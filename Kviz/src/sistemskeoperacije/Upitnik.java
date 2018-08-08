package sistemskeoperacije;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baza.Baza;
import baza.Pitanje;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JSeparator;

public class Upitnik extends JFrame {

	private JPanel contentPane;
	
	public Pitanje pitanje = new Pitanje();
	private Baza lista= new Baza(); 
	private JPanel panel_1;
	private JLabel lblRB;
	private JTextField textFieldRB;
	private JLabel lblPitanje;
	private JTextField textFieldPitanje;
	private JTextField textFieldO1;
	private JTextField textFieldO2;
	private JTextField textFieldO3;
	private JTextField textFieldO4;
	private JTextArea textArea_1;
	private Button btnDodaj;
	private JSeparator separator;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upitnik frame = new Upitnik();
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
	public Upitnik() {
		createContents();
	}
	private void createContents() {
		setTitle("Pravljenje pitanja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
		contentPane.add(getScrollPane(), BorderLayout.SOUTH);
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblRB());
			panel_1.add(getTextField_3());
			panel_1.add(getLblPitanje());
			panel_1.add(getTextField_1_1());
			panel_1.add(getTextField_2_1());
			panel_1.add(getTextField_3_1());
			panel_1.add(getTextFieldO3());
			panel_1.add(getTextFieldO4());
			panel_1.add(getTextArea_1());
			panel_1.add(getBtnDodaj());
			panel_1.add(getSeparator());
		}
		return panel_1;
	}
	private JLabel getLblRB() {
		if (lblRB == null) {
			lblRB = new JLabel("Redni broj");
			lblRB.setBounds(10, 25, 72, 14);
		}
		return lblRB;
	}
	private JTextField getTextField_3() {
		if (textFieldRB == null) {
			textFieldRB = new JTextField();
			textFieldRB.setBounds(92, 22, 56, 20);
			textFieldRB.setColumns(10);
		}
		return textFieldRB;
	}
	private JLabel getLblPitanje() {
		if (lblPitanje == null) {
			lblPitanje = new JLabel("Pitanje:");
			lblPitanje.setBounds(10, 56, 46, 14);
		}
		return lblPitanje;
	}
	private JTextField getTextField_1_1() {
		if (textFieldPitanje == null) {
			textFieldPitanje = new JTextField();
			textFieldPitanje.setBounds(76, 53, 402, 20);
			textFieldPitanje.setColumns(10);
		}
		return textFieldPitanje;
	}
	private JTextField getTextField_2_1() {
		if (textFieldO1 == null) {
			textFieldO1 = new JTextField();
			textFieldO1.setBounds(76, 100, 182, 20);
			textFieldO1.setColumns(10);
		}
		return textFieldO1;
	}
	private JTextField getTextField_3_1() {
		if (textFieldO2 == null) {
			textFieldO2 = new JTextField();
			textFieldO2.setBounds(268, 100, 210, 20);
			textFieldO2.setColumns(10);
		}
		return textFieldO2;
	}
	private JTextField getTextFieldO3() {
		if (textFieldO3 == null) {
			textFieldO3 = new JTextField();
			textFieldO3.setBounds(76, 131, 182, 20);
			textFieldO3.setColumns(10);
		}
		return textFieldO3;
	}
	private JTextField getTextFieldO4() {
		if (textFieldO4 == null) {
			textFieldO4 = new JTextField();
			textFieldO4.setBounds(268, 131, 210, 20);
			textFieldO4.setColumns(10);
		}
		return textFieldO4;
	}
	private JTextArea getTextArea_1() {
		if (textArea_1 == null) {
			textArea_1 = new JTextArea();
			textArea_1.setBounds(10, 209, 557, 188);
		}
		return textArea_1;
	}
	private Button getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new Button("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pitanje.setRedniBroj(Integer.parseInt(textFieldRB.getText()));
					pitanje.setPitanje(textFieldPitanje.getText());
					pitanje.setOdgovor1(textFieldO1.getText());
					pitanje.setOdgovor2(textFieldO2.getText());
					pitanje.setOdgovor3(textFieldO3.getText());
					pitanje.setOdgovor4(textFieldO4.getText());
					
					if (pitanje.getRedniBroj()!=1)
						lista=SOUcitajIzFajla.izvrsi("data/lista");
					SODodajPitanje.izvrsi(pitanje, lista);
					SOSacuvajUFajl.izvrsi("data/lista", lista);
					textArea_1.setText(SOPrikazListe.izvrsi(lista));
					
				}
			});
			btnDodaj.setBounds(194, 167, 140, 22);
		}
		return btnDodaj;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setName("Lista Pitanja");
			separator.setBounds(10, 196, 493, 2);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
		}
		return scrollPane;
	}
}
