import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class InicioSesion extends JFrame {

	/**
	 * 
	 */
	private static final Color COLOR_FONDO = new Color(32,33,35);
	private static final Color FOREGROUND_LABEL = new Color(57,113,177);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Usuario;
	private JPasswordField textField_Contraseña;
	
	private JButton btnIniciarSesion;
	@SuppressWarnings("unused")
	private ControladorLogin controlador;
	private BaseDeDatos bbdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioSesion() {
		setUndecorated(true);
		setBackground(new Color(204, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Sistema de Gestión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 267);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBackground(new Color(102, 204, 102));
		lblNombre.setForeground(FOREGROUND_LABEL);
		lblNombre.setBounds(390, 42, 141, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(FOREGROUND_LABEL);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(390, 102, 141, 14);
		contentPane.add(lblNewLabel);
		
		textField_Usuario = new JTextField();
		textField_Usuario.setCaretColor(Color.CYAN);
		textField_Usuario.setForeground(Color.WHITE);
		textField_Usuario.setBorder(null);
		textField_Usuario.setBackground(COLOR_FONDO);
		textField_Usuario.setBounds(390, 67, 288, 20);
		contentPane.add(textField_Usuario);
		textField_Usuario.setColumns(10);
		
		textField_Contraseña = new JPasswordField();
		textField_Contraseña.setCaretColor(Color.CYAN);
		textField_Contraseña.setForeground(Color.WHITE);
		textField_Contraseña.setBorder(null);
		textField_Contraseña.setBackground(COLOR_FONDO);
		textField_Contraseña.setEchoChar('*');
		textField_Contraseña.setBounds(390, 127, 287, 23);
		contentPane.add(textField_Contraseña);
		textField_Contraseña.setColumns(10);
		
		btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIniciarSesion.setForeground(Color.BLACK);
		btnIniciarSesion.setRolloverEnabled(false);
		btnIniciarSesion.setBackground(new Color(126,87,194));
		btnIniciarSesion.setBounds(391, 171, 287, 42);
		contentPane.add(btnIniciarSesion);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(390, 87, 288, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(390, 150, 287, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InicioSesion.this.dispose();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(661, 11, 17, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIconTextGap(0);
		URL url = getClass().getResource("logo_resize.png");
		lblNewLabel_2.setIcon( new ImageIcon(url));
		lblNewLabel_2.setBounds(10, 40, 359, 202);
		contentPane.add(lblNewLabel_2);
		bbdd = new BaseDeDatos();
		controlador = new ControladorLogin(this, bbdd);
	}
	
	public JPasswordField getTextField_Contraseña() {
		return textField_Contraseña;
	}

	public void setTextField_Contraseña(JPasswordField textField_Contraseña) {
		this.textField_Contraseña = textField_Contraseña;
	}


	public JTextField getTextField_Usuario() {
		return textField_Usuario;
	}

	public void setTextField_Usuario(JTextField textField_Usuario) {
		this.textField_Usuario = textField_Usuario;
	}


	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}
}
