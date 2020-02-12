package com.natgas.courses.restfulwebservices.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class UserResource {

    private final UserDaoService userDao;

    public UserResource(final UserDaoService userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/users")
    public List<User> getAll() {
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable final int id) {
        User user = userDao.findById(id);
        if (user == null) {
            throw new UserNotFoundException(""+id);
        }
        return user;
    }

    @PostMapping(value="/users")
    public ResponseEntity<User> create(@RequestBody final User entity) {
        final User user = userDao.save(entity);

        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    
    
}