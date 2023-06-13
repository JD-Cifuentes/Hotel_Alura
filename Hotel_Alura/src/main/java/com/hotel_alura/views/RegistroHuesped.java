package com.hotel_alura.views;

import com.hotel_alura.controllers.RecordCRUD.QuerySelectors;
import com.hotel_alura.models.enums.FontSizes;
import com.hotel_alura.models.enums.JsonMaps;
import com.hotel_alura.models.enums.QueryOptions;
import com.hotel_alura.views.components_instancy_tools.InitComboBoxes;
import com.hotel_alura.views.components_instancy_tools.IntOnlyKeyListener;
import com.hotel_alura.views.components_instancy_tools.LetterOnlyKeyListener;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNDocumento;
	private JDateChooser txtFechaN;
	private JComboBox<Format> txtNacionalidad;
	private JLabel labelExit;
	private JLabel labelAtras;
	private LocalDate birthDate;
	int xMouse, yMouse;


	public RegistroHuesped() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
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
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
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
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(new Color(12, 138, 199));
			     labelAtras.setForeground(Color.white);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);


		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(12, 138, 199));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		panel.add(imagenFondo);
		imagenFondo.setIcon(new ImageIcon(Objects.requireNonNull(RegistroHuesped.class.getResource("/imagenes/registro.png"))));

		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(Objects.requireNonNull(RegistroHuesped.class.getResource("/imagenes/Ha-100px.png"))));

		JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
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
		btnexit.setBackground(Color.white);

		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));

		txtNDocumento = new JTextField();
		txtNDocumento.addKeyListener(new IntOnlyKeyListener(txtNDocumento));
		txtNDocumento.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		txtNDocumento.setBounds(560, 135, 285, 33);
		txtNDocumento.setColumns(10);
		txtNDocumento.setBackground(Color.WHITE);
		txtNDocumento.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNDocumento);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new LetterOnlyKeyListener(txtNombre));
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		txtNombre.setBounds(560, 204, 285, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new LetterOnlyKeyListener(txtApellido));
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		txtApellido.setBounds(560, 278, 285, 36);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtApellido);
		
		txtFechaN = new JDateChooser();
		txtFechaN.setBounds(560, 350, 289, 36);
		txtFechaN.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(RegistroHuesped.class.getResource("/imagenes/icon-reservas.png"))));
		txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		txtFechaN.addPropertyChangeListener(evt -> {
			if (txtFechaN.getDate() != null){
				birthDate = txtFechaN.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
		});
		contentPane.add(txtFechaN);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new IntOnlyKeyListener(txtTelefono));
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);
		
		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(560, 495, 285, 33);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		new InitComboBoxes(txtNacionalidad, JsonMaps.NATION);
		contentPane.add(txtNacionalidad);



		JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
		lblTitulo.setBounds(606, 55, 234, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.XLARGE.getSize()));
		contentPane.add(lblTitulo);

		JLabel lblNumeroDocumento = new JLabel("DOCUMENTO");
		lblNumeroDocumento.setBounds(562, 119, 253, 14);
		lblNumeroDocumento.setForeground(SystemColor.textInactiveText);
		lblNumeroDocumento.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		contentPane.add(lblNumeroDocumento);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(560, 189, 255, 14);
		lblNombre.setForeground(SystemColor.textInactiveText);
		lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(560, 256, 255, 14);
		lblApellido.setForeground(SystemColor.textInactiveText);
		lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		contentPane.add(lblApellido);
		
		JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
		lblFechaN.setBounds(560, 326, 255, 14);
		lblFechaN.setForeground(SystemColor.textInactiveText);
		lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		contentPane.add(lblFechaN);

		JLabel lblTelefono = new JLabel("TELÉFONO");
		lblTelefono.setBounds(562, 406, 253, 14);
		lblTelefono.setForeground(SystemColor.textInactiveText);
		lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		contentPane.add(lblTelefono);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(560, 474, 253, 14);
		lblNacionalidad.setForeground(SystemColor.textInactiveText);
		lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		contentPane.add(lblNacionalidad);
		

		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_1);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 314, 289, 2);
		separator_1_2_2.setForeground(new Color(12, 138, 199));
		separator_1_2_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_2);
		
		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 386, 289, 2);
		separator_1_2_3.setForeground(new Color(12, 138, 199));
		separator_1_2_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_3);
		
		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(12, 138, 199));
		separator_1_2_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_4);
		
		JSeparator separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(new Color(12, 138, 199));
		separator_1_2_5.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_5);
		
		JPanel btnguardar = new JPanel();
		btnguardar.setBounds(723, 560, 122, 35);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{

					if (!(txtNDocumento.getText().isBlank() ||
							txtNombre.getText().isBlank() ||
							txtApellido.getText().isBlank() ||
							birthDate.toString().isBlank() ||
							txtTelefono.getText().isBlank() ||
							Objects.requireNonNull(txtNacionalidad.getSelectedItem()).toString().isBlank()
					)){
						long document = Long.parseLong(txtNDocumento.getText());
						List<String> dataToCreate = new ArrayList<>();
						dataToCreate.add(txtNombre.getText());
						dataToCreate.add(txtApellido.getText());
						dataToCreate.add(birthDate.toString());
						dataToCreate.add(txtTelefono.getText());
						dataToCreate.add((String) txtNacionalidad.getSelectedItem());

						QuerySelectors.createSelector(QueryOptions.GUEST.toString(), document, dataToCreate);

						Exito dialog = new Exito();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(
								null,
								"Revisa que todos los campos estén completos",
								"Falta completar campos",
								JOptionPane.ERROR_MESSAGE);
					}


				}catch (Exception exception){
					JOptionPane.showMessageDialog(
							null,
							"No se completó la operación debido a que\n" +
									"el huésped ya se encuentra creado",
							"No se logró crear el huésped",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnguardar.setLayout(null);
		btnguardar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnguardar);
		btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelGuardar = new JLabel("GUARDAR");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnguardar.add(labelGuardar);

	}
	
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
