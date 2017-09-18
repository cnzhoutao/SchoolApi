package com.zt.dao.inner;

import com.zt.entity.InviTation;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface InviTationDaoI {

    /**
     * 获取所有帖子
     * @return
     */
    public List<InviTation> getAllInvi();

    /**
     * 插入一条帖子记录
     * @param inviTation
     */
    public void insertInvi(InviTation inviTation);

    /**
     * 根据title获取id
     * @param title
     * @return
     */
    public List<Long> getIdByTitle(@Param(value = "title") String title);


}
