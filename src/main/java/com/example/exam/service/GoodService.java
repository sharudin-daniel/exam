package com.example.exam.service;

import com.example.exam.mapper.GoodGroupMapper;
import com.example.exam.mapper.GoodMapper;
import com.example.exam.model.Good;
import com.example.exam.model.GoodGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodService {

    private final GoodMapper goodMapper;
    private final GoodGroupMapper goodGroupMapper;


    public void insert(Good good) {
        //Check (by name) if good.good_group is present in TABLE good_group
        GoodGroup newGoodGroup = good.getGoodGroup();
        GoodGroup oldGoodGroup = goodGroupMapper.findByNameAndPriority(newGoodGroup.getName(), newGoodGroup.getPriority());
        if(oldGoodGroup==null)
            goodGroupMapper.insert(newGoodGroup);
        else
            good.setGoodGroup(oldGoodGroup);
        goodMapper.insert(good);
    }

    public void desableById(Long id) {

        goodMapper.desableById(id);
    }

    public void desableAll() {

        goodMapper.desableAll();
    }

    public Good getById(Long id) {
        Good good = goodMapper.findById(id);
        good.setGoodGroup(goodGroupMapper.findByIdOfGood(id));
        return good;
    }

    public List<Good> getAll( ) {
        List<Good> goods = goodMapper.findAll();
        goods.forEach(good -> {
            good.setGoodGroup(goodGroupMapper.findByIdOfGood(good.getId()));
        });
        return goods;
    }

    public void update(Long id, Good newGood) {
        Good oldGood = goodMapper.findById(id);
        if(newGood.getName()!=null)
            oldGood.setName(newGood.getName());
        if(newGood.getEnabled()!=null)
            oldGood.setEnabled(newGood.getEnabled());
        if(newGood.getPrice()!=null)
            oldGood.setPrice(newGood.getPrice());
        if(newGood.getAmount()!=null)
            oldGood.setAmount(newGood.getAmount());
        if(newGood.getGoodGroup()!=null){
            oldGood.setGoodGroup(newGood.getGoodGroup());
            goodGroupMapper.insert(newGood.getGoodGroup());
        }
        goodMapper.update(oldGood);
    }

    public void add(Long id, Long amount) {
        Good good = goodMapper.findById(id);
        good.setAmount(good.getAmount()+amount);
        goodMapper.update(good);
    }
}
