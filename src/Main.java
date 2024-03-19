import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {// clase

//    @Override
//    public boolean equals(Object obj) { // metodo
//        return super.equals(obj);
//    }

    public static void main(String[] args) { // funcion

        // variables de entrada
        Scanner leer = new Scanner(System.in);
        int cantidad_asistentes, duracion, edad=17, menor25=0, edad26_35=0, mayor35=0;
        String RUT, nombre="", direccion="", comuna="", telefono, fecha, hora, lugar="", nombre_asistente="";
        String patron_telefono = "\\d{3}\\d{3}\\d{4}"; // valido
        //String patron_RUT = "\\b[0-9|.]{1,10}\\-[K|k|0-9]"; // no funciona
        //String patron_RUT = "[0-9]{1,2}.[0-9]{3}.[0-9]{3}-[0-9Kk]{1}$"; // valido con puntos
        String patron_RUT = "^(\\d{1,2}(?:[\\.]?\\d{3}){2}-[\\dkK])$"; // valido con puntos
        //""^(\d{1,2}(?:[\.]?\d{3}){2}-[\dkK])$""
        String patron_fecha = "^\\d{2}-\\d{2}-\\d{4}$";
        String patron_hora = "^\\d{2}:\\d{2}$";


        List<Integer> listaEdad = new ArrayList<>();
        List<String> listaNombre = new ArrayList<>();

              // proceso

// validar datos del cliente
        // validar RUT cliente
        do {
            System.out.println("Ingrese RUT (con digito verificador) de cliente ");
            RUT = leer.nextLine();// 12.345.678-9
            if (!RUT.matches(patron_RUT)) {
                System.out.println("RUT no valido");
            }
        } while (!RUT.matches(patron_RUT));

        // validar nombre cliente
        while (nombre.isEmpty()) {
            System.out.println("Ingrese nombre de cliente ");
            nombre = leer.nextLine();
            if (nombre.isEmpty()) {
                System.out.println("debe ingresar el nombre");
            }
        }// while (!" ".equals(lee.nextLine()))

        // validar direccion cliente
        while (direccion.isEmpty()) {
            System.out.println("Ingrese direccion de cliente ");
            direccion = leer.nextLine();
            if (direccion.isEmpty()) {
                System.out.println("debe ingresar el direccion");
            }
        }

        // validar comuna cliente
        while (comuna.isEmpty()) {
            System.out.println("Ingrese comuna de cliente ");
            comuna = leer.nextLine();
            if (comuna.isEmpty()) {
                System.out.println("debe ingresar el comuna");
            }
        }

        // validar teléfono cliente
        do {
            System.out.println("Ingrese numero de telefono (con 10 digitos) de cliente ");
            telefono = leer.nextLine();// 1234567890
            if (!telefono.matches(patron_telefono)) {
                System.out.println("telefono no valido");
            }
        } while (!telefono.matches(patron_telefono));

        // validar fecha capacitacion
        do {
            System.out.println("Ingrese fecha de la capacitacion dd-mm-yyyy");
            fecha = leer.nextLine();// 1234567890
            if (!fecha.matches(patron_fecha)) {
                System.out.println("fecha no valido");
            }
        } while (!fecha.matches(patron_fecha));

        // validar hora capacitacion
        do {
            System.out.println("Ingrese hora de la capacitacion hh:mm");
            hora = leer.nextLine();// 1234567890
            if (!hora.matches(patron_hora)) {
                System.out.println("hora no valido");
            }
        } while (!hora.matches(patron_hora));
        
        // validar lugar de la capacitacion
        while (lugar.isEmpty()) {
            System.out.println("Ingrese lugar de la capacitacion ");
            lugar = leer.nextLine();
            if (lugar.isEmpty()) {
                System.out.println("debe ingresar el lugar");
            }
        }

        // validar duracion de la capacitacion
        do {
            System.out.println("Ingrese duracion de la capacitacion en minutos");
            duracion = leer.nextInt();
            if (duracion<=0) {
                System.out.println("la duracion de la capacitación debe ser mayor a 0");
            }
        } while (duracion <= 0);
        leer.nextLine();

        // validar cantidad de asistentes
        do {
            System.out.println("Ingrese cantidad de asistentes");
            cantidad_asistentes = leer.nextInt();
            if (cantidad_asistentes <= 0) {
                System.out.println("la cantidad de asistentes debe ser mayor a 0");
            }
        } while (cantidad_asistentes <= 0);
        

// datos de los asistentes
        for (int i = 0; i < cantidad_asistentes; i++) {
            //leer.nextLine();
            // validar nombre asistente
            while (nombre_asistente.isEmpty()) {
                System.out.println("Ingrese nombre de asistente " + (i + 1));
                nombre_asistente = leer.nextLine();
                if (nombre_asistente.isEmpty()) {
                    System.out.println("debe ingresar el nombre");
                }
            }
// edad
            // validar edad asistente
            do {
                System.out.println("Ingrese edad de asistente " + (i + 1));
                edad = leer.nextInt();
                
                if (edad <= 17) {
                    System.out.println("debe ser mayor de edad");
                }
            } while (edad <= 17);
            listaEdad.add(edad);
            listaNombre.add(nombre_asistente);
            nombre_asistente = "";

        }
        
        // salida, mostrar datos de la capacitacion y asistentes menores a 25, mayores a 35 y los de 26 a 35 años
        System.out.println("**************************");
        System.out.println("Datos para la capacitacion");
        System.out.println("Empresa: " + nombre);
        System.out.println("RUT: " + RUT);
        System.out.println("Direccion: " + direccion);
        System.out.println("Comuna: " + comuna);
        System.out.println("Telefono: " + telefono);
        System.out.println("Fecha de la capacitacion: " + fecha);
        System.out.println("Hora de la capacitacion: " + hora);
        System.out.println("Lugar de la capacitacion: " + lugar);
        System.out.println("Duracion de la capacitacion: " + duracion);
        System.out.println("Cantidad de asistentes: " + cantidad_asistentes);

        // forEach
        for (int edad_personas : listaEdad) {
            if (edad_personas < 25) {
                menor25++;
            } else if (edad_personas > 35) {
                mayor35++;
            } else {
                edad26_35++;
            }
        }
        System.out.println("Personas menores de 25: " + menor25);//menor
        System.out.println("Personas entre 26 y 35: " + edad26_35);//entre 26 y 35
        System.out.println("Personas mayores de 35: " + mayor35);// mayor

        leer.close(); // cerrar Scanner

    } // cierre de la funcion main
} // cierre de la clase Main



// 18 22 24
// 26 35 33
// 36 55 44