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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reservacion extends JFrame implements ToHome{
	

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ConexionBD connect = new ConexionBD();
	private Connection cn = connect.Connect();
	private List<Integer> reservasUsuario;
	private String rUsuarioStr;
	private String userName;
	private String[] tusReservas = new String[4];
	

	//Clase de reservaciones para añadir o cancelar una reservación al apartado de "reservas" del usuario
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Reservacion(Cliente cliente) throws SQLException {
		//Indicamos el nombre del cliente actual
		this.userName = cliente.getNombre();
		setR(cliente.getReservas());
		setReservasUsuario(rUsuarioStr);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblNewLabel = new JLabel("Reservaciones");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 16));
		lblNewLabel.setBounds(334, 11, 113, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("En este apartado puedes reservar tu clase de preferencia. Verifica que este tu horario de preferencia y reservalo. ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(73, 57, 635, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Spinning");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(104, 116, 66, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hit Dance");
		lblNewLabel_2_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(270, 116, 66, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Zumba");
		lblNewLabel_2_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(455, 116, 54, 15);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Box");
		lblNewLabel_2_3.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(618, 116, 36, 15);
		contentPane.add(lblNewLabel_2_3);
		
		JComboBox spCMBX = new JComboBox();
		spCMBX.setModel(new DefaultComboBoxModel(new String[] {"7:00 a.m - 8:00 a.m", "9:00 a.m - 10:00 a.m", "12:00 p.m - 1:00 p.m", "6:00 p.m - 7:00 p.m", "8:00 p.m - 9:00 p.m"}));
		spCMBX.setBounds(73, 159, 129, 22);
		contentPane.add(spCMBX);
		
		JComboBox hdCMBX = new JComboBox();
		hdCMBX.setModel(new DefaultComboBoxModel(new String[] {"7:00 a.m - 8:00 a.m", "10:00 a.m - 11:00 a.m", "12:00 p.m - 1:00 p.m", "6:00 p.m - 7:00 p.m", "8:00 p.m - 9:00 p.m"}));
		hdCMBX.setBounds(245, 159, 129, 22);
		contentPane.add(hdCMBX);
		
		JComboBox zbCMBX = new JComboBox();
		zbCMBX.setModel(new DefaultComboBoxModel(new String[] {"7:00 a.m - 8:00 a.m", "8:00 a.m - 9:00 a.m", "9:00 a.m - 10:00 a.m", "10:00 a.m - 11:00 a.m", "11:00 a.m - 12:00 p.m"}));
		zbCMBX.setBounds(411, 159, 129, 22);
		contentPane.add(zbCMBX);
		
		JComboBox bxCMBX = new JComboBox();
		bxCMBX.setModel(new DefaultComboBoxModel(new String[] {"3:00 p.m - 4:00 p.m", "4:00 p.m - 5:00 p.m", "5:00 p.m - 6:00 p.m", "6:00 p.m - 7:00 p.m", "7:00 p.m - 8:00 p.m"}));
		bxCMBX.setBounds(581, 159, 129, 22);
		contentPane.add(bxCMBX);
		
		JLabel res1Lbl = new JLabel("Reservación 1");
		res1Lbl.setText(tusReservas[0]);
		res1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		res1Lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		res1Lbl.setBounds(194, 339, 367, 14);
		contentPane.add(res1Lbl);
		
		JLabel res2Lbl = new JLabel("Reservación 2");
		res2Lbl.setText(tusReservas[1]);
		res2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		res2Lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		res2Lbl.setBounds(194, 399, 367, 14);
		contentPane.add(res2Lbl);
		
		JLabel res3Lbl = new JLabel("Reservación 3");
		res3Lbl.setText(tusReservas[2]);
		res3Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		res3Lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		res3Lbl.setBounds(194, 457, 367, 14);
		contentPane.add(res3Lbl);
		
		JLabel res4Lbl = new JLabel("Reservación 4");
		res4Lbl.setText(tusReservas[3]);
		res4Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		res4Lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		res4Lbl.setBounds(194, 516, 367, 14);
		contentPane.add(res4Lbl);
		
		//Inicializamos las reservaciones del usuario
		setTusReservaciones(res1Lbl, res2Lbl, res3Lbl, res4Lbl);
		JButton reservarSPbtn = new JButton("Reservar");
		
		//Botones para reservar en cada respectiva clase donde también se debe de indicar el horario que se quiere
		reservarSPbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hora;
				
				hora = spCMBX.getSelectedIndex();
				if(reservasUsuario == null || reservasUsuario.size() < 4) {
					boolean reservada = reservarClase(hora, "Reservar");
					if(reservada)addClase(hora);
					setTusReservaciones(res1Lbl, res2Lbl, res3Lbl, res4Lbl);
					}
				else JOptionPane.showMessageDialog(null, "Lo sentimos, ya has alcanzado el máximo de 4 clases", "Reserva Fallida", JOptionPane.ERROR_MESSAGE);

				
			}
		});
		reservarSPbtn.setBounds(94, 192, 89, 23);
		reservarSPbtn.setBackground(Color.black);
		reservarSPbtn.setForeground(Color.white);
		contentPane.add(reservarSPbtn);
		
		JButton reservarSPbtn_1 = new JButton("Reservar");
		reservarSPbtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hora;
				System.out.println(rUsuarioStr);
				hora = hdCMBX.getSelectedIndex();
				System.out.println(" selected " + hora);
				hora += 5;
				System.out.println(" Hora before clase " + hora);
				if(reservasUsuario == null || reservasUsuario.size() < 4) {
				boolean reservada = reservarClase(hora, "Reservar");
				if(reservada)addClase(hora);
				System.out.println(rUsuarioStr);
				setTusReservaciones(res1Lbl, res2Lbl, res3Lbl, res4Lbl);
				}
				else JOptionPane.showMessageDialog(null, "Lo sentimos, ya has alcanzado el máximo de 4 clases", "Reserva Fallida", JOptionPane.ERROR_MESSAGE);

				
			}
		});
		reservarSPbtn_1.setBounds(270, 192, 89, 23);
		reservarSPbtn_1.setBackground(Color.black);
		reservarSPbtn_1.setForeground(Color.white);
		contentPane.add(reservarSPbtn_1);
		
		JButton reservarSPbtn_2 = new JButton("Reservar");
		reservarSPbtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hora;
				System.out.println(rUsuarioStr);
				hora = zbCMBX.getSelectedIndex();
				hora += 10;
				System.out.println(" Hora before clase " + hora);
				if(reservasUsuario == null || reservasUsuario.size() < 4) {
					boolean reservada = reservarClase(hora, "Reservar");
					if(reservada)addClase(hora);
					setTusReservaciones(res1Lbl, res2Lbl, res3Lbl, res4Lbl);
				
					}
				else JOptionPane.showMessageDialog(null, "Lo sentimos, ya has alcanzado el máximo de 4 clases", "Reserva Fallida", JOptionPane.ERROR_MESSAGE);

			}
		});
		reservarSPbtn_2.setBounds(427, 192, 89, 23);
		reservarSPbtn_2.setBackground(Color.black);
		reservarSPbtn_2.setForeground(Color.white);
		contentPane.add(reservarSPbtn_2);
		
		JButton reservarSPbtn_3 = new JButton("Reservar");
		reservarSPbtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hora;
				System.out.println(rUsuarioStr);
				hora = bxCMBX.getSelectedIndex();
				hora += 15;
				System.out.println(" Hora before clase " + hora);
				if(reservasUsuario == null || reservasUsuario.size() < 4) {
					boolean reservada = reservarClase(hora, "Reservar");
					if(reservada)addClase(hora);
					setTusReservaciones(res1Lbl, res2Lbl, res3Lbl, res4Lbl);
					}
				else JOptionPane.showMessageDialog(null, "Lo sentimos, ya has alcanzado el máximo de 4 clases", "Reserva Fallida", JOptionPane.ERROR_MESSAGE);
					
			}
		});
		reservarSPbtn_3.setBounds(605, 192, 89, 23);
		reservarSPbtn_3.setBackground(Color.black);
		reservarSPbtn_3.setForeground(Color.white);
		contentPane.add(reservarSPbtn_3);
		
		JLabel lblTusReservacione = new JLabel("Tus reservaciones:");
		lblTusReservacione.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblTusReservacione.setBounds(325, 262, 122, 24);
		contentPane.add(lblTusReservacione);
		
		JLabel lblNewLabel_3 = new JLabel("Puedes reservar hasta cuatro clases");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(194, 297, 367, 14);
		contentPane.add(lblNewLabel_3);
		
		
		JCheckBox r1CHBX = new JCheckBox("");
		r1CHBX.setBounds(361, 360, 26, 23);
		contentPane.add(r1CHBX);
		
		JCheckBox r2CHBX = new JCheckBox("");
		r2CHBX.setBounds(361, 420, 26, 23);
		contentPane.add(r2CHBX);
		
		JCheckBox r3CHBX = new JCheckBox("");
		r3CHBX.setBounds(361, 478, 26, 23);
		contentPane.add(r3CHBX);
		
		JCheckBox r4CHBX = new JCheckBox("");
		r4CHBX.setBounds(361, 538, 26, 23);
		contentPane.add(r4CHBX);
		
		ButtonGroup group = new ButtonGroup();
		group.add(r1CHBX);
		group.add(r2CHBX);
		group.add(r3CHBX);
		group.add(r4CHBX);
		
		//Se cancela una reservación quitandola de la lista de reservaciones del usuario y aumentado el cupo de dicha clase cancelada
		JButton btnNewButton = new JButton("Cancelar reservacion");
		btnNewButton.setBackground(Color.black);
		btnNewButton.setForeground(Color.white);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println(rUsuarioStr);
		        if (rUsuarioStr.equals("NA")) {
		            JOptionPane.showMessageDialog(Reservacion.this, "No tienes reservaciones que cancelar", "Cancelación Fallida", JOptionPane.ERROR_MESSAGE);
		        } else {
		            if (r1CHBX.isSelected()) {
		            }
		            else if (r2CHBX.isSelected()) {
		                cancelarReserva(1, res2Lbl);
		            }
		            else if (r3CHBX.isSelected()) {
		            	 cancelarReserva(2, res3Lbl);
		            }
		            else if (r4CHBX.isSelected()) {
		            	cancelarReserva(3, res4Lbl);
		                
		            }
		        }
		    }

		    private void cancelarReserva(int index, JLabel label) {
		        if (reservasUsuario.isEmpty()) {
		            JOptionPane.showMessageDialog(Reservacion.this, "No tienes reservación que cancelar", "Cancelación Fallida", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (index >= 0 && index < reservasUsuario.size()) {
		            int reserva = reservasUsuario.remove(index);
		            System.out.println("reserva: " + reserva);
		            cancelarClase(reserva);
		            setTusReservaciones(res1Lbl, res2Lbl, res3Lbl, res4Lbl);
		        } else {
		            JOptionPane.showMessageDialog(Reservacion.this, "Índice de reserva inválido", "Cancelación Fallida", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		btnNewButton.setBounds(283, 568, 178, 23
				);
		contentPane.add(btnNewButton);
		
		
		
		JButton HomeBtn = new JButton("Home");
		HomeBtn.setFont(new Font("Broadway", Font.PLAIN, 12));

		
		HomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setReservas(rUsuarioStr);
				backToHome(cliente);
			}
		});
		HomeBtn.setBounds(686, 567, 86, 43);
		contentPane.add(HomeBtn);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image dedImg = new ImageIcon(this.getClass().getResource("/deadLift.png")).getImage();
		int l = 184;
		int l2 = 207;
		Image sclaedImg = dedImg.getScaledInstance(l, l2, Image.SCALE_SMOOTH);
		lblNewLabel_4.setIcon(new ImageIcon(sclaedImg));
		lblNewLabel_4.setBounds(50, 380, l, l2);
		contentPane.add(lblNewLabel_4);
		
	}
	//En esta misma clase se elimina o se reserva
	public boolean reservarClase(int clase, String reservarEliminar) {
	    boolean isReservada = false;
	    int reservada = 0;

	    clase++;
	    System.out.println(" Hora clase " + clase);
	    int horario = clase % 5;
	    horario = (horario == 0) ? 5 : horario;
	    String claseNombre;

	    if (clase >= 1 && clase <= 5) {
	        claseNombre = "ASpinning";
	    } else if (clase >= 6 && clase <= 10) {
	        claseNombre = "BHitDance";
	    } else if (clase >= 11 && clase <= 15) {
	        claseNombre = "CZumba";
	    } else {
	        claseNombre = "DBox";
	    }
	    String horarioStr;
	    switch (horario) {
	        case 1:
	            horarioStr = "Horario1";
	            break;
	        case 2:
	            horarioStr = "Horario2";
	            break;
	        case 3:
	            horarioStr = "Horario3";
	            break;
	        case 4:
	            horarioStr = "Horario4";
	            break;
	        default:
	            horarioStr = "Horario5";
	    }

	  

	    try (PreparedStatement selectStm = cn.prepareStatement("SELECT * FROM clases_reservacion WHERE Clase = ?")) {
	        selectStm.setString(1, claseNombre);


	        try (ResultSet rs = selectStm.executeQuery()) {
	            if (rs.next()) {
	                reservada = rs.getInt(horario + 1);
	                if (reservada != 0 || "Eliminar".equals(reservarEliminar) ) {
	                    isReservada = true;
	                    try (PreparedStatement updateStm = cn.prepareStatement("UPDATE clases_reservacion SET " + horarioStr + " = ? WHERE Clase = ?")) {
	                        if ("Reservar".equals(reservarEliminar)) {
	                            reservada--;
	                        } else if ("Eliminar".equals(reservarEliminar)) {
	                            reservada++;
	                        }


	                        updateStm.setInt(1, reservada);
	                        updateStm.setString(2, claseNombre);


	                        updateStm.executeUpdate();
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Lo sentimos, el cupo de esta clase está lleno", "Reserva Fallida", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isReservada;
	}
	
	//Se realiza un string de la lista de clases usuario para tener un manejo más sencillo de la lista
	public void setReservasUsuario(String reservasCliente) {
		List<Integer> reservas = new ArrayList<>();
		if (reservasCliente != null && !reservasCliente.equals("NA")) {
			String reservasSC = reservasCliente.replaceAll("[\\[\\] ]", "");
			String[] reservasStr = reservasSC.split(",");
			for(String reserva : reservasStr) {
				reservas.add(Integer.parseInt(reserva));
			}
		}
		else reservas = null;
	
		
		this.reservasUsuario = reservas;
		
	}
	
	//Se hace un UPDATE al cliente agregando la clase reservada
	public void addClase(int clase) {
	    if (rUsuarioStr.equals("NA")) {
	        reservasUsuario = new ArrayList<>();
	    }

	    if (reservasUsuario.size() < 4) {
            boolean add = true;
            for (int claseX : reservasUsuario) {
                if (claseX == clase)
                    add = false;
            }
            if (add == true)
            	reservasUsuario.add(clase);
            else
                JOptionPane.showMessageDialog(null, "Ya has reservado esta clase en este horario", "Reserva Fallida",
                        JOptionPane.ERROR_MESSAGE);
	        
	        rUsuarioStr = reservasUsuario.toString();
	   	 try (PreparedStatement preStm = cn.prepareStatement("UPDATE usuarios_gym SET reservas = ? WHERE nombre_gym = ?")) {
             preStm.setString(1, rUsuarioStr);
             preStm.setString(2, userName);
             preStm.executeUpdate();
         } catch (SQLException e1) {
			e1.printStackTrace();
			
			
		}
	    } else {
	        JOptionPane.showMessageDialog(null, "Lo sentimos, ya has alcanzado el máximo de 4 clases", "Reserva Fallida", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void setR(String rUsuarioStr) {
		rUsuarioStr = rUsuarioStr.equals("[]") ? "NA": rUsuarioStr;
		this.rUsuarioStr = rUsuarioStr;
	}
	
	//Se hace un UPDATE  a la base de datos con la lista sin la clase cancelada
	public void cancelarClase(int clase) {
	    if (reservasUsuario.isEmpty()) {
	        System.out.println("No tienes reservas");
	        return;
	    }

	    @SuppressWarnings("unused")
		boolean removed = reservasUsuario.remove(Integer.valueOf(clase));
	    
	    System.out.println(reservasUsuario.size());
	    if (reservasUsuario.isEmpty()) {
	        rUsuarioStr = "NA";
	        System.out.println("aqui");
	    } else {
	        rUsuarioStr = reservasUsuario.toString();
	    }

	    try (PreparedStatement preStm = cn.prepareStatement("UPDATE usuarios_gym SET reservas = ? WHERE nombre_gym = ?")) {
	    	System.out.println(rUsuarioStr);
	        preStm.setString(1, rUsuarioStr);
	        preStm.setString(2, userName);
	        preStm.executeUpdate();
	    } catch (SQLException e1) {
	       
	        e1.printStackTrace();
	    }

	    if (reservasUsuario.isEmpty()) {
	        System.out.println("No tienes reserva para la clase " + clase);
	    } else {
	        System.out.println("Reserva cancelada para la clase " + clase);
	    }

	    setReservasUsuario(rUsuarioStr);
	}

	//Se agrgan reservaciones usuario
	public void setTusReservaciones(JLabel lb1, JLabel lb2, JLabel lb3, JLabel lb4) {
	    if (rUsuarioStr.equals("NA")) {
	        tusReservas[0] = tusReservas[1] = tusReservas[2] = tusReservas[3] = "No tienes reserva";
	    } else {
	        Arrays.fill(tusReservas, "No tienes reserva");  

	        
	        for (int i = 0; i < reservasUsuario.size(); i++) {
	            int claseIndex = reservasUsuario.get(i); 
	            if (claseIndex >= 0 && claseIndex < Clases.values().length) {
	                tusReservas[i] = Clases.values()[claseIndex].getClase();
	            }
	        }
	    }

	  
	    lb1.setText(tusReservas[0]);
	    lb2.setText(tusReservas[1]);
	    lb3.setText(tusReservas[2]);
	    lb4.setText(tusReservas[3]);
	}
	
	//Reestablece las etiquetas con reservaciones cada vez que se haga un cambio en estas
	public void setLabelsReservaciones(JLabel lb1, JLabel lb2, JLabel lb3, JLabel lb4) {
		lb1.setText(tusReservas[0]);
		lb2.setText(tusReservas[1]);
		lb3.setText(tusReservas[2]);
		lb4.setText(tusReservas[3]);
	}

	
	public void backToHome(Cliente cliente) {
		Home home = new Home(cliente);
		setVisible(false);
		dispose();
		home.setVisible(true);

	}
}
