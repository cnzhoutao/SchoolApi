package com.zt.dao.inner;

import com.zt.entity.InviLike;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;

public interface InviLikeDaoI {

    /**
     * 插入一条帖子的点赞记录
     * @param inviLike
     */
    public void insertLike(InviLike inviLike);

    /**
     * 根据帖子id和userId删除一条点赞记录
     * @param inviId
     * @param userId
     */
    public void deleteALike(@Param(value = "inviId") long inviId,@Param(value = "userId") long userId);


    /**
     * 根据inviId和userId判断用户是否对某一篇帖子点过赞
     * @param userId
     * @param inviId
     * @return
     */
    public long getCountByInviId(@Param(value = "userId") long userId,@Param(value = "inviId") long inviId);

    /**
     * 更改用户头像
     * @param icon
     * @param userId
     */
    public void updateIcon(@Param(value = "icon") String icon,@Param(value = "userId") long userId);

    /**
     * 更改用户名
     * @param userName
     * @param usrId
     */
    public void updateUserName(@Param(value = "userName") String userName,@Param(value = "userId") long usrId);

    /**
     * 删除已经删除但点过赞的帖子
     * @param inviId
     */
    public void deleteInviById(@Param(value = "inviId") long inviId);
}
