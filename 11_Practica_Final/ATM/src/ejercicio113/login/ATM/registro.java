package ejercicio113.login.ATM;

import javax.swing.*;

import ejercicio112.cuenta.ATM.Cliente;
import ejercicio116.usuario.ATM.alta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;


@SuppressWarnings({ "serial", "unused" })
public class registro extends JFrame {
	
	//JLabels
	JLabel Titulo;
	JLabel username;
	JLabel N_PIN;
	JLabel verificar;
	
	//JPanel
	JPanel centro;
	JPanel sur;
	
	//TextField
	JTextField usuario;
	
	//Contraseñas
	JTextField N_PIN1;
	
	//JButton
	JButton ok;
	JButton cancel;
	
	private Login log;
	protected int id;
	
	public registro(Login lo) {
		
		this.log = lo;
		setTitle("Nuevo usuario");
		setSize(250,250);
		
		//Fuentes
		Font f1 = new Font("Times New Roman", Font.BOLD, 40);
		
		//Container
		Container cp = getContentPane();

	
		Titulo = new JLabel("Rellena este formulario para darte de alta", SwingConstants.CENTER);
		Titulo.setFont(f1);
		cp.add(Titulo, BorderLayout.NORTH);
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(3,2));
		cp.add(centro, BorderLayout.CENTER);
		
		username = new JLabel("username: ");
		usuario = new JTextField(15);
		N_PIN = new JLabel("PIN: ");
		N_PIN1 = new JTextField(15);
		
		centro.add(username);
		centro.add(usuario);
		centro.add(N_PIN);
		centro.add(N_PIN1);
		
		
		sur = new JPanel();
		cp.add(sur, BorderLayout.SOUTH);
		
		ok = new JButton("Alta");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (usuario.getText().equals("") && N_PIN1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos");
					} else {
						JOptionPane.showMessageDialog(null, "Inserción correcta.");
						Cliente cli = new Cliente(id, usuario.getText(), N_PIN1.getText());
						alta.Alta(cli, usuario.getText(), N_PIN1.getText());
						setVisible(false);
						dispose();
						new Login();
					}
				} 
				
				catch (Exception s) {
					s.printStackTrace();
					JOptionPane.showMessageDialog(null, "No se pueden crear dos usuarios con el mismo nombre");
				}
			}
			
		});
		
		cancel = new JButton("Salir");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new Login();
			}
		});
			
		sur.add(ok);
		sur.add(cancel);
		
		setPreferredSize(new Dimension(300,150));
		
		
	}


}
