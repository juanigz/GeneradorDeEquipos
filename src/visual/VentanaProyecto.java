package visual;

import javax.swing.JFrame;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import swing.PanelBorder;
import swing.PanelGradiente;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import controladores.VentanaEstadisticasControlador;
import controladores.VentanaPrincipalControlador;
import controladores.VentanaProyectoControlador;
import controladores.VentanaRegistroControlador;
import sistema.Equipo;
import sistema.Incompatibilidad;
import sistema.Persona;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class VentanaProyecto extends JFrame{
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRegistro;
	private JTextField fieldLideres;
	private JTextField fieldArquitectos;
	private JTextField fieldTesters;
	private JTextField fieldProgramadores;
	private Integer cantLideres;
	private Integer cantArquitectos;
	private Integer cantTesters;
	private Integer cantProgramadores;
	private static List<Persona> personas;
	private List<Incompatibilidad> incompatibilidades;

	public VentanaProyecto() {
		initialize();
	}

	public void initialize() {
		personas = VentanaRegistroControlador.getLista();
		for (Persona p : personas) {			
			incompatibilidades = VentanaRegistroControlador.getIncompatibilidades(p, p.getIncompatibilidad());
		}
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
		panelRegistro = new swing.PanelBorder();
	
		panelGradiente1.setColorPrimario(new Color(0, 230, 249));
        panelGradiente1.setColorSecundario(new Color(128, 0, 64));
        
        panelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        
        getContentPane().add(panelGradiente1, BorderLayout.CENTER);

        panelGradiente1.setLayer(panelRegistro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        JLabel lblNuevo = new JLabel("Nuevo");
        lblNuevo.setBounds(0, 23, 230, 37);
        lblNuevo.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblProyecto = new JLabel("Proyecto");
        lblProyecto.setBounds(0, 59, 230, 43);
        lblProyecto.setHorizontalAlignment(SwingConstants.CENTER);
        lblProyecto.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelRegistro.setLayout(null);
        panelRegistro.add(lblNuevo);
        panelRegistro.add(lblProyecto);
        
        JLabel lblLideres = new JLabel("Cantidad de Lideres");
        lblLideres.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLideres.setBounds(25, 113, 180, 14);
        panelRegistro.add(lblLideres);
        
        fieldLideres = new JTextField();
        fieldLideres.setColumns(10);
        fieldLideres.setBounds(24, 128, 181, 24);
        panelRegistro.add(fieldLideres);
        
        JLabel lblArquitectos = new JLabel("Cantidad de Arquitectos");
        lblArquitectos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblArquitectos.setBounds(25, 163, 180, 14);
        panelRegistro.add(lblArquitectos);
        
        fieldArquitectos = new JTextField();
        fieldArquitectos.setColumns(10);
        fieldArquitectos.setBounds(24, 178, 181, 24);
        panelRegistro.add(fieldArquitectos);
        
        JLabel lblProrgramadores = new JLabel("Cantidad de Prorgramadores");
        lblProrgramadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProrgramadores.setBounds(25, 213, 180, 14);
        panelRegistro.add(lblProrgramadores);
        
        fieldTesters = new JTextField();
        fieldTesters.setColumns(10);
        fieldTesters.setBounds(24, 278, 181, 24);
        panelRegistro.add(fieldTesters);
        
        JButton btnGenerar = new JButton("Generar");
        btnGenerar.setForeground(new Color(0, 0, 0));
        btnGenerar.setBackground(Color.LIGHT_GRAY);
        btnGenerar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnGenerar.setBounds(115, 313, 90, 24);
        panelRegistro.add(btnGenerar);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnVolver.setBackground(Color.LIGHT_GRAY);
        btnVolver.setBounds(24, 313, 81, 24);
        panelRegistro.add(btnVolver);
        
        JLabel lblTesters = new JLabel("Cantidad de Testers");
        lblTesters.setHorizontalAlignment(SwingConstants.LEFT);
        lblTesters.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTesters.setBounds(25, 263, 144, 14);
        panelRegistro.add(lblTesters);

        fieldProgramadores = new JTextField();
        fieldProgramadores.setColumns(10);
        fieldProgramadores.setBounds(24, 228, 181, 24);
        panelRegistro.add(fieldProgramadores);
        
        GroupLayout gl_panelGradiente1 = new GroupLayout(panelGradiente1);
        gl_panelGradiente1.setHorizontalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panelGradiente1.createSequentialGroup()
        			.addContainerGap(330, Short.MAX_VALUE)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
        			.addGap(324))
        );
        gl_panelGradiente1.setVerticalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_panelGradiente1.createSequentialGroup()
        			.addGap(95)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(113, Short.MAX_VALUE))
        );
        
        panelGradiente1.setLayout(gl_panelGradiente1);

        btnGenerar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cantLideres = Integer.parseInt(fieldLideres.getText());
					cantArquitectos = Integer.parseInt(fieldArquitectos.getText());
					cantTesters = Integer.parseInt(fieldTesters.getText());
					cantProgramadores = Integer.parseInt(fieldProgramadores.getText());
					if (cantLideres <= 0 || cantArquitectos <= 0 || cantTesters <= 0 || cantProgramadores <= 0) {
						JOptionPane.showMessageDialog(null, "Ingrese cantidades validas.");
					} else {					
						Equipo equipoBase = VentanaProyectoControlador.generarEquipo(personas, incompatibilidades);
						VentanaProyectoControlador.cargarRequerimientos(equipoBase, cantLideres, cantArquitectos, cantTesters, cantProgramadores);
						personas = VentanaProyectoControlador.getMejorSolucion(equipoBase);
						limpiarFields();
						VentanaProyectoControlador.cerrar();
						VentanaEstadisticasControlador.mostrar();
					}
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros.");
				}
			}
		});
        
        btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaProyectoControlador.cerrar();
			limpiarFields();
			VentanaPrincipalControlador.mostrar();
			VentanaPrincipalControlador.actualizarTabla(personas);
		}
	});
	}
	
	public static List<Persona> getMejorSolucion() {
		return personas;
	}
	
	private void limpiarFields() {
		fieldArquitectos.setText("");
		fieldLideres.setText("");
		fieldProgramadores.setText("");
		fieldTesters.setText("");
	}
}
