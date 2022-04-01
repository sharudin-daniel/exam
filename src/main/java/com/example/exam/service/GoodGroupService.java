package com.example.exam.service;

import com.example.exam.mapper.GoodGroupMapper;
import com.example.exam.model.GoodGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodGroupService {

    private final GoodGroupMapper goodGroupMapper;

    public void insert(GoodGroup goodGroup) {
        goodGroupMapper.insert(goodGroup);
    }

    public GoodGroup getById(Long id) {
        return goodGroupMapper.findById(id);
    }

    public List<GoodGroup> getAll( ) {
        return goodGroupMapper.findAll();
    }

    public void update(Long id, GoodGroup newGoodGroup) {
        GoodGroup oldGoodGroup = goodGroupMapper.findById(id);
        if(newGoodGroup.getName()!=null)
            oldGoodGroup.setName(newGoodGroup.getName());
        if(newGoodGroup.getPriority()!=null)
            oldGoodGroup.setPriority(newGoodGroup.getPriority());
        goodGroupMapper.update(oldGoodGroup);
    }

}
