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

import controladores.VentanaPrincipalControlador;
import controladores.VentanaRegistroControlador;
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
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class VentanaRegistro extends JFrame{
	private File imagen;
	private Image icono;
	private PanelGradiente panelGradiente1;
	private PanelBorder panelRegistro;
	private JTextField fieldApellido;
	private JTextField fieldNombre;
	private JTextField fieldIncomp;
	private JLabel lblExito;
	private String apellido;
	private String nombre;
	private String rol;
	private String incompatibilidad;
	private int calificacion;
	private List<Persona> personas;

	public VentanaRegistro() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize() {
		personas = VentanaRegistroControlador.getLista();
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
        
        JLabel lblRegistrar = new JLabel("Registrar");
        lblRegistrar.setBounds(0, 23, 230, 37);
        lblRegistrar.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblRegistro1 = new JLabel("Persona");
        lblRegistro1.setBounds(0, 66, 230, 24);
        lblRegistro1.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistro1.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelRegistro.setLayout(null);
        panelRegistro.add(lblRegistrar);
        panelRegistro.add(lblRegistro1);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblApellido.setBounds(25, 113, 67, 14);
        panelRegistro.add(lblApellido);
        
        fieldApellido = new JTextField();
        fieldApellido.setColumns(10);
        fieldApellido.setBounds(24, 128, 181, 24);
        panelRegistro.add(fieldApellido);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(25, 163, 67, 14);
        panelRegistro.add(lblNombre);
        
        fieldNombre = new JTextField();
        fieldNombre.setColumns(10);
        fieldNombre.setBounds(24, 178, 181, 24);
        panelRegistro.add(fieldNombre);
        
        JLabel lblRol = new JLabel("Rol");
        lblRol.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRol.setBounds(25, 213, 67, 14);
        panelRegistro.add(lblRol);
        
        JLabel lblCalificacion = new JLabel("Calificacion");
        lblCalificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCalificacion.setBounds(25, 307, 67, 24);
        panelRegistro.add(lblCalificacion);
        
        fieldIncomp = new JTextField();
        fieldIncomp.setColumns(10);
        fieldIncomp.setBounds(24, 278, 181, 24);
        panelRegistro.add(fieldIncomp);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setForeground(new Color(0, 0, 0));
        btnRegistrar.setBackground(Color.LIGHT_GRAY);
        btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnRegistrar.setBounds(116, 378, 90, 24);
        panelRegistro.add(btnRegistrar);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnVolver.setBackground(Color.LIGHT_GRAY);
        btnVolver.setBounds(25, 378, 81, 24);
        panelRegistro.add(btnVolver);
        
        JLabel lblIncomp = new JLabel("Incompatibilidad");
        lblIncomp.setHorizontalAlignment(SwingConstants.LEFT);
        lblIncomp.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIncomp.setBounds(25, 263, 144, 14);
        panelRegistro.add(lblIncomp);
        
        lblExito = new JLabel();
        lblExito.setForeground(new Color(0, 128, 0));
        lblExito.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblExito.setBounds(25, 360, 195, 14);
        panelRegistro.add(lblExito);
        
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Arquitecto", "Programador", "Tester", "Lider del Proyecto"}));
        comboBox.setBounds(24, 228, 181, 24);
        panelRegistro.add(comboBox);
        
        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
        spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
        spinner.setBounds(24, 328, 181, 24);
        panelRegistro.add(spinner);
        
        GroupLayout gl_panelGradiente1 = new GroupLayout(panelGradiente1);
        gl_panelGradiente1.setHorizontalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panelGradiente1.createSequentialGroup()
        			.addContainerGap(330, Short.MAX_VALUE)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
        			.addGap(324))
        );
        gl_panelGradiente1.setVerticalGroup(
        	gl_panelGradiente1.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panelGradiente1.createSequentialGroup()
        			.addContainerGap(77, Short.MAX_VALUE)
        			.addComponent(panelRegistro, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
        			.addGap(60))
        );
        
        panelGradiente1.setLayout(gl_panelGradiente1);
        btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistro.remove(lblExito);
				apellido = fieldApellido.getText();
				nombre = fieldNombre.getText();
				rol = (String) comboBox.getSelectedItem();
				incompatibilidad = fieldIncomp.getText();
				calificacion = (int) spinner.getValue();
				if (!apellido.isBlank() || !nombre.isBlank()) {
					Persona per = VentanaRegistroControlador.generarPersona(apellido, nombre, rol, incompatibilidad, calificacion);
					personas = VentanaRegistroControlador.registrarPersona(per);
					limpiarFields();
					aniadirExito();					
				} else {					
					JOptionPane.showMessageDialog(null, "El apellido o el nombre no pueden estar vacíos.");
				}
			}
		});
        
        btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaRegistroControlador.cerrar();
			limpiarFields();
			VentanaPrincipalControlador.mostrar();
			VentanaPrincipalControlador.actualizarTabla(personas);
		}
	});
	}
	
	private void aniadirExito() {
		lblExito.setText("\u00A1Persona registrada con éxito!");
		panelRegistro.add(lblExito);
	}
	private void limpiarFields() {
		fieldApellido.setText("");
		fieldNombre.setText("");
		fieldIncomp.setText("");
	}
}
