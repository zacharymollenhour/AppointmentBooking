package sample.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Project: QAM1-Software2-ZacharyMollenhour
 * Package: Utilities
 * <p>
 * Author: Zachary Mollenhour
 * Date: 2/6/2021
 * Time: 1:40 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class DBConfig {

    //Database Configuration
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://wgudb.ucertify.com/WJ07xwX";

    //Login Properties
    static final String UserName = "U07xwX";
    static final String Password = "53689163256";
    static final String Database = "Wj07xwX";
    static Connection sqlConn;


    public static Connection OpenConnection() {
        try {
            Class.forName(JDBC_Driver);
            sqlConn = DriverManager.getConnection(DB_URL, UserName, Password);

        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found " + e.getMessage());
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return sqlConn;
    }


}
