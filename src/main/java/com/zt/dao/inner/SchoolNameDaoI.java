package com.zt.dao.inner;

import com.zt.entity.SchoolName;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface SchoolNameDaoI {

    public List<SchoolName> getSchoolNameByPID(@Param(value = "pId") int pId);
}
