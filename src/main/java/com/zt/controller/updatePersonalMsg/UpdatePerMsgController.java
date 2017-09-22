package com.zt.controller.updatePersonalMsg;

import com.zt.dao.inner.StuDaoI;
import com.zt.entity.Stu;
import com.zt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/")
@Controller
public class UpdatePerMsgController {

    @Autowired
    private StuDaoI stuDaoI;
    /**
     * 用户修改自己的年龄
     * @param phoneNum
     * @param age
     * @return
     */
    @RequestMapping(value = "updateAge.html")
    @ResponseBody
    public ApiResponse updateAge(@RequestParam(value = "phoneNum") String phoneNum, @RequestParam(value = "age") int age){
        try {
            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);
            stuDaoI.updateAge(age,stu.getId());
            return ApiResponse.success(1,"修改年龄成功",null);
        }catch (Exception e){
            System.err.println("用户修改自己的年龄失败:"+e.toString());
            return ApiResponse.failure(0,"修改年龄失败",null);
        }

    }


    /**
     * 用户修改性别
     * @param phoneNum
     * @param gender
     * @return
     */
    @RequestMapping(value = "updateGender.html")
    @ResponseBody
    public ApiResponse updateGender(@RequestParam(value = "phoneNum") String phoneNum
            , @RequestParam(value = "gender") String gender){
        try {
            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);
            stuDaoI.updateGender(gender,stu.getId());
            return ApiResponse.success(1,"修改性别成功",null);
        }catch (Exception e){
            System.err.println("用户修改自己的性别失败:"+e.toString());
            return ApiResponse.failure(0,"修改性别失败",null);
        }

    }

    /**
     * 用户修改自己的个人简介
     * @param phoneNum
     * @param msg
     * @return
     */
    @RequestMapping(value = "updateMsg.html")
    @ResponseBody
    public ApiResponse updateMsg(@RequestParam(value = "phoneNum") String phoneNum, @RequestParam(value = "msg") String msg){
        try {
            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);
            stuDaoI.updateMsg(msg,stu.getId());
            return ApiResponse.success(1,"修改跟人信息成功",null);
        }catch (Exception e){
            System.err.println("用户修改自己的个人信息失败:"+e.toString());
            return ApiResponse.failure(0,"修改个人信息失败",null);
        }

    }

    /**
     * 用户根据手机号回去个人信息
     * @param phoneNum
     * @return
     */
    @RequestMapping(value = "getInfoByPhone.html")
    @ResponseBody
    public ApiResponse getInfoByPhoneNum(@RequestParam(value = "phoneNum") String phoneNum){
        try {
            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("stu",stu);
            return ApiResponse.success(1,"获取个人信息成功",data);
        }catch (Exception e){
            System.err.println("获取个人信息失败:"+e.toString());
            return ApiResponse.failure(0,"获取个人信息失败",null);
        }
    }



}
