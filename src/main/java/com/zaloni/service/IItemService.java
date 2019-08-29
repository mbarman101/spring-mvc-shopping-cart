package com.zaloni.service;


import com.zaloni.entity.Item;

import java.util.List;

public interface IItemService {
   void addItem(Item item);
    List<Item> getAllItems();
    Item getItem(int id);
    Item updateItem(Item item);
    void deleteItem(int id);
}
