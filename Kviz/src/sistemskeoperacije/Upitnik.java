package sistemskeoperacije;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baza.Baza;
import baza.Odgovor;
import baza.Pitanje;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

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
	private Button btnDodaj;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JCheckBox chckbx1;
	private JCheckBox chckbx3;
	private JCheckBox chckbx2;
	private JCheckBox chckbx4;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JTextField textFieldFajl;
	private JButton btnOk;
	private JButton btnUcitajListu;

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
		setBounds(100, 100, 736, 464);
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
			panel_1.add(getBtnDodaj());
			panel_1.add(getSeparator());
			panel_1.add(getChckbx1());
			panel_1.add(getChckbx3());
			panel_1.add(getChckbx2());
			panel_1.add(getChckbx4());
			panel_1.add(getScrollPane_1());
			panel_1.add(getLblNewLabel());
			panel_1.add(getTextFieldFajl());
			panel_1.add(getBtnOk());
			panel_1.add(getBtnUcitajListu());
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
			textFieldRB.setEditable(false);
			textFieldRB.setEnabled(false);
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
			textFieldPitanje.setBounds(92, 53, 608, 20);
			textFieldPitanje.setColumns(10);
		}
		return textFieldPitanje;
	}
	private JTextField getTextField_2_1() {
		if (textFieldO1 == null) {
			textFieldO1 = new JTextField();
			textFieldO1.setBounds(10, 100, 230, 20);
			textFieldO1.setColumns(10);
		}
		return textFieldO1;
	}
	private JTextField getTextField_3_1() {
		if (textFieldO2 == null) {
			textFieldO2 = new JTextField();
			textFieldO2.setBounds(337, 100, 247, 20);
			textFieldO2.setColumns(10);
		}
		return textFieldO2;
	}
	private JTextField getTextFieldO3() {
		if (textFieldO3 == null) {
			textFieldO3 = new JTextField();
			textFieldO3.setBounds(10, 131, 230, 20);
			textFieldO3.setColumns(10);
		}
		return textFieldO3;
	}
	private JTextField getTextFieldO4() {
		if (textFieldO4 == null) {
			textFieldO4 = new JTextField();
			textFieldO4.setBounds(337, 131, 247, 20);
			textFieldO4.setColumns(10);
		}
		return textFieldO4;
	}
	private Button getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new Button("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String putanja = "data/"+textFieldFajl.getText();
				
					pitanje.setRedniBroj(Integer.parseInt(textFieldRB.getText()));
					pitanje.setPitanje(textFieldPitanje.getText());
					
					Odgovor o1 = new Odgovor();
					Odgovor o2 = new Odgovor();
					Odgovor o3 = new Odgovor();
					Odgovor o4 = new Odgovor();
					o1.setTekst(textFieldO1.getText());
					o1.setTacno(chckbx1.isSelected());
					o2.setTekst(textFieldO2.getText());
					o2.setTacno(chckbx2.isSelected());
					o3.setTekst(textFieldO3.getText());
					o3.setTacno(chckbx3.isSelected());
					o4.setTekst(textFieldO4.getText());
					o4.setTacno(chckbx4.isSelected());
					
					pitanje.setOdgovor1(o1);
					pitanje.setOdgovor2(o2);
					pitanje.setOdgovor3(o3);
					pitanje.setOdgovor4(o4);
					
					
					SODodajPitanje.izvrsi(pitanje, lista);
					SOSacuvajUFajl.izvrsi(putanja, lista);
					
					textArea.setText(SOPrikazListe.izvrsi(lista));
				}
			});
			btnDodaj.setBounds(303, 157, 140, 22);
		}
		return btnDodaj;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setName("Lista Pitanja");
			separator.setBounds(10, 196, 690, 2);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
		}
		return scrollPane;
	}
	private JCheckBox getChckbx1() {
		if (chckbx1 == null) {
			chckbx1 = new JCheckBox("Tacno");
			chckbx1.setBounds(246, 99, 85, 23);
		}
		return chckbx1;
	}
	private JCheckBox getChckbx3() {
		if (chckbx3 == null) {
			chckbx3 = new JCheckBox("Tacno");
			chckbx3.setBounds(246, 130, 85, 23);
		}
		return chckbx3;
	}
	private JCheckBox getChckbx2() {
		if (chckbx2 == null) {
			chckbx2 = new JCheckBox("Tacno");
			chckbx2.setBounds(603, 100, 97, 23);
		}
		return chckbx2;
	}
	private JCheckBox getChckbx4() {
		if (chckbx4 == null) {
			chckbx4 = new JCheckBox("Tacno");
			chckbx4.setBounds(603, 131, 97, 23);
		}
		return chckbx4;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 209, 690, 192);
			scrollPane_1.setViewportView(getTextArea());
		}
		return scrollPane_1;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Fajl");
			lblNewLabel.setBounds(213, 25, 46, 14);
		}
		return lblNewLabel;
	}
	private JTextField getTextFieldFajl() {
		if (textFieldFajl == null) {
			textFieldFajl = new JTextField();
			textFieldFajl.setBounds(266, 22, 177, 20);
			textFieldFajl.setColumns(10);
		}
		return textFieldFajl;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String putanja = "data/"+textFieldFajl.getText();
					
					File f = new File(putanja);
					if(!f.exists()) { 
						textFieldRB.setText("1");
					}else {
						lista=SOUcitajIzFajla.izvrsi(putanja);
						int broj = lista.getBrojPitanja()+1;
						textFieldRB.setText(""+broj);
					}
					
				}
			});
			btnOk.setBounds(462, 21, 91, 23);
		}
		return btnOk;
	}
	private JButton getBtnUcitajListu() {
		if (btnUcitajListu == null) {
			btnUcitajListu = new JButton("Ucitaj listu");
			btnUcitajListu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					String putanja = "data/"+textFieldFajl.getText();
					File f = new File(putanja);
					if(!f.exists()) 
						textArea.setText("Lista pitanja je prazna");
					else {
						lista=SOUcitajIzFajla.izvrsi(putanja);
						textArea.setText(SOPrikazListe.izvrsi(lista));
					}
				}
			});
			btnUcitajListu.setBounds(492, 162, 91, 23);
		}
		return btnUcitajListu;
	}
}
