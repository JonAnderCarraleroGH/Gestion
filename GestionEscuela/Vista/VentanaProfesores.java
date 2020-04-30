import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class VentanaProfesores extends JFrame {

	/**
	 * 
	 */
	private static final Color COLOR_FONDO = new Color(32,33,35);
	private static final Color COLOR_BUTTON = new Color(126,87,194);
	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JMenu mnHerramientas;
	private ControladorVentanaProfesores controladorVentanaProfesores;
	private int id_personal;
	private JMenu mnInfo;
	private ArrayList<JMenuItem> asignaturas;
	private ArrayList<JMenuItem> asignaturas_notas;
	private BaseDeDatos bbdd;
	private Posiciones posiciones;
	private JMenuBar menuBar;
	private JMenu mnNotas;
	private PanelNotas panelNotas;
	private JPanel panelTitulo;
	private JLabel lblX;
	private JLabel lblMinimize;
	private JSeparator separator;
	private JSeparator separator_1;
	@SuppressWarnings("unused")
	private ComponentMover cm;
	@SuppressWarnings("unused")
	private ComponentResizer cr;
	private JLabel lblMaximize;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JPanel panel;
	private LabelMenu lblPerfil;
	private LabelMenu lblContraseña;
	private LabelMenu lblLogOut;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProfesores frame = new VentanaProfesores("ejemplo",1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 * @param id 
	 */
	public VentanaProfesores(String nombreProfesor, int id) {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		setForeground(Color.WHITE);
		setUndecorated(true);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		id_personal=id;
		bbdd = new BaseDeDatos();
		setTitle("Bienvenid@ " + nombreProfesor);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 568);

		menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.setBackground(new Color(126,87,194));
		menuBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		setJMenuBar(menuBar);
		contenedor = new JPanel();
		contenedor.setBackground(COLOR_FONDO);
		mnHerramientas = new JMenu("Herramientas");
		mnHerramientas.setBackground(Color.GRAY);
		mnHerramientas.setForeground(Color.white);
		menuBar.add(mnHerramientas);
		setContentPane(contenedor);
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));

		mnInfo = new JMenu("Informacion de Asignatura");
		mnInfo.setBackground(Color.CYAN);
		mnHerramientas.add(mnInfo);

		mnNotas = new JMenu("Ver/Modificar notas");
		mnNotas.setBackground(Color.CYAN);
		mnHerramientas.add(mnNotas);

		panelTitulo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelTitulo.setBackground(COLOR_FONDO);
		menuBar.add(panelTitulo);

		lblMinimize = new JLabel("_");
		lblMinimize.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMinimize.setBackground(Color.WHITE);
		lblMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimize.setForeground(Color.CYAN);
		panelTitulo.add(lblMinimize);

		separator_2 = new JSeparator();
		panelTitulo.add(separator_2);

		separator_3 = new JSeparator();
		panelTitulo.add(separator_3);

		lblMaximize = new JLabel("[]");
		lblMaximize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMaximize.setForeground(Color.YELLOW);
		panelTitulo.add(lblMaximize);

		separator_1 = new JSeparator();
		panelTitulo.add(separator_1);

		separator = new JSeparator();
		panelTitulo.add(separator);

		lblX = new JLabel("X");
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setForeground(Color.RED);
		panelTitulo.add(lblX);
		cm = new ComponentMover(this, panelTitulo);




		contenedor.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(67,60,82));
		contenedor.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(5, 1, 10, 20));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(67,60,82));
		panel.add(panel_1);

		panel_1.setLayout(new GridLayout(2, 0, 0, 0));

		lblNewLabel_2 = new JLabel("Bienvenido");
		lblNewLabel_2.setFont(new Font("Script MT Bold", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(COLOR_BUTTON);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel(nombreProfesor);
		lblNewLabel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		lblNewLabel_3.setFont(new Font("Script MT Bold", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		lblPerfil = new LabelMenu("New label");
		lblPerfil.setText("Coming soon");
		panel.add(lblPerfil);

		lblContraseña = new LabelMenu("New label");
		lblContraseña.setToolTipText("");
		lblContraseña.setText("Cambiar Contrase\u00F1a");
		panel.add(lblContraseña);

		lblLogOut = new LabelMenu("New label");
		lblLogOut.setForeground(Color.BLACK);

		lblLogOut.setText("Log Out");
		panel.add(lblLogOut);

		lblNewLabel_5 = new JLabel("Academia Almi");
		lblNewLabel_5.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.LIGHT_GRAY));
		lblNewLabel_5.setFont(new Font("Script MT Bold", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		URL url = getClass().getResource("logo_resize.png");
		lblNewLabel.setIcon( new ImageIcon(url));
		contenedor.add(lblNewLabel, BorderLayout.CENTER);
		controladorVentanaProfesores = new ControladorVentanaProfesores(this);
		iniciarSubMenuAsignaturas();
		/*JPanel jPanel = new JPanel();
		contentPane.add(jPanel, BorderLayout.CENTER);*/
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		cr = new ComponentResizer(this);
	}

	private void iniciarSubMenuAsignaturas() {
		asignaturas = new ArrayList<JMenuItem>();
		asignaturas_notas = new ArrayList<JMenuItem>();
		ResultSet selectAsignaturas = bbdd.getAsignaturasById(id_personal);
		try {
			selectAsignaturas.beforeFirst();
			while (selectAsignaturas.next()) {
				JMenuItem aux = new JMenuItem(selectAsignaturas.getString(2));
				JMenuItem auxNotas = new JMenuItem(selectAsignaturas.getString(2));
				int id = Integer.parseInt(selectAsignaturas.getString(1));	
				String nombreAsignatura = selectAsignaturas.getString(2);
				aux.addActionListener(controladorVentanaProfesores.escuchadorPosiciones(id, nombreAsignatura));
				auxNotas.addActionListener(controladorVentanaProfesores.escuchadorNotas(id, nombreAsignatura));
				asignaturas_notas.add(auxNotas);
				mnNotas.add(auxNotas);
				asignaturas.add(aux) ;
				mnInfo.add(aux);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getId_personal() {
		return id_personal;
	}

	public void setId_personal(int id_personal) {
		this.id_personal = id_personal;
	}
	

	public LabelMenu getLblPerfil() {
		return lblPerfil;
	}

	public void setLblPerfil(LabelMenu lblPerfil) {
		this.lblPerfil = lblPerfil;
	}

	public LabelMenu getLblContraseña() {
		return lblContraseña;
	}

	public void setLblContraseña(LabelMenu lblContraseña) {
		this.lblContraseña = lblContraseña;
	}

	public LabelMenu getLblLogOut() {
		return lblLogOut;
	}

	public void setLblLogOut(LabelMenu lblLogOut) {
		this.lblLogOut = lblLogOut;
	}

	public JLabel getLblMaximize() {
		return lblMaximize;
	}

	public void setLblMaximize(LabelMenu lblMaximize) {
		this.lblMaximize = lblMaximize;
	}

	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(LabelMenu lblX) {
		this.lblX = lblX;
	}

	public JLabel getLblMinimize() {
		return lblMinimize;
	}

	public void setLblMinimize(LabelMenu lblMinimize) {
		this.lblMinimize = lblMinimize;
	}

	public JMenu getMnHerramientas() {
		return mnHerramientas;
	}

	public void setMnHerramientas(JMenu mnHerramientas) {
		this.mnHerramientas = mnHerramientas;
	}

	public ControladorVentanaProfesores getControladorVentanaProfesores() {
		return controladorVentanaProfesores;
	}

	public void setControladorVentanaProfesores(ControladorVentanaProfesores controladorVentanaProfesores) {
		this.controladorVentanaProfesores = controladorVentanaProfesores;
	}

	public JMenu getMnInfo() {
		return mnInfo;
	}

	public void setMnInfo(JMenu mnInfo) {
		this.mnInfo = mnInfo;
	}

	public ArrayList<JMenuItem> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<JMenuItem> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public ArrayList<JMenuItem> getAsignaturas_notas() {
		return asignaturas_notas;
	}

	public void setAsignaturas_notas(ArrayList<JMenuItem> asignaturas_notas) {
		this.asignaturas_notas = asignaturas_notas;
	}

	public BaseDeDatos getBbdd() {
		return bbdd;
	}

	public void setBbdd(BaseDeDatos bbdd) {
		this.bbdd = bbdd;
	}

	public Posiciones getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(Posiciones posiciones) {
		this.posiciones = posiciones;
	}

	public JMenu getMnNotas() {
		return mnNotas;
	}

	public void setMnNotas(JMenu mnNotas) {
		this.mnNotas = mnNotas;
	}

	public PanelNotas getPanelNotas() {
		return panelNotas;
	}

	public JPanel getContenedor() {
		return contenedor;
	}

	public void setContenedor(JPanel contenedor) {
		this.contenedor = contenedor;
	}

	public void setPanelNotas(PanelNotas panelNotas) {
		this.panelNotas = panelNotas;
	}
}
