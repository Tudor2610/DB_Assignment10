package com.unittesting.db_assignment10.test;

import com.unittesting.db_assignment10.model.User;
import com.unittesting.db_assignment10.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void whenCreateUser_ThenUserTableSizeMustBeOne(){
        User user = new User();
        userService.createUser(user);
        Assertions.assertEquals(1, userService.getAll().size());
    }
}
