package com.example.exam.mapper;

import com.example.exam.model.Sales;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SalesMapper {

    @Select("select * from sales where id=#{id}")
    @Results(value={
            @Result(column="id", property="id", id=true),
            @Result(column="amount_sold", property="amountSold"),
            @Result(column="price_for_one", property="priceForOne"),
            @Result(column="total_sum", property="totalSum"),
            @Result(column="sale_date", property="saleDate")
    })
    public Sales findById(Long id);

    @Select("select * from sales")
    @Results(value={
            @Result(column="id", property="id", id=true),
            @Result(column="amount_sold", property="amountSold"),
            @Result(column="price_for_one", property="priceForOne"),
            @Result(column="total_sum", property="totalSum"),
            @Result(column="sale_date", property="saleDate")
    })
    public List<Sales> findAll();

    @Insert("insert into  sales (amount_sold, price_for_one, total_sum, sale_date, id_of_good)" +
            " values(#{amountSold}, #{priceForOne}, #{totalSum}, #{saleDate}, #{good.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void insert(Sales Sales);

    @Update("update sales set amount_old=#{amountSold}, price_for_one=#{priceForOne}, total_sum=#{totalSum}," +
            " sale_date=#{saleDate}, id_of_good=#{good.id}" +
            " where id=#{id}")
    public void update(Sales Sales);
}
