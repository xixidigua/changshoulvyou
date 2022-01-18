package com.yida.changshoulvyoudemo.service;

import com.yida.changshoulvyoudemo.entity.Client;

import java.util.List;

/**
 * Service层，部门服务接口
 */
public interface ClientService {
     public List<Client> readAll();
     //带条件的增删改查
}
