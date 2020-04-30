import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class PanelNotas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String [] NOMBRES_COLUMNAS = {"Nombre","Apellido","Nota"};
	private String [][] nombresAlumnos;
	private BaseDeDatos bbdd;
	private JTable tablaNotas;
	private JButton buttonUpdate;
	@SuppressWarnings("unused")
	private ControladorPanelNotas controladorPanelNotas;
	private boolean esTrimestreNuevo;
	@SuppressWarnings("unused")
	private JScrollPane jScrollPane;
	/**
	 * Create the panel.
	 * @param nombreAsignatura 
	 * @param trimestre 
	 */
	public PanelNotas(int id_asignatura, String nombreAsignatura, int trimestre) {
		bbdd = new BaseDeDatos();
		buttonUpdate = new JButton("Modificar Notas");
		buttonUpdate.setContentAreaFilled(false);
		buttonUpdate.setOpaque(true);
		buttonUpdate.setBackground(new Color(126,87,194));
		buttonUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonUpdate.setForeground(Color.BLACK);
		buttonUpdate.setRolloverEnabled(false);
		ResultSet rs = bbdd.getALumnosNotasByAsignatura(id_asignatura, trimestre);
		int numeroAlumnos = getResultSetRowCount(rs);
		if (numeroAlumnos == 0) {
			rs = bbdd.getAlumnosAsignatura(id_asignatura, trimestre);
			esTrimestreNuevo = true;
			numeroAlumnos=getResultSetRowCount(rs);
		}
		nombresAlumnos = new String [numeroAlumnos][NOMBRES_COLUMNAS.length];
		llenarArray(rs);
		setLayout(new BorderLayout(0, 0));
		tablaNotas = new JTable(nombresAlumnos, NOMBRES_COLUMNAS);
		setBackground(new Color(32,33,35));
		this.add(tablaNotas.getTableHeader(), BorderLayout.PAGE_START);
		tablaNotas.setFillsViewportHeight(true);
		tablaNotas.getColumnModel().getColumn(2).setCellRenderer(new StatusColumnCellRenderer());
		jScrollPane = new JScrollPane();
		//jScrollPane.add(tablaNotas);
		this.add(tablaNotas, BorderLayout.CENTER);
		this.add(buttonUpdate, BorderLayout.SOUTH);
		tablaNotas.setVisible(true);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), nombreAsignatura, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(204, 255, 255)));//Cambiar el nombre ejemplo por el de la asignatura
		controladorPanelNotas = new ControladorPanelNotas(rs, trimestre, id_asignatura,this);
	}
	private void llenarArray(ResultSet rs) {
		try {
			rs.beforeFirst();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		for (int filas = 0; filas < nombresAlumnos.length; filas++) {
			try {
				if (rs.next()) {					
					nombresAlumnos[filas][0] = rs.getString(1);
					nombresAlumnos [filas][1] = rs.getString(2);
					if (esTrimestreNuevo) {
						nombresAlumnos [filas][2] = "";
					}
					else {
						nombresAlumnos [filas][2] = rs.getString(3);
					}
				}												
			} catch (SQLException e) {
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
	public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
			//Las celdas de la tabla por defecto se renderizan como JLabel
			JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
			table.getModel();
			if (!esTrimestreNuevo) {
				
				if (Integer.parseInt(nombresAlumnos[row][col]) < 5 && Integer.parseInt(nombresAlumnos[row][col]) >= 0) {
					l.setBackground(Color.red);
					
				}
				else {
					l.setBackground(Color.green);
				}
				if (Integer.parseInt(nombresAlumnos[row][col]) < 0) {
					nombresAlumnos[row][col]="";
					l.setBackground(Color.white);
				}
				
			}
			return l;
		}
	}
	public JTable getTablaNotas() {
		return tablaNotas;
	}
	public void setTablaNotas(JTable tablaNotas) {
		this.tablaNotas = tablaNotas;
	}
	public JButton getButtonUpdate() {
		return buttonUpdate;
	}
	public void setButtonUpdate(JButton buttonUpdate) {
		this.buttonUpdate = buttonUpdate;
	}
	public boolean isEsTrimestreNuevo() {
		return esTrimestreNuevo;
	}
	public void setEsTrimestreNuevo(boolean esTrimestreNuevo) {
		this.esTrimestreNuevo = esTrimestreNuevo;
	}
}
