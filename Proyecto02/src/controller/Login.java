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

import Model.User;
import Utils.Conexion;
import dao.Userdao;



@WebServlet("/login")
public class Login  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Userdao user;
	
	public Login() throws SQLException {
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
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			case "worker":
				loginWorker(request, response);
				break;
			case "patient":
				loginPatient(request, response);
				break;
			case "access":
				System.out.println("holaaaaaaaaaaaaaaaa");
				access(request, response);
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
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Vista/index.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//Articulo articulo = new Articulo(0, request.getParameter("codigo"), request.getParameter("nombre"), request.getParameter("descripcion"),request.getParameter("cantidad"),request.getParameter("precio"));
		//articuloDAO.insertar(articulo);
		System.out.println("aqui");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vista/RegistrarFuncionario.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
	/*	List<Articulo> listaArticulos= articuloDAO.listarArticulos();
		request.setAttribute("lista", listaArticulos);*/
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	//	Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
	//	request.setAttribute("articulo", articulo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
	//	Articulo articulo = new Articulo(Integer.parseInt(request.getParameter("id")), request.getParameter("codigo"), request.getParameter("nombre"), request.getParameter("descripcion"),request.getParameter("existencia"), request.getParameter("precio"));
		//articuloDAO.actualizar(articulo);
		index(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		//articuloDAO.eliminar(articulo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}
	private void loginWorker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//	Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		//	request.setAttribute("articulo", articulo);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vista/LoginWorker.jsp");
		dispatcher.forward(request, response);
	}
	private void loginPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//	Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		//	request.setAttribute("articulo", articulo);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	private void access(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//	Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		//	request.setAttribute("articulo", articulo);
		System.out.println("hola  "+ user.getUser(request.getParameter("username")).getType());
		User aux =  user.getUser(request.getParameter("username"));
		System.out.println("no paso dauh daddy" + aux.getUsername());
		if (aux!= null) {
			System.out.println("no paso dauh 11111111");
			user.addSession(aux.getUsername(), aux.getType());
			System.out.println("no paso dauh 123456");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Vista/IndexPatient.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			System.out.println("no paso dauh 555");
		}

		
		
	
	}
}
