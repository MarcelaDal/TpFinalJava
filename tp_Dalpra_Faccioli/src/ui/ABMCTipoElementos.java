package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;


import entity.Persona;
import entity.TipoElementos;
import entity.Categoria;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import controlers.CtrlABMCTipoElementos;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class ABMCTipoElementos extends JFrame {

	private CtrlABMCTipoElementos ctrl=new CtrlABMCTipoElementos();
		
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JPanel panelTipoElementos;
	private JLabel lblId;
	private JTextField txtId;
	private JComboBox cmbCantMaxRes;
	private JCheckBox chkHabilitado;

		/**
	 * Create the frame.
	 */
	public ABMCTipoElementos() {
		//setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 738, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelTipoElementos = new JPanel();
		panelTipoElementos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mantenimiento Tipo de Elementos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		lblId = new JLabel("ID");
		lblId.setVisible(false);
		lblId.setBounds(197, 49, 36, 14);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnVaciarCampos = new JButton("Vaciar campos");
		btnVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtId.setText("");
				txtNombre.setText("");
				txtNombre.setText("");
				chkHabilitado.setSelected(false);
				cmbCantMaxRes.setSelectedItem(null);	
				txtId.setVisible(false);
				lblId.setVisible(false);
			}
		});
		btnVaciarCampos.setBounds(550, 16, 129, 21);
		btnVaciarCampos.setFocusCycleRoot(true);
		btnVaciarCampos.setFocusPainted(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(panelTipoElementos, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelTipoElementos, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarClick();
			}
		});
		btnBuscar.setBounds(431, 77, 100, 23);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(165, 86, 68, 14);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(250, 80, 171, 20);
		txtNombre.setColumns(10);
		
		JLabel lblcantMaxRes = new JLabel("Cantidad m\u00E1xima");
		lblcantMaxRes.setBounds(75, 113, 158, 14);
		lblcantMaxRes.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnAgregarTipoElem = new JButton("Agregar Tipo");
		btnAgregarTipoElem.setBounds(10, 288, 136, 34);
		btnAgregarTipoElem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnAgregarTipoElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarClick();
			}
		});
		
		JButton btnModificarDatos = new JButton("Modificar Datos");
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificarDatos.setBounds(165, 288, 136, 34);
		btnModificarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificarClick();
			}
		});
		
		JButton btnBorrar = new JButton("Baja Tipo Elemento");
		btnBorrar.setBounds(321, 288, 136, 34);
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelTipoElementos.setLayout(null);
		panelTipoElementos.add(lblId);
		panelTipoElementos.add(btnBuscar);
		panelTipoElementos.add(lblNombre);
		panelTipoElementos.add(txtNombre);
		panelTipoElementos.add(lblcantMaxRes);
		panelTipoElementos.add(btnAgregarTipoElem);
		panelTipoElementos.add(btnModificarDatos);
		panelTipoElementos.add(btnBorrar);
		panelTipoElementos.add(btnVaciarCampos);
		
		JButton btnListado = new JButton("Listado");
		
		btnListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mnuListadoTipoElementosClick();
			}
		});
		
		btnListado.setBounds(551, 288, 136, 34);
		panelTipoElementos.add(btnListado);
		
		cmbCantMaxRes  = new JComboBox();
		cmbCantMaxRes.setModel(new DefaultComboBoxModel(new Integer[] {1, 2, 3, 4, 5, 6}));
		cmbCantMaxRes.setBounds(252, 122, 100, 20);
		panelTipoElementos.add(cmbCantMaxRes);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setVisible(false);
		txtId.setColumns(10);
		txtId.setBounds(252, 46, 100, 20);
		panelTipoElementos.add(txtId);
		
		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setBounds(252, 165, 97, 23);
		panelTipoElementos.add(chkHabilitado);
		
		JLabel lblDeReservasPendientes = new JLabel("de reservas pendientes");
		lblDeReservasPendientes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeReservasPendientes.setBounds(75, 128, 158, 14);
		panelTipoElementos.add(lblDeReservasPendientes);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	
	
	
	protected void agregarClick() {
		TipoElementos te = this.mapearDeForm();
		try{
			if(this.validaCampos()){
				ctrl.add(te);
				JOptionPane.showMessageDialog(contentPane, "Nuevo tipo de elemento agregado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			}else{
				JOptionPane.showMessageDialog(contentPane, "Rellene todos los campos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtId.setText(String.valueOf(te.getId()));
		
	}
	
	protected void borrarClick(){
		try{
			if(this.validaCampos()){
				int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Está seguro de que desea eliminar el tipo de elemento?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) { 
					ctrl.delete(this.mapearDeForm());
					JOptionPane.showMessageDialog(contentPane, "El tipo de elemento ha sido dado de baja.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(contentPane, "Rellene todos los campos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void modificarClick(){
		try{
			if(this.validaCampos()){
				ctrl.update(this.mapearDeForm());
				JOptionPane.showMessageDialog(contentPane, "Modificación exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(contentPane, "Rellene todos los campos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void buscarClick() {
		try {
			if(!this.txtNombre.getText().equals("")){
			this.mapearAForm(ctrl.getByNombre(this.mapearDeForm()));
			lblId.setVisible(true);
			txtId.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(contentPane, "Rellene el campo 'Nombre'.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No existen registros con ese nombre.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private void mapearAForm(TipoElementos te){
		this.txtId.setText(String.valueOf(te.getId()));
		this.txtNombre.setText(te.getNombre());
		this.chkHabilitado.setSelected(te.isHabilitado());
		this.cmbCantMaxRes.setSelectedItem((int)te.getCanMaxResPend());
		
	}
	
	
	private TipoElementos mapearDeForm(){
		TipoElementos te=new TipoElementos();
		if(!this.txtId.getText().isEmpty()){
			te.setId(Integer.parseInt(this.txtId.getText()));
		}
		te.setNombre(this.txtNombre.getText());
		te.setHabilitado(this.chkHabilitado.isSelected());
		if (cmbCantMaxRes.getSelectedIndex() != -1){
			te.setCanMaxResPend((int)cmbCantMaxRes.getSelectedItem());
		}
		return te;
		
	}
	
	public void showTipoElementos(TipoElementos te){
		this.mapearAForm(te);
	}
	
	protected void mnuListadoTipoElementosClick() {
		this.dispose();
		ListadoTipoElementos lte= new ListadoTipoElementos();
		lte.setVisible(true);
		
	}
	private boolean validaCampos(){
		if((!this.txtNombre.getText().equals("") )&&
		(this.cmbCantMaxRes.getSelectedItem()!=null))
		{
			return true;
		}else{
			return false;
		}
	}
}
