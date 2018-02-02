package com.qf.service;

import com.qf.dao.StudentDao;
import com.qf.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @Author lx
 * @Date Create is 2018/1/27 11:41
 * @Modifyed By
 * @Description
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao dao;


    //新增
    public void save(Student student){
        dao.save(student);


    }
    //查询
    public List<Student> getAll(){
        return dao.findAll();
    }
    //删除
    public boolean delete(Long id){
        dao.delete(id);
        return true;
    }
    //排序
    public List<Student> getAllBySort(Sort sort){
        return  dao.findAll(sort);
    }
    //分页
    public Page<Student> getAllByPage(Pageable pageable){
        return  dao.findAll(pageable);
    }

    //jpql语句
    public List<Student> getAllByJPQL(){
        return  dao.getAll();
    }
    public List<Student> getAllByJPQL2(){
        return  dao.getAll2();
    }

    //专业查询接口的方法
    public List<Student> findOne(String name){
        //动态查询
        Specification<Student> studentSpecification=new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                 //criteriaQuery.where()
                 return  criteriaBuilder.and(criteriaBuilder.like(root.get("name").as(String.class),"%"+name+"%"),
                         criteriaBuilder.gt(root.get("age").as(Integer.class),30));
            }
        };

        return  dao.findAll(studentSpecification);
    }
    //使用方法名进行查询
    public Student getById(Long id){

        return  dao.getById(id);
    }
    public List<Student> getByAgeBetween(int minx,int max){
        return dao.getByAgeBetween(minx,max);
    }

}
