package com.example.exam.service;

import com.example.exam.mapper.TestMapper;
import com.example.exam.model.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestMapper testMapper;

    public void insert(Test test) {
        testMapper.insert(test);
    }

    public void deleteById(Long id) {
        testMapper.deleteById(id);
    }

    public void deleteAll() {
        testMapper.deleteAll();
    }

    public Test getById(Long id) {
        return testMapper.findById(id);
    }

    public List<Test> getAll( ) {
        return testMapper.findAll();
    }

    public void update(Long id, Test newTest) {
        Test oldTest = testMapper.findById(id);
        oldTest.setName(newTest.getName());
        oldTest.setDescription(newTest.getDescription());
        testMapper.update(oldTest);
    }

}
