package com.wh.mas.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface MasMapper<T> extends BaseMapper<T> {

    default List<T> list(){
        return selectList(null);
    }

    default List<T> list(Wrapper<T> wrapper){
        return selectList(wrapper);
    }
}
