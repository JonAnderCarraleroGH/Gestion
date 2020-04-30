import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final Color COLOR_FONDO = new Color(32,33,35);
	private static final Color COLOR_BUTTON = new Color(126,87,194);
	private static final Color FOREGROUND_LABEL = new Color(57,113,177);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int id_personal;
	private JPanel panel;
	private LabelMenu lblTransferir;
	private LabelMenu lblAlta;
	private LabelMenu lblBaja;
	private LabelMenu lblModificar;
	private LabelMenu lblPagos;
	private LabelMenu lblLogout;
	@SuppressWarnings("unused")
	private ControladorVentanaPrincipal controladorVentanaPrincipal;
	private JPanel panelTitulo;
	private JLabel lblX;
	private JLabel lblMinimize;
	@SuppressWarnings("unused")
	private ComponentMover cm;
	@SuppressWarnings("unused")
	private ComponentResizer cr;
	private JLabel lblNuevoCurso;
	private JPanel panelMenuIzquierda;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblBienvenido;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal("ejemplo",1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param nombre 
	 * @param id 
	 */
	public VentanaPrincipal(String nombre, int id) {
		setUndecorated(true);
		id_personal = id;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 439);
		
		contentPane = new JPanel();
		contentPane.setBackground(COLOR_FONDO);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		//panel.setBackground(COLOR_FONDO);
		panel.setBackground(new Color(67,60,82));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(7, 1, 10, 10));
		
		lblNuevoCurso = new LabelMenu("Crear Nuevo Curso");
		panel.add(lblNuevoCurso);
		
		lblTransferir = new LabelMenu("Pasar de Curso");
		panel.add(lblTransferir);
		
		lblAlta = new LabelMenu("Alta Alumno");
		panel.add(lblAlta);
		
		lblBaja = new LabelMenu("Baja Alumno");
		panel.add(lblBaja);
		
		lblModificar = new LabelMenu("Modificar Alumno");
		panel.add(lblModificar);
		
		lblPagos = new LabelMenu("Comprobar Pagos???");
		lblPagos.setText("Comprobar Pagos");
		panel.add(lblPagos);
		
		lblLogout = new LabelMenu("Logout");
		lblLogout.setForeground(Color.BLACK);
		lblLogout.setText("Log Out");
		panel.add(lblLogout);
		
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(new Rectangle(10, 10, 0, 0));
		panelTitulo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		panelTitulo.setBackground(COLOR_FONDO);
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cm = new ComponentMover(this, panelTitulo);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelMenuIzquierda = new JPanel();
		panelMenuIzquierda.setBackground(COLOR_FONDO);
		FlowLayout fl_panelMenuIzquierda = (FlowLayout) panelMenuIzquierda.getLayout();
		fl_panelMenuIzquierda.setAlignOnBaseline(true);
		fl_panelMenuIzquierda.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelMenuIzquierda);
		
		lblBienvenido = new JLabel("Bienvenid@ " +nombre);
		lblBienvenido.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 11));
		lblBienvenido.setForeground(Color.white);
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenuIzquierda.add(lblBienvenido);
		
		JPanel panelMenuDerecha = new JPanel();
		panelMenuDerecha.setBackground(COLOR_FONDO);
		FlowLayout fl_panelMenuDerecha = (FlowLayout) panelMenuDerecha.getLayout();
		fl_panelMenuDerecha.setAlignment(FlowLayout.RIGHT);
		panelMenuDerecha.setBounds(-36, 0, 10, 10);
		panelTitulo.add(panelMenuDerecha);
		
		lblMinimize = new JLabel("_");
		panelMenuDerecha.add(lblMinimize);
		lblMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimize.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMinimize.setForeground(Color.CYAN);
		
		separator = new JSeparator();
		panelMenuDerecha.add(separator);
		
		separator_1 = new JSeparator();
		panelMenuDerecha.add(separator_1);
		
		lblX = new JLabel("X");
		panelMenuDerecha.add(lblX);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblX.setForeground(Color.RED);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setBorder(null);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		URL url = getClass().getResource("logo_resize.png");
		lblNewLabel.setIcon( new ImageIcon(url));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		cr = new ComponentResizer(this);
		controladorVentanaPrincipal = new ControladorVentanaPrincipal(this);
		
	}

	public JLabel getLblNuevoCurso() {
		return lblNuevoCurso;
	}

	public void setLblNuevoCurso(JLabel lblNuevoCurso) {
		this.lblNuevoCurso = lblNuevoCurso;
	}

	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(JLabel lblX) {
		this.lblX = lblX;
	}

	public JLabel getLblMinimize() {
		return lblMinimize;
	}

	public void setLblMinimize(JLabel lblMinimize) {
		this.lblMinimize = lblMinimize;
	}

	public LabelMenu getLblTransferir() {
		return lblTransferir;
	}

	public void setLblTransferir(LabelMenu lblTransferir) {
		this.lblTransferir = lblTransferir;
	}


	public LabelMenu getLblAlta() {
		return lblAlta;
	}

	public void setLblAlta(LabelMenu lblAlta) {
		this.lblAlta = lblAlta;
	}

	public LabelMenu getLblBaja() {
		return lblBaja;
	}

	public void setLblBaja(LabelMenu lblBaja) {
		this.lblBaja = lblBaja;
	}

	public LabelMenu getLblModificar() {
		return lblModificar;
	}

	public void setLblModificar(LabelMenu lblModificar) {
		this.lblModificar = lblModificar;
	}

	public LabelMenu getLblPagos() {
		return lblPagos;
	}

	public void setLblPagos(LabelMenu lblPagos) {
		this.lblPagos = lblPagos;
	}

	public int getId_personal() {
		return id_personal;
	}

	public void setId_personal(int id_personal) {
		this.id_personal = id_personal;
	}

	public LabelMenu getLblLogout() {
		return lblLogout;
	}

	public void setLblLogout(LabelMenu lblLogout) {
		this.lblLogout = lblLogout;
	}
}
