package com.yida.changshoulvyoudemo.service.impl;

import com.yida.changshoulvyoudemo.entity.ConsumptionClassify;
import com.yida.changshoulvyoudemo.mapper.ConsumptionClassifyMapper;
import com.yida.changshoulvyoudemo.service.ConsumptionClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("consumptionClassifyService")
public class ConsumptionClassifyServiceImpl implements ConsumptionClassifyService {
    @Autowired(required = false)
    private ConsumptionClassifyMapper  consumptionClassifyMapper;

    @Override
    public List<ConsumptionClassify> readAll() {
        List<ConsumptionClassify> consumptionClassifies = consumptionClassifyMapper.selectAll();
        return consumptionClassifies;
    }

}