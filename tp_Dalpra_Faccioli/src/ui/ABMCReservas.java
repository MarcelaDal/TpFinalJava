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

import controlers.CtrlABMCReservas;
import entity.Persona;
import entity.Reserva;
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
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.DropMode;
import java.awt.Dimension;

public class ABMCReservas extends JFrame {

	private CtrlABMCReservas ctrl=new CtrlABMCReservas();
	
	private JPanel contentPane;
	private JPanel panelAgregarClientes;
	private JTable table;
	private JComboBox cboTipoElemento, cboElemento;
	private JTextArea textAreaDesc;
	private JTextField textField;

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
		panelAgregarClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAgregarClientes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reservas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnVaciarCampos = new JButton("Vaciar campos");
		btnVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				cboTipoElemento.setSelectedItem(null);
				
			}
		});
		btnVaciarCampos.setBounds(550, 16, 129, 21);
		btnVaciarCampos.setFocusCycleRoot(true);
		btnVaciarCampos.setFocusPainted(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelAgregarClientes, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelAgregarClientes, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnConfirmarReserva = new JButton("Confirmar Reserva");
		btnConfirmarReserva.setBounds(72, 322, 192, 34);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mnuListadoReservasClick();
			}
		});
		btnListado.setBounds(381, 322, 136, 34);
		panelAgregarClientes.setLayout(null);
		panelAgregarClientes.add(btnConfirmarReserva);
		panelAgregarClientes.add(btnListado);
		panelAgregarClientes.add(btnVaciarCampos);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(104, 160, 68, 14);
		panelAgregarClientes.add(lblFecha);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(182, 154, 142, 20);
		panelAgregarClientes.add(dateChooser);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(104, 197, 68, 14);
		panelAgregarClientes.add(lblHora);
		
		table = new JTable();
		table.setBounds(258, 268, 62, -9);
		panelAgregarClientes.add(table);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		lblTipoElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoElemento.setBounds(72, 68, 100, 14);
		panelAgregarClientes.add(lblTipoElemento);
		
		cboTipoElemento = new JComboBox();
		cboTipoElemento.setBounds(182, 65, 142, 20);
		panelAgregarClientes.add(cboTipoElemento);
		
		JLabel lblElemento = new JLabel("Elemento");
		lblElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblElemento.setBounds(72, 112, 100, 14);
		panelAgregarClientes.add(lblElemento);
		
		cboElemento = new JComboBox();
		cboElemento.setBounds(182, 109, 142, 20);
		panelAgregarClientes.add(cboElemento);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetalle.setBounds(104, 231, 68, 14);
		panelAgregarClientes.add(lblDetalle);
		
		textAreaDesc = new JTextArea();
		textAreaDesc.setName("descipcion");
		textAreaDesc.setTabSize(2);
		textAreaDesc.setFont(new Font("Calibri", Font.PLAIN, 13));
		textAreaDesc.setWrapStyleWord(true);
		textAreaDesc.setLineWrap(true);
		textAreaDesc.setBounds(182, 226, 211, 47);
		panelAgregarClientes.add(textAreaDesc);
		
		//TODO: agregar algun time picker
		textField = new JTextField();
		textField.setBounds(182, 194, 86, 20);
		panelAgregarClientes.add(textField);
		textField.setColumns(10);
		
		
		
		contentPane.setLayout(gl_contentPane);
		cargarListas();
	}
	
	private void mapearAForm(Reserva r){
		
	}
	
	private Reserva mapearDeForm(){
		Reserva r=new Reserva();
		
		r.setEstado("activo");
		if (cboElemento.getSelectedIndex() != -1){
			r.setElemento((Elemento)cboElemento.getSelectedItem());
		}
		//TODO: obtener la persona de la variable de sesión
		//r.setPersona(persona);
		
		
		
		return r;
	}
	
	/*public void showPersona(Persona p){
		this.mapearAForm(p);
	}*/
	
	private void cargarListas() {
		try {
			this.cboTipoElemento.setModel(new DefaultComboBoxModel(this.ctrl.getTipoElementos().toArray()));
			this.cboTipoElemento.setSelectedIndex(-1);
			//TODO: cargar los elementos una vez seleccionado el tipo de elemento
			this.cboElemento.setModel(new DefaultComboBoxModel(this.ctrl.getElementos().toArray()));
			this.cboElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Categorias");
		}
	}
	
	protected void mnuListadoReservasClick() {
		this.dispose();
		ListadoReservas lr= new ListadoReservas();
		lr.setVisible(true);
		
	}
}
