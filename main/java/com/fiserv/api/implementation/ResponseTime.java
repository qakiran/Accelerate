package com.fiserv.api.implementation;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to validate response time SLA
 */

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import com.fiserv.framework.api.interfaces.IResponseTime;
import com.fiserv.api.utils.Comparison;

public class ResponseTime implements IResponseTime{

	private int respTime;
	private TimeUnit timeUnit;
	private static ResponseTime instance = null;
	private static Logger logger = Logger.getLogger(ResponseTime.class);
	private Comparison compare = Comparison.getInstance();
	

	protected ResponseTime() {
		// Set access modifier protected for default constructor to achieve
		// Singleton Pattern
	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the ResponseTime
	 */
	public static ResponseTime getInstance() {
		if (null == instance) {
			instance = new ResponseTime();
		}
		return instance;
	}

	/**
	 * This function is setter method for REST response time
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param responseTime
	 *            Response time to be passed as integer
	 */
	public void setRespTime(int responseTime) {
		this.respTime = responseTime;
		logger.debug("Response time value set : " + responseTime);
	}

	/**
	 * This function is getter method for REST response time
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Response time as integer
	 */
	public int getRespTime() {
		return respTime;
	}

	/**
	 * This function is setter method for time unit of REST response time
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param timeUnit
	 *            Time Unit to be passed as TimeUnit
	 */
	public void setRespTimeUnit(TimeUnit timeUnit) {
		logger.debug("Response time unit set : " + timeUnit);
		this.timeUnit = timeUnit;
	}

	/**
	 * This function is getter method for time unit of REST response time
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Time Unit as TimeUnit
	 */
	private TimeUnit getRespTimeUnit() {
		return timeUnit;
	}

	/**
	 * This function validates Response time value for less than or equal to
	 * expected value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param responseTime
	 *            Response Time as Object Type
	 */
	public void isLessOrEqualTo(Object responseTime) {
		logger.info("Validating response time - Less than or equal to - Time Unit " + getRespTimeUnit());
		compare.lessOrEqualsTo((Object) responseTime, (Object) getRespTime());
	}

	/**
	 * This function validates Response time value for Greater than or equal to
	 * expected value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param responseTime
	 *            Response Time as Object Type
	 */
	public void isGreaterOrEqualTo(Object responseTime) {
		logger.info("Validating response time - Greater than or equal to - Time Unit " + getRespTimeUnit());
		compare.greatOrEqualsTo((Object) responseTime, (Object) getRespTime());
	}

}
