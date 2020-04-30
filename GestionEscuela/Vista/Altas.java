import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class Altas extends JPanel {
	/**
	 * 
	 */
	private static final Color COLOR_FONDO = new Color(32,33,35);
	private static final Color COLOR_BUTTON = new Color(126,87,194);
	private static final Color FOREGROUND_LABEL = new Color(57,113,177);
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldDni;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JButton btnAñadir;
	private JComboBox<String> comboBox;
	private ControladorAltas controladorAltas;

	

	/**
	 * Create the panel.
	 */
	public Altas() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Altas de Alumnos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		setBackground(COLOR_FONDO);
		setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setForeground(FOREGROUND_LABEL);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setCaretColor(Color.MAGENTA);
		textFieldNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNombre.setBackground(COLOR_FONDO);
		textFieldNombre.setForeground(Color.WHITE);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("1er Apellido");
		lblNewLabel_1.setForeground(FOREGROUND_LABEL);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setCaretColor(Color.MAGENTA);
		textFieldApellido1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldApellido1.setBackground(COLOR_FONDO);
		textFieldApellido1.setForeground(Color.WHITE);
		add(textFieldApellido1);
		textFieldApellido1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("2\u00BA Apellido");
		lblNewLabel_2.setForeground(FOREGROUND_LABEL);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_2);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setCaretColor(Color.MAGENTA);
		textFieldApellido2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldApellido2.setBackground(COLOR_FONDO);
		textFieldApellido2.setForeground(Color.WHITE);
		add(textFieldApellido2);
		textFieldApellido2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setForeground(FOREGROUND_LABEL);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_3);
		
		textFieldDni = new JTextField();
		textFieldDni.setCaretColor(Color.MAGENTA);
		textFieldDni.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldDni.setBackground(COLOR_FONDO);
		textFieldDni.setForeground(Color.WHITE);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Numero de Tel\u00E9fono");
		lblNewLabel_4.setForeground(FOREGROUND_LABEL);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_4);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setCaretColor(Color.MAGENTA);
		textFieldTelefono.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldTelefono.setBackground(COLOR_FONDO);
		textFieldTelefono.setForeground(Color.WHITE);
		add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(FOREGROUND_LABEL);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_5);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setCaretColor(Color.MAGENTA);
		textFieldEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldEmail.setBackground(COLOR_FONDO);
		textFieldEmail.setForeground(Color.WHITE);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Curso");
		lblNewLabel_6.setForeground(FOREGROUND_LABEL);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_6);
		
		comboBox = new JComboBox<String>();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(FOREGROUND_LABEL);
		add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("");
		add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(COLOR_FONDO);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAñadir = new JButton("A\u00F1adir ");
		btnAñadir.setForeground(Color.BLUE);
		btnAñadir.setBackground(COLOR_BUTTON);
		panel.add(btnAñadir);
		llenarComboBox();
		controladorAltas = new ControladorAltas(this);
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
			e.printStackTrace();
		}
	}
	
	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldApellido1() {
		return textFieldApellido1;
	}

	public void setTextFieldApellido1(JTextField textFieldApellido1) {
		this.textFieldApellido1 = textFieldApellido1;
	}

	public JTextField getTextFieldApellido2() {
		return textFieldApellido2;
	}

	public void setTextFieldApellido2(JTextField textFieldApellido2) {
		this.textFieldApellido2 = textFieldApellido2;
	}

	public JTextField getTextFieldDni() {
		return textFieldDni;
	}

	public void setTextFieldDni(JTextField textFieldDni) {
		this.textFieldDni = textFieldDni;
	}

	public JTextField getTextFieldTelefono() {
		return textFieldTelefono;
	}

	public void setTextFieldTelefono(JTextField textFieldTelefono) {
		this.textFieldTelefono = textFieldTelefono;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(JTextField textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}

	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public ControladorAltas getControladorAltas() {
		return controladorAltas;
	}

	public void setControladorAltas(ControladorAltas controladorAltas) {
		this.controladorAltas = controladorAltas;
	}

}
