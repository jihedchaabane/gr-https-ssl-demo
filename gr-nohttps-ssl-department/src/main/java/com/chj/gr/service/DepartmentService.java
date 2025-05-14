package com.chj.gr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chj.gr.clients.StudentClient;
import com.chj.gr.entity.DepartmentEntity;

@Service
public class DepartmentService {

	@Autowired
	private StudentClient studentClient;
	
    public List<DepartmentEntity> getAllDepartments(){
        List<DepartmentEntity> departments = new ArrayList<>();
        
        DepartmentEntity scienceDept = new DepartmentEntity();
        scienceDept.setDepartmentId("1");
        scienceDept.setDepartmentName("Science");
        scienceDept.setStudents(studentClient.getBarEureka());
        
        departments.add(scienceDept);
        return departments;
    }
}
