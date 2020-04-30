import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class ControladorPanelNotas {
	@SuppressWarnings("unused")
	private PanelNotas notas;
	private BaseDeDatos bbdd;
	
	public ControladorPanelNotas(ResultSet rs, int trimestre, int id_asignatura, PanelNotas notas) {
		bbdd = new BaseDeDatos();
		this.notas = notas;
		notas.getButtonUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numeroLineas = notas.getTablaNotas().getModel().getRowCount();
				TableModel modelo = notas.getTablaNotas().getModel();
				try {
					rs.beforeFirst();
					for (int i = 0; i < numeroLineas; i++){
						if (rs.next()) {
								int nota =  Integer.parseInt((String) modelo.getValueAt(i, 2));
								if (notas.isEsTrimestreNuevo()) {
									int resultado=JOptionPane.showOptionDialog(null, "¿Estás segura de que quieres registrar estas notas?", "Confirmar Insertar Expediente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
									if(resultado==JOptionPane.YES_OPTION) {
										int id_alumno = Integer.parseInt(rs.getString(3));
										bbdd.insertIntoExpediente(id_alumno,nota, trimestre, id_asignatura);
									}
								}
								else {
									int resultado=JOptionPane.showOptionDialog(null, "¿Estás segura de que quieres modificar estas notas?", "Confirmar Update Expediente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
									if(resultado==JOptionPane.YES_OPTION) {
										int id_alumno = Integer.parseInt(rs.getString(4));
										bbdd.updateNota(id_alumno,nota, trimestre, id_asignatura);
									}
								}
							}						
						}
					JOptionPane.showMessageDialog(notas, "Operación Correcta");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Introduzca valores en todos los registros");
				}				
			}
		});
	}
}
