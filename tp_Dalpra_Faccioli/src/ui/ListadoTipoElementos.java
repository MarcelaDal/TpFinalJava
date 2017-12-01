package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;


import controlers.CtrlABMCTipoElementos;
import entity.TipoElementos;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ListadoTipoElementos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<TipoElementos> tipoelementos;
	CtrlABMCTipoElementos ctrl= new CtrlABMCTipoElementos();

	
	public ListadoTipoElementos() {
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(btnEditar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 240));
		contentPane.setLayout(gl_contentPane);
		
		try{
			this.tipoelementos= ctrl.getAll();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	
	protected void btnEditarClick() {
		int indexTipoElemento=table.convertRowIndexToModel(table.getSelectedRow());
		if(indexTipoElemento!=-1){
			ABMCTipoElementos pd= new ABMCTipoElementos();
			pd.showTipoElementos(this.tipoelementos.get(indexTipoElemento));
			
			//this.getDesktopPane().add(pd);
			pd.setVisible(true);
			this.dispose();
		}
		
	}
	protected void initDataBindings() {
		JTableBinding<TipoElementos, List<TipoElementos>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, tipoelementos, table);
		//
		BeanProperty<TipoElementos, String> tipos_elementosBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(tipos_elementosBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<TipoElementos, String> tipos_elementosBeanProperty_1 =BeanProperty.create("canMaxResPend");
		jTableBinding.addColumnBinding(tipos_elementosBeanProperty_1).setColumnName("Cantidad máxima reservas pendientes").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
