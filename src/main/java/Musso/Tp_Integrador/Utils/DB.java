package Musso.Tp_Integrador.Utils;

import java.io.*;
import java.sql.*;

public class DB {
	
	private static final String url ="jdbc:hsqldb:mem:.";
	private static final String user="root";
	private static final String pass="root";
	
	private static Connection crearConexion(){
		Connection conn=null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			conn= DriverManager.getConnection(url,user,pass);
			System.out.println("Connected.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getConexion() {
		crearTablas();
		return crearConexion();
	}
	
	public static void crearTablas() {
		Connection conn = DB.crearConexion();
		Statement st = null;
		
		try {
			String ConstructorTablas="";
			BufferedReader rd = new BufferedReader (new FileReader ("creacion.txt"));
			String inputLine = null;
			while((inputLine = rd.readLine()) != null){
				ConstructorTablas+=inputLine;
			}
			
			st = conn.createStatement();			
			st.execute(ConstructorTablas); // levantar de archivo
			
//			PreparedStatement pst = conn.prepareStatement(inputLine);
//			pst = conn.prepareStatement(("INSERT INTO AGENDA (NOMBRE,ID_DUENIO) VALUES (?, ?)")
//			pst.setString(1, "abc");
//			pst.setInt(1, 2);
//			int cantidad = st.executeUpdate(inputLine);
			
//			execute -> any type
//			executeQuery -> para SELECT
//			executeUpdate -> para INSERT/UPDATE/DELETE
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
