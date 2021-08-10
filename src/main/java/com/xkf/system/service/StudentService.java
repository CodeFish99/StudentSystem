package com.xkf.system.service;

import com.xkf.system.bean.Student;
import com.xkf.system.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xukefei
 * @create 2021-08-03 下午3:47
 */
@Service
public class StudentService {
    @Autowired
    StudentMapper mapper;

    public Student getStudentById(int id) {
        return mapper.getStudentById(id);
    }

    public List<Student> findStudentLikeName(Map<String, Object> map) {
        return mapper.findStudentLikeName(map);
    }

    public boolean addStudent(Student student) {
        int i = mapper.insertStudent(student);
        if (i > 0) return true;
        return false;
    }

}
