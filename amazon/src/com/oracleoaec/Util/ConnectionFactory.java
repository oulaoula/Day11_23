package  com.oracleoaec.Util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 四要素获得连接
 * @author kick
 *
 */
public class ConnectionFactory {
	private static String DRIVERNAME = null;
	private static String URL = null;
	private static String USER = null;
	private static String PWD = null;
	private static Connection con = null;
	static{
		Properties pt = new Properties();
		InputStream ins = ConnectionFactory.class.getResourceAsStream("jdbcinfo.properties");
		try {
			pt.load(ins);//从jdbcinfo.properties中获取值
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(ins != null){
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		DRIVERNAME = pt.getProperty("oracle.driver");//获取driver
		URL = pt.getProperty("oracle.url");//获取url
		USER = pt.getProperty("oracle.user");//获取用户名
		PWD = pt.getProperty("oracle.pwd");//获取密码
	}
	public static Connection getConnection(){
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USER, PWD);//获取数据库链接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
