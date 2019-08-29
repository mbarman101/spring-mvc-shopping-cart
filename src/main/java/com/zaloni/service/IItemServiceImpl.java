package com.zaloni.service;

import com.zaloni.dao.IItemDao;
import com.zaloni.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IItemServiceImpl implements IItemService {

    @Autowired
    private IItemDao itemDao;

    @Override
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    @Override
    public Item getItem(int id) {
        return itemDao.getItem(id);
    }

    @Override
    public Item updateItem(Item item) {
        return itemDao.updateItem(item);
    }

    @Override
    public void deleteItem(int id) {
      itemDao.deleteItem(id);
    }

}
