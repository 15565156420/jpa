package com.qf.service;

import com.qf.dao.QueryStudentDao;
import com.qf.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Author lx
 * @Date Create is 2018/1/27 15:26
 * @Modifyed By
 * @Description
 */
@Service
@Transactional
public class QueryStudentService {

    @Autowired
    private QueryStudentDao dao;


    //方法名查询
    public Student getId(Long id){
        return dao.getById(id);
    }


    public List<Student> query1(){
        return dao.query1();
    }
    //执行修改操作
    public void update1(String name,Long id){
         dao.update1(name,id);
    }

    //执行SQL语句
    public List<Student> query2(){
        return  dao.query2();
    }

    //命名查询
    public List<Student> query3(){
        return dao.query3();
    }

    public List<Student> queryStudent7(){
        return dao.queryStudent7();
    }

    //动态查询  类似 QBC(Hibernate的动态查询方式，5.2.x被遗弃----)
    public  List<Student> query4(String n){
        Specification<Student> specification=new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name").as(String.class),"%"+n+"%");
            }
        };
        return dao.findAll(specification);
    }


    public void update2(){
        dao.update2();
    }



}
