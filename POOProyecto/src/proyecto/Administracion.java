package proyecto;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

//Implementa la interfaz ToHome para método de bóton
public class Administracion extends JFrame implements ToHome{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ConexionBD connect = new ConexionBD();
	private Connection cn = connect.Connect();
	private double monto;

	
	public Administracion(Cliente cliente) {
		//Le da el valor correspondiente atributo de clase monto
		setMonto(cliente.getPagos());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		
		//Etiquetas
		JLabel lblNewLabel = new JLabel("Administración");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
		lblNewLabel.setBounds(318, 19, 162, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de usuario:");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(345, 147, 109, 17);
		contentPane.add(lblNewLabel_1);
		JLabel nombreUsuarioLbl = new JLabel("");
		nombreUsuarioLbl.setText(cliente.getNombre());
		nombreUsuarioLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nombreUsuarioLbl.setBounds(245, 175, 313, 14);
		contentPane.add(nombreUsuarioLbl);
		
		JCheckBox darBajaCHBX = new JCheckBox("Estoy de acuerdo que una vez dado de baja no tendré acceso ");
		darBajaCHBX.setHorizontalAlignment(SwingConstants.CENTER);
		darBajaCHBX.setBackground(Color.white);
		darBajaCHBX.setBounds(188, 368, 462, 83);
		contentPane.add(darBajaCHBX);
		
		//Bóton que accede a la base de datos con READ para leer el espacio de "pagos"del usuario
		JButton consultarBTN = new JButton("Consultar monto a pagar");
		
		consultarBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(monto != 0)
			JOptionPane.showMessageDialog(Administracion.this, "Actualmente el monto a pagar es: $"+ monto, "Concultar Monto", JOptionPane.INFORMATION_MESSAGE);
			else JOptionPane.showMessageDialog(Administracion.this, "No debes ningun pago, !Gracias!", "Concultar Monto", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		consultarBTN.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		consultarBTN.setBackground(Color.black);
		consultarBTN.setForeground(Color.white);
		consultarBTN.setBounds(307, 222, 196, 23);
		contentPane.add(consultarBTN);
		
		//Bóton para depositar al monto y tiene de restrcción que no se puede depositar más que el monto
		JButton depositarBTN = new JButton("Depositar monto");
		
		depositarBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(monto != 0) {
				double deposito = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu depósito: "));
				double monto = getMonto();
				if(deposito > 0 && monto-deposito >= 0) {
					monto -= deposito;
						setMonto(monto);
				  	   try (PreparedStatement preStm = cn.prepareStatement("UPDATE usuarios_gym SET pagos = ? WHERE nombre_gym = ?")) {
			               preStm.setDouble(1, monto);
			               preStm.setString(2, cliente.getNombre());
			               preStm.executeUpdate();
			           } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else JOptionPane.showMessageDialog(Administracion.this, "No puedes depositar más de $" + monto, "Error Depósito", JOptionPane.ERROR_MESSAGE);
				}
				else JOptionPane.showMessageDialog(Administracion.this, "No debes ningun pago, !Gracias!", "Depositar", JOptionPane.INFORMATION_MESSAGE);

				
			}
		});
		depositarBTN.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		depositarBTN.setBackground(Color.black);
		depositarBTN.setForeground(Color.white);
		depositarBTN.setBounds(307, 271, 196, 23);
		contentPane.add(depositarBTN);
		
		//Bóton para dar de baja que tiene commo restricción que el usuario tenga sus pagos en 0
		JButton bajaBTN = new JButton("Dar de baja");
	
		bajaBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(darBajaCHBX.isSelected()) {
				
					if(cliente.getPagos() == 0) {
						  try (PreparedStatement preStm = cn.prepareStatement("DELETE FROM usuarios_gym WHERE nombre_gym = ?")) {
				               preStm.setString(1, cliente.getNombre());
				               preStm.executeUpdate();
							   JOptionPane.showMessageDialog(Administracion.this, "No tienes pagos pendientes, has sido dado de baja, !Gracias por haber sido miembro!", "Dar de Baja", JOptionPane.INFORMATION_MESSAGE);

				           } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else JOptionPane.showMessageDialog(Administracion.this, "Por favor, realiza tus pagos pendientes para darte de baja", "Error Dar de baja", JOptionPane.ERROR_MESSAGE);
					
				}
				else JOptionPane.showMessageDialog(Administracion.this, "Por favor, acepta los terminos para dar de baja", "Error Dar de baja", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		bajaBTN.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 12));
		bajaBTN.setBackground(Color.black);
		bajaBTN.setForeground(Color.white);
		bajaBTN.setBounds(307, 321, 196, 23);
		contentPane.add(bajaBTN);
		
		//Botón que regresa a casa
		JButton HomeBtn = new JButton("Home");
		HomeBtn.setFont(new Font("Broadway", Font.PLAIN, 12));

		
		HomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToHome(cliente);
			}
		});
		HomeBtn.setBounds(686, 567, 86, 43);
		contentPane.add(HomeBtn);
		
		JLabel lblNewLabel_2 = new JLabel("En este apartado podrás consultar tus pagos y realizar depositos.");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(209, 55, 390, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Recuerda que para evitar penalizaciones, es necesario pagar antes de que termine el mes.");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(156, 80, 489, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image dedImg = new ImageIcon(this.getClass().getResource("/adminDed.png")).getImage();
		int l = 200;
	
		Image sclaedImg = dedImg.getScaledInstance(l, l, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(sclaedImg));
		lblNewLabel_3.setBounds(307, 470, l, l);
		contentPane.add(lblNewLabel_3);

	}
	
	
	//Métodos para tomar el monto y settearlo
	
	private double getMonto() {return this.monto;}
	
	private void setMonto(double monto) {
		this.monto = monto;
	}
	
	//Función abstracta de ToHome
	public void backToHome(Cliente cliente) {
		Home home = new Home(cliente);
		setVisible(false);
		dispose();
		home.setVisible(true);

	}
}