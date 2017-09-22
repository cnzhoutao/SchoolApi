package com.zt.controller.BackStage.UserContro;

import com.zt.dao.inner.StuDaoI;
import com.zt.entity.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(value = "/")
@Controller
public class UserPageController {

    @Autowired
    private StuDaoI stuDaoI;

    /**
     * 用户管理
     * @return
     */
    @RequestMapping(value = "userContro.html")
    public ModelAndView UserController() {

        ModelAndView modelAndView=new ModelAndView("userContro");
        List<Stu> list=stuDaoI.getAllCommonUser();
        modelAndView.addObject("list",list);
        return modelAndView;
    }




}
