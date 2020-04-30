/*import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ControladorPagos {
	private BaseDeDatos bbdd;
	private static final String [] NOMBRES_COLUMNAS = {"Mes","Pagado"};
	private String [][] infoAlumno;

	public ControladorPagos(Pagos pagos) {
		bbdd= new BaseDeDatos();
		pagos.getBtnAlumno().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String dni = pagos.getTxtAlumno().getText();
				String risi = bbdd.PagosAlumnos(dni);
				JSONObject json = null;
				try {
					int contador=0;
					json = new JSONObject(risi);	
					pagos.getTextArea().setText("Nombre del alumno: "+json.get("Alumno")+"\n");
					pagos.getTextArea().setText(pagos.getTextArea().getText()+"Mes         Pagado \n");
					pagos.getTextArea().setText(pagos.getTextArea().getText()+json.get("Mes") + "       "+ json.get("Pagado")+ "\n");
					String aux = risi.substring(risi.indexOf('}')+1, risi.length());
					for (int i = 1; i <= 9; i++) {
						json = new JSONObject(aux);
						pagos.getTextArea().setText(pagos.getTextArea().getText()+json.get("Mes"));
						for (int j = json.get("Mes").toString().length(); j < 12; j++) {
							pagos.getTextArea().setText(pagos.getTextArea().getText() + " ");
						}
						pagos.getTextArea().setText(pagos.getTextArea().getText()+json.get("Pagado")+ "\n");
						if (json.get("Pagado").toString().equals("No")) {
							contador++;
						}
						aux = aux.substring(aux.indexOf('}')+1, aux.length());
					}
					pagos.getTextArea().setText(pagos.getTextArea().getText() + "El alumno debe: "+contador*90+"€");
				} catch (JSONException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				

				} 
		});
	}
}*/
