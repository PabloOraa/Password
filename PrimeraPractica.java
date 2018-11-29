package Practica1;

import DatosPersonales.Contrasena;
import DatosPersonales.MisDatos;
import java.util.Scanner;

/**
 * Clase PrimeraPractica en la que se va a encontrar la interfaz de la aplicación, con la petición de los datos para generar al usuario.
 * @author Pablo Oraa
 * @version 1.3 28/11/2018
 */
public class PrimeraPractica 
{
    public static void main(String[] args) 
    {
        MisDatos Prueba = new MisDatos();
        Scanner sc = new Scanner(System.in);
        boolean correcto;
        
        //Pedimos datos al usuario
        do
        {
            correcto = false;
            System.out.print("Introduce tu nombre: ");
            Prueba.setNombre(sc.nextLine());
            if(Prueba.comprobarNombre(Prueba.getNombre()))
                correcto = true;
        }while(!correcto);
        
        do
        {
            correcto = false;
            System.out.print("Introduce tu primer apellido: ");
            Prueba.setPrimerApellido(sc.nextLine());
            if(Prueba.comprobarPrimerApellido(Prueba.getPrimerApellido()))
                correcto = true;
        }while(!correcto);
        
        do
        {
            correcto = false;
            System.out.print("Introduce tu segundo apellido "
                    + "(Si no tienes, introduce el primero de nuevo): ");
            Prueba.setSegundoApellido(sc.nextLine());
            if(Prueba.comprobarSegundoApellido(Prueba.getSegundoApellido()))
                correcto = true;
        }while(!correcto);
        
        do
        {
            correcto = false;
            System.out.print("Introduce tu DNI: ");
            String DNI = sc.next();
            if(Prueba.comprobarDNI(DNI))
            {
                Prueba.setDNI(DNI);
                correcto = true;
            }
        }while(!correcto);
        
        do
        {
            correcto = false;
            System.out.print("Introduce tu fecha de nacimieto en formato dd/mm/aaaa: ");
            String fechaNac = sc.next();
            if(Prueba.comprobarFecha(fechaNac))
                correcto = true;
        }while(!correcto);
        
        //Creamos las contraseñas con cada uno de los métodos
        Contrasena contr = new Contrasena(1);
        Contrasena contr2 = new Contrasena(2);
        Contrasena contr3 = new Contrasena(Prueba);
        
        //Le mostramos las contraseñas al usuario
        System.out.println("La primera contrasena es " + contr.getPassword() 
                            + " que es " + contr.getColor() + contr.getSeguridad());
        System.out.print("\033[30m");
        System.out.println("La segunda contrasena es " + contr2.getPassword() 
                            + " que es " + contr2.getColor() + contr2.getSeguridad());
        System.out.print("\033[30m");
        System.out.println("La tercera contrasena es " + contr3.getPassword() 
                            + " que es " + contr3.getColor() + contr3.getSeguridad());
        System.out.print("\033[30m");
        
        //El usuario elige una de las contraseñas, que será la que se le asigne a su usuario.
        System.out.print("Elige una de las tres contrasenas: ");
        switch(Integer.parseInt(sc.next()))
        {
            case 1:
                Prueba.setContrasena(contr.getPassword());
                break;
            case 2:
                Prueba.setContrasena(contr2.getPassword());
                break;
            case 3:
                Prueba.setContrasena(contr3.getPassword());
                break;
        }
        System.out.println("Gracias. Tu nombre de usuario es: " + Prueba.getNombreUsuario()
         + " y tu contrasenia es: " + Prueba.getContrasena());
    }
}
