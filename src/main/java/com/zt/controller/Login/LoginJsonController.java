package com.zt.controller.Login;

import com.zt.dao.inner.StuDaoI;
import com.zt.entity.Stu;
import com.zt.util.AjaxResponse;
import com.zt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class LoginJsonController {

    @Autowired
    private StuDaoI stuDaoI;
    /**
     * 用户登录api
     *通过手机号和密码登录
     * @param phoneNum
     * @param pwd
     * @return
     */
    @RequestMapping(value = "login.html")
    @ResponseBody
    public ApiResponse login(@RequestParam(value = "phoneNum") String phoneNum, @RequestParam(value = "pwd") String pwd) {
        try {
            int count = stuDaoI.login(phoneNum, pwd);
            if (count >= 1) {
                return ApiResponse.success(1, "登录成功",null);
            } else {
                return ApiResponse.failure(0,"用户名或密码错误",null);
            }
        } catch (Exception e) {
            System.err.println("用户登录时服务器出错:" + e.toString());
            return ApiResponse.failure(0, "网络不佳,请稍后重试",null);
        }
    }

}
