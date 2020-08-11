package dao;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Catalogue;
import Model.Patient;
import Model.User;
import Utils.Conexion;




public class Patientdao {
	private Conexion con;
	private Connection connection;

	public Patientdao() throws SQLException {
	
		con = new Conexion();
	
	}
	public void insert(Patient add,User add2) throws SQLException {
		String sql = "select addpatient (?,?,?,?,?,?,?,?,?,?,?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		  DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		System.out.println("Driver name: " + dm.getDriverName()+ "     l     oco");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString (1,add.getId());
		statement.setString(2,add.getName());
		statement.setString(3,add.getSurname1());
		statement.setString(4,add.getSurname2());
		statement.setString(5,add.getEmail());
		statement.setString(6,add.getNationality());
		statement.setString(7,add.getBlood());
		statement.setString(8,add.getState());
		statement.setString(9,add.getBirth());
		statement.setString(10,add2.getUsername());
		statement.setString(11,add2.getPassword());
	
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
	}
	public List<Categoria> listarCategorias() throws SQLException {

		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		String sql = "SELECT * FROM Categoria";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String id = resulSet.getString("CodigoCategoria");
			String nombre= resulSet.getString("NombreCategoria");
			String descripcion = resulSet.getString("Descripcion");
			String estado= resulSet.getString("Estado");

			Categoria nuevo= new Categoria(id, nombre, descripcion,estado);
			listaCategorias.add(nuevo);
		}
		con.desconectar();
		return listaCategorias;
	}
	
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
