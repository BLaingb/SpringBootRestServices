package com.natgas.courses.restfulwebservices.user;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class UserResource {

    private UserDaoService userDao;

    public UserResource(UserDaoService userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value="/users")
    public List<User> getAll() {
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable int id) {
        return userDao.findById(id);
    }
    
    @PostMapping(value="/users")
    public User create(@RequestBody User entity) {
        User user = userDao.save(entity);
        return user;
    }
    
    
}