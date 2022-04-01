package com.example.exam.service;

import com.example.exam.mapper.RoleMapper;
import com.example.exam.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleMapper roleMapper;

    public void insert(Role role) {
        roleMapper.insert(role);
    }

    public Role getById(Long id) {
        return roleMapper.findById(id);
    }

    public List<Role> getAll( ) {
        return roleMapper.findAll();
    }

    public void update(Long id, Role newRole) {
        Role oldRole = roleMapper.findById(id);
        if(newRole.getName()!=null)
            oldRole.setName(newRole.getName());
        roleMapper.update(oldRole);
    }

}
