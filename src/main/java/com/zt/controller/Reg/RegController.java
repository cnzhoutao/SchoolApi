package com.zt.controller.Reg;

import com.zt.dao.inner.ProvinceDaoI;
import com.zt.dao.inner.SchoolNameDaoI;
import com.zt.dao.inner.StuDaoI;
import com.zt.entity.Province;
import com.zt.entity.SchoolName;
import com.zt.entity.Stu;
import com.zt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class RegController {

    @Autowired
    private ProvinceDaoI provinceDaoI;

    @Autowired
    private SchoolNameDaoI schoolNameDaoI;

    @Autowired
    private StuDaoI stuDaoI;

    /**
     * 获取所有的省份数据
     *
     * @return
     */
    @RequestMapping(value = "getAllProvin.html")
    @ResponseBody
    public ApiResponse getAllProvince() {

        List<Province> list = provinceDaoI.getAllProvince();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("list", list);
        return ApiResponse.success(1, "获取数据成功", data);
    }

    /**
     * 根据省份id获取对应的大学
     *
     * @param pId
     * @return
     */
    @RequestMapping(value = "getSchNameByPid.html")
    @ResponseBody
    public ApiResponse getSchoolNameByPid(@RequestParam(value = "pId") int pId) {
        try {
            List<SchoolName> list = schoolNameDaoI.getSchoolNameByPID(pId);
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("list", list);
            return ApiResponse.success(1, "获取数据成功", data);
        } catch (Exception e) {
            System.out.println("获取数据失败:" + e.toString());
            return ApiResponse.failure(0, "获取数据失败");
        }

    }

    /**
     * 用户发起注册请求
     * @param userName
     * @param pwd
     * @param phoneNum
     * @param schoolName
     * @return
     */
    @RequestMapping(value = "reg.html")
    @ResponseBody
    public ApiResponse register(@RequestParam(value = "userName") String userName
            , @RequestParam(value = "pwd") String pwd,
                                @RequestParam(value = "phoneNum") String phoneNum,
                                @RequestParam(value = "schoolName") String schoolName) {

                    System.err.println(userName+":"+pwd+":"+phoneNum+":"+schoolName);

                try{
                    int count=stuDaoI.checkUserName(userName);
                    if(count>=1){
                        return ApiResponse.failure(0,"该用户名已经被占用");
                    }
                    stuDaoI.insertStu(userName,pwd,phoneNum,schoolName);
                    return ApiResponse.success(1,"用户注册成功");

                }catch (Exception e){
                    System.err.println("用户注册失败:"+e.toString());
                    return ApiResponse.failure(0,"用户注册失败,请稍后重试");
                }

    }

}
