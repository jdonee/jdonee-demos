/**
 * 测试用的Demo类的转换类
 */
package org.jdonee.cooking;

/**
 * @author ZengAihui
 * 
 */
public class PersonDto {
	private String name;
	private int age;

	public PersonDto() {
	}

	public PersonDto(String name, int age) {
		this.name = name;
		this.age = age;
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

	public String getDetails() {
		return "Name= " + name + "; Age= " + age;
	}

}
