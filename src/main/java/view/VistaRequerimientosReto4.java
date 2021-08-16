package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LideresMayorSalario;
import model.vo.LideresProyectosEmblematicos;
import model.vo.MaterialRankeadoImportado;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaRequerimientosReto4 extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextArea textArea;

    public VistaRequerimientosReto4() {
            JFrame frame = new JFrame ("PROYECTO DE CONSTRUCCIÓN"); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 300);
    frame.setVisible(true);
    
		setBounds(470, 250, 800, 650);      
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reto 5 MVC");
		lblNewLabel.setBounds(25, 15, 70, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Obed de Jesús Correa");
		lblNewLabel_1.setBounds(28, 40, 208, 16);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 60, 737, 455);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btn_consulta_1 = new JButton("Consulta 1");				// Consulta 1
		btn_consulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requerimiento1();
			}
		});
		btn_consulta_1.setBounds(30, 525, 110, 30);
		contentPane.add(btn_consulta_1);
		
		JButton btnNewButton = new JButton("Consulta 2");				// Consulta 2
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requerimiento3();
			}
		});
		btnNewButton.setBounds(157, 525, 110, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consulta 3");				// Consulta 3
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requerimiento4();
			}
		});
		btnNewButton_1.setBounds(280, 525, 110, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clarear");				// Limpiar
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				
			}
		});
		btnNewButton_2.setBounds(648, 525, 110, 30);
		contentPane.add(btnNewButton_2);
	}

     public void requerimiento1(){

             

        try{

            ArrayList<LideresMayorSalario> rankingLideresMayorSalario = controlador.consultarLideresMayorSalarios();

            //Encabezado del resultado
           
            String enunciado = "* Lideres con mayor salario *\nID_Lider  Nombre  Primer_Apellido\n";
            
            //Cada VO cargado, mostrarlo en la vista
            for (LideresMayorSalario lideresMayors : rankingLideresMayorSalario) {
            	
            	
                enunciado += lideresMayors.getIdLider();
                enunciado += "           ";
                enunciado += lideresMayors.getNombre();
                enunciado += "         ";
                enunciado += lideresMayors.getPrimerApellido();
                enunciado += "\n";
                  
            }
            
            textArea.setText(enunciado);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public void requerimiento3(){       

        try{

            ArrayList<LideresProyectosEmblematicos> rankingProyectosEmblematicos = controlador.consultarLideresProyectosEmblematicos();


            //Encabezado del resultado
            String enunciado = "* Lideres proyectos emblemáticos *\nId_Lider	Id_Proyecto	Id_Tipo\n";
            
            //Cada VO cargado, mostrarlo en la vista
            for (LideresProyectosEmblematicos lideresProyectosE : rankingProyectosEmblematicos) {
            		
                enunciado += lideresProyectosE.getIdLider();
                enunciado += "           ";
                enunciado += lideresProyectosE.getIdProyecto();
                enunciado += "         ";
                enunciado += lideresProyectosE.getIdTipo();
                enunciado += "\n";
                  
            }
            
            textArea.setText(enunciado);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public void requerimiento4(){      

        String importe = "* Productos importados *\n\n";      

    try{
        
        ArrayList<MaterialRankeadoImportado> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosImportados();

        //Cada VO cargado, mostrarlo en la vista
        for (MaterialRankeadoImportado materialImportado : rankingMaterialesImportados) {
        	
            importe += "El producto de ID ";
        	importe += materialImportado.getIdMaterial();
        	importe += " de descripción: ";
        	importe += materialImportado.getNombreMaterial();
        	importe += "de tipo importado(a), tiene un precio de ";
        	importe += materialImportado.getPrecioUnidad();
      
        	importe += "\n"  ;
        }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
        textArea.setText(importe);
    }
}
