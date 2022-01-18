package com.yida.changshoulvyoudemo.service.impl;

import com.yida.changshoulvyoudemo.entity.Client;
import com.yida.changshoulvyoudemo.mapper.ClientMapper;
import com.yida.changshoulvyoudemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
    @Autowired(required = false)
    private ClientMapper clientMapper;

    @Override
    public List<Client> readAll() {
        List<Client> clients = clientMapper.selectAll();
        return clients;
    }

}