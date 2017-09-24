package com.zt.controller.InviTation;

import com.zt.dao.inner.InviLikeDaoI;
import com.zt.dao.inner.InviSaveDaoI;
import com.zt.dao.inner.InviTationDaoI;
import com.zt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/")
@Controller
public class DeletePInvi {


    @Autowired
    private InviTationDaoI inviTationDaoI;

    @Autowired
    private InviSaveDaoI inviSaveDaoI;

    @Autowired
    private InviLikeDaoI inviLikeDaoI;


    /**
     * 删除个人发帖，以及相关的收藏及点赞
     * @param inviId
     * @return
     */
    @RequestMapping(value = "deletePInviById.html")
    @ResponseBody
    public ApiResponse deletePInvi(@RequestParam(value = "inviId") long inviId){
        try {
            inviTationDaoI.deleteInviById(inviId);
            inviSaveDaoI.deleteInviById(inviId);
            inviLikeDaoI.deleteInviById(inviId);
            return ApiResponse.success(1,"删除个人发帖成功",null);
        }catch (Exception e){
            System.err.println("删除个人发帖失败:"+e.toString());
            return ApiResponse.failure(0,"删除个人发帖失败",null);
        }
    }

}
