package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import dao.AtletaDAO;
import dao.PatrocinadorDAO;
import dao.PruebaDAO;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import entidades.Atleta;
import entidades.Lugar;
import entidades.Patrocinador;
import entidades.Prueba;
import entidades.Resultado;
import utils.ConexBD;
import validaciones.Validaciones;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class CerrarPrueba extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int idprueba = 1;
					CerrarPrueba frame = new CerrarPrueba(idprueba);
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
	public CerrarPrueba(int idprueba) {
		PruebaDAO pDAO = new PruebaDAO(ConexBD.getCon());
		Prueba prueba = pDAO.buscarPorID(idprueba);
		if(prueba!=null) {
			setTitle("Cerrar Prueba" + idprueba);
		}
		else
		setTitle("Cerrar Prueba INDETERMINADA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos de la prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 424, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);



		textField = new JTextField(""+prueba.getId());
		textField.setBounds(86, 14, 86, 20);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);



		textFieldNombre = new JTextField(prueba.getNombre());
		textFieldNombre.setBounds(86, 41, 261, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);



		JComboBox comboBoxLugar = new JComboBox();
		comboBoxLugar.setBounds(245, 69, 169, 22);
		panel_1.add(comboBoxLugar);
		comboBoxLugar.setEnabled(false);
		comboBoxLugar.setModel(new DefaultComboBoxModel(Lugar.values()));

		JPanel panel = new JPanel();
		panel.setBounds(22, 98, 210, 52);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tipo de Prueba:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JRadioButton rbIndividual = new JRadioButton("Individual");
	
		rbIndividual.setEnabled(false);
		buttonGroupTipo.add(rbIndividual);
		panel.add(rbIndividual);

		JRadioButton rbEquipos = new JRadioButton("Por Equipos");
		rbEquipos.setEnabled(false);
		buttonGroupTipo.add(rbEquipos);
		panel.add(rbEquipos);
		if(prueba.isIndividual()) 
			rbIndividual.setSelected(true);
		else
			rbEquipos.setSelected(true);
		
		
		/**
		 * LABELS INTERFAZ
		 */
		
		JLabel lblIdPrueba = new JLabel("IdPrueba:");
		lblIdPrueba.setBounds(22, 21, 77, 14);
		panel_1.add(lblIdPrueba);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 48, 77, 14);
		panel_1.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 73, 46, 14);
		panel_1.add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(200, 73, 46, 14);
		panel_1.add(lblLugar);
		
		JLabel lblPatrocinador = new JLabel("Patrocinador:");
		lblPatrocinador.setBounds(22, 161, 87, 14);
		panel_1.add(lblPatrocinador);

		JLabel lblprimerpuesto = new JLabel("Primer puesto *:");
		lblprimerpuesto.setBounds(27, 251, 109, 14);
		contentPane.add(lblprimerpuesto);

		JLabel lblsegundopuesto = new JLabel("Segundo puesto *:");
		lblsegundopuesto.setBounds(27, 343, 109, 14);
		contentPane.add(lblsegundopuesto);

		JLabel lbltercerpuesto = new JLabel("Tercer puesto *:");
		lbltercerpuesto.setBounds(27, 427, 109, 14);
		contentPane.add(lbltercerpuesto);

		JLabel lblNewLabel = new JLabel("Horas:");
		lblNewLabel.setBounds(27, 276, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Minutos:");
		lblNewLabel_1.setBounds(109, 276, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Segundos:");
		lblNewLabel_2.setBounds(202, 276, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Centésimas");
		lblNewLabel_3.setBounds(302, 276, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Id Oro *:");
		lblNewLabel_4.setBounds(27, 301, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Horas:");
		lblNewLabel_5.setBounds(27, 368, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Minutos:");
		lblNewLabel_6.setBounds(109, 368, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Segundos:");
		lblNewLabel_7.setBounds(203, 368, 60, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Centésimas:");
		lblNewLabel_8.setBounds(302, 368, 61, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Id Plata *:");
		lblNewLabel_9.setBounds(27, 391, 61, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Horas");
		lblNewLabel_10.setBounds(27, 452, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Minutos: ");
		lblNewLabel_11.setBounds(109, 452, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Segundos:");
		lblNewLabel_12.setBounds(202, 452, 61, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Centésimas:");
		lblNewLabel_13.setBounds(302, 452, 61, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Establecer como DEFINITIVO:");
		lblNewLabel_14.setBounds(27, 508, 154, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Id Bronce *:");
		lblNewLabel_15.setBounds(27, 477, 72, 14);
		contentPane.add(lblNewLabel_15);
		
		/**
		 * SPINNERS TIEMPO
		 */
		JSpinner horasPrimerspinner = new JSpinner();
		horasPrimerspinner.setBounds(69, 273, 30, 20);
		contentPane.add(horasPrimerspinner);
		
		JSpinner minPrimerspinner = new JSpinner();
		minPrimerspinner.setBounds(162, 273, 30, 20);
		contentPane.add(minPrimerspinner);
		
		JSpinner segPrimerspinner = new JSpinner();
		segPrimerspinner.setBounds(262, 273, 30, 20);
		contentPane.add(segPrimerspinner);

		JSpinner centPrimerSpinner = new JSpinner();
		centPrimerSpinner.setBounds(370, 273, 30, 20);
		contentPane.add(centPrimerSpinner);
		
		JSpinner horasSegunspinner = new JSpinner();
		horasSegunspinner.setBounds(69, 365, 30, 20);
		contentPane.add(horasSegunspinner);
		
		JSpinner minSegspinner = new JSpinner();
		minSegspinner.setBounds(162, 365, 30, 20);
		contentPane.add(minSegspinner);
		
		JSpinner SegSegspinner = new JSpinner();
		SegSegspinner.setBounds(262, 365, 30, 20);
		contentPane.add(SegSegspinner);
		
		JSpinner centSegspinner = new JSpinner();
		centSegspinner.setBounds(370, 365, 30, 20);
		contentPane.add(centSegspinner);
		
		JSpinner horasTerspinner = new JSpinner();
		horasTerspinner.setBounds(69, 449, 30, 20);
		contentPane.add(horasTerspinner);
		
		JSpinner minTerspinner = new JSpinner();
		minTerspinner.setBounds(162, 449, 30, 20);
		contentPane.add(minTerspinner);
		
		JSpinner segTerspinner = new JSpinner();
		segTerspinner.setBounds(262, 449, 30, 20);
		contentPane.add(segTerspinner);
		
		JSpinner centTerspinner = new JSpinner();
		centTerspinner.setBounds(370, 449, 30, 20);
		contentPane.add(centTerspinner);
		
		
		
		/***
		 * COMBOBOX INTRODUCIR PUESTOS
		 */
		
		AtletaDAO atDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletasList = (ArrayList<Atleta>) atDAO.buscarTodos();
		
		String[] atletasStr1 = new String[atletasList.size()];
		atletasStr1[0] = "NINGUNO";
		for (int i = 0; i < atletasList.size(); i++)
			atletasStr1[i + 1] = atletasList.get(i).toString();
		
		
		
		JComboBox<Atleta> comboBoxPuesto1 = new JComboBox<Atleta>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(atletasStr1));		
		lblprimerpuesto.setLabelFor(comboBoxPuesto1);
		comboBoxPuesto1.setBounds(140, 247, 287, 22);
		contentPane.add(comboBoxPuesto1);
		
		JComboBox<Atleta> comboBoxPuesto2 = new JComboBox<Atleta>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(atletasStr1));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBoxPuesto2.setBounds(140, 339, 287, 22);
		contentPane.add(comboBoxPuesto2);

		JComboBox<Atleta> comboBoxPuesto3 = new JComboBox<Atleta>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(atletasStr1));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBoxPuesto3.setBounds(140, 423, 287, 22);
		contentPane.add(comboBoxPuesto3);

		
		/**
		 * COMBOBOX ID ORO, PLATA, BRONCE
		 */
		/*ResultadoDAO resultDAO = new ResultadoDAO(ConexBD.getCon());
		ArrayList<Atleta> atletasList = (ArrayList<Atleta>) resultadoDAO.buscarTodos();
		
		String[] atletasStr1 = new String[atletasList.size()];
		atletasStr1[0] = "NINGUNO";
		for (int i = 0; i < atletasList.size(); i++)
		atletasStr1[i + 1] = atletasList.get(i).getPersona().data();
		*/	
		
		JComboBox comboBoxPrimerIdoro = new JComboBox();
		comboBoxPrimerIdoro.setBounds(79, 297, 76, 22);
		contentPane.add(comboBoxPrimerIdoro);
		
		JComboBox idPlatacomboBox = new JComboBox();
		idPlatacomboBox.setBounds(79, 387, 76, 22);
		contentPane.add(idPlatacomboBox);
		
		JComboBox idBroncecomboBox = new JComboBox();
		idBroncecomboBox.setBounds(91, 475, 76, 22);
		contentPane.add(idBroncecomboBox);
		
		
		
		
		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

		/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
		/// el model del comboBox
		DefaultComboBoxModel<Patrocinador> patrocinadoresModel = new DefaultComboBoxModel<Patrocinador>();
		JComboBox<Patrocinador> comboBoxPatrocinador = new JComboBox<Patrocinador>(patrocinadoresModel);
		PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
		ArrayList<Patrocinador> patrocinadoresList = (ArrayList<Patrocinador>) patDAO.buscarTodos();
		for (Patrocinador pat : patrocinadoresList)
			comboBoxPatrocinador.addItem(pat);

		/// Pero el modelo de comboBox básico requiere Strings
		String[] patrocinadoresStr = new String[patrocinadoresList.size()];
		for (int i = 0; i < patrocinadoresList.size(); i++)
			patrocinadoresStr[i] = patrocinadoresList.get(i).mostrarBasico();
		comboBoxPatrocinador.setModel(new DefaultComboBoxModel(patrocinadoresStr));
		comboBoxPatrocinador.setBounds(96, 157, 261, 22);
		panel_1.add(comboBoxPatrocinador);
		comboBoxPatrocinador.setEnabled(false);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(86, 69, 86, 20);
		panel_1.add(spinnerFecha);
		spinnerFecha.setEnabled(false);
		spinnerFecha.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));

		
		/*
		 * Cuando se pulsa boton aceptar: 
		 */
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				
				valido = (comboBoxPuesto1.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe de seleccionar el Atleta ganador de la prueba";
					lblprimerpuesto.setForeground(Color.RED);
				} 
				valido = false;
				valido = (comboBoxPuesto2.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe de seleccionar el Atleta que obtuvo el segundo puesto";
					lblsegundopuesto.setForeground(Color.RED);
				}
				valido = false;
				valido = (comboBoxPuesto3.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe de seleccionar el Atleta que obtuvo el segundo puesto";
					lbltercerpuesto.setForeground(Color.RED);
				}
				AtletaDAO atlDAO = new AtletaDAO(ConexBD.getCon());
				String seleccionado = (String) comboBoxPuesto1.getSelectedItem();
				String[] aux = seleccionado.split("\\.");
				long idAtl = Long.valueOf(aux[0]);
				Atleta atleta = atlDAO.buscarPorID(idAtl);
				ConexBD.cerrarConexion();
				if (atleta == null)
					valido = false;
				
				
				String seleccionado2 = (String) comboBoxPuesto2.getSelectedItem();
				String seleccionado3 = (String) comboBoxPuesto3.getSelectedItem();
				valido = false;
				if (seleccionado == seleccionado2 || seleccionado == seleccionado3 || seleccionado2 == seleccionado3) {
					errores += "No puede seleccionar el mismo Atleta en puestos diferentes, seleccione Atletas difrentes";
					if (seleccionado == seleccionado2) {
						lblprimerpuesto.setForeground(Color.RED);
						lblsegundopuesto.setForeground(Color.RED);
					} else if (seleccionado == seleccionado3) {
						lblprimerpuesto.setForeground(Color.RED);
						lbltercerpuesto.setForeground(Color.RED);
					} else {
						lblsegundopuesto.setForeground(Color.RED);
						lbltercerpuesto.setForeground(Color.RED);
					}
				}
			
				
				
				
				valido = errores.isEmpty();

				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}

				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
				boolean correcto = pruebadao.modificar(prueba);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				if (!correcto) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al cerrar la Prueba en la BD";
					msj = "Hubo un error y NO se ha cerrado la prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					titulo = "Prueba "+prueba.getId()+" cerrada en la BD";
					msj = "Se ha cerrado correctamente la  prueba:\n" + prueba.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
					/// Aqui se redirigiría al usuario hacia la pantalla principal
					/// TODO
				}
			}
		});
		
		
		buttonAceptar.setBounds(233, 532, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}

			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		buttonCancelar.setBounds(332, 532, 89, 23);
		contentPane.add(buttonCancelar);
		

		

		


		JRadioButton botonDef = new JRadioButton("");
		botonDef.setBounds(172, 499, 30, 23);
		contentPane.add(botonDef);
		



	}
}
