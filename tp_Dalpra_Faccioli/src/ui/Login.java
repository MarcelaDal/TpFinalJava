package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import controlers.CtrlABMCClientes;
import entity.Persona;
import entity.CurrentUser;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Acceso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(120, 56, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setBounds(96, 105, 70, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(176, 53, 140, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(176, 102, 140, 20);
		contentPane.add(txtContraseña);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setBounds(227, 173, 132, 23);
		contentPane.add(btnIngresar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(52, 173, 89, 23);
		contentPane.add(btnSalir);
	}

	protected void ingresar(){
		String usuario= txtUsuario.getText();
		String pass= String.valueOf(txtContraseña.getPassword());
		
				
		CtrlABMCClientes ctrl= new CtrlABMCClientes();
		Persona p= new Persona();
		p.setUsuario(usuario);
		p.setContrasenia(pass);
		
		Persona per;
		try {
			per = ctrl.login(p);
			if(per!=null){
				if(per.isHabilitado()==true){
				CurrentUser.getSingletonInstance().setUsuario(per);
				JOptionPane.showMessageDialog(contentPane, "Bienvenido, "+per.getNombre());
				
				this.dispose();
				Main window = new Main();
				window.frame.setVisible(true);
				window.visualizarBotones();
				}else{
					JOptionPane.showMessageDialog(contentPane, "Usted está habilitado para ingresar al sistema. Contacte con un Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}else{
				JOptionPane.showMessageDialog(contentPane, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
		} }
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void salir() {
		System.exit(0);
		
	}
}
