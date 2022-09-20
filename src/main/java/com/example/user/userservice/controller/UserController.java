package com.example.user.userservice.controller;

import com.example.user.userservice.VO.ResponseTemplateVO;
import com.example.user.userservice.entity.User;
import com.example.user.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController

{
   @Autowired
   private UserService userService;

   @PostMapping("/")
   public User saveUser(@RequestBody User user)
   {
      log.info("Inside saveUser of UserController");
       return userService.saveUser(user);
   }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId)
    {
        System.out.println("Hello");
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
