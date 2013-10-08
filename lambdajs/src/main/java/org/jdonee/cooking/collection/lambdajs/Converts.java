/**
 * 
 */
package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import java.util.List;

import org.jdonee.cooking.Person;
import org.jdonee.cooking.PersonData;
import org.jdonee.cooking.PersonDto;

import ch.lambdaj.function.convert.Converter;

/**
 * @author ZengAihui
 *         通过convert方法转换两个不同对象的列表
 */
public class Converts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<PersonDto> filteredPersonDtos = convert(PersonData.getTestData(), new Converter<Person, PersonDto>() {
			@Override
			public PersonDto convert(Person f) {
				return new PersonDto(f.getName(), f.getAge());
			}
		});

		for (PersonDto person : filteredPersonDtos) {
			System.out.println(person.getDetails());
		}
	}

}
