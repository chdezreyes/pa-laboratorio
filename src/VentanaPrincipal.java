import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class VentanaPrincipal extends JFrame implements ActionListener, DocumentListener{
    
    // PANEL SUPERIOR DE LA VENTANA
	private JLayeredPane 	  panelSuperior;
	private JLabel 			  incidencias;
	private JComboBox<Object> comboIncidencias;
	private JLabel			  tecnicos;
	private JComboBox<Object> comboTecnicos;
	private Border			  bordeSuperior;

    //PANEL INFERIOR DE LA VENTANA
	private Border			bordeInferior;
	private JLayeredPane 	panelInferior;
	private JLabel			id;
	private JTextField 		campoId;
	private JLabel			fechaInicio;
	private JTextField		campoFechaInicio;
	private JLabel			tecnicoAsignado;
	private JTextField		campoTecnicoAsignado;
	private JLabel			estado;
	private JTextField		campoEstado;
	private JLabel			tiempo;
	private JTextField		campoTiempo;
	private JLabel			fechaFin;
	private JTextField		campoFechaFin;
	private JLabel			descripcion;
	private JTextArea		campoDescripcion;

    //BOTONES
	private JButton			actualizar;
	private JButton			asignar;
	private JButton			informes;
	private JButton			cerrar;

	//ESTADISTICAS

	private Estadisticas	estadisticas;

    public VentanaPrincipal (ArrayList<Incidencia> averias, ArrayList<Tecnico> empleados){

        super("Gestor de Incidencias - ACME");
        inicioComponentes();
        cargadatosCombos(averias, empleados);
		estadisticas = new Estadisticas(averias, empleados);	
    }

    public void inicioComponentes(){

        //INICIAMOS LOS COMBOBOX
		comboIncidencias = new JComboBox<Object>();  
		comboTecnicos	 = new JComboBox<Object>(); 
       
        //DEFINIMOS EL PANEL SUPERIOR
		bordeSuperior = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		panelSuperior = new JLayeredPane();
		panelSuperior.setBackground(new Color (62,102,128));
		panelSuperior.setBounds(5,5,590,40);
		panelSuperior.setBorder(bordeSuperior);
		panelSuperior.setOpaque(true);
        
        //DEFINIMOS LOS ELEMETOS DEL PANEL SUPERIOR
		incidencias = new JLabel("Incidencias: ");
		incidencias.setBounds(10,5,80,30);
        incidencias.setForeground(Color.WHITE);
		comboIncidencias.setBounds(95,5,195,30);
		tecnicos	= new JLabel("Tecnicos: ");
		tecnicos.setBounds(315,5,60,30);
        tecnicos.setForeground(Color.WHITE);
		comboTecnicos.setBounds(385,5,195,30);

        //DEFINIMOS EL PANEL INFERIOR
		bordeInferior = BorderFactory.createTitledBorder("Detalle de Incidencias");
		panelInferior = new JLayeredPane();
		panelInferior.setBorder(bordeInferior);
		panelInferior.setBounds(5,50,590,210);

        //DEFINIMOS LOS ELEMENTOS DEL PANEL INFERIOR
		id = new JLabel("  ID: ");
		id.setBounds(15,20,100,25);
		id.setBackground(Color.DARK_GRAY);
		id.setForeground(Color.WHITE);
		id.setOpaque(true);
		
		campoId = new JTextField("");
		campoId.setBounds(120,20,150,25);
		
		fechaInicio = new JLabel("  Fecha Inicio: ");
		fechaInicio.setBounds(15,50,100,25);
		fechaInicio.setBackground(Color.DARK_GRAY);
		fechaInicio.setForeground(Color.WHITE);
		fechaInicio.setOpaque(true);
		
		campoFechaInicio = new JTextField("");
		campoFechaInicio.setBounds(120,50,150,25);
		
		tecnicoAsignado = new JLabel("  Tecnico: ");
		tecnicoAsignado.setBounds(15,80,100,25);
		tecnicoAsignado.setBackground(Color.DARK_GRAY);
		tecnicoAsignado.setForeground(Color.WHITE);
		tecnicoAsignado.setOpaque(true);
		
		campoTecnicoAsignado = new JTextField("");
		campoTecnicoAsignado.setBounds(120,80,150,25);
		
		estado = new JLabel("  Estado: ");
		estado.setBounds(15,110,100,25);
		estado.setBackground(Color.DARK_GRAY);
		estado.setForeground(Color.WHITE);
		estado.setOpaque(true);
		
		campoEstado = new JTextField("");
		campoEstado.setBounds(120,110,150,25);
		
		tiempo = new JLabel("  Tiempo: ");
		tiempo.setBounds(15,140,100,25);
		tiempo.setBackground(Color.DARK_GRAY);
		tiempo.setForeground(Color.WHITE);
		tiempo.setOpaque(true);
		
		campoTiempo = new JTextField("");
		campoTiempo.setBounds(120,140,150,25);
		
		fechaFin = new JLabel("  Fecha Cierre: ");
		fechaFin.setBounds(15,170,100,25);
		fechaFin.setBackground(Color.DARK_GRAY);
		fechaFin.setForeground(Color.WHITE);
		fechaFin.setOpaque(true);
		
		campoFechaFin = new JTextField("");
		campoFechaFin.setBounds(120,170,150,25);
		
        descripcion = new JLabel("  Descripcion: ");
		descripcion.setBounds(275,20,100,25);
		descripcion.setBackground(Color.DARK_GRAY);
		descripcion.setForeground(Color.WHITE);
		descripcion.setOpaque(true);
		
		campoDescripcion = new JTextArea("");
		campoDescripcion.setBounds(275,50,305,145);
		campoDescripcion.setLineWrap(true);
		campoDescripcion.setWrapStyleWord(true);
		campoDescripcion.setBorder(bordeSuperior);

        // DEFINIMOS LOS BOTONES
		actualizar = new JButton ("Actualizar");
		actualizar.setBounds(5,268,142,25);
		actualizar.setEnabled(false);
		
		asignar = new JButton ("Asignar");
		asignar.setBounds(153,268,142,25);
		asignar.setEnabled(false);
		
		informes = new JButton ("Informes");
		informes.setBounds(302,268,142,25);
		
		cerrar = new JButton ("Cerrar");
		cerrar.setBounds(450,268,142,25);

        this.setSize(615,340);
		this.setResizable(false);
		
		this.getContentPane().setLayout(new FlowLayout());
		setLayout(null);

        //COLOCAMOS EL PANEL SUPERIOR Y SUS ELEMENTOS
		this.getContentPane().add(panelSuperior);	
		panelSuperior.add(incidencias);
		panelSuperior.add(comboIncidencias);
		panelSuperior.add(tecnicos);
		panelSuperior.add(comboTecnicos);
		
		//COLOCAMOS EL PANEL INFERIOR Y SUS ELEMENTOS
		this.getContentPane().add(panelInferior);
		panelInferior.add(id);
		panelInferior.add(campoId);
		panelInferior.add(fechaInicio);
		panelInferior.add(campoFechaInicio);
		panelInferior.add(tecnicoAsignado);
		panelInferior.add(campoTecnicoAsignado);
		panelInferior.add(estado);
		panelInferior.add(campoEstado);
		panelInferior.add(tiempo);
		panelInferior.add(campoTiempo);
		panelInferior.add(fechaFin);
		panelInferior.add(campoFechaFin);
		panelInferior.add(descripcion);
		panelInferior.add(campoDescripcion);
		
		//COLOCAMOS LOS BOTONES
		this.getContentPane().add(actualizar);
		this.getContentPane().add(asignar);
		this.getContentPane().add(informes);
		this.getContentPane().add(cerrar);
		
		//SETEAMOS LOS PARAMETROS INCIALES DE ALGUNOS COMPONENTES.
		campoId.setEditable(false);
		campoFechaInicio.setEditable(false);
		campoTecnicoAsignado.setEditable(false);
		campoEstado.setEditable(false);
		campoTiempo.setEditable(false);
		campoFechaFin.setEditable(false);
		campoDescripcion.setEditable(false);
		comboTecnicos.setEnabled(false);
		
		//ASIGNAMOS LOS MANEJADORES
		comboIncidencias.addActionListener(this);
		comboTecnicos.addActionListener(this);
		asignar.addActionListener(this);
		actualizar.addActionListener(this);
		informes.addActionListener(this);
		cerrar.addActionListener(this);
		campoTiempo.getDocument().addDocumentListener(this);

		this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evento) {
        Object o = evento.getSource();

        if(o.equals(comboIncidencias)){
           if(comboIncidencias.getSelectedIndex()==0){
				System.out.println("Estoy en Cero");
				comboTecnicos.setEnabled(false);
				campoId.setText(null);
				campoFechaInicio.setText(null);
				campoTecnicoAsignado.setText(null);
        	       campoTecnicoAsignado.setOpaque(false);
				campoEstado.setText(null);
				campoTiempo.setText(null);
				campoFechaFin.setText(null);
				campoDescripcion.setText(null);
			}
            else{    
                Incidencia i =(Incidencia) comboIncidencias.getSelectedItem();
                comboTecnicos.setEnabled(true);
                campoId.setText(i.getId());
                campoFechaInicio.setText(i.getFechaInicio());
                if(i.getTecnico()==null) {
                    campoTecnicoAsignado.setText("Pendiente de Asignar");
                    campoTecnicoAsignado.setBackground(new Color (155,209,229));
                    campoTecnicoAsignado.setOpaque(true);
                    
                }else{
                    campoTecnicoAsignado.setText(i.getTecnico().getDatos());
                    campoTecnicoAsignado.setOpaque(false);
                }
                
                campoEstado.setText(i.getEstado());
                campoDescripcion.setText(i.getDescripcion());

                if(i.getEstado().equals("Terminado")){
                    campoTiempo.setText(i.getTiempoRes().toString());
                    campoTiempo.setEditable(false);
                    actualizar.setEnabled(false);
                    comboTecnicos.setEnabled(false);
					System.out.println("Estoy Terminado");
                }
				else if(i.getEstado().equals("En Proceso")){
					campoTiempo.setEditable(true);
					campoTiempo.setText(null);
                    System.out.println("Estoy en Proceso");
				
                }
				else{
					campoTiempo.setText(null);
					campoTiempo.setEditable(false);
					System.out.println("Estoy Pendiente");
						
				}

                if(i.getFechaFin()!=null) {
                    campoFechaFin.setText(i.getFechaFin().toString());
                }else {
                    campoFechaFin.setText(null);
                }

                System.out.println(i);
           }
        }
        else if(o.equals(comboTecnicos)){
            if(comboTecnicos.getSelectedIndex()==0){
                asignar.setEnabled(false);
            }
            else{
                asignar.setEnabled(true);               
            }
        }
        else if(o.equals(asignar)){
            Tecnico t =(Tecnico) comboTecnicos.getSelectedItem();
            Incidencia i =(Incidencia) comboIncidencias.getSelectedItem();

            try{
                comprobarTecnico(i);
                i.setTecnico(t);
                campoTecnicoAsignado.setText(i.getTecnico().getDatos());
                campoTecnicoAsignado.setOpaque(false);
                comboIncidencias.setSelectedItem(comboIncidencias.getSelectedItem());
            }catch (ExcepcionTecnicoAsignado e){
                JOptionPane.showMessageDialog(new JFrame(), " Esta Incidencia ya tiene tecnico asignado", "Aviso",
				JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(o.equals(actualizar)){
			Incidencia i =(Incidencia) comboIncidencias.getSelectedItem();
			if(!i.getEstado().equals("Terminado")){
				i.cerrarParte(Integer.parseInt(campoTiempo.getText()));
				comboIncidencias.setSelectedItem(comboIncidencias.getSelectedItem());
				actualizar.setEnabled(false);
			}			
        }
		else if(o.equals(informes)){
			VentanaEstadisticas ve = new VentanaEstadisticas(estadisticas);
			ve.setVisible(true);
			
			System.out.println(estadisticas.incidenciasAbiertas());
			System.out.println(estadisticas.incidenciasCerradas());
			System.out.println(estadisticas.incidenciasProceso());
			System.out.println(estadisticas.tiempoMedio());
			System.out.println(estadisticas.empleadoMas());
			System.out.println(estadisticas.empleadoMin());
		}

        else if(o.equals(cerrar)) {
            System.exit(0);  
        }


    }

    public void insertUpdate(DocumentEvent evento){
		Incidencia i =(Incidencia) comboIncidencias.getSelectedItem();
		if(!i.getEstado().equals("Terminado")){
			actualizar.setEnabled(true);
			System.out.println("Texto Insertado");
		}
        

    }

    public void removeUpdate(DocumentEvent evento){
		System.out.println("Texto Borrado");
	}

    public void changedUpdate(DocumentEvent evento){
        System.out.println("Texto cambiado");
		
    }

    public void comprobarTecnico(Incidencia i) throws ExcepcionTecnicoAsignado{
        if(i.getTecnico()!=null){
            throw new ExcepcionTecnicoAsignado();
        }
    }

    public void cargadatosCombos(ArrayList<Incidencia> averias, ArrayList<Tecnico> empleados){
       comboIncidencias.addItem("Seleccione Incidencia");
       comboTecnicos.addItem("Seleccione Tecnico");

        for (Incidencia i: averias){
            comboIncidencias.addItem(i);
        }

        for (Tecnico t : empleados){
            comboTecnicos.addItem(t);
        }
    }
}