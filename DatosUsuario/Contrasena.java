package DatosPersonales;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Random;

/**
 * Clase contrasena utilizada para generar contrase�as de forma aleatoria.
 * Para ello tenemos tres m�todos, uno mec�nico usando dados y una serie de filas, uno algor�tmico que utiliza Secure Random
 * y uno propio con una serie de reglas.
 * @author Pablo Oraa
 * @version 1.4 02/12/2018
 */
public final class Contrasena 
{
    /**
     * Variable de clase rand - Generar� numeros aleatorios para la moneda (entre 0 y 1), para obtener un s�mbolo aleatorio en el tercer m�todo
     * o para la obtenci�n de la fila y columna del primer m�todo.
     */
    Random rand = new Random();
    /**
     * Variable de clase contra - Cadena de texto donde se guardar� la cadena generada por alguno de los tres metodos posibles.
     */
    private String contra;
    /**
     * Variable de clase seguridad - Cadena de texto que indica cuan segura es la contrase�a en funci�n de May�sculas, Min�suclas, N�meros y S�mbolos.
     * Puede ser Poco Segura, Segura o Muy Segura.
     */
    private String seguridad;
    /**
     * Variable de clase color - Cadena de texto que indica el color asociado a la seguridad de la contrase�a, siendo rojo para Poco Segura, Amarillo para Segura y verde para Muy Segura.
     */
    private String color;
    /**
     * Variable de clase cadenaSimbolos - Cadena de texto con todos los s�mbolos que puede tener nuestra contrase�a, es decir !"�$%&/()=.
     */
    private final String cadenaSimbolos="!\"�$%&/()=";
    /**
     * Variable de clase primeraFila - Cadena de texto que representa la primera fila de caracteres seg�n la tabla aportada, es decir, abcdef.
     */
    private final String primeraFila="abcdef";
    /**
     * Variable de clase segundaFila - Cadena de texto que representa la segunda fila de caracteres seg�n la tabla aportada, es decir, ghijkl.
     */
    private final String segundaFila="ghijkl";
    /**
     * Variable de clase terceraFila - Cadena de texto que representa la tercera fila de caracteres seg�n la tabla aportada, es decir, mnopqr.
     */
    private final String terceraFila="mnopqr";
    /**
     * Variable de clase cuartaFila - Cadena de texto que representa la cuarta fila de caracteres seg�n la tabla aportada, es decir, stuvwx.
     */
    private final String cuartaFila="stuvwx";
    /**
     * Variable de clase quintaFila - Cadena de texto que representa la quinta fila de caracteres seg�n la tabla aportada, es decir, yz0123.
     */
    private final String quintaFila="yz0123";
    /**
     * Variable de clase sextaFila - Cadena de texto que representa la sexta fila de caracteres seg�n la tabla aportada, es decir, 456789.
     */
    private final String sextaFila="456789";
    /**
     * Variable de clase listaCompleta - Cadena de texto que representa la lista completa de caracteres permitidos seg�n la tabla aportada, es decir, de la a a la z en min�sculas y en may�sculas, los numeros y los simbolos.
     */
    private final String listaCompleta = primeraFila + segundaFila + terceraFila + cuartaFila + quintaFila + sextaFila
                        + primeraFila.toUpperCase() + segundaFila.toUpperCase() 
                        + terceraFila.toUpperCase() + cuartaFila.toUpperCase() + "YZ" + cadenaSimbolos;
    
    /**
     * Constructor de la clase contrase�a que utiliza el metodo propio para la creaci�n de la contrase�a.
     * <br>Estos podr�n ser de 4 a 8 d�gitos, que se crear�n aleatoriamente en el momento que se use el m�todo.
     * @param usuario Representa el usuario del que se va a generar la contrase�a, por si es necesario.
     */
    public Contrasena(MisDatos usuario)
    {
        setPassword(tercerMetodo(usuario,rand.nextInt(5)+4));
        setSeguridad(getPassword());
    }
    
    /**
     * Constructor de la clase contrase�a que utiliza uno de los metodos diferentes en funci�n del parametro.
     * <br>Estos podr�n ser de 4 a 8 d�gitos, que se crear�n aleatoriamente en el momento que se use el metodo.
     * @param metodo Representa cada uno de los m�todos de generacion aleatoria de contrase�as. 
     * 1 para el Metodo Mec�nico, 2 para el Metodo Logarar�tmico.
     */
    public Contrasena(int metodo)
    {
        switch (metodo) 
        {
            case 1:
                setPassword(metodoMecanico(rand.nextInt(5)+4));
                setSeguridad(getPassword());
                break;
            default:
                setPassword(metodoLogaritmico(rand.nextInt(5)+4));
                setSeguridad(getPassword());
                break;
        }
    }
    
    /**
     * setPassword guarda la contrase�a que se le pasa por parametro y la guarda en la variable contra.
     * @param cadena que ha generado el metodo aleatorio.
     */
    public void setPassword(String cadena)
    {
        contra = cadena;
    }
    
    /**
     * setSeguridad obtiene la seguridad asociada a la contrase�a generada por uno de los metodos, y le asigna el color una vez sabemos la seguridad.
     * <br>Si la contrase�a tiene entre 4 y 6 car�cteres, la contrase�a ser� Poco Segura.
     * <br>Si la contrase�a tiene m�s de 6 car�cteres pero no tiene s�mbolos, letras may�sculas, letras min�sculas o n�meros, ser� Segura.
     * <br>Si la contrase�a tiene m�s de 6 car�cteres y tiene s�mbolos, letras may�sculas, letras min�sculas y n�meros, ser� Muy Segura.
     * @param contra se ha generado con alguno de los metodos.
     */
    public void setSeguridad(String contra)
    {
        if(contra.length() < 7)
            seguridad = "Poco Segura";
        else
            if(comprobarSimbolo(contra) && comprobarLetraMayuscula(contra) 
                    && comprobarLetraMinuscula(contra) && comprobarNumero(contra))
                seguridad = "Muy Segura";
            else
                seguridad = "Segura";
        setColor();
    }
    
    /**
     * setColor guarda el color que se le asigna a la seguridad que tiene la contrase�a.
     * <br>Si la contrase�a es Poco Segura, tendr� el color rojo.
     * <br>Si la contrase�a es Segura, tendr� el color amarillo.
     * <br>Si la contrase�a es Muy Segura, tendr� el color verde.
     */
    private void setColor()
    {
        switch (seguridad) {
            case "Poco Segura":
                color = "\033[31m";
                break;
            case "Segura":
                color = "\033[33m";
                break;
            default:
                color = "\033[32m";
                break;
        }
    }
    
    /**
     * El metodo comprobarSimbolo sirve para ver la contrase�a creada dispone de un s�mbolo en ella.
     * <br>Para ello, recorre la contrase�a creada y compara con cada uno de los simbolos que est�n permitidos.
     * @param contra Contrase�a creada por uno de los metodos y en la que se va a comprobar si hay un simbolo.
     * @return true si hay un simbolo, o false si no lo hay.
     */
    private boolean comprobarSimbolo(String contra)
    {
        boolean simbolo = false;
        for (int i = 0; i < contra.length() && !simbolo; i++) 
            for (int j = 0; j < cadenaSimbolos.length() && !simbolo; j++) 
                if(contra.charAt(i) == cadenaSimbolos.charAt(j))
                    return true;
        return false;
    }
    
    /**
     * El metodo comprobarLetraMayuscula sirve para ver la contrase�a creada dispone de una letra mayuscula en ella.
     * <br>Para ello, recorre la contrase�a creada y comprueba si hay una letra may�scula en la cadena.
     * @param contra Contrase�a creada por uno de los metodos y en la que se va a comprobar si hay una letra may�scula.
     * @return true si hay una letra may�scula, o false si no lo hay.
     */
    private boolean comprobarLetraMayuscula(String contra)
    {
        for (int i = 0; i < contra.length(); i++) 
            if(Character.isUpperCase(contra.charAt(i)))
                return true;
        return false;
    }
    
    /**
     * El metodo comprobarLetraMinuscula sirve para ver la contrase�a creada dispone de una letra min�scula en ella.
     * <br>Para ello, recorre la contrase�a creada y comprueba si hay una letra min�scula en la cadena.
     * @param contra Contrase�a creada por uno de los metodos y en la que se va a comprobar si hay una letra min�scula.
     * @return true si hay una letra min�scula, o false si no lo hay.
     */
    private boolean comprobarLetraMinuscula(String contra)
    {
            for (int i = 0; i < contra.length(); i++) 
                if(Character.isLowerCase(contra.charAt(i)))
                    return true;
            return false;
    }
    
    /**
     * El metodo comprobarNumero sirve para ver la contrase�a creada dispone de un numero en ella.
     * <br>Para ello, recorre la contrase�a creada y compara con cada uno de los numero que est�n permitidos.
     * @param contra Contrase�a creada por uno de los metodos y en la que se va a comprobar si hay un numero.
     * @return true si hay un numero, o false si no lo hay.
     */
    private boolean comprobarNumero(String contra)
    {
        for (int i = 0; i < contra.length(); i++) 
            if(Character.isDigit(contra.charAt(i)))
                return true;
        return false;
    }
    
    /**
     * El metodo getSeguridad devuelve la seguridad de una contrase�a creada con anterioridad.
     * @return La cadena Poco Segura, Segura o Muy Segura en funci�n del valor en la variable seguridad.
     */
    public String getSeguridad()
    {
        return seguridad;
    }
    
    /** 
     * El metodo getPassword devuelve la contrase�a creada con anterioridad y guardada en la variable contra.
     * @return La contrase�a creada por uno de los metodos disponibles.
     */
    public String getPassword()
    {
        return contra;
    }
    
    /**
     * El metodo getColor devuelve el color asociado a la seguridad de una contrase�a creada con anterioridad.
     * @return El color rojo, verde y amarillo en funci�n del valor en la variable color.
     */
    public String getColor()
    {
        return color;
    }
    
    //Primer Metodo 
    /**
     * El metodo metodoMecanico genera una contrase�a aleatoria utilizando una serie de filas y columnas aleatorias elegidas aleatoriamente.
     * abcdefghijklmnopqrstuvwxyz0123456789 es cada uno de los car�cteres posibles. A mayores, se lanza una moneda, en el que si es cruz, se
     * coger� la letra min�scula o el n�mero. Por el contrario, si es cara, se coge la letra May�scula o el simbolo asociado a cada n�mero en
     * el teclado espa�ol.
     * @param numeroCaracteres N�mero de car�cteres que debe tener la contrase�a que se va a generar.
     * @return La contrase�a generada.
     */
    public String metodoMecanico(int numeroCaracteres)
    {        
        String cadenaUsar;
        String contrasena="";
        for (int i = 0; i < numeroCaracteres; i++) 
        {
            boolean caracterNumerico = false;
            boolean ladoMoneda;
            ladoMoneda = rand.nextInt(2) == 1; //True representa Cara, es decir, simbolos y mayusculas
                                               //False representa Cruz, es decir, numeros y minusculas
            
            int numero = rand.nextInt(6)+1;
            cadenaUsar = elegirCadena(numero);
            
            int numero2 = rand.nextInt(6)+1;
            if((numero == 5 && numero2 >= 3)||numero == 6)
                caracterNumerico = true;
            
            if(!ladoMoneda)
                contrasena += cadenaUsar.charAt(numero2-1);
            else
                if(caracterNumerico)
                    contrasena += simboloUsar((numero2-1));
                else
                    contrasena += cadenaUsar.toUpperCase().charAt(numero2-1);
            
        }//Fin del bucle
        return contrasena;
    }//Fin del metodo mec�nico
    
    /**
     * El metodo elegirCadena utiliza la posici�n que se le pasa por par�metro para asignar.
     * una de las cadenas que pueden contener un car�cter de la contrase�a.
     * @param posicion Posici�n obtenida ya sea por aleatoriedad o por SecureRandom que indica el n�mero de cadena a usar.
     * @return La cadena que se va a utilizar para saber el car�cter de la contrase�a.
     */
    private String elegirCadena(int posicion)
    {
        switch(posicion)
        {
            case 1:
            case '1':
                return primeraFila;
            case 2:
            case '2':
                return segundaFila;
            case 3:
            case '3':
                return terceraFila;
            case 4:
            case '4':
                return cuartaFila;
            case 5:
            case '5':
                return quintaFila;
            case 6:
            case '6':
                return sextaFila;
        }//Fin del Switch
        return "";
    }//Fin del metodo elegir fila
    
    //Segundo metodo
    /**
     * El metodo metodoLogaritmico genera una contrase�a utilizando la clase SecureRandom para generar una serie de n�meros aleatorios
     * entre 0 y 71 que indicar� la posici�n sobre la que tiene que coger el caracter de una cadena con todos los car�cteres posibles.
     * @param numeroCaracteres N�mero de car�cteres que debe tener la contrase�a que se va a generar.
     * @return La contrase�a generada.
     */
    public String metodoLogaritmico(int numeroCaracteres)
    {
        String contrasena = "";
        SecureRandom sr = new SecureRandom();
        for (int i = 0; i < numeroCaracteres; i++) 
            contrasena += listaCompleta.charAt(sr.nextInt(72));
        return contrasena;
    }

    /**
     * El metodo simboloUsar identifica el simbolo asociado al numero que se le pasa. 
     * <br>El simbolo asociado es aquel que podemos encontrar encima de los n�meros en el teclado espa�ol de un ordenador.
     * @param numero Indica el numero del que se quiere saber el s�mbolo correspondiente.
     * @return El s�mbolo asociado.
     */
    private char simboloUsar(int numero)
    {
        char Simbolo=' ';
        switch(numero)
        {
            case 1:
            case '1':
                Simbolo = '!';
                break;
            case 2:
            case '2':
                Simbolo = '"';
                break;
            case 3:
            case '3':
                Simbolo = '�';
                break;
            case 4:
            case '4':
                Simbolo = '$';
                break;
            case 5:
            case '5':
                Simbolo = '%';
                break;
            case 6:
            case '6':
                Simbolo = '&';
                break;
            case 7:
            case '7':
                Simbolo = '/';
                break;
            case 8:
            case '8':
                Simbolo = '(';
                break;
            case 9:
            case '9':
                Simbolo = ')';
                break;
            case 0:
            case '0':
                Simbolo = '=';
                break;   
        }//Fin del Switch
        return Simbolo;
    }//Fin de la clase
    
    //Tercer metodo
    /**
     * El metodo tercerMetodo genera la contrase�a utilizando la idea aportada en el enunciado de la pr�ctica, en funci�n del numero de caracteres.
     * <br>1.  Primera letra del nombre en may�sculas. 
     * <br>2. �ltima letra del primer apellido en min�sculas. 
     * <br>3,4.  Dos �ltimas cifras del DNI. 
     * <br>5.  Letra de d�gito de control del DNI en may�sculas. �sta se generar� autom�ticamente a partir del n� de DNI usando el algoritmo m�dulo 23. 
     * <br>6,7.  Dos �ltimas cifras del a�o de nacimiento. 
     * <br>8.  S�mbolo aleatorio de entre los que aparecen en un teclado est�andar encima de los n�meros (0-9). 
     * @param usuario Usuario que se ha creado y del que tenemos los datos de Nombre, Primer Apellido, Segundo Apellido, Fecha de Nacimiento y numero de DNI.
     * @param numeroCaracteres Longitud que va a tener la contrase�a generada.
     * @return Cadena con la contrase�a generada utilizando las reglas anteriores.
     */
    public String tercerMetodo(MisDatos usuario, int numeroCaracteres)
    {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT); 
        
        String contrasena = "";
        contrasena+=usuario.getNombre().toUpperCase().charAt(0) + "" 
                + usuario.getPrimerApellido().toLowerCase().charAt(usuario.getPrimerApellido().length()-1)
                + "" + usuario.getDNI().charAt(6) + "" + usuario.getDNI().charAt(7);
        if(numeroCaracteres == 5)
        {   
            contrasena += usuario.getDNI().charAt(8);
            if(numeroCaracteres == 6)
            {
                contrasena +=df.format(usuario.getFechaNacimiento()).charAt(df.format(usuario.getFechaNacimiento()).length()-2);
                if(numeroCaracteres == 7)
                {
                    contrasena += df.format(usuario.getFechaNacimiento()).charAt(df.format(usuario.getFechaNacimiento()).length()-1);
                    if(numeroCaracteres == 8)
                        contrasena += simboloUsar(rand.nextInt(10));
                }//Fin del if de 7
            }//Fin del if de 6
        }//Fin del if de 5
        return contrasena;
    }//Fin del tercer metodo
    
    /*
    * (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString()
    {
        return "Contra = " + contra + "\nSeguridad = " + seguridad 
                + "\nColor = " + color;
    }
}// Fin de la clase
