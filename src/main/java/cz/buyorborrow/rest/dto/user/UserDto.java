package cz.buyorborrow.rest.dto.user;

import cz.buyorborrow.rest.model.user.Profile;
import cz.buyorborrow.rest.model.user.UserRole;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ekishigo on 9.4.16.
 */
public class UserDto {

    @NotEmpty
    private String username;
    @NotEmpty
    private String passwordHash;

    private Profile profile;
    private List<String> transactionsIds;
    private List<String> myItemsIds;
    @NotNull
    private UserRole role;

    public UserDto() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
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
        return "UserDto{" +
                "username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", profile=" + profile +
                ", transactionsIds=" + transactionsIds +
                ", myItemsIds=" + myItemsIds +
                ", role=" + role +
                '}';
    }
}
