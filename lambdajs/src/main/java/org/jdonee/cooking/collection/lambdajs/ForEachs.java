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
 *         通过forEach方法批量变更某个字段的值
 */
public class ForEachs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> persons = PersonData.getTestData();
		// -------------------------------------------------------------------------------------------
		System.out.println("changing before--------------");
		for (Person person : persons) {
			System.out.println(person.getDetails());
		}
		forEach(persons).setAge(31);
		System.out.println("changing after--------------");
		for (Person person : persons) {
			System.out.println(person.getDetails());
		}
	}

}
