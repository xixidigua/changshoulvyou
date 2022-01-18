package com.yida.changshoulvyoudemo.mapper;

import com.yida.changshoulvyoudemo.entity.Scenic;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

public interface ScenicMapper extends Mapper<Scenic> {
      public Scenic read(@RequestParam("id") Integer id);
}
