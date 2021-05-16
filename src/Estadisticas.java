import java.util.ArrayList;
import java.util.Collections;

public class Estadisticas {

    private ArrayList<Incidencia> averias;
    private ArrayList<Tecnico>    empleados;
    private int cerradas ;
    private int abiertas ;
    private int proceso ;


    public Estadisticas (ArrayList<Incidencia> averias, ArrayList<Tecnico> empleados){
       this.averias     = averias;
       this.empleados   = empleados;
    }

    public String incidenciasCerradas(){
        cerradas = 0;
        for(Incidencia i: averias){
            if(i.getEstado().equals("Terminado")){
                cerradas++;
            }
        }
        return Double.toString((double)cerradas/(double)averias.size()*100)+" %";
    }

    public String incidenciasAbiertas(){
        abiertas = 0;
        for(Incidencia i: averias){
            if(i.getEstado().equals("Pendiente")){
                abiertas++;
            }
        }
        return Double.toString((double)abiertas/(double)averias.size()*100)+" %";
    }

    public String incidenciasProceso(){
        proceso = 0; 
        for(Incidencia i: averias){
            if(i.getEstado().equals("En Proceso")){
                proceso++;
            }
        }
        return Double.toString((double)proceso/(double)averias.size()*100)+" %";
    }

    public String tiempoMedio(){
        int tiempoTotal = 0;
        int cerradas = 0;

        for(Incidencia i: averias){
            if(i.getEstado().equals("Terminado")){
                cerradas++;
                tiempoTotal = tiempoTotal + i.getTiempoRes();
            }   
        }
        if (tiempoTotal == 0){
            return "No hay incidencias terminadas";
        }else{
            return Double.toString((double) tiempoTotal / (double) cerradas)+ " horas";
        }
        
    }
    
    public String empleadoMas(){
        ArrayList<Integer> lista =  new ArrayList<>();
        int maximo, index;
        String result;

        for(Tecnico t: empleados){
            int contador = 0;
            for(Incidencia i: averias){
                if(i.getEstado().equals("Terminado") && (i.getTecnico()== t)){
                    contador++;
                }
            }
            lista.add(empleados.indexOf(t), contador);
        }
        maximo = Collections.max(lista);
        index = lista.indexOf(maximo);

        if(maximo==0){
            result = "No hay incidencias terminadas.";
        }else{
            result = "Tecnico mas resolutivo: "+ empleados.get(index).getNombre() + " - Incidencias Terminadas: " +maximo;    
        }
        return result;
    }

    public String empleadoMin(){
        ArrayList<Integer> lista =  new ArrayList<>();
        int minimo, index; 
        int total = 0;
        String result;

        for(Tecnico t: empleados){
            int contador = 0;
            for(Incidencia i: averias){
                if(i.getEstado().equals("Terminado") && (i.getTecnico()== t)){
                    contador++;
                }
                if(i.getEstado().equals("Terminado")){
                    total++;
                }
            }
            lista.add(empleados.indexOf(t), contador);
        }
        minimo = Collections.min(lista);
        index = lista.indexOf(minimo);
        
        if(total==0){
            result = "No hay incidencias terminadas.";
        }else{
            result = "Tecnico menos resolutivo: "+ empleados.get(index).getNombre() + " - Incidencias Terminadas: " +minimo;
        }
        return result;
    }

}
