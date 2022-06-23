package it.accenture.firstweek.exceptionsExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class ExceptionTutorial {
    public static void main(String[] args) {
        System.out.println("Inizio main");
        //try {
            f1();
        //} catch (FileNotFoundException e) {
          //  System.out.println("File not found.");
        //}
        System.out.println("Fine main");
    }

    private static void f1(){
        System.out.println("Inizio f1");
        try {
            f2();
        } catch (FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } //finally { //esegue comunque alla fine, a prescindere dal catch

        //}
        /*
        //versione brutta ma corretta
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */
        /*
        // pessima idea: gestisce anche errori di programmazione come NullPointerException
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

         */

        System.out.println("Fine f1");
    }

    private static void f2() throws FileNotFoundException, SQLException {
        System.out.println("Inizio f2");
        FileInputStream fis = new FileInputStream("nonEsisto.txt");
        int x = 3;
        int y = 4;
        FileInputStream fis2 = new FileInputStream("nonEsisto2.txt");
        Connection c = DriverManager.getConnection("", "", "");
        /*
        try {
            FileInputStream fis = new FileInputStream("nonEsisto.txt");
        } catch (FileNotFoundException e) {
            //System.out.println(e.getMessage());
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
         */
        System.out.println("Fine f2");
    }

    public static void readFromDb() {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try{
            c = DriverManager.getConnection("","","");
            s = c.createStatement();
            String sql = "SELECT * FROM employees";
            rs = s.executeQuery(sql);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(rs != null ) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void betterReadFromDb() {
        String sql = "SELECT * FROM employees";
        try(Connection c = DriverManager.getConnection("","","");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
        ){
            while(rs.next()){}
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
