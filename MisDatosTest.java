/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersonales;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Pablo Oraa
 */
public class MisDatosTest 
{
    /**
     * Test of setDNI method, of class MisDatos
     */
    @Test //DNI Correcto Sin Letra
    public void testSetDNISinLetraCorrecta()
    {
        System.out.println("setDNI");
        String DNI = "71179287";
        MisDatos instance = new MisDatos();
        instance.setDNI(DNI);
        boolean expResult = true;
        boolean result = instance.getDNI().equals("71179287Z");
        assertEquals(expResult,result);
    }
    
    @Test //DNI Incorrecto Sin Letra
    public void testSetDNISinLetraIncorrecta()
    {
        System.out.println("setDNI");
        String DNI = "71179288";
        MisDatos instance = new MisDatos();
        instance.setDNI(DNI);
        boolean expResult = false;
        boolean result = instance.getDNI().equals("71179287Z");
        assertEquals(expResult,result);
    }
    
    @Test //DNI correcto Con Letra
    public void testSetDNIConLetra()
    {
        System.out.println("setDNI");
        String DNI = "71179287Z";
        MisDatos instance = new MisDatos();
        instance.setDNI(DNI);
        boolean expResult =true;
        boolean result = instance.getDNI().equals("71179287Z");
        assertEquals(expResult,result);
    }
    
    @Test //DNI Inorrecto Con Letra
    public void testSetDNIConLetraIncorrecta()
    {
        System.out.println("setDNI");
        String DNI = "71179287Y";
        MisDatos instance = new MisDatos();
        instance.setDNI(DNI);
        boolean expResult = false;
        boolean result = instance.getDNI().equals("71179287Z");
        assertEquals(expResult,result);
    }
    
    /**
     * Test of comprobarNombre method, of class MisDatos.
     */
    @Test //Nombre correcto de más de 3 caracteres
    public void testComprobarNombreMasDeTresCaracteres()
    {
        System.out.println("comprobarNombre");
        String nombre = "Pablo";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Nombre correcto de 3 caracteres
    public void testComprobarNombreTresCaracteres()
    {
        System.out.println("comprobarNombre");
        String nombre = "Pab";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Nombre incorrecto de 2 caracteres
    public void testComprobarNombreDosCaracteres()
    {
        System.out.println("comprobarNombre");
        String nombre = "Pa";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Nombre correcto de 4 caracteres
    public void testComprobarNombreCuatroCaracteres()
    {
        System.out.println("comprobarNombre");
        String nombre = "Pabl";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Nombre incorrecto de 1 carácter
    public void testComprobarNombreUnCaracter()
    {
        System.out.println("comprobarNombre");
        String nombre = "P";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Nombre incorrecto por cadena vacia
    public void testComprobarNombreCadenaVacia()
    {
        System.out.println("comprobarNombre");
        String nombre = "";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Nombre correcto más largo
    public void testComprobarNombreCadenaMasLarga()
    {
        System.out.println("comprobarNombre");
        String nombre = "Alberto";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Nombre incorrecto más largo con letras no caracteres
    public void testComprobarNombreCadenaMasLargaCaracteresNoLetras()
    {
        System.out.println("comprobarNombre");
        String nombre = "Alberto232";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Nombre incorrecto sin letras
    public void testComprobarNombreNoLetras()
    {
        System.out.println("comprobarNombre");
        String nombre = "12831(&)´`+ç";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of comprobarPrimerApellido method, of class MisDatos.
     */
    @Test //Apellido correcto de 4 carácteres
    public void testComprobarPrimerApellidoCuatroCaracteres()
    {
        System.out.println("comprobarNombre");
        String primerApellido = "Oraa";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarPrimerApellido(primerApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido correcto de 3 caracteres
    public void testComprobarPrimerApellidoTresCaracteres()
    {
        System.out.println("comprobarNombre");
        String primerApellido = "Ora";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarPrimerApellido(primerApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido correcto de dos caracteres
    public void testComprobarPrimerApellidoDosCaracteres()
    {
        System.out.println("comprobarNombre");
        String primerApellido = "Or";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarPrimerApellido(primerApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido incorrecto de un carácter
    public void testComprobarPrimerApellidoUnCaracter()
    {
        System.out.println("comprobarNombre");
        String primerApellido = "O";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarPrimerApellido(primerApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido incorrecto nulo
    public void testComprobarPrimerApellidoCadenaVacia()
    {
        System.out.println("comprobarNombre");
        String primerApellido = "";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarNombre(primerApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido correcto más largo
    public void testComprobarPrimerApellidoCadenaLarga()
    {
        System.out.println("comprobarNombre");
        String primerApellido = "Jimenez";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarPrimerApellido(primerApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido incorrecto más largo con no letras
    public void testComprobarPrimerApellidoCadenaLargaNoTodoLetras()
    {
        System.out.println("comprobarNombre");
        String primerApellido = "Jimenez+`·";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarPrimerApellido(primerApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido incorrecto sin letras
    public void testComprobarPrimerApellidoNoLetras()
    {
        System.out.println("comprobarNombre");
        String primerApellido = "·$212´´3";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarPrimerApellido(primerApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of comprobarPrimerApellido method, of class MisDatos.
     */
    @Test //Apellido 2 Correcto de 4 caracteres
    public void testComprobarSegundoApellidoCuatroCaracteres()
    {
        System.out.println("comprobarNombre");
        String segundoApellido = "Oraa";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarSegundoApellido(segundoApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido 2 Correcto de 3 caracteres
    public void testComprobarSegundoApellidoTresCaracteres()
    {
        System.out.println("comprobarNombre");
        String segundoApellido = "Ora";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarSegundoApellido(segundoApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido 2 Correcto de 2 caracteres
    public void testComprobarSegundoApellidoDosCaracteres()
    {
        System.out.println("comprobarNombre");
        String segundoApellido = "Or";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarSegundoApellido(segundoApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido 2 Incorrecto de 1 carácter
    public void testComprobarSegundoApellidoUnCaracter()
    {
        System.out.println("comprobarNombre");
        String segundoApellido = "O";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarSegundoApellido(segundoApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido 2 Incorrecto de Cadena Vacia
    public void testComprobarSegundoApellidoCadenaVacia()
    {
        System.out.println("comprobarNombre");
        String segundoApellido = "";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarSegundoApellido(segundoApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido 2 Correcto Cadena más larga
    public void testComprobarSegundoApellidoCadenaMasLarga()
    {
        System.out.println("comprobarNombre");
        String segundoApellido = "Jimenez";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarSegundoApellido(segundoApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido 2 incorrecto más largo con no letras
    public void testComprobarSegundoApellidoCadenaLargaNoTodoLetras()
    {
        System.out.println("comprobarNombre");
        String segundoApellido = "Jimenez+`·";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarSegundoApellido(segundoApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Apellido 2 incorrecto sin letras
    public void testComprobarSegundoApellidoNoLetras()
    {
        System.out.println("comprobarNombre");
        String segundoApellido = "·$212´´3";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarSegundoApellido(segundoApellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of comprobarDNI method, of class MisDatos.
     */
    @Test //DNI Correcto con letra
    public void testComprobarDNIconLetra() 
    {
        System.out.println("comprobarDNI");
        String numeroDNI = "71179287Z";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarDNI(numeroDNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //DNI Correcto sin Letra
    public void testComprobarDNISinLetra() 
    {
        System.out.println("comprobarDNI");
        String numeroDNI = "71179287";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarDNI(numeroDNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //DNI Incorrecto con letra
    public void testComprobarDNILetraIncorrecta() 
    {
        System.out.println("comprobarDNI");
        String numeroDNI = "71179827Y";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarDNI(numeroDNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //DNI Incorrecto 9 numeros
    public void testComprobarDNI9Numeros() 
    {
        System.out.println("comprobarDNI");
        String numeroDNI = "7117982722";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarDNI(numeroDNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //DNI Incorrecto Letra en medio
    public void testComprobarDNIletraEnMedio() 
    {
        System.out.println("comprobarDNI");
        String numeroDNI = "711Z2323";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarDNI(numeroDNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //DNI Incorrecto menos de 8 caracteres con letra en medio
    public void testComprobarDNImenos8CaracteresLetra() {
        System.out.println("comprobarDNI");
        String numeroDNI = "1234a";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarDNI(numeroDNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //DNI Incorrecto menos de 8 caracteres
    public void testComprobarDNImenos8Caracteres() 
    {
        System.out.println("comprobarDNI");
        String numeroDNI = "1234";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarDNI(numeroDNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of comprobarFecha method, of class MisDatos.
     */
    @Test //Fecha Correcta
    public void testComprobarFechaCorrecta() 
    {
        System.out.println("comprobarFecha");
        String fecha = "10/08/1998";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarFecha(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Fecha Incorrecta sin barra
    public void testComprobarFechaSinBarra() 
    {
        System.out.println("comprobarFecha");
        String fecha = "10081998";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarFecha(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Fecha Correcta
    public void testComprobarFechaCorrecta2() 
    {
        System.out.println("comprobarFecha");
        String fecha = "10/12/2017";
        MisDatos instance = new MisDatos();
        boolean expResult = true;
        boolean result = instance.comprobarFecha(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Fecha Incorrecta No Existe
    public void testComprobarFechaNoExiste() 
    {
        System.out.println("comprobarFecha");
        String fecha = "32/47/1998";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarFecha(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Fecha Incorrecta hoy
    public void testComprobarFechaHoy() 
    {
        System.out.println("comprobarFecha");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoy = new Date();
        String fecha = sdf.format(hoy);
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarFecha(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Fecha Incorrecta mañana
    public void testComprobarFechaMañana() 
    {
        System.out.println("comprobarFecha");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoy = new Date();
        hoy.setTime(hoy.getTime()+86400);
        String fecha = sdf.format(hoy);
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarFecha(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Fecha Incorrecta Posterior a hoy
    public void testComprobarFechaAñosPosteriores() 
    {
        System.out.println("comprobarFecha");
        String fecha = "31/12/2024";
        MisDatos instance = new MisDatos();
        boolean expResult = false;
        boolean result = instance.comprobarFecha(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}
