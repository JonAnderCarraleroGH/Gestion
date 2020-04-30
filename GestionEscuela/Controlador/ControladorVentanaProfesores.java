import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorVentanaProfesores {
	VentanaProfesores ventanaProfesores;
	private int alto, ancho;
	private  int posx,posy;

	public ControladorVentanaProfesores(VentanaProfesores ventanaProfesores) {
		super();
		this.ventanaProfesores = ventanaProfesores;
		ventanaProfesores.addComponentListener(eventoResize());
		ventanaProfesores.getLblX().addMouseListener(closeWindow());
		ventanaProfesores.getLblMinimize().addMouseListener(minimizeWindow());
		ventanaProfesores.getLblMaximize().addMouseListener(maximizeWindow());
		ventanaProfesores.getLblLogOut().addMouseListener(clickLabel());
		ventanaProfesores.getLblContraseña().addMouseListener(clickLabel());
	}

	public MouseAdapter clickLabel() {
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				LabelMenu label = (LabelMenu) e.getSource();
				String text = label.getText().toUpperCase();
				@SuppressWarnings("unused")
				Color original = new Color(32, 33, 35);
				BorderLayout layout = (BorderLayout)ventanaProfesores.getContentPane().getLayout();

				switch (text) {
				case "PERFIL":
					break;
				case "CAMBIAR CONTRASEÑA":
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaProfesores.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					int id_personal = ventanaProfesores.getId_personal();
					ventanaProfesores.getContentPane().add(new CambioContraseña(id_personal),BorderLayout.CENTER);
					ventanaProfesores.getContentPane().revalidate();
					ventanaProfesores.repaint();
					break;
				case "LOG OUT":
					ventanaProfesores.dispose();
					new InicioSesion().setVisible(true);
					break;

				default:
					break;
				}

			}
		};
	}


	public MouseAdapter maximizeWindow() {
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (ventanaProfesores.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
					ventanaProfesores.setBounds(posx, posy, ancho, alto);
				}
				else {
					alto = ventanaProfesores.getHeight();
					ancho = ventanaProfesores.getWidth();
					posx = ventanaProfesores.getX();
					posy = ventanaProfesores.getY();
					ventanaProfesores.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}


			}
		};
	}
	public MouseAdapter closeWindow() {
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventanaProfesores.dispose();

			}
		};
	}
	public MouseAdapter minimizeWindow() {
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventanaProfesores.setState(JFrame.ICONIFIED);
			}
		};
	}


	public ActionListener escuchadorPosiciones (int id, String asignatura) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BorderLayout layout = (BorderLayout)ventanaProfesores.getContentPane().getLayout();
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaProfesores.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					ventanaProfesores.setPosiciones( new Posiciones(id, asignatura));
					ventanaProfesores.getContenedor().add(ventanaProfesores.getPosiciones(), BorderLayout.CENTER);
					ventanaProfesores.getContenedor().revalidate();
					ventanaProfesores.repaint();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				}						
			}
		};
	}
	public  ComponentAdapter eventoResize() {
		return new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int tamañoFuente = (ventanaProfesores.getWidth() + ventanaProfesores.getHeight())/100;
				ControladorVentanaPrincipal.changeFont(ventanaProfesores, tamañoFuente);

			}
		};
	}

	public ActionListener escuchadorNotas (int id, String asignatura) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String entrada = null;
				int trimestre=-1;
				do {
					try {
						entrada = JOptionPane.showInputDialog(ventanaProfesores, "¿Que trimestre desea visualizar/modificar?");
						if(entrada==null) {
							break;
						}
						trimestre = Integer.parseInt(entrada);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(ventanaProfesores, "Por favor introduzca un numero entre 1 y 3");
						
						
					}
				} while (trimestre<0 || trimestre>3);
				if(trimestre!=-1) {
					BorderLayout layout = (BorderLayout)ventanaProfesores.getContentPane().getLayout();
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaProfesores.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					ventanaProfesores.setPanelNotas(new PanelNotas(id, asignatura,trimestre));
					ventanaProfesores.getContenedor().add(ventanaProfesores.getPanelNotas(), BorderLayout.CENTER);
					ventanaProfesores.getContenedor().revalidate();
					ventanaProfesores.repaint();
				}
			}
		};
	}

	public MouseListener eventoMouse() {
		return new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		};
	}
}
