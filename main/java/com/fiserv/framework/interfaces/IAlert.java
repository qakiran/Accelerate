/**
 * 
 */
package com.fiserv.framework.interfaces;

/**
 * @author Dhiraj.Bendale
 *
 */
public interface IAlert {
	boolean alertIsPresent();

	boolean alertIsPresentinTime(int time);

	void close();

	void accept();

	void switchToAlert();

}
