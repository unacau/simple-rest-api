package cz.buyorborrow.rest.model.user;

import cz.buyorborrow.rest.dto.user.UserDto;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by ekishigo on 9.4.16.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private UserDto user;

    public CurrentUser(UserDto user) {
        super(user.getUsername(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public UserDto getUser() {
        return user;
    }

    public String getId() {
        return user.getUsername();
    }

    public UserRole getRole() {
        return user.getRole();
    }
}
