package ejercicio114.menu.ATM;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ejercicio113.login.ATM.Conexion_MySQL;

@SuppressWarnings("serial")
public class consultar_saldo extends JFrame{
	
	//JLabel
	JLabel id_Cuenta;
	
	//JTextField
	JTextField cuenta;
		
	//JPanel
	JPanel centro; 
	JPanel sur;
		
	//JButton
	JButton confirmar;
	
	public consultar_saldo() {
		setTitle("Consultar saldo.");
		setSize(230,230);
		
		Container cp = getContentPane();
		
		id_Cuenta = new JLabel("ID: ");
		cuenta = new JTextField(15);
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(1,2));
		cp.add(centro, BorderLayout.CENTER);
		
		centro.add(id_Cuenta);
		centro.add(cuenta);
		
		sur = new JPanel();
		cp.add(sur, BorderLayout.SOUTH);
		
		confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Conexion_MySQL con = new Conexion_MySQL();
					int campo_2 = Integer.parseInt(cuenta.getText());
					con.ConectarBasedeDatos();	
					String sql1 = ("SELECT SALDO FROM CUENTA WHERE ID = " + campo_2);
					con.resultado = con.sentencia.executeQuery(sql1);
					
					if (con.resultado.next()) {
						Double saldo = con.resultado.getDouble(1);
						JOptionPane.showMessageDialog(null, "Saldo disponible: " + saldo);
					}
					 else {
						JOptionPane.showMessageDialog(null, "Cuenta Inexistente");
					 }

					con.resultado.close();
						
				} catch (Exception e5) {
					e5.printStackTrace();
				}
			}
			
		});
	
		sur.add(confirmar);
		setVisible(true);
		
	}

}
