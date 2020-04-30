import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class CambioContrase�a extends JPanel {
	/**
	 * 
	 */
	private static final Color COLOR_FONDO = new Color(32,33,35);
	private static final Color COLOR_BUTTON = new Color(126,87,194);
	private static final Color FOREGROUND_LABEL = new Color(57,113,177);
	private static final long serialVersionUID = 1L;
	private JButton btnCambiar;
	private JLabel lblNewLabel;
	private JPasswordField passwordFieldContrase�a;
	private JPasswordField passwordFieldRepetir;
	private int id_personal;
	private ControladorContrase�a controladorContrase�a;
	/**
	 * Create the panel.
	 * @param id_personal 
	 */
	public CambioContrase�a(int id_personal) {
		this.setId_personal(id_personal);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cambio de Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		setBackground(COLOR_FONDO);
		setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Nueva Contrase\u00F1a");
		lblNewLabel_3.setForeground(FOREGROUND_LABEL);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_3);
		
		passwordFieldContrase�a = new JPasswordField();
		passwordFieldContrase�a.setCaretColor(Color.CYAN);
		passwordFieldContrase�a.setForeground(Color.WHITE);
		passwordFieldContrase�a.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordFieldContrase�a.setBackground(COLOR_FONDO);
		passwordFieldContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		add(passwordFieldContrase�a);
		
		JLabel lblNewLabel_4 = new JLabel("Repita la contrase\u00F1a");
		lblNewLabel_4.setForeground(FOREGROUND_LABEL);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_4);
		
		passwordFieldRepetir = new JPasswordField();
		passwordFieldRepetir.setCaretColor(Color.CYAN);
		passwordFieldRepetir.setForeground(Color.WHITE);
		passwordFieldRepetir.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordFieldRepetir.setBackground(COLOR_FONDO);
		passwordFieldRepetir.setHorizontalAlignment(SwingConstants.CENTER);
		add(passwordFieldRepetir);
		
		lblNewLabel = new JLabel("");
		add(lblNewLabel);
		
		btnCambiar = new JButton("Cambiar Contrase\u00F1a");
		add(btnCambiar);
		setControladorContrase�a(new ControladorContrase�a(this));
	}

	public int getId_personal() {
		return id_personal;
	}

	public void setId_personal(int id_personal) {
		this.id_personal = id_personal;
	}
	public JButton getBtnCambiar() {
		return btnCambiar;
	}

	public void setBtnCambiar(JButton btnCambiar) {
		this.btnCambiar = btnCambiar;
	}

	public JPasswordField getPasswordFieldContrase�a() {
		return passwordFieldContrase�a;
	}

	public void setPasswordFieldContrase�a(JPasswordField passwordFieldContrase�a) {
		this.passwordFieldContrase�a = passwordFieldContrase�a;
	}

	public JPasswordField getPasswordFieldRepetir() {
		return passwordFieldRepetir;
	}

	public void setPasswordFieldRepetir(JPasswordField passwordFieldRepetir) {
		this.passwordFieldRepetir = passwordFieldRepetir;
	}

	public ControladorContrase�a getControladorContrase�a() {
		return controladorContrase�a;
	}

	public void setControladorContrase�a(ControladorContrase�a controladorContrase�a) {
		this.controladorContrase�a = controladorContrase�a;
	}
}
