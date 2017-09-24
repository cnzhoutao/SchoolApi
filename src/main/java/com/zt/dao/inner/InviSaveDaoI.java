package com.zt.dao.inner;

import com.zt.entity.InviSave;
import org.apache.ibatis.annotations.Param;

/**
 * 帖子收藏
 */
public interface InviSaveDaoI {


    /**
     * 插入一条帖子收藏记录
     * @param inviSave
     */
    public void insertSave(InviSave inviSave);

    /**
     * 根据帖子id和用户id判断用户是否收藏过某一篇帖子
     * @param inviId
     * @param userId
     * @return
     */
    public long getCountByInviIdAndUserId(@Param(value = "inviId") long inviId,@Param(value = "userId") long userId);

    /**
     * 根据id和帖子id删除一条用户的收藏记录
     * @param inviId
     * @param userId
     */
    public void deleteSave(@Param(value = "inviId") long inviId,@Param(value = "userId") long userId);

    /**
     * 更改用户头像
     * @param icon
     * @param userId
     */
    public void updateIcon(@Param(value = "icon") String icon,@Param(value = "userId") long userId);


    /**
     * 修改用户名
     * @param userName
     * @param userId
     */
    public void updateUserName(@Param(value = "userName") String userName,@Param(value = "userId") long userId);

    /**
     * 删除已经删除的帖子收藏
     * @param inviId
     */
    public void deleteInviById(@Param(value = "inviId") long inviId);
}
