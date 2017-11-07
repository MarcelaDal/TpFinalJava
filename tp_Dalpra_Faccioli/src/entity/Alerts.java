package entity;

import javax.swing.JOptionPane;

public class Alerts {

	public void showErrorAlert(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showWarningAlert(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.WARNING_MESSAGE);
	}
	public void showSucessAlert(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
