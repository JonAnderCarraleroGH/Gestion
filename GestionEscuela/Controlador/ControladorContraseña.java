import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorContrase�a{
	private CambioContrase�a cambioContrase�a;
	public ControladorContrase�a(CambioContrase�a cambioContrase�a) {
		this.cambioContrase�a = cambioContrase�a;
		cambioContrase�a.getBtnCambiar().addActionListener(eventoClick());
	}
	private ActionListener eventoClick() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String contrase�a = new String(cambioContrase�a.getPasswordFieldContrase�a().getPassword());
				String repetir = new String(cambioContrase�a.getPasswordFieldRepetir().getPassword());
				if (contrase�a.equals(repetir)) {
					BaseDeDatos bbdd = new BaseDeDatos();
					int opcion=JOptionPane.showOptionDialog(null, "�Est�s segura de que quieres cambiar la contrase�a?", "Cambio Contrase�a", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(opcion==JOptionPane.YES_OPTION) {
						boolean resultado = bbdd.updateContrase�a(contrase�a, cambioContrase�a.getId_personal());
						if (resultado) {
							JOptionPane.showMessageDialog(cambioContrase�a, "La contrase�a se ha cambiado");
						}
						else {
							JOptionPane.showMessageDialog(cambioContrase�a, "Ha habido un error");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(cambioContrase�a, "Los campos no coinciden");
				}
			}
		};
	}

}
