package ejercicio114.menu.ATM;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import ejercicio111.abrir.nueva_cuenta;
import ejercicio112.cuenta.ATM.Cuenta;
import ejercicio113.login.ATM.*;

@SuppressWarnings({ "unused", "serial" })
public class main_menu extends JFrame{
	
	//JLabel
	JLabel info;
	
	//Botones
	JButton abrir_cuenta;
	JButton baja_definitiva;
	JButton retirar_dinero;
	JButton cerrar_cuenta;
	JButton ingresar_dinero_en_otra_cuenta;
	JButton depositar_dinero;
	JButton consultar_saldo;
	JButton salir;
	
	//JPanel
	JPanel centro;
	JPanel sur;
	
	//JTextArea
	JTextArea log;
	
	public main_menu() {
		
		setTitle("Menú principal");
		setSize(500,500);
		Cuenta c;
		//Fuentes
		Font f1 = new Font("Times New Roman", Font.BOLD, 40);
				
		Container cp = getContentPane();
		
		info = new JLabel("Qué operación desea realizar.", SwingConstants.CENTER);
		info.setFont(f1);
		cp.add(info, BorderLayout.NORTH);
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(2,4));
		cp.add(centro, BorderLayout.CENTER);
		
		abrir_cuenta = new JButton("Abrir cuenta");
		abrir_cuenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				nueva_cuenta nc = new nueva_cuenta();
				nc.setVisible(true);
			}
			
		});
		
		baja_definitiva = new JButton("Eliminar cuenta");
		baja_definitiva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new baja_final();
				
			}
			
		});
		
		retirar_dinero = new JButton("Retirar dinero");
		retirar_dinero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new retirada();
				setVisible(true);
			}
			
		});
		
		
		cerrar_cuenta = new JButton("Cerrar cuenta");
		cerrar_cuenta.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new Borrar();
				setVisible(true);
			}
			
		});
		
		ingresar_dinero_en_otra_cuenta = new JButton("Ingresar dinero en otra cuenta");
		ingresar_dinero_en_otra_cuenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new ingresar_saldo_en_otra_cuenta();
				setVisible(true);
			}
			
		});
		
		depositar_dinero = new JButton("Depositar dinero");
		depositar_dinero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				new ingresar_saldo();
				setVisible(true);
			}
			
		});
		
		consultar_saldo = new JButton("Consultar saldo");
		consultar_saldo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new consultar_saldo();
				setVisible(true);
			}
		});
		
		salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setVisible(false);
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
			
		});
		
		centro.add(abrir_cuenta);
		centro.add(baja_definitiva);
		centro.add(retirar_dinero);
		centro.add(cerrar_cuenta);
		centro.add(ingresar_dinero_en_otra_cuenta);
		centro.add(depositar_dinero);
		centro.add(consultar_saldo);
		centro.add(salir);
		
	}

}
