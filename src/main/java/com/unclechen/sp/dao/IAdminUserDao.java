/**
 * 
 */
package com.unclechen.sp.dao;

import java.util.List;

import com.unclechen.sp.domain.AdminUser;


/**
 * @author unclechen
 */
public interface IAdminUserDao {

	

	/**
	 * 登陆,成功返回用户信息,失败返回null
	 * 
	 * @param username
	 * @param passwd
	 * @return
	 */
	public AdminUser logIn(AdminUser user);
  
  /**
   * 修改登录时间
   * @return
   */
  public int updateLastTime(int id);
  
}
