import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEstadisticas extends JFrame implements ActionListener{
    
    //PANEL SUPERIOR DE LA VENTANA
    private JLayeredPane 	  panelSuperior;
    private Border			  bordeSuperior;
    private JLabel 			  etiquetaEstadisticas;   

    //PANEL MEDIO DE LA VENTANA
    private Border			bordeMedio;
	private JLayeredPane 	panelMedio;

    private JLabel          incidenciasAbiertas;
    private JTextField      datoIncidenciasAbiertas;
    private JLabel          incidenciasProceso;
    private JTextField      datoIncienciasProceso;
    private JLabel          incidenciasCerradas;
    private JTextField      datoIncidenciasCerradas;

    // PANEL INFERIOR DE LA VENTANA
    private Border			bordeInferior;
	private JLayeredPane 	panelInferior;

    private JLabel          tiempoMedio;
    private JTextField      datoTiempoMedio;
    private JLabel          tecnicoMas;
    private JTextField      datoTecnicoMas;
    private JLabel          tecnicoMenos;
    private JTextField      datoTecnicoMenos;

    //BOTONES
    private JButton	          cerrar;
    
    public VentanaEstadisticas(Estadisticas estadisticas) {
        
        super("Estadisticas de incidencias");
        inicioComponentes(estadisticas);
    }

    public void inicioComponentes(Estadisticas estadisticas){

        //DEFINIMOS EL PANEL SUPERIOR
        bordeSuperior = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		panelSuperior = new JLayeredPane();
		panelSuperior.setBackground(new Color (62,102,128));
		panelSuperior.setBounds(3,3,590,40);
		panelSuperior.setBorder(bordeSuperior);
		panelSuperior.setOpaque(true);
        etiquetaEstadisticas = new JLabel ("Estadisticas - KPI");
        etiquetaEstadisticas.setBounds(10,5,120,30);
        etiquetaEstadisticas.setForeground(Color.WHITE);

        //DEFINIMOS EL PANEL MEDIO
        bordeMedio = BorderFactory.createTitledBorder("Porcentajes: ");
		panelMedio = new JLayeredPane();
		panelMedio.setBorder(bordeMedio);
		panelMedio.setBounds(0,45,595,110);
        
        incidenciasAbiertas = new JLabel (" Porcentaje incidencias abiertas: ");
        incidenciasAbiertas.setBounds(10,20,220,25);
		incidenciasAbiertas.setBackground(Color.DARK_GRAY);
		incidenciasAbiertas.setForeground(Color.WHITE);
		incidenciasAbiertas.setOpaque(true);
        datoIncidenciasAbiertas = new JTextField(estadisticas.incidenciasAbiertas());
        datoIncidenciasAbiertas.setHorizontalAlignment(JTextField.RIGHT);
        datoIncidenciasAbiertas.setBounds(235,20,350,25);
                
        incidenciasProceso  = new JLabel (" Porcentaje incidencias en proceso: ");
        incidenciasProceso.setBounds(10,48,220,25);
		incidenciasProceso.setBackground(Color.DARK_GRAY);
		incidenciasProceso.setForeground(Color.WHITE);
		incidenciasProceso.setOpaque(true);
        datoIncienciasProceso = new JTextField(estadisticas.incidenciasProceso());
        datoIncienciasProceso.setHorizontalAlignment(JTextField.RIGHT);
        datoIncienciasProceso.setBounds(235,48,350,25);
        
        incidenciasCerradas  = new JLabel (" Porcentaje incidencias cerradas: ");
        incidenciasCerradas.setBounds(10,76,220,25);
		incidenciasCerradas.setBackground(Color.DARK_GRAY);
		incidenciasCerradas.setForeground(Color.WHITE);
		incidenciasCerradas.setOpaque(true);
        datoIncidenciasCerradas  = new JTextField(estadisticas.incidenciasCerradas());
        datoIncidenciasCerradas.setHorizontalAlignment(JTextField.RIGHT);
        datoIncidenciasCerradas.setBounds(235,76,350,25);
      
         //DEFINIMOS EL PANEL INFERIOR
        bordeInferior = BorderFactory.createTitledBorder("Informes: ");
        panelInferior = new JLayeredPane();
        panelInferior.setBorder(bordeInferior);
        panelInferior.setBounds(0,155,595,110);

        tiempoMedio = new JLabel (" Tiempo medio de resolucion : ");
        tiempoMedio.setBounds(10,20,220,25);
		tiempoMedio.setBackground(Color.DARK_GRAY);
		tiempoMedio.setForeground(Color.WHITE);
		tiempoMedio.setOpaque(true);
        datoTiempoMedio = new JTextField(estadisticas.tiempoMedio());
        datoTiempoMedio.setHorizontalAlignment(JTextField.LEFT);
        datoTiempoMedio.setBounds(235,20,350,25);
        
        tecnicoMas = new JLabel (" Tecnico mas resolutivo: ");
        tecnicoMas.setBounds(10,48,220,25);
		tecnicoMas.setBackground(Color.DARK_GRAY);
		tecnicoMas.setForeground(Color.WHITE);
		tecnicoMas.setOpaque(true);
        datoTecnicoMas = new JTextField(estadisticas.empleadoMas());
        datoTecnicoMas.setHorizontalAlignment(JTextField.LEFT);
        datoTecnicoMas.setBounds(235,48,350,25);
        
        tecnicoMenos = new JLabel (" Tiecnico menos resolutivo: ");
        tecnicoMenos.setBounds(10,76,220,25);
		tecnicoMenos.setBackground(Color.DARK_GRAY);
		tecnicoMenos.setForeground(Color.WHITE);
		tecnicoMenos.setOpaque(true);
        datoTecnicoMenos = new JTextField(estadisticas.empleadoMin());
        datoTecnicoMenos.setHorizontalAlignment(JTextField.LEFT);
        datoTecnicoMenos.setBounds(235,76,350,25);


        
        //DEFINIMOS LOS BOTONES
        cerrar = new JButton ("Cerrar");
		cerrar.setBounds(450,268,142,25);

        this.setSize(615,340);
		this.setResizable(false);
        this.getContentPane().setLayout(new FlowLayout());
		setLayout(null);
        
        // COLOCAMOS EL PANEL SUPERIOR
        this.getContentPane().add(panelSuperior);	
        panelSuperior.add(etiquetaEstadisticas);

        //COLOCAMOS EL PANEL MEDIO
        this.getContentPane().add(panelMedio);
        panelMedio.add(incidenciasAbiertas);
        panelMedio.add(incidenciasProceso);
        panelMedio.add(incidenciasCerradas);
        panelMedio.add(datoIncidenciasAbiertas);
        panelMedio.add(datoIncienciasProceso);
        panelMedio.add(datoIncidenciasCerradas);

         //COLOCAMOS EL PANEL INFERIOR
        this.getContentPane().add(panelInferior);
        panelInferior.add(tiempoMedio);
        panelInferior.add(datoTiempoMedio);
        panelInferior.add(tecnicoMas);
        panelInferior.add(datoTecnicoMas);
        panelInferior.add(tecnicoMenos);
        panelInferior.add(datoTecnicoMenos); 

        //COLOCAMOS LOS BOTONES
        this.getContentPane().add(cerrar);

        //ASIGNAMOS LOS MANEJADORES
        cerrar.addActionListener(this);
    }

    public void actionPerformed (ActionEvent evento){
        Object o = evento.getSource();

        if(o.equals(cerrar)){
            this.setVisible(false);	
        }
    }
}
