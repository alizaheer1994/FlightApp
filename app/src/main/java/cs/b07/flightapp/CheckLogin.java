package cs.b07.flightapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zaheeral on 11/26/2016.
 */
public class CheckLogin {

    static String userName;
    static String passWord;

    public CheckLogin(String userName, String passWord){
        userName = this.userName;
        passWord = this.passWord;
    }

    public static boolean loginChecker(Context context){


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open("clients.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                String[] mLineSplit = mLine.split(";");

                if (mLineSplit[2] == userName){
                    boolean passwordCheckerBoolean = passWordCheck(mLineSplit);

                    if (passwordCheckerBoolean){
                        return true;
                    }else{
                        return false;
                    }

                }

            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return false;
    }

    public static boolean passWordCheck(String[] mLineSplit){
        try {
            if (mLineSplit[6] == passWord){
                return true;
            }
        }catch (NullPointerException e){
            return true;
        }finally {
            return false;
        }
    }

}
