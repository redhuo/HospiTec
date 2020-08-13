package dao;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Model.Appointment;
import Model.Area;
import Model.Catalogue;
import Model.Center;
import Model.Diagnostic;
import Utils.Conexion;




public class  Diagnosticdao {
	private Conexion con;
	private Connection connection;

	public Diagnosticdao() throws SQLException {
	
		con = new Conexion();
	
	}
	public void insert(Diagnostic add) throws SQLException {
		String sql = "select adddiagnostic (?,?,?,?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		  DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		System.out.println("Driver name: " + dm.getDriverName()+ "     l     oco");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString (1,add.getLevel());
		statement.setString(2,add.getCatalogue_id());
		statement.setString(3,add.getPatient_id());
		statement.setString(4,add.getObservation());


	
		 System.out.println("Driver name: " + dm.getDriverName()+ "  washa");

		statement.executeUpdate();
		
		 System.out.println("Driver name: " + dm.getDriverName()+ "  washa23");
		statement.close();
		con.desconectar();
	
		
	
	}
/*	public Categoria obtenerPorId(String id) throws SQLException {
		Categoria nuevo = null;

		String sql = "SELECT * FROM Categoria WHERE CodigoCategoria= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			nuevo = new Categoria(res.getString("CodigoCategoria"), res.getString("NombreCategoria"), res.getString("Descripcion"),
					res.getString("Estado"));
		}
		res.close();
		con.desconectar();

		return nuevo;
	}*/
	public List<Center> listCenters() throws SQLException {

		List<Center> listcenters = new ArrayList<Center>();
		String sql = "select * from getcenters()";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String id = resulSet.getString("auxcenter_id");
			String nombre= resulSet.getString("auxcenter_name");
		
			Center nuevo= new Center(id, nombre, "",0,"");
			listcenters.add(nuevo);
		}
		con.desconectar();
		return listcenters;
	}
	/*
	public boolean eliminar(Categoria nuevo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM Categoria WHERE CodigoCategoria=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nuevo.getCodigoCategoria());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
	
	public boolean actualizar(Categoria nuevo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE Categoria SET CodigoCategoria=?,NombreCategoria=?,Descripcion=?,Estado=? WHERE CodigoCategoria=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString (1,nuevo.getCodigoCategoria());
		statement.setString(2,nuevo.getNombreCategoria());
		statement.setString(3,nuevo.getDescripcion());
		statement.setString(4,nuevo.getEstado());
		statement.setString(5, nuevo.getCodigoCategoria());
		System.out.println(nuevo.getCodigoCategoria()+ " holaaaaaaaaaaaaaaaa");

		rowActualizar = statement.executeUpdate() > 0;
		System.out.println(nuevo.getDescripcion()+ " holaaaaaaaaaaaaaaaa "+ rowActualizar ) ;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}*/
	
	public static void main (String args[]) {
		Catalogue nuevo = new Catalogue("755","Fiebre","Paracetamol");
		
		try {
			new Cataloguedao().insert(nuevo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}