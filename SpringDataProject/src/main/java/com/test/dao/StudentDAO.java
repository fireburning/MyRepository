package com.test.dao;

import com.test.entity.Student;

import java.util.List;

/**
 * Created by zhang on 2017/6/6.
 */
public interface StudentDAO {

    List<Student> query();

    void save(Student student);
}
