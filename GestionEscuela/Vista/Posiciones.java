import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Posiciones extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String [] NOMBRES_COLUMNAS = {"Fila1","Fila2","Fila3","Fila4","Fila5","Fila6"};
	private String [][] nombresAlumnos;
	private BaseDeDatos bbdd;
	private JTable tablaPosiciones;
	/**
	 * Create the panel.
	 * @param nombreAsignatura 
	 */
	public Posiciones(int id_asignatura, String nombreAsignatura) {
		bbdd= new BaseDeDatos();
		ResultSet rs = bbdd.getAlumnosPosicionByAsignaturaId(id_asignatura);
		int numeroAlumnos = getResultSetRowCount(rs);
		nombresAlumnos = new String [(numeroAlumnos/6)+1][6];
		llenarArrayNombres(rs);
		setLayout(new BorderLayout(0, 0));
		tablaPosiciones = new JTable(nombresAlumnos, NOMBRES_COLUMNAS);
		setBackground(new Color(32,33,35));
		this.add(tablaPosiciones.getTableHeader(), BorderLayout.PAGE_START);
		tablaPosiciones.setFillsViewportHeight(true);
		this.add(tablaPosiciones, BorderLayout.CENTER);
		tablaPosiciones.setVisible(true);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), nombreAsignatura, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(204, 153, 255)));
		JLabel lblNewLabel = new JLabel("La posici\u00F3n 1 ser\u00E1 la m\u00E1s cercana a la puerta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.SOUTH);
		
	}
	private void llenarArrayNombres(ResultSet rs) {
		int ultimaPosicion = 0;
		for (int filas = 0; filas < nombresAlumnos.length; filas++) {
			for (int columnas = 0; columnas < nombresAlumnos[0].length; columnas++) {
				try {
					boolean siguiente = rs.next();
					boolean esConsecutivo = true;
					if (!rs.isBeforeFirst() && siguiente) {
						int posicionActual = Integer.parseInt(rs.getString(3));
						if (posicionActual-ultimaPosicion != 1) {
							nombresAlumnos[filas][columnas] = ultimaPosicion+1+" | Asiento no asignado";
							rs.previous();
							esConsecutivo = false;
						}
					}
					if (siguiente && esConsecutivo) {
						nombresAlumnos[filas][columnas] =ultimaPosicion+1+" | "+ rs.getString(1)+" "+rs.getString(2);
					}
					ultimaPosicion++;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
