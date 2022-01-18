package com.yida.changshoulvyoudemo.service;

import com.yida.changshoulvyoudemo.entity.Classify;

import java.util.List;

/**
 * Service层，部门服务接口
 */
public interface ClassifyService {
     public List<Classify> readAll();
     //带条件的增删改查
}
