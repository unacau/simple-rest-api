package cz.buyorborrow.rest.controller;

import cz.buyorborrow.rest.dto.user.CreateForm;
import cz.buyorborrow.rest.dto.user.CreateFormValidator;
import cz.buyorborrow.rest.dto.user.UserDto;
import cz.buyorborrow.rest.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

/**
 * Created by ekishigo on 9.4.16.
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private CreateFormValidator createFormValidator;

    @Autowired
    public UserController(UserService userService, CreateFormValidator createFormValidator) {
        this.userService = userService;
        this.createFormValidator = createFormValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(createFormValidator);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    UserDto create(@RequestBody @Valid CreateForm createForm, BindingResult bindingResult) {
        List<ObjectError> errors = bindingResult.getGlobalErrors();
        for (ObjectError error : errors) {
            switch (error.getCode()) {
                case "password.no_match":
                    LOGGER.debug(error.getDefaultMessage());
                    throw new ValidationException(error.getDefaultMessage());
                case "username.exists":
                    LOGGER.debug(error.getDefaultMessage());
                    throw new DataIntegrityViolationException(error.getDefaultMessage());
            }
        }
        return userService.create(createForm);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    UserDto getUser(@PathVariable String id) {
        return userService.getByUsername(id);
    }

}
