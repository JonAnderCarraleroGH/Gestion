import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ControladorSegundo {
	private Segundo segundo;
	private BaseDeDatos bbdd;
	private int id_alumno;
	private String curso;

	public ControladorSegundo(Segundo segundo) {
		super();
		this.segundo = segundo;
		bbdd = new BaseDeDatos();
		segundo.getBtnSelecCurso().addActionListener(actionBuscar());
	}

	public ActionListener actionBuscar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				curso=(String) segundo.getComboBox().getSelectedItem();
				String asignatura;
				int cursoaux;
				asignatura=curso.substring(0, curso.length()-1);
				cursoaux=Integer.parseInt(curso.substring(curso.length()-1,curso.length()));
				pasarCurso(curso, cursoaux, asignatura);
				JOptionPane.showMessageDialog(segundo, "Los alumnos dignos han sido pasados a segundo curso", "Paso a segundo", JOptionPane.INFORMATION_MESSAGE);
			}
		};
	}

	private void pasarCurso(String curso, int cursoaux, String asignatura) {
		String curso2="";
		int id_asignatura=0;
		int id_curso=bbdd.getIdCurso(curso);
		ResultSet rsAlumnos = bbdd.getAlumnosCurso(id_curso);
		ResultSet rsAsignaturas = bbdd.getIdAsignaturasFromCursoByName(curso);
		int numeroLineasAlumnos = getResultSetRowCount(rsAlumnos);
		int numeroLineasAsignaturas = getResultSetRowCount(rsAsignaturas);
		try {
			while (rsAlumnos.next()) { //bucle para recorrer todos los alumnos de un curso
				id_alumno = rsAlumnos.getInt(1);
				int resultado=JOptionPane.showOptionDialog(null, "¿Estás segura de que quieres pasar de curso a estos alumnos?", "Confirmar Pasar a Segundo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if(resultado==JOptionPane.YES_OPTION) {
					boolean deshabilitado=bbdd.deshabilitarExpedienteAnterior(id_alumno);
					boolean pasaCurso=true;
					if(cursoaux==1) {
						int cursoInt=cursoaux+1;
						curso2=asignatura.concat(Integer.toString(cursoInt));
						while(rsAsignaturas.next()) {
							id_asignatura=rsAsignaturas.getInt(1);
							int nota=bbdd.selectNotaByIDAlumnoAndIDAsignatura(id_alumno, id_asignatura);
							if(nota<5) {
								pasaCurso=false;
							}
						}
						rsAsignaturas.beforeFirst();
						if(pasaCurso) {
							ResultSet rsAsignaturasSegundo=bbdd.getIdAsignaturasFromCursoByName(curso2);
							while(rsAsignaturasSegundo.next()) {
								int id_asignaturaSegundo=rsAsignaturasSegundo.getInt(1);
								bbdd.insertIntoExpediente(id_alumno, null, 1, id_asignaturaSegundo);
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getResultSetRowCount(ResultSet rs) {
		int contador=0;
		try {
			while (rs.next()){
				contador++;
			}
			rs.beforeFirst();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return contador;
	}
} 
