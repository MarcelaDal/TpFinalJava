package ui;

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

import controlers.CtrlABMCElementos;
import entity.TipoElementos;
import entity.Categoria;
import entity.Elemento;

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
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class ABMCElementos extends JFrame {

	private CtrlABMCElementos ctrl=new CtrlABMCElementos();	
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JComboBox cboTipoElemento;
	private JPanel panelElementos;
	private JTextField txtId;
	private JLabel lblId;
	private JCheckBox chkHabilitado;

	
	public ABMCElementos() {
		//setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 738, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelElementos = new JPanel();
		panelElementos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mantenimiento Elementos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txtId = new JTextField();
		txtId.setBounds(252, 43, 100, 20);
		txtId.setEditable(false);
		txtId.setEnabled(false);
		txtId.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setBounds(208, 46, 26, 14);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnVaciarCampos = new JButton("Vaciar campos");
		btnVaciarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vaciarCampos();
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
					.addComponent(panelElementos, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelElementos, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnBuscar = new JButton("Buscar");
				
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		btnBuscar.setBounds(432, 88, 100, 23);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(166, 92, 68, 14);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(252, 90, 170, 20);
		txtNombre.setColumns(10);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		lblTipoElemento.setBounds(128, 134, 106, 14);
		lblTipoElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cboTipoElemento = new JComboBox();
		cboTipoElemento.setBounds(252, 131, 170, 20);
		
		JButton btnAgregarElemento = new JButton("Agregar Elemento");
		btnAgregarElemento.setBounds(10, 288, 136, 34);
		btnAgregarElemento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnAgregarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarClick();
			}
		});
		
		JButton btnModificarDatos = new JButton("Modificar Datos");
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificarDatos.setBounds(163, 288, 136, 34);
		btnModificarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificarClick();
			}
		});
		
		JButton btnBorrarElemento = new JButton("Eliminar Elemento");
		btnBorrarElemento.setBounds(321, 288, 148, 34);
		btnBorrarElemento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		btnBorrarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelElementos.setLayout(null);
		panelElementos.add(lblId);
		panelElementos.add(txtId);
		panelElementos.add(btnBuscar);
		panelElementos.add(lblNombre);
		panelElementos.add(txtNombre);
		panelElementos.add(lblTipoElemento);
		panelElementos.add(cboTipoElemento);
		panelElementos.add(btnAgregarElemento);
		panelElementos.add(btnModificarDatos);
		panelElementos.add(btnBorrarElemento);
		panelElementos.add(btnVaciarCampos);
		
		JButton btnListado = new JButton("Listado");
		
		btnListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mnuListadoElementosClick();
			}
		});
		
		btnListado.setBounds(551, 288, 136, 34);
		panelElementos.add(btnListado);
		
		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setBounds(252, 170, 97, 23);
		panelElementos.add(chkHabilitado);
		contentPane.setLayout(gl_contentPane);
		cargarListas();
	}
	protected void agregarClick() {
		Elemento ele = this.mapearDeForm();
		try{
			if(this.validaCampos()){
				ctrl.add(ele);	
				JOptionPane.showMessageDialog(contentPane, "Nuevo elemento agregado con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				this.vaciarCampos();
			}
			else{
				JOptionPane.showMessageDialog(contentPane, "Rellene todos los campos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(contentPane, "Ha sucedido un error, intente nuevamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

		}
		this.txtId.setText(String.valueOf(ele.getId()));
		
	}
	
	protected void borrarClick(){
		try{
			if(!this.txtNombre.getText().equals("")){
				int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea dar de baja al elemento?", "Aviso", JOptionPane.YES_NO_OPTION);
				
				if (opcion == 0) { 
					ctrl.delete(this.mapearDeForm());
					JOptionPane.showMessageDialog(contentPane, "El elemento ha sido dado de baja.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
					this.vaciarCampos();
			}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Rellene el campo 'Nombre'.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			   
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No se ha podido dar de baja el elemento.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	
	protected void modificarClick(){
		try{
			if(!this.txtNombre.getText().equals("")){
				ctrl.update(this.mapearDeForm());	
				JOptionPane.showMessageDialog(contentPane, "Elemento modificado con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				this.vaciarCampos();
			}else{
				JOptionPane.showMessageDialog(contentPane, "Rellene el campo 'Nombre'.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No se ha podido realizar la modificación.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

		e.printStackTrace();
		}
	}
	
	private void mapearAForm(Elemento ele){
		this.txtNombre.setText(ele.getNombre());
		if (ele.getTipo() !=null){
			this.cboTipoElemento.setSelectedItem(ele.getTipo());
		}
		this.txtId.setText(String.valueOf(ele.getId()));
		this.chkHabilitado.setSelected(ele.isHabilitado());
	}
	
	
	protected void buscarClick() {
		try {
			if(!this.txtNombre.getText().equals("")){
			this.mapearAForm(ctrl.getByNombre(this.mapearDeForm()));
			lblId.setVisible(true);
			txtId.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(contentPane, "Rellene el campo 'Nombre'.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No se ha podido encontrar el elemento.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	private Elemento mapearDeForm(){
		Elemento ele=new Elemento();
		if(!this.txtId.getText().isEmpty()){
			ele.setId(Integer.parseInt(this.txtId.getText()));
		}
		ele.setNombre(this.txtNombre.getText());
		if (cboTipoElemento.getSelectedIndex() != -1){
			ele.setTipo((TipoElementos)cboTipoElemento.getSelectedItem());
		}
		ele.setHabilitado(this.chkHabilitado.isSelected());
		return ele;
	}
	
	public void showElementos(Elemento ele){
		this.mapearAForm(ele);
	}
	
	private void cargarListas() {
		try {
			this.cboTipoElemento.setModel(new DefaultComboBoxModel(this.ctrl.getTipoElementos().toArray()));
			this.cboTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error recuperando Tipos de Elementos", "Error", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	protected void mnuListadoElementosClick() {
		this.dispose();
		ListadoElementos le= new ListadoElementos();
		le.setVisible(true);
		
	}
	private boolean validaCampos(){
		if((!this.txtNombre.getText().equals("") )&&
		(this.cboTipoElemento.getSelectedItem()!=null))
		{
			return true;
		}else{
			return false;
		}
	}
	
	private void vaciarCampos(){
		txtId.setText("");
		txtNombre.setText("");
		cboTipoElemento.setSelectedItem(null);
		chkHabilitado.setSelected(false);
	}
}
