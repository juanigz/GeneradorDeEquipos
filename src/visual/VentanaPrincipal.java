package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import controladores.VentanaPrincipalControlador;
import controladores.VentanaProyectoControlador;
import controladores.VentanaRegistroControlador;
import sistema.Persona;
import swing.PanelBorder;
import swing.PanelGradiente;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRedondo;
	private JPanel panel;
	private String mensaje;
    private static JTable tabla;
    private static DefaultTableModel modelo;
    private static int filasPorPagina = 100;
    private List<Persona> personas;

	public VentanaPrincipal() {
		initialize();
	}
	private void initialize() {
		personas = VentanaRegistroControlador.getLista();
		mensaje = "";
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
		panelRedondo = new swing.PanelBorder();
		panelRedondo.setBounds(15, 120, 850, 352);

		panelGradiente1.setColorPrimario(new Color(0, 230, 249));
		panelGradiente1.setColorSecundario(new Color(128, 0, 64));

		panelRedondo.setBackground(new java.awt.Color(255, 255, 255));

		getContentPane().add(panelGradiente1, BorderLayout.CENTER);
		panelGradiente1.setLayout(null);

		panelGradiente1.setLayer(panelRedondo, javax.swing.JLayeredPane.DEFAULT_LAYER);
		panelGradiente1.add(panelRedondo);

		String[] columnas = {"Apellido", "Nombre", "Rol", "Incompatibilidad", "Calificacion"};

		modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Aca se define si la celda es editable o no
				return false;
			}
		};
		tabla = new JTable(modelo);
		tabla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Font font = new Font("Tahoma", Font.BOLD, 12);
		tabla.getTableHeader().setFont(font);
		tabla.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(10, 11, 830, 328);
		panelRedondo.add(scrollPane);
		
		JButton btnRegistrar = new JButton("Nueva Persona");
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.setBounds(15, 526, 150, 24);
		panelGradiente1.add(btnRegistrar);
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipalControlador.cerrar();
				VentanaRegistroControlador.mostrar();
			}
		});
		
		JButton btnGuardar = new JButton("Guardar Lista");
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.setBounds(175, 526, 150, 24);
		panelGradiente1.add(btnGuardar);
	
		JButton btnGrupo = new JButton("Nuevo Proyecto");
		btnGrupo.setForeground(Color.BLACK);
		btnGrupo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGrupo.setBackground(Color.LIGHT_GRAY);
		btnGrupo.setBounds(715, 526, 150, 24);
		panelGradiente1.add(btnGrupo);
		
		JLabel lblTitulo = new JLabel("Personas Disponibles");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(15, 11, 850, 87);
		panelGradiente1.add(lblTitulo);
		
		JButton btnEliminar = new JButton("Eliminar Persona");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setBounds(335, 526, 150, 24);
		panelGradiente1.add(btnEliminar);
		
		btnGrupo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipalControlador.cerrar();
				VentanaProyectoControlador.mostrar();
			}
		});
		
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		if (!mensaje.isBlank()) {
        			panelGradiente1.remove(panel);
        		}
        		mensaje = "guardado";
        		agregarExito(mensaje);
				VentanaPrincipalControlador.guardarJson(personas);
			}
		});
		actualizarTabla(personas);
		
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		String personaAEliminar = JOptionPane.showInputDialog(null, "Ingrese el apellido de la "
        				+ "persona que quiere eliminar:", "", JOptionPane.PLAIN_MESSAGE);
        		if (!mensaje.isBlank()) {
        			panelGradiente1.remove(panel);
        		}
        		if (personaAEliminar != null) {
        			mensaje = "eliminar";
        			agregarExito(mensaje);
        			personas = VentanaPrincipalControlador.eliminarPersona(personaAEliminar);
        			actualizarTabla(personas);        			
        		}
			}
		});
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
		tabla.revalidate();
		tabla.repaint();
	}
	
	private void agregarExito(String mensaje) {
		panel = new JPanel();
		panel.setBounds(15, 501, 173, 20);
		panelGradiente1.add(panel);
		panel.setLayout(null);
		
		JTextArea txtExito = new JTextArea();
		txtExito.setBounds(0, 0, 180, 20);
		txtExito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtExito.setEditable(false);
		if (mensaje.equals("guardado")) {			
			txtExito.setText("¡Lista guardada con éxito!");
		}
		if (mensaje.equals("eliminar")) {
			panel.setBounds(15, 501, 193, 20);
			txtExito.setBounds(0, 0, 200, 20);
			txtExito.setText("¡Persona eliminada con éxito!");
		}
		panel.add(txtExito);
	}
}
