package com.zt.controller.BackStage.InviContro;

import com.zt.dao.inner.InviTationDaoI;
import com.zt.util.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/")
@Controller
public class InviJsonController {

    @Autowired
    private InviTationDaoI inviTationDaoI;

    @RequestMapping(value = "deleteInvi.html")
    @ResponseBody
    public AjaxResponse deleteInvi(@RequestParam(value = "inviId") long inviId){

        try {
            inviTationDaoI.deleteInviById(inviId);
            return AjaxResponse.success();

        }catch (Exception e){
            System.err.println("删除帖子失败:"+e.toString());
            return AjaxResponse.failure();
        }
    }
}
