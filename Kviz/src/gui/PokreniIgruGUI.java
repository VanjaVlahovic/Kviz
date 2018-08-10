package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baza.Baza;
import baza.Odgovor;
import baza.Pitanje;
import sistemskeoperacije.SOUcitajIzFajla;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class PokreniIgruGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JRadioButton rdb1;
	private JRadioButton rdb2;
	private JRadioButton rdb3;
	private JRadioButton rdb4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnPotvrdi;
	private JRadioButtonMenuItem rdbMatematika;
	private JRadioButtonMenuItem rdbIstorija;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnDalje;
	private JLabel label;
	private JTextField textFieldPoruka;
	private JLabel lblTacni;
	private JLabel lblUkupno;
	private JProgressBar progressBar;
	private JLabel label_1;
	private JLabel lblBrTacnih;
	private int brojTacnih;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokreniIgruGUI frame = new PokreniIgruGUI();
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
	public PokreniIgruGUI() {
		createContents();
	}
	private void createContents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 460);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getRdb1());
		contentPane.add(getRdb2());
		contentPane.add(getRdb3());
		contentPane.add(getRdb4());
		contentPane.add(getBtnPotvrdi());
		contentPane.add(getBtnDalje());
		contentPane.add(getLabel());
		contentPane.add(getTextFieldPoruka());
		contentPane.add(getLblTacni());
		contentPane.add(getLblUkupno());
		contentPane.add(getProgressBar());
		contentPane.add(getLabel_1());
		contentPane.add(getLblBrTacnih());
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Kategorija");
			mnNewMenu.add(getRdbMatematika());
			mnNewMenu.add(getRdbIstorija());
		}
		return mnNewMenu;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 70, 304, 98);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JRadioButton getRdb1() {
		if (rdb1 == null) {
			rdb1 = new JRadioButton("");
			buttonGroup.add(rdb1);
			rdb1.setBounds(10, 186, 197, 23);
		}
		return rdb1;
	}
	private JRadioButton getRdb2() {
		if (rdb2 == null) {
			rdb2 = new JRadioButton("");
			buttonGroup.add(rdb2);
			rdb2.setBounds(10, 212, 189, 23);
		}
		return rdb2;
	}
	private JRadioButton getRdb3() {
		if (rdb3 == null) {
			rdb3 = new JRadioButton("");
			buttonGroup.add(rdb3);
			rdb3.setBounds(10, 238, 197, 23);
		}
		return rdb3;
	}
	private JRadioButton getRdb4() {
		if (rdb4 == null) {
			rdb4 = new JRadioButton("");
			buttonGroup.add(rdb4);
			rdb4.setBounds(10, 264, 197, 23);
		}
		return rdb4;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("");
			btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean t;
					Baza lista = ucitavanjeListe();
					int broj = Integer.parseInt(label.getText());
					Pitanje p = lista.vratiListu().get(broj-1);
					t = proveraOdgovora(p);
					if (t)
						brojTacnih++;
					lblBrTacnih.setText(""+brojTacnih);
					btnPotvrdi.setEnabled(false);
					btnDalje.setEnabled(true);
				}
			});
			btnPotvrdi.setBounds(211, 217, 66, 54);
		}
		return btnPotvrdi;
	}
	private JRadioButtonMenuItem getRdbMatematika() {
		if (rdbMatematika == null) {
			rdbMatematika = new JRadioButtonMenuItem("Matematika");
			buttonGroup_1.add(rdbMatematika);
			rdbMatematika.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPotvrdi.setEnabled(true);
					brojTacnih=0;
					lblBrTacnih.setText(""+brojTacnih);
					Baza lista = ucitavanjeListe();
					progressBar.setMaximum(lista.getBrojPitanja());
					progressBar.setValue(0);
					lblUkupno.setText(""+lista.getBrojPitanja());
					label.setText("1");
					UzimanjePitanja(lista, 0);
				}
			});
		}
		return rdbMatematika;
	}
	private JRadioButtonMenuItem getRdbIstorija() {
		if (rdbIstorija == null) {
			rdbIstorija = new JRadioButtonMenuItem("Istorija");
			buttonGroup_1.add(rdbIstorija);
			rdbIstorija.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPotvrdi.setEnabled(true);
					brojTacnih=0;
					lblBrTacnih.setText(""+brojTacnih);
					Baza lista = ucitavanjeListe();
					progressBar.setMaximum(lista.getBrojPitanja());
					progressBar.setValue(0);
					lblUkupno.setText(""+lista.getBrojPitanja());
					label.setText("1");
					UzimanjePitanja(lista, 0);
				}
			});
		}
		return rdbIstorija;
	}
	private JButton getBtnDalje() {
		if (btnDalje == null) {
			btnDalje = new JButton("Dalje");
			btnDalje.setEnabled(false);
			btnDalje.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnPotvrdi.setEnabled(true);
					Baza lista = ucitavanjeListe();
					int broj = Integer.parseInt(label.getText());
					if (broj<lista.getBrojPitanja()) {
						UzimanjePitanja(lista, broj);
						label.setText(""+(broj+1));
					}else {
						textFieldPoruka.setText("");
						textArea.setText("Kraj");
						buttonGroup.clearSelection();
						btnPotvrdi.setEnabled(false);
						btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
					}
					btnDalje.setEnabled(false);
					progressBar.setValue(progressBar.getValue()+1);
				}
			});
			btnDalje.setBounds(105, 352, 91, 23);
		}
		return btnDalje;
	}
	
	private void UzimanjePitanja(Baza lista, int redniBroj) {
		btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		buttonGroup.clearSelection();
		textFieldPoruka.setText("");
		Pitanje p = lista.vratiListu().get(redniBroj);
		textArea.setText(p.getPitanje());
		rdb1.setText(p.getOdgovor1().getTekst());
		rdb2.setText(p.getOdgovor2().getTekst());
		rdb3.setText(p.getOdgovor3().getTekst());
		rdb4.setText(p.getOdgovor4().getTekst());
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(173, 36, 23, 14);
		}
		return label;
	}
	
	private Baza ucitavanjeListe() {
		Baza lista = new Baza();
		if (rdbIstorija.isSelected())
			lista = SOUcitajIzFajla.izvrsi("data/Istorija");
		if (rdbMatematika.isSelected())
			lista = SOUcitajIzFajla.izvrsi("data/Matematika");
		return lista;
	}
	
	
	public boolean proveraOdgovora(Pitanje p) {
		boolean t = false;
		Odgovor o = nadjiTacan(p);
		if (rdb1.isSelected())
			if (p.getOdgovor1().isTacno()) {
				btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
				textFieldPoruka.setText("Tacno!!! :D");
				t = true;
			}else {
				btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
				textFieldPoruka.setText("Tacan odgovor: "+o.getTekst());
			}
		if (rdb2.isSelected())
			if( p.getOdgovor2().isTacno()) {
				btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
				textFieldPoruka.setText("Tacno!!! :D");
				t = true;
			}else {
				btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
				textFieldPoruka.setText("Tacan odgovor: "+o.getTekst());
			}
		if (rdb3.isSelected()) 
			if( p.getOdgovor3().isTacno()) {
				btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
				textFieldPoruka.setText("Tacno!!! :D");
				t = true;
			}else {
				btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
				textFieldPoruka.setText("Tacan odgovor: "+o.getTekst());
			}
		if (rdb4.isSelected()) 
			if( p.getOdgovor4().isTacno()) {
				btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
				textFieldPoruka.setText("Tacno!!! :D");
				t = true;
			}else {
				btnPotvrdi.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
				textFieldPoruka.setText("Tacan odgovor: "+o.getTekst());
			}
		return t;
		}
	private JTextField getTextFieldPoruka() {
		if (textFieldPoruka == null) {
			textFieldPoruka = new JTextField();
			textFieldPoruka.setBounds(10, 287, 304, 23);
			textFieldPoruka.setColumns(10);
		}
		return textFieldPoruka;
	}
	public Odgovor nadjiTacan(Pitanje p) {
		if (p.getOdgovor1().isTacno())
			return p.getOdgovor1();
		if (p.getOdgovor2().isTacno())
			return p.getOdgovor2();
		if (p.getOdgovor3().isTacno())
			return p.getOdgovor3();
		else
			return p.getOdgovor4();		
	}
	private JLabel getLblTacni() {
		if (lblTacni == null) {
			lblTacni = new JLabel("Tacni:");
			lblTacni.setBounds(173, 11, 46, 14);
		}
		return lblTacni;
	}
	private JLabel getLblUkupno() {
		if (lblUkupno == null) {
			lblUkupno = new JLabel("");
			lblUkupno.setBounds(199, 36, 48, 14);
		}
		return lblUkupno;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setForeground(Color.BLUE);
			progressBar.setBorder(UIManager.getBorder("ProgressBar.border"));
			progressBar.setBounds(10, 36, 150, 16);
			
		}
		return progressBar;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("/");
			label_1.setBounds(194, 36, 11, 14);
		}
		return label_1;
	}
	private JLabel getLblBrTacnih() {
		if (lblBrTacnih == null) {
			lblBrTacnih = new JLabel("");
			lblBrTacnih.setBounds(221, 11, 46, 14);
		}
		return lblBrTacnih;
	}
}
