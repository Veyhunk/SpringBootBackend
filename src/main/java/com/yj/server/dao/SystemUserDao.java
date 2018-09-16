package com.yj.server.dao;

import org.apache.ibatis.annotations.Mapper;
/**
 * 
*    
* 功能描述：   用户信息数据库操作
* 创建人：Administrator   
* 创建时间：2018年9月16日 上午1:19:56     
* @version    
*
 */

import com.yj.server.model.SystemUser;

@Mapper
public interface SystemUserDao {
	/**
	 * 根据用户名查询
	 * 
	 * @param userName
	 * @return
	 */
	SystemUser searchUserByName(String userName);

	/**
	 * 根据手机号查询
	 * 
	 * @param phone
	 * @return
	 */
	SystemUser searchUserByPhone(String phone);
}
