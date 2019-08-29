package com.zaloni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class adminController {

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("t1") int i, @RequestParam("t2") int j) {
        int k = i+ j ; //Integer.parseInt(request.getParameter("t1")) + Integer.parseInt(request.getParameter("t2"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result.jsp");
        mv.addObject("result", k);
        return mv;
    }

}
