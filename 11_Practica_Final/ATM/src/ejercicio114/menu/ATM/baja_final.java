package ejercicio114.menu.ATM;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ejercicio113.login.ATM.Conexion_MySQL;

@SuppressWarnings("serial")
public class baja_final extends JFrame{
	
	//JLabel
	JLabel ID_Cliente;
	
	//JTextField
	JTextField cliente;
		
	//JPanel
	JPanel centro; 
	JPanel sur;
		
	//JButton
	JButton confirmar;
	JButton cancel;
	
	public baja_final() {
		setTitle("Borrar cuenta mediante ID");
		setSize(230,230);
		
		Container cp = getContentPane();
		
		ID_Cliente = new JLabel("ID: ");
		cliente = new JTextField(15);
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(1,2));
		cp.add(centro, BorderLayout.CENTER);
		
		centro.add(ID_Cliente);
		centro.add(cliente);
		
		sur = new JPanel();
		cp.add(sur, BorderLayout.SOUTH);
		
		confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Conexion_MySQL con = new Conexion_MySQL();
					int campo_2 = Integer.parseInt(cliente.getText());
					con.ConectarBasedeDatos();	
					String sql1 = ("SELECT * FROM CLIENTES WHERE ID = " + campo_2);
					con.resultado = con.sentencia.executeQuery(sql1);
					
					if (cliente.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Cuenta a eliminar!!!");
					} else if (con.resultado.next()){
						String sql2 = ("DELETE FROM CLIENTES WHERE ID = " + cliente.getText());
						JDialog.setDefaultLookAndFeelDecorated(true);
					    int response = JOptionPane.showConfirmDialog(null, "Estás seguro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.NO_OPTION) {
					      System.out.println("No button clicked");
					    } else if (response == JOptionPane.YES_OPTION) {
					      System.out.println("Yes button clicked");
					      JOptionPane.showMessageDialog(null, "Operación realizada con éxito");
						  con.sentencia.executeUpdate(sql2);
					    } else if (response == JOptionPane.CLOSED_OPTION) {
					      System.out.println("JOptionPane closed");
					    }
						
					    
					} else {
						JOptionPane.showMessageDialog(null, "No existe este cliente. ");
					}
				} catch (Exception e5) {
					e5.printStackTrace();
				}
			}
			
		});
		
	
		sur.add(confirmar);
		setVisible(true);
		
	}

}
