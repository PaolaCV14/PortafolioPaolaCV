package proyecto;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
//import java.time.Period;
import java.time.format.DateTimeFormatter;

//Clase motora de la aplicación ya que es el cliente aquel que contiene el contructor para almacenar todos los datos recuperados por la BD
public class Cliente {
    private String clave;
    private String nombre;
    private double pagos;
    private String reservas;
    private LocalDate dateOfBirth;
    private double height;
    private double weight;

	//Contructor principal con todos los atributos para un cliente
    public Cliente(String nombre, String clave, double pagos, double height,LocalDate dateOfBirth, double weight, String reservas) {
    	this(nombre, clave);
    	setPagos(pagos);
    	setHeight(height);
    	setWeight(weight);
    	setDate(dateOfBirth);
    	setReservas(reservas);
    	
    }
    public Cliente(String nombre, String clave, double weight) {
    	this(nombre, clave);
    	setWeight(weight);
    }
    public Cliente(String nombre, String clave) {
    	setNombre(nombre);
    	setClave(clave);
    }
    public Cliente() {}
    
    //getters
    public LocalDate getDateOfBirth() {
    	return dateOfBirth;
    }
    
    public double getHeight() {
    	return height;
    }
    
    public double getWeight() {
    	return weight;
    }
    
    public String getClave() {
        return clave;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPagos() {
        return pagos;
    }
    public String getReservas() {
    	return reservas;
    }
    public void setReservas(String reservas) {
    	this.reservas = reservas;
    }
    //setters
    public void setClave(String clave) {
    	this.clave = clave;
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPagos(double pagos) {
    	this.pagos = pagos;
    }

    
    public void setHeight(double height) {
		 this.height = height; }
    

    
    public void setWeight(double weight) {
		this.weight = weight;
    }

    public void setDate(LocalDate dateOfBirth) {
		 this.dateOfBirth = dateOfBirth;
    	
    }
    




    //Con esta función se puede obtener una lista de todos los usuarios dentro de la base de datos
	public  List<Cliente> listaCliente(Connection cn) throws SQLException{
    	List<Cliente> listaClientes = new ArrayList<Cliente>();
        try (PreparedStatement stm = cn.prepareStatement("SELECT * FROM usuarios_gym");
                ResultSet rs = stm.executeQuery()) {
               while (rs.next()) {
                  
                   String nombreUsuario = rs.getString("nombre_gym");
                   String claveUsuario = rs.getString("clave_usuario");
                   double pagos = rs.getDouble("pagos");
                   double height = rs.getDouble("altura_gym");
                   double peso = rs.getDouble("peso_gym");
                   String dateOfBirthStr = rs.getString("nacimiento_gym");
           		   DateTimeFormatter formater =   DateTimeFormatter.ofPattern("dd/MM/yy");
           		   LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formater);
               
                   String reservaciones = rs.getString("reservas");
                   

                   // Create a User object and add it to the list
                   Cliente cliente = new Cliente(nombreUsuario, claveUsuario, pagos, height, dateOfBirth, peso, reservaciones);
                   listaClientes.add(cliente);
                   
               }
           }
        return listaClientes;
    			 
    }
	
	public String toString() {
		return "\nCliente: " +nombre + "\nClave: " + clave + "\nPagos: " + pagos + "\nPeso: " + weight + "\nEstatura: " + height +"\nBirthDay" + dateOfBirth + "\nReservas: " + reservas;
	}
}