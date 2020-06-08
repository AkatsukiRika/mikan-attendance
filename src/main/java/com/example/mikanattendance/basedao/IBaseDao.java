package com.example.mikanattendance.basedao;

import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 公用Mapper接口
 * @author rika
 * @param <T>
 */
public interface IBaseDao<T> extends Mapper<T>, MySqlMapper<T> {
}
