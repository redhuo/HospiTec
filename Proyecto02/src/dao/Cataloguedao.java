package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CatTreat;
import Model.Catalogue;
import Utils.Conexion;




public class Cataloguedao {
	private Conexion con;
	private Connection connection;

	public Cataloguedao() throws SQLException {
	
		con = new Conexion();
	
	}
	public void insert(Catalogue add) throws SQLException {
		String sql = "select addcatalogue (?,?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		  DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		System.out.println("Driver name: " + dm.getDriverName()+ "     l     oco");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString (1,add.getId());
		statement.setString(2,add.getName());

	
		 System.out.println("Driver name: " + dm.getDriverName()+ "  washa");

		statement.executeUpdate();
		
		 System.out.println("Driver name: " + dm.getDriverName()+ "  washa23");
		statement.close();
		con.desconectar();
	
		
	
	}
	public List<CatTreat> listCatTreat(String id){
		
		List<CatTreat> listCatalogue = new ArrayList<CatTreat>();
		String sql = "SELECT * from gettreatments(?)";
		try {
			con.conectar();
		
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);

		ResultSet res = statement.executeQuery();
		while (res.next()) {
			CatTreat nuevo =new CatTreat(res.getString("auxcatid"),res.getString("auxtreat"));
			listCatalogue.add(nuevo);
		}
		res.close();
		con.desconectar();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCatalogue;
	}
	
	public List<Catalogue> listCatalogue() throws SQLException {

		List<Catalogue> listCatalogue = new ArrayList<Catalogue>();
		String sql = "SELECT * FROM getcatalogue()";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String id = resulSet.getString("auxcat_id");
			String nombre= resulSet.getString("auxcat_name");
		

			Catalogue nuevo= new Catalogue(id, nombre,"");
			listCatalogue.add(nuevo);
		}
		con.desconectar();
		return listCatalogue;
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