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
    @RequestMapping("login.html")
    @ResponseBody
    public ApiResponse login(){
        List<Stu> list=stuDaoI.getAll();
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("list",list);
        return ApiResponse.success(1,"成功",data);
    }




}
