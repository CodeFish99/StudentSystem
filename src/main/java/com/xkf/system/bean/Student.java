package com.xkf.system.bean;

import java.io.Serializable;

/**
 * @author xukefei
 * @create 2021-08-02 下午1:35
 */
public class Student implements Serializable {

    public static final long serialVersionUID = 1L;

    private int stuId;
    private String stuName;
    private String stuGender;
    private String stuEducation;
    private String stuSchool;
    private String stuPhone;
    private String stuHome;
    private String stuGraduation;

    public Student() {
    }

    public Student(int stuId, String stuName, String stuGender, String stuEducation, String stuSchool, String stuPhone, String stuHome, String stuGraduation) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuEducation = stuEducation;
        this.stuSchool = stuSchool;
        this.stuPhone = stuPhone;
        this.stuHome = stuHome;
        this.stuGraduation = stuGraduation;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuEducation() {
        return stuEducation;
    }

    public void setStuEducation(String stuEducation) {
        this.stuEducation = stuEducation;
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuHome() {
        return stuHome;
    }

    public void setStuHome(String stuHome) {
        this.stuHome = stuHome;
    }

    public String getStuGraduation() {
        return stuGraduation;
    }

    public void setStuGraduation(String stuGraduation) {
        this.stuGraduation = stuGraduation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuEducation='" + stuEducation + '\'' +
                ", stuSchool='" + stuSchool + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuHome='" + stuHome + '\'' +
                ", stuGraduation='" + stuGraduation + '\'' +
                '}';
    }
}
