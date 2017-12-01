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

import controlers.CtrlABMCClientes;
import entity.Persona;

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

public class ListadoPersonas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Persona> pers;
	CtrlABMCClientes ctrl= new CtrlABMCClientes();
	
	/**
	 * Create the frame.
	 */
	public ListadoPersonas() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEditarClick();
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(btnEditar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 240));
		contentPane.setLayout(gl_contentPane);
		
		try{
			this.pers=ctrl.getAll();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	
	protected void btnEditarClick() {
		int indexPersona=table.convertRowIndexToModel(table.getSelectedRow());
		if(indexPersona!=-1){			
			ABMCClientes pd= new ABMCClientes();
			pd.showPersona(this.pers.get(indexPersona));
			
			//this.getDesktopPane().add(pd);
			pd.setVisible(true);
			this.dispose();
		}
		else JOptionPane.showMessageDialog(contentPane, "Seleccione una persona.", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	protected void initDataBindings() {
		JTableBinding<Persona, List<Persona>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, pers, table);
		//
		BeanProperty<Persona, String> personaBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_1 = BeanProperty.create("apellido");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Apellido").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_2 = BeanProperty.create("dni");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("DNI").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_3 = BeanProperty.create("categoria.descripcion");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Categoria").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_4= BeanProperty.create("habilitado");
		jTableBinding.addColumnBinding(personaBeanProperty_4).setColumnName("Habilitado").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
