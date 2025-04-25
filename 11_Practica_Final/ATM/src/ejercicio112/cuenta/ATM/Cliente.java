package ejercicio112.cuenta.ATM;
import java.io.Serializable;
import java.util.ArrayList;

import ejercicio112.cuenta.ATM.Cuenta;
import ejercicio113.login.ATM.registro;

@SuppressWarnings({ "serial", "unused" })
public class Cliente implements Serializable{

	
	//Variables globales
	public int id;
	private String username;
	private String NPIN;
	private int mi_numero_cuenta;
	private int transacciones;
	

	public Cliente(int ID, String uname, String PIN) {
		
		this.id = ID;
		this.username = uname;
		this.NPIN = PIN;
		
	}
	
	
	//Getters y setters
	
	public String getUsername() {
		return username;
	}

	public int getId() {
		return id;
	}


	public String getNPIN() {
		return this.NPIN;
	}
	
	public int getTransacciones() {
		return transacciones;
	}
	
	public void addTransaccion() {
		this.transacciones = transacciones + 1;
	}
	
	
	String validarPin() {
		return this.NPIN;
	}
	
	

	public int setId(int id) {
		// TODO Auto-generated method stub
		return this.id = id;
	}
}
