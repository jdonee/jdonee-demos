/**
 * 测试用的Demo类
 */
package org.jdonee.cooking;

/**
 * @author ZengAihui
 * 
 */
public class Person {
	private int id;
	private String name;
	private int age;
	private String city;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(int id, String name, int age, String city) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDetails() {
		return "ID= " + id + "; Name= " + name + "; Age= " + age + "; City= " + city;
	}

}
