package com.zt.controller.InviLike;


import com.zt.dao.inner.InviLikeDaoI;
import com.zt.dao.inner.InviTationDaoI;
import com.zt.dao.inner.StuDaoI;
import com.zt.entity.InviLike;
import com.zt.entity.Stu;
import com.zt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 帖子点赞相关的处理操作
 */
@RequestMapping(value = "/")
@Controller
public class InviLikeController {

    @Autowired
    private StuDaoI stuDaoI;

    @Autowired
    private InviLikeDaoI inviLikeDaoI;

    @Autowired
    private InviTationDaoI inviTationDaoI;
    /**
     * 根据用户信息和inviId插入一条点赞记录
     * 同时likeNum+1
     * @param phoneNum
     * @param inviId
     * @return
     */
    @RequestMapping(value = "like.html")
    @ResponseBody
    public ApiResponse dianzan(@RequestParam(value = "phoneNum") String phoneNum
            ,@RequestParam(value = "inviId") long inviId){
        try {
            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);
            InviLike inviLike=new InviLike();

            inviLike.setInviId(inviId);
            inviLike.setUserIcon(stu.getIcon());
            inviLike.setUserId(stu.getId());
            inviLike.setUserName(stu.getUserName());

            inviLikeDaoI.insertLike(inviLike);
            inviTationDaoI.likeNumAdd1(inviId);

            return ApiResponse.success(1,"点赞成功",null);
        }catch (Exception e){
            System.err.println("点赞出错:"+e.toString());
            return ApiResponse.failure(0,"点赞失败",null);
        }
    }

    /**
     * 取消点赞
     * 删一条点赞记录
     * 同时likeNum-1
     * @param phoneNum
     * @param inviId
     * @return
     */
    @RequestMapping(value = "cancelLike.html")
    @ResponseBody
    public ApiResponse cancelDianZan(@RequestParam(value = "phoneNum") String phoneNum
            ,@RequestParam(value = "inviId") long inviId){
        try {
            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);
            inviLikeDaoI.deleteALike(inviId,stu.getId());
            inviTationDaoI.likeNumSub1(inviId);
            return ApiResponse.success(1,"取消点赞成功",null);
        }catch (Exception e){
            System.err.println("取消点赞失败:"+e.toString());
            return ApiResponse.failure(0,"取消点赞失败",null);
        }

    }

}
