package ejercicio113.login.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import ejercicio112.cuenta.ATM.Cliente;

@SuppressWarnings("unused")
public class Conexion_MySQL {

	public Connection conexion;
	public Statement sentencia;
	public ResultSet resultado;

	public void ConectarBasedeDatos(){
	 try {
		 final String Control = "com.mysql.cj.jdbc.Driver";
		 Class.forName(Control);
		 final String url_bd = "jdbc:mysql://localhost:3306/atm";
		 conexion = DriverManager.getConnection(url_bd,"root","");
		 sentencia = conexion.createStatement();
	 } catch (ClassNotFoundException | SQLException ex) {
		 JOptionPane.showMessageDialog(null,ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
	 	}
	}

	 public void DesconectarBasedeDatos() {
		 try {
			 if (conexion != null ) {
				 if(sentencia != null) {
					 sentencia.close();
				 }
				 conexion.close();
			 }
		 } catch (SQLException ex) {
			 JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			 System.exit(1);
		 }
	 }
	 
	 
	 public Connection getConnection(){
		 return conexion;
	 }

	



	 
	 
}
