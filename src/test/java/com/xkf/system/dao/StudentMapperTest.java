package com.xkf.system.dao;

import com.xkf.system.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xukefei
 * @create 2021-08-02 下午1:57
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void getStudentList() {
        List<Student> studentList = studentMapper.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void getStudentById() {
        Student student = studentMapper.getStudentById(3);
        System.out.println(student);
    }

    @Test
    public void addStudent() {

    }

    @Test
    public void updateStudent() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 3);
        map.put("name", "我是谁");
        map.put("phone", "20394028");
        int res = studentMapper.updateStudent(map);
        if (res > 0) System.out.println("更新成功！");
    }

    @Test
    public void deleteStudent() {
        int res = studentMapper.deleteStudent(32);
        if (res > 0) System.out.println("删除成功！");
    }

    @Test
    public void findStudentLikeName() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "a");

        List<Student> list = studentMapper.findStudentLikeName(map);

        for (Student student : list) {
            System.out.println(student);
        }
    }
}
