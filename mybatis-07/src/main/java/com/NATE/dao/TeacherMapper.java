package com.NATE.dao;

import com.NATE.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
     // 获得指定老师及其所有学生的信息
     Teacher getTeacher(@Param("tid") int id);

     Teacher getTeacher2(@Param("tid") int id);

}
