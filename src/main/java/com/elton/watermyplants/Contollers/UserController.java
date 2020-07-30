package com.elton.watermyplants.Contollers;


import com.elton.watermyplants.Models.User;
import com.elton.watermyplants.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

   // GET http://localhost:2019/users/users

    // working but not with Oauth2
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<?> listAllUsers()
    {
        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }

    // GET http://localhost:2019/users/user/1
    //working
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping(value = "/user/{userId}",
            produces = {"application/json"})
    public ResponseEntity<?> getUserById(
            @PathVariable
                    Long userId)
    {
        User u = userService.findUserById(userId);
        return new ResponseEntity<>(u,
                HttpStatus.OK);
    }
   //  POST http://localhost:2019/users/user
    // working
    @PostMapping(value = "/user", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> addUser(@Valid @RequestBody User newuser)
    {
        newuser.setUserid(0);
        newuser = userService.save(newuser);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newuser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }

   // DELETE http://localhost:2019/users/user/1
    //working (but double check) hah

   @PreAuthorize("hasAnyRole('ADMIN')")
   @DeleteMapping(value = "/user/{userId}")
   public ResponseEntity<?> deleteUserById(
           @PathVariable
                   Long userId)
   {
       userService.delete(userId);
       return new ResponseEntity<>(HttpStatus.OK);
   }

   // working!
    @PreAuthorize("hasAnyRole('USER')")
    @PutMapping(value = "/user/{userid}",
            produces = {"application/json"},consumes = "application/json")
    public ResponseEntity<?> updateFullUser(
            @Valid
            @RequestBody
                    User updateUser,
            @PathVariable
                    long userid)
    {
        updateUser.setUserid(userid);
        userService.save(updateUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // working!!! Jeuse CHRIST
    //    http://localhost:2019/users/myinfo
    @GetMapping(value = "/myinfo", produces = {"application/json"})
    public ResponseEntity<?> myInfo(Authentication authentication)
    {
        User u = userService.findByName(authentication.getName());
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    // put for updating plant





}
