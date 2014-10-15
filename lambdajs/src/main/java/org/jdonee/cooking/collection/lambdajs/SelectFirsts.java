/**
 * 
 */
package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import org.hamcrest.core.StringContains;
import org.jdonee.cooking.Person;
import org.jdonee.cooking.PersonData;

/**
 * @author ZengAihui
 *         通过selectFirst方法获取列表中符合条件第一个对象
 * 
 */
public class SelectFirsts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person filteredPerson = selectFirst(PersonData.getTestData(),
				having(on(Person.class).getCity(), StringContains.containsString("Indonesia")));// 包含Indonesia城市名的个人用户
		// -------------------------------------------------------------------------------------------
		System.out.println(filteredPerson.getDetails());
	}

}
