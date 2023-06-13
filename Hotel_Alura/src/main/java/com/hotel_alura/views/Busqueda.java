package com.hotel_alura.views;

import com.hotel_alura.controllers.RecordCRUD.QuerySelectors;
import com.hotel_alura.models.enums.FontSizes;
import com.hotel_alura.models.enums.QueryOptions;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;


	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, FontSizes.XLARGE.getSize()));
		lblNewLabel_4.setBounds(331, 62, 300, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);


		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		modelo = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0 && column != 1 && column != 4;
			}
		};
		modelo.addColumn("Número de reserva");
		modelo.addColumn("Fecha de registro");
		modelo.addColumn("Fecha Check-In");
		modelo.addColumn("Fecha Check-Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de pago");
		tbReservas.setModel(modelo);
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab(QueryOptions.RESERVE.toString(), new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/reservado.png"))), scroll_table, null);
		scroll_table.setVisible(true);


		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		modeloHuesped = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0 && column != 6;
			}
		};
		modeloHuesped.addColumn("Documento");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de reserva");
		tbHuespedes.setModel(modeloHuesped);
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab(QueryOptions.GUEST.toString(), new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/pessoas.png"))), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/Ha-100px.png"))));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
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
		header.setLayout(null);
		header.setBackground(Color.WHITE);
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
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
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
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, FontSizes.MEDIUM.getSize()));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JPanel btnAyudaFormato = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				Shape shape = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
				g2d.setColor(getBackground());
				g2d.fill(shape);
				g2d.dispose();
			}
		};


		btnAyudaFormato.setLayout(null);
		btnAyudaFormato.setBackground(new Color(12, 138, 199));
		btnAyudaFormato.setBounds(480, 125, 36, 36);
		btnAyudaFormato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnAyudaFormato);

		JLabel lblAyudaFormato = new JLabel("");
		lblAyudaFormato.setIcon(new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/question-sign-in-circles.png"))));
		lblAyudaFormato.setBounds(1, 1, 34, 34);
		btnAyudaFormato.add(lblAyudaFormato);

		JToolTip formatInfo = new JToolTip();
		formatInfo.setTipText("<html>" +
				"Formatos admitidos por campo <br>" +
				"- fechas -> aaaa/mm/dd<br>" +
				"- valor -> usar punto para decimal<br>" +
				"- formas de pago: * Efectivo<br>" +
				"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;* Tarjeta crédito<br>" +
				"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;* Tarjeta débito<br>" +
				"</html>");
		formatInfo.setAlignmentY(1);
		formatInfo.setForeground(Color.BLACK);
		formatInfo.setBackground(Color.LIGHT_GRAY);
		formatInfo.setFont(new Font("Roboto", Font.PLAIN, FontSizes.SMALL.getSize()));
		formatInfo.setOpaque(true);
		formatInfo.setVisible(false);
		formatInfo.setBounds(0, 0, 200, 100);
		contentPane.add(formatInfo);

		btnAyudaFormato.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				formatInfo.setVisible(true);
				formatInfo.setLocation(
						btnAyudaFormato.getX() - 200,
						btnAyudaFormato.getY() - 25
				);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				formatInfo.setVisible(false);
			}

		});

		contentPane.add(formatInfo);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnBuscar = new JPanel();
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchAndRenderTable(panel);
			}
		});

		btnBuscar.setLayout(null);
		btnBuscar.setBackground(new Color(12, 138, 199));
		btnBuscar.setBounds(748, 125, 122, 35);
		btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnBuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnBuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JTable selectedTable = getSelectedTable((JScrollPane) panel.getSelectedComponent());
				int selectedRowIndex = selectedTable.getSelectedRow();

				if (selectedRowIndex != -1){
					String refForSearch = selectedTable.getValueAt(selectedRowIndex, 0).toString();
					List<String> dataToUpdate = new ArrayList<>();

					for (int i = 0; i < selectedTable.getColumnCount(); i++) {

						String columnNameAtIndex = selectedTable.getColumnName(i);

						if (!(columnNameAtIndex.equals("Número de reserva") ||
								columnNameAtIndex.equals("Fecha de registro") ||
								columnNameAtIndex.equals("Documento"))
						) {
							dataToUpdate.add(selectedTable.getValueAt(selectedRowIndex, i).toString());
						}
					}
					try{
						QuerySelectors.editSelector(panel.getTitleAt(panel.getSelectedIndex()), dataToUpdate, refForSearch);

					}catch (Exception exception){
						JOptionPane.showMessageDialog(
								null,
								"No se lograrón actualizar los datos, verifica \n que la información agreagada se encuentre en un formato válido.",
								"ups! Ha ocurrido un error",
								JOptionPane.ERROR_MESSAGE);
					}

					searchAndRenderTable(panel);

				}else {
					noRowSelected();
				}
			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JTable selectedTable = getSelectedTable((JScrollPane) panel.getSelectedComponent());
				int selectedRowIndex = selectedTable.getSelectedRow();

				if (selectedRowIndex != -1){
					String refToDelete = selectedTable.getValueAt(selectedRowIndex, 0).toString();

					try{

						int option = JOptionPane.showConfirmDialog(
								null,
								"Confirmar eliminación",
								"¿Realmente quieres eliminar este registro?",
								JOptionPane.YES_NO_OPTION);

						if (option == JOptionPane.YES_OPTION){
							QuerySelectors.deleteSelector(panel.getTitleAt(panel.getSelectedIndex()), refToDelete);
							DefaultTableModel defaultModel = (DefaultTableModel) selectedTable.getModel();
							defaultModel.setRowCount(0);
							JOptionPane.showMessageDialog(
									null,
									"Registro eliminado con éxito",
									"El registro seleccionado \n fue eliminado con éxito",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}catch (Exception exception){
						JOptionPane.showMessageDialog(
								null,
								"No se logró elimnar el registro.",
								"ups! Ha ocurrido un error",
								JOptionPane.ERROR_MESSAGE);
					}
				}else {
					noRowSelected();
				}


			}
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, FontSizes.LARGE.getSize()));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
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

	private JTable getSelectedTable (JScrollPane selectedJScrollPane){
		Component view = selectedJScrollPane.getViewport().getView();
		return (JTable) view;
	}

	private	void noRowSelected(){
		JOptionPane.showMessageDialog(
				null,
				"No has seleccionado una fila,\n intenta nuevamente",
				"Ninguna fila seleccionada para editar",
				JOptionPane.WARNING_MESSAGE);
	}

	private void searchAndRenderTable(JTabbedPane panel){
		try{
			List<String> readQuery = QuerySelectors
					.searchSelector(
							panel.getTitleAt(panel.getSelectedIndex()),
							Long.parseLong(txtBuscar.getText())
					);

			if(readQuery.isEmpty()){
				throw new NullPointerException();
			}

			JTable selectedTable = getSelectedTable((JScrollPane) panel.getSelectedComponent());
			DefaultTableModel defaultModel = (DefaultTableModel) selectedTable.getModel();
			Object[] dataRegister = new Object[defaultModel.getColumnCount()];


			defaultModel.setRowCount(0);

			for (String queryRow:
					readQuery) {
				String[] queryRowSplited = queryRow.split("\n");

				System.arraycopy(queryRowSplited, 0, dataRegister, 0, dataRegister.length);
				defaultModel.addRow(dataRegister);
			}

		}catch (Exception exception){
			JOptionPane.showMessageDialog(
					null,
					"Verifique los valores ingresados \n para la consulta e intente nuevamente",
					"La consulta no fue exitosa",
					JOptionPane.ERROR_MESSAGE);
			System.out.println(exception);
		}
	}
}
