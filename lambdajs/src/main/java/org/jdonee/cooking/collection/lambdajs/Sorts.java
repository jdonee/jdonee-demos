/**
 * 
 */
package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import java.util.List;

import org.jdonee.cooking.Person;
import org.jdonee.cooking.PersonData;

/**
 * @author ZengAihui
 *         根据sort方法对列表进行排序
 */
public class Sorts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> persons = PersonData.getTestData();
		// -------------------------------------------------------------------------------------------
		System.out.println("sorting before--------------");
		for (Person person : persons) {
			System.out.println(person.getDetails());
		}
		persons = sort(persons, on(Person.class).getAge());// 默认升序
		System.out.println("sorting after--------------");
		for (Person person : persons) {
			System.out.println(person.getDetails());
		}
		persons = sort(persons, on(Person.class).getAge(), 1);// 倒序排列
		System.out.println("sorting after--------------");
		for (Person person : persons) {
			System.out.println(person.getDetails());
		}
	}

}
