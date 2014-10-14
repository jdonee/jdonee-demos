/**
 * 
 */
package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import java.util.List;

import org.hamcrest.core.IsEqual;
import org.jdonee.cooking.Person;
import org.jdonee.cooking.PersonData;

/**
 * @author ZengAihui
 *         通过IsEqual.equalTo匹配某个字段，然后通过select返回匹配的列表，
 *         最后通过extract方法抽取出单个字段组成新的列表。
 */
public class ExtractSelects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> filteredPersonNames = extract(
				select(PersonData.getTestData(), having(on(Person.class).getAge(), IsEqual.equalTo(22))),
				on(Person.class).getName());// 年龄等于22岁的人的姓名

		// -------------------------------------------------------------------------------------------
		System.out.println("filteredPersonNames: " + filteredPersonNames);

	}

}
