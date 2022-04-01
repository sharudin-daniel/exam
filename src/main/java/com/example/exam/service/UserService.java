package com.example.exam.service;

import com.example.exam.mapper.RoleMapper;
import com.example.exam.mapper.UserMapper;
import com.example.exam.model.Good;
import com.example.exam.model.Role;
import com.example.exam.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    public void insert(User user) {
        Role newRole = user.getRole();
        Role oldRole = roleMapper.findByName(newRole.getName());
        if(oldRole==null)
            roleMapper.insert(newRole);
        else
            user.setRole(oldRole);
        userMapper.insert(user);
    }

    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }

    public void deleteAll() {
        userMapper.deleteAll();
    }

    public User getById(Long id) {
        User user = userMapper.findById(id);
        user.setRole(roleMapper.findByIdOfUser(id));
        return user;
    }

    public List<User> getAll( ) {
        List<User> users= userMapper.findAll();
        users.forEach(user -> {
            user.setRole(roleMapper.findByIdOfUser(user.getId()));
        });
        return users;
    }

    public void update(Long id, User newUser) {
        User oldUser = userMapper.findById(id);
        oldUser.setName(newUser.getName());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setActive(newUser.isActive());
        oldUser.setRole(newUser.getRole());
        userMapper.update(oldUser);
    }

}
