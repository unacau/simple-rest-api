package cz.buyorborrow.rest.service.user;

import cz.buyorborrow.rest.dto.user.UserDto;
import cz.buyorborrow.rest.model.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by ekishigo on 9.4.16.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        return new CurrentUser(user);
    }
}
