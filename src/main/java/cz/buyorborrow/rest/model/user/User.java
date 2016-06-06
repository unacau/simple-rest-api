package cz.buyorborrow.rest.model.user;

import org.springframework.data.annotation.Id;

import java.util.List;

import static cz.buyorborrow.rest.utils.PreCondition.isTrue;
import static cz.buyorborrow.rest.utils.PreCondition.notEmpty;

/**
 * Created by ekishigo on 30.3.16.
 */
public class User {

    public static final int MAX_USERNAME_LENGTH = 25;

    @Id
    private String username;
    private String passwordHash;
    private Profile profile;
    private List<String> transactionsIds;
    private List<String> myItemsIds;
    private UserRole role;

    public User() {
    }

    private User(UserBuilder builder) {
        this.username = builder.username;
        this.passwordHash = builder.passwordHash;
        this.profile = builder.profile;
        this.transactionsIds = builder.transactions;
        this.myItemsIds = builder.myItems;
        this.role = builder.role;
    }

    public boolean hasItem(String itemId) {
        return myItemsIds.contains(itemId);
    }

    public boolean hasTransaction(String transactionId) {
        return transactionsIds.contains(transactionId);
    }

    public boolean isContentEmpty() {
        return myItemsIds.isEmpty();
    }

    public boolean isTransactionListEmpty() {
        return transactionsIds.isEmpty();
    }

    public void removeItem(String i) {
        if (this.hasItem(i)) {
            this.myItemsIds.remove(i);
        }
    }

    public void removeTransaction(String t) {
        if (this.hasTransaction(t)) {
            this.transactionsIds.remove(t);
        }
    }

    public void putItem(String i) {
        this.myItemsIds.add(i);
    }

    public void putTransaction(String t) {
        this.transactionsIds.add(t);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        checkUsername(username);
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        checkPass(passwordHash);
        this.passwordHash = passwordHash;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<String> getTransactionsIds() {
        return transactionsIds;
    }

    public void setTransactionsIds(List<String> transactionsIds) {
        this.transactionsIds = transactionsIds;
    }

    public List<String> getMyItemsIds() {
        return myItemsIds;
    }

    public void setMyItemsIds(List<String> myItemsIds) {
        this.myItemsIds = myItemsIds;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        //return String.format("User username is %s", username);
        return username;
    }

    private void checkUsername(String username) {
        if (username != null) {
            notEmpty(username, "username can't be empty");
            isTrue(username.length() <= MAX_USERNAME_LENGTH,
                    "Username should not be longer than %d chars",
                    MAX_USERNAME_LENGTH);
        }
    }

    private void checkPass(String pass) {
        if (pass != null) {
            notEmpty(pass, "Password can't be empty");
        }
    }

    public static UserBuilder getUserBuilder(String username, String passwordHash) {
        return new UserBuilder(username, passwordHash);
    }
    /**
     * Builder class for User class.
     * Required attributes are username and password. Others are optional.
     */
    public static class UserBuilder {
        private String username;
        private String passwordHash;

        private Profile profile;
        private List<String> transactions;
        private List<String> myItems;
        private UserRole role;

        public UserBuilder(String username, String passwordHash) {
            this.username = username;
            this.passwordHash = passwordHash;
        }

        public UserBuilder withProfile(Profile profile) {
            this.profile = profile;
            return this;
        }

        public UserBuilder withTransactions(List<String> transactions) {
            this.transactions = transactions;
            return this;
        }

        public UserBuilder withItems(List<String> items) {
            this.myItems = items;
            return this;
        }

        public UserBuilder withRole(UserRole role) {
            this.role = role;
            return this;
        }

        public User build() {
            User build = new User(this);
            build.checkUsername(build.getUsername());
            build.checkPass(build.getPasswordHash());
            return build;
        }
    }
}
