package com.example.exam.mapper;

import com.example.exam.model.GoodGroup;
import com.example.exam.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from roles where id=#{id}")
    public Role findById(Long id);

    @Select("select * from roles")
    public List<Role> findAll();

    @Delete("delete from roles where id=#{id}")
    public void deleteById(Long id);

    @Delete("delete from roles")
    public void deleteAll();

    @Select("select * from roles " +
            " right join users on users.role_id=roles.id" +
            " where users.id=#{id}")
    public Role findByIdOfUser(Long id);

    @Select("select * from roles " +
            " where roles.name=#{name}")
    public Role findByName(String name);

    @Insert("insert into  roles (name)" +
            " values(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void insert(Role role);

    @Update("update roles set name=#{name}" +
            " where id=#{id}")
    public void update(Role role);


}
