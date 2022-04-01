package com.example.exam.service;

import com.example.exam.mapper.RoleMapper;
import com.example.exam.mapper.UserMapper;
import com.example.exam.model.MyUserDetails;
import com.example.exam.model.Role;
import com.example.exam.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDatailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = Optional.ofNullable(userMapper.findByUserName(username));
        if(!userOpt.isPresent())
            throw new UsernameNotFoundException("Not found:" + username);

        User user = userOpt.get();
        System.out.println(user.toString());

        Role role = roleMapper.findByIdOfUser(user.getId());
        user.setRole(role);
        System.out.println(user.toString());
        return new MyUserDetails(user);
    }
}
 