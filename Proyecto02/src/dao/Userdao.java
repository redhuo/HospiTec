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




public class Userdao {
	private Conexion con;
	private Connection connection;

	public Userdao() throws SQLException {
	
		con = new Conexion();
	
	}

	public User getUser(String id) throws SQLException {
		User aux = null;

		String sql = "SELECT * FROM getuser(?) ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			aux = new User(res.getString("user_name"),"",res.getString("usertype"));
		}
		res.close();
		con.desconectar();

		return aux;
	}
	
	public String getSession() throws SQLException {
		String aux = null;

		String sql = "SELECT * FROM getsession() ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			aux = res.getString("auxusername");
		}
		res.close();
		con.desconectar();

		return aux;
	}
	public void addSession(String id,String type) throws SQLException {
		User aux = null;
		System.out.println("yoyo 1");
		String sql = "SELECT addSession(?,?)";
		con.conectar();
		System.out.println("yoyo 2");
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);
		statement.setString(2, type);
		System.out.println("yoyo 3");
		statement.executeQuery();
		System.out.println("yoyo 4");
		statement.close();
		con.desconectar();
		
		
	}
	public void removeSession() throws SQLException {
		

		String sql = "SELECT removeSession() ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeQuery();
		
		statement.close();
		con.desconectar();

		
	}
	
	/*public List<Categoria> listarCategorias() throws SQLException {

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
	
	public static void main (String args[]) throws SQLException {
		Userdao nuevo = new Userdao();
		System.out.println(nuevo.getUser("rodri").getType());
	}

}
