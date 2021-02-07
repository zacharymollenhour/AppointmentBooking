package sample.Utilities;

import sample.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import static sample.Utilities.DBQueries.LoginQueryParse;
import static sample.Utilities.DBQueries.createLoginQuery;

/**
 * Project: QAM1-Software2-ZacharyMollenhour
 * Package: Models
 * <p>
 * Author: Zachary Mollenhour
 * Date: 2/6/2021
 * Time: 1:38 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class LoginUser {

    //User Object
    public static User ActiveUser;

    public static Boolean Login(String checkUsrName, String checkPssWord) {
        try{
            Statement sqlStatement = DBConfig.OpenConnection().createStatement();
            String query = createLoginQuery(checkUsrName,checkPssWord);
            ResultSet authLogin = sqlStatement.executeQuery(query);

            String resultString = LoginQueryParse(authLogin, "User_Name");
            if(resultString != null)
            {
                ActiveUser = new User();
                ActiveUser.setUserName(resultString);

                sqlStatement.close();

                LoggingUtil.WriteError(ActiveUser.getUserName(), true);
                return true;
            }
            else
            {
                LoggingUtil.WriteError(ActiveUser.getUserName(), false);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return false;
        }

    }
}
