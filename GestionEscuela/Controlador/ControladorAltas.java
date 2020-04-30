import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControladorAltas {
	private BaseDeDatos bbdd;
	private Altas altas;
	
	public ControladorAltas(Altas altas) {
		super();
		this.altas = altas;
		bbdd = new BaseDeDatos();
		altas.getBtnAñadir().addActionListener(insertAction());
	}
	
	public ActionListener insertAction() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = altas.getTextFieldNombre().getText();
				String apellido1 = altas.getTextFieldApellido1().getText();
				String apellido2 = altas.getTextFieldApellido2().getText();
				String dni = altas.getTextFieldDni().getText();
				String telefono = altas.getTextFieldTelefono().getText();
				String email = altas.getTextFieldEmail().getText();
				int id = bbdd.maxIDFromAlumnado();
				String nombreCurso = (String) altas.getComboBox().getSelectedItem();
				int resultado=JOptionPane.showOptionDialog(null, "¿Estás segura de que los datos son correctos?", "Confirmar Alta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(resultado==JOptionPane.YES_OPTION) {
					bbdd.insertAlumno(nombre, apellido1, apellido2, email, telefono, dni, id);
					if (nombreCurso != null) {
						ResultSet rs = bbdd.getIdAsignaturasFromCursoByName(nombreCurso);
						try {
							while(rs.next()) {
								int id_asignatura = rs.getInt(1);
								bbdd.insertIntoExpediente(id,  null, 1, id_asignatura);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				} 				
			}
		};
	}
}
