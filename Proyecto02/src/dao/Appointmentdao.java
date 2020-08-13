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
import Model.Catalogue;
import Model.PatientApp;
import Model.WAC;
import Utils.Conexion;




public class  Appointmentdao {
	private Conexion con;
	private Connection connection;

	public Appointmentdao() throws SQLException {
	
		con = new Conexion();
	
	}
	public void insert(Appointment add,String patient) throws SQLException {
		String sql = "select addappointment (?,?,?,?,?,?,?)";
		
		con.conectar();
		connection = con.getJdbcConnection();
		  DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
		System.out.println("Driver name: " + dm.getDriverName()+ "     l     oco");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString (1,add.getId());
		statement.setString(2,add.getArea());
		statement.setString(3,add.getDay());
		statement.setString(4,add.getHour());
		statement.setString(5,add.getStatus());
		statement.setString(6,add.getCenter_id());
		statement.setString(7,patient);

	
		 System.out.println("Driver name: " + dm.getDriverName()+ "  washa");

		statement.executeUpdate();
		
		 System.out.println("Driver name: " + dm.getDriverName()+ "  washa23");
		statement.close();
		con.desconectar();
	
		
	
	}
	public PatientApp obtainPatientId(String id) throws SQLException {
		PatientApp nuevo = null;

		String sql = "SELECT * FROM getpatientapp(?) ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			nuevo = new PatientApp(res.getString("auxpatientid"), res.getString("auxappid"));
		}
		res.close();
		con.desconectar();

		return nuevo;
	}
	public List<Appointment> listAppointments(String id) throws SQLException {

		List<Appointment> listapp = new ArrayList<Appointment>();
		String sql = "SELECT * FROM getappointments(?) ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);

		ResultSet res = statement.executeQuery();
		while (res.next()) {
			String code = res.getString("appid");
			String status = res.getString("appstatus");
			String appday = res.getString("appday");
		
			listapp.add(new Appointment(code,"",appday,"",status,""));
		}
		con.desconectar();
		return listapp;
	}
	public List<Appointment> listAllAppointments(String area,String center) throws SQLException {

		List<Appointment> listapp = new ArrayList<Appointment>();
		String sql = "SELECT * FROM getappointmentsworker(?,?) ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, area);
		statement.setString(2, center);

		ResultSet res = statement.executeQuery();
		while (res.next()) {
			String code = res.getString("appid");
			String status = res.getString("appstatus");
			String appday = res.getString("appday");
		
			listapp.add(new Appointment(code,"",appday,"",status,""));
		}
		con.desconectar();
		return listapp;
	}
	public List<Appointment> listAllAppointmentsAv(String area,String center) throws SQLException {

		List<Appointment> listapp = new ArrayList<Appointment>();
		String sql = "SELECT * FROM getappointmentsworker(?,?) ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, area);
		statement.setString(2, center);

		ResultSet res = statement.executeQuery();
		while (res.next()) {
			String code = res.getString("appid");
			String status = res.getString("appstatus");
			String appday = res.getString("appday");
		
			listapp.add(new Appointment(code,"",appday,"",status,""));
		}
		con.desconectar();
		return listapp;
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
	*/
	public void actualizar(String id,String message) throws SQLException {
	
		String sql = "select updateappointment(?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString (1,id);
		statement.setString(2,message);
		statement.executeUpdate();
		statement.close();
		con.desconectar();
	
	}
	
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