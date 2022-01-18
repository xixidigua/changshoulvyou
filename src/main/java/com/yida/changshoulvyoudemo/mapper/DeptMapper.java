package com.yida.changshoulvyoudemo.mapper;

import com.yida.changshoulvyoudemo.entity.Dept;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

public interface DeptMapper extends Mapper<Dept> {
    public Dept read(@RequestParam("id") Integer id);
}
