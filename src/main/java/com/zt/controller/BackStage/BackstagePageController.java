package com.zt.controller.BackStage;


import com.zt.dao.inner.StuDaoI;
import com.zt.entity.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(value = "/")
@Controller
public class BackstagePageController {

    @Autowired
    private StuDaoI stuDaoI;

    @RequestMapping(value = "backLogin.html")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "index.html")
    public ModelAndView Index(){

        ModelAndView modelAndView=new ModelAndView("backStage");
        List<Stu> list=stuDaoI.getAllAdmin();
        modelAndView.addObject("list",list);
        return modelAndView;
    }


}
