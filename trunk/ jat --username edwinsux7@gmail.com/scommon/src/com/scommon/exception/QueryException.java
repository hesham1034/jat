
/*   
 * @(#)QueryException.java 1.0 2011-6-26   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.scommon.exception;   
/**   
 * ClassName:QueryException   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    scommon1.0   
 * @Date     2011-6-26        上午11:55:29   
 *   
 */
public class QueryException extends RuntimeException{

	public QueryException() {
		super();   
	}

	public QueryException(String message, Throwable cause) {
		super(message, cause);   
	}

	public QueryException(String message) {
		super(message);   
	}

	public QueryException(Throwable cause) {
		super(cause);   
	}
}
   
