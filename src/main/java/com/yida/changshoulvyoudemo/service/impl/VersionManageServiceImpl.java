package com.yida.changshoulvyoudemo.service.impl;

import com.yida.changshoulvyoudemo.entity.VersionManage;
import com.yida.changshoulvyoudemo.mapper.VersionManageMapper;
import com.yida.changshoulvyoudemo.service.VersionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *Service层，景点列表接口服务实现
 */
@Service("versionManageService")
public class VersionManageServiceImpl implements VersionManageService {
      @Autowired(required = false)
    private VersionManageMapper  versionManageMapper;

    @Override
    public void update(VersionManage v) {
        versionManageMapper.update(v);
    }

    @Override
    public List<VersionManage> readAll() {
        return versionManageMapper.readAll();
    }
}
