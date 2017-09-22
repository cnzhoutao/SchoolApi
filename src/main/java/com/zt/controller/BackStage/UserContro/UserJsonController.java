package com.zt.controller.BackStage.UserContro;

import com.zt.dao.inner.StuDaoI;
import com.zt.util.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/")
@Controller
public class UserJsonController {

    @Autowired
    private StuDaoI stuDaoI;

    @RequestMapping(value = "upUser.html")
    @ResponseBody
    public AjaxResponse upUser(@RequestParam(value = "userId") long userId){

        try {

            stuDaoI.UpUser(userId);
            return AjaxResponse.success(1,"提拔管理员成功",null);
        }catch (Exception e){
            System.err.println("提拔管理员出错:"+e.toString());
            return AjaxResponse.failure(0,"提拔管理员出错，请稍后重试",null);
        }

    }
}
