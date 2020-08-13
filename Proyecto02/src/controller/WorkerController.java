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
import Model.Catalogue;
import Model.Center;
import Model.User;
import Model.Worker;
import dao.Appointmentdao;
import dao.Areadao;
import dao.Cataloguedao;
import dao.Centerdao;
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
	
	public WorkerController() throws SQLException {
		center = new Centerdao();
		area = new Areadao();
		appdao= new Appointmentdao();
		patient= new Patientdao();
		user = new Userdao();
		worker = new Wokerdao();
		catalogue = new Cataloguedao();
		
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
		String site = "";
		if(request.getParameter("type").equals("Doctor")) {
			site = "/WEB-INF/Vista/IndexDoctor.jsp";
		}
		else if (request.getParameter("type").equals("Nurse")) {
			site = "/WEB-INF/Vista/IndexNurse.jsp";
		}
		else if (request.getParameter("type").equals("Secretary")) {
			site = "/WEB-INF/Vista/IndexSecretary.jsp";
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher(site);
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
	private void attendApp2 (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
	
		String aux = request.getParameter("attend");
		//List<Appointment> apps = appdao.listAllAppointments(user.getUserAreaCenter(user.getSession()).getArea(), user.getUserAreaCenter(user.getSession()).getCenter());
	//	request.setAttribute("list", apps);
		//System.out.println("yoooooooooooooooooooooo hahha "+user.getUserAreaCenter(user.getSession()).getCenter());
		List<Catalogue> aux2 = catalogue.listCatalogue();
		request.setAttribute("patientid", aux);
		request.setAttribute("list", aux2);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/RegistrarDiagnostico.jsp");
		dispatcher.forward(request, response);
	}
}

