package com.company;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
	    System.out.println(generate(length));


    }

    public static void connectDb(){
        Connection c = null;
        Statement stmt = null;

        try {
            //Connect
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:passwords.db");
            System.out.println("Opened database successfully");

//            stmt = c.createStatement();
//            String sql = "CREATE TABLE passwords" +
//                    "(ID INT PRIMARY KEY     NOT NULL," +
//                    " URL           TEXT    NOT NULL, " +
//                    " PASSWORD      TEXT     NOT NULL) ";
//
//            stmt.executeUpdate(sql);
//            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }

    public static void insertDate(){
        connectDb();
        stmt = c.createStatement();
        String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
        stmt.executeUpdate(sql);
    }

    public static char[] generate(int len){
        System.out.println("Generated password...");
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_-=+?/<>,.;";

        Date date = new Date();
        String time = date.toString().replaceAll("\\s", "");

        String values = Capital_chars + Small_chars + numbers + symbols + time;

        Random rndm_method = new Random();
        char[] password = new char[len];
        for (int i = 0; i < len; i++){
            password[i] = values.charAt(rndm_method.nextInt(values.length()));
        }
        return password;
    }
}
