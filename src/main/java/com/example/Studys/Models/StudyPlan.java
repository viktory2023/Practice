package com.example.Studys.Models;

public class StudyPlan {
    private Integer id;
    private String name;
    private Integer semester;
    private String isExam;
    private String teacher;
    private Integer hours;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setIsExam(String isExam) {
        this.isExam = isExam;
    }
    public String getIsExam() {
        return isExam;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getHours() {
        return hours;
    }
}

