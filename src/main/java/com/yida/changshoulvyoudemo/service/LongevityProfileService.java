package com.yida.changshoulvyoudemo.service;

import com.yida.changshoulvyoudemo.entity.LongevityProfile;

import java.util.List;

public interface LongevityProfileService {
    public void update(LongevityProfile L);//改
    public List<LongevityProfile> readAll();//查所有
}
