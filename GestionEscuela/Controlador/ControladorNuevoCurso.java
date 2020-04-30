import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControladorNuevoCurso {
	private NuevoCurso curso;
	private BaseDeDatos bbdd;
	
	
	public ControladorNuevoCurso(NuevoCurso curso) {
		super();
		this.curso = curso;
		curso.getBtnAñadir().addActionListener(insertAction());
		curso.getTextFieldNombre().getDocument().addDocumentListener(changeEvent());
	}


	private DocumentListener changeEvent() {
		// TODO Auto-generated method stub
		return new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				curso.getBtnAñadir().setEnabled(true);
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				curso.getBtnAñadir().setEnabled(true);
			}
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				curso.getBtnAñadir().setEnabled(true);
			}
		};
	}


	private ActionListener insertAction() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreCurso = curso.getTextFieldNombre().getText();
				String regex = "^[A-Z]{1,5}[1-2]{1,1}?$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(nombreCurso);
				boolean coincideRegex = matcher.matches();
				String nombreAs = curso.getTextFieldAs().getText();
				String nombreAs1 = curso.getTextFieldAs1().getText();
				String nombreAs2 = curso.getTextFieldAs2().getText();
				String nombreAs3 = curso.getTextFieldAs3().getText();
				String nombreAs4 = curso.getTextFieldAs4().getText();
				String nombreConv = (String) curso.getComboBox().getSelectedItem();
				String nombreConv1 = (String) curso.getComboBox1().getSelectedItem();
				String nombreConv2 = (String) curso.getComboBox2().getSelectedItem();
				String nombreConv3 = (String) curso.getComboBox3().getSelectedItem();
				String nombreConv4 = (String) curso.getComboBox4().getSelectedItem();
				if (coincideRegex) {
					bbdd = new BaseDeDatos();
					int id_curso;
					if (!nombreCurso.equals("")) {
						int resultado=JOptionPane.showOptionDialog(null, "¿Estás segura de que los datos son correctos?", "Confirmar Alta Curso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
						if(resultado==JOptionPane.YES_OPTION) {
							id_curso = bbdd.insertCurso(nombreCurso);
							if (!nombreAs.equals("")) {
								bbdd.insertAsignatura(nombreAs,id_curso,nombreConv);
							}
							if (!nombreAs1.equals("")) {
								bbdd.insertAsignatura(nombreAs1,id_curso,nombreConv1);
							}
							if (!nombreAs2.equals("")) {
								bbdd.insertAsignatura(nombreAs2,id_curso,nombreConv2);
							}
							if (!nombreAs3.equals("")) {
								bbdd.insertAsignatura(nombreAs3,id_curso,nombreConv3);
							}
							if (!nombreAs4.equals("")) {
								bbdd.insertAsignatura(nombreAs4,id_curso,nombreConv4);
							}	
							JOptionPane.showMessageDialog(curso, "Curso creado satisfactoriamente");
						}
					}						
				}
				else {
					JOptionPane.showMessageDialog(curso, "El nombre deben ser letras en mayúsculas(1-5) seguidas del numero de curso");
				}
				// TODO solucionar es_igua 0
					
			}
		};
	}
	
	
}
