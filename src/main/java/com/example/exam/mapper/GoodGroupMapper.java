package com.example.exam.mapper;

import com.example.exam.model.GoodGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodGroupMapper {

    @Select("select * from good_group where id=#{id}")
    public GoodGroup findById(Long id);

    @Select("select * from good_group")
    public List<GoodGroup> findAll();

    @Select("select * from good_group " +
            " right join goods on goods.good_group_id=good_group.id" +
            " where goods.id=#{id}")
    public GoodGroup findByIdOfGood(Long id);

    @Select("select * from good_group " +
            " where good_group.name=#{name} and good_group.priority=#{priority}")
    public GoodGroup findByNameAndPriority(String name, Long priority);

    @Insert("insert into  good_group (name, priority)" +
            " values(#{name}, #{priority})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void insert(GoodGroup goodGroup);

    @Update("update good_group set name=#{name}, priority=#{priority}" +
            " where id=#{id}")
    public void update(GoodGroup goodGroup);


}
