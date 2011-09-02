
/*   
 * @(#)DeleteException.java 1.0 2011-6-26   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.scommon.exception;   
/**   
 * ClassName:DeleteException   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    scommon1.0   
 * @Date     2011-6-26        上午11:51:59   
 *   
 */
public class DeleteException extends RuntimeException{

	public DeleteException() {
		super();   
	}

	public DeleteException(String message, Throwable cause) {
		super(message, cause);   
	}

	public DeleteException(String message) {
		super(message);   
	}

	public DeleteException(Throwable cause) {
		super(cause);   
	}

}
   
