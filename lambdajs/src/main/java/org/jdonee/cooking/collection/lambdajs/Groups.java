package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import java.util.Set;

import org.jdonee.cooking.Person;
import org.jdonee.cooking.PersonData;

import ch.lambdaj.group.Group;

/**
 * 
 * @author ZengAihui
 *         通过group方法对List的某个字段进行分组。Group应该算是变形的Map。
 */
public class Groups {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Group<Person> groupAgeOfPerson = group(PersonData.getTestData(), by(on(Person.class).getAge()));// by类似SQL的GROUP
																										// BY
		Set<String> groupAgeKeys = groupAgeOfPerson.keySet();
		// -------------------------------------------------------------------------------------------
		System.out.println("groupAgeKeys: " + groupAgeKeys);
		System.out.println("groupOfAge: " + groupAgeOfPerson.find(22));

		for (String ageKey : groupAgeKeys) {
			for (Person person : groupAgeOfPerson.find(ageKey)) {
				System.out.println(person.getDetails());
			}
		}
	}
}
