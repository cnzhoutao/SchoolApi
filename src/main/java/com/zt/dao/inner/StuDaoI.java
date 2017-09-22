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

    /**
     * 用户登录操作，判断手机号和密码是否正确
     * @param phoneNum
     * @param pwd
     * @return
     */
    public int login(@Param(value = "phoneNum")String phoneNum,@Param(value = "pwd") String pwd);

    /**
     * 检查用户的手机号是否已经注册过了
     * @param phoneNum
     * @return
     */
    public int checkPhoneNum(@Param(value = "phoneNum") String phoneNum);

    /**
     * 根据手机号获取一个学生的具体信息
     * @param phoneNum
     * @return
     */
    public List<Stu> getStuByPhoneNum(@Param(value = "phoneNum") String phoneNum);


    /**
     * 后台登录
     * @param phoneNum
     * @param pwd
     * @return
     */
    public int checkBackLogin(@Param(value = "phoneNum")String phoneNum,@Param(value = "pwd") String pwd);

    /**
     * 获取所有普通用户
     * @return
     */
    public List<Stu> getAllCommonUser();

    /**
     * 提拔普通用户为管理员
     * @param userId
     */
    public void UpUser(@Param(value = "userId") long userId);

    /**
     * 删除一个用户
     * @param userId
     */
    public void deleteUser(@Param(value = "userId") long userId);

    /**
     * 修改用户的年龄
     * @param age
     * @param userId
     */
    public void updateAge(@Param(value = "age") int age,@Param(value = "userId") long userId);

    /**
     * 修改用户的性别
     * @param gender
     * @param userId
     */
    public void updateGender(@Param(value = "gender") String gender,@Param(value = "userId") long userId);

    /**
     * 用户修改个人简介
     * @param msg
     * @param userId
     */
    public void updateMsg(@Param(value = "msg") String msg,@Param(value = "userId") long userId);

}
