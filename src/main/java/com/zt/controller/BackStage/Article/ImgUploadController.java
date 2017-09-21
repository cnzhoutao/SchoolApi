package com.zt.controller.BackStage.Article;

import com.zt.dao.inner.DetailImgDaoI;
import com.zt.dao.inner.InviTationDaoI;
import com.zt.entity.DetailImg;
import com.zt.entity.InviTation;
import com.zt.entity.Stu;
import com.zt.util.AjaxResponse;
import com.zt.util.ConstFile;
import com.zt.util.ImgResponse;
import com.zt.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 图片上传的控制器
 */
@RequestMapping(value = "/")
@Controller
public class ImgUploadController {

    @Autowired
    private InviTationDaoI inviTationDaoI;

    @Autowired
    private DetailImgDaoI detailImgDaoI;

    private String newImgName = "";

    @RequestMapping(value = "upload.html")
    @ResponseBody
    public ImgResponse upload(@RequestParam(value = "file") MultipartFile file) {
        try {
            newImgName = getImgName(file);
            UploadUtil.uploadImage(newImgName, (InputStream) file.getInputStream());
            Map<String, Object> data = new HashMap<String, Object>();
            System.err.println("图片路径：" + ConstFile.imgName + newImgName);
            data.put("src", ConstFile.imgName + newImgName);
            data.put("title", "上传图片成功");
            return ImgResponse.success("上传成功", data);
        } catch (Exception e) {
            System.err.println("上传图片出错" + e.toString());
            return ImgResponse.failure("上传图片出错", null);
        }
    }

    /**
     * 获取图片新的名称
     *
     * @param file
     * @return
     */
    private String getImgName(MultipartFile file) {
        String contentType = file.getContentType();
        String imgEnd = contentType.substring(contentType.indexOf("/") + 1);
        System.err.println("imgEnd:" + imgEnd);
        String newName = UUID.randomUUID().toString().replaceAll("-", "") + "." + imgEnd;
        return newName;
    }


    /**
     * 保存管理员发的帖子
     *
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "saveArticle.html")
    @ResponseBody
    public AjaxResponse saveArticle(HttpSession session, @RequestParam(value = "title") String title
            , @RequestParam(value = "content") String content) {
        try {
            InviTation inviTation = new InviTation();
            inviTation.setTitle(title);
            inviTation.setContent(content);
            Stu stu = (Stu) session.getAttribute("admin");
            inviTation.setUserId((int) stu.getId());
            inviTation.setUserName(stu.getUserName());
            inviTation.setUserIcon(stu.getIcon());
            inviTation.setType(1);
            inviTationDaoI.insertInvi(inviTation);
            if (newImgName != null) {
                List<Long> list = inviTationDaoI.getIdByTitle(title);
                DetailImg detailImg=new DetailImg();
                detailImg.setInviId(list.get(list.size()-1));
                detailImg.setImgUrl(newImgName);
                detailImgDaoI.insertDetailImg(detailImg);
            }
            return AjaxResponse.success(1, "管理员发表文章成功", null);
        } catch (Exception e) {
            System.err.println("管理员发帖子出错:" + e.toString());
            return AjaxResponse.failure(0, "管理员发帖出错", null);
        }
    }

}
