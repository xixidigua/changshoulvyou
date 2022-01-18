package com.yida.changshoulvyoudemo.service;

import com.yida.changshoulvyoudemo.entity.TrafficRoute;

import java.util.List;

public interface TrafficRouteService {
    public void update(TrafficRoute t);//改
    public List<TrafficRoute> readAll();//查所有
}
