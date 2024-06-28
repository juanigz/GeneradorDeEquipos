package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import controladores.VentanaEstadisticasControlador;
import controladores.VentanaPrincipalControlador;
import sistema.Persona;

import javax.swing.GroupLayout.Alignment;

import swing.PanelBorder;
import swing.PanelGradiente;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VentanaEstadisticas extends JFrame{
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRedondo2;
	private static DefaultTableModel modelo;
	private static int filasPorPagina = 100;
	private static DefaultXYDataset dataset;
	private static List<Integer> calificaciones;
	private List<Persona> personas;
	
	public VentanaEstadisticas() {
		initialize();
	}
	
	private void initialize() {
		personas = VentanaProyecto.getMejorSolucion();
		calificaciones = VentanaEstadisticasControlador.getCalificaciones();
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			imagen = new File("imagenes\\icono.png");
			icono = ImageIO.read(imagen);
			setIconImage(icono);
		} catch (Exception e) {
			System.out.println("Error cargando imagen: " + e.getMessage());
		}
		setTitle("");
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelGradiente1 = new swing.PanelGradiente();
		panelRedondo2 = new swing.PanelBorder();
	
		panelGradiente1.setColorPrimario(new Color(0, 230, 249));
        panelGradiente1.setColorSecundario(new Color(128, 0, 64));
        
        panelRedondo2.setBackground(new java.awt.Color(255, 255, 255));
        
        getContentPane().add(panelGradiente1, BorderLayout.CENTER);

        panelGradiente1.setLayer(panelRedondo2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        PanelBorder panelRedondo1 = new PanelBorder();
        panelRedondo1.setBackground(Color.WHITE);
        
		String[] columnas = {"Apellido", "Nombre", "Rol", "Incompatibilidad", "Calificacion"};

		modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Aca se define si la celda es editable o no
				return false;
			}
		};
		JTable tabla = new JTable(modelo);
		tabla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Font font = new Font("Tahoma", Font.BOLD, 12);
		tabla.getTableHeader().setFont(font);
		tabla.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 11, 450, 125);
		panelRedondo1.add(scrollPane);
        
        JLabel lblTitulo = new JLabel("Mejor Equipo");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 60));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
//        JButton btnPantallaPrincipal = new JButton("Pantalla Principal");
//        btnPantallaPrincipal.setForeground(Color.BLACK);
//        btnPantallaPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        btnPantallaPrincipal.setBackground(Color.LIGHT_GRAY);
        
        GroupLayout gl_panelGradiente1 = new GroupLayout(panelGradiente1);
        gl_panelGradiente1.setHorizontalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addGap(172)
        			.addGroup(gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panelGradiente1.createSequentialGroup()
        					.addGap(25)
        					.addComponent(panelRedondo1, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
        				.addComponent(panelRedondo2, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(417, Short.MAX_VALUE))
        		.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        );
        gl_panelGradiente1.setVerticalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panelRedondo1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panelRedondo2, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        
        panelGradiente1.setLayout(gl_panelGradiente1);
        
//        btnPantallaPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnPantallaPrincipal.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			getContentPane().invalidate();
//			getContentPane().validate();
//			getContentPane().repaint();
//			VentanaEstadisticasControlador.cerrar();
//			VentanaPrincipalControlador.mostrar();
//		}
//	});
	
        dataset = new DefaultXYDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(
        	    "", // Título del gráfico
        	    "Iteracion Valida", // Etiqueta del eje x
        	    "Mejor Calificacion", // Etiqueta del eje y
        	    dataset = dataSet(), // Dataset con los datos
        	    PlotOrientation.VERTICAL,
        	    true,
        	    true,
        	    false
        	);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(10, 11, 504, 247);
        panelRedondo2.add(chartPanel);
        
        chart.fireChartChanged();
        actualizarTabla(personas);
	}
	
	public static void actualizarTabla(List<Persona> personas) {
		modelo.setRowCount(0);
		int fin = Math.min(filasPorPagina, personas.size());
		for (int i = 0; i < fin; i++) {
			Persona persona = personas.get(i);
			modelo.addRow(new Object[]{persona.getApellido(), persona.getNombre(), 
					persona.getRol(), persona.getIncompatibilidad(), persona.getCalificacion()});
		}
		modelo.fireTableDataChanged();
		
	}
	
	private static DefaultXYDataset dataSet() {
		double[][] datosMejoresSoluciones = new double[2][calificaciones.size()];

		for (int i = 0; i < calificaciones.size(); i++) {
		    datosMejoresSoluciones[0][i] = i + 1; // Valor x (número de caso base)
		    datosMejoresSoluciones[1][i] = calificaciones.get(i); // Valor y (cantidad de casos base)
		}

		dataset.addSeries("Mejor Calificacion por Iteracion Valida", datosMejoresSoluciones);
		
		return dataset;
	}
}
