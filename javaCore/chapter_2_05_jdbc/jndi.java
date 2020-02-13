package chapter_2_05_jdbc;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

/*
 * use for JavaEE:
 * @Resource(name="jdbc/corejava")
 * private DataSource source;
 * */

public class jndi {
	
	public static void main(String[] args) throws NamingException {
		Context jndiContext = new InitialContext();
		DataSource source = (DataSource)jndiContext.lookup("java:comp/env/jdbc/corejava");
		try {
			Connection conn = source.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
