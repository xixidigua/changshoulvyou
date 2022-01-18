package com.yida.changshoulvyoudemo.mapper;

import com.yida.changshoulvyoudemo.entity.ReadState;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

public interface ReadStateMapper extends Mapper<ReadState> {
    public ReadState read(@RequestParam("id") Integer id);
}
