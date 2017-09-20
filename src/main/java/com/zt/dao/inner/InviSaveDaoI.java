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

}
