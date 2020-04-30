import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControladorBajas {
	private BaseDeDatos bbdd;
	private Bajas bajas;
	private int id_alumno;
	
	public ControladorBajas(Bajas bajas) {
		super();
		this.bajas = bajas;
		bbdd = new BaseDeDatos();
		bajas.getBtnBuscar2().addActionListener(actionBuscar());
		bajas.getTxtIntroduzcaElDni2().addActionListener(actionBuscar());
		bajas.getTxtIntroduzcaElDni2().getDocument().addDocumentListener(writeEvent());
		bajas.getBtnDelete().addActionListener(actionDelete());
	}
	
	private DocumentListener writeEvent() {
		return new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				bajas.getBtnBuscar2().setEnabled(true);
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				bajas.getBtnBuscar2().setEnabled(true);
				
			}
		};
	}

	public ActionListener actionBuscar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dni = bajas.getTxtIntroduzcaElDni2().getText();
				ResultSet rs = bbdd.getAlumnoByDNI(dni);
				try {
					if (rs.next()) {
						bajas.getTextFieldNombre().setText(rs.getString(1));
						bajas.getTextFieldApellido1().setText(rs.getString(2));
						bajas.getTextFieldApellido2().setText(rs.getString(3));
						bajas.getTextFieldDni().setText(rs.getString(4));
						bajas.getTextFieldTelefono().setText(rs.getString(5));
						bajas.getTextFieldEmail().setText(rs.getString(6));
						id_alumno = rs.getInt(7);
						bajas.getBtnDelete().setEnabled(true);
					}
					else {
						JOptionPane.showMessageDialog(bajas, "No se encontraron resultados");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
	}
	
	public ActionListener actionDelete() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//String nombre = bajas.getTextFieldNombre().getText();
				//String apellido = bajas.getTextFieldApellido1().getText();
				//String apellido2 = bajas.getTextFieldApellido2().getText();
				//String dni = bajas.getTextFieldDni().getText();
				//String telefono = bajas.getTextFieldTelefono().getText();
				//String email = bajas.getTextFieldEmail().getText();
				int opcion=JOptionPane.showOptionDialog(null, "¿Estás segura de que quieres deshabilitar este alumno?", "Confirmar Baja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(opcion==JOptionPane.YES_OPTION) {
					boolean resultado = bbdd.updateHabilitadoAlumnado(id_alumno);
					if (resultado) {
						JOptionPane.showMessageDialog(bajas, "Alumno dado de baja");
						bajas.getTextFieldDni().setForeground(Color.WHITE);
					}
				}
			}
		};
	}
}
