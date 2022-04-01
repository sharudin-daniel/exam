package com.example.exam.mapper;

import com.example.exam.model.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("select * from test where id=#{id}")
    public Test findById(Long id);

    @Select("select * from test")
    public List<Test> findAll();

    @Delete("delete from test where id=#{id}")
    public void deleteById(Long id);

    @Delete("delete from test")
    public void deleteAll();

    @Insert("insert into  test (name, description)" +
            "values(#{name}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void insert(Test test);

    @Update("update test set name=#{name}, description=#{description}" +
            "where id=#{id}")
    public void update(Test test);

}
