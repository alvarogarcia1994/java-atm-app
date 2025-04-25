package ejercicio115.operaciones.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicio112.cuenta.ATM.Cuenta;

@SuppressWarnings("unused")
public class Nueva_cuenta {

	public static void apertura(Cuenta cl) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "");
			String sql = ("INSERT INTO CUENTA (ID_Cliente, Saldo, Tipo) VALUES(" + cl.getNID_C() + ", "+ cl.getSaldo() + ", '" + cl.getTipo() + "' );");
			System.out.println("sql insert cuenta: " + sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
