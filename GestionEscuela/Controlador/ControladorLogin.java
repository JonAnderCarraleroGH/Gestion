import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControladorLogin {
	private InicioSesion inicioSesion;
	private BaseDeDatos bbdd;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaProfesores ventanaProfesores;
	
	
	public ControladorLogin(InicioSesion inicioSesion, BaseDeDatos bbdd) {
		super();
		this.inicioSesion = inicioSesion;
		this.bbdd = bbdd;
		inicioSesion.getBtnIniciarSesion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		inicioSesion.getTextField_Contraseña().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
				
			}
		});
		
		inicioSesion.getTextField_Usuario().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
				
			}
		});
	}
	
	private void login() {
		String usuario = inicioSesion.getTextField_Usuario().getText()+ "";
		String password = new String(inicioSesion.getTextField_Contraseña().getPassword()) + "";
		int login = bbdd.checkLogIn(usuario, password);
		ResultSet rs = bbdd.getInfoByCredenciales(usuario, password);
		
		switch (login) {
		case 1:	//JOptionPane.showMessageDialog(inicioSesion, "Login OK", "Login estatus", JOptionPane.INFORMATION_MESSAGE);
			try {
				rs.next();
				ventanaProfesores = new VentanaProfesores(rs.getString(2), Integer.parseInt(rs.getString(1)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
				ventanaProfesores.setVisible(true);
				inicioSesion.dispose();
		
			break;
		case 2:	JOptionPane.showMessageDialog(inicioSesion, "Login OK", "Login estatus", JOptionPane.INFORMATION_MESSAGE);
			try {
				rs.next();
				ventanaPrincipal = new VentanaPrincipal(rs.getString(2), Integer.parseInt(rs.getString(1)));
			} catch (SQLException e) {
				e.printStackTrace();
			}				
				ventanaPrincipal.setVisible(true);
				inicioSesion.dispose();

			break;
		case 3: int resultado=JOptionPane.showOptionDialog(null, "¿Quieres entrar como administrativo o como profesor?(SÍ para administrativo, NO para profesor, CANCEL para volver", "Rango", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if(resultado==JOptionPane.YES_OPTION) {
				try {
					rs.next();
					ventanaPrincipal = new VentanaPrincipal(rs.getString(2), Integer.parseInt(rs.getString(1)));
				} catch (SQLException e) {
					e.printStackTrace();
				}				
					ventanaPrincipal.setVisible(true);
					inicioSesion.dispose();
			} 
			if(resultado==JOptionPane.NO_OPTION) {
				try {
					rs.next();
					ventanaProfesores = new VentanaProfesores(rs.getString(2), Integer.parseInt(rs.getString(1)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
					ventanaProfesores.setVisible(true);
					inicioSesion.dispose();
			}
			break;
			

		default:JOptionPane.showMessageDialog(inicioSesion, "Login not OK", "Login estatus", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
	
	
}
