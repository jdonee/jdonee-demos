/**
 * 
 */
package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import java.util.List;

import org.jdonee.cooking.Person;
import org.jdonee.cooking.PersonData;
import org.jdonee.cooking.PersonDto;

/**
 * @author ZengAihui
 *         通过project方法来转换两个不同对象的列表,用来替换convert方法，使用起来更简便
 * 
 */
public class Projects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<PersonDto> filteredPersonDtos = project(PersonData.getTestData(), PersonDto.class, on(Person.class)
				.getName(), on(Person.class).getAge());

		for (PersonDto person : filteredPersonDtos) {
			System.out.println(person.getDetails());
		}

	}

}
