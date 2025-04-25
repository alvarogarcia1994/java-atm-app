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
public class ingresar_saldo_en_otra_cuenta extends JFrame{
	//JPanel
		JPanel centro;
		JPanel sur;
		
		//JLabel
		JLabel campo;
		JLabel menu;
		
		//JTextField
		JTextField cantidad;
		
		//JComboBox
		JTextField cuenta;
		
		//JButton
		JButton confirmar;
		JButton salir;
		
		public ingresar_saldo_en_otra_cuenta() {
			setVisible(true);
			setTitle("Ingresar saldo en otra cuenta");
			setSize(350,350);
			
			Container cp = getContentPane();
			
			centro = new JPanel();
			centro.setLayout(new GridLayout(2,2));
			cp.add(centro, BorderLayout.CENTER);
			
			campo = new JLabel("Cantidad a ingresar: ");
			cantidad = new JTextField(15);
			menu = new JLabel("Cuenta de destino: ");
			cuenta = new JTextField(15);
			centro.add(campo);
			centro.add(cantidad);
			centro.add(menu);
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
						@SuppressWarnings("unused")
						Double campo_1 = Double.parseDouble(cantidad.getText());
						int campo_2 = Integer.parseInt(cuenta.getText());
						con.ConectarBasedeDatos();	
						String sql = ("SELECT ID FROM Cuenta WHERE ID = " + campo_2);
						con.resultado = con.sentencia.executeQuery(sql);
						
						if (cantidad.getText().equals(" ") || cuenta.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos");
						} else if (cantidad.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Dime una cantidad");
						} else if (con.resultado.next()){
							JOptionPane.showMessageDialog(null, "Operación realizada con éxito");
							String sql2 = ("UPDATE cuenta SET saldo =  saldo + " + cantidad.getText() + "WHERE ID = " + cuenta.getText());
							con.sentencia.executeUpdate(sql2);
							setVisible(false);
							dispose();
							new main_menu();
						} else {
							JOptionPane.showMessageDialog(null, "NO EXISTE");
						}
					} catch (Exception e5) {
						e5.printStackTrace();
					}
				}
				
			});
			
			salir = new JButton("Salir");
			salir.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "Operación anulada");
					setVisible(false);
					dispose();
					new main_menu();
				}
				
			});
			
			sur.add(confirmar);
			sur.add(salir);
		}
		

}
