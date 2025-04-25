package ejercicio112.cuenta.ATM;

import java.util.Comparator;

public class ComparadorNombres implements Comparator<Cliente>{

	@Override
	public int compare(Cliente c1, Cliente c2) {
		// TODO Auto-generated method stub
		return c1.getUsername().compareToIgnoreCase(c2.getUsername());
	}

}
