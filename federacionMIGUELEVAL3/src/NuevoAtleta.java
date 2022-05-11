import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entidades.Atleta;
import entidades.DatosPersona;
import validaciones.Validaciones;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class NuevoAtleta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoAtleta frame = new NuevoAtleta();
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
	public NuevoAtleta() {
		setTitle("Nuevo Atleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos Persona");
		lblNewLabel.setBounds(5, 5, 424, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre *:");
		lblNewLabel_1.setBounds(39, 30, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Documentacion *:");
		lblNewLabel_2.setBounds(10, 55, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Seleccione el valor e ingrese el valor:");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(39, 80, 185, 20);
		contentPane.add(lblNewLabel_3);
		

		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NIF");
		rdbtnNewRadioButton.setBounds(230, 76, 43, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NIE");
		rdbtnNewRadioButton_1.setBounds(275, 76, 44, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		

		
		JLabel lblNewLabel_4 = new JLabel("Teléfono:");
		lblNewLabel_4.setBounds(10, 111, 56, 14);
		contentPane.add(lblNewLabel_4);
		

		
		JLabel lblNewLabel_5 = new JLabel("Fecha Nacimiento *:");
		lblNewLabel_5.setBounds(10, 148, 111, 14);
		contentPane.add(lblNewLabel_5);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1652133600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(118, 145, 109, 20);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_6 = new JLabel("Datos Físicos:");
		lblNewLabel_6.setBounds(5, 183, 100, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(98, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(61, 108, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Altura *:");
		lblNewLabel_7.setBounds(20, 205, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Peso *:");
		lblNewLabel_8.setBounds(20, 230, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 202, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(76, 227, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Equipo:");
		lblNewLabel_9.setBounds(20, 279, 46, 14);
		contentPane.add(lblNewLabel_9);
		

		
		JLabel lblNewLabel_10 = new JLabel("m. en formato(xx,xx)");
		lblNewLabel_10.setBounds(184, 205, 121, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("kg. en formato(xx,xx)");
		lblNewLabel_11.setBounds(184, 230, 111, 14);
		contentPane.add(lblNewLabel_11);
		
		
		
		
		
		
		
		
		/**
		 * BOTON ACEPTAR
		 */
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(184, 324, 89, 23);
		contentPane.add(buttonAceptar);
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosPersona nueva = new DatosPersona();
				Atleta nuevo = new Atleta();
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				String nombre = textField.getText();
				valido = Validaciones.validarNombre(nombre);
				if (!valido) {
					errores += "El nombre del equipo no es valido (5-50 caracteres";
					lblNewLabel_1.setForeground(Color.RED);
				} else
					nueva.setNombre(nombre);
				valido = false;
				
				
			// y asi con todos los campos para validar cuando se de al boton de aceptar
				
			}


		});
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(296, 324, 89, 23);
		contentPane.add(buttonCancelar);
		

		
		JComboBox comboBoxEquipo = new JComboBox();
		comboBoxEquipo.setBounds(76, 275, 86, 22);
		contentPane.add(comboBoxEquipo);
		
		/**
		 * COMBOBOX
		 */
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
