/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatosPersonales;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pabli
 */
public class ContrasenaTest 
{
    MisDatos md = new MisDatos();
    
    @Before
    public void setUp() 
    {
        md.setNombre("Pablo");
        md.setPrimerApellido("Oraa");
        md.setSegundoApellido("Lopez");
        md.setDNI("71179287");
        md.comprobarFecha("10/08/1998");
    }

    /**
     * Test of setSeguridad method, of class Contrasena.
     */
    @Test
    public void testSetSeguridadSeguraCsoloMin() 
    {
        System.out.println("setSeguridad");
        String contra = "abcddef";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIsoloMin() 
    {
        System.out.println("setSeguridad");
        String contra = "abcdef";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCsoloMas() 
    {
        System.out.println("setSeguridad");
        String contra = "AJDUWBEK";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIsoloMas() 
    {
        System.out.println("setSeguridad");
        String contra = "ABCDE";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCsoloNum() 
    {
        System.out.println("setSeguridad");
        String contra = "18374524";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIsoloNum() 
    {
        System.out.println("setSeguridad");
        String contra = "1231";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCsoloSim() 
    {
        System.out.println("setSeguridad");
        String contra = "!/·%$)·&";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIsoloSim() 
    {
        System.out.println("setSeguridad");
        String contra = "/&(!=/";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMinMas() 
    {
        System.out.println("setSeguridad");
        String contra = "abcdEFG";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMinMas() 
    {
        System.out.println("setSeguridad");
        String contra = "abcDE";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMinNum() 
    {
        System.out.println("setSeguridad");
        String contra = "as76dv8";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMinNum() 
    {
        System.out.println("setSeguridad");
        String contra = "a4d76";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMinSim() 
    {
        System.out.println("setSeguridad");
        String contra = "as%\")ke&";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMinSim() 
    {
        System.out.println("setSeguridad");
        String contra = "as(d&)";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMasNum() 
    {
        System.out.println("setSeguridad");
        String contra = "ABWUE715";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMasNum() 
    {
        System.out.println("setSeguridad");
        String contra = "AKW234";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMasSim() 
    {
        System.out.println("setSeguridad");
        String contra = "ABWUE/!·";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMasSim() 
    {
        System.out.println("setSeguridad");
        String contra = "AKW=/%";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCNumSim() 
    {
        System.out.println("setSeguridad");
        String contra = "7·1\"5&/";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraINumSim() 
    {
        System.out.println("setSeguridad");
        String contra = "2·$3%4";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMinMasNum() 
    {
        System.out.println("setSeguridad");
        String contra = "abcdEF34";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMinMasNum() 
    {
        System.out.println("setSeguridad");
        String contra = "aB3c";
        Contrasena instance = new Contrasena(1);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMasNumSim() 
    {
        System.out.println("setSeguridad");
        String contra = "AK45&\"7$";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMasNumSim() 
    {
        System.out.println("setSeguridad");
        String contra = "AK45&\"";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMinNumSim() 
    {
        System.out.println("setSeguridad");
        String contra = "ak45&\"7$";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMinNumSim() 
    {
        System.out.println("setSeguridad");
        String contra = "a4&7$";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraCMinMasSim() 
    {
        System.out.println("setSeguridad");
        String contra = "asB&Td$";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadSeguraIMinMasSim() 
    {
        System.out.println("setSeguridad");
        String contra = "a&B$";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    //Muy Segura
    @Test
    public void testSetSeguridadMuySeguraCMinMasNumSim() 
    {
        System.out.println("setSeguridad");
        String contra = "aK45&\"e";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getSeguridad().equals("Muy Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testSetSeguridadMuySeguraIMinMasNumSim() 
    {
        System.out.println("setSeguridad");
        String contra = "aK4&";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getSeguridad().equals("Muy Segura");
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test //Color Rojo Correcto
    public void testSetColorRojo()
    {
        System.out.println("setColor");
        String contra = "abcd2";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getColor().equals("\033[31m");
        assertEquals(expResult,result);
    }
    
    @Test //Color Rojo Incorrecto
    public void testSetIColorRojo()
    {
        System.out.println("setColor");
        String contra = "abcd2(S9";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getColor().equals("\033[31m");
        assertEquals(expResult,result);
    }
    
    @Test //Color Amarillo C
    public void testSetColorAmarillo()
    {
        System.out.println("setColor");
        String contra = "abcd25%2";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getColor().equals("\033[33m");
        assertEquals(expResult,result);
    }
    
    @Test //Color Amarillo I
    public void testSetIColorAmarillo()
    {
        System.out.println("setColor");
        String contra = "abcd2(S9";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getColor().equals("\033[33m");
        assertEquals(expResult,result);
    }
    
    @Test //Color Verde C
    public void testSetColorVerde()
    {
        System.out.println("setColor");
        String contra = "abcd2(S9";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = true;
        boolean result = instance.getColor().equals("\033[32m");
        assertEquals(expResult,result);
    }
    
    @Test //Color Verde I
    public void testSetIColorVerde()
    {
        System.out.println("setColor");
        String contra = "abcd2(9";
        Contrasena instance = new Contrasena(0);
        instance.setSeguridad(contra);
        boolean expResult = false;
        boolean result = instance.getColor().equals("\033[32m");
        assertEquals(expResult,result);
    }
    
    
    
    
    
    
    
    /**
     * Test of metodoMecanico method, of class Contrasena.
     */
   /* @Test
    public void testMetodoMecanico() {
        System.out.println("metodoMecanico");
        int numeroCaracteres = 0;
        Contrasena instance = null;
        String expResult = "";
        String result = instance.metodoMecanico(numeroCaracteres);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of metodoLogaritmico method, of class Contrasena.
     */
    /*@Test
    public void testMetodoLogaritmico() {
        System.out.println("metodoLogaritmico");
        int numeroCaracteres = 0;
        Contrasena instance = null;
        String expResult = "";
        String result = instance.metodoLogaritmico(numeroCaracteres);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of tercerMetodo method, of class Contrasena.
     */
   /* @Test
    public void testTercerMetodo() {
        System.out.println("tercerMetodo");
        MisDatos usuario = null;
        int numeroCaracteres = 0;
        Contrasena instance = null;
        String expResult = "";
        String result = instance.tercerMetodo(usuario, numeroCaracteres);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/    
}
