package com.qf.dao;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import com.qf.domain.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JPA的使用
public interface StudentDao  extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student>{

    //jpql的使用
    @Query("select s from Student s")
    public List<Student> getAll();

    //jpql条件
    @Query("select s from Student s where s.id between 1 and 20 order by s.id desc")
    public List<Student> getAll2();

    //方法名查询
    public Student getById(Long id);
    public List<Student> getByAgeBetween(int minx, int max);

    //@SQLUpdate("update Student ")
}
