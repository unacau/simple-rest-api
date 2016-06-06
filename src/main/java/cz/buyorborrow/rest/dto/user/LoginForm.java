package cz.buyorborrow.rest.dto.user;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ekishigo on 12.4.16.
 */
public class LoginForm {
    @NotEmpty
    @NotNull
    @Size(max = 25)
    private String username;
    @NotEmpty
    @NotNull
    @Size(max = 25)
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
