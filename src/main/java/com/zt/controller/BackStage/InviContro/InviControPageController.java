package com.zt.controller.BackStage.InviContro;

import com.zt.dao.inner.InviTationDaoI;
import com.zt.entity.InviTation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(value = "/")
@Controller
public class InviControPageController {

    @Autowired
    private InviTationDaoI inviTationDaoI;

    @RequestMapping(value = "inviContro.html")
    public ModelAndView inviContro(){
        ModelAndView modelAndView=new ModelAndView("inviContro");
        List<InviTation> list=inviTationDaoI.getAllInvi();
        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
