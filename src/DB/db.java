package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class db {

    private static Connection conn = null;

    public static Connection getConn() {
        if (conn == null){
            try {
                Properties props = loadProp();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url,props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConn(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }


    private static Properties loadProp (){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs); //quarda a leitura do arquivo fs, dentr do obj props
            return props;
        }
        catch (IOException e){
            throw new DbException(e.getMessage());

        }

    }

    public static void closeStatment(Statement st){
        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}


