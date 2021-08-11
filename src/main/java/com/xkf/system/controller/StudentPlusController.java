package com.xkf.system.controller;

import com.xkf.system.bean.ResultObject;
import com.xkf.system.bean.Student;
import com.xkf.system.dao.StudentMapperPlus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xukefei
 * @create 2021-08-11 上午10:55
 */
@RestController
@RequestMapping("/studentplus")
public class StudentPlusController {
    @Resource
    StudentMapperPlus mapper;

    @GetMapping("/getStudentById")
    public ResultObject getStudentById(int id) {
        Student student = mapper.selectById(id);
        if (student != null) {
            return ResultObject.success("查询成功", student);
        } else {
            return ResultObject.error("查询失败", null);
        }
    }

    @PostMapping("/addStudent")
    public ResultObject addStudent(Student student) {
        int rs = mapper.insert(student);
        if (rs > 0) {
            return ResultObject.success("插入成功", null);
        } else {
            return ResultObject.error("插入失败", null);
        }
    }

    @GetMapping("/getStudentList")
    public ResultObject getStudentList() {
        List<Student> students = mapper.selectList(null);
        if (students != null) {
            return ResultObject.success("查询成功", students);
        } else {
            return ResultObject.error("查询失败", null);
        }
    }

    @GetMapping("/updateStudentNameById")
    public ResultObject updateStudentNameById(int id, String name) {
        Student student = mapper.selectById(id);
        student.setStuName(name);
        int rs = mapper.updateById(student);
        if (rs > 0) {
            return ResultObject.success("更新成功", null);
        } else {
            return ResultObject.error("更新失败", null);
        }
    }

    @GetMapping("/deleteStudentById")
    public ResultObject deleteStudentById(int id) {
        int rs = mapper.deleteById(id);
        if (rs > 0) {
            return ResultObject.success("删除成功", null);
        } else {
            return ResultObject.error("删除失败", null);
        }
    }
}
