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

    /**
     * 更改用户头像
     * @param icon
     * @param userId
     */
    public void updateIcon(@Param(value = "icon") String icon,@Param(value = "userId") long userId);


    /**
     * 更改用户名
     * @param userName
     * @param userId
     */
    public void updateUserName(@Param(value = "userName") String userName,@Param(value = "userId") long userId);

}
