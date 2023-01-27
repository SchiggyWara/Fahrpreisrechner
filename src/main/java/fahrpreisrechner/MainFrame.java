package fahrpreisrechner;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fahrpreisrechner.repository.Dao;
import fahrpreisrechner.repository.entities.Kunde;
import fahrpreisrechner.repository.entities.Scooter;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private static Dao dao;
	private JTextField result;
	private JTextField txtRabattcode;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dao = new Dao();
					dao.setJdbi(dao.createConnection());
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Scooter-Combobox
		List<Scooter> scootersKomplett = dao.getScooters();
		String[] scooters = scootersKomplett.stream().map(e -> e.getbezeichnung()).toArray(String[]::new);
		JComboBox scooter = new JComboBox(scooters);
		scooter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		scooter.setBounds(42, 40, 124, 19);
		scooter.setEditable(true);
		contentPane.add(scooter);

		// Kunden-Combobox
		List<Kunde> kundenKomplett = dao.getKunden();
		String[] kundenNamen = kundenKomplett.stream().map(e -> e.getNachname()).toArray(String[]::new);
		JComboBox kunden = new JComboBox(kundenNamen);
		kunden.setBounds(42, 84, 124, 19);
		kunden.setEditable(true);
		contentPane.add(kunden);

		// Einheit-ComboBox
		Enum[] einheiten = Einheit.values();
		JComboBox einheit = new JComboBox(einheiten);
		einheit.setBounds(42, 133, 124, 19);
		contentPane.add(einheit);

		// TextField für Eingabe-Wert (Zeit oder Strecke)
		textField = new JTextField();
		textField.setBounds(30, 211, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		// Button berechnen
		JButton berechnen = new JButton("berechnen");
		berechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ergebnis = 0;
				Einheit ein = (Einheit) einheit.getSelectedItem();
				double value = Double.parseDouble(textField.getText());
				switch (ein) {
				case ZEIT:
					ergebnis = Rechner.berechnePreisMinuten(value);
					break;
				case STRECKE:
					ergebnis = Rechner.berechnePreisKilometer(value);
					break;
				}
				if (txtRabattcode.getText().equals("scooteq2023")) ergebnis *= 0.80;
				result.setText(String.valueOf(ergebnis));
			}
		});
		berechnen.setBounds(30, 242, 124, 21);
		contentPane.add(berechnen);

		JLabel lblNewLabel = new JLabel("Ergebnis");
		lblNewLabel.setBounds(42, 269, 96, 33);
		contentPane.add(lblNewLabel);
		
		
		result = new JTextField();
		result.setBounds(32, 296, 124, 19);
		contentPane.add(result);
		result.setColumns(10);
		
		txtRabattcode = new JTextField();
		txtRabattcode.setText("Rabattcode");
		txtRabattcode.setBounds(166, 211, 114, 19);
		contentPane.add(txtRabattcode);
		txtRabattcode.setColumns(10);

	}
}
