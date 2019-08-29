package com.zaloni.controller;

import com.zaloni.entity.Item;
import com.zaloni.entity.User;
import com.zaloni.service.HelperService;
import com.zaloni.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {
    public LoginController() {
        System.out.println("IN LOGIN CONTROLLER");
    }

    @Autowired
    private ILoginService logInService;

    @Autowired
    private HelperService helperService;

    @RequestMapping(value = "/")
    public ModelAndView login(ModelAndView model) throws IOException {
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView signMeIn(@RequestParam("uid") String uid, @RequestParam("user") String user, @RequestParam("passWord") String passsWord) throws IOException {

        ModelAndView model = new ModelAndView();
        User userVO = logInService.logMeIn(Integer.parseInt(uid));
        System.out.println(userVO.toString());
        if( user.equals(userVO.getName()) &&  passsWord.equals(userVO.getPassword())){
            List<Item> listItems = helperService.getItems();
            for (Item item : listItems) {
                System.out.println(item);
            }
            model.addObject("listItems",listItems);
            model.setViewName("home");
            return model;
        }
        else{
            model.setViewName("error");
            return model;
        }
        //return model;
    }
}
