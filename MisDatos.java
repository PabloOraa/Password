package DatosPersonales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase Mis Datos será utilizada para guardar el nombre, apellidos, dni, fecha de nacimiento
 * y datos de usuario que vamos a tener de un usuario.
 * @author Pablo Oraa
 */
public class MisDatos 
{
    /**
     * Variable de clase nombre - Cadena de texto que representa el nombre de un usuario.
     */
    private String nombre;
    /**
     * Variable de clase primerApellido - Cadena de texto que representa el primero apellido de un usuario.
     */
    private String primerApellido;
    /**
     * Variable de clase segundoApellido - Cadena de texto que representa el segundo apellido de un usuario.
     */
    private String segundoApellido;
    /**
     * Variable de clase DNI - Cadena de texto que representa el DNI de un usuario.
     */
    private String DNI;
    /**
     * Variable de clase fechaNacimiento - Cadena de texto que representa la fecha de nacimiento de un usuario en formato dd/mm/aaaa.
     */
    private Date fechaNacimiento;
    /**
     * Variable de clase nombreUsuario- Cadena de texto que representa el nombre de Usuario de un usuario generado por su nombre y apellidos.
     */
    private String nombreUsuario;
    /**
     * Variable de clase contrasena - Cadena de texto que representa la contraseña de un usuario elegida entre las creadas por uno de los métodos.
     */
    private String contrasena;
    
    /**
     * Inicializa la clase MisDatos creando una cadena vacia en nombreuUsuario, y dejando el resto de variables a NULL
     */
    public MisDatos()
    {
        nombreUsuario = "";
    }

    /**
     * setNombre permite guardar en el objeto creado el nombre del usuario que estamos creando.
     * @param nombre Nombre que ha introducido el usuario y que indica el nombre que tiene. Minimo debe tener 3 caracteres.
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    /**
     * setPrimeroApellido permite guardar en el objeto creado el primero apellido del usuario que estamos creando.
     * @param Apellido que ha introducido el usuario y que indica el primero apellido que tiene. Minimo debe tener 2 caracteres.
     */
    public void setPrimerApellido(String Apellido)
    {
        this.primerApellido = Apellido;
    }
    
    /**
     * setSegundoApellido permite guardar en el objeto creado el segundo apellido del usuario que estamos creando.
     * @param Apellido que ha introducido el usuario y que indica el segundo Apellido que tiene. Minimo debe tener 2 caracteres.
     */
    public void setSegundoApellido(String Apellido)
    {
        this.segundoApellido = Apellido;
        setNombreUsuario();
    }
    
    /**
     * setDNI permite guardar en el objeto creado el DNI del usuario que estamos creando.
     * Si son 8 dígitos calculará la letra asociada, y si no directamente lo asigna
     * @param DNI que ha introducido el usuario y que indica los 8 digitos (u 8 digitos + letra) del DNI que tiene.
     */
    public void setDNI(String DNI)
    {
        if(DNI.length() == 8)
            DNI += obtenerLetraDNI(DNI);
        this.DNI = DNI;
    } 
    
    /**
     * setFechaNacimiento permite guardar en el objeto creado la fecha de nacimiento del usuario que estamos creando.
     * @param fechaNac que ha introducido el usuario y que indica el dia/mes/año de nacimiento. Está en formato dd/MM/yyyy.
     */
    public void setFechaNacimiento(Date fechaNac)
    {
        this.fechaNacimiento = fechaNac;
    }
    
    /**
     * setNombreUsuario crea el nombre de usuario asociado al usuario utilizando el nombre, primer apellido y segundo apellido.
     * Para ello, toma las dos primeras letras del segundo Apellido, a continuación coge las dos primeras del primer Apellido y por último coge las tres primeras letras del nombre. 
     */
    private void setNombreUsuario()
    {
        for (int i = 0, pos = 0; i < 7; i++) 
        {
            if(i < 2)
                this.nombreUsuario +=segundoApellido.charAt(pos);
            else if(i < 4)
                this.nombreUsuario +=primerApellido.charAt(pos);
            else
                this.nombreUsuario +=nombre.charAt(pos);
            pos++;
            if(i == 1)
                pos = 0;
            else if(i == 3)
                pos = 0;
            
        }  
    }
    
    /**
     * setContraseña guarda la contraseña que se le pasa por parametro y la guarda para que esté con todos los datos del usuario.
     * @param contrasena que el usuario ha decidido tener el usuario.
     */
    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }
    
    /**
     * El metodo getNombre coge el atributo nombre y lo devuelve al metodo que lo ha llamado.
     * @return El nombre que tiene el usuario registrado de los datos que ha introducido con anterioridad.
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * El metodo getPrimerApellido coge el atributo primerApellido y lo devuelve al metodo que lo ha llamado.
     * @return El primer apellido que tiene el usuario registrado de los datos que ha introducido con anterioridad.
     */
    public String getPrimerApellido()
    {
        return primerApellido;
    }
    
    /**
     * El metodo getSegundoApellido coge el atributo segundoApellido y lo devuelve al metodo que lo ha llamado.
     * @return El segundo apellido que tiene el usuario registrado de los datos que ha introducido con anterioridad.
     */
    public String getSegundoApellido()
    {
        return segundoApellido;
    }
    
    /**
     * El metodo getFechaNacimiento coge el atributo fechaNacimiento y lo devuelve al metodo que lo ha llamado.
     * @return La fecha de nacimiento que tiene el usuario registrada de los datos que ha introducido con anterioridad.
     */
    public Date getFechaNacimiento()
    {
        return fechaNacimiento;
    }    
    
    /**
     * El metodo getDNI coge el atributo DNI y lo devuelve al metodo que lo ha llamado.
     * @return El DNI que tiene el usuario registrado de los datos que ha introducido con anterioridad.
     */
    public String getDNI()
    {
        return DNI;
    }
    
    /**
     * El metodo getNombreUsuario coge el atributo nombreUsuario y lo devuelve al metodo que lo ha llamado.
     * @return El nombre de usuario que tiene el usuario registrado de los datos que ha introducido con anterioridad.
     */
    public String getNombreUsuario()
    {
        return nombreUsuario;
    }
    
    /**
     * El metodo getCOntrasena coge el atributo contrasena y lo devuelve al metodo que lo ha llamado.
     * @return La contraseña que tiene el usuario registrado de los datos que ha introducido con anterioridad.
     */
    public String getContrasena()
    {
        return contrasena;
    }
    
    /**
     * El metodo comprobarNombre sirve para ver si el nombre que ha introducido el usuario es valido.
     * Para ello, comprueba que no sea una cadena vacia.
     * Si no, se comprobará si tiene 3 o más carácteres, que son los mínimos que puede tener el nombre.
     * Si tiene el número de carácteres que debe tener, se comprobará que todo sean letras.
     * @param nombre Cadena de texto que representa el nombre que ha introducido el usuario.
     * @return true si es un nombre valido y false si no se trata de uno valido.
     */
    public boolean comprobarNombre(String nombre)
    {
        if(nombre.isEmpty())
        {
            System.out.println("No puede ser una cadena vacia.");
            return false;
        }
        else if(nombre.length() < 3)
        {
            System.out.println("Debe tener más de 3 carácteres");
            return false;
        }
        
        for(int i = 0; i < nombre.length(); i++)
            if(!Character.isLetter(nombre.charAt(i)))
            {
                System.out.println("Un nombre no tiene caracteres que no sean letras");
                return false;
            }
        
        return true;
    }
    
    /**
     * El metodo comprobarPrimerApellido sirve para ver si el primer apellido que ha introducido el usuario es valido.
     * Para ello, comprueba que no sea una cadena vacia.
     * Si no, se comprobará si tiene 2 o más carácteres, que son los mínimos que puede tener el primero apellido.
     * Si tiene el número de carácteres que debe tener, se comprobará que todo sean letras.
     * @param primerApellido Cadena de texto que representa el primer apellido que ha introducido el usuario.
     * @return true si es un apellido valido y false si no se trata de uno valido.
     */
    public boolean comprobarPrimerApellido(String primerApellido)
    {
        if(primerApellido.isEmpty())
        {
            System.out.println("No puede ser una cadena vacia.");
            return false;
        }
        else if(primerApellido.length() < 2)
        {
            System.out.println("Debe tener más de 2 carácteres");
            return false;
        }
        
        for(int i = 0; i < primerApellido.length(); i++)
            if(!Character.isLetter(primerApellido.charAt(i)))
                if(!Character.isLetter(nombre.charAt(i)))
                {
                    System.out.println("Un nombre no tiene caracteres que no sean letras");
                    return false;
                }
        
        return true;
    }

    /**
     * El metodo comprobarSegundoApellido sirve para ver si el segundo apellido que ha introducido el usuario es valido.
     * Para ello, comprueba que no sea una cadena vacia.
     * Si no, se comprobará si tiene 2 o más carácteres, que son los mínimos que puede tener el segundo apellido.
     * Si tiene el número de carácteres que debe tener, se comprobará que todo sean letras.
     * @param segundoApellido Cadena de texto que representa el segundo apellido que ha introducido el usuario.
     * @return true si es un apellido valido y false si no se trata de uno valido.
     */
    public boolean comprobarSegundoApellido(String segundoApellido)
    {
        if(segundoApellido.isEmpty())
        {
            System.out.println("No puede ser una cadena vacia.");
            return false;
        }
        else if(segundoApellido.length() < 2)
        {
            System.out.println("Debe tener más de 2 carácteres");
            return false;
        }
        
        for(int i = 0; i < segundoApellido.length(); i++)
            if(!Character.isLetter(nombre.charAt(i)))
            {
                System.out.println("Un nombre no tiene caracteres que no sean letras");
                return false;
            }
        
        return true;
    }
    
    /**
     * El metodo comprobarDNI sirve para ver si el numero de DNI que ha introducido el usuario es valido y es posible que se trate de un DNI.
     * Para ello, comprueba que tenga un minimo de 8 caracteres, que es la cantidad de numeros que tiene el documento de identidad español.
     * Si los tiene, pasará a comprobar si todos estos caracteres son digitos, no pudiendo tener alguna letra entre medias.
     * En caso de que tenga 9 carácteres, se comprobará que se trata de la letra asociada al numero de DNI. 
     * @param numeroDNI 8 digitos como cadena que ha tenido que introducir el usuario.
     * @return true si es un DNI valido y false si no se trata de uno valido.
     */
    public boolean comprobarDNI(String numeroDNI)
    {      
        if(numeroDNI.length() == 8)
        {
            for (int i = 0; i < 8; i++) 
                if(!Character.isDigit(numeroDNI.charAt(i)))
                {
                    System.out.println("Error. Alguno de los caracteres no es un digito\n");
                        return false;
                }
            return true;
        }
        else if(numeroDNI.length() == 9 && Character.isLetter(numeroDNI.charAt(8)))
        {
            String cadenaSinLetra = "";
            for (int i = 0; i < 8; i++) 
                cadenaSinLetra += numeroDNI.charAt(i);
            
            if(comprobarDNI(cadenaSinLetra))
                if(obtenerLetraDNI(cadenaSinLetra) == numeroDNI.charAt(8))
                    return true;
            return false;
        }
        else
            System.out.println("Error. El DNI debe tener 8 digitos\n");
        return false;
    }
    
    /**
     * El metodo obtenerLetraDNI asignará una letra al DNI asociado a un usuario utilizando el algoritmo módulo 23.
     * Para ello en función del resto del número del DNI entre 23, se le asignará la letra TRWAGMYFPDXBNJZSQVHLCKE correspondiente.
     * @param DNI Numero asociado a la variable DNI del usuario sobre el que se esté creando la contraseña.
     * @return La letra asociada a ese DNI.
     */
    private char obtenerLetraDNI(String DNI)
    {
        int resto = Integer.parseInt(DNI)%23;
        char letraDNI = ' ';
        
        switch(resto)
        {
            case 0:
                letraDNI = 'T';
                break;
            case 1:
                letraDNI = 'R';
                break;
            case 2:
                letraDNI = 'W';
                break;
            case 3:
                letraDNI = 'A';
                break;
            case 4:
                letraDNI = 'G';
                break;
            case 5:
                letraDNI = 'M';
                break;
            case 6:
                letraDNI = 'Y';
                break;
            case 7:
                letraDNI = 'F';
                break;
            case 8:
                letraDNI = 'P';
                break;
            case 9:
                letraDNI = 'D';
                break;
            case 10:
                letraDNI = 'X';
                break;
            case 11:
                letraDNI = 'B';
                break;
            case 12:
                letraDNI = 'N';
                break;
            case 13:
                letraDNI = 'J';
                break;
            case 14:
                letraDNI = 'Z';
                break;
            case 15:
                letraDNI = 'S';
                break;
            case 16:
                letraDNI = 'Q';
                break;
            case 17:
                letraDNI = 'V';
                break;
            case 18:
                letraDNI = 'H';
                break;
            case 19:
                letraDNI = 'L';
                break;
            case 20:
                letraDNI = 'C';
                break;
            case 21:
                letraDNI = 'K';
                break;
            case 22:
                letraDNI = 'E';
                break;  
        }
        return letraDNI;
    }
    
    /**
     * El metodo comprobarFecha sirve para ver si la fecha de nacimiento que ha introducido el usuario es valida.
     * Para ello, comprueba que se trata de una cadena introducida con el formato dd/MM/yyyy.
     * En caso de que se encuentre en ese formato, comprobará que se trate de una fecha anterior a la de hoy.
     * @param fecha Cadena que representa el dd/mm/aaaa en el que ha nacido el usuario.
     * @return true si es un fecha valida y false si no se trata de una valida.
     */
    public boolean comprobarFecha(String fecha)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date fechaEnDate;
        Date hoy = new Date();
        try
        {
            fechaEnDate = sdf.parse(fecha);
            
            
            if(sdf.format(fechaEnDate).equals(sdf.format(hoy)))
            {   
                System.out.println("La fecha debe ser anterior al dia de hoy");
                return false;
            }
            else if(hoy.after(fechaEnDate))
            {
                setFechaNacimiento(fechaEnDate);
                return true;
            }
            else
            {
                System.out.println("La fecha debe ser anterior al dia de hoy");
                return false;
            }
        }catch(ParseException e)
        {
            System.out.println("La fecha no se ha introducido correctamente");
            return false;
        }
    }
}
