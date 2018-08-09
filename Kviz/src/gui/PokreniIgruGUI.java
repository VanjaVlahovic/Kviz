package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baza.Baza;
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

public class PokreniIgruGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNewButton;
	private JRadioButtonMenuItem rdbtnmntmMinja;
	private JRadioButtonMenuItem rdbtnmntmNikola;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

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
		contentPane.add(getRdbtnNewRadioButton());
		contentPane.add(getRdbtnNewRadioButton_1());
		contentPane.add(getRdbtnNewRadioButton_2());
		contentPane.add(getRdbtnNewRadioButton_3());
		contentPane.add(getBtnNewButton());
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
			mnNewMenu.add(getRdbtnmntmMinja());
			mnNewMenu.add(getRdbtnmntmNikola());
		}
		return mnNewMenu;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 47, 304, 98);
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
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("");
			buttonGroup.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setBounds(10, 186, 109, 23);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("");
			buttonGroup.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setBounds(10, 212, 109, 23);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("");
			buttonGroup.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setBounds(10, 238, 109, 23);
		}
		return rdbtnNewRadioButton_2;
	}
	private JRadioButton getRdbtnNewRadioButton_3() {
		if (rdbtnNewRadioButton_3 == null) {
			rdbtnNewRadioButton_3 = new JRadioButton("");
			buttonGroup.add(rdbtnNewRadioButton_3);
			rdbtnNewRadioButton_3.setBounds(10, 264, 109, 23);
		}
		return rdbtnNewRadioButton_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Baza lista = SOUcitajIzFajla.izvrsi("data/Minja");
					Pitanje p = lista.vratiListu().get(0);
					if (rdbtnNewRadioButton.isSelected())
						if (p.getOdgovor1().isTacno())
							btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
						else
							btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
					if (rdbtnNewRadioButton_1.isSelected())
						if( p.getOdgovor2().isTacno())
							btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
						else
							btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
					if (rdbtnNewRadioButton_2.isSelected()) 
						if( p.getOdgovor3().isTacno())
							btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
						else
							btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
					if (rdbtnNewRadioButton_3.isSelected()) 
						if( p.getOdgovor4().isTacno())
							btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
						else
							btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
				}
			});
			btnNewButton.setBounds(211, 217, 66, 54);
		}
		return btnNewButton;
	}
	private JRadioButtonMenuItem getRdbtnmntmMinja() {
		if (rdbtnmntmMinja == null) {
			rdbtnmntmMinja = new JRadioButtonMenuItem("Minja");
			buttonGroup_1.add(rdbtnmntmMinja);
			rdbtnmntmMinja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
					buttonGroup.clearSelection();
					Baza lista = SOUcitajIzFajla.izvrsi("data/Minja");
					Pitanje p = lista.vratiListu().get(0);
					textArea.setText(p.getPitanje());
					rdbtnNewRadioButton.setText(p.getOdgovor1().getTekst());
					rdbtnNewRadioButton_1.setText(p.getOdgovor2().getTekst());
					rdbtnNewRadioButton_2.setText(p.getOdgovor3().getTekst());
					rdbtnNewRadioButton_3.setText(p.getOdgovor4().getTekst());
				}
			});
		}
		return rdbtnmntmMinja;
	}
	private JRadioButtonMenuItem getRdbtnmntmNikola() {
		if (rdbtnmntmNikola == null) {
			rdbtnmntmNikola = new JRadioButtonMenuItem("Nikola");
			buttonGroup_1.add(rdbtnmntmNikola);
			rdbtnmntmNikola.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton.setIcon(new ImageIcon(PokreniIgruGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
					buttonGroup.clearSelection();
					Baza lista = SOUcitajIzFajla.izvrsi("data/Nikola");
					Pitanje p = lista.vratiListu().get(0);
					textArea.setText(p.getPitanje());
					rdbtnNewRadioButton.setText(p.getOdgovor1().getTekst());
					rdbtnNewRadioButton_1.setText(p.getOdgovor4().getTekst());
					rdbtnNewRadioButton_2.setText(p.getOdgovor2().getTekst());
					rdbtnNewRadioButton_3.setText(p.getOdgovor3().getTekst());
				}
			});
		}
		return rdbtnmntmNikola;
	}
}
