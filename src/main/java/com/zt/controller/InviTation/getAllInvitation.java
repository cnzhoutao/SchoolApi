package com.zt.controller.InviTation;

import com.zt.dao.inner.InviTationDaoI;
import com.zt.entity.InviTation;
import com.zt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class getAllInvitation {

    @Autowired
    private InviTationDaoI inviTationDaoI;

    @RequestMapping(value = "getAllInvi.html")
    @ResponseBody
    public ApiResponse getAllInviTation(){
        try {
            List<InviTation> list=inviTationDaoI.getAllInvi();
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("list",list);
            return ApiResponse.success(1,"请求数据成功",data);
        }catch (Exception e){
            System.err.println("请求所有帖子失败");
            return ApiResponse.failure(0,"获取帖子失败,请稍后重试",null);
        }
    }
}
