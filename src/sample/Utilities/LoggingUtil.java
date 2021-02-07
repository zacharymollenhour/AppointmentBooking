package sample.Utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;

/**
 * Project: QAM1-Software2-ZacharyMollenhour
 * Package: Utilities
 * <p>
 * Author: Zachary Mollenhour
 * Date: 2/6/2021
 * Time: 2:10 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class LoggingUtil {

    private static final String PathName = "errorlog.txt";

    public static void WriteError(String username, boolean success)
    {
        try(
            FileWriter fileWrite = new FileWriter(PathName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
            PrintWriter printWriter = new PrintWriter(bufferedWriter))
        {
            printWriter.println(ZonedDateTime.now() + " " + username + (success ? " Success" : " Failure" ));
        }
        catch(IOException e)
        {
            System.out.println("Log Error: " + e.getMessage());
        }
    }
}
