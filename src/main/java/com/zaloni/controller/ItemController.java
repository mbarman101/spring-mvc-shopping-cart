package com.zaloni.controller;

import com.zaloni.entity.Item;
import com.zaloni.service.HelperService;
import com.zaloni.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ItemController {

    @Autowired
    IItemService itemService;

    @Autowired
    HelperService helperService;

    @RequestMapping(value = "/newItem",method = RequestMethod.GET)
    public ModelAndView newItem(ModelAndView model) {
        Item item = new Item();
        model.addObject("item",item);
        model.setViewName("itemForm");
        return model;
    }

    @RequestMapping(value = "/saveItem",method = RequestMethod.POST)
    public ModelAndView saveItem(@ModelAttribute Item item){
        ModelAndView model = new ModelAndView();
        if(item.getId() == 0){
           itemService.addItem(item);
           System.out.println("Item addition completed");
        }
        else{
            itemService.updateItem(item);
            System.out.println("Item update successfully");
        }

        List<Item> listItems = helperService.getItems();
        model.addObject("listItems",listItems);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/editItem",method = RequestMethod.GET)
    public ModelAndView editItem(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("itemForm");
        /**
         * Another way of getting the request parameters
         */
        int id = Integer.parseInt(request.getParameter("id"));
        Item item = itemService.getItem(id);
        model.addObject("item",item);
        return model;
    }

    @RequestMapping(value="/deleteItem", method = RequestMethod.GET)
    public ModelAndView deleteItem(@RequestParam("id") String id){
      int itemId = Integer.parseInt(id);
      itemService.deleteItem(itemId);
      ModelAndView model = new ModelAndView();
        List<Item> listItems = helperService.getItems();
        model.addObject("listItems",listItems);
        model.setViewName("home");
        return model;
    }
}
