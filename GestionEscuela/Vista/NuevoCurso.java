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

public class NuevoCurso extends JPanel {
	
	
	/**
	 * 
	 */
	private static final Color COLOR_FONDO = new Color(32,33,35);
	private static final Color COLOR_BUTTON = new Color(126,87,194);
	private static final Color FOREGROUND_LABEL = new Color(57,113,177);
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldAs;
	private JTextField textFieldAs1;
	private JTextField textFieldAs2;
	private JTextField textFieldAs3;
	private JTextField textFieldAs4;
	private JButton btnAñadir;
	@SuppressWarnings("unused")
	private ControladorNuevoCurso controladorNuevoCurso;
	private Color colorFondoTxt;
	private Color colorLabel;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	private JComboBox<String> comboBox3;
	private JComboBox<String> comboBox4;
	/**
	 * Create the panel.
	 */
	public NuevoCurso() {
		colorFondoTxt = COLOR_FONDO;
		colorLabel = FOREGROUND_LABEL;
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear Nuevo Curso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		setBackground(colorFondoTxt);
		setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblNombre = new JLabel("Nombre del Curso");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setForeground(colorLabel);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setCaretColor(Color.MAGENTA);
		textFieldNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNombre.setBackground(colorFondoTxt);
		textFieldNombre.setForeground(Color.WHITE);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBorder(null);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Nueva Asignatura");
		lblNewLabel_1.setForeground(colorLabel);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		textFieldAs = new JTextField();
		textFieldAs.setCaretColor(Color.MAGENTA);
		textFieldAs.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldAs.setBackground(colorFondoTxt);
		textFieldAs.setForeground(Color.WHITE);
		add(textFieldAs);
		textFieldAs.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Se convalida con:");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_8);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.BLUE);
		add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Nueva Asignatura");
		lblNewLabel_2.setForeground(colorLabel);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_2);
		
		textFieldAs1 = new JTextField();
		textFieldAs1.setCaretColor(Color.MAGENTA);
		textFieldAs1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldAs1.setBackground(colorFondoTxt);
		textFieldAs1.setForeground(Color.WHITE);
		add(textFieldAs1);
		textFieldAs1.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Se convalida con:");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_9);
		
		comboBox1 = new JComboBox<String>();
		add(comboBox1);
		
		JLabel lblNewLabel_3 = new JLabel("Nueva Asignatura");
		lblNewLabel_3.setForeground(colorLabel);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_3);
		
		textFieldAs2 = new JTextField();
		textFieldAs2.setCaretColor(Color.MAGENTA);
		textFieldAs2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldAs2.setBackground(colorFondoTxt);
		textFieldAs2.setForeground(Color.WHITE);
		add(textFieldAs2);
		textFieldAs2.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Se convalida con:");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_10);
		
		comboBox2 = new JComboBox<String>();
		add(comboBox2);
		
		JLabel lblNewLabel_4 = new JLabel("Nueva Asignatura");
		lblNewLabel_4.setForeground(colorLabel);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_4);
		
		textFieldAs3 = new JTextField();
		textFieldAs3.setCaretColor(Color.MAGENTA);
		textFieldAs3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldAs3.setBackground(colorFondoTxt);
		textFieldAs3.setForeground(Color.WHITE);
		add(textFieldAs3);
		textFieldAs3.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Se convalida con:");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_11);
		
		comboBox3 = new JComboBox<String>();
		add(comboBox3);
		
		JLabel lblNewLabel_5 = new JLabel("Nueva Asignatura");
		lblNewLabel_5.setForeground(colorLabel);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_5);
		
		textFieldAs4 = new JTextField();
		textFieldAs4.setCaretColor(Color.MAGENTA);
		textFieldAs4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textFieldAs4.setBackground(colorFondoTxt);
		textFieldAs4.setForeground(Color.WHITE);
		add(textFieldAs4);
		textFieldAs4.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Se convalida con:");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_12);
		
		comboBox4 = new JComboBox<String>();
		add(comboBox4);
		
		JLabel lblNewLabel_7 = new JLabel("");
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_13 = new JLabel("");
		add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		add(lblNewLabel_14);
		
		JPanel panel = new JPanel();
		panel.setBackground(colorFondoTxt);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAñadir = new JButton("Crear");
		btnAñadir.setEnabled(false);
		btnAñadir.setForeground(Color.BLUE);
		btnAñadir.setBackground(COLOR_BUTTON);
		panel.add(btnAñadir);
		llenarComboBox();
		controladorNuevoCurso = new ControladorNuevoCurso(this);
	}

	private void llenarComboBox() {
		BaseDeDatos bbdd = new BaseDeDatos();
		ResultSet rs = bbdd.getAllAsignaturas();
		comboBox.addItem(null);
		comboBox1.addItem(null);	
		comboBox2.addItem(null);	
		comboBox3.addItem(null);	
		comboBox4.addItem(null);	
		try {
			while (rs.next()) {
				comboBox.addItem(rs.getString(1));
				comboBox1.addItem(rs.getString(1));	
				comboBox2.addItem(rs.getString(1));	
				comboBox3.addItem(rs.getString(1));	
				comboBox4.addItem(rs.getString(1));	
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

	public JTextField getTextFieldAs() {
		return textFieldAs;
	}

	public void setTextFieldAs(JTextField textFieldAs) {
		this.textFieldAs = textFieldAs;
	}

	public JTextField getTextFieldAs1() {
		return textFieldAs1;
	}

	public void setTextFieldAs1(JTextField textFieldAs1) {
		this.textFieldAs1 = textFieldAs1;
	}

	public JTextField getTextFieldAs2() {
		return textFieldAs2;
	}

	public void setTextFieldAs2(JTextField textFieldAs2) {
		this.textFieldAs2 = textFieldAs2;
	}

	public JTextField getTextFieldAs3() {
		return textFieldAs3;
	}

	public void setTextFieldAs3(JTextField textFieldAs3) {
		this.textFieldAs3 = textFieldAs3;
	}

	public JTextField getTextFieldAs4() {
		return textFieldAs4;
	}

	public void setTextFieldAs4(JTextField textFieldAs4) {
		this.textFieldAs4 = textFieldAs4;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}

	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}

	public Color getColorFondoTxt() {
		return colorFondoTxt;
	}

	public void setColorFondoTxt(Color colorFondoTxt) {
		this.colorFondoTxt = colorFondoTxt;
	}

	public Color getColorLabel() {
		return colorLabel;
	}

	public void setColorLabel(Color colorLabel) {
		this.colorLabel = colorLabel;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JComboBox<String> getComboBox1() {
		return comboBox1;
	}

	public void setComboBox1(JComboBox<String> comboBox1) {
		this.comboBox1 = comboBox1;
	}

	public JComboBox<String> getComboBox2() {
		return comboBox2;
	}

	public void setComboBox2(JComboBox<String> comboBox2) {
		this.comboBox2 = comboBox2;
	}

	public JComboBox<String> getComboBox3() {
		return comboBox3;
	}

	public void setComboBox3(JComboBox<String> comboBox3) {
		this.comboBox3 = comboBox3;
	}

	public JComboBox<String> getComboBox4() {
		return comboBox4;
	}

	public void setComboBox4(JComboBox<String> comboBox4) {
		this.comboBox4 = comboBox4;
	}

}
