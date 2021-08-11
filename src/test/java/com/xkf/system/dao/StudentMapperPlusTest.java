package com.xkf.system.dao;

import com.mysql.cj.Constants;
import com.xkf.system.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author xukefei
 * @create 2021-08-11 上午8:54
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StudentMapperPlusTest {
    @Autowired
    private StudentMapperPlus studentMapperPlus;

    @Test
    public void testSelectList() {
        List<Student> students = studentMapperPlus.selectList(null);
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        Student student = studentMapperPlus.selectById(1);
        System.out.println(student);
    }

    @Test
    public void testInsert() {
        Student student = studentMapperPlus.selectById(1);
        int res = studentMapperPlus.insert(student);
        if (res > 0) System.out.println("插入成功");
        else System.out.println("插入失败");
    }

    @Test
    public void testUpdate() {
        Student student = studentMapperPlus.selectById(1);
        student.setStuName("尼古拉斯");
        int res = studentMapperPlus.updateById(student);
        if (res > 0) System.out.println("修改成功");
        else System.out.println("修改失败");
    }

    @Test
    public void testDelete() {
        int res = studentMapperPlus.deleteById(2);
        if (res > 0) System.out.println("删除成功");
        else System.out.println("删除失败");
    }
}
