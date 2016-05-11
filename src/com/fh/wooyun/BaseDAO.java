package com.fh.wooyun;

import com.avatar.db.DBFactory;
import com.avatar.db.jdbc.JdbcHandler;

/**
 * 数据库DAO操作基类
 */
public class BaseDAO
{
	/**
	 * 数据库操作对象
	 */
	protected JdbcHandler	dbHander	= null;

	/**
	 * 默认构造函数
	 */
	public BaseDAO() {
		dbHander = DBFactory.create("default");
	}

	/**
	 * 判断数据库连接是否正常
	 * 
	 * @param sql 语句
	 * @return 用户集合
	 */
	public boolean isConnection()
	{
		return dbHander.isConnectionReachable();
	}
	
	public static void main(String[] args){
	    BaseDAO baseDao = new BaseDAO();
	    System.out.println(baseDao.isConnection());
	}
}
