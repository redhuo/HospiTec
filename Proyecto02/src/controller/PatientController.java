package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Center;
import Model.Patient;
import Model.Treatment;
import Model.User;
import Model.Appointment;
import Model.Area;
import dao.Appointmentdao;
import dao.Areadao;
import dao.Centerdao;
import dao.Patientdao;
import dao.Userdao;



@WebServlet("/patient")
public class PatientController  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Centerdao center;
	Areadao area;
	Appointmentdao appdao;
	Patientdao patient;
	Userdao user;
	
	public PatientController() throws SQLException {
		center = new Centerdao();
		area = new Areadao();
		appdao= new Appointmentdao();
		patient= new Patientdao();
		user = new Userdao();
	}
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "type":
				index(request, response);
				break;
			case "patient":
				registerPatient(request, response);
				break;
			case "enterpatient":
				registerPatient2(request, response);
				break;
			case "newapp":
				registerApp(request, response);
				break;
			case "enterapp":
				registerApp2(request, response);
				break;
			case "viewapp":
				showApp(request, response);
				break;
			case "cancelapp":
				cancelApp(request, response);
				break;
			case "viewtreat":
				showTreat(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarFuncionario.jsp");
		dispatcher.forward(request, response);
	}

	
	private void registerPatient (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarPaciente.jsp");
		dispatcher.forward(request, response);
	}
	
	private void registerPatient2 (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//mostrar(request, response);
		Patient aux= new Patient(request.getParameter("id"),request.getParameter("nombre"),request.getParameter("apellido1"),request.getParameter("apellido2"),
		request.getParameter("correo"),request.getParameter("nacionalidad"),request.getParameter("tipo_sangre"),request.getParameter("residencia"),request.getParameter("fecha"));
		User aux2 = new User(request.getParameter("usuario"),request.getParameter("password"),"Patient");
		
		try {
			patient.insert(aux, aux2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("patient registered");
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/IndexPatient.jsp");
		dispatcher.forward(request, response);
	}
	private void registerApp (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		List<Center> centers = center.listCenters();
		List<Area> areas = area.listAreas();
		request.setAttribute("list", centers);
		request.setAttribute("list2", areas);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarCita.jsp");
		dispatcher.forward(request, response);
	}
	private void registerApp2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int randomNum = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
		Appointment app = new Appointment(String.valueOf(randomNum),request.getParameter("area"),request.getParameter("fecha"),request.getParameter("hora"),"Registered",request.getParameter("center"));
		try {
			appdao.insert(app,patient.getPatientId(user.getSession()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showApp (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		List<Appointment> apps = appdao.listAppointments(patient.getPatientId(user.getSession()));
	
		request.setAttribute("list", apps);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/viewAppointments.jsp");
		dispatcher.forward(request, response);
	}
	private void cancelApp (HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
	
		String code = request.getParameter("cancel");
		try {
			appdao.actualizar(code, "Cancelled");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/IndexPatient.jsp");
		dispatcher.forward(request, response);
	}
	private void showTreat (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		List<Treatment> apps = patient.listTreat(patient.getPatientId(user.getSession()));
	
		request.setAttribute("list", apps);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/ViewTreatment.jsp");
		dispatcher.forward(request, response);
	}
}

