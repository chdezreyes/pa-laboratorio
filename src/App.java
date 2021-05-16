import java.util.ArrayList;
import javax.swing.JFrame;

public class App {
    
    public static ArrayList<Incidencia> incidencias;
    public static ArrayList<Tecnico> tecnicos;
    
    public static void main(String[] args) throws Exception {
        
        incidencias = new ArrayList<Incidencia>(); cargaIncidencias();   
        tecnicos    = new ArrayList<Tecnico>(); cargaTecnicos();     
        VentanaPrincipal v = new VentanaPrincipal(incidencias, tecnicos);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public static void cargaIncidencias(){

        Incidencia incidencia1 = new Incidencia("Error de Impresora. Se atasca el papel en impresiones de mas de 100 hojas. Ademas hay que cambiarn el toner");
        Incidencia incidencia2 = new Incidencia("Error olvido contrasena. Comenta que lo ha intentado varias veces y el usuario debe estar bloqueado");
        Incidencia incidencia3 = new Incidencia("Virus. Ha abierto un correo con un fichero con sospecha de virus. El antivirus esta sin soporte");
        Incidencia incidencia4 = new Incidencia("Actualizacion de Windows. Hay que actualizar los drivers de la tarjeta de red.");
        Incidencia incidencia5 = new Incidencia("Error de Impresora. Se atasca el papel en impresiones de mas de 100 hojas. Ademas hay que cambiarn el toner");
        Incidencia incidencia6 = new Incidencia("Error olvido contrasena. Comenta que lo ha intentado varias veces y el usuario debe estar bloqueado");
        Incidencia incidencia7 = new Incidencia("Virus. Ha abierto un correo con un fichero con sospecha de virus. El antivirus esta sin soporte");
        Incidencia incidencia8 = new Incidencia("Actualizacion de Windows. Hay que actualizar los drivers de la tarjeta de red.");

        incidencias.add(incidencia1);  incidencias.add(incidencia2);
        incidencias.add(incidencia3);  incidencias.add(incidencia4);
        incidencias.add(incidencia5);  incidencias.add(incidencia6);
        incidencias.add(incidencia7);  incidencias.add(incidencia8);
    }

    public static void cargaTecnicos(){
        Tecnico tecnico1 = new Tecnico("Carlos","N1");
        Tecnico tecnico2 = new Tecnico("Miguel","N1");
        Tecnico tecnico3 = new Tecnico("Ernesto","N2");
        Tecnico tecnico4 = new Tecnico("Ivan","N3");

        tecnicos.add(tecnico1);
        tecnicos.add(tecnico2);
        tecnicos.add(tecnico3);
        tecnicos.add(tecnico4);
        System.out.println("Lista de tecnicos "+tecnicos.size());
    }
}
