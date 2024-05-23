package proyecto;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

//Clase Home que es a donde se log in el usuario y aquí se muestran las tres opciones de actividades dentro de la aplicación
public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Home(Cliente cliente) {
		
		//Partes de la interfazgráfica
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido a tu gimnasio de confianza " + cliente.getNombre() + "!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		lblNewLabel.setBounds(199, 34, 414, 32);
		contentPane.add(lblNewLabel);
		
		//Botones para ir a su respectivo frame y en cada uno se les pasa el cliente como argumento
		
		JButton administracionBTN = new JButton("Administración");
		administracionBTN.setBackground(Color.black);
		administracionBTN.setForeground(Color.white);
		administracionBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administracion admin = new Administracion(cliente);
				setVisible(false);
				dispose();
				admin.setVisible(true);
			}
		});
		administracionBTN.setBounds(321, 109, 157, 32);
		contentPane.add(administracionBTN);
		
		JButton nutricionBTN = new JButton("Nutrición");
		nutricionBTN.setBackground(Color.black);
		nutricionBTN.setForeground(Color.white);
		nutricionBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nutriologo nutriologo = null;
				try {
					nutriologo = new Nutriologo(cliente);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				dispose();
				nutriologo.setVisible(true);
			}
		});
		nutricionBTN.setBounds(321, 187, 157, 32);
		contentPane.add(nutricionBTN);
		
		JButton reservacionBTN = new JButton("Reservaciones");
		reservacionBTN.setBackground(Color.black);
		reservacionBTN.setForeground(Color.white);
		reservacionBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservacion reservacion = null;
				try {
					reservacion = new Reservacion(cliente);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				dispose();
				reservacion.setVisible(true);
			}
		});
		reservacionBTN.setBounds(321, 269, 157, 32);
		contentPane.add(reservacionBTN);
		
		
		JButton HomeBtn = new JButton("Back");
		HomeBtn.setFont(new Font("Broadway", Font.PLAIN, 12));

		
		HomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 backToMenu();
			}
		});
		HomeBtn.setBounds(686, 567, 86, 43);
		contentPane.add(HomeBtn);
		
		
		JLabel dedLb = new JLabel("");
		Image dedImg = new ImageIcon(this.getClass().getResource("/ded22.png")).getImage();
		int l = 240;
		Image sclaedImg = dedImg.getScaledInstance(l, l, Image.SCALE_SMOOTH);
		dedLb.setIcon(new ImageIcon(sclaedImg));
		
		dedLb.setBounds(290, 370, l, l);
		contentPane.add(dedLb);
	}
	
	
	
	//Función para volver a log in
	void backToMenu() {
		Menu menu = new Menu();
		setVisible(false);
		dispose();
		menu.setVisible(true);
	}
}
