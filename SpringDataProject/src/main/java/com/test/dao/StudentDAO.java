package com.test.dao;

import com.test.entity.Student;

import java.util.List;

/**
 * Created by zhangxs on 2017/6/5.
 */
public interface StudentDAO {
    List<Student> query();

    void save(Student student);
}
