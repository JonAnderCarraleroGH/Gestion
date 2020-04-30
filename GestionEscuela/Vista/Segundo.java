import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Segundo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private ControladorSegundo controladorSegundo;
	private JButton btnSelecCurso;
	private JComboBox<String> comboBox;
	private int id_curso=0, id_asignatura=0;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	

	/**
	 * Create the panel.
	 */
	public Segundo() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pasar a segundo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		setBackground(new Color(32, 33, 35));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32,33,35));
		add(panel);
		//comboBox.addItem("DAM1");
		//comboBox.addItem("ASIR1");
		
		panel.setLayout(new GridLayout(7, 2, 0, 0));
		
		lblNewLabel_5 = new JLabel("Los primeros cursos se transferiran a segundo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("Los segundos se graduar\u00E1n de la escuela");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setForeground(Color.WHITE);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		
		lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox<String>();
		panel.add(comboBox);
		
		btnSelecCurso = new JButton("Seleccionar Curso");
		panel.add(btnSelecCurso);
		llenarComboBox();
		controladorSegundo =  new ControladorSegundo(this);

	}
	
	private void llenarComboBox() {
		BaseDeDatos bbdd = new BaseDeDatos();
		ResultSet rs = bbdd.getCursos(null);
		try {
			while (rs.next()) {
				String nombreCurso = rs.getString(1);
				String ejemplo = "ejemplo";
				if (nombreCurso != null) {
					if (!nombreCurso.equals(ejemplo)) {
						comboBox.addItem(rs.getString(1));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtnSelecCurso() {
		return btnSelecCurso;
	}

	public void setBtnSelecCurso(JButton btnSelecCurso) {
		this.btnSelecCurso = btnSelecCurso;
	}
}
