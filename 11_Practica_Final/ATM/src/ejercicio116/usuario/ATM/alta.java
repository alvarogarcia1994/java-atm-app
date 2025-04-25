package ejercicio116.usuario.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JTextField;

import ejercicio112.cuenta.ATM.Cliente;
import ejercicio113.login.ATM.registro;

@SuppressWarnings("unused")
public class alta {
	
	
	//public static boolean Alta(int ID, String usuario, String n_PIN1) {
	public static boolean Alta(Cliente cli, String username, String PIN) {
		boolean existencia = true;
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
			@SuppressWarnings("static-access")
			String sql = ("INSERT INTO CLIENTES (ID, USERNAME, PIN) VALUES('" + cli.setId(cli.id) + "','" + username + "','" + PIN +"');");
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			existencia = false;
		}
		
		return existencia;
	}


	
}
