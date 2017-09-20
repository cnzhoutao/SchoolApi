package com.zt.controller.BackStage;

import com.zt.dao.inner.StuDaoI;
import com.zt.util.AjaxResponse;
import com.zt.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/")
@Controller
public class BackStageJsonController {

    @Autowired
    private StuDaoI stuDaoI;

    @RequestMapping(value = "loginCheck.html")
    @ResponseBody
    public AjaxResponse loginChck(String phoneNum, String pwd){
        System.out.println(phoneNum+":"+pwd);
        try {
            int count=stuDaoI.checkBackLogin(phoneNum, MD5Util.md5(pwd.trim()));
            System.err.println("count:"+count);
            if(count>=1){
                return AjaxResponse.success(1,"登录成功",null);
            }
            return AjaxResponse.failure(0,"用户或者密码错误，或者该用户不是管理员",null);

        }catch (Exception e){
            System.err.println("管理员登录出错"+e.toString());
            return AjaxResponse.failure(0,"管理员登录出错",null);
        }

    }

}
