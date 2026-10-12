package com.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;
import com.entity.Course;

public class MainClass {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Course.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        Course c1 = new Course();
        c1.setCourseId(101);
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourseId(102);
        c2.setCourseName("SQL");

        Student s1 = new Student();
        s1.setStudentId(1);
        s1.setStudentName("Rahul");

        Student s2 = new Student();
        s2.setStudentId(2);
        s2.setStudentName("Priya");

        Set<Course> set1 = new HashSet<Course>();
        set1.add(c1);
        set1.add(c2);
        s1.setCourses(set1);

        Set<Course> set2 = new HashSet<Course>();
        set2.add(c1);
        s2.setCourses(set2);

        ss.persist(c1);
        ss.persist(c2);
        ss.persist(s1);
        ss.persist(s2);

        System.out.println("Inserted ...!");

        tr.commit();
        ss.close();
        sf.close();
    }
}