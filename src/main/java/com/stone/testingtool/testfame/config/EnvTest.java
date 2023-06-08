package com.stone.testingtool.testfame.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author guocang.shi
 */
public class EnvTest {

    private static String url;
    private static String key;
    private static String value;

    private static String user;
    private static String password;
    private static String worktaken;

    static  {

        String keyenv="dev";
        String keyValue="dev";
        Properties prop = new Properties();
        InputStream in = Object.class.getResourceAsStream("/config.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(keyenv.equals(prop.getProperty(keyValue))) {
            url = prop.getProperty("URL").trim();
        }
        else
        {
            url = prop.getProperty("WORK_URL").trim();
        }
        key = prop.getProperty("APIKEY").trim();
        value= prop.getProperty("TOKE").trim();
        user = prop.getProperty("USER").trim();
        password= prop.getProperty("PASSWORD").trim();
        worktaken = prop.getProperty("WORKTOKN").trim();
    }

    //获取url

    public static String getUrl() {
        return url;
    }
    //获取key

    public static String getKey() {
        return key;
    }
    //获取value

    public static String getValue() {
        return value;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getworktaken() {
        return worktaken;
    }
}
