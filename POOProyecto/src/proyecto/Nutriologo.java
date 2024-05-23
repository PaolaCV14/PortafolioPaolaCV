package proyecto;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Nutriologo extends JFrame implements ToHome {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<?> ejercicioCXBN;
	private ConexionBD connect = new ConexionBD();
	private Connection cn = connect.Connect();
	private int edad;
	private float peso;
	private float estatura;
	private String genero = null;
	private float ejercicio;
	private String userName;
	
	
	//Clase Nutrición donde a partir de los datos del cliente se harán cálculos para determinar su requerimiento calórico
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Nutriologo(Cliente cliente) throws SQLException {
		this.userName = cliente.getNombre();
		setEstatura(cliente.getHeight());
		setPeso(cliente.getWeight());
		int edad = toEdad(cliente.getDateOfBirth());
		setEdad(edad);
	
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lblNewLabel = new JLabel("Nutrición");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
		lblNewLabel.setBounds(318, 11, 109, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Calcula tu IBM para determinar la cantidad de calorías que deberías ingerir diriamente.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(134, 40, 523, 63);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edad: ");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(157, 100, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Peso:");
		lblNewLabel_2_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(157, 171, 54, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Estatura: ");
		lblNewLabel_2_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(157, 306, 72, 15);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Género:");
		lblNewLabel_2_3.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(488, 100, 54, 15);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Realizo ejercicio:");
		lblNewLabel_2_4.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(488, 192, 109, 15);
		contentPane.add(lblNewLabel_2_4);

		JLabel ibmLabel_1 = new JLabel("");
		ibmLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		ibmLabel_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		ibmLabel_1.setBounds(134, 508, 500, 47);
		contentPane.add(ibmLabel_1);
		
		
		//RadioButtons para determinar el género 
		JRadioButton mujerRDB = new JRadioButton("Mujer");	
		mujerRDB.setBounds(488, 127, 109, 23);
		contentPane.add(mujerRDB);
		
		JRadioButton hombreRDB = new JRadioButton("Hombre");
		hombreRDB.setBounds(488, 152, 109, 23);
		contentPane.add(hombreRDB);
		
		ButtonGroup generoGroup = new ButtonGroup();
		generoGroup.add(mujerRDB);
		generoGroup.add(hombreRDB);

		hombreRDB.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        setGenero("Hombre");
		      
		    }
		});

		mujerRDB.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        setGenero("Mujer");
		       
		    }
		});
		
		ejercicioCXBN = new JComboBox();
		ejercicioCXBN.setModel(new DefaultComboBoxModel(new String[] {"No realizo ", "1-2 veces por semana", "3-5 veces por semana", "6-7 por semana"}));
		ejercicioCXBN.setBounds(488, 227, 146, 23);
		contentPane.add(ejercicioCXBN);

		
		
		JLabel pesoTxt = new JLabel();
		pesoTxt.setBounds(157, 211, 109, 14);
		pesoTxt.setText(Float.toString(peso)+ " kg");
		contentPane.add(pesoTxt);
		
		JLabel edadTxt = new JLabel("New label");
		edadTxt.setBounds(157, 131, 84, 15);
		edadTxt.setText(Integer.toString(edad) + " años");
		contentPane.add(edadTxt);
		
		JLabel estaturaTxt = new JLabel();
		estaturaTxt.setBounds(157, 340, 109, 14);
		estaturaTxt.setText(Float.toString(estatura)+" m");
		contentPane.add(estaturaTxt);
		
		//Se pueden realizar cambios en el peso y en la estatura y se realizará dicho UPDATE en la BD
		JButton pesoBtn = new JButton("Cambiar peso");
		pesoBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        double nuevoPeso = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu peso actual en kilogramos: "));
		        if (nuevoPeso > 0) {
		            try (PreparedStatement preStm = cn.prepareStatement("UPDATE usuarios_gym SET peso_gym = ? WHERE nombre_gym = ?")) {
		                preStm.setDouble(1, nuevoPeso);
		                preStm.setString(2, userName);
		                int rowsAffected = preStm.executeUpdate();

		                if (rowsAffected > 0) {
		                    // Commit changes if not auto-committed
		                    // cn.commit();

		                    setPeso(nuevoPeso);
		                    pesoTxt.setText(Double.toString(nuevoPeso) + " kg");
		                } else {
		                    JOptionPane.showMessageDialog(Nutriologo.this, "No se encontró el usuario: " + userName, "Error Cambiar Peso", JOptionPane.ERROR_MESSAGE);
		                }
		            } catch (SQLException e1) {
		                // Log or display a user-friendly message
		                e1.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(Nutriologo.this, "Por favor, ingresa un peso válido", "Error Cambiar Peso", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		pesoBtn.setBounds(157, 251, 136, 23);
		pesoBtn.setBackground(Color.black);
		pesoBtn.setForeground(Color.white);
		contentPane.add(pesoBtn);
		
		JButton estaturaBtn = new JButton("Cambiar estatura");
		estaturaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double nuevaEstatura = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu estatura actual en metros: "));
				if(nuevaEstatura > 0 && nuevaEstatura < 4) {
					 try (PreparedStatement preStm = cn.prepareStatement("UPDATE usuarios_gym SET altura_gym = ? WHERE nombre_gym = ?")) {
			               preStm.setDouble(1, nuevaEstatura);
			               preStm.setString(2, userName);
			               preStm.executeUpdate();
			               setEstatura(nuevaEstatura);
			               estaturaTxt.setText(Float.toString(estatura) + " m");
			           } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
						
					}
				}
				else {
					JOptionPane.showMessageDialog(Nutriologo.this, "Por favor, ingresa una estatura válida", "Error Cambiar Estatura", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		estaturaBtn.setBounds(157, 377, 136, 23);
		estaturaBtn.setBackground(Color.black);
		estaturaBtn.setForeground(Color.white);
		contentPane.add(estaturaBtn);
		
		//Una vez dado click en este botón se calculará el requerimiento calórico
		JButton btnNewButton = new JButton("Calcular IBM");
		 btnNewButton.setBackground(Color.black);
		 btnNewButton.setForeground(Color.white);
	
		btnNewButton.setBounds(488, 386, 146, 35);
		contentPane.add(btnNewButton);
		
		JLabel ibmLabel = new JLabel("");
		ibmLabel.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		ibmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ibmLabel.setBounds(134, 476, 500, 47);
		contentPane.add(ibmLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(genero!= null) {
					int frecuencia = ejercicioCXBN.getSelectedIndex() + 1;
					System.out.println(frecuencia);
					setEjercicio(frecuencia);
					float ibm = IBM(genero, peso, estatura, edad, ejercicio);
					int ibmInt = (int) ibm;
					ibmLabel.setText("Con tus datos podemos recomendarte que consumas al día un aproximado de " );	
					ibmLabel_1.setText( Integer.toString(ibmInt) + 
			                  " calorías por día\npara mantener un peso saludable.");
					}
				else JOptionPane.showMessageDialog(Nutriologo.this, "Por favor, determina tu género", "Error Género", JOptionPane.ERROR_MESSAGE);

				
				
			}
		});
		JButton HomeBtn = new JButton("Home");
		HomeBtn.setFont(new Font("Broadway", Font.PLAIN, 12));

		
		HomeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setHeight(estatura);
				cliente.setWeight(peso);
				backToHome(cliente);
			}
		});
		HomeBtn.setBounds(686, 567, 86, 43);
		contentPane.add(HomeBtn);
		
		JLabel label = new JLabel("");
		Image dedImg = new ImageIcon(this.getClass().getResource("/cintaDEd.png")).getImage();
		int l = 146;
		int l2 = 114;
		Image sclaedImg = dedImg.getScaledInstance(l, l2, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(sclaedImg));
		label.setBounds(488, 261, 146, 114);
		contentPane.add(label);
		
	}
	
	//getters
	public String getGenero() {
		return genero;
	}
	public void setGenero(String hombreMujer) {
		this.genero = hombreMujer;
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = (float) peso;
	}
	
	public float getEstatura(){
		return estatura;
	}
	public void setEstatura(double estatura){
		this.estatura = (float) estatura;
		
	}
	
	
	public int getEdad() {
		
		return edad;
	}

	//Método para convertir de una fecha de nacimiento a la edad respectiva
	public int toEdad(LocalDate birthDay) {
		
    	LocalDate fechaActual = LocalDate.now();
    	int edad = birthDay.until(fechaActual).getYears();
    	edad = edad < 0 ? edad +100 : edad;
    	return edad;
		
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public float ejercicio() {
		return ejercicio;
	}
	//método que asigna un valor dependiendo del nivel de ejercicio
	public void setEjercicio(int frecuencia) {
		switch(frecuencia) {
		case 1: 
			ejercicio = 1.2f;
			break;
		case 2:
			ejercicio = 1.375f;
			break;
		case 3:
			ejercicio = 1.55f;
			break;
		default:
			ejercicio = 1.725f;
		}
	}

	//método de calculó de ingesta calórica
	public float IBM(String genero, float peso, float estatura, int edad, float ejercicio) {
		float IBM = 0;
		if(genero == "Mujer") 
			IBM = (float) ((10 * peso) + (6.25 * (100* estatura)) -(5 * edad) - 161);
		
		else
			IBM = (float) ((10 * peso) + (6.25 * (100* estatura)) -(5 * edad) + 5);;
		
		return IBM*ejercicio;
	}
	
	public void backToHome(Cliente cliente) {
		Home home = new Home(cliente);
		setVisible(false);
		dispose();
		home.setVisible(true);

	}
}