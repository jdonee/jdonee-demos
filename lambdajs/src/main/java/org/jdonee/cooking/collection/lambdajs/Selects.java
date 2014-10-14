package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import java.util.List;

import org.hamcrest.core.StringContains;
import org.jdonee.cooking.Person;
import org.jdonee.cooking.PersonData;

/**
 * 
 * @author ZengAihui
 *         首先通过StringContains.containsString查找某个字符串是否包含在字段里，然后通过select组合成新的List。
 */
public class Selects {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> filteredPerson = select(PersonData.getTestData(),
				having(on(Person.class).getCity(), StringContains.containsString("Indonesia")));// 包含Indonesia城市名的个人用户
		// -------------------------------------------------------------------------------------------
		for (Person person : filteredPerson) {
			System.out.println(person.getDetails());
		}
	}
}
