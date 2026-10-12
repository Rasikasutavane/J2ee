package com.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {

    @Id
    private int studentId;

    private String studentName;

    @ManyToMany
    private Set<Course> courses = new HashSet<>();

    public Student() {
        super();
    }

    public Student(int studentId, String studentName, Set<Course> courses) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.courses = courses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId
                + ", studentName=" + studentName + "]";
    }
}