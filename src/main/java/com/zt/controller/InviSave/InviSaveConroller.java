package com.zt.controller.InviSave;


import com.zt.dao.inner.InviSaveDaoI;
import com.zt.dao.inner.StuDaoI;
import com.zt.entity.InviSave;
import com.zt.entity.Stu;
import com.zt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 帖子收藏控制器
 */
@Controller
@RequestMapping(value = "/")
public class InviSaveConroller {


    @Autowired
    private InviSaveDaoI inviSaveDaoI;

    @Autowired
    private StuDaoI stuDaoI;

    /**
     * 收藏一条帖子
     * @param inviId
     * @param phoneNum
     * @return
     */
    @RequestMapping(value = "saveInvi.html")
    @ResponseBody
    public ApiResponse saveInvi(@RequestParam(value = "inviId") long inviId
            ,@RequestParam(value = "phoneNum") String phoneNum){

        try {

            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);

            InviSave inviSave=new InviSave();

            inviSave.setUserId(stu.getId());
            inviSave.setInviId(inviId);
            inviSave.setUserName(stu.getUserName());
            inviSave.setUserIcon(stu.getIcon());
            inviSave.setInviId(inviId);

            inviSaveDaoI.insertSave(inviSave);
            return ApiResponse.success(1,"保存帖子成功",null);

        }catch (Exception e){
            System.err.println("收藏帖子失败"+e.toString());
            return ApiResponse.failure(0,"保存帖子失败",null);
        }
    }

    /**
     * 根据inviId和userId删除一条用户的收藏记录
     * @param inviId
     * @param phoneNum
     * @return
     */
    @RequestMapping(value = "cancelSave.html")
    @ResponseBody
    public ApiResponse cancelSave(@RequestParam(value = "inviId") long inviId,@RequestParam(value = "phoneNum") String phoneNum){
        try {
            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);
            inviSaveDaoI.deleteSave(inviId,stu.getId());
            return ApiResponse.success(1,"删除记录成功",null);
        }catch (Exception e){
            System.err.println("删除一条用户的收藏记录失败:"+e.toString());
            return ApiResponse.failure(0,"删除收藏记录失败",null);
        }
    }




}
