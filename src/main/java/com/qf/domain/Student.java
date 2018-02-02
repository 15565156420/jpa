package com.qf.domain;
import javax.persistence.*;

//
@Entity
@Table(name = "t_student")
//命名查询
@NamedQueries({
		@NamedQuery(name = "Student.query3", query= "select s from Student s"),

		@NamedQuery(name= "Student.queryStudent7", query="select s from Student s where s.id=7")

})
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String name;

	private int age;

	@Column(length = 2)
	private String sex;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
