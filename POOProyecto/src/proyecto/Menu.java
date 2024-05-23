package proyecto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Menu extends JFrame  {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField passwordTxt;
	private ConexionBD connect = new ConexionBD();
	private Connection cn = null;
	private Cliente clientes;
	@SuppressWarnings("unused")
	private Cliente cliente;
	
	//Clase Menu es aquella que se presenta en primera instancia con la opción de Log In o registrarse
	public Menu() {
		cn = connect.Connect();
		clientes = new Cliente();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblNewLabel = new JLabel("Deadpool Pump");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bodoni MT Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(283, 24, 219, 63);
		contentPane.add(lblNewLabel);
		
		JLabel logoImg = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logoDead.png")).getImage();
		int l = 180;
		int l2 = 200;
		Image scaledImg = imgLogo.getScaledInstance(l2, l, Image.SCALE_SMOOTH);
		logoImg.setIcon(new ImageIcon (scaledImg));
		logoImg.setBounds(302, 107, l2, l);
		contentPane.add(logoImg);
		

		//Se va con eset botón a la clase de registrarse
		JButton registerBtn = new JButton("REGISTRARSE");
		registerBtn.setBackground(Color.black);
		registerBtn.setForeground(Color.white);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarse registrarse = new Registrarse();
				setVisible(false);
				dispose();
				registrarse.setVisible(true);
			}
		});
		registerBtn.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		registerBtn.setBounds(323, 528, 138, 33);
		contentPane.add(registerBtn);
		
		userNameTxt = new JTextField();
		
		userNameTxt.setBounds(289, 347, 206, 20);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(287, 427, 206, 20);
		contentPane.add(passwordTxt);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de usuario:");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(289, 316, 172, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(287, 396, 140, 20);
		contentPane.add(lblNewLabel_1_1);
		
		
		//Se busca que exista un usuario con el nombre y contraseña introducida por el usuario y si si se va a Home, si no se lo señala
		JButton logInBtn = new JButton("LOG IN");
		logInBtn.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		logInBtn.setBackground(Color.black);
		logInBtn.setForeground(Color.white);
		logInBtn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {				
				String userName = userNameTxt.getText();
				String password = passwordTxt.getText();
				Cliente client = null;
				boolean coincide = false;
				System.out.println(userName);
			    if (userName == null || password == null) {
			        JOptionPane.showMessageDialog(Menu.this, "Por favor ingresa tu usuario y contraseña", "Error Iniciar sesión", JOptionPane.ERROR_MESSAGE);
			        return;
			    }
			    else {
			    	
			    //Gnerico donde irán almacenados los clientes del programa
			    List<Cliente> listaClientes = null;
			   
			    try {
			        listaClientes = clientes.listaCliente(cn);
			        for (Cliente cliente : listaClientes) {
				        if (cliente.getNombre().equals(userName) && cliente.getClave().equals(password)) {
				            coincide = true;
				            client = new Cliente(cliente.getNombre(), cliente.getClave(), cliente.getPagos(), cliente.getHeight(), cliente.getDateOfBirth(), cliente.getWeight(), cliente.getReservas());
				            break;  
				        }
				    }
			    } catch (SQLException e1) {
			        e1.printStackTrace();
			    }
			}
			  
			    if (coincide) {
			    	setCliente(userName, password);
			        Home home = new Home(client);
			        setVisible(false);
			        dispose();
			        home.setVisible(true);
			    } else {
			        JOptionPane.showMessageDialog(Menu.this, "Usuario o contraseña incorrecta.", "Error Iniciar sesión", JOptionPane.ERROR_MESSAGE);
			    }}
		});
		logInBtn.setBounds(323, 475, 138, 33);
		contentPane.add(logInBtn);
		
	}
	
	public void setCliente(String userName, String password) {
		this.cliente = new Cliente(userName, password);
	}
	
	
	
	
}