/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alejo
 */
public class Persona {
    int id;
    String nombre,domicilio,telefono;
    
    public Persona(int i,String n,String d,String t){
        id=i;
        nombre=n;
        domicilio=d;
        telefono=t;
    }
    
    public String[] toRenglon(){
        String[] cadena = new String[4];
        
        cadena[0]=""+id;
        cadena[1]=nombre;
        cadena[2]=domicilio;
        cadena[3]=telefono;
        return cadena;
    }
}
