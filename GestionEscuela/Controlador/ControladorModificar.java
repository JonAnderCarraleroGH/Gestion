import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControladorModificar {
	private Modificar modificar;
	private BaseDeDatos bbdd;
	private int id_alumno;
	
	public ControladorModificar(Modificar modificar) {
		super();
		this.modificar = modificar;
		bbdd = new BaseDeDatos();
		modificar.getBtnBuscar().addActionListener(actionBuscar());
		modificar.getTxtIntroduzcaElDni().addActionListener(actionBuscar());
		modificar.getTxtIntroduzcaElDni().getDocument().addDocumentListener(writeEvent());
		modificar.getBtnAñadir().addActionListener(actionUpdate());
	}
	
	
	private DocumentListener writeEvent() {
		return new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				modificar.getBtnBuscar().setEnabled(true);
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};
	}


	public ActionListener actionBuscar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dni = modificar.getTxtIntroduzcaElDni().getText();
				ResultSet rs = bbdd.getAlumnoByDNI(dni);
				try {
					if (rs.next()) {
						modificar.getTextFieldNombre().setText(rs.getString(1));
						modificar.getTextFieldApellido1().setText(rs.getString(2));
						modificar.getTextFieldApellido2().setText(rs.getString(3));
						modificar.getTextFieldDni().setText(rs.getString(4));
						modificar.getTextFieldTelefono().setText(rs.getString(5));
						modificar.getTextFieldEmail().setText(rs.getString(6));
						id_alumno = rs.getInt(7);
						modificar.getBtnAñadir().setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(modificar, "No se encontraron resultados");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
	}
	
	public ActionListener actionUpdate() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = modificar.getTextFieldNombre().getText();
				String apellido = modificar.getTextFieldApellido1().getText();
				String apellido2 = modificar.getTextFieldApellido2().getText();
				String dni = modificar.getTextFieldDni().getText();
				String telefono = modificar.getTextFieldTelefono().getText();
				String email = modificar.getTextFieldEmail().getText();
				int opcion=JOptionPane.showOptionDialog(null, "¿Estás segura de que los datos son correctos?", "Confirmar Modificación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(opcion==JOptionPane.YES_OPTION) {
					boolean resultado = bbdd.updateInfoAlumnado(nombre, apellido, apellido2, email, telefono, dni, id_alumno);
					if (resultado) {
						JOptionPane.showMessageDialog(modificar, "Update OK");
						modificar.getTextFieldDni().setForeground(Color.WHITE);
					}
					else {
						JOptionPane.showMessageDialog(modificar, "Restriccion única violada, ese DNI ya esta en el sistema");
						modificar.getTextFieldDni().setForeground(Color.red);
					}
				}
			}
		};
	}
	
}
