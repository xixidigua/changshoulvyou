package com.yida.changshoulvyoudemo.service;

import com.yida.changshoulvyoudemo.entity.VersionManage;

import java.util.List;

public interface VersionManageService {
    public void update(VersionManage v);//改
    public List<VersionManage> readAll();//查所有
}
