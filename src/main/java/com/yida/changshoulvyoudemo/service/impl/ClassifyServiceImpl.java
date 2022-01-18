package com.yida.changshoulvyoudemo.service.impl;

import com.yida.changshoulvyoudemo.entity.Classify;
import com.yida.changshoulvyoudemo.mapper.ClassifyMapper;
import com.yida.changshoulvyoudemo.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired(required = false)
    private ClassifyMapper classifyMapper;

    @Override
    public List<Classify> readAll() {
        List<Classify> classifies = classifyMapper.selectAll();
        return classifies;
    }

}