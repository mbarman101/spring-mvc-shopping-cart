package com.zaloni.dao;

import com.zaloni.entity.Item;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao implements IItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addItem(Item item) {
      sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    @Override
    public List<Item> getAllItems(){

        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Item.class);
        List<Item> results = cr.list();
        return results;
    }

    @Override
    public Item getItem(int id) {
        return (Item) sessionFactory.getCurrentSession().get(Item.class,id);
    }

    @Override
    public Item updateItem(Item item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    @Override
    public void deleteItem(int id) {
        Item item = (Item) sessionFactory.getCurrentSession().load(Item.class,id);
        if(item != null){
            sessionFactory.getCurrentSession().delete(item);
        }
    }


}

