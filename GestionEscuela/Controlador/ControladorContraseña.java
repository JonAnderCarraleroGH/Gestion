import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorContraseña{
	private CambioContraseña cambioContraseña;
	public ControladorContraseña(CambioContraseña cambioContraseña) {
		this.cambioContraseña = cambioContraseña;
		cambioContraseña.getBtnCambiar().addActionListener(eventoClick());
	}
	private ActionListener eventoClick() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String contraseña = new String(cambioContraseña.getPasswordFieldContraseña().getPassword());
				String repetir = new String(cambioContraseña.getPasswordFieldRepetir().getPassword());
				if (contraseña.equals(repetir)) {
					BaseDeDatos bbdd = new BaseDeDatos();
					int opcion=JOptionPane.showOptionDialog(null, "¿Estás segura de que quieres cambiar la contraseña?", "Cambio Contraseña", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(opcion==JOptionPane.YES_OPTION) {
						boolean resultado = bbdd.updateContraseña(contraseña, cambioContraseña.getId_personal());
						if (resultado) {
							JOptionPane.showMessageDialog(cambioContraseña, "La contraseña se ha cambiado");
						}
						else {
							JOptionPane.showMessageDialog(cambioContraseña, "Ha habido un error");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(cambioContraseña, "Los campos no coinciden");
				}
			}
		};
	}

}
