package cz.buyorborrow.rest.dto.user;

import cz.buyorborrow.rest.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by ekishigo on 9.4.16.
 */
@Component
public class CreateFormValidator implements Validator {
    private UserService userService;

    @Autowired
    public CreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(CreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateForm form = (CreateForm) target;
        validateUsername(errors, form);
        validatePasswords(errors, form);
    }

    private void validatePasswords(Errors errors, CreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateUsername(Errors errors, CreateForm form) {
        if (userService.getByUsername(form.getUsername()) != null) {
            errors.reject("username.exists", "User with this username already exists");
        }
    }
}
