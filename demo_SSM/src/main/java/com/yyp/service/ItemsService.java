package com.yyp.service;

import com.yyp.domain.Items;

/**
 * @author Yang
 * @version V 1.0
 * @date 2018-11-07
 */
public interface ItemsService {
    // 根据id查询
    Items findById(Integer id);
}
