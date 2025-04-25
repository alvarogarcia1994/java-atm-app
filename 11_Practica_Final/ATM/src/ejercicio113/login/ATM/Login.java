package ejercicio113.login.ATM;

import javax.swing.JFrame;

import ejercicio114.menu.ATM.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class Login extends JFrame{
	
	//Etiquetas
	JLabel Titulo;
	JLabel l_usuario;
	JLabel pass;
	
	
	//JPanel
	JPanel centro;
	JPanel sur;
	
	//TextField
	JTextField username;
	
	//JPassword
	JPasswordField passwd;
	
	//JButton
	JButton log;
	JButton alta;
	JButton cancel;
	
	public Login() {
		//Titulo
		setTitle("Acceso a la app.");
		setSize(500,500);
		
		
		//Fuentes
		Font f1 = new Font("Times New Roman", Font.BOLD, 40);
		
		//Contenedor
		Container cp = getContentPane();
		Titulo = new JLabel("Accede a tu cuenta o date de alta.", SwingConstants.CENTER);
		Titulo.setFont(f1);
		cp.add(Titulo, BorderLayout.NORTH);
		
		//Contenido del panel central
		centro = new JPanel();
		centro.setLayout(new GridLayout(2,2));
		cp.add(centro, BorderLayout.CENTER);
		
		l_usuario = new JLabel("Username: ");
		username = new JTextField(15);
		centro.add(l_usuario);
		centro.add(username);
		
		pass = new JLabel("Contraseña: ");
		passwd = new JPasswordField();
		centro.add(pass);
		centro.add(passwd);
		
		sur = new JPanel();
		cp.add(sur, BorderLayout.SOUTH);
		
		log = new JButton("Confirmar");
		log.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Logger log = Logger.getLogger("P11.TXT");
					FileHandler fh;
					fh = new FileHandler("p11.txt");
					Conexion_MySQL con = new Conexion_MySQL();
					String user = username.getText();
					String pin = String.valueOf(passwd.getPassword());
					con.ConectarBasedeDatos();
					String sql = ("SELECT ID FROM CLIENTES WHERE Username='" + user + "'" +" AND PIN = '" + pin + "' ");
					con.resultado = con.sentencia.executeQuery(sql);
					log.addHandler(fh);
					SimpleFormatter format = new SimpleFormatter();
					fh.setFormatter(format);
					
					if(con.resultado.next()) {
						setVisible(false);
						main_menu menu = new main_menu();
						menu.setVisible(true);
						log.info("El usuario " + username.getText()  + " se ha logeado." );
						
					} else {
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
							log.info("El usuario " + username.getText()  + " es inexistente o ha introducido mal su contraseña." );
					}
							
					con.DesconectarBasedeDatos();
		
				
				} catch (SQLException | SecurityException | IOException ex) {
					ex.printStackTrace();
					Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
	
		});
		sur.add(log);
		
		alta = new JButton("Registráte");
		alta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
				JFrame registro = new registro(Login.this);
				registro.setVisible(true);
			}
			
		});
		
		
		sur.add(alta);
		
		cancel = new JButton("Salir");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Chao");
				System.exit(0);
			}
			
		});
		
		sur.add(cancel);
		
		setVisible(true);
		
		
	}

	
}
