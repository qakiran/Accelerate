/**
 * 
 */
package com.fiserv.framework.utility.database;

/**
 * @author dhiraj.bendale
 *
 */
public interface Database {

	void getConnection();
	public void getQueryData(String query);
	public int insertOrUpdate(String query);
}
