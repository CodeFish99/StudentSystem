package com.xkf.system.dao;

import com.xkf.system.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author xukefei
 * @create 2021-08-02 下午1:35
 */
public interface StudentMapper {

    @Results(id = "studentResultMap", value = {
            @Result(column = "stu_id", property = "stuId"),
            @Result(column = "stu_name", property = "stuName"),
            @Result(column = "stu_gender", property = "stuGender"),
            @Result(column = "stu_education", property = "stuEducation"),
            @Result(column = "stu_school", property = "stuSchool"),
            @Result(column = "stu_phone", property = "stuPhone"),
            @Result(column = "stu_home", property = "stuHome"),
            @Result(column = "stu_graduation", property = "stuGraduation")
    })
    @Select("select * from student_info")
    List<Student> getStudentList();

    @ResultMap("studentResultMap")
    @Select("select * from student_info where stu_id = #{id}")
    Student getStudentById(int id);

    @ResultMap("studentResultMap")
    @Insert("insert into student_info (stu_name, stu_school, stu_phone) values(#{stuName}, #{stuSchool}, #{stuPhone})")
    @Options(useGeneratedKeys = true, keyProperty = "stuId")
    int insertStudent(Student student);

    int updateStudent(Map<String, Object> map);

    int deleteStudent(int id);

    @ResultMap("studentResultMap")
//    @Select({
//            "<script>",
//            "SELECT * FROM student_info WHERE 1=1",
//            "<if test='name!=null'>",
//            "AND stu_name LIKE CONCAT('%',#{name},'%')",
//            "</if>",
//            "</script>"
//    })
    @Select("select * from student_info where stu_name like concat('%',#{name},'%')")
    List<Student> findStudentLikeName(Map<String, Object> map);
}
