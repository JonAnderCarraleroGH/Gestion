import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class ControladorVentanaPrincipal {
	private VentanaPrincipal ventanaPrincipal;
	@SuppressWarnings("unused")
	private BaseDeDatos bbdd;

	public ControladorVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
		ventanaPrincipal.getLblAlta().addMouseListener(eventoHover());
		ventanaPrincipal.getLblBaja().addMouseListener(eventoHover());
		ventanaPrincipal.getLblModificar().addMouseListener(eventoHover());
		ventanaPrincipal.getLblPagos().addMouseListener(eventoHover());
		ventanaPrincipal.getLblNuevoCurso().addMouseListener(eventoHover());
		ventanaPrincipal.getLblTransferir().addMouseListener(eventoHover());
		ventanaPrincipal.addComponentListener(eventoResize());
		ventanaPrincipal.getLblX().addMouseListener(closeWindow());
		ventanaPrincipal.getLblMinimize().addMouseListener(minimizeWindow());
		ventanaPrincipal.getLblLogout().addMouseListener(clickLabel());
	}
	
	public MouseAdapter closeWindow() {
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventanaPrincipal.dispose();
				
			}
		};
	}
	public MouseAdapter minimizeWindow() {
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				ventanaPrincipal.setState(JFrame.ICONIFIED);
			}
		};
	}
	public MouseListener eventoHover() {
		return new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				//LabelMenu label = (LabelMenu) e.getSource();
				//label.setBackground(label.getColorOriginal());
				//label.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				//LabelMenu label = (LabelMenu) e.getSource();
				////label.setOpaque(true);
				//label.setBackground(new Color(116, 82, 255));
				//ventanaPrincipal.repaint();

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				LabelMenu label = (LabelMenu) e.getSource();
				String text = label.getText().toUpperCase();
				@SuppressWarnings("unused")
				Color original = new Color(32, 33, 35);
				BorderLayout layout = (BorderLayout)ventanaPrincipal.getContentPane().getLayout();
				
				switch (text) {
				case "ALTA ALUMNO":
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaPrincipal.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					ventanaPrincipal.getContentPane().add(new Altas(),BorderLayout.CENTER);
					ventanaPrincipal.getContentPane().revalidate();
					ventanaPrincipal.repaint();
					break;
				case "BAJA ALUMNO":
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaPrincipal.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					ventanaPrincipal.getContentPane().add(new Bajas(),BorderLayout.CENTER);
					ventanaPrincipal.getContentPane().revalidate();	
					ventanaPrincipal.repaint();
					break;
				case "MODIFICAR ALUMNO":
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaPrincipal.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					ventanaPrincipal.getContentPane().add(new Modificar(), BorderLayout.CENTER);
					ventanaPrincipal.getContentPane().revalidate();
					ventanaPrincipal.repaint();
					break;
				case "PASAR DE CURSO":
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaPrincipal.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					ventanaPrincipal.getContentPane().add(new Segundo(), BorderLayout.CENTER);
					ventanaPrincipal.getContentPane().revalidate();
					ventanaPrincipal.repaint();

					break;
				case "COMPROBAR PAGOS":
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaPrincipal.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					ventanaPrincipal.getContentPane().add(new Pagos(), BorderLayout.CENTER);
					ventanaPrincipal.getContentPane().revalidate();
					ventanaPrincipal.repaint();
					break;
				case "CREAR NUEVO CURSO":
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						ventanaPrincipal.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					ventanaPrincipal.getContentPane().add(new NuevoCurso(), BorderLayout.CENTER);
					ventanaPrincipal.getContentPane().revalidate();
					ventanaPrincipal.repaint();
					break;

				default:
					break;
				}

			}
		};
	}

	public  ComponentAdapter eventoResize() {
		return new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int tamañoFuente = (ventanaPrincipal.getWidth() + ventanaPrincipal.getHeight())/90;
				changeFont(ventanaPrincipal, tamañoFuente);
				
			}
		};
	}
	
	public static void changeFont(Component component, int fontSize) {
	    Font f = component.getFont();
	    component.setFont(new Font(f.getName(),f.getStyle(),fontSize));
	    if (component instanceof Container) {
	        for (Component child : ((Container) component).getComponents()) {
	            changeFont(child, fontSize);
	        }
	    }
	}
	
	public MouseAdapter clickLabel() {
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				LabelMenu label = (LabelMenu) e.getSource();
				String text = label.getText().toUpperCase();
				@SuppressWarnings("unused")
				Color original = new Color(32, 33, 35);
				BorderLayout layout = (BorderLayout)ventanaPrincipal.getContentPane().getLayout();
				ventanaPrincipal.dispose();
				new InicioSesion().setVisible(true);
			}
		};
	}
}


