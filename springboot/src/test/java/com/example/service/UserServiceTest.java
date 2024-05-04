package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class UserServiceTest {
    @Test
    public void deleteById() {
        User user = new User();
        System.out.println(user.toString());
    }
}