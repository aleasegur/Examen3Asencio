package Ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class MyMethodsDB {
    private static final String dir="resources/db.properties";
    private static String USER;
    private static String URL;
    private static String PASS;


    public static void loadProperties(){
        Properties properties=new Properties();
        try(InputStream iS= Files.newInputStream(Paths.get(dir))) {
            properties.load(iS);
            URL=properties.getProperty("db.url");
            USER=properties.getProperty("db.user");
            PASS=properties.getProperty("db.password");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public static String getUSER() {
        return USER;
    }

    public static String getURL() {
        return URL;
    }

    public static String getPASS() {
        return PASS;
    }

}
