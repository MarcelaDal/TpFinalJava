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

import controlers.CtrlABMCClientes;
import entity.Persona;
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
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class ABMCReservas extends JFrame {

	private CtrlABMCClientes ctrl=new CtrlABMCClientes();
	
	
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JCheckBox chkHabilitado;
	private JComboBox cboCategoria;
	private JPanel panelAgregarClientes;
	private JTextField txtId;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCClientes frame = new ABMCClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ABMCReservas() {
		//setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 738, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelAgregarClientes = new JPanel();
		panelAgregarClientes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reservas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txtId = new JTextField();
		txtId.setBounds(252, 16, 100, 20);
		txtId.setVisible(false);
		txtId.setEditable(false);
		txtId.setEnabled(false);
		txtId.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setBounds(208, 19, 26, 14);
		lblId.setVisible(false);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnVaciarCampos = new JButton("Vaciar campos");
		btnVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtId.setText("");
				txtDni.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				cboCategoria.setSelectedItem(null);
				chkHabilitado.setSelected(false);
				
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
					.addComponent(panelAgregarClientes, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(panelAgregarClientes, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(208, 49, 26, 14);
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtDni = new JTextField();
		txtDni.setBounds(252, 46, 100, 20);
		txtDni.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
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
		btnBuscar.setBounds(370, 45, 100, 23);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(166, 86, 68, 14);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(252, 79, 100, 20);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(166, 121, 68, 14);
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(252, 111, 100, 20);
		txtApellido.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(166, 156, 68, 14);
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(252, 153, 100, 20);
		
		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setBounds(252, 191, 100, 23);
		chkHabilitado.setSelected(false);
		
		JButton btnAgregarCliente = new JButton("Agregar Cliente");
		btnAgregarCliente.setBounds(29, 244, 136, 34);
		
		JButton btnModificarDatos = new JButton("Modificar Datos");
		btnModificarDatos.setBounds(216, 244, 136, 34);
		
		JButton btnBorrar = new JButton("Borrar Cliente");
		btnBorrar.setBounds(403, 244, 136, 34);
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
		contentPane.setLayout(gl_contentPane);
		cargarListas();
	}
	
	private void mapearAForm(Persona p){
		this.txtDni.setText(p.getDni());
		this.txtNombre.setText(p.getNombre());
		this.txtApellido.setText(p.getApellido());
		this.chkHabilitado.setSelected(p.isHabilitado());
		this.cboCategoria.setSelectedItem(p.getCategoria());
		this.txtId.setText(String.valueOf(p.getId()));
	}
	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));
			lblId.setVisible(true);
			txtId.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
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
}
