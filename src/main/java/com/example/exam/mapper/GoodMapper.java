package com.example.exam.mapper;

import com.example.exam.model.Good;
import com.example.exam.model.GoodGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodMapper {

    @Select("select * from goods where id=#{id}")
    public Good findById(Long id);

    @Select("select * from goods" +
            " where enabled=true")
    public List<Good> findAll();

    @Select("select * from goods" +
            " left join sales on sales.id_of_good=goods.id" +
            " where sales.id=#{id}")
    public Good findByIdOfSales(Long id);

    @Update("update goods set enabled=false" +
            " where id=#{id}")
    public void desableById(Long id);

    @Update("update goods set enabled=false")
    public void desableAll();

    @Insert("insert into  goods (name, price, enabled, amount, good_group_id)" +
            " values(#{name}, #{price}, #{enabled}, #{amount}, #{goodGroup.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void insert(Good good);

    @Update("update goods set name=#{name}, price=#{price}, enabled=#{enabled}," +
            " amount=#{amount}, good_group_id=#{goodGroup.id}" +
            " where id=#{id}")
    public void update(Good good);

    @Update("update goods set amount=#{amount}" +
            " where id=#{id}")
    public void updateAmount(Good good);

}
