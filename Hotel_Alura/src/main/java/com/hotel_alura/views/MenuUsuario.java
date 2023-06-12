package com.hotel_alura.views;

import com.hotel_alura.models.enums.FontSizes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import java.util.Objects;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {


	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelRegistroReservas;
	private final JLabel labelRegistroCliente;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(50, 58, 150, 150);
		panelMenu.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuario.class.getResource("/imagenes/aH-150px.png"))));
		
		JPanel btnRegistroReserva = new JPanel();
		btnRegistroReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistroReserva.setBackground(new Color(118, 187, 223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistroReserva.setBackground(new Color(12, 138, 199));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistroReserva.setBounds(0, 255, 257, 56);
		btnRegistroReserva.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegistroReserva);
		btnRegistroReserva.setLayout(null);
		
		labelRegistroReservas = new JLabel("Registro de reservas");
		labelRegistroReservas.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuario.class.getResource("/imagenes/reservado.png"))));
		labelRegistroReservas.setForeground(SystemColor.text);
		labelRegistroReservas.setBounds(25, 11, 205, 34);
		labelRegistroReservas.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		labelRegistroReservas.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistroReserva.add(labelRegistroReservas);


		JPanel btnRegistroCliente = new JPanel();
		btnRegistroCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistroCliente.setBackground(new Color(118, 187, 223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistroCliente.setBackground(new Color(12, 138, 199));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistroHuesped frame = new RegistroHuesped();
				frame.setVisible(true);
				dispose();
			}
		});
		btnRegistroCliente.setBounds(0, 312, 257, 56);
		btnRegistroCliente.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegistroCliente);
		btnRegistroCliente.setLayout(null);

		labelRegistroCliente = new JLabel("Registro de huéspedes");
		labelRegistroCliente.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuario.class.getResource("/imagenes/persona-crear.png"))));
		labelRegistroCliente.setForeground(SystemColor.text);
		labelRegistroCliente.setBounds(27, 11, 200, 34);
		labelRegistroCliente.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		labelRegistroCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistroCliente.add(labelRegistroCliente);

		
		JPanel btnBusqueda = new JPanel();
		btnBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		btnBusqueda.setBounds(0, 369, 257, 56);
		btnBusqueda.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnBusqueda);
		btnBusqueda.setLayout(null);
		
		JLabel lblBusqueda = new JLabel("Búsqueda");
		lblBusqueda.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuario.class.getResource("/imagenes/pessoas.png"))));
		lblBusqueda.setBounds(27, 11, 200, 34);
		lblBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
		lblBusqueda.setForeground(Color.WHITE);
		lblBusqueda.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		btnBusqueda.add(lblBusqueda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(891, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));
		
	    JPanel panelFecha = new JPanel();
	    panelFecha.setBackground(new Color(118, 187, 223));
	    panelFecha.setBounds(256, 84, 688, 121);
	    contentPane.add(panelFecha);
	    panelFecha.setLayout(null);
	    
	    JLabel lblNewLabel_1 = new JLabel("Sistema de reservas Hotel Alura");
	    lblNewLabel_1.setBounds(180, 11, 356, 42);
	    panelFecha.add(lblNewLabel_1);
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, FontSizes.XLARGE.getSize()));
	    
	    JLabel labelFecha = new JLabel("New label");
	    labelFecha.setBounds(35, 64, 294, 36);
	    panelFecha.add(labelFecha);
	    labelFecha.setForeground(Color.WHITE);
	    labelFecha.setFont(new Font("Roboto", Font.PLAIN, FontSizes.XXLARGE.getSize()));
	    Date fechaActual = new Date(); //fecha y hora actual
	    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); //formatear la fecha en una cadena
	    labelFecha.setText("Hoy es " + fecha); //setear la representacion en cadena de la fecha
	    
	    JLabel lblNewLabel = new JLabel("Bienvenido");
	    lblNewLabel.setFont(new Font("Roboto", Font.BOLD, FontSizes.XLARGE.getSize()));
	    lblNewLabel.setBounds(302, 234, 147, 46);
	    contentPane.add(lblNewLabel);
	    
	    String textoDescripcion = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel   </body></html>";
	    JLabel labelDescripcion = new JLabel(textoDescripcion);
	    labelDescripcion.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
	   
	    labelDescripcion.setBounds(312, 291, 598, 66);
	    contentPane.add(labelDescripcion);
	    
	    String textoDescripcion1 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
	    JLabel labelDescripcion_1 = new JLabel(textoDescripcion1);
	    labelDescripcion_1.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
	    labelDescripcion_1.setBounds(311, 345, 569, 88);
	    contentPane.add(labelDescripcion_1);
	    
	    JLabel lblNewLabel_3 = new JLabel("- Registro de Reservas y Huéspedes");
	    lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
	    lblNewLabel_3.setBounds(312, 444, 295, 27);
	    contentPane.add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_3_1 = new JLabel("- Edición de Reservas y Huéspedes existentes");
	    lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
	    lblNewLabel_3_1.setBounds(312, 482, 355, 27);
	    contentPane.add(lblNewLabel_3_1);
	    
	    JLabel lblNewLabel_3_2 = new JLabel("- Eliminar todo tipo de registros");
	    lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
	    lblNewLabel_3_2.setBounds(312, 520, 295, 27);
	    contentPane.add(lblNewLabel_3_2);
	}
	
	private void headerMousePressed(MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
