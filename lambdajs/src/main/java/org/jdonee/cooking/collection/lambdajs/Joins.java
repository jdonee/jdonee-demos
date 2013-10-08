/**
 * 
 */
package org.jdonee.cooking.collection.lambdajs;

import static ch.lambdaj.Lambda.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZengAihui
 *         使用Join构建查询语句
 */
public class Joins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hari1", "hari2", "hari3", "hari4");
		// -------------------------------------------------------------------------------------------
		String result = join(list, "','");
		String query = "SELECT t FROM t_person t WHERE "
				+ (result.length() > 0 ? "t.name IN ('" + result + "')" : "0=0");
		// -------------------------------------------------------------------------------------------
		System.out.println(query);
	}

}
