import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import org.eclipse.jdt.annotation.Nullable;

/**
 * @author DAM1-Irene
 *
 */
/**
 * @author DAM1-Irene
 *
 */
/**
 * @author DAM1-Irene
 *
 */
/**
 * @author DAM1-Irene
 *
 */
public class BaseDeDatos {
	private Connection conexion;
	
	public BaseDeDatos() {
		crearConexion();
	}
	
	private void crearConexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conexion=DriverManager.getConnection("jdbc:oracle:thin:@192.168.6.38:1539:xe","reto","Almi1234");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se ha podido conectar on la base de datos, pongase en contacto con el personal de sistemas");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	}	
	/**
	 * @param usuario
	 * @param password
	 * @return -1 if login was not successful , -2 if there was an exception, id_puesto if login was okay.
	 */
	public int checkLogIn (String usuario, String password) {
		int puesto;
		
		try {
			String sql = "SELECT id_puesto FROM Personal_Puesto INNER JOIN Personal ON Personal.id_personal=Personal_Puesto.id_personal WHERE dni = ? AND password = ? AND habilitado=1";
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, usuario);
			sentencia.setString(2, password);
			ResultSet rs = sentencia.executeQuery();
			if (!rs.next()) {
				return -1;//El result set esta vacio, la SELECT no ha devuelto nada por lo que el login no es correcto
			}
			puesto = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			puesto = -2;
		}
		return puesto;
	}
	
	/**
	 * @param usuario
	 * @param password
	 * @return
	 */
	public ResultSet getInfoByCredenciales(String usuario, String password) {
		String sql = "SELECT id_personal, nombre FROM Personal WHERE dni = ? AND password = ?";
		PreparedStatement sentencia;
		try {
			sentencia = prepararSentencia(sql);
			sentencia.setString(1, usuario);
			sentencia.setString(2, password);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * @param id_asignatura
	 * @return ResultSet with names, surnames and position from Alumnado
	 */
	public ResultSet getAlumnosPosicionByAsignaturaId(int id_asignatura) {
		String sql = "SELECT Alumnado.nombre, ALumnado.apellido1, Expediente.posicion FROM Alumnado INNER JOIN Expediente  ON Expediente.id_alumnado = Alumnado.id_alumnado WHERE Expediente.id_asignatura=? AND Expediente.habilitado=1 AND trimestre=1  ORDER BY  Expediente.posicion ASC ";
		PreparedStatement sentencia;
		try {
			sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_asignatura);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	/**
	 * @param id_asignatura
	 * @param trimestre 
	 * @return Return result set with names in position 1/2, grade in position 3 and id in position 4
	 */
	public ResultSet getALumnosNotasByAsignatura(int id_asignatura, int trimestre) {
		String sql = "Select Alumnado.nombre, Alumnado.apellido1, Expediente.nota,Alumnado.id_alumnado from Expediente INNER JOIN Alumnado ON Alumnado.id_alumnado = Expediente.id_alumnado WHERE id_asignatura = ? AND trimestre = ?";
		PreparedStatement sentencia;
		try {
			sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_asignatura);
			sentencia.setInt(2, trimestre);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param id_asignatura
	 * @param trimestre
	 * @return Return result set with names in position 1/2, id in position 3
	 */
	/**
	 * @param id_asignatura
	 * @param trimestre
	 * @return
	 */
	public ResultSet getAlumnosAsignatura(int id_asignatura, int trimestre) {
		String sql = "Select Alumnado.nombre, Alumnado.apellido1, Alumnado.id_alumnado from Expediente INNER JOIN Alumnado ON Alumnado.id_alumnado = Expediente.id_alumnado WHERE id_asignatura = ? AND trimestre=?";
		PreparedStatement sentencia;
		trimestre--;
		try {
			sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_asignatura);
			sentencia.setInt(2, trimestre);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			return null;			
		}
	}
	/**
	 * @param id from teacher we want to get asignaturas from
	 * @return Result Set with all the ids and names, id in result set position 1
	 */
	public ResultSet getAsignaturasById(int id) {
		String sql = "SELECT Asignatura.id_asignatura, Asignatura.nombre FROM Asignatura INNER JOIN Asignatura_Personal ON Asignatura.id_asignatura = Asignatura_Personal.id_asignatura INNER JOIN Personal ON Asignatura_Personal.id_personal = personal.id_personal WHERE Personal.id_personal = ?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//Inicializa la prepare.
	private PreparedStatement prepararSentencia(String sql) throws SQLException {
		return conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	}
	
	/**
	 * @param id_asignatura with the id desired to get info from.
	 * @return ResultSet with info or null if something went wrong.
	 */
	public ResultSet getDistribucion(int id_asignatura) {
		String sql = "SELECT nombre, apellido1, apellido2, posicion FROM Alumnado INNER JOIN Expediente ON Alumnado.id_alumnado = Expediente.id_alumnado WHERE Expediente.id_asignatura = ?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_asignatura);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * @param id_alumno
	 * @param nota
	 * @param trimestre
	 * @param id_asignatura
	 * @return true if successful.
	 */
	public boolean updateNota(int id_alumno, int nota, int trimestre, int id_asignatura) {
		String sql = "UPDATE Expediente set nota = ?  WHERE id_alumnado = ? AND trimestre = ? AND id_asignatura = ? AND habilitado=1";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setInt(1, nota);
			sentencia.setInt(2, id_alumno);
			sentencia.setInt(3, trimestre);
			sentencia.setInt(4, id_asignatura);
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param id_alumno
	 * @param nota
	 * @param trimestre
	 * @param id_asignatura
	 */
	public void insertIntoExpediente(int id_alumno,@Nullable Integer nota, int trimestre, int id_asignatura) {
		int id_expediente = maxIDFromExpediente();
		id_expediente++;
		String sql = "INSERT INTO Expediente (id_expediente,id_alumnado,id_asignatura,trimestre,nota) VALUES (?,?,?,?,?)";
		if (nota==(Integer)null) {
			sql = "INSERT INTO Expediente (id_expediente,id_alumnado,id_asignatura,trimestre) VALUES (?,?,?,?)";
		}
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_expediente);
			sentencia.setInt(2, id_alumno);
			sentencia.setInt(3, id_asignatura);
			sentencia.setInt(4, trimestre);
			if (nota!=(Integer)null) {
				sentencia.setInt(5, nota);
			}
			
			sentencia.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * @return  a valid id from Expediente
	 */
	public int maxIDFromExpediente() {
		String sql = "SELECT MAX(id_expediente) FROM Expediente";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			//sentencia.setString(1, id_name);
			//sentencia.setString(2, tableName);
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				return rs.getInt(1)+1;
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			return -1;
		}
	}
	
	
	public int maxIDFromTable(  String id_name, String tableName) {
		String sql = "SELECT MAX(id_curso) FROM Curso";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			//sentencia.setString(1, id_name);
			//sentencia.setString(2, tableName);
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				return rs.getInt(1)+1;
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			return -1;
		}
	}
	
	
	/**
	 * @param dni to search in bd
	 * @return result set with name in position 1, surname in position 2/3, dni in position 4, tlf in 5, email in 6
	 */
	public ResultSet getAlumnoByDNI(String dni) {
		String sql = "SELECT nombre,apellido1,apellido2,dni,telefono,email,id_alumnado, habilitado FROM Alumnado WHERE Alumnado.dni = ?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, dni);
			ResultSet rs =  sentencia.executeQuery();
			if (rs.next()) {
				if (Integer.parseInt(rs.getString("habilitado")) == 0) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Este alumno esta deshabilitado desea recuperar sus datos igualmente?");
					if (respuesta == JOptionPane.OK_OPTION) {
						rs.beforeFirst();
						return rs;
					}
					else {
						return null;
					}
				}
			}
			rs.beforeFirst();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param nombre
	 * @param apellido
	 * @param apellido2
	 * @param email
	 * @param telefono
	 * @param dni
	 * @param id
	 * @return true if successful.
	 */
	public boolean updateInfoAlumnado(String nombre, String apellido, String apellido2, String email, String telefono,String dni, int id) {
		String sql = "Update Alumnado set nombre = ?, apellido1 = ?, apellido2 = ?, telefono = ?, email = ?, dni = ? WHERE id_alumnado = ?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setString(3, apellido2);
			sentencia.setString(4, telefono);
			sentencia.setString(5, email);
			sentencia.setString(6, dni);
			sentencia.setInt(7, id);
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	/**
	 * @return all names to load combobox
	 */
	/*public ResultSet getAllCurso() {
		String sql = "SELECT nombre FROM Curso";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	
	/**
	 * @param id_curso
	 * @return ResultSet with all cursos from BBDD
	 */
	public ResultSet getCursos(@Nullable Integer id_curso) {
		String sql = "SELECT nombre FROM Curso";
		if (id_curso!=(Integer)null) {
			sql="SELECT nombre FROM Curso where id_curso=?";
		}
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			if(id_curso!=(Integer)null) {
				sentencia.setInt(1, id_curso);
			}
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * @return ResultSet with all Asignaturas FROM BBDD
	 */
	public ResultSet getAllAsignaturas() {
		String sql = "SELECT nombre FROM Asignatura";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * @param nombre
	 * @param apellido
	 * @param apellido2
	 * @param email
	 * @param telefono
	 * @param dni
	 * @param id
	 * @return true if insert was successful
	 */
	public boolean insertAlumno(String nombre, String apellido, String apellido2, String email, String telefono,String dni, int id) {
		String sql = "INSERT INTO Alumnado (nombre, apellido1,apellido2,email,telefono,dni,id_alumnado,habilitado) VALUES (?,?,?,?,?,?,?,1)";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setString(3, apellido2);
			sentencia.setString(4, telefono);
			sentencia.setString(5, email);
			sentencia.setString(6, dni);
			sentencia.setInt(7, id);
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param id_alumno
	 * @return set habilitado=0 returns true if successful
	 */
	public boolean updateHabilitadoAlumnado(int id_alumno) {
		String sql = "UPDATE Alumnado SET habilitado=0 WHERE id_alumnado=?";
		try {
			PreparedStatement sentencia=prepararSentencia(sql);
			sentencia.setInt(1, id_alumno);
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * @param nombreCurso
	 * @return id from the inserted Curso, returns -1 if there was an error
	 */
	public int insertCurso(String nombreCurso) {
		int id_curso = maxIDFromTable("id_curso", nombreCurso);
		String sql = "INSERT INTO Curso (id_curso, nombre) VALUES (?,?)";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_curso);
			sentencia.setString(2, nombreCurso);
			sentencia.execute();
			return id_curso;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	/**
	 * @param returns the id from the row that matches the string
	 */
	public int getIdCurso(String curso) {
		String sql = "SELECT id_curso FROM Curso WHERE nombre=?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, curso);
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * @param id_alumno
	 * @return Saca los alumnos matriculados en un curso
	 */	
	public ResultSet getAlumnosCurso(int id_curso) {
		String sql = "SELECT DISTINCT Expediente.id_alumnado from Expediente INNER JOIN Asignatura ON Asignatura.id_asignatura=Expediente.id_asignatura INNER JOIN Alumnado on Alumnado.id_alumnado=Expediente.id_alumnado where Asignatura.id_curso=? AND Alumnado.habilitado=1 AND Expediente.habilitado=1 AND expediente.trimestre=3";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_curso);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	/**
	 * @return valid id from the table Alumnado
	 */
	public int maxIDFromAlumnado() {
		String sql = "SELECT MAX(id_alumnado) FROM Alumnado";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			//sentencia.setString(1, id_name);
			//sentencia.setString(2, tableName);
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				return rs.getInt(1)+1;
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * @param nombreCurso
	 * @return ids from asignaturas asigned to a curso
	 */
	public ResultSet getIdAsignaturasFromCursoByName(String nombreCurso) {
		String sql = "SELECT Asignatura.id_asignatura FROM Asignatura INNER JOIN Curso ON Curso.id_curso=Asignatura.id_curso WHERE Curso.nombre=?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, nombreCurso);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * @param id_alumno
	 * @return ResultSet with nombre,apellido1,apellido2,dni,telefono,email,id_alumnado, habilitado From the row that matches the String.
	 */
	public ResultSet getAlumnoByID(String id_alumno) {
		String sql = "SELECT nombre,apellido1,apellido2,dni,telefono,email,id_alumnado, habilitado FROM Alumnado WHERE Alumnado.dni = ?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, id_alumno);
			ResultSet rs =  sentencia.executeQuery();
			rs.next();
			if (Integer.parseInt(rs.getString("habilitado")) == 0) {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Este alumno esta deshabilitado desea recuperar sus datos igualmente?");
				if (respuesta == JOptionPane.OK_OPTION) {
					rs.beforeFirst();
					return rs;
				}
				else {
					return null;
				}
			}
			rs.beforeFirst();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insertAsignatura(String nombreAs, int id_curso, @Nullable String nombreConv) {
		String sql;
		int es_igual=-2;
		boolean alterInsert = nombreConv == null;
		if (alterInsert) {
			sql = "INSERT INTO Asignatura (nombre, id_curso) VALUES (?,?)";
		}
		else {
			sql = "INSERT INTO Asignatura (nombre, id_curso, es_igual) VALUES (?,?,?)";
			es_igual = getEsIgualByAsignaturaNombre(nombreConv);
		}
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, nombreAs);
			sentencia.setInt(2, id_curso);
			if (!alterInsert) {
				sentencia.setInt(3, es_igual);
			}
			sentencia.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @param nombreConv
	 * @return the id from the column esIgual from the table Asignaturas
	 */
	private int getEsIgualByAsignaturaNombre(@Nullable String nombreConv) {
		String sql = "SELECT es_igual FROM Asignatura WHERE nombre = ?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, nombreConv);
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * @param id_alumno
	 * @return true if update was successful
	 */
	protected boolean deshabilitarExpedienteAnterior(int id_alumno) {
		String sql = "UPDATE Expediente SET habilitado=0  WHERE id_alumnado = ?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_alumno);
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

	/**
	 * @param contraseña
	 * @param id_personal
	 * @return changes password for the row that mathes the id received, returns true if it was successful
	 */
	public boolean updateContraseña(String contraseña, int id_personal) {
		String sql = "UPDATE Personal SET password = ? WHERE id_personal = ?";
		try {
			PreparedStatement sentencia = prepararSentencia(sql);
			sentencia.setString(1, contraseña);
			sentencia.setInt(2, id_personal);
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * @param id_alumno
	 * @param id_asignatura
	 * @return returns nota from the row thtat matches two ids, returns -1 if none was found, returns -2 if there was an error.
	 */
	public int selectNotaByIDAlumnoAndIDAsignatura(int id_alumno, int id_asignatura) {
		String sql="SELECT nota FROM Expediente WHERE id_alumnado=? AND id_asignatura=? AND trimestre=3";
		PreparedStatement sentencia;
		try {
			sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_alumno);
			sentencia.setInt(2, id_asignatura);
			ResultSet rs=sentencia.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
		}
	}
	
	/*public ResultSet getAlumnosAsignaturaCurso(int id_alumno) {
		String sql = "Select Asignatura.nombre,superado from Expediente INNER JOIN Alumnado ON Alumnado.id_alumnado = Expediente.id_alumnado WHERE id_alumnado = ? AND superado = 0 and fecha_fin IS NULL";
		PreparedStatement sentencia;
		try {
			sentencia = prepararSentencia(sql);
			sentencia.setInt(1, id_asignatura);
			return sentencia.executeQuery();
		} catch (SQLException e) {
			return null;			
		}
	}*/

	//Test para llamar a funciones almacenadas
	public String PagosAlumnos(String dni) {
		String retorno;
		String sql = "Select Alumno_Pagos(a.id_alumnado) from Alumnado a where dni=?";
		PreparedStatement sentencia;
		try {
			sentencia = prepararSentencia(sql);
			sentencia.setString(1, dni);
			ResultSet rs=sentencia.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}else {
				
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
