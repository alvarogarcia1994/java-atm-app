package ejercicio112.cuenta.ATM;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cuenta implements Serializable {

	public int NID;
	public long NID_C;
	public double saldo;
	public String tipo;

	public Cuenta(int NID_cuenta, long id_cliente, Double saldo, String tipo) {
		this.NID = NID_cuenta;
		this.NID_C = id_cliente;
		this.saldo = saldo;
		this.tipo = tipo;
	}

	void info() {
		System.out.println("Número de cuenta: " + this.NID);
		System.out.println("ID Cliente: " + this.NID_C);
		System.out.println("Saldo: " + this.saldo);
		System.out.println("Tipo: " + this.tipo);
	}

	// Getters y setters
	public int getID() {
		return this.NID;
	}

	public void setID(int ID) {
		this.NID = ID;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public long getNID_C() {
		return this.NID_C;
	}

	public void setNID_C(int nID_C) {
		this.NID_C = nID_C;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTypeAhorros() {
		this.tipo = "Ahorros";
	}

	public void setTypeCorriente() {
		this.tipo = "Corriente";
	}

}
