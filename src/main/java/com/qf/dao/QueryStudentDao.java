package com.qf.dao;

import com.qf.domain.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

/**
 * @Author lx
 * @Date Create is 2018/1/27 15:09
 * @Modifyed By
 * @Description  演示各种操作
 */

public interface QueryStudentDao extends Repository<Student,Long>,JpaSpecificationExecutor<Student> {

    //方法名查询
    Student getById(Long id);

    //@Query注解的使用
    //执行jpql语句
    @Query("select s from Student s where s.id <10")
    public List<Student> query1();

    //执行修改操作
    @Modifying()
    @Query("update Student s set s.name=?1 where s.id=?2")
    public void update1(String name, Long id);

    //执行SQL语句
    @Query(nativeQuery = true,value = "select * from t_student where age >100")
    public List<Student> query2();

    @Modifying()
    @Query(nativeQuery = true,value = "update t_student set sex='男'")
    public void update2();

    //命名查询`
    public List<Student> query3();
    //动态查询  类似 QBC(Hibernate的动态查询方式，5.2.x被遗弃----)
    // public  List<Student> query4(Specification<Student> specification);

    public List<Student> queryStudent7();



}
