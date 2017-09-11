package com.zt.dao.inner;

import com.zt.entity.Stu;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface StuDaoI {

    public List<Stu> getAll();

    /**
     * 插入一条用户记录
     * userName,
     pwd,
     phoneNum,
     school
     * @param userName
     * @param pwd
     * @param phoneNum
     * @param school
     */
    public void insertStu(@Param(value = "userName") String userName, @Param(value = "pwd") String pwd,
                          @Param(value = "phoneNum") String phoneNum, @Param(value = "school") String school);

    /**
     * 用户注册时判断用户名是否已经被占用
     *
     * @param userName
     * @return
     */
    public int checkUserName(@Param(value = "userName") String userName);
}
