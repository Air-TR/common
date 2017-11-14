//package com.tr.common.utils.jdbc;
//
//import java.sql.Connection;
////import java.sql.ResultSet;
////import java.sql.ResultSetMetaData;
////import java.sql.Statement;
//
//import org.apache.commons.dbcp.BasicDataSource;
//
///**
// * 该类用于管理数据库连接 -- 简化版
// * 
// * @author taorun
// * @date 2017年11月14日 下午2:07:18
// *
// */
//
//public class DBUtil2 {
//	
//	// 数据库连接池
//	private static BasicDataSource ds;
//	
//	/**
//	 * 初始化静态属性
//	 */
//	static {
//		// 初始化连接池
//		ds = new BasicDataSource();
//		// 将JDBC建立连接所需要的信息设置到连接池中
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://114.55.86.125:3306/cpxx?autoReconnect=false&useUnicode=true&characterEncoding=utf-8&useSSL=false");
//		ds.setUsername("dev");
//		ds.setPassword("jlyc123456");
//	}
//	
//	/**
//	 * 获取数据库连接
//	 * @return
//	 */
//	public static Connection getConnection() throws Exception{
//		/**
//		 * 连接池提供的方法: Connection getConnection() 
//		 * 该方法可以返回一个连接池中可用连接。这是一个阻塞方法，当连接池中有空闲连接可以使用时会立刻返回，
//		 * 若当前连接池没有可用连接时，会进入阻塞，阻塞时间由创建连接池时通过setMaxWait设置的时间为准，
//		 * 在等待期间若有空闲连接着立即返回，当超过最大等待时间仍没有可用连接时，该方法会抛出超时异常。
//		 */
//		return ds.getConnection();
//	}
//	
//	/**
//	 * 关闭给定的连接
//	 * @param conn
//	 */
//	public static void closeConnection(Connection conn){
//		try {
//			/**
//			 * 若该连接是通过连接池获取的，那么调用这个连接的close方法并不是与数据库断开连接了，而仅仅是将该连接还给连接池。
//			 */
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) throws Exception {
//		Connection conn = DBUtil2.getConnection();
////		Statement state = conn.createStatement();
////		String sql = "select count(*) count from gcp_cloth_type_info";
////		ResultSet rs = state.executeQuery(sql);
////		rs.next();
////		int count = rs.getInt(1);
////		System.out.println(count);
//		System.out.println(conn);
//		DBUtil2.closeConnection(conn);
//	}
//	
//}
