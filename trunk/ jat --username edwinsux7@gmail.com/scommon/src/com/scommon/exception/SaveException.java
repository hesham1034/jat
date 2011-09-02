
/*   
 * @(#)SaveException.java 1.0 2011-6-26   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.scommon.exception;   
/**   
 * ClassName:SaveException   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    scommon1.0   
 * @Date     2011-6-26        上午11:47:46   
 *   
 */
@SuppressWarnings("serial")
public class SaveException extends RuntimeException{
	public SaveException(){
	}
	
	public SaveException(String msg){
		super(msg);
	}

	public SaveException(String message, Throwable cause) {
		super(message, cause);   
	}

	public SaveException(Throwable cause) {
		super(cause);   
	}
}
   
