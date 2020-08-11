package Utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexion {
    private Connection jdbcConnection;

    
    public Conexion() {
	 
		this.jdbcConnection = null;
	}

	public void conectar() throws SQLException {

        try { 
        	jdbcConnection = DriverManager.getConnection("jdbc:postgresql://localhost/Hospital", "admin", "123456");
        	  System.out.println("aqui estoy 2 si" );
        	  DatabaseMetaData dm = (DatabaseMetaData) jdbcConnection.getMetaData();
        }  
        catch(SQLException e) {
        	 System.out.println("aqui estoy 2 no");
        }
        System.out.println("aqui estoy ");


    }
     
    public void desconectar() throws SQLException {  
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

	public Connection getJdbcConnection() {
		return jdbcConnection;
	}  
	public static void main(String[] args) {
		 
        Connection conn = null;
 
        try {
 
            Conexion  con = new Conexion();
            con.conectar();
      
            conn= con.getJdbcConnection();
            System.out.println(conn.getCatalog());
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
        
                ResultSet resultSet = null;
          
                
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
			
}
