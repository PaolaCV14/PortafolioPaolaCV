package proyecto;


import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import javax.swing.JCheckBox;

public class Registrarse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreRtxt;
	private JTextField claveRtxt;
	private JTextField estaturaRtxt;
	private JTextField pesoRtxt;
	@SuppressWarnings("rawtypes")
	private JComboBox diaCBX;
	@SuppressWarnings("rawtypes")
	private JComboBox mesCBX;
	@SuppressWarnings("rawtypes")
	private JComboBox yearCBX;
	private ConexionBD connect = new ConexionBD();
	private Connection cn = null;
	@SuppressWarnings("unused")
	private Cliente clientes;

	
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	//En esta clase se realiza un nuevo registro de usuario con la acción CREATE en la base de datos
	public Registrarse() {
		//Conexión base de datos
		cn = connect.Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		//Interfaz gráfica
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblNewLabel = new JLabel("¡Se un nuevo miembro de nuestro gimnasio!");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 13));
		lblNewLabel.setBounds(283, 40, 309, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registro");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(351, 11, 104, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de usuario:");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(182, 113, 120, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Contraseña:");
		lblNewLabel_2_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(182, 188, 120, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2_1_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(182, 244, 120, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Día:");
		lblNewLabel_2_1_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2_1_2.setBounds(182, 273, 38, 14);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Mes:");
		lblNewLabel_2_1_3.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2_1_3.setBounds(182, 335, 38, 14);
		contentPane.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Año:");
		lblNewLabel_2_1_4.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2_1_4.setBounds(182, 404, 120, 14);
		contentPane.add(lblNewLabel_2_1_4);
		
		diaCBX = new JComboBox();
		diaCBX.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		diaCBX.setBounds(182, 298, 140, 22);
		contentPane.add(diaCBX);
		
		mesCBX = new JComboBox();
		mesCBX.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		mesCBX.setBounds(182, 360, 142, 22);
		contentPane.add(mesCBX);
		
		yearCBX = new JComboBox();
		yearCBX.setModel(new DefaultComboBoxModel(new String[] {"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		yearCBX.setBounds(182, 429, 140, 22);
		contentPane.add(yearCBX);
		
		nombreRtxt = new JTextField();
		nombreRtxt.setBounds(182, 138, 151, 20);
		contentPane.add(nombreRtxt);
		nombreRtxt.setColumns(10);
		
		claveRtxt = new JTextField();
		claveRtxt.setBounds(182, 213, 151, 20);
		contentPane.add(claveRtxt);
		claveRtxt.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Peso en kg:");
		lblNewLabel_2_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(491, 113, 120, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Estatura en metros:");
		lblNewLabel_2_3.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(491, 188, 120, 14);
		contentPane.add(lblNewLabel_2_3);
		
		estaturaRtxt = new JTextField();
		estaturaRtxt.setColumns(10);
		estaturaRtxt.setBounds(491, 213, 151, 20);
		contentPane.add(estaturaRtxt);
		
		pesoRtxt = new JTextField();
		pesoRtxt.setColumns(10);
		pesoRtxt.setBounds(491, 138, 151, 20);
		contentPane.add(pesoRtxt);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Paquetes");
		lblNewLabel_2_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1.setBounds(491, 273, 120, 14);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JTextArea txtrPaquetePremium = new JTextArea();
		txtrPaquetePremium.setText("Paquete Premium\r\n  $450 por mes ");
		txtrPaquetePremium.setBounds(491, 297, 136, 52);
		contentPane.add(txtrPaquetePremium);
		
		JCheckBox premiumCHBX = new JCheckBox("");
		premiumCHBX.setBounds(638, 309, 26, 23);
		contentPane.add(premiumCHBX);
		
		JCheckBox basicoCHBX = new JCheckBox("");
		basicoCHBX.setBounds(638, 381, 26, 23);
		contentPane.add(basicoCHBX);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(basicoCHBX);
		buttonGroup.add(premiumCHBX);
		JTextArea txtrPaqueteBsico = new JTextArea();
		txtrPaqueteBsico.setText("Paquete Básico\r\n $300 por mes ");
		txtrPaqueteBsico.setBounds(491, 366, 136, 52);
		contentPane.add(txtrPaqueteBsico);
		//Se registra el usuario con este botón
		JButton Registrar = new JButton("Registrar");
		Registrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nombreUsuario = nombreRtxt.getText();
		        String claveUsuario = claveRtxt.getText();
		        String kgTxt = pesoRtxt.getText();
		        String mTxt = estaturaRtxt.getText();

		        if (nombreUsuario.isEmpty() || claveUsuario.isEmpty() || kgTxt.isEmpty() || mTxt.isEmpty()) {
		            JOptionPane.showMessageDialog(Registrarse.this, "Asegúrate de haber llenado todos los campos obligatorios.", "Error en Registro", JOptionPane.ERROR_MESSAGE);
		            return; // Agregamos un return para salir del método en caso de error.
		        }

		        try {
		            double kg = Double.parseDouble(kgTxt);
		            double m = Double.parseDouble(mTxt);
		            int dia = Integer.parseInt(diaCBX.getSelectedItem().toString());
		            int mes = Integer.parseInt(mesCBX.getSelectedItem().toString());
		            int year = Integer.parseInt(yearCBX.getSelectedItem().toString());

		            // Crear LocalDate en lugar de Date
		            LocalDate dateOfBirth = LocalDate.of(year, mes, dia);
		            

		            // Calcular pagos una vez
		            double pagos = premiumCHBX.isSelected() ? 450.0 : 300.0;

		            // Llamar a agregarUsuario con los parámetros necesarios
		            agregarUsuario(cn, nombreUsuario, claveUsuario, dateOfBirth, kg, m, pagos);

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(Registrarse.this, "Los campos de peso y estatura deben ser números válidos.", "Error en Registro", JOptionPane.ERROR_MESSAGE);
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		Registrar.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 13));
		Registrar.setBounds(325, 560, 150, 32);
		contentPane.add(Registrar);
		
		JButton HomeBtn = new JButton("Back");
		HomeBtn.setFont(new Font("Broadway", Font.PLAIN, 14));
		HomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backLogin();
			}
		});
		HomeBtn.setBounds(686, 567, 86, 43);
		contentPane.add(HomeBtn);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image dedImg = new ImageIcon(this.getClass().getResource("/registerDead.png")).getImage();
		int l = 189;
		int l2 = 100;
		Image sclaedImg = dedImg.getScaledInstance(l, l2, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(sclaedImg));
		lblNewLabel_3.setBounds(303, 490, l, l2);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
			}
		});
		btnNewButton.setBounds(69, 27, 89, 23);
		contentPane.add(btnNewButton);
		

	}
    private static void agregarUsuario(Connection cn, String nombre, String clave, LocalDate dateOfBirth, double kg, double m, double pagos) throws SQLException {
        // Agregar un nuevo usuario
        try (PreparedStatement preStm = cn.prepareStatement("INSERT INTO usuarios_gym (nombre_gym, clave_usuario, nacimiento_gym, peso_gym, altura_gym, pagos, reservas) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            preStm.setString(1, nombre);
            preStm.setString(2, clave);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
            String formattedDate = dateOfBirth.format(formatter);
            preStm.setString(3, formattedDate);
            preStm.setDouble(4, kg);
            preStm.setDouble(5, m);
            preStm.setDouble(6, pagos);
            preStm.setString(7, "NA");
            preStm.executeUpdate();
        }
        JOptionPane.showMessageDialog(null, "¡Felicidades, ya eres miembro del gym!", "Registrado", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void backLogin() {
    	Menu menu = new Menu();
    	setVisible(false);
    	dispose();
    	menu.setVisible(true);
    }
}


