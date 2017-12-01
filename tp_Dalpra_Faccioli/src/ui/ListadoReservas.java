package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;


import controlers.CtrlABMCReservas;
import entity.CurrentUser;
import entity.Persona;
import entity.Reserva;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

public class ListadoReservas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Reserva> reservas;
	CtrlABMCReservas ctrl= new CtrlABMCReservas();
	
	/**
	 * Create the frame.
	 */
	public ListadoReservas() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		btnCancelarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCancelarReservaClick();
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnSalirClick();
			}

			
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnCancelarReserva, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir)
						.addComponent(btnCancelarReserva))
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 240));
		contentPane.setLayout(gl_contentPane);
		
		try{
			Persona per= CurrentUser.getCurrentUser().getUsuario();
			if(per.getCategoria().getId()==1){
				this.reservas=ctrl.getAll();
			} else{
				this.reservas=ctrl.getByUsuario(per);
			}
			
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	
	protected void btnCancelarReservaClick() {
		int indexReserva=table.convertRowIndexToModel(table.getSelectedRow());
		if(indexReserva!=-1){
			int confirmado = JOptionPane.showConfirmDialog(contentPane,"¿Está seguro que desea cancelar su reserva?");
			if (JOptionPane.OK_OPTION == confirmado){
				try {
					ctrl.delete(this.reservas.get(indexReserva));
					JOptionPane.showMessageDialog(contentPane, "Reserva Cancelada");
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
	
	protected void btnSalirClick() {
		this.dispose();		
	}	
	
	
	protected void initDataBindings() {
		
		//TODO: preguntar si el admin ve las reservas canceladas tambien
		
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, reservas, table);
		//
		BeanProperty<Reserva, String> reservaBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(reservaBeanProperty).setColumnName("ID Reserva").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_1 = BeanProperty.create("persona.nombre");
		jTableBinding.addColumnBinding(reservaBeanProperty_1).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_2 = BeanProperty.create("persona.apellido");
		jTableBinding.addColumnBinding(reservaBeanProperty_2).setColumnName("Apellido").setEditable(false);
		//
		BeanProperty<Reserva, String> personaBeanProperty_3 = BeanProperty.create("elemento.nombre");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Elemento Reservado").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_4 = BeanProperty.create("fecha");
		jTableBinding.addColumnBinding(reservaBeanProperty_4).setColumnName("Fecha").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_5 = BeanProperty.create("hora");
		jTableBinding.addColumnBinding(reservaBeanProperty_5).setColumnName("Hora").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}