package ejercicio115.operaciones.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class consultar_saldo {
	
	public void consulta_saldo(int ID) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
			String sql = ("'SELECT SALDO FROM CUENTA WHERE ID_CLIENTE  = " + ID + "')");
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		

	}

}
