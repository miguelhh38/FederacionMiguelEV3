import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class swing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing frame = new swing();
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
	public swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 424, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("NUEVO TIEMPO");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Horas:");
		lblNewLabel_1.setBounds(20, 52, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Minutos:");
		lblNewLabel_2.setBounds(135, 52, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(58, 49, 30, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(181, 49, 30, 20);
		contentPane.add(spinner_1);
		
		JLabel lblNewLabel_3 = new JLabel("Segundos:");
		lblNewLabel_3.setBounds(20, 94, 63, 14);
		contentPane.add(lblNewLabel_3);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(82, 91, 30, 20);
		contentPane.add(spinner_2);
		
		JLabel lblNewLabel_4 = new JLabel("Centésimas:");
		lblNewLabel_4.setBounds(135, 94, 63, 14);
		contentPane.add(lblNewLabel_4);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(208, 91, 30, 20);
		contentPane.add(spinner_3);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(298, 191, 89, 23);
		contentPane.add(btnNewButton);
	}
}
