package com.example.user.userservice.service;

import com.example.user.userservice.VO.Department;
import com.example.user.userservice.VO.ResponseTemplateVO;
import com.example.user.userservice.entity.User;
import com.example.user.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user)
    {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId)
    {
        log.info("Inside getUserWithDepartment of UserService");
       ResponseTemplateVO vo =new ResponseTemplateVO();
       User user = userRepository.findByUserId(userId);
      System.out.println("Hi");
        Department department =
                restTemplate.getForObject("http://localhost:8080/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
}}
