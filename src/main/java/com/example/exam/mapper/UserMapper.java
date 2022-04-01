package com.example.exam.mapper;

import com.example.exam.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users where id=#{id}")
    public User findById(Long id);

    @Select("select * from users where name=#{name}")
    public User findByUserName(String name);

    @Select("select * from users")
    public List<User> findAll();

    @Delete("delete from users where id=#{id}")
    public void deleteById(Long id);

    @Delete("delete from users")
    public void deleteAll();

    @Insert("insert into  users (name, password, active, role_id) " +
            "values(#{name}, #{password}, #{active}, #{role.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void insert(User user);

    @Update("update users set name=#{name}, password=#{password}, active=#{active}, role_id=#{role.id}," +
            "where id=#{id}")
    public void update(User user);

}

