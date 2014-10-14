/**
 * 
 */
package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import java.util.Map;

import org.jdonee.cooking.Person;
import org.jdonee.cooking.PersonData;

/**
 * @author ZengAihui
 *         通过index方法在List的对象类中抽取一个字段设置成Key重新组合Map，
 *         注:key仅限于对象类型。
 */
public class Indexs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// -------------------------------------------------------------------------------------------
		Map<Integer, Person> personMap = index(PersonData.getTestData(), on(Person.class).getId());
		// -------------------------------------------------------------------------------------------
		System.out.println("Person name with ID 5: " + personMap.get(5).getName());
	}

}
