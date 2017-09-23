package com.zt.controller.InviTation;

import com.zt.dao.inner.*;
import com.zt.entity.DetailImg;
import com.zt.entity.InviTation;
import com.zt.entity.JugeInvi;
import com.zt.entity.Stu;
import com.zt.model.InviWithDetailImg;
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
public class getAllInvitation {

    @Autowired
    private InviTationDaoI inviTationDaoI;

    @Autowired
    private StuDaoI stuDaoI;

    @Autowired
    private InviLikeDaoI inviLikeDaoI;

    @Autowired
    private InviSaveDaoI inviSaveDaoI;

    @Autowired
    private InviJugeDaoI inviJugeDaoI;

    @RequestMapping(value = "getAllInvi.html")
    @ResponseBody
    public ApiResponse getAllInviTation() {
        try {
            List<InviTation> list = inviTationDaoI.getAllInvi();
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("list", list);
            return ApiResponse.success(1, "请求数据成功", data);
        } catch (Exception e) {
            System.err.println("请求所有帖子失败");
            return ApiResponse.failure(0, "获取帖子失败,请稍后重试", null);
        }
    }

    /**
     * 请求所有帖子按viewNum倒序排列
     * @return
     */
    @RequestMapping(value = "getAllInviHot.html")
    @ResponseBody
    public ApiResponse getAllInviHot(){
        try {
            List<InviTation> list = inviTationDaoI.getAllInviOrderByViewNum();
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("list", list);
            return ApiResponse.success(1, "请求数据成功", data);
        }catch (Exception e){
            System.err.println("获取所有的热帖失败:"+e.toString());
            return ApiResponse.failure(0,"获取所有的热帖失败",null);
        }
    }


    /**
     * 根据type获取所有帖子及其细节图
     *
     * @param type
     * @return
     */
    @RequestMapping(value = "getInviAndImg.html")
    @ResponseBody
    public AjaxResponse getAllInviWithType(@RequestParam(value = "type") int type) {
        try {
            System.err.println("进入请求页");
            List<InviWithDetailImg> list = inviTationDaoI.getInviByType(type);
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("list", list);
            return AjaxResponse.success(1, "获取数据成功", data);
        } catch (Exception e) {
            System.err.println("获取帖子及其对应的细节图失败"+e.toString());
            return AjaxResponse.failure(0, "获取细节图失败", null);
        }

    }

    /**
     * 根据inviId和stuId判断用户是否收藏过某篇帖子或者点赞过某篇帖子
     *
     * @param inviId
     * @param phoneNum
     * @return
     */
    @RequestMapping(value = "getInviById.html")
    @ResponseBody
    public ApiResponse getInviByInviIdAndStuId(@RequestParam(value = "inviId") long inviId,
                                               @RequestParam(value = "phoneNum") String phoneNum) {
        boolean isLike = false;
        boolean isSave = false;
        try {
            List<Stu> stuList = stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu = stuList.get(stuList.size() - 1);

            long likeCount = inviLikeDaoI.getCountByInviId(stu.getId(), inviId);
            if (likeCount >= 1) {
                isLike = true;
            }

            long saveCount = inviSaveDaoI.getCountByInviIdAndUserId(inviId, stu.getId());
            if (saveCount >= 1) {
                isSave = true;
            }
            InviWithDetailImg inviTation = inviTationDaoI.getInviId(inviId);

            inviTationDaoI.viewNumAdd1(inviId);

            List<JugeInvi> jugeList=inviJugeDaoI.getJugeByInviId(inviId);

            Map<String, Object> data = new HashMap<String, Object>();

            data.put("inviTaion", inviTation);
            data.put("isLike", isLike);
            data.put("isSave", isSave);
            data.put("jugeList",jugeList);
            return ApiResponse.success(1, "获取帖子详细内容成功", data);

        } catch (Exception e) {
            System.err.println("根据帖子id获取帖子失败:" + e.toString());
            return ApiResponse.failure(0, "根据id获取帖子失败", null);
        }

    }

    /**
     * 根据帖子类别返回某个具体用户所发的帖子
     * @param phoneNum
     * @param type
     * @return
     */
    @RequestMapping(value = "getInviByType.html")
    @ResponseBody
    public AjaxResponse getInviByType(@RequestParam(value = "phoneNum") String phoneNum
            , @RequestParam(value = "type") int type) {
        try {
            List<Stu> stuList = stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu = stuList.get(stuList.size() - 1);
            List<DetailImg> list = inviTationDaoI.getInviBuTypeAndUserId(type, stu.getId());
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("list",list);
            return AjaxResponse.success(1,"根据类别及用户请求帖子成功",data);

        } catch (Exception e) {
            System.err.println("根据类别及用户id请求帖子出错:" + e.toString());
            return AjaxResponse.failure(0, "请求帖子出错", null);
        }
    }

    /**
     * 根据个人id获取该用户收藏的帖子
     * @param phoneNum
     * @return
     */
    @RequestMapping(value = "getSave.html")
    @ResponseBody
    public AjaxResponse getSave(@RequestParam(value = "phoneNum")String phoneNum){

        try {
            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu = stuList.get(stuList.size() - 1);
            List<InviWithDetailImg> list=inviTationDaoI.getSavedInvi(stu.getId());
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("list",list);
            return AjaxResponse.success(1,"请求用户个人收藏的帖子成功",data);

        }catch (Exception e){
            System.err.println("获取用户个人收藏的帖子是把你："+e.toString());
            return AjaxResponse.failure(0,"获取收藏的帖子失败",null);
        }
    }
}
