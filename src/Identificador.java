/**
 *  CLASE IDENTIFICADOR: Resuelve una unica instancia que asigna los numeros de incidencias correlativos.
 *                       Usa Patron Singleton
 */


public class Identificador {
    
    private int contador = 0;
    private static Identificador instance = null;

    /**
     *  CONSTRUCTOR - PRIVADO
     */
    private Identificador(){
  
    }

    /**
     * INSTANCIADOR.
     */
    public static String Instance(){
        if(instance==null)
            instance = new Identificador();
      instance.incrementar();
      return instance.getContador();
    }

    /**
     * INCREMENTA CONTADOR
     */
    private  void incrementar(){
        this.contador++;
    }

    /**
     * CONSTRUYE EL STRING DEL CONTADOR
     * @return
     */
    public  String getContador(){
        return "IC"+contador;
    }
}