package com.zt.controller.InviJuge;

import com.zt.dao.inner.InviJugeDaoI;
import com.zt.dao.inner.InviTationDaoI;
import com.zt.dao.inner.StuDaoI;
import com.zt.entity.JugeInvi;
import com.zt.entity.Stu;
import com.zt.util.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = "/")
@Controller
public class InviJugeController {

    @Autowired
    private StuDaoI stuDaoI;

    @Autowired
    private InviJugeDaoI inviJugeDaoI;

    @Autowired
    private InviTationDaoI inviTationDaoI;


    @RequestMapping(value = "juge.html")
    @ResponseBody
    public AjaxResponse juge(@RequestParam(value = "inviId") long inviId, @RequestParam(value = "phoneNum") String phoneNum,
                             @RequestParam(value = "content") String content) {

        try {

            List<Stu> stuList=stuDaoI.getStuByPhoneNum(phoneNum);
            Stu stu=stuList.get(stuList.size()-1);
            JugeInvi jugeInvi=new JugeInvi();
            jugeInvi.setContent(content);
            jugeInvi.setInviId(inviId);
            jugeInvi.setUserIcon(stu.getIcon());
            jugeInvi.setUserId(stu.getId());
            jugeInvi.setUserName(stu.getUserName());
            inviJugeDaoI.insertJuge(jugeInvi);

            inviTationDaoI.jugeNumAdd1(inviId);


            return AjaxResponse.success(1,"用户评论成功",null);
        } catch (Exception e) {
            System.err.println("用户评论帖子出错:" + e.toString());
            return AjaxResponse.failure(0, "用户评论帖子出错", null);
        }
    }

}
