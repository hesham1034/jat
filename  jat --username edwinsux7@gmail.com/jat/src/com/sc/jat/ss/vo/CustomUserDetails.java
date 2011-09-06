package com.sc.jat.ss.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sc.jat.ss.model.Users;

/**   
 * ClassName:UserDetails   
 * Function:创建UserDetails的实现类，本质为用户详细信息的一个载体 
 * 在实现类中可以进一步扩展属性
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
public class CustomUserDetails implements UserDetails {

	private Collection<GrantedAuthority> authorities;
	/**
	 * 用户id，在UserDetialManager中进行赋值
	 */
	private String id; 
	private String password;
	private String username;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private Users user;

	public CustomUserDetails(String id, String password, String username, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled, List<GrantedAuthority> gAuthoritys, Users user) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.authorities = gAuthoritys;
		this.user = user;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public String getId() {
		return id;
	}

	public Users getUser() {
		return user;
	}

}
