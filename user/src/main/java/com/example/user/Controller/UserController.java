package com.example.user.Controller;


import com.example.user.Model.UserModel;
import com.example.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody UserModel userModel) {
        userService.createUser(userModel);
        return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody UserModel userModel){
        userService.updateUser(id, userModel);
        return new ResponseEntity<>("Update", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Delete",HttpStatus.OK);
    }

    @RequestMapping(value = "/users")
    public ResponseEntity<Object> allUser(){
        return new ResponseEntity<>(userService.getUserModels(), HttpStatus.OK);
    }
}
