package com.xkf.system.controller;

import com.xkf.system.bean.ResultObject;
import com.xkf.system.bean.Student;
import com.xkf.system.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xukefei
 * @create 2021-08-03 下午4:16
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    StudentService studentService;

    @GetMapping("/getStudentById")
    public ResultObject getStudentById(int id) {
        Student rs = studentService.getStudentById(id);
        if (rs != null) {
            return ResultObject.success("查询成功", rs);
        } else {
            return ResultObject.error("无符合的值", null);
        }
    }

    @PostMapping("/addStudent")
    public ResultObject addStudent(Student student) {
        boolean rs = studentService.addStudent(student);
        if (rs == true) {
            return ResultObject.success("插入成功", student);
        } else {
            return ResultObject.error("插入失败", null);
        }
    }

    @PostMapping("/findStudentLikeName")
    public ResultObject findStudentLikeName(@RequestBody Map<String, Object> map) {
        List<Student> list = studentService.findStudentLikeName(map);
        if (list.isEmpty()) {
            return ResultObject.error("无符合的值", null);
        } else {
            return ResultObject.success("查询成功", list);
        }
    }
}
