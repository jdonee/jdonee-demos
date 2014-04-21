/**
 * 
 */
package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;
import static org.hamcrest.Matchers.*;

import org.jdonee.cooking.*;

import ch.lambdaj.function.closure.*;

/**
 * @author ZengAihui
 *         通过方法转换器自定义处理函数返回
 */
public class Switchers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Switcher<String> switcher = new Switcher<String>().addCase(new Person("me", 36), "me")
				.addCase(having(on(Person.class).getAge(), lessThan(30)), "young")
				.addCase(having(on(Person.class).getAge(), greaterThan(70)), "old").setDefault("adult");

		System.out.println(switcher.exec(new Person("me", 36))); // result == "me";??
		System.out.println(switcher.exec(new Person("sister", 23))); // result == "adult";
		System.out.println(switcher.exec(new Person("dad", 71))); // result == "old";
	}

}
