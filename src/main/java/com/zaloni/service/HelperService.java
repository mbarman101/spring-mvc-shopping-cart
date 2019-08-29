package com.zaloni.service;

import com.zaloni.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelperService {

    @Autowired
    IItemService itemService;

    public List<Item> getItems(){
        return itemService.getAllItems();
    }
}
