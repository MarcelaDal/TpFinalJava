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

import controlers.CtrlABMCElementos;
import entity.Elemento;

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

public class ListadoElementos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Elemento> elementos;
	CtrlABMCElementos ctrl= new CtrlABMCElementos();
	
	/**
	 * Create the frame.
	 */
	public ListadoElementos() {
		
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
			this.elementos=ctrl.getAll();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	
	protected void btnEditarClick() {
		int indexElemento=table.convertRowIndexToModel(table.getSelectedRow());
		
		ABMCElementos pd= new ABMCElementos();
		pd.showElementos(this.elementos.get(indexElemento));
		pd.setVisible(true);
		this.dispose();
	}
	protected void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, elementos, table);
		//
		BeanProperty<Elemento, String> elementoBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		
		BeanProperty<Elemento, String> elementoBeanProperty_1 = BeanProperty.create("tipo.nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("Tipo Elemento").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
