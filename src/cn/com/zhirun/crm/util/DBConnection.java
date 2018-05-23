package cn.com.zhirun.crm.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection conn;
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        if(conn==null){
            InputStream is = DBConnection.class.getResourceAsStream("/db.properties");
            Properties properties = new Properties();
            properties.load(is);
            String dbDriver = properties.getProperty("dbDriver");
            String dbUrl = properties.getProperty("dbUrl");
            String dbUser = properties.getProperty("dbUser");
            String dbPwd = properties.getProperty("dbPwd");
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        }
        return conn;
    }
}
