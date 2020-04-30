import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Font;


public class Pagos extends JPanel {
	private static final Color COLOR_FONDO = new Color(32,33,35);
	private static final Color FOREGROUND_LABEL = new Color(57,113,177);
	private JTextField txtAlumno;
	private JButton btnAlumno;
	private ControladorPagos controladorPagos;
	private JTextArea textArea;

	

	/**
	 * Create the panel.
	 */
	public Pagos() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(COLOR_FONDO);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtAlumno = new JTextField();
		txtAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlumno.setText("Introduce DNI");
		panel.add(txtAlumno);
		txtAlumno.setColumns(10);
		txtAlumno.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				//txtIntroduzcaElDni.setText("Introduzca el dni a buscar");
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtAlumno.setText("");
			}
		});
		
		btnAlumno = new JButton("Buscar");
		btnAlumno.setContentAreaFilled(false);
		btnAlumno.setOpaque(true);
		btnAlumno.setForeground(Color.WHITE);
		btnAlumno.setBackground(new Color(126,87,194));
		panel.add(btnAlumno);
		controladorPagos= new ControladorPagos(this);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setForeground(FOREGROUND_LABEL);
		textArea.setBackground(COLOR_FONDO);
		add(textArea, BorderLayout.CENTER);
		
		}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JTextField getTxtAlumno() {
		return txtAlumno;
	}

	public void setTxtAlumno(JTextField txtAlumno) {
		this.txtAlumno = txtAlumno;
	}
	public JButton getBtnAlumno() {
		return btnAlumno;
	}


	public void setBtnAlumno(JButton btnAlumno) {
		this.btnAlumno = btnAlumno;
	}

}



