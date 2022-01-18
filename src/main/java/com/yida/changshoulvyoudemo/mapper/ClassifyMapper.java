package com.yida.changshoulvyoudemo.mapper;

import com.yida.changshoulvyoudemo.entity.Classify;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

public interface ClassifyMapper extends Mapper<Classify> {
    public Classify read(@RequestParam("id") Integer id);
}
