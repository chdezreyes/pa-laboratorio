/**
 * CLASE TECNICO:
 */

public class Tecnico {

    private String nombre;
    private String nivel;
    
    public Tecnico (String nombre, String nivel) {
    	this.nombre = nombre;
    	this.nivel = nivel;
    }

    /*SETTERS*/

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setNivel(String nivel){
        this.nivel = nivel;
    }
    
    /*GETTERS*/

    public String getNombre(){
    	if(this.nombre == null) {
    		nombre = "Sin Asignar";
    	}
        return nombre;
    }

    public String getNivel(){
        return nivel;
    }

    public String getDatos() {
    	return nombre+" - "+nivel;
    }

    public String toString() {
		
		return "Tec: "+ nombre +" - "+nivel;
	}
}
