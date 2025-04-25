package ejercicio111.abrir;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ejercicio112.cuenta.ATM.Cuenta;
import ejercicio114.menu.ATM.*;
import ejercicio115.operaciones.ATM.Nueva_cuenta;

@SuppressWarnings("serial")
public class nueva_cuenta extends JFrame{
	
	//Container
	Container cp;
	
	//JLabel
	JLabel titulo;
	
	//JPanel
	JPanel centro;
	
	//JButton
	JButton ahorros;
	JButton corriente;
	JButton salir;

	public nueva_cuenta() {
		//Titulos
		setTitle("Nueva cuenta");
		
		//Tamaño
		setSize(200,200);
		
		//Fuentes
		Font f1 = new Font("Times New Roman", Font.BOLD, 40);
		
		//Contenedor
		Container cp = getContentPane();
		
		//JLabel
		titulo = new JLabel("Elige el tipo de cuenta", SwingConstants.CENTER);
		titulo.setFont(f1);
		cp.add(titulo, BorderLayout.NORTH);
		
		//JPanel
		centro = new JPanel();
		cp.add(centro, BorderLayout.CENTER);
		
		
		//JButtons
		ahorros = new JButton("Cuenta de ahorros");
		ahorros.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Cuenta cl = new Cuenta(-1, System.currentTimeMillis(), 0.0, "Ahorro");
					Nueva_cuenta.apertura(cl);	
					JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
					setVisible(false);
					dispose();
					new main_menu();
					
				} catch(Exception e2) {
					e2.printStackTrace();
				}
			}
			
		});
		
		corriente = new JButton("Cuenta corriente");
		corriente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Cuenta cl = new Cuenta(-1, System.currentTimeMillis(), 0.0, "Corriente");
					Nueva_cuenta.apertura(cl);
					JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
					setVisible(false);
					dispose();
					new main_menu();
					
				} catch(Exception e3) {
					e3.printStackTrace();
				}
			}
			
		});
		
		centro.add(ahorros);
		centro.add(corriente);
		
	}

}
