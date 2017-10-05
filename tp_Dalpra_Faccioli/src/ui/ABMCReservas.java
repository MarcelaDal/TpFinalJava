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
import javax.swing.border.TitledBorder;

import controlers.CtrlABMCReservas;
import entity.Reserva;
import entity.TipoElementos;
import entity.CurrentUser;
import entity.Elemento;
import entity.Persona;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
//import com.github.lgooddatepicker.components.TimePicker;
import java.awt.ComponentOrientation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCReservas extends JFrame {

	private CtrlABMCReservas ctrl=new CtrlABMCReservas();
	
	private JPanel contentPane;
	private JPanel panelAgregarClientes;
	private JTable table;
	private JComboBox cboTipoElemento, cboElemento;
	private JTextArea textAreaDetalle;
	private JDateChooser dateChooserReserva;
	//private TimePicker timePicker;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCClientes frame = new ABMCClientes();
					frame.setVisible(truej
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
		btnConfirmarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				reservarClick();
			}
		});
		btnConfirmarReserva.setBounds(72, 341, 192, 34);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mnuListadoReservasClick();
			}
		});
		btnListado.setBounds(381, 341, 136, 34);
		panelAgregarClientes.setLayout(null);
		panelAgregarClientes.add(btnConfirmarReserva);
		panelAgregarClientes.add(btnListado);
		panelAgregarClientes.add(btnVaciarCampos);
		
		JLabel lblFecha = new JLabel("Fecha*");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(104, 160, 68, 14);
		panelAgregarClientes.add(lblFecha);
		
		dateChooserReserva = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dateChooserReserva.setDateFormatString("dd/MM/yyyy");
		dateChooserReserva.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateChooserReserva.setBounds(182, 154, 142, 20);
		panelAgregarClientes.add(dateChooserReserva);
		dateChooserReserva.setMinSelectableDate(new Date());
		
		JLabel lblHora = new JLabel("Hora*");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(104, 197, 68, 14);
		panelAgregarClientes.add(lblHora);
		
		table = new JTable();
		table.setBounds(258, 268, 62, -9);
		panelAgregarClientes.add(table);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento*");
		lblTipoElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoElemento.setBounds(72, 68, 100, 14);
		panelAgregarClientes.add(lblTipoElemento);
		
		cboTipoElemento = new JComboBox();
		cboTipoElemento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				seleccionarTipoElementoClick();
			}
		});
		cboTipoElemento.setBounds(182, 65, 142, 20);
		panelAgregarClientes.add(cboTipoElemento);
		
		JLabel lblElemento = new JLabel("Elemento*");
		lblElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblElemento.setBounds(72, 112, 100, 14);
		panelAgregarClientes.add(lblElemento);
		
		cboElemento = new JComboBox();
		cboElemento.setBounds(182, 109, 142, 20);
		panelAgregarClientes.add(cboElemento);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetalle.setBounds(104, 240, 68, 14);
		panelAgregarClientes.add(lblDetalle);
		
		textAreaDetalle = new JTextArea();
		textAreaDetalle.setName("descipcion");
		textAreaDetalle.setTabSize(2);
		textAreaDetalle.setFont(new Font("Calibri", Font.PLAIN, 13));
		textAreaDetalle.setWrapStyleWord(true);
		textAreaDetalle.setLineWrap(true);
		textAreaDetalle.setBounds(182, 235, 211, 47);
		panelAgregarClientes.add(textAreaDetalle);
		
		//timePicker = new TimePicker();
		//timePicker.setBounds(182, 193, 142, 23);
		//panelAgregarClientes.add(timePicker);
		
		JLabel lblCamposRequeridos = new JLabel("(*) Campos Requeridos");
		lblCamposRequeridos.setBounds(182, 300, 149, 14);
		panelAgregarClientes.add(lblCamposRequeridos);
		
		contentPane.setLayout(gl_contentPane);
		cargarListaTipoElementos();
	}
	
	private void mapearAForm(Reserva r){
		
	}
	
	private Reserva mapearDeForm(){
		Reserva r=new Reserva();
		
		r.setEstado(true);
		if (cboElemento.getSelectedIndex() != -1){
			r.setElemento((Elemento)cboElemento.getSelectedItem());
		}
		r.setDetalle(textAreaDetalle.getText());
		
		java.sql.Date date = new java.sql.Date(dateChooserReserva.getDate().getTime());
		r.setFecha(date);
		
	
		

		
		//TODO: set fecha y hora
		//r.setFecha(date);
		//r.setHora(timePicker.getTime());
	
		Persona per = CurrentUser.getCurrentUser().getUsuario();
		r.setPersona(per);
		
		
		return r;
	}
	
	/*public void showPersona(Persona p){
		this.mapearAForm(p);
	}*/
	
	private void reservarClick(){
		if(validaCampos()){
			Reserva r= this.mapearDeForm();
			
		try{
			ctrl.add(r);
			JOptionPane.showMessageDialog(contentPane, "Nueva reserva agregada exitosamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No se pudo agregar reserva", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
		}
		else{
			JOptionPane.showMessageDialog(contentPane, "Complete los campos requeridos para poder continuar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	private void seleccionarTipoElementoClick(){
		cargarListaElementos(this.mapearDeFormTipoElemento());
	}
	
	private TipoElementos mapearDeFormTipoElemento(){
		TipoElementos te= new TipoElementos();
		if (cboTipoElemento.getSelectedIndex() != -1){
			te= ((TipoElementos)cboTipoElemento.getSelectedItem());
		}
		return te;
	}
	
	
	
	private void cargarListaTipoElementos() {
		try {
			this.cboTipoElemento.setModel(new DefaultComboBoxModel(this.ctrl.getTipoElementos().toArray()));
			this.cboTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Tipo de Elementos");
		}
	}
	
	private void cargarListaElementos(TipoElementos te) {
		try {
			this.cboElemento.setModel(new DefaultComboBoxModel(this.ctrl.getByTipoElemento(te).toArray()));
			this.cboElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Elementos");
		}
	}
	
	protected void mnuListadoReservasClick() {
		this.dispose();
		ListadoReservas lr= new ListadoReservas();
		lr.setVisible(true);
		
	}
	
	private boolean validaCampos(){
		if((this.cboElemento.getSelectedItem()!=null)&&
				(this.cboTipoElemento.getSelectedItem()!=null)&&
				(this.dateChooserReserva.getDate()!=null))
				//&& (this.timePicker.getTime()!=null))
				{
		return true;
		}else{
			return false;
		}
	}
}
