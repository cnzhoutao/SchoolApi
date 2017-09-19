package com.zt.controller.InviTation;

import com.zt.dao.inner.DetailImgDaoI;
import com.zt.dao.inner.InviTationDaoI;
import com.zt.dao.inner.StuDaoI;
import com.zt.entity.DetailImg;
import com.zt.entity.InviTation;
import com.zt.entity.Stu;
import com.zt.util.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 上传帖子相关的内容，
 * 包括title,content,List<String>细节图地址
 */

@Controller
@RequestMapping(value = "/")
public class UploadInviTation {

    @Autowired
    private InviTationDaoI inviTationDaoI;

    @Autowired
    private DetailImgDaoI detailImgDaoI;

    @Autowired
    private StuDaoI stuDaoI;

    /**
     * 保存帖子及其细节图
     * @param phoneNum
     * @param type
     * @param title
     * @param content
     * @param imgList
     * @return
     */
    @RequestMapping(value = "uploadInvi.html")
    @ResponseBody
    public AjaxResponse uploadInvi(
            @RequestParam(value = "phoneNum")  String phoneNum,
            @RequestParam(value = "type") int type,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "detailImg") List<String> imgList) {

        try {

            Stu stu=new Stu();
            stu=stuDaoI.getStuByPhoneNum(phoneNum.trim());
            InviTation inviTation = new InviTation();
            inviTation.setType(type);
            inviTation.setContent(content);
            inviTation.setTitle(title);
            inviTation.setUserIcon(stu.getIcon());
            inviTation.setUserId((int) stu.getId());
            inviTation.setUserName(stu.getUserName());
            inviTationDaoI.insertInvi(inviTation);

            List<Long> list;

            list = inviTationDaoI.getIdByTitle(title);

            for(String s:imgList){
                DetailImg detailImg=new DetailImg();
                detailImg.setImgUrl(s);
                detailImg.setInviId(list.get(list.size()-1));
                detailImgDaoI.insertDetailImg(detailImg);
            }
            return AjaxResponse.success(1, "保存帖子成功", null);
        } catch (Exception e) {
            System.err.println("保存帖子出bug：" + e.toString());
            return AjaxResponse.failure(0, "保存帖子出错", null);
        }

    }
}
