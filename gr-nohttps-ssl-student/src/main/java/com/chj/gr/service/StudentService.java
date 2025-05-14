package com.chj.gr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chj.gr.entity.StudentEntity;

@Service
public class StudentService {

    public List<StudentEntity> getAllStudents(){
        List<StudentEntity> students = new ArrayList<>();
//        StudentEntity student1 = StudentEntity.builder().department("Science").studentId(1).studentName("Athos").build();
//        StudentEntity student2 = StudentEntity.builder().studentName("Porthos").studentId(2).department("Commerce").build();
//        StudentEntity student3 = StudentEntity.builder().department("Arts").studentId(3).studentName("Aramis").build();
        
        StudentEntity student1 = new StudentEntity();
        student1.setStudentId(1);
        student1.setStudentName("Athos");
        
        StudentEntity student2 = new StudentEntity();
        student2.setStudentId(2);
        student2.setStudentName("Porthos");
        
        StudentEntity student3 = new StudentEntity();
        student3.setStudentId(3);
        student3.setStudentName("Aramis");
        
        students.add(student1);
        students.add(student2);
        students.add(student3);
        return students;
    }
}
