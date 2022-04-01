package com.example.exam.mapper;

import com.example.exam.model.Role;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Mapper
public interface MyLogMapper {

    @Insert("insert into  logs (date, message)" +
            " values(#{date}, #{message})")
    public void insert(String message, LocalDate date);


}
