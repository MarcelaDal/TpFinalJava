package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;
	private JButton btnClientes;
	private JButton btnReservas;
	private JButton btnMantenimientoTipoEle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					Login ventanaLogin= new Login();
					ventanaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setBounds(299, 54, 205, 100);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMCClientes cli= new ABMCClientes();
				cli.setVisible(true);
			}

			
		});
		frame.getContentPane().add(btnClientes);
		
		btnReservas = new JButton("Reservas");
		btnReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ABMCReservas res= new ABMCReservas();
				res.setVisible(true);
			}
		});
		btnReservas.setBounds(61, 51, 205, 106);
		btnReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnReservas);
		
		btnMantenimientoTipoEle = new JButton("Mantenimiento tipo elementos");
		btnMantenimientoTipoEle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMantenimientoTipoEle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ABMCTipoElementos mantTipoEle= new ABMCTipoElementos();
				mantTipoEle.setVisible(true);
			}
		});
		btnMantenimientoTipoEle.setBounds(299, 210, 205, 48);
		frame.getContentPane().add(btnMantenimientoTipoEle);
		
		JButton btnMantenimientoEle = new JButton("Mantenimiento Elementos");
		btnMantenimientoEle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ABMCElementos mantEle= new ABMCElementos();
				mantEle.setVisible(true);
			}
		});
		btnMantenimientoEle.setBounds(299, 274, 205, 48);
		frame.getContentPane().add(btnMantenimientoEle);
	}
}
