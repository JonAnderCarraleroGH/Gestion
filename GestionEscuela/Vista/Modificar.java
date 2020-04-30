import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class Modificar extends JPanel {
	/**
	 * 
	 */
	private static final Color COLOR_FONDO = new Color(32,33,35);
	private static final Color FOREGROUND_LABEL = new Color(57,113,177);
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldDni;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JButton btnAñadir;
	private JTextField txtIntroduzcaElDni;
	private JButton btnBuscar;
	@SuppressWarnings("unused")
	private ControladorModificar controladorModificar;
	

	/**
	 * Create the panel.
	 */
	public Modificar() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modificar Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		setBackground(COLOR_FONDO);
		setLayout(new GridLayout(8, 2, 0, 0));

		txtIntroduzcaElDni = new JTextField();
		txtIntroduzcaElDni.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntroduzcaElDni.setText("Introduzca el dni a buscar");
		add(txtIntroduzcaElDni);
		txtIntroduzcaElDni.setColumns(10);
		txtIntroduzcaElDni.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				//txtIntroduzcaElDni.setText("Introduzca el dni a buscar");
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtIntroduzcaElDni.setText("");
			}
		});
		
		btnBuscar = new JButton("Buscar Por Dni");
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBackground(new Color(126,87,194));
		btnBuscar.setEnabled(false);

		add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Nombre");
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
		
		JLabel lblNewLabel_7 = new JLabel("");
		add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(COLOR_FONDO);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAñadir = new JButton("Modificar");
		btnAñadir.setForeground(Color.BLUE);
		btnAñadir.setContentAreaFilled(false);
		btnAñadir.setOpaque(true);
		btnAñadir.setBackground(new Color(126,87,194));
		panel.add(btnAñadir);
		btnAñadir.setEnabled(false);
		controladorModificar =  new ControladorModificar(this);

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


	public JTextField getTxtIntroduzcaElDni() {
		return txtIntroduzcaElDni;
	}


	public void setTxtIntroduzcaElDni(JTextField txtIntroduzcaElDni) {
		this.txtIntroduzcaElDni = txtIntroduzcaElDni;
	}


	public JButton getBtnBuscar() {
		return btnBuscar;
	}


	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

}
