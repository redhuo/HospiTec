	package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Appointment;
import Model.Area;
import Model.CatTreat;
import Model.Catalogue;
import Model.Center;
import Model.Diagnostic;
import Model.PatientTreat;
import Model.Treatment;
import Model.User;
import Model.Worker;
import dao.Appointmentdao;
import dao.Areadao;
import dao.Cataloguedao;
import dao.Centerdao;
import dao.Diagnosticdao;
import dao.Patientdao;
import dao.Userdao;
import dao.Wokerdao;



@WebServlet("/worker")
public class  WorkerController  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Centerdao center;
	Areadao area;
	Appointmentdao appdao;
	Patientdao patient;
	Userdao user;
	Wokerdao worker;
	Cataloguedao catalogue;
	Diagnosticdao diagnostic;
	
	public WorkerController() throws SQLException {
		center = new Centerdao();
		area = new Areadao();
		appdao= new Appointmentdao();
		patient= new Patientdao();
		user = new Userdao();
		worker = new Wokerdao();
		catalogue = new Cataloguedao();
		diagnostic = new Diagnosticdao();
		
		
		
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
			case "worker":
				registerWorker(request, response);
				break;
			case "enterworker":
				registerWorker2(request, response);
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
			case "attendapp":
				attendApp(request, response);
				break;
			case "attendapp2":
				attendApp2(request, response);
				break;
			case "attendapp3":
				attendApp3(request, response);
				break;
			
			case "attendapp4":
				attendApp4(request, response);
				break;
			case "cancelapp":
				cancelApp(request, response);
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


	private void registerWorker (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		List<Center> centers = center.listCenters();
		List<Area> areas = area.listAreas();
		request.setAttribute("list", centers);
		request.setAttribute("list2", areas);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarFuncionario.jsp");
		dispatcher.forward(request, response);
	}
	private void registerWorker2 (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		Worker aux = new Worker(request.getParameter("id"),request.getParameter("nombre"),request.getParameter("apellido1"),
						request.getParameter("apellido2"),request.getParameter("type"),request.getParameter("fecha"));
		User aux2 = new User(request.getParameter("usuario"),request.getParameter("password"),request.getParameter("type"));
		worker.insert(aux, aux2, request.getParameter("center"),request.getParameter("area"));
	
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void registerApp (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarCita.jsp");
		dispatcher.forward(request, response);
	}
	private void registerApp2 (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarCita.jsp");
		dispatcher.forward(request, response);
	}
	private void showApp (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String doctor ="/WEB-INF/Vista/viewAppDoctor.jsp";
		String nurse="/WEB-INF/Vista/viewAppNurse.jsp";
		String secretary="/WEB-INF/Vista/viewAppSecretary.jsp";
		String job = "";
		System.out.println("yolo "+user.getUserAreaCenter(user.getSession()).getArea());
		System.out.println("yolo2 "+user.getUserAreaCenter(user.getSession()).getCenter());
		List<Appointment> apps = appdao.listAllAppointments(user.getUserAreaCenter(user.getSession()).getArea(), user.getUserAreaCenter(user.getSession()).getCenter());
		request.setAttribute("list", apps);
		System.out.println("yoooooooooooooooooooooo hahha "+user.getUserAreaCenter(user.getSession()).getCenter());
		if(user.getUser(user.getSession()).getType().equals("Doctor")) {
			job=doctor;
		}
		else if(user.getUser(user.getSession()).getType().equals("Nurse")) {
			job=nurse;
		}
		else if(user.getUser(user.getSession()).getType().equals("Doctor")) {
			job=secretary;
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher(job);
		dispatcher.forward(request, response);
	}
	private void attendApp (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);

		List<Appointment> apps = appdao.listAllAppointments(user.getUserAreaCenter(user.getSession()).getArea(), user.getUserAreaCenter(user.getSession()).getCenter());
		request.setAttribute("list", apps);
		System.out.println("yoooooooooooooooooooooo hahha "+user.getUserAreaCenter(user.getSession()).getCenter());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/AttendPatient.jsp");
		dispatcher.forward(request, response);
	}
	private void attendApp2 (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("El attend no sirve 1");
		
		String aux=null;
		try {
			aux = appdao.obtainPatientId(request.getParameter("attend")).getPatient();
			appdao.actualizar(request.getParameter("attend"), "Attended");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El attend no sirve 2");
		//List<Appointment> apps = appdao.listAllAppointments(user.getUserAreaCenter(user.getSession()).getArea(), user.getUserAreaCenter(user.getSession()).getCenter());
	//	request.setAttribute("list", apps);
		//System.out.println("yoooooooooooooooooooooo hahha "+user.getUserAreaCenter(user.getSession()).getCenter());
		List<Catalogue> aux2 = catalogue.listCatalogue();
		request.setAttribute("patientid", aux);
		request.setAttribute("list", aux2);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarDiagnostico.jsp");
		dispatcher.forward(request, response);
	}
	private void attendApp3 (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("El attend no sirve 1");
		Diagnostic diag = new Diagnostic(request.getParameter("estado"),request.getParameter("catalogue"),request.getParameter("paciente"),request.getParameter("observacion"));
		try {
			diagnostic.insert(diag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El attend no sirve 2");

		List<CatTreat> aux2= catalogue.listCatTreat(request.getParameter("catalogue"));
	
	
		String patientid= request.getParameter("paciente");
		request.setAttribute("list", aux2);
		request.setAttribute("lol", patientid);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarTratamiento.jsp");
		dispatcher.forward(request, response);
	}
	private void attendApp4 (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		System.out.println("El attend no sirve 1");
		Treatment aux = new Treatment(request.getParameter("paciente"),request.getParameter("treatment"),request.getParameter("dosis"),request.getParameter("tipo"));
		try {
			patient.insertTreat(aux);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El attend no sirve 2");

	
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/IndexDoctor.jsp");
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
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/IndexDoctor.jsp");
		dispatcher.forward(request, response);
	}

}

