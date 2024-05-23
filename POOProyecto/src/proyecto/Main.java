package proyecto;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		//En el main se inicializa la base de datos y se inicia el programa en la ventna de Menu
		ConexionBD connect = new ConexionBD();
		Connection cn = null;
		cn = connect.Connect();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		printUsuarios(cn);
		
	}


	//método para inicializar base de datos
    private static void printUsuarios(Connection cn) throws SQLException {
        // Obtener la tabla de usuarios
        try (PreparedStatement stm = cn.prepareStatement("SELECT * FROM usuarios_gym");
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                String nombreUsuario = rs.getString(2);
                String claveUsuario = rs.getString(3);
                System.out.println("ID: " + idUsuario + "\nNombre: " + nombreUsuario + "\nClaveee: " + claveUsuario);
            }
        }
    }
}
