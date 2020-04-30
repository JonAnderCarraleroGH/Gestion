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

public class Bajas extends JPanel {
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
	private JButton btnDelete;
	private JTextField txtIntroduzcaElDni2;
	private JButton btnBuscar2;
	@SuppressWarnings("unused")
	private ControladorBajas controladorBajas;

	/**
	 * Create the panel.
	 */
	public Bajas() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bajas de Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		setBackground(COLOR_FONDO);
		setLayout(new GridLayout(8, 2, 0, 0));
		
		txtIntroduzcaElDni2 = new JTextField();
		txtIntroduzcaElDni2.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntroduzcaElDni2.setText("Introduzca el dni a buscar");
		add(txtIntroduzcaElDni2);
		txtIntroduzcaElDni2.setColumns(10);
		txtIntroduzcaElDni2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				//txtIntroduzcaElDni2.setText("Introduzca el dni a buscar");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtIntroduzcaElDni2.setText("");
			}
		});
		
		btnBuscar2 = new JButton("Buscar Por Dni");
		btnBuscar2.setEnabled(false);
		btnBuscar2.setContentAreaFilled(false);
		btnBuscar2.setOpaque(true);
		btnBuscar2.setBackground(COLOR_BUTTON);
		add(btnBuscar2);
		
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
		textFieldNombre.setEditable(false);
		
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
		textFieldApellido1.setEditable(false);
		
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
		textFieldApellido2.setEditable(false);
		
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
		textFieldDni.setEditable(false);
		
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
		textFieldTelefono.setEditable(false);
		
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
		textFieldEmail.setEditable(false);
		
		JLabel lblNewLabel_7 = new JLabel("");
		add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(COLOR_FONDO);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnDelete = new JButton("Deshabilitar");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setOpaque(true);
		btnDelete.setBackground(COLOR_BUTTON);
		
		panel.add(btnDelete);
		controladorBajas=new ControladorBajas(this);
		

	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JTextField getTxtIntroduzcaElDni2() {
		return txtIntroduzcaElDni2;
	}

	public void setTxtIntroduzcaElDni2(JTextField txtIntroduzcaElDni2) {
		this.txtIntroduzcaElDni2 = txtIntroduzcaElDni2;
	}

	public JButton getBtnBuscar2() {
		return btnBuscar2;
	}

	public void setBtnBuscar2(JButton btnBuscar2) {
		this.btnBuscar2 = btnBuscar2;
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

}

