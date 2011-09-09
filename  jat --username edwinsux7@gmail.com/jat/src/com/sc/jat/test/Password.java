
package com.sc.jat.test;   

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**   
 * ClassName:Password   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-9-7   
 * @since    jat1.0   
 */
public class Password {
	public static void main(String[] args){
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String pwd = md5.encodePassword("boss", "boss");
		System.out.println(pwd);
	}
}
   
