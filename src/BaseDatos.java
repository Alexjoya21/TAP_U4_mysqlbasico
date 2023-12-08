/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alejo
 */
public class BaseDatos {
    Connection conexion;
    Statement transaccion;
    ResultSet cursor;
    String cadenaConexion="jdbc:mysql://buh1mfiritjwanx0sa7t-mysql.services.clever-cloud.com:3306/buh1mfiritjwanx0sa7t?zeroDateTimeBehavior=CONVERT_TO_NULL",
            usuario="um6qu4elkzqqxvfc",
            pass="lM8eEXhu6FeRSbqxE9eS";
    
    public BaseDatos(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion=DriverManager.getConnection(cadenaConexion, usuario, pass);
        transaccion=conexion.createStatement();
        
        }catch(SQLException e){
        
        }catch(ClassNotFoundException ex){
        
        }
    }
    public boolean insertar(Persona p){
        String SQL_Insertar="INSERT INTO `Persona` (`ID`, `NOMBRE`, `DOMICILIO`, `TELEFONO`) VALUES (NULL, '%NOM%', '%DOM%', '%TEL%');";
        SQL_Insertar = SQL_Insertar.replace("%NOM%", p.nombre);
        SQL_Insertar = SQL_Insertar.replace("%DOM%", p.domicilio);
        SQL_Insertar = SQL_Insertar.replace("%TEL%", p.telefono);
        
        try{
            transaccion.execute(SQL_Insertar);
        }catch(SQLException e){
        return false;
        }
        return true;
    }
    public ArrayList<Persona> mostrarTodos(){
        ArrayList<Persona> datos = new ArrayList<Persona>();
        String SQL_consulta = "SELECT * FROM `Persona` ";
        //RESULSET = variable que maneja las tuplas resultado
        
        try{
            cursor=transaccion.executeQuery(SQL_consulta);
            if(cursor.next()){
                do{
                    
                    Persona p=new Persona(cursor.getInt(1),
                                            cursor.getString(2),
                                            cursor.getString(3),
                                            cursor.getString(4));
                    datos.add(p);
                }while(cursor.next());
            }
        }catch(SQLException e){
        
        }
        
        return datos;
    }
    public Persona obtnerporID(String ID){
        String SQL_consulta = "SELECT * FROM `Persona` WHERE `ID`="+ID;
        //RESULSET = variable que maneja las tuplas resultado
        
        try{
            cursor=transaccion.executeQuery(SQL_consulta);
            Persona p=new Persona(cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));
            return p;
        }catch(SQLException e){
        
        }
        
        return new Persona(-1,"","","");
    }
    
    public boolean Eliminar(String IDaEliminar){
        String SQL_eliminar ="DELETE FROM `Persona` WHERE `ID` ="+IDaEliminar;
        
        try {
            transaccion.execute(SQL_eliminar);
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public boolean actualizar(Persona p){
        String SQL_actualizar="UPDATE `Persona` SET `NOMBRE`='%NOM%',`DOMICILIO`='%DOM%',`TELEFONO`='%TEL%' WHERE `ID`="+p.id;
        
        
        SQL_actualizar = SQL_actualizar.replace("%NOM%", p.nombre);
        SQL_actualizar = SQL_actualizar.replace("%DOM%", p.domicilio);
        SQL_actualizar = SQL_actualizar.replace("%TEL%", p.telefono);
        
        try{
            transaccion.execute(SQL_actualizar);
        }catch(SQLException e){
        return false;
        }
        return true;
    }
}
