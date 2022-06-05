package Juego;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    public static Conexion instance;
    public static Connection conectar = null;

    private Conexion(){

    }

    public static Conexion getInstance(){

        if (instance == null){
            instance = new Conexion();
        }
        return instance;
    }



    public Connection establecerConexion() {       
        
               
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprog", "root", "8904");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la base correctamente" + e.toString());
        }

        return conectar;
    }

}
