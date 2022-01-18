package com.yida.changshoulvyoudemo.service.impl;

import com.yida.changshoulvyoudemo.entity.TrafficRoute;
import com.yida.changshoulvyoudemo.mapper.TrafficRouteMapper;
import com.yida.changshoulvyoudemo.service.TrafficRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *Service层，景点列表接口服务实现
 */
@Service("trafficRouteService")
public class TrafficRouteServiceImpl implements TrafficRouteService {
      @Autowired(required = false)
    private TrafficRouteMapper trafficRouteMapper;

    @Override
    public void update(TrafficRoute t) {
     trafficRouteMapper.update(t);
    }

    @Override
    public List<TrafficRoute> readAll() {
        return trafficRouteMapper.readAll();
    }
}
