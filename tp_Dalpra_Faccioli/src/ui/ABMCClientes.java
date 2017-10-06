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

import controlers.CtrlABMCClientes;
import entity.Persona;
import entity.Categoria;
import entity.CurrentUser;

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

public class ABMCClientes extends JFrame {

	private CtrlABMCClientes ctrl=new CtrlABMCClientes();	
	
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JCheckBox chkHabilitado, chkVer;
	private JComboBox cboCategoria;
	private JPanel panelAgregarClientes;
	private JTextField txtId;
	private JLabel lblId, lblContrasenia, lblCategoria;
	private JPasswordField txtContrasenia;
	private JButton btnModificarDatos, btnAgregarCliente, btnBorrar, btnBuscar, btnListado, btnVaciarCampos;


	/**
	 * Create the frame.
	 */
	public ABMCClientes() {
		//setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 738, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelAgregarClientes = new JPanel();
		panelAgregarClientes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(176, 56, 100, 20);
		txtId.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setBounds(132, 59, 26, 14);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btnVaciarCampos = new JButton("Vaciar campos");
		btnVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtId.setText("");
				txtDni.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				cboCategoria.setSelectedItem(null);
				chkHabilitado.setSelected(false);
				txtContrasenia.setText("");
				txtId.setVisible(false);
				lblId.setVisible(false);
				
			}
		});
		btnVaciarCampos.setBounds(550, 16, 129, 21);
		btnVaciarCampos.setFocusCycleRoot(true);
		btnVaciarCampos.setFocusPainted(false);
		btnVaciarCampos.setVisible(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(panelAgregarClientes, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelAgregarClientes, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblDni = new JLabel("DNI*");
		lblDni.setBounds(118, 89, 40, 14);
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtDni = new JTextField();
		txtDni.setBounds(176, 86, 100, 20);
		txtDni.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setVisible(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		btnBuscar.setBounds(294, 85, 100, 23);
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(90, 126, 68, 14);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(176, 119, 100, 20);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido*");
		lblApellido.setBounds(90, 161, 68, 14);
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(176, 158, 100, 20);
		txtApellido.setColumns(10);
		
		lblCategoria = new JLabel("Categor\u00EDa*");
		lblCategoria.setVisible(false);
		lblCategoria.setBounds(79, 196, 79, 14);
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cboCategoria = new JComboBox();
		cboCategoria.setVisible(false);
		cboCategoria.setBounds(176, 193, 100, 20);
		
		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setVisible(false);
		chkHabilitado.setSelected(true);
		chkHabilitado.setBounds(176, 267, 100, 23);
		
		btnAgregarCliente = new JButton("Agregar Cliente");
		btnAgregarCliente.setVisible(false);
		btnAgregarCliente.setBounds(10, 338, 136, 34);
		btnAgregarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarClick();
			}
		});
		
		btnModificarDatos = new JButton("Modificar Datos");
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificarDatos.setBounds(163, 338, 136, 34);
		btnModificarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificarClick();
			}
		});
		
		btnBorrar = new JButton("Borrar Cliente");
		btnBorrar.setVisible(false);
		btnBorrar.setBounds(321, 338, 136, 34);
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
		panelAgregarClientes.setLayout(null);
		panelAgregarClientes.add(lblId);
		panelAgregarClientes.add(txtId);
		panelAgregarClientes.add(lblDni);
		panelAgregarClientes.add(txtDni);
		panelAgregarClientes.add(btnBuscar);
		panelAgregarClientes.add(lblNombre);
		panelAgregarClientes.add(txtNombre);
		panelAgregarClientes.add(lblApellido);
		panelAgregarClientes.add(txtApellido);
		panelAgregarClientes.add(lblCategoria);
		panelAgregarClientes.add(cboCategoria);
		panelAgregarClientes.add(chkHabilitado);
		panelAgregarClientes.add(btnAgregarCliente);
		panelAgregarClientes.add(btnModificarDatos);
		panelAgregarClientes.add(btnBorrar);
		panelAgregarClientes.add(btnVaciarCampos);
		
		btnListado = new JButton("Listado");
		btnListado.setVisible(false);
		
		btnListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mnuListadoPersonaClick();
			}
		});
		
		btnListado.setBounds(551, 338, 136, 34);
		panelAgregarClientes.add(btnListado);
		
		lblContrasenia = new JLabel("Contrase\u00F1a*");
		lblContrasenia.setVisible(false);
		lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenia.setBounds(58, 233, 100, 14);
		panelAgregarClientes.add(lblContrasenia);
		
		//TODO agregar funcionalidad para cambio de contraseña
		txtContrasenia = new JPasswordField();
		txtContrasenia.setVisible(false);
		//TODO eliminar linea de abajo
		txtContrasenia.setText("hola");
		txtContrasenia.setBounds(176, 230, 100, 20);
		panelAgregarClientes.add(txtContrasenia);
		
		chkVer = new JCheckBox("Ver");
		chkVer.setVisible(false);
		chkVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				verPassword();
			}
		});
		chkVer.setBounds(282, 229, 97, 23);
		panelAgregarClientes.add(chkVer);
		contentPane.setLayout(gl_contentPane);
		cargarListas();
		
		visualizarBotones();
	}
	
	
	
	
	private void visualizarBotones() {
		if(CurrentUser.getCurrentUser().getUsuario().getCategoria().getId()==1){
			this.chkHabilitado.setVisible(true);
			this.btnBuscar.setVisible(true);
			this.btnAgregarCliente.setVisible(true);
			this.btnBorrar.setVisible(true);
			this.btnListado.setVisible(true);
			this.txtContrasenia.setVisible(false);
			this.lblContrasenia.setVisible(false);
			this.chkVer.setVisible(false);
			this.cboCategoria.setVisible(true);
			this.lblCategoria.setVisible(true);
			
		}
		if(CurrentUser.getCurrentUser().getUsuario().getCategoria().getId()!=1){
			this.txtContrasenia.setVisible(true);
			this.lblContrasenia.setVisible(true);
			this.chkVer.setVisible(true);
		}
	}

	protected void verPassword(){
		if(this.chkVer.isSelected()){this.txtContrasenia.setEchoChar((char)0);}
		if(this.chkVer.isSelected()==false){this.txtContrasenia.setEchoChar('•');}
	}


	protected void agregarClick() {
		Persona p = this.mapearDeForm();
		try{
			ctrl.add(p);
			JOptionPane.showMessageDialog(contentPane, "Nuevo cliente agregado con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtId.setText(String.valueOf(p.getId()));
		
	}
	
	protected void borrarClick(){
		try{
			ctrl.delete(this.mapearDeForm());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Ha sucedido un error, intente nuevamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	protected void modificarClick(){
		try{
			ctrl.update(this.mapearDeForm());
			JOptionPane.showMessageDialog(contentPane, "Modificación exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No se ha podido realizar la modificación.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void mapearAForm(Persona p){
		this.txtDni.setText(p.getDni());
		this.txtNombre.setText(p.getNombre());
		this.txtApellido.setText(p.getApellido());
		this.chkHabilitado.setSelected(p.isHabilitado());
		if (p.getCategoria() !=null){
			this.cboCategoria.setSelectedItem(p.getCategoria());
		}
		this.txtId.setText(String.valueOf(p.getId()));
	}
	
	
	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));
			lblId.setVisible(true);
			txtId.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No existen registros para ese DNI.", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private Persona mapearDeForm(){
		Persona p=new Persona();
		if(!this.txtId.getText().isEmpty()){
			p.setId(Integer.parseInt(this.txtId.getText()));
		}
		p.setDni(this.txtDni.getText());
		p.setNombre(this.txtNombre.getText());
		p.setApellido(this.txtApellido.getText());
		p.setHabilitado(this.chkHabilitado.isSelected());
		if (cboCategoria.getSelectedIndex() != -1){
			p.setCategoria((Categoria)cboCategoria.getSelectedItem());
		}
		p.setContrasenia(String.valueOf(txtContrasenia.getPassword()));
		return p;
	}
	
	public void showPersona(Persona p){
		this.mapearAForm(p);
	}
	
	private void cargarListas() {
		try {
			this.cboCategoria.setModel(new DefaultComboBoxModel(this.ctrl.getCategorias().toArray()));
			this.cboCategoria.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Categorias");
		}
	}
	protected void mnuListadoPersonaClick() {
		this.dispose();
		ListadoPersonas lp= new ListadoPersonas();
		lp.setVisible(true);
		
	}
}
