
package com.fiserv.keyword;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author dhiraj.bendale
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Keywords {
	/**
	 * Keyword description
	 * 
	 */
	String description();

	/**
	 * Assign category to keyword
	 * 
	 * @return
	 */
	String category() default "";

	/**
	 * Assign author to Keyword
	 * 
	 * @return
	 */
	String author();

	/**
	 * Assign tag to keyword use to provide addition info to user . e.g
	 * tag=Story234/feature-2012/smoke
	 * 
	 * @return
	 */
	String tag() default "";
}