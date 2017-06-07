package com.test.repository;

import com.test.entity.Employee;
import org.springframework.data.repository.Repository;


/**
 * Created by zhang on 2017/6/7.
 */
public interface EmployeeRepository extends Repository<Employee,Integer> {

    Employee findByName(String name);
}
