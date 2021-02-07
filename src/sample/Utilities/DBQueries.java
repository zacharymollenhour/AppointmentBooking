package sample.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Project: QAM1-Software2-ZacharyMollenhour
 * Package: Utilities
 * <p>
 * Author: Zachary Mollenhour
 * Date: 2/6/2021
 * Time: 1:50 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class DBQueries {

    ///Store all Database Queries
    private static final String authorizeUser = "SELECT * FROM users WHERE User_Name = '";

    //Helper
    public static String createLoginQuery(String user, String password)
    {
        String loginQuery = authorizeUser + user + "' AND Password= '" + password + "'";
        return loginQuery;
    }

    public static String LoginQueryParse(ResultSet results, String parseVar)
    {

        try{
            if(results.next())
            {
                String resultSet = results.getString(parseVar);
                return resultSet;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return null;
    }
}
