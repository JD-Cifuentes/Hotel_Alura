package com.hotel_alura.views;

import com.hotel_alura.controllers.RecordCRUD.QuerySelectors;
import com.hotel_alura.models.Reserve;
import com.hotel_alura.models.enums.FontSizes;
import com.hotel_alura.models.enums.PaymentMethods;
import com.hotel_alura.models.enums.QueryOptions;
import com.hotel_alura.views.components_instancy_tools.IntOnlyKeyListener;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@SuppressWarnings("serial")
public class ReservasView extends JFrame {


	private final JTextField txtDocumento;
	private JPanel contentPane;
	public static JTextField txtValor;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<String> txtFormaPago;
	int xMouse, yMouse;

	private JLabel labelExit;
	private JLabel labelAtras;

	private double billValue;
	private LocalDate CheckInDate;
	private LocalDate CheckOutDate;


	public ReservasView() {
		super("Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Código que crea los elementos de la interfáz gráfica


		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 155, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.textHighlight);
		separator_2.setBounds(68, 225, 289, 2);
		separator_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(SystemColor.textHighlight);
		separator_3.setBounds(68, 295, 289, 2);
		separator_3.setBackground(SystemColor.textHighlight);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(SystemColor.textHighlight);
		separator_4.setBackground(SystemColor.textHighlight);
		separator_4.setBounds(68, 365, 289, 2);
		panel.add(separator_4);


		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setBounds(109, 50, 219, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, FontSizes.MEDIUM.getSize()));
		panel.add(lblTitulo);

		JLabel lblClientDoc = new JLabel("DOCUMENTO DEL CLIENTE");
		lblClientDoc.setForeground(SystemColor.textInactiveText);
		lblClientDoc.setBounds(68, 105, 169, 14);
		lblClientDoc.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.SMALL.getSize()));
		panel.add(lblClientDoc);
		
		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 170, 169, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.SMALL.getSize()));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 240, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.SMALL.getSize()));
		panel.add(lblCheckOut);

		JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(68, 310, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.SMALL.getSize()));
		panel.add(lblValor);
		
		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 380, 187, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.SMALL.getSize()));
		panel.add(lblFormaPago);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(Objects.requireNonNull(ReservasView.class.getResource("/imagenes/Ha-100px.png"))));
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 500, 409);
		panel_1.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(Objects.requireNonNull(ReservasView.class.getResource("/imagenes/reservas-img-3.png"))));

												
		// Componentes para dejar la interfaz con estilo Material Design
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
				 btnexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);


		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));

		JLabel lblSiguiente = new JLabel("RESERVAR");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		lblSiguiente.setBounds(0, 0, 122, 35);
		
		
		//Campos que guardaremos en la base de datos

		txtDocumento = new JTextField();
		txtDocumento.addKeyListener(new IntOnlyKeyListener(txtDocumento));
		txtDocumento.setBackground(SystemColor.text);
		txtDocumento.setForeground(Color.BLACK);
		txtDocumento.setBounds(68, 120, 289, 35);
		txtDocumento.setFont(new Font("Roboto Black", Font.BOLD, FontSizes.MEDIUM.getSize()));
		txtDocumento.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtDocumento);

		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(ReservasView.class.getResource("/imagenes/icon-reservas.png"))));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, FontSizes.SMALL.getSize()));
		txtFechaEntrada.setBounds(68, 185, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		panel.add(txtFechaEntrada);

		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(ReservasView.class.getResource("/imagenes/icon-reservas.png"))));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, FontSizes.SMALL.getSize()));
		txtFechaSalida.setBounds(68, 255, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 33);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtFechaSalida);
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (txtFechaSalida.getDate() != null && txtFechaEntrada.getDate() != null){
					CheckInDate = txtFechaEntrada.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					CheckOutDate = txtFechaSalida.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					long daysToPay = ChronoUnit.DAYS.between( CheckInDate, CheckOutDate);

					if (daysToPay > 0){
						billValue = daysToPay*Reserve.getStandarRoomValue();
						txtValor.setText( Double.toString (billValue));

					}else{
						txtValor.setText("Fechas invalidas");
						billValue = 0;
					}
				}
			}
		});


		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(78, 325, 289, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, FontSizes.MEDIUM.getSize()));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);


		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 405, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		try {
			PaymentMethods.insertPaymentMethodList(txtFormaPago);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		panel.add(txtFormaPago);

		JPanel btnsiguiente = new JPanel();
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (billValue > 0 ) {

					try{
						long document = Long.parseLong(txtDocumento.getText());
						List<String> dataTotransfer = new ArrayList<>();
						dataTotransfer.add(CheckInDate.toString());
						dataTotransfer.add(CheckOutDate.toString());
						dataTotransfer.add((String) txtFormaPago.getSelectedItem());

						QuerySelectors.createSelector(QueryOptions.RESERVE.toString(), document, dataTotransfer);

						Exito dialog = new Exito();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);

					}catch (Exception exception){
						JOptionPane.showMessageDialog(
								null,
								"Verifica que el huésped se encuentre \n" +
										"registrado previamente, de no ser así \n" +
										"proceda primero a registrarlo.",
								"No se logró crear la reserva",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}						
		});
		btnsiguiente.setLayout(null);
		btnsiguiente.setBackground(SystemColor.textHighlight);
		btnsiguiente.setBounds(238, 493, 122, 35);
		btnsiguiente.add(lblSiguiente);
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


	}
		
	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"	
	 private void headerMousePressed(MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
