import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CLASE INCIDENCIA: 
 */

public class Incidencia {
    
    private String id;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private int estado;
    private Tecnico tecnico;
    private Integer tiempoRes;

    /**
     * CONSTRUCTOR
     * @param descripcion
    */

    public Incidencia(String descripcion){
    	this.id = Identificador.Instance();
    	this.descripcion = descripcion;
    	this.fechaInicio = new java.util.Date();
    	this.estado = 0; 
    	
    }
    
    /**
     * SET TECNICO --> Cambia Estado a Estado = 1 ---> Ver getEstado() para todas las opciones
     * @param tecnico
     */
    
    public void setTecnico(Tecnico tecnico) {
    	this.tecnico = tecnico;
    	this.estado=1;
    }
    
    /**
     * GET ID
     * @return
     */

    public String getId() {
    	return id;
    }
    
    /**
     * GET DESCRIPCION
     * @return
     */
    public String getDescripcion() {
	    return descripcion;
    }
   
    /**
     * GET FECHA INICIO
     * @return
     */
    public String getFechaInicio() {
    	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    	String fecha = format.format(fechaInicio);
    	return fecha;
    }
    
    /**
     * GET ESTADO --> Al manejarlo así hacemos flexible los estados, de manera que más adelante se pueden incluir más de manera sencilla
     * @return
     */
    public String getEstado() {
    	if(estado == 0) {
    		return "Pendiente";
    	}else if (estado == 1) {
    		return "En Proceso";
    	}else {
    		return "Terminado";
    	}
    }
    
    /**
     * GET TECNICO
     * @return
     */
    
    public Tecnico getTecnico() {
    	return tecnico;
    }
    
    /**
     * GET FECHA FIN
     * @return
     */

    public String getFechaFin() {
    	if(fechaFin==null) {
    		return null;
    	}
    	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    	String fecha = format.format(fechaFin);
    	return fecha;
    }
    
    /**
     * GET TIEMPO DE RESOLUCION
     * @return
     */

    public Integer getTiempoRes() {
    	return tiempoRes;
    }
    
    /**
     * GET DATOS --> Descripción completa de la incidencia
     * @return
     */

    public String getDatos() {
    	
    	String datos;
    	
    	if(tecnico!=null) {
    		datos = "Parte: "+id+" - Fecha Inicio: "+fechaInicio+" - Tecnico: "+tecnico.getNombre()+"\t - Estado: "+estado+"\t Tiempo de Reparacion: "+tiempoRes;
    	}else {
    		datos = "Parte: "+id+" - Fecha Inicio: "+fechaInicio+" - Tecnico: Sin asignar"+"\t - Estado: "+estado+"\t Tiempo de Reparacion: "+tiempoRes;
    	}
    	return datos;
    }

   
    public String toString() {
		
		return "Incidencia: "+ id;
	}


    /**
     * CERRAR INCIDENCIA --> Fija tambien fecha de cierre
     *                   --> Cambia Estado a Estado = 2 ---> Ver getEstado() para todas las opciones
     * @param tiempoRes
     */
    public void cerrarParte(Integer tiempoRes) {
    	this.estado=2;
    	this.fechaFin = new java.util.Date();
    	this.tiempoRes = tiempoRes;    	
    }
    

}