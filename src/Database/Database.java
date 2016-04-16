/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author yunitarp2706
 */
public class Database {
    private Connection conn;
    private Statement sta;

    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tubes", "root", "");
            sta = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Buat Manipulasi Data (Insert, update, delete)
     * @param query
     * @return 
     */
    public boolean manipulate(String query)
    {
        try {
            if (sta.executeUpdate(query) >= 1)
            {
                return true;
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    /**
     * GetData berdasarkan query (Select)
     * @param query
     * @return 
     */
    public ResultSet getData(String query)
    {
        try {
            return sta.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
       
    }
    
    public void disconnect()
    {
        try {
            sta.close();
            conn.close();
        } catch (Exception e) {
        }
    }
            
    
    
}
