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

import ejercicio113.login.ATM.*;

@SuppressWarnings("serial")
public class Borrar extends JFrame{

	JLabel menu;
	
	//JTextField
	JTextField cuenta;
	
	//JPanel
	JPanel centro; 
	JPanel sur;
	
	//JButton
	JButton confirmar;
	JButton cancel;
	
	public Borrar() {
		setTitle("Borrar cuenta mediante ID");
		setSize(230,230);
		
		Container cp = getContentPane();
		
		menu = new JLabel("ID: ");
		cuenta = new JTextField(15);
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(1,2));
		cp.add(centro, BorderLayout.CENTER);
		
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
					int campo_2 = Integer.parseInt(cuenta.getText());
					con.ConectarBasedeDatos();	
					String sql1 = ("SELECT * FROM CUENTA WHERE ID = " + campo_2);
					con.resultado = con.sentencia.executeQuery(sql1);
					if (cuenta.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Cuenta a eliminar!!!");
					} else if (con.resultado.next()){
						String sql2 = ("DELETE FROM CUENTA WHERE ID = " + cuenta.getText());
						int response = JOptionPane.showConfirmDialog(null, "Estás seguro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    if (response == JOptionPane.NO_OPTION) {
						      System.out.println("No button clicked");
						    } else if (response == JOptionPane.YES_OPTION) {
						      System.out.println("Yes button clicked");
						      JOptionPane.showMessageDialog(null, "Operación realizada con éxito");
							  con.sentencia.executeUpdate(sql2);
							  setVisible(false);
							  dispose();
							  new main_menu();
						    } else if (response == JOptionPane.CLOSED_OPTION) {
						      System.out.println("JOptionPane closed");
						    }
						
					} else {
						JOptionPane.showMessageDialog(null, "Cuenta Inexistente");
					}
				} catch (Exception e5) {
					e5.printStackTrace();
				}
				
			}
			
		});
		
		cancel = new JButton("Cancelar");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
			}
			
		});
	
		sur.add(confirmar);
		sur.add(cancel);
		setVisible(true);
	}

}
