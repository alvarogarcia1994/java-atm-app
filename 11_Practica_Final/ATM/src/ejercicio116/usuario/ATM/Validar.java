package ejercicio116.usuario.ATM;

import java.io.IOException;

import ejercicio113.login.ATM.Conexion_MySQL;

public class Validar {
	

	public boolean buscar_usuario(String username, int pin) throws IOException{
		
		try {
			Conexion_MySQL con = new Conexion_MySQL();
			con.ConectarBasedeDatos();
			String sql = ("SELECT COUNT(ID) FROM CLIENTES WHERE Username='" + username + "'" +" AND PIN = '" + pin + "' ");
			con.resultado = con.sentencia.executeQuery(sql);
			if (con.resultado.next()) {
				return true;
			} else {
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
