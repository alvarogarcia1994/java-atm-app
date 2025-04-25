package ejercicio115.operaciones.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicio112.cuenta.ATM.Cuenta;

@SuppressWarnings("unused")
public class ingresar_dinero {
	
	public static void ingresar(Double saldo) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "");
			String sql = ("'UPDATE cuenta SET saldo = saldo + '" + saldo);
			System.out.println("sql actualizar cuenta: " + sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
