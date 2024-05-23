package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	//Declaramos las variables con sus respectivos atributos
	private static final String CONTROLLER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bd_gym";
	private static final String USER = "root";
	private static final String PASSWORD = "Password123.";
	
	//Método connect que nos regresa una conexión
		public Connection Connect() {
			Connection connect = null;
			//Try que intentara conectar con la base de datos creada con los atributos asignados
			try {
				Class.forName(CONTROLLER);
				connect = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Conexion con base de datos");
			}
			//Catch para saber si hubo error en la craga del controlador
			catch (ClassNotFoundException e) {
				System.out.println("ERROR CARGAR CONTROLADOR");
				e.printStackTrace();
			}
			//Catch para saber si hay erro al tratar de conectarse a la base de datos
			catch (SQLException e) {
				System.out.println("ERROR conexion");
				e.printStackTrace();
			}
			
			return connect;
		}
	
		
	
}
