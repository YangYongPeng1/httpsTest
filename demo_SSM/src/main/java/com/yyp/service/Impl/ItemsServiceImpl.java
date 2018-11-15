package com.yyp.service.Impl;

import com.yyp.dao.ItemsDao;
import com.yyp.domain.Items;
import com.yyp.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @version V 1.0
 * @date 2018-11-07
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;

    @Override
    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }
}
