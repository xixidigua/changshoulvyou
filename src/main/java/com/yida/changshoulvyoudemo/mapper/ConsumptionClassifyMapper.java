package com.yida.changshoulvyoudemo.mapper;

import com.yida.changshoulvyoudemo.entity.ConsumptionClassify;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

public interface ConsumptionClassifyMapper extends Mapper<ConsumptionClassify> {
    public ConsumptionClassify read(@RequestParam("id") Integer id);
}
