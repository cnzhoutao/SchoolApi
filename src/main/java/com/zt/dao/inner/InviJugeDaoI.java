package com.zt.dao.inner;

import com.zt.entity.JugeInvi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InviJugeDaoI {

    /**
     * 插入一条帖子评论
     * @param jugeInvi
     */
    public void insertJuge(JugeInvi jugeInvi);

    /**
     * 根据帖子id请求某一条帖子的所有评论
     * @param inviId
     * @return
     */
    public List<JugeInvi> getJugeByInviId(@Param(value = "inviId") long inviId);
}
