package org.jdonee.cooking;

import java.util.Arrays;
import java.util.List;

public class PersonData {

	/**
	 * 测试集合
	 * 
	 * @return
	 */
	public static List<Person> getTestData() {
		List<Person> persons = Arrays.asList(new Person(13, "Steve", 22, "London, UK"), new Person(25, "Greg", 28,
				"New York, USA"), new Person(5, "Emily", 22, "Bali, Indonesia"), new Person(9, "Malih", 14,
				"Jakarta, Indonesia"));
		return persons;
	}

}
