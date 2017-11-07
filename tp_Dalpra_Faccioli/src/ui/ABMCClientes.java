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
		txtId.setColumns(10);
		
		lblId = new JLabel("ID");
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
		btnVaciarCampos.setFocusCycleRoot(true);
		btnVaciarCampos.setFocusPainted(false);
		btnVaciarCampos.setVisible(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
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
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtDni = new JTextField();
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
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido*");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		lblCategoria = new JLabel("Categor\u00EDa*");
		lblCategoria.setVisible(false);
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cboCategoria = new JComboBox();
		cboCategoria.setVisible(false);
		
		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setVisible(false);
		chkHabilitado.setSelected(true);
		
		btnAgregarCliente = new JButton("Agregar Cliente");
		btnAgregarCliente.setVisible(false);
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
		btnModificarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modificarClick();
			}
		});
		
		btnBorrar = new JButton("Borrar Cliente");
		btnBorrar.setVisible(false);
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
		
		btnListado = new JButton("Listado");
		btnListado.setVisible(false);
		
		btnListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mnuListadoPersonaClick();
			}
		});
		
		lblContrasenia = new JLabel("Contrase\u00F1a*");
		lblContrasenia.setVisible(false);
		lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//TODO agregar funcionalidad para cambio de contraseña
		txtContrasenia = new JPasswordField();
		txtContrasenia.setVisible(false);
		
		
		chkVer = new JCheckBox("Ver");
		chkVer.setVisible(false);
		chkVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				verPassword();
			}
		});
		GroupLayout gl_panelAgregarClientes = new GroupLayout(panelAgregarClientes);
		gl_panelAgregarClientes.setHorizontalGroup(
			gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(544)
					.addComponent(btnVaciarCampos, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(126)
					.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(112)
					.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(84)
					.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(84)
					.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(73)
					.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cboCategoria, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(52)
					.addComponent(lblContrasenia, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtContrasenia, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(chkVer, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(170)
					.addComponent(chkHabilitado, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addGap(4)
					.addComponent(btnAgregarCliente, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(btnModificarDatos, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(btnListado, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelAgregarClientes.setVerticalGroup(
			gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAgregarClientes.createSequentialGroup()
					.addComponent(btnVaciarCampos, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAgregarClientes.createSequentialGroup()
							.addGap(3)
							.addComponent(lblId))
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAgregarClientes.createSequentialGroup()
							.addGap(4)
							.addComponent(lblDni))
						.addGroup(gl_panelAgregarClientes.createSequentialGroup()
							.addGap(1)
							.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscar))
					.addGap(11)
					.addGroup(gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAgregarClientes.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNombre))
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAgregarClientes.createSequentialGroup()
							.addGap(3)
							.addComponent(lblApellido))
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAgregarClientes.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCategoria))
						.addComponent(cboCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAgregarClientes.createSequentialGroup()
							.addGap(4)
							.addComponent(lblContrasenia))
						.addGroup(gl_panelAgregarClientes.createSequentialGroup()
							.addGap(1)
							.addComponent(txtContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(chkVer))
					.addGap(15)
					.addComponent(chkHabilitado)
					.addGap(48)
					.addGroup(gl_panelAgregarClientes.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregarCliente, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModificarDatos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnListado, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
		);
		panelAgregarClientes.setLayout(gl_panelAgregarClientes);
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
		if(validaCampos()){
		Persona p = this.mapearDeForm();
		try{
			ctrl.add(p);
			JOptionPane.showMessageDialog(contentPane, "Nuevo cliente agregado con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtId.setText(String.valueOf(p.getId()));
		}
		else {
			JOptionPane.showMessageDialog(contentPane, "Complete los campos requeridos para poder continuar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	
	protected void borrarClick(){
		try{
			if(!this.txtNombre.getText().equals("")){
				int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Està seguro de que desea eliminar el cliente?", "Aviso", JOptionPane.YES_NO_OPTION);
				
				if (opcion == 0) { 
					ctrl.delete(this.mapearDeForm());
					JOptionPane.showMessageDialog(contentPane, "El cliente ha sido dado de baja.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				}else{}
			} else {
				JOptionPane.showMessageDialog(contentPane, "Complete el campo 'Nombre'.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

			}			
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Ha sucedido un error, intente nuevamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	protected void modificarClick(){
		if(validaCampos()){
		try{
			ctrl.update(this.mapearDeForm());
			JOptionPane.showMessageDialog(contentPane, "Modificación exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No se ha podido realizar la modificación.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}}
		else{
			JOptionPane.showMessageDialog(contentPane, "Complete los campos requeridos para poder continuar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

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
		this.txtContrasenia.setText(p.getContrasenia());
	}
	
	
	protected void buscarClick() {
		if(validaCampoDni()){			
			try {
				this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));
				lblId.setVisible(true);
				txtId.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(contentPane, "No existen registros para ese DNI.", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(contentPane, "Rellene el campo DNI.", "Error", JOptionPane.INFORMATION_MESSAGE);
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
	private boolean validaCampoDni(){
		if(!this.txtDni.getText().equals("")) {return true;}
		else {return false;}
	}
	private boolean validaCampos(){
		if((!this.txtDni.getText().equals(""))&&
			(!this.txtNombre.getText().equals(""))&&
			(!this.txtApellido.getText().equals(""))&&
			(!this.txtContrasenia.getPassword().equals(""))&&
			(this.cboCategoria.getSelectedItem()!=null)) {return true;}
		else {return false;}
	}
}
