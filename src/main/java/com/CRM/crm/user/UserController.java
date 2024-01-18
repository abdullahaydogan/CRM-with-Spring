package com.CRM.crm.user;

import com.CRM.crm.auth.token.TokenService;
import com.CRM.crm.shared.GenericMessage;
import com.CRM.crm.user.dto.UserCreate;
import com.CRM.crm.user.dto.UserDTO;
import com.CRM.crm.user.dto.UserUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/api/v1/users")
    GenericMessage createUser(@Valid @RequestBody UserCreate user) {

        userService.userSave(user.toUser());
        return new GenericMessage("User is Created");
    }

    @PatchMapping("/api/v1/users/{token}/active")
    GenericMessage activateUser(@PathVariable String token) {
        userService.activeUser(token);
        return new GenericMessage("User Activated");
    }

    @GetMapping("api/v1/users")
    Page<UserDTO> getUsers(Pageable page, @RequestHeader(name = "Authorization", required = false) String authorizationHeader) {
        var loggedInUser = tokenService.verifyToken(authorizationHeader);
        return userService.getUsers(page, loggedInUser).map(UserDTO::new);
    }

    @PutMapping("api/v1/users/updateUser/{id}")
    UserDTO updateUser(@PathVariable Long id, @RequestBody UserUpdate userUpdate) {
        return new UserDTO(userService.userUpdate(id, userUpdate));
    }


}

