//package cz.buyorborrow.rest.controller;
//
//import cz.buyorborrow.rest.dto.user.CreateFormValidator;
//import cz.buyorborrow.rest.dto.user.LoginForm;
//import cz.buyorborrow.rest.model.user.CurrentUser;
//import cz.buyorborrow.rest.service.user.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
///**
// * Created by ekishigo on 12.4.16.
// */
//@RestController
//public class LoginController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
//    private UserService userService;
//    private UserDetailsService userDetailsService;
//    private CreateFormValidator createFormValidator;
//
//
//    @Autowired
//    public LoginController(UserService userService, UserDetailsService userDetailsService, CreateFormValidator createFormValidator) {
//        this.userService = userService;
//        this.userDetailsService = userDetailsService;
//        this.createFormValidator = createFormValidator;
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/login")
//    String login(@RequestBody @Valid LoginForm loginForm) {
//        UserDetails currentUser = userDetailsService.loadUserByUsername(loginForm.getUsername());
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (currentUser.getPassword() == encoder.encode(loginForm.getPassword())) {
//            return "redirect:/user/" + ;
//        } else {
//            return "Username or password is not correct";
//        }
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    LoginForm login() {
//        return new LoginForm("Enter your username", "Enter password");
//    }
//}
