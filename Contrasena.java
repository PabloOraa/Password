package DatosPersonales;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Random;

/**
 * Clase contrasena utilizada para generar contraseñas de forma aleatoria.
 * Para ello tenemos tres métodos, uno mecánico usando dados y una serie de filas, uno algorítmico que utiliza Secure Random
 * y uno propio con una serie de reglas.
 * @author Pablo Oraa
 */
public final class Contrasena 
{
    /**
     * Variable de clase rand - Generará numeros aleatorios para la moneda (entre 0 y 1), para obtener un simbolo aleatorio en el tercer metodo
     * o para la obtención de la fila y columna del primer metodo.
     */
    Random rand = new Random();
    /**
     * Variable de clase contra - Cadena de texto donde se guardará la cadena generada por alguno de los tres metodos posibles.
     */
    private String contra;
    /**
     * Variable de clase seguridad - Cadena de texto que indica cuan segura es la contraseña en función de Mayúsculas, Minúsuclas, Números y Simbolos.
     * Puede ser Poco Segura, Segura o Muy Segura.
     */
    private String seguridad;
    /**
     * Variable de clase color - Cadena de texto que indica el color asociado a la seguridad de la contraseña, siendo rojo para Poco Segura, Amarillo para Segura y verde para Muy Segura.
     */
    private String color;
    /**
     * Variable de clase cadenaSimbolos - Cadena de texto con todos los símnolos que puede tener nuestra contraseña, es decir !"·$%&/()=.
     */
    private final String cadenaSimbolos="!\"·$%&/()=";
    /**
     * Variable de clase primeraFila - Cadena de texto que representa la primera fila de caracteres según la tabla aportada, es decir, abcdef.
     */
    private final String primeraFila="abcdef";
    /**
     * Variable de clase segundaFila - Cadena de texto que representa la segunda fila de caracteres según la tabla aportada, es decir, ghijkl.
     */
    private final String segundaFila="ghijkl";
    /**
     * Variable de clase terceraFila - Cadena de texto que representa la tercera fila de caracteres según la tabla aportada, es decir, mnopqr.
     */
    private final String terceraFila="mnopqr";
    /**
     * Variable de clase cuartaFila - Cadena de texto que representa la cuarta fila de caracteres según la tabla aportada, es decir, stuvwx.
     */
    private final String cuartaFila="stuvwx";
    /**
     * Variable de clase quintaFila - Cadena de texto que representa la quinta fila de caracteres según la tabla aportada, es decir, yz0123.
     */
    private final String quintaFila="yz0123";
    /**
     * Variable de clase sextaFila - Cadena de texto que representa la sexta fila de caracteres según la tabla aportada, es decir, 456789.
     */
    private final String sextaFila="456789";
    /**
     * Variable de clase listaCompleta - Cadena de texto que representa la lista completa de caracteres permitidos según la tabla aportada, es decir, de la a a la z en minusculas y en mayusculas, los numeros y los simbolos.
     */
    private final String listaCompleta = primeraFila + segundaFila + terceraFila + cuartaFila + quintaFila + sextaFila
                        + primeraFila.toUpperCase() + segundaFila.toUpperCase() 
                        + terceraFila.toUpperCase() + cuartaFila.toUpperCase() + "YZ" + cadenaSimbolos;
    
    /**
     * Constructor de la clase contraseña que utiliza el metodo propio para la creación de la ocntraseña.
     * Estos podrán ser de 4 a 8 dígitos, que se crearán aleatoriamente en el momento que se use el metodo.
     * @param usuario Representa el usuario del que se va a generar la contraseña, por si es necesario.
     */
    public Contrasena(MisDatos usuario)
    {
        setPassword(tercerMetodo(usuario,rand.nextInt(5)+4));
        setSeguridad(getPassword());
    }
    
    /**
     * Constructor de la clase contraseña que utiliza uno de los metodos diferentes en función del parametro.
     * Estos podrán ser de 4 a 8 dígitos, que se crearán aleatoriamente en el momento que se use el metodo.
     * @param metodo Representa cada uno de los´métodos de generacion aleatoria de contraseñas. 
     * 1 para el Metodo Mecánico, 2 para el Metodo Logarítmico y 3 para el Metodo propio.
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
     * setContraseña guarda la contraseña que se le pasa por parametro y la guarda en la variable contra.
     * @param cadena que ha generado el metodo aleatorio.
     */
    public void setPassword(String cadena)
    {
        contra = cadena;
    }
    
    /**
     * setContraseña guarda la contraseña que se le pasa por parametro y la guarda para que esté con todos los datos del usuario.
     * Si la contraseña tiene entre 4 y 6 carácteres, la contraseña será Poco Segura.
     * Si la contraseña tiene más de 6 carácteres pero no tiene símbolos, letras mayúsculas, letras minúsculas o números, será Segura.
     * Si la contraseña tiene más de 6 carácteres y tiene símbolos, letras mayúsculas, letras minúsculas y números, será Muy Segura.
     * @param contra se ha generado con alguno de los metodos.
     */
    public void setSeguridad(String contra)
    {
        if(contra.length() < 7)
            seguridad = "Poco Segura";
        else
        {
            boolean simbolo = comprobarSimbolo(contra);
            boolean letraMayus = comprobarLetraMayuscula(contra);
            boolean letraMinus = comprobarLetraMinuscula(contra);
            boolean numero = comprobarNumero(contra);
            if(simbolo && letraMayus && letraMinus && numero)
                seguridad = "Muy Segura";
            else
                seguridad = "Segura";
        }
        setColor();
    }
    
    /**
     * setColor guarda el color que se le asigna a la seguridad que tiene la contraseña.
     * Si la contraseña es Poco Segura, tendrá el color rojo.
     * Si la contraseña es Segura, tendrá el color amarillo.
     * Si la contraseña es Muy Segura, tendrá el color verde.
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
     * El metodo comprobarSimbolo sirve para ver la contraseña creada dispone de un simbolo en ella.
     * Para ello, recorre la contraseña creada y compara con cada uno de los simbolos que están permitidos.
     * @param contra Contraseña creada por uno de los metodos y en la que se va a comprobar si hay un simbolo.
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
     * El metodo comprobarLetraMayuscula sirve para ver la contraseña creada dispone de una letra mayuscula en ella.
     * Para ello, recorre la contraseña creada y comprueba si hay una letra mayúscula en la cadena.
     * @param contra Contraseña creada por uno de los metodos y en la que se va a comprobar si hay una letra mayuscula.
     * @return true si hay una letra mayuscula, o false si no lo hay.
     */
    private boolean comprobarLetraMayuscula(String contra)
    {
            for (int i = 0; i < contra.length(); i++) 
                if(Character.isUpperCase(contra.charAt(i)))
                    return true;
            return false;
    }
    
    /**
     * El metodo comprobarLetraMinuscula sirve para ver la contraseña creada dispone de una letra minúscula en ella.
     * Para ello, recorre la contraseña creada y comprueba si hay una letra minúscula en la cadena.
     * @param contra Contraseña creada por uno de los metodos y en la que se va a comprobar si hay una letra minúscula.
     * @return true si hay una letra minúscula, o false si no lo hay.
     */
    private boolean comprobarLetraMinuscula(String contra)
    {
            for (int i = 0; i < contra.length(); i++) 
                if(Character.isLowerCase(contra.charAt(i)))
                    return true;
            return false;
    }
    
    /**
     * El metodo comprobarNumero sirve para ver la contraseña creada dispone de un numero en ella.
     * Para ello, recorre la contraseña creada y compara con cada uno de los numero que están permitidos.
     * @param contra Contraseña creada por uno de los metodos y en la que se va a comprobar si hay un numero.
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
     * El metodo getSeguridad devuelve la seguridad de una contraseña creada con anterioridad.
     * @return La cadena Poco Segura, Segura o Muy Segura en función del valor en la variable seguridad.
     */
    public String getSeguridad()
    {
        return seguridad;
    }
    
    /** 
     * El metodo getPassword devuelve la contraseña creada con anterioridad y guardada en la variable contra.
     * @return La contraseña creada por uno de los metodos disponibles.
     */
    public String getPassword()
    {
        return contra;
    }
    
    /**
     * El metodo getColor devuelve el color asociado a la seguridad de una contraseña creada con anterioridad.
     * @return El color rojo, verde y amarillo en función del valor en la variable color.
     */
    public String getColor()
    {
        return color;
    }
    
    //Primer Metodo 
    /**
     * El metodo metodoMecanico genera una contraseña aleatoria utilizando una serie de filas y columnas aleatorias elegidas aleatoriamente.
     * abcdefghijklmnopqrstuvwxyz0123456789 es cada uno de los carácteres posibles. A mayores, se lanza una moneda, en el que si es cruz, se
     * cogerá la letra minúscula o el número. Por el contrario, si es cara, se coge la letra Mayúscula o el simbolo asociado a cada número en
     * el teclado español.
     * @param numeroCaracteres Número de carácteres que debe tener la contraseña que se va a generar.
     * @return La contraseña generada.
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
    }//Fin del metodo mecánico
    
    /**
     * El metodo elegirCadena utiliza la posición que se le pasa por parámetro para asignar.
     * una de las cadenas que pueden contener un carácter de la contraseña.
     * @param posicion Posición obtenida ya sea por aleatoriedad o por SecureRandom que indica el número de cadena a usar.
     * @return La cadena que se va a utilizar para saber el carácter de la contraseña.
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
     * El metodo metodoLogaritmico genera una contraseña utilizando la clase SecureRandom para generar una serie de numero aleatorios
     * entre 0 y 71 que indicará la posición sobre la que tiene que coger el caracter de una cadena con todos los carácteres posibles.
     * @param numeroCaracteres Número de carácteres que debe tener la contraseña que se va a generar.
     * @return La contraseña generada.
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
     * El simbolo asociado es aquel que podemos encontrar encima de los números en el teclado español de un ordenador.
     * @param numero Indica el numero del que se quiere saber el simbolo correspondiente.
     * @return El simbolo asociado.
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
                Simbolo = '·';
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
     * El metodo tercerMetodo genera la contraseña utilizando la idea aportada en el enunciado de la práctica, en función del numero de caracteres.
     * 1.  Primera letra del nombre en mayúsculas. 
     * 2.  Última letra del primer apellido en minúsculas. 
     * 3,4.  Dos últimas cifras del DNI. 
     * 5.  Letra de dígito de control del DNI en mayúsculas. Ésta se generará automáticamente a partir del nº de DNI usando el algoritmo módulo 23. 
     * 6,7.  Dos últimas cifras del año de nacimiento. 
     * 8.  Símbolo aleatorio de entre los que aparecen en un teclado estándar encima de los números (0-9). 
     * @param usuario Usuario que se ha creado y del que tenemos los datos de Nombre, Primer Apellido, Segundo Apellido, Fecha de Nacimiento y numero de DNI.
     * @param numeroCaracteres Longitud que va a tener la contraseña generada.
     * @return Cadena con la contraseña generada utilizando las reglas anteriores.
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
}// Fin de la clase
