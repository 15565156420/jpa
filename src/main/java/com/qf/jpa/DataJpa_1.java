package com.qf.jpa;

import com.qf.domain.Student;
import com.qf.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


//
public class DataJpa_1 {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		test2(context);
	}
	//基本使用--新增和查询
	private static void test1(ApplicationContext context){
		//System.out.println("OK");
		StudentService studentService=context.getBean(StudentService.class);
		System.out.println(studentService);

		for(int i=1;i<100;i++){
			Student student=new Student();
			student.setName("name"+i);
			student.setSex("男");
			student.setAge(i);
			studentService.save(student);
		}

		System.out.println(studentService.getAll());
	}

	//删除、分页、排序
	private static void test2(ApplicationContext context){
		StudentService service=context.getBean(StudentService.class);
		//System.out.println("删除："+service.delete(2l));
		//创建分页类对象，并设置当前页和煤业显示的数量
		Pageable pageable=new PageRequest(0,20);

		Page<Student> page=service.getAllByPage(pageable);

		System.out.println("条数："+page.getTotalElements()+"-->"+"页数"+page.getTotalPages());
		System.out.println("分页内容："+page.getContent());

		//创建排序对象。并指定排序自动和规则
		Sort sort=new Sort(Sort.Direction.DESC,"age");
		System.out.println("排序："+service.getAllBySort(sort));

	}

	/**
	 * 分页
	 * 排序
	 * @param context
	 */
	private static void testpage(ApplicationContext context){
		StudentService service=context.getBean(StudentService.class);
		Pageable pageable=new PageRequest(0,10);
		Page<Student> page=service.getAllByPage(pageable);

		System.out.println();
		page.getTotalElements();
		page.getTotalPages();
		page.getContent();

		Sort sort=new Sort(Sort.Direction.DESC,"age");
		service.getAllBySort(sort);

	}


	//JPQL的使用
	public static void test3(ApplicationContext context){
		StudentService service=context.getBean(StudentService.class);
		System.out.println("JPQL:"+service.getAllByJPQL());
		System.out.println("JPQL带上条件:"+service.getAllByJPQL2());
		System.out.println("专业查询接口的动态查询："+service.findOne("20"));
	}


	public static void test4(ApplicationContext context) {
		StudentService service = context.getBean(StudentService.class);
		System.out.println("方法名查询："+service.getById(44l));
		System.out.println("方法名查询："+service.getByAgeBetween(60,80));
	}

}
