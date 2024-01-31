package progBd;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Color;

public class Interfaccia_progetto extends JFrame {

	
	private JPanel contentPane;
	private JPanel op_1;
	private JPanel op_2,rimuovi_bibita ; 
	private JPanel op_3, op_4,op_5,aggiungi_pietanza,aggiungi_bibita,op_7,op_8,op_9,op_10,op_11,op_12,op_13,op_14,op_15,op_16,op_17,op_18,op_19,op_20,op_21,op_22,op_23;
	private JLayeredPane layeredPane;
	private JLabel registrazione;
	private JTextField nome;
	private JTextField cognome;
	private JPasswordField password;
	private JTextField email;
	private JTextField indirizzo;
	private JTextField telefono;
	private JTextField nome_locale;
	private JTextField indirizzo_locale;
	private JTextField tipologia;
	private JTextField telefono_locale;
	private JTextField nome_fattorino;
	private JTextField cognome_fattorino;
	private JTextField cf_fattorino;
	private JTextField indirizzo_locale_fattorino;
	private JTextField nome_locale_fattorino;
	private JTextField telefono_fattorino;
	private JTextField email_recensione;
	private JTextField commento;
	private JTextField nome_locale_recensione;
	private JTextField indirizzo_locale_recensione;
	private JTextField nome_menu;
	private JTextField nome_locale_menu;
	private JTextField indirizzo_locale_menu;
	private JTextField nome_pietanza;
	private JTextField prezzo_pietanza;
	private JTextField nome_locale_fc;
	private JTextField indirizzo_locale_fc;
	private JTextField email_fc;
	private JTextField codice_coupon;
	private JTextField data_inizio_coupon;
	private JTextField scadenza_coupon;
	private JTextField spesa_minima;
	private JTextField valore_sconto;
	private JTextField nome_locale_coupon;
	private JTextField indirizzo_locale_coupon;
	private JLabel codice_fc;
	private JTable table;
	private JTextField email_fc_visualizza;
	private JTextField email_num_ordini;
	private JTable tab_num_ordini;
	private JTextField codice_scopri_fattorino;
	private JTable tab_fattorino;
	private JTextField codice_visualizza_prodotti;
	private JTable tab_prodotti;
	private JTable tab_locali_media;
	private JTextField città_ricerca;
	private JTable tab_cerca_locali;
	private JTextField codice_riepilogo;
	private JTable tab_riepilogo_ordine;
	private JTextField nome_locale_rim_p;
	private JTextField indirizzo_locale_rim_p;
	private JTextField nome_menu_rim_p;
	private JTextField nome_pietanza_rim_p;
	private JPanel rimuovi_pietanza;
	private JTextField nome_locale_rim_b;
	private JTextField indirizzo_locale_rim_b;
	private JTextField nome_menu_rim_b;
	private JTextField nome_bibita_rim_b;
	private JTextField nome_locale_visualizza_menu;
	private JTextField indirizzo_locale_visualizza_menu;
	private JTable tab_visualizza_menu;
	private JPanel panel_mod_p;
	private JPanel panel_mod_b;
	private JTextField nome_pietanza_mod;
	private JTextField nome_locale_mod_p;
	private JTextField indirizzo_locale_mod_p;
	private JTextField nuovo_prezzo_b;
	private JTextField nuovo_prezzo_p;
	private JTextField nome_bibita_mod;
	private JTextField nome_locale_mod_b;
	private JTextField indirizzo_locale_mod_b;
	private JTextField nome_locale_bibite_a;
	private JTextField indirizzo_locale_bibite_a;
	private JTable tab_bibite_a;
	private JTextField nome_pietanza_ingr;
	private JTable tab_ingr;
	private JTextField nome_menù_prodotti;
	private JTextField nome_locale_prodotti;
	private JTextField indirizzo_locale_prodotti;
	private JTable tab_prodotti_menu;
	private JTable tab_vantaggi;
	private JTextField nome_locale_resoconto;
	private JTextField indirizzo_locale_resoconto;
	private JTextField nome_prodotto_resoconto;
	private JTextField data_resoconto;
	private JTable tab_resoconto;
	private JLabel vincoli_password;
	private JTextField nome_menu_bibita;
	private JTextField nome_locale_menu_bibita;
	private JTextField indirizzo_locale_menu_bibita;
	private JTextField nome_bibita;
	private JTextField prezzo_bibita;
	private JPanel op_6;
	private JTextField nome_menù_mod_p;
	private JTextField nome_menu_mod_b;
	private JTextField email_effettua_ordine;
	private JTextField nome_locale_effettua_ordine;
	private JTextField indirizzo_locale_effettua_ordine;
	private JTextField nome_menu_p_effettua_ordine;
	private JTextField nome_menu_b_effettua_ordine;
	private JTextField codice_fc_effettua_ordine;
	private JPanel Applica_fc;
	private JTextField codice_coupon_eff_ordine;
	private JPanel Inserisci_coupon;
	private JPanel Completa_ordine;
	private JTextField fatt_consegna;
	private JTextField orario_previsto;
	private JPanel Area_locale_ordine;
	protected String CodiceOrdine;
	protected String Email;
	protected String NomeL;
	protected String IndirizzoL;
	protected String Nota;
	protected String MenuP;
	protected String MenuB;
	protected String Pietanze_Quantita_Ordinate;
	protected String Bibite_Quantita_Ordinate;
	protected String CF;
	protected double Prezzo_tot;
	private JLabel codice_effettua_ordine;
	private JLabel prezzo_tot_ordine;
	private JLabel mostra_codice_ordine_ricevuto;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaccia_progetto frame = new Interfaccia_progetto();
					frame.setVisible(false);
					Driver.Accesso(Interfaccia_accesso_sql.getPassw());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	
	/**
	 * Create the frame.
	 */
	
	
	
	public Interfaccia_progetto() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 128, 642);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JButton op1 = new JButton("Op1");
		op1.setForeground(Color.BLUE);
		op1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_1);
			}
		});
		op1.setBounds(10, 11, 89, 23);
		panel.add(op1);
		
		JButton op2 = new JButton("Op2");
		op2.setForeground(Color.BLUE);
		op2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_2);
			}
		});
		op2.setBounds(10, 35, 89, 23);
		panel.add(op2);
		
		JButton op3 = new JButton("Op3");
		op3.setForeground(Color.BLUE);
		op3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_3);
			}

		});
		op3.setBounds(10, 61, 89, 23);
		panel.add(op3);
		
		JButton op4 = new JButton("Op4");
		op4.setForeground(Color.BLUE);
		op4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_4);
			}
		});
		op4.setBounds(10, 87, 89, 23);
		panel.add(op4);
		
		JButton op5 = new JButton("Op5");
		op5.setForeground(Color.BLUE);
		op5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_5);
			}
		});
		op5.setBounds(10, 113, 89, 23);
		panel.add(op5);
		
		JButton op8 = new JButton("Op8");
		op8.setForeground(Color.BLUE);
		op8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_8);
			}
		});
		op8.setBounds(10, 191, 89, 23);
		panel.add(op8);
		
		JButton op9 = new JButton("Op9");
		op9.setForeground(Color.BLUE);
		op9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_9);
			}
		});
		op9.setBounds(10, 218, 89, 23);
		panel.add(op9);
		
		JButton op10 = new JButton("Op10");
		op10.setForeground(Color.BLUE);
		op10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_10);
			}
		});
		op10.setBounds(10, 245, 89, 23);
		panel.add(op10);
		
		JButton op11 = new JButton("Op11");
		op11.setForeground(Color.BLUE);
		op11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_11);
			}
		});
		op11.setBounds(10, 272, 89, 23);
		panel.add(op11);
		
		JButton op12 = new JButton("Op12");
		op12.setForeground(Color.BLUE);
		op12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_12);
			}
		});
		op12.setBounds(10, 298, 89, 23);
		panel.add(op12);
		
		JButton op13 = new JButton("Op13");
		op13.setForeground(Color.BLUE);
		op13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_13);
				try {
					tab_locali_media.setModel(DbUtils.resultSetToTableModel(Driver.MediaStelle()));
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		op13.setBounds(10, 322, 89, 23);
		panel.add(op13);
		
		JButton op14 = new JButton("Op14");
		op14.setForeground(Color.BLUE);
		op14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_14);
			}
		});
		op14.setBounds(10, 350, 89, 23);
		panel.add(op14);
		
		JButton op15 = new JButton("Op15");
		op15.setForeground(Color.BLUE);
		op15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_15);
			}
		});
		op15.setBounds(10, 379, 89, 23);
		panel.add(op15);
		
		JButton op16 = new JButton("Op16");
		op16.setForeground(Color.BLUE);
		op16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_16);
			}
		});
		op16.setBounds(10, 407, 89, 23);
		panel.add(op16);
		
		JButton op17 = new JButton("Op17");
		op17.setForeground(Color.BLUE);
		op17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_17);
			}
		});
		op17.setBounds(10, 436, 89, 23);
		panel.add(op17);
		
		JButton op18 = new JButton("Op18");
		op18.setForeground(Color.BLUE);
		op18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_18);
			}
		});
		op18.setBounds(10, 463, 89, 23);
		panel.add(op18);
		
		JButton op19 = new JButton("Op19");
		op19.setForeground(Color.BLUE);
		op19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_19);
			}
		});
		op19.setBounds(10, 491, 89, 23);
		panel.add(op19);
		
		JButton op20 = new JButton("Op20");
		op20.setForeground(Color.BLUE);
		op20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_20);
			}
		});
		op20.setBounds(10, 521, 89, 23);
		panel.add(op20);
		
		JButton op21 = new JButton("Op21");
		op21.setForeground(Color.BLUE);
		op21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_21);
			}
		});
		op21.setBounds(10, 550, 89, 23);
		panel.add(op21);
		
		JButton op22 = new JButton("Op22");
		op22.setForeground(Color.BLUE);
		op22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_22);
				try {
					tab_vantaggi.setModel(DbUtils.resultSetToTableModel(Driver.FidCardAndCoupon()));
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		op22.setBounds(10, 581, 89, 23);
		panel.add(op22);
		
		JButton op23 = new JButton("Op23");
		op23.setForeground(Color.BLUE);
		op23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_23);
			}
		});
		op23.setBounds(10, 606, 89, 23);
		panel.add(op23);
		
		JButton op7 = new JButton("Op7");
		op7.setForeground(Color.BLUE);
		op7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_7);
			}
		});
		op7.setBounds(10, 167, 89, 23);
		panel.add(op7);
		
		JButton op6 = new JButton("Op6");
		op6.setForeground(Color.BLUE);
		op6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(op_6);
			}
			
		});
		op6.setBounds(10, 140, 89, 23);
		panel.add(op6);
		
		layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(0, 0, 255));
		layeredPane.setBounds(127, 0, 489, 642);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		op_1 = new JPanel();
		layeredPane.add(op_1, "name_393188366385200");
		op_1.setLayout(null);
		
		registrazione = new JLabel("REGISTRAZIONE");
		registrazione.setBounds(203, 11, 118, 54);
		op_1.add(registrazione);
		
		JLabel ins_nome = new JLabel("Inserisci nome:");
		ins_nome.setBounds(10, 72, 118, 34);
		op_1.add(ins_nome);
		
		nome = new JTextField();
		nome.setBounds(10, 101, 166, 20);
		op_1.add(nome);
		nome.setColumns(10);
		
		JLabel ins_cognome = new JLabel("Inserisci cognome:");
		ins_cognome.setBounds(10, 137, 118, 14);
		op_1.add(ins_cognome);
		
		cognome = new JTextField();
		cognome.setBounds(10, 159, 167, 20);
		op_1.add(cognome);
		cognome.setColumns(10);
		
		JLabel ins_email = new JLabel("Inserisci e-mail:");
		ins_email.setBounds(10, 197, 118, 14);
		op_1.add(ins_email);
		
		password = new JPasswordField();
		password.setBounds(10, 289, 169, 20);
		op_1.add(password);
		
		JLabel ins_pass = new JLabel("Inserisci password:");
		ins_pass.setBounds(10, 266, 138, 14);
		op_1.add(ins_pass);
		
		email = new JTextField();
		email.setBounds(10, 229, 169, 20);
		op_1.add(email);
		email.setColumns(10);
		
		JLabel ins_indirizzo = new JLabel("Inserisci indirizzo:");
		ins_indirizzo.setBounds(10, 331, 169, 14);
		op_1.add(ins_indirizzo);
		
		indirizzo = new JTextField();
		indirizzo.setBounds(10, 358, 169, 20);
		op_1.add(indirizzo);
		indirizzo.setColumns(10);
		
		JLabel ins_telefono = new JLabel("Inserisci telefono:");
		ins_telefono.setBounds(10, 398, 169, 14);
		op_1.add(ins_telefono);
		
		telefono = new JTextField();
		telefono.setBounds(10, 432, 169, 20);
		op_1.add(telefono);
		telefono.setColumns(10);
		
		JButton salva_registrazione = new JButton("Salva");
		salva_registrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Password=null;
				String Nome = nome.getText();
				String Cognome = cognome.getText();
				String Email = email.getText();
				//controllo password
				int valid;
				if(Driver.isValid(password.getText())) {
					vincoli_password.setText("");
					valid=1;
					Password = password.getText();
				}
				else {
				    valid=0;
					vincoli_password.setText("<html>La password deve contenere<br>minimo 8 caratteri tra cui:un carattere maiuscolo,un carattere minuscolo,un carattere numerico</html>"); 
				}
				if(valid==0)
					password.setText("");
					
				String Indirizzo = indirizzo.getText();
				String Telefono = telefono.getText();
				
				try {
					
					Driver.CreaAccount(Nome, Cognome, Email, Password, Indirizzo, Telefono);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Account già esistente");
					else if(Driver.getFlag()==1)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
				}
			
			
		});
		salva_registrazione.setBounds(203, 487, 89, 23);
		op_1.add(salva_registrazione);
		
		vincoli_password = new JLabel("");
		vincoli_password.setBounds(203, 210, 276, 194);
		op_1.add(vincoli_password);
		
		op_2 = new JPanel();
		layeredPane.add(op_2, "name_393192542217200");
		op_2.setLayout(null);
		
		JLabel registrazione_locale = new JLabel("REGISTRA UN NUOVO LOCALE");
		registrazione_locale.setBounds(168, 30, 269, 14);
		op_2.add(registrazione_locale);
		
		JLabel ins_nome_locale = new JLabel("Inserisci nome:");
		ins_nome_locale.setBounds(23, 72, 136, 14);
		op_2.add(ins_nome_locale);
		
		nome_locale = new JTextField();
		nome_locale.setBounds(23, 99, 154, 20);
		op_2.add(nome_locale);
		nome_locale.setColumns(10);
		
		JLabel ins_indirizzo_locale = new JLabel("Inserisci indirizzo:");
		ins_indirizzo_locale.setBounds(23, 141, 136, 14);
		op_2.add(ins_indirizzo_locale);
		
		indirizzo_locale = new JTextField();
		indirizzo_locale.setBounds(23, 177, 154, 20);
		op_2.add(indirizzo_locale);
		indirizzo_locale.setColumns(10);
		
		JLabel ins_tipologia = new JLabel("Inserisci tipologia:");
		ins_tipologia.setBounds(23, 222, 154, 14);
		op_2.add(ins_tipologia);
		
		tipologia = new JTextField();
		tipologia.setBounds(23, 256, 154, 20);
		op_2.add(tipologia);
		tipologia.setColumns(10);
		
		JLabel ins_telefono_locale = new JLabel("Inserisci telefono:");
		ins_telefono_locale.setBounds(23, 300, 154, 14);
		op_2.add(ins_telefono_locale);
		
		telefono_locale = new JTextField();
		telefono_locale.setBounds(23, 340, 154, 20);
		op_2.add(telefono_locale);
		telefono_locale.setColumns(10);
		
		JButton salva_registrazione_locale = new JButton("Salva");
		salva_registrazione_locale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String Nome = nome_locale.getText();
			String Indirizzo = indirizzo_locale.getText();
			String Tipologia = tipologia.getText();
			String Telefono = telefono_locale.getText();
			
			try {
				Driver.RegistraLocale(Nome, Tipologia, Indirizzo, Telefono);
				if(Driver.getFlag()==0)
					JOptionPane.showMessageDialog(null, "Locale già esistente");
				else if(Driver.getFlag()==1)
					JOptionPane.showMessageDialog(null, "Errore");
			}catch(Exception e1)
			{
				System.out.println(e1);
				
			}
			}
		});
		salva_registrazione_locale.setBounds(203, 388, 89, 23);
		op_2.add(salva_registrazione_locale);
		
		op_3 = new JPanel();
		layeredPane.add(op_3, "name_393195230230100");
		op_3.setLayout(null);
		
		JLabel registrazione_fattorino = new JLabel("ASSUNZIONE NUOVO FATTORINO");
		registrazione_fattorino.setBounds(160, 11, 274, 67);
		op_3.add(registrazione_fattorino);
		
		JLabel ins_nome_fattorino = new JLabel("Nome:");
		ins_nome_fattorino.setBounds(10, 89, 86, 14);
		op_3.add(ins_nome_fattorino);
		
		JLabel ins_cognome_fattorino = new JLabel("Cognome:");
		ins_cognome_fattorino.setBounds(10, 147, 130, 14);
		op_3.add(ins_cognome_fattorino);
		
		JLabel ins_cf = new JLabel("Codice fiscale:");
		ins_cf.setBounds(10, 203, 130, 14);
		op_3.add(ins_cf);
		
		JLabel ins_telefono_fattorino = new JLabel("Telefono:");
		ins_telefono_fattorino.setBounds(10, 268, 130, 14);
		op_3.add(ins_telefono_fattorino);
		
		JLabel ins_indirizzo_locale_fattorino = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_fattorino.setBounds(10, 380, 130, 14);
		op_3.add(ins_indirizzo_locale_fattorino);
		
		JLabel ins_nome_locale_fattorino = new JLabel("Locale:");
		ins_nome_locale_fattorino.setBounds(10, 324, 112, 14);
		op_3.add(ins_nome_locale_fattorino);
		
		nome_fattorino = new JTextField();
		nome_fattorino.setBounds(10, 110, 130, 20);
		op_3.add(nome_fattorino);
		nome_fattorino.setColumns(10);
		
		cognome_fattorino = new JTextField();
		cognome_fattorino.setBounds(10, 172, 130, 20);
		op_3.add(cognome_fattorino);
		cognome_fattorino.setColumns(10);
		
		cf_fattorino = new JTextField();
		cf_fattorino.setBounds(10, 228, 130, 20);
		op_3.add(cf_fattorino);
		cf_fattorino.setColumns(10);
		
		indirizzo_locale_fattorino = new JTextField();
		indirizzo_locale_fattorino.setBounds(10, 405, 130, 20);
		op_3.add(indirizzo_locale_fattorino);
		indirizzo_locale_fattorino.setColumns(10);
		
		nome_locale_fattorino = new JTextField();
		nome_locale_fattorino.setBounds(10, 349, 130, 20);
		op_3.add(nome_locale_fattorino);
		nome_locale_fattorino.setColumns(10);
		
		telefono_fattorino = new JTextField();
		telefono_fattorino.setBounds(10, 293, 130, 20);
		op_3.add(telefono_fattorino);
		telefono_fattorino.setColumns(10);
		
		JButton salva_assunzione_fatt = new JButton("Salva");
		salva_assunzione_fatt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nome = nome_fattorino.getText();
				String Cognome = cognome_fattorino.getText();
				String CodiceF = cf_fattorino.getText();
				String Telefono = telefono_fattorino.getText();
				String NomeL = nome_locale_fattorino.getText();
				String Indirizzo = indirizzo_locale_fattorino.getText();

				try {
					Driver.Fattorino(CodiceF, Nome, Cognome, Telefono, NomeL, Indirizzo);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Dati non corretti");
					else if(Driver.getFlag()==1)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		salva_assunzione_fatt.setBounds(202, 443, 89, 23);
		op_3.add(salva_assunzione_fatt);
		
		op_4 = new JPanel();
		layeredPane.add(op_4, "name_393197330331900");
		op_4.setLayout(null);
		
		JLabel inserimento_recensione = new JLabel("LASCIA UNA RECENSIONE!");
		inserimento_recensione.setBounds(159, 83, 190, 33);
		op_4.add(inserimento_recensione);
		
		JLabel ins_email_recensione = new JLabel("Inserisci la tua e-mail:");
		ins_email_recensione.setBounds(31, 136, 127, 14);
		op_4.add(ins_email_recensione);
		
		JLabel ins_commento = new JLabel("Lascia un commento:");
		ins_commento.setBounds(31, 210, 127, 14);
		op_4.add(ins_commento);
		
		JLabel ins_nome_locale_recensione = new JLabel("Nome locale:");
		ins_nome_locale_recensione.setBounds(31, 366, 152, 14);
		op_4.add(ins_nome_locale_recensione);
		
		JLabel ins_indirizzo_locale_recensione = new JLabel("Inserisci indirizzo:");
		ins_indirizzo_locale_recensione.setBounds(31, 422, 127, 14);
		op_4.add(ins_indirizzo_locale_recensione);
		
		final JComboBox stelle = new JComboBox();
		stelle.setEditable(true);
		stelle.setBounds(31, 323, 127, 20);
		op_4.add(stelle);
		
		stelle.addItem(1);
		stelle.addItem(2);
		stelle.addItem(3);
		stelle.addItem(4);
		stelle.addItem(5);
		
		stelle.setSelectedItem("Stelle");
		
		email_recensione = new JTextField();
		email_recensione.setBounds(31, 161, 127, 20);
		op_4.add(email_recensione);
		email_recensione.setColumns(10);
		
		commento = new JTextField();
		commento.setBounds(31, 235, 127, 77);
		op_4.add(commento);
		commento.setColumns(10);
		
		nome_locale_recensione = new JTextField();
		nome_locale_recensione.setBounds(31, 391, 127, 20);
		op_4.add(nome_locale_recensione);
		nome_locale_recensione.setColumns(10);
		
		indirizzo_locale_recensione = new JTextField();
		indirizzo_locale_recensione.setBounds(31, 447, 127, 20);
		op_4.add(indirizzo_locale_recensione);
		indirizzo_locale_recensione.setColumns(10);
		
		JButton salva_recensione = new JButton("Salva");
		salva_recensione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Email = email_recensione.getText();
				String Commento=null;
				//vincolo caratteri max commento
				if( (commento.getText().length()) >1000) 
					JOptionPane.showMessageDialog(null, "Non puoi superare i 1000 caratteri");
				else {
				Commento = commento.getText();	
				}
				
			   //cast delle stelle in int
				String Stelle = String.valueOf(stelle.getSelectedItem());
				int Stelle_int = Integer.parseInt(Stelle);
				
				String NomeL = nome_locale_recensione.getText();
				String Indirizzo = indirizzo_locale_recensione.getText();
				
				try {
					Driver.Recensione(Email, Commento, Stelle_int, NomeL, Indirizzo);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		salva_recensione.setBounds(182, 480, 89, 23);
		op_4.add(salva_recensione);
		
		op_5 = new JPanel();
		layeredPane.add(op_5, "name_393200051265700");
		op_5.setLayout(null);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBounds(0, 0, 489, 642);
		op_5.add(layeredPane_3);
		layeredPane_3.setLayout(new CardLayout(0, 0));
		
		JPanel Primi_dati_effettua_ordine = new JPanel();
		layeredPane_3.add(Primi_dati_effettua_ordine, "name_612664565609300");
		Primi_dati_effettua_ordine.setLayout(null);
		
		JLabel ins_email_effettua_ordine = new JLabel("E-mail:");
		ins_email_effettua_ordine.setBounds(219, 44, 127, 20);
		Primi_dati_effettua_ordine.add(ins_email_effettua_ordine);
		
		email_effettua_ordine = new JTextField();
		email_effettua_ordine.setBounds(162, 75, 147, 20);
		Primi_dati_effettua_ordine.add(email_effettua_ordine);
		email_effettua_ordine.setColumns(10);
		
		JLabel effettua_ordine = new JLabel("EFFETTUA UN ORDINE");
		effettua_ordine.setBounds(182, 11, 189, 14);
		Primi_dati_effettua_ordine.add(effettua_ordine);
		
		JLabel dati_locale_eff_ordine = new JLabel("Dati locale");
		dati_locale_eff_ordine.setBounds(24, 106, 147, 14);
		Primi_dati_effettua_ordine.add(dati_locale_eff_ordine);
		
		JLabel ins_nome_locale_effettua_ordine = new JLabel("Nome:");
		ins_nome_locale_effettua_ordine.setBounds(24, 145, 96, 14);
		Primi_dati_effettua_ordine.add(ins_nome_locale_effettua_ordine);
		
		nome_locale_effettua_ordine = new JTextField();
		nome_locale_effettua_ordine.setBounds(24, 172, 110, 20);
		Primi_dati_effettua_ordine.add(nome_locale_effettua_ordine);
		nome_locale_effettua_ordine.setColumns(10);
		
		JLabel ins_indirizzo_locale_effettua_ordine = new JLabel("Indirizzo:");
		ins_indirizzo_locale_effettua_ordine.setBounds(231, 145, 140, 14);
		Primi_dati_effettua_ordine.add(ins_indirizzo_locale_effettua_ordine);
		
		indirizzo_locale_effettua_ordine = new JTextField();
		indirizzo_locale_effettua_ordine.setBounds(231, 172, 140, 20);
		Primi_dati_effettua_ordine.add(indirizzo_locale_effettua_ordine);
		indirizzo_locale_effettua_ordine.setColumns(10);
		
		JLabel ins_menu_pietanze_effettua_ordine = new JLabel("Nome menù pietanze:");
		ins_menu_pietanze_effettua_ordine.setBounds(24, 234, 147, 14);
		Primi_dati_effettua_ordine.add(ins_menu_pietanze_effettua_ordine);
		
		JLabel ins_menu_bibite_effettua_ordine = new JLabel("Nome menù bibite:");
		ins_menu_bibite_effettua_ordine.setBounds(231, 234, 161, 14);
		Primi_dati_effettua_ordine.add(ins_menu_bibite_effettua_ordine);
		
		nome_menu_p_effettua_ordine = new JTextField();
		nome_menu_p_effettua_ordine.setBounds(24, 259, 110, 20);
		Primi_dati_effettua_ordine.add(nome_menu_p_effettua_ordine);
		nome_menu_p_effettua_ordine.setColumns(10);
		
		nome_menu_b_effettua_ordine = new JTextField();
		nome_menu_b_effettua_ordine.setBounds(231, 259, 115, 20);
		Primi_dati_effettua_ordine.add(nome_menu_b_effettua_ordine);
		nome_menu_b_effettua_ordine.setColumns(10);
		
		JLabel ins_pietanze_e_quantità = new JLabel("Pietanze e quantità:");
		ins_pietanze_e_quantità.setBounds(24, 303, 120, 14);
		Primi_dati_effettua_ordine.add(ins_pietanze_e_quantità);
		
		JLabel ins_bibite_e_quantità = new JLabel("Bibite e quantità:");
		ins_bibite_e_quantità.setBounds(231, 303, 140, 14);
		Primi_dati_effettua_ordine.add(ins_bibite_e_quantità);
		
		final JTextArea pietanze_e_quantità = new JTextArea();
		pietanze_e_quantità.setBounds(22, 328, 112, 83);
		Primi_dati_effettua_ordine.add(pietanze_e_quantità);
		
		final JTextArea bibite_e_quantità = new JTextArea();
		bibite_e_quantità.setBounds(231, 328, 110, 83);
		Primi_dati_effettua_ordine.add(bibite_e_quantità);
		
		JLabel ins_nota = new JLabel("NOTA:");
		ins_nota.setBounds(24, 439, 110, 14);
		Primi_dati_effettua_ordine.add(ins_nota);
		
		final JTextArea nota = new JTextArea();
		nota.setBounds(34, 464, 147, 38);
		Primi_dati_effettua_ordine.add(nota);
		
		JButton bott_continua_ordine = new JButton("Continua");
		bott_continua_ordine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CodiceOrdine=Driver.randomCodice();
				Email=email_effettua_ordine.getText();
				NomeL=nome_locale_effettua_ordine.getText();
				IndirizzoL=indirizzo_locale_effettua_ordine.getText();
				
				//vincolo caratteri max nota
				if( (nota.getText().length()) >500) 
					JOptionPane.showMessageDialog(null, "Non puoi superare i 500 caratteri");
				else
					Nota = nota.getText();	
				
				
				MenuP=nome_menu_p_effettua_ordine.getText();
				MenuB = nome_menu_b_effettua_ordine.getText();
				Pietanze_Quantita_Ordinate=pietanze_e_quantità.getText();
				Bibite_Quantita_Ordinate=bibite_e_quantità.getText();
				CF=Driver.FattorinoRandom(NomeL, IndirizzoL);
				Prezzo_tot=0;
				Driver.EffettuaOrdine(CodiceOrdine, Nota, Prezzo_tot, Email, NomeL, IndirizzoL, CF, "");
				if(Driver.getFlag()==0)
					JOptionPane.showMessageDialog(null, "Errore");
				//scompattato
				String pietanze[]=Pietanze_Quantita_Ordinate.split("\n");
				for(String p:pietanze) {
		        	
		        	String []p1=p.split(",");
		        	String pietanza=p1[0];
		        	int quantita=Integer.parseInt(p1[1].trim());
		        	Driver.ComprendeP(CodiceOrdine, pietanza, quantita);
		        	if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
		        	double prezzo=Driver.PrezzoP(MenuP, NomeL, IndirizzoL, pietanza);		        	
		        	Prezzo_tot=Prezzo_tot+(prezzo*quantita);
		    }
				if(MenuB.length()>0)
				{
					String bibite[]=Bibite_Quantita_Ordinate.split("\n");
					for(String b:bibite) {
			        	
			        	String []b1=b.split(",");
			        	String bibita=b1[0];
			           	int quantita=Integer.parseInt(b1[1].trim());
			        	Driver.ComprendeB(CodiceOrdine, bibita, quantita);
			        	if(Driver.getFlag()==0)
							JOptionPane.showMessageDialog(null, "Errore");
			        	double prezzo=Driver.PrezzoB(MenuB, NomeL, IndirizzoL, bibita);
			        	Prezzo_tot=Prezzo_tot+(prezzo*quantita);
			    }
				}
				System.out.println(Prezzo_tot);
				switchPanels(Applica_fc);
			}
		});
		bott_continua_ordine.setBounds(208, 560, 89, 23);
		Primi_dati_effettua_ordine.add(bott_continua_ordine);
		
		Applica_fc = new JPanel();
		layeredPane_3.add(Applica_fc, "name_612664616450700");
		Applica_fc.setLayout(null);
		
		JLabel fidelity_card_effettua_ordine = new JLabel("Hai una Fidelity Card?");
		fidelity_card_effettua_ordine.setBounds(166, 39, 192, 14);
		Applica_fc.add(fidelity_card_effettua_ordine);
		
		JLabel ins_codice_fc_effettua_ordine = new JLabel("Codice:");
		ins_codice_fc_effettua_ordine.setBounds(66, 73, 138, 14);
		Applica_fc.add(ins_codice_fc_effettua_ordine);
		
		codice_fc_effettua_ordine = new JTextField();
		codice_fc_effettua_ordine.setBounds(66, 98, 138, 20);
		Applica_fc.add(codice_fc_effettua_ordine);
		codice_fc_effettua_ordine.setColumns(10);
		
		JButton bott_applica_fc = new JButton("Applica");
		bott_applica_fc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String CodiceFC=codice_fc_effettua_ordine.getText();
				Driver.È_applicata(CodiceFC, NomeL, IndirizzoL, CodiceOrdine);
				if(Driver.getFlag()==0)
					JOptionPane.showMessageDialog(null, "Errore");
				int num_consumazioni=Driver.NumConsumazioniFC(CodiceFC, NomeL, IndirizzoL, Email);
				if(num_consumazioni==10)
				{
					Prezzo_tot=0;
					num_consumazioni=0;
				}else
					num_consumazioni++;
				Driver.AggiornaConsumazioni(CodiceFC, NomeL, IndirizzoL, Email, num_consumazioni);
				if(Driver.getFlag()==0)
					JOptionPane.showMessageDialog(null, "Errore");
				switchPanels(Inserisci_coupon);
			}
		});
		bott_applica_fc.setBounds(93, 149, 89, 23);
		Applica_fc.add(bott_applica_fc);
		
		JButton bott_salta_fc = new JButton("Salta");
		bott_salta_fc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Inserisci_coupon);
			}
		});
		bott_salta_fc.setBounds(221, 149, 89, 23);
		Applica_fc.add(bott_salta_fc);
		
		Inserisci_coupon = new JPanel();
		layeredPane_3.add(Inserisci_coupon, "name_613438925557500");
		Inserisci_coupon.setLayout(null);
		
		JLabel coupon_effettua_ordine = new JLabel("Vuoi inserire un coupon?");
		coupon_effettua_ordine.setBounds(181, 34, 221, 14);
		Inserisci_coupon.add(coupon_effettua_ordine);
		
		JLabel ins_codice_coupon_eff_ordine = new JLabel("Codice:");
		ins_codice_coupon_eff_ordine.setBounds(100, 70, 116, 14);
		Inserisci_coupon.add(ins_codice_coupon_eff_ordine);
		
		codice_coupon_eff_ordine = new JTextField();
		codice_coupon_eff_ordine.setBounds(100, 95, 116, 20);
		Inserisci_coupon.add(codice_coupon_eff_ordine);
		codice_coupon_eff_ordine.setColumns(10);
		
		JButton bott_inserisci_coupon = new JButton("Inserisci");
		bott_inserisci_coupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CodiceCoupon=codice_coupon_eff_ordine.getText();
				if(Prezzo_tot>=Driver.SpesaMinima(NomeL, CodiceCoupon, IndirizzoL)){
					int percentuale=Driver.Percentuale(NomeL, CodiceCoupon, IndirizzoL);
					Prezzo_tot=Prezzo_tot-(Prezzo_tot*percentuale/100);
					Driver.È_inserito(CodiceCoupon, CodiceOrdine);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}else
					JOptionPane.showMessageDialog(null, "Codice non applicabile");
				codice_effettua_ordine.setText("Codice del tuo ordine: "+CodiceOrdine);
				prezzo_tot_ordine.setText("Prezzo totale: "+Prezzo_tot);
				switchPanels(Completa_ordine);
						
			}
			
		});
		bott_inserisci_coupon.setBounds(100, 148, 89, 23);
		Inserisci_coupon.add(bott_inserisci_coupon);
		
		JButton bott_salta_completa_ordine = new JButton("Salta e completa ordine");
		bott_salta_completa_ordine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codice_effettua_ordine.setText("Codice del tuo ordine: "+CodiceOrdine);
				prezzo_tot_ordine.setText("Prezzo totale: "+Prezzo_tot);
				switchPanels(Completa_ordine);
			}
		});
		bott_salta_completa_ordine.setBounds(224, 148, 179, 23);
		Inserisci_coupon.add(bott_salta_completa_ordine);
		
		Completa_ordine = new JPanel();
		layeredPane_3.add(Completa_ordine, "name_614202067701100");
		Completa_ordine.setLayout(null);
		
		JLabel completa_ett_ordine = new JLabel("COMPLETA ORDINE");
		completa_ett_ordine.setBounds(199, 11, 178, 14);
		Completa_ordine.add(completa_ett_ordine);
		
		codice_effettua_ordine = new JLabel("");
		codice_effettua_ordine.setBounds(86, 44, 353, 14);
		Completa_ordine.add(codice_effettua_ordine);
		
		
		prezzo_tot_ordine = new JLabel("");
		prezzo_tot_ordine.setBounds(86, 86, 163, 14);
		Completa_ordine.add(prezzo_tot_ordine);
		
		
		JButton bott_fine_ordine = new JButton("Fine");
		bott_fine_ordine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				mostra_codice_ordine_ricevuto.setText("Ricevuto ordine numero: "+CodiceOrdine);
				switchPanels(Area_locale_ordine);
			}
		});
		bott_fine_ordine.setBounds(204, 148, 89, 23);
		Completa_ordine.add(bott_fine_ordine);
		
		Area_locale_ordine = new JPanel();
		layeredPane_3.add(Area_locale_ordine, "name_615062287179700");
		Area_locale_ordine.setLayout(null);
		
		JLabel area_locale = new JLabel("AREA LOCALE");
		area_locale.setBounds(21, 27, 159, 14);
		Area_locale_ordine.add(area_locale);
		
		mostra_codice_ordine_ricevuto = new JLabel("");
		mostra_codice_ordine_ricevuto.setBounds(21, 52, 381, 14);
		Area_locale_ordine.add(mostra_codice_ordine_ricevuto);
		
				
		JLabel ins_fatt_consegna = new JLabel("Inserisci fattorino:");
		ins_fatt_consegna.setBounds(27, 89, 138, 14);
		Area_locale_ordine.add(ins_fatt_consegna);
		
		fatt_consegna = new JTextField();
		fatt_consegna.setBounds(21, 114, 144, 20);
		Area_locale_ordine.add(fatt_consegna);
		fatt_consegna.setColumns(10);
		
		JLabel ins_orario_previsto = new JLabel("Orario previsto:");
		ins_orario_previsto.setBounds(31, 155, 118, 14);
		Area_locale_ordine.add(ins_orario_previsto);
		
		orario_previsto = new JTextField();
		orario_previsto.setBounds(21, 180, 144, 20);
		Area_locale_ordine.add(orario_previsto);
		orario_previsto.setColumns(10);
		
		JButton bott_fine_ordine_locale = new JButton("Fine");
		bott_fine_ordine_locale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cf_fattorino=fatt_consegna.getText();
				String orario_previsto1=orario_previsto.getText();
				Driver.FineOrdine(Prezzo_tot,CodiceOrdine, cf_fattorino, orario_previsto1);
				JOptionPane.showMessageDialog(null,"Ordine completato!");
			}
		});
		bott_fine_ordine_locale.setBounds(138, 231, 89, 23);
		Area_locale_ordine.add(bott_fine_ordine_locale);
		
	    op_8 = new JPanel();
		layeredPane.add(op_8, "name_393208792971400");
		op_8.setLayout(null);
		
		JScrollPane tab_fc = new JScrollPane();
		tab_fc.setBounds(22, 204, 415, 175);
		op_8.add(tab_fc);
		
		table = new JTable();
		tab_fc.setViewportView(table);
		
		JLabel visualizza_fc = new JLabel("VISUALIZZA LE TUE FIDELITY CARD");
		visualizza_fc.setBounds(21, 23, 331, 14);
		op_8.add(visualizza_fc);
		
		JLabel ins_email_fc_visualizza = new JLabel("Inserisci e-mail:");
		ins_email_fc_visualizza.setBounds(21, 48, 163, 14);
		op_8.add(ins_email_fc_visualizza);
		
		email_fc_visualizza = new JTextField();
		email_fc_visualizza.setBounds(21, 75, 177, 20);
		op_8.add(email_fc_visualizza);
		email_fc_visualizza.setColumns(10);
		
		JButton invio_fc_visualizza = new JButton("Invio");
		invio_fc_visualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Email = email_fc_visualizza.getText();
				
				try {
					table.setModel(DbUtils.resultSetToTableModel(Driver.VisualizzaFidelityCard(Email)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		invio_fc_visualizza.setBounds(21, 118, 89, 23);
		op_8.add(invio_fc_visualizza);
		
		op_9 = new JPanel();
		layeredPane.add(op_9, "name_393211738148500");
		op_9.setLayout(null);
		
		JLabel visualizza_num_ordini = new JLabel("VISUALIZZA NUMERO ORDINI");
		visualizza_num_ordini.setBounds(34, 26, 212, 14);
		op_9.add(visualizza_num_ordini);
		
		JLabel ins_email_num_ordini = new JLabel("Inserisci la tua e-mail:");
		ins_email_num_ordini.setBounds(34, 61, 128, 14);
		op_9.add(ins_email_num_ordini);
		
		email_num_ordini = new JTextField();
		email_num_ordini.setBounds(34, 94, 143, 20);
		op_9.add(email_num_ordini);
		email_num_ordini.setColumns(10);
		
		JButton invio_num_ordini = new JButton("Invio");
		invio_num_ordini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Email = email_num_ordini.getText();
				
				try {
					tab_num_ordini.setModel(DbUtils.resultSetToTableModel(Driver.ContaOrdini(Email)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
			
		});
		invio_num_ordini.setBounds(34, 143, 89, 23);
		op_9.add(invio_num_ordini);
		
		JScrollPane panel_num_ordini = new JScrollPane();
		panel_num_ordini.setBounds(211, 60, 212, 108);
		op_9.add(panel_num_ordini);
		
		tab_num_ordini = new JTable();
		panel_num_ordini.setViewportView(tab_num_ordini);
		
		op_10 = new JPanel();
		layeredPane.add(op_10, "name_393214192880500");
		op_10.setLayout(null);
		
		JLabel scopri_fattorino = new JLabel("ECCO CHI CONSEGNERÀ IL TUO ORDINE");
		scopri_fattorino.setBounds(30, 32, 310, 14);
		op_10.add(scopri_fattorino);
		
		JLabel ins_codice_scopri_fattorino = new JLabel("Inserisci codice del tuo ordine:");
		ins_codice_scopri_fattorino.setBounds(30, 83, 174, 14);
		op_10.add(ins_codice_scopri_fattorino);
		
		codice_scopri_fattorino = new JTextField();
		codice_scopri_fattorino.setBounds(30, 118, 174, 20);
		op_10.add(codice_scopri_fattorino);
		codice_scopri_fattorino.setColumns(10);
		
		JScrollPane panel_fattorino = new JScrollPane();
		panel_fattorino.setBounds(30, 181, 351, 37);
		op_10.add(panel_fattorino);
		
		tab_fattorino = new JTable();
		panel_fattorino.setViewportView(tab_fattorino);
		
		JButton invio_scopri_fattorino = new JButton("Invio");
		invio_scopri_fattorino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Codice = codice_scopri_fattorino.getText();
				
				try {
					tab_fattorino.setModel(DbUtils.resultSetToTableModel(Driver.VisualizzaFattorinoOrdine(Codice)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}

			}
		});
		invio_scopri_fattorino.setBounds(30, 147, 89, 23);
		op_10.add(invio_scopri_fattorino);
		
		op_11 = new JPanel();
		layeredPane.add(op_11, "name_393217567090700");
		op_11.setLayout(null);
		
		JLabel visualizza_prodotti = new JLabel("ECCO COSA HAI ORDINATO:");
		visualizza_prodotti.setBounds(22, 37, 206, 14);
		op_11.add(visualizza_prodotti);
		
		JLabel ins_codice_visualizza_prodotti = new JLabel("Inserisci codice del tuo ordine:");
		ins_codice_visualizza_prodotti.setBounds(22, 79, 206, 14);
		op_11.add(ins_codice_visualizza_prodotti);
		
		codice_visualizza_prodotti = new JTextField();
		codice_visualizza_prodotti.setBounds(22, 109, 186, 20);
		op_11.add(codice_visualizza_prodotti);
		codice_visualizza_prodotti.setColumns(10);
		
		JScrollPane panel_prodotti = new JScrollPane();
		panel_prodotti.setBounds(22, 178, 444, 140);
		op_11.add(panel_prodotti);
		
		tab_prodotti = new JTable();
		panel_prodotti.setViewportView(tab_prodotti);
		
		JButton invio_visualizza_prodotti = new JButton("Invio");
		invio_visualizza_prodotti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Codice = codice_visualizza_prodotti.getText();
				
				try {
					tab_prodotti.setModel(DbUtils.resultSetToTableModel(Driver.VisualizzaOrdine(Codice)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		invio_visualizza_prodotti.setBounds(22, 140, 89, 23);
		op_11.add(invio_visualizza_prodotti);
		
		op_12 = new JPanel();
		layeredPane.add(op_12, "name_393220780765500");
		op_12.setLayout(null);
		
		JLabel inserisci_coupon = new JLabel("OFFRI UN COUPON AI TUOI CLIENTI");
		inserisci_coupon.setBounds(157, 25, 227, 14);
		op_12.add(inserisci_coupon);
		
		JLabel ins_codice = new JLabel("Codice:");
		ins_codice.setBounds(10, 63, 115, 14);
		op_12.add(ins_codice);
		
		JLabel ins_data_inizio = new JLabel("Data inizio:");
		ins_data_inizio.setBounds(10, 128, 115, 14);
		op_12.add(ins_data_inizio);
		
		JLabel ins_scadenza_coupon = new JLabel("Scadenza");
		ins_scadenza_coupon.setBounds(156, 128, 86, 14);
		op_12.add(ins_scadenza_coupon);
		
		JLabel ins_spesa_minima = new JLabel("Spesa minima:");
		ins_spesa_minima.setBounds(10, 205, 115, 14);
		op_12.add(ins_spesa_minima);
		
		JLabel ins_valore_sconto = new JLabel("Valore sconto");
		ins_valore_sconto.setBounds(10, 279, 115, 14);
		op_12.add(ins_valore_sconto);
		
		JLabel ins_locale_nome_coupon = new JLabel("Nome locale:");
		ins_locale_nome_coupon.setBounds(10, 345, 115, 14);
		op_12.add(ins_locale_nome_coupon);
		
		JLabel ins_locale_indirizzo_coupon = new JLabel("Indirizzo locale:");
		ins_locale_indirizzo_coupon.setBounds(10, 422, 115, 14);
		op_12.add(ins_locale_indirizzo_coupon);
		
		codice_coupon = new JTextField();
		codice_coupon.setBounds(10, 88, 115, 20);
		op_12.add(codice_coupon);
		codice_coupon.setColumns(10);
		
		data_inizio_coupon = new JTextField();
		data_inizio_coupon.setText("YYYY-MM-DD");
		data_inizio_coupon.setBounds(10, 163, 115, 20);
		op_12.add(data_inizio_coupon);
		data_inizio_coupon.setColumns(10);
		
		scadenza_coupon = new JTextField();
		scadenza_coupon.setText("YYYY-MM-DD");
		scadenza_coupon.setBounds(157, 163, 109, 20);
		op_12.add(scadenza_coupon);
		scadenza_coupon.setColumns(10);
		
		spesa_minima = new JTextField();
		spesa_minima.setText("€");
		spesa_minima.setBounds(10, 230, 115, 20);
		op_12.add(spesa_minima);
		spesa_minima.setColumns(10);
		
		valore_sconto = new JTextField();
		valore_sconto.setText("%");
		valore_sconto.setBounds(10, 304, 115, 20);
		op_12.add(valore_sconto);
		valore_sconto.setColumns(10);
		
		nome_locale_coupon = new JTextField();
		nome_locale_coupon.setBounds(10, 378, 115, 20);
		op_12.add(nome_locale_coupon);
		nome_locale_coupon.setColumns(10);
		
		indirizzo_locale_coupon = new JTextField();
		indirizzo_locale_coupon.setBounds(10, 453, 115, 20);
		op_12.add(indirizzo_locale_coupon);
		indirizzo_locale_coupon.setColumns(10);
		
		JButton salva_coupon = new JButton("Salva");
		salva_coupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Codice = codice_coupon.getText();
				String Data_inizio = data_inizio_coupon.getText();
				String Data_scadenza = scadenza_coupon.getText();
				String Spesa_minima = spesa_minima.getText();
				double Spesa_minima_d=Double.parseDouble(Spesa_minima);
				String Valore = valore_sconto.getText();
				int Valore_i = Integer.parseInt(Valore) ;
				String NomeL = nome_locale_coupon.getText();
				String IndirizzoL = indirizzo_locale_coupon.getText();
				
				try {
					Driver.OffrireCoupon(Codice, Data_inizio, Spesa_minima_d, Valore_i, Data_scadenza, NomeL, IndirizzoL);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		salva_coupon.setBounds(122, 518, 89, 23);
		op_12.add(salva_coupon);
		
		op_13 = new JPanel();
		layeredPane.add(op_13, "name_393223677374600");
		op_13.setLayout(null);
		
		JLabel visualizza_locali_media = new JLabel("LOCALI RECENSITI CON UNA MEDIA DI STELLE >=3");
		visualizza_locali_media.setBounds(20, 24, 363, 14);
		op_13.add(visualizza_locali_media);
		
		JScrollPane panel_locali_media = new JScrollPane();
		panel_locali_media.setBounds(20, 63, 444, 191);
		op_13.add(panel_locali_media);
		
		tab_locali_media = new JTable();
		panel_locali_media.setViewportView(tab_locali_media);
		
		op_14 = new JPanel();
		layeredPane.add(op_14, "name_393226834450200");
		op_14.setLayout(null);
		
		JLabel cerca_pizzerie = new JLabel("CERCA INTORNO A TE!");
		cerca_pizzerie.setBounds(21, 24, 251, 14);
		op_14.add(cerca_pizzerie);
		
		JLabel ins_città_ricerca = new JLabel("Inserisci la tua città:");
		ins_città_ricerca.setBounds(21, 69, 196, 14);
		op_14.add(ins_città_ricerca);
		
		città_ricerca = new JTextField();
		città_ricerca.setBounds(21, 97, 156, 20);
		op_14.add(città_ricerca);
		città_ricerca.setColumns(10);
		
		JButton cerca_locali = new JButton("Cerca");
		cerca_locali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Città = città_ricerca.getText();
				
				try {
					tab_cerca_locali.setModel(DbUtils.resultSetToTableModel(Driver.PizzerieInLocalità(Città)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		cerca_locali.setBounds(21, 138, 89, 23);
		op_14.add(cerca_locali);
		
		JScrollPane panel_cerca_locali = new JScrollPane();
		panel_cerca_locali.setBounds(21, 204, 419, 147);
		op_14.add(panel_cerca_locali);
		
		tab_cerca_locali = new JTable();
		panel_cerca_locali.setViewportView(tab_cerca_locali);
		
		op_15 = new JPanel();
		layeredPane.add(op_15, "name_393230267075900");
		op_15.setLayout(null);
		
		JLabel riepilogo_ordine = new JLabel("RIEPILOGO DEL TUO ORDINE:");
		riepilogo_ordine.setBounds(10, 21, 235, 14);
		op_15.add(riepilogo_ordine);
		
		JLabel ins_codice_riepilogo = new JLabel("Inserisci codice del tuo ordine:");
		ins_codice_riepilogo.setBounds(10, 59, 208, 14);
		op_15.add(ins_codice_riepilogo);
		
		codice_riepilogo = new JTextField();
		codice_riepilogo.setBounds(10, 86, 162, 20);
		op_15.add(codice_riepilogo);
		codice_riepilogo.setColumns(10);
		
		JButton invio_riepilogo_ordine = new JButton("Invio");
		invio_riepilogo_ordine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Codice = codice_riepilogo.getText();
				
				try {
					tab_riepilogo_ordine.setModel(DbUtils.resultSetToTableModel(Driver.DatiOrdine(Codice)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		invio_riepilogo_ordine.setBounds(10, 128, 89, 23);
		op_15.add(invio_riepilogo_ordine);
		
		JScrollPane panel_riepilogo_ordine = new JScrollPane();
		panel_riepilogo_ordine.setBounds(10, 186, 399, 153);
		op_15.add(panel_riepilogo_ordine);
		
		tab_riepilogo_ordine = new JTable();
		panel_riepilogo_ordine.setViewportView(tab_riepilogo_ordine);
		
		op_16 = new JPanel();
		layeredPane.add(op_16, "name_393233250507400");
		op_16.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 489, 65);
		op_16.add(panel_1);
		panel_1.setLayout(null);
		
		JButton bottone_rimuovi_pietanza = new JButton("Rimuovi pietanza");
		bottone_rimuovi_pietanza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(rimuovi_pietanza);
			}
			
		});
		bottone_rimuovi_pietanza.setBounds(48, 31, 147, 23);
		panel_1.add(bottone_rimuovi_pietanza);
		
		JButton bottone_rimuovi_bibita = new JButton("Rimuovi bibita");
		bottone_rimuovi_bibita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(rimuovi_bibita);
			}
		});
		bottone_rimuovi_bibita.setBounds(246, 31, 153, 23);
		panel_1.add(bottone_rimuovi_bibita);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(10, 76, 479, 566);
		op_16.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		rimuovi_pietanza = new JPanel();
		layeredPane_1.add(rimuovi_pietanza, "name_414952034636000");
		rimuovi_pietanza.setLayout(null);
		
		JLabel ins_nome_locale_rim_p = new JLabel("Nome locale:");
		ins_nome_locale_rim_p.setBounds(23, 21, 176, 14);
		rimuovi_pietanza.add(ins_nome_locale_rim_p);
		
		JLabel ins_indirizzo_locale_rim_p = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_rim_p.setBounds(23, 96, 159, 14);
		rimuovi_pietanza.add(ins_indirizzo_locale_rim_p);
		
		JLabel ins_nome_menu_rim_p = new JLabel("Nome menù:");
		ins_nome_menu_rim_p.setBounds(23, 172, 123, 14);
		rimuovi_pietanza.add(ins_nome_menu_rim_p);
		
		JLabel ins_nome_rim_p = new JLabel("Nome pietanza:");
		ins_nome_rim_p.setBounds(23, 249, 138, 14);
		rimuovi_pietanza.add(ins_nome_rim_p);
		
		nome_locale_rim_p = new JTextField();
		nome_locale_rim_p.setBounds(23, 53, 123, 20);
		rimuovi_pietanza.add(nome_locale_rim_p);
		nome_locale_rim_p.setColumns(10);
		
		indirizzo_locale_rim_p = new JTextField();
		indirizzo_locale_rim_p.setBounds(23, 127, 123, 20);
		rimuovi_pietanza.add(indirizzo_locale_rim_p);
		indirizzo_locale_rim_p.setColumns(10);
		
		nome_menu_rim_p = new JTextField();
		nome_menu_rim_p.setBounds(23, 210, 123, 20);
		rimuovi_pietanza.add(nome_menu_rim_p);
		nome_menu_rim_p.setColumns(10);
		
		nome_pietanza_rim_p = new JTextField();
		nome_pietanza_rim_p.setBounds(23, 286, 123, 20);
		rimuovi_pietanza.add(nome_pietanza_rim_p);
		nome_pietanza_rim_p.setColumns(10);
		
		JButton bott_rimuovi_p = new JButton("Rimuovi");
		bott_rimuovi_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeL = nome_locale_rim_p.getText();
				String IndirizzoL = indirizzo_locale_rim_p.getText();
				String NomeM = nome_menu_rim_p.getText();
				String NomeP = nome_pietanza_rim_p.getText();
				
				try {
					Driver.RimuoviPietanzaMenu(NomeM, NomeL, IndirizzoL, NomeP);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
				});
		bott_rimuovi_p.setBounds(45, 338, 89, 23);
		rimuovi_pietanza.add(bott_rimuovi_p);
		
		rimuovi_bibita = new JPanel();
		layeredPane_1.add(rimuovi_bibita, "name_414952062868600");
		rimuovi_bibita.setLayout(null);
		
		JLabel ins_nome_locale_rim_b = new JLabel("Nome locale:");
		ins_nome_locale_rim_b.setBounds(23, 21, 176, 14);
		rimuovi_bibita.add(ins_nome_locale_rim_b);
		
		JLabel ins_indirizzo_locale_rim_b = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_rim_b.setBounds(23, 96, 159, 14);
		rimuovi_bibita.add(ins_indirizzo_locale_rim_b);
		
		JLabel ins_nome_menu_rim_b = new JLabel("Nome menù:");
		ins_nome_menu_rim_b.setBounds(23, 172, 123, 14);
		rimuovi_bibita.add(ins_nome_menu_rim_b);
		
		JLabel ins_nome_rim_b = new JLabel("Nome bibita:");
		ins_nome_rim_b.setBounds(23, 249, 138, 14);
		rimuovi_bibita.add(ins_nome_rim_b);
		
		nome_locale_rim_b = new JTextField();
		nome_locale_rim_b.setBounds(23, 53, 123, 20);
		rimuovi_bibita.add(nome_locale_rim_b);
		nome_locale_rim_b.setColumns(10);
		
		indirizzo_locale_rim_b = new JTextField();
		indirizzo_locale_rim_b.setBounds(23, 127, 123, 20);
		rimuovi_bibita.add(indirizzo_locale_rim_b);
		indirizzo_locale_rim_b.setColumns(10);
		
		nome_menu_rim_b = new JTextField();
		nome_menu_rim_b.setBounds(23, 210, 123, 20);
		rimuovi_bibita.add(nome_menu_rim_b);
		nome_menu_rim_b.setColumns(10);
		
		nome_bibita_rim_b = new JTextField();
		nome_bibita_rim_b.setBounds(23, 286, 123, 20);
		rimuovi_bibita.add(nome_bibita_rim_b);
		nome_bibita_rim_b.setColumns(10);
		
		JButton bott_rimuovi_b = new JButton("Rimuovi");
		bott_rimuovi_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeL = nome_locale_rim_b.getText();
				String IndirizzoL = indirizzo_locale_rim_b.getText();
				String NomeM = nome_menu_rim_b.getText();
				String NomeB = nome_bibita_rim_b.getText();
				
				try {
					Driver.RimuoviBibitaMenu(NomeM, NomeL, IndirizzoL, NomeB);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		bott_rimuovi_b.setBounds(40, 337, 89, 23);
		rimuovi_bibita.add(bott_rimuovi_b);
		
		op_17 = new JPanel();
		layeredPane.add(op_17, "name_393236613578100");
		op_17.setLayout(null);
		
		JLabel visualizza_menu = new JLabel("ECCO I MENÙ:");
		visualizza_menu.setBounds(201, 34, 218, 14);
		op_17.add(visualizza_menu);
		
		JLabel ins_nome_locale_visualizza_menu = new JLabel("Nome locale:");
		ins_nome_locale_visualizza_menu.setBounds(27, 83, 131, 14);
		op_17.add(ins_nome_locale_visualizza_menu);
		
		nome_locale_visualizza_menu = new JTextField();
		nome_locale_visualizza_menu.setBounds(27, 121, 131, 20);
		op_17.add(nome_locale_visualizza_menu);
		nome_locale_visualizza_menu.setColumns(10);
		
		JLabel ins_indirizzo_locale_visualizza_menu = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_visualizza_menu.setBounds(27, 178, 131, 14);
		op_17.add(ins_indirizzo_locale_visualizza_menu);
		
		indirizzo_locale_visualizza_menu = new JTextField();
		indirizzo_locale_visualizza_menu.setBounds(27, 222, 131, 20);
		op_17.add(indirizzo_locale_visualizza_menu);
		indirizzo_locale_visualizza_menu.setColumns(10);
		
		JButton invio_visualizza_menu = new JButton("Invio");
		invio_visualizza_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeL = nome_locale_visualizza_menu.getText();
				String IndirizzoL = indirizzo_locale_visualizza_menu.getText();
				
				try {
					tab_visualizza_menu.setModel(DbUtils.resultSetToTableModel(Driver.VisualizzaMenù(NomeL, IndirizzoL)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		invio_visualizza_menu.setBounds(27, 278, 89, 23);
		op_17.add(invio_visualizza_menu);
		
		JScrollPane panel_visualizza_menu = new JScrollPane();
		panel_visualizza_menu.setBounds(217, 123, 208, 122);
		op_17.add(panel_visualizza_menu);
		
		tab_visualizza_menu = new JTable();
		panel_visualizza_menu.setViewportView(tab_visualizza_menu);
		
		op_18 = new JPanel();
		layeredPane.add(op_18, "name_393239718888900");
		op_18.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 489, 109);
		op_18.add(panel_2);
		panel_2.setLayout(null);
		
		JButton bottone_mod_prezzo_p = new JButton("Pietanza");
		bottone_mod_prezzo_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel_mod_p);
			}
		});
		bottone_mod_prezzo_p.setBounds(75, 42, 89, 23);
		panel_2.add(bottone_mod_prezzo_p);
		
		JButton bottone_mod_prezzo_b = new JButton("Bibita");
		bottone_mod_prezzo_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel_mod_b);
			}
		});
		bottone_mod_prezzo_b.setBounds(284, 42, 89, 23);
		panel_2.add(bottone_mod_prezzo_b);
		
		JLabel modifica_prezzo = new JLabel("MODIFICA PREZZO");
		modifica_prezzo.setBounds(174, 11, 125, 14);
		panel_2.add(modifica_prezzo);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBounds(10, 120, 479, 511);
		op_18.add(layeredPane_2);
		layeredPane_2.setLayout(new CardLayout(0, 0));
		
		panel_mod_p = new JPanel();
		layeredPane_2.add(panel_mod_p, "name_417930486890800");
		panel_mod_p.setLayout(null);
		
		JLabel ins_nome_pietanza_mod = new JLabel("Inserisci nome:");
		ins_nome_pietanza_mod.setBounds(40, 27, 146, 14);
		panel_mod_p.add(ins_nome_pietanza_mod);
		
		nome_pietanza_mod = new JTextField();
		nome_pietanza_mod.setBounds(40, 65, 132, 20);
		panel_mod_p.add(nome_pietanza_mod);
		nome_pietanza_mod.setColumns(10);
		
		JLabel ins_nome_locale_mod_p = new JLabel("Nome locale:");
		ins_nome_locale_mod_p.setBounds(40, 109, 166, 14);
		panel_mod_p.add(ins_nome_locale_mod_p);
		
		nome_locale_mod_p = new JTextField();
		nome_locale_mod_p.setBounds(40, 155, 132, 20);
		panel_mod_p.add(nome_locale_mod_p);
		nome_locale_mod_p.setColumns(10);
		
		JLabel ins_indirizzo_locale_mod_p = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_mod_p.setBounds(40, 211, 146, 14);
		panel_mod_p.add(ins_indirizzo_locale_mod_p);
		
		indirizzo_locale_mod_p = new JTextField();
		indirizzo_locale_mod_p.setBounds(40, 250, 132, 20);
		panel_mod_p.add(indirizzo_locale_mod_p);
		indirizzo_locale_mod_p.setColumns(10);
		
		JLabel ins_nuovo_prezzo_p = new JLabel("Inserisci nuovo prezzo:");
		ins_nuovo_prezzo_p.setBounds(40, 304, 166, 14);
		panel_mod_p.add(ins_nuovo_prezzo_p);
		
		nuovo_prezzo_p = new JTextField();
		nuovo_prezzo_p.setText("€");
		nuovo_prezzo_p.setBounds(40, 345, 132, 20);
		panel_mod_p.add(nuovo_prezzo_p);
		nuovo_prezzo_p.setColumns(10);
		
		JButton bott_modifica_prezzo_p = new JButton("Salva");
		bott_modifica_prezzo_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeP = nome_pietanza_mod.getText();
				String NomeL = nome_locale_mod_p.getText();
				String IndirizzoL = indirizzo_locale_mod_p.getText();
				String Prezzo = nuovo_prezzo_p.getText();
				double Prezzo_d = Double.parseDouble(Prezzo);
				String NomeM = nome_menù_mod_p.getText() ;
				
				try {
					Driver.ModPrezzoPietanza(Prezzo_d, NomeL, IndirizzoL, NomeP, NomeM);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		bott_modifica_prezzo_p.setBounds(194, 410, 89, 23);
		panel_mod_p.add(bott_modifica_prezzo_p);
		
		JLabel ins_nome_menu_mod_p = new JLabel("Nome menù:");
		ins_nome_menu_mod_p.setBounds(258, 212, 132, 13);
		panel_mod_p.add(ins_nome_menu_mod_p);
		
		nome_menù_mod_p = new JTextField();
		nome_menù_mod_p.setBounds(258, 250, 132, 19);
		panel_mod_p.add(nome_menù_mod_p);
		nome_menù_mod_p.setColumns(10);
		
		panel_mod_b = new JPanel();
		layeredPane_2.add(panel_mod_b, "name_417946042357100");
        panel_mod_b.setLayout(null);
		
		JLabel ins_nome_bibita_mod = new JLabel("Inserisci nome:");
		ins_nome_bibita_mod.setBounds(40, 27, 146, 14);
		panel_mod_b.add(ins_nome_bibita_mod);
		
		nome_bibita_mod = new JTextField();
		nome_bibita_mod.setBounds(40, 65, 132, 20);
		panel_mod_b.add(nome_bibita_mod);
		nome_bibita_mod.setColumns(10);
		
		JLabel ins_nome_locale_mod_b = new JLabel("Nome locale:");
		ins_nome_locale_mod_b.setBounds(40, 109, 166, 14);
		panel_mod_b.add(ins_nome_locale_mod_b);
		
		nome_locale_mod_b = new JTextField();
		nome_locale_mod_b.setBounds(40, 155, 132, 20);
		panel_mod_b.add(nome_locale_mod_b);
		nome_locale_mod_b.setColumns(10);
		
		JLabel ins_indirizzo_locale_mod_b = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_mod_b.setBounds(40, 211, 146, 14);
		panel_mod_b.add(ins_indirizzo_locale_mod_b);
		
		indirizzo_locale_mod_b = new JTextField();
		indirizzo_locale_mod_b.setBounds(40, 250, 132, 20);
		panel_mod_b.add(indirizzo_locale_mod_b);
		indirizzo_locale_mod_b.setColumns(10);
		
		JLabel ins_nuovo_prezzo_b = new JLabel("Inserisci nuovo prezzo:");
		ins_nuovo_prezzo_b.setBounds(40, 304, 166, 14);
		panel_mod_b.add(ins_nuovo_prezzo_b);
		
		nuovo_prezzo_b = new JTextField();
		nuovo_prezzo_b.setText("€");
		nuovo_prezzo_b.setBounds(40, 345, 132, 20);
		panel_mod_b.add(nuovo_prezzo_b);
		nuovo_prezzo_b.setColumns(10);
		
		JButton bott_modifica_prezzo_b = new JButton("Salva");
		bott_modifica_prezzo_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeB = nome_bibita_mod.getText();
				String NomeL = nome_locale_mod_b.getText();
				String IndirizzoL = indirizzo_locale_mod_b.getText();
				String Prezzo = nuovo_prezzo_b.getText();
				double Prezzo_d = Double.parseDouble(Prezzo);
				String NomeM = nome_menu_mod_b.getText();
			
				try {
					Driver.ModPrezzoBibita(Prezzo_d, NomeL, IndirizzoL, NomeB, NomeM);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		bott_modifica_prezzo_b.setBounds(195, 393, 89, 23);
		panel_mod_b.add(bott_modifica_prezzo_b);
		
		JLabel ins_nome_menu_mod_b = new JLabel("Nome menù:");
		ins_nome_menu_mod_b.setBounds(255, 212, 132, 13);
		panel_mod_b.add(ins_nome_menu_mod_b);
		
		nome_menu_mod_b = new JTextField();
		nome_menu_mod_b.setBounds(255, 250, 146, 19);
		panel_mod_b.add(nome_menu_mod_b);
		nome_menu_mod_b.setColumns(10);
		
		op_19 = new JPanel();
		layeredPane.add(op_19, "name_393289996410600");
		op_19.setLayout(null);
		
		JLabel bibite_analcoliche = new JLabel("Bibite analcoliche:");
		bibite_analcoliche.setBounds(10, 25, 148, 14);
		op_19.add(bibite_analcoliche);
		
		JLabel ins_nome_locale_bibite_a = new JLabel("Inserisci nome locale:");
		ins_nome_locale_bibite_a.setBounds(10, 65, 127, 14);
		op_19.add(ins_nome_locale_bibite_a);
		
		nome_locale_bibite_a = new JTextField();
		nome_locale_bibite_a.setBounds(10, 103, 86, 20);
		op_19.add(nome_locale_bibite_a);
		nome_locale_bibite_a.setColumns(10);
		
		JLabel ins_indirizzo_locale_bibite_a = new JLabel("Inserisci indirizzo locale:");
		ins_indirizzo_locale_bibite_a.setBounds(10, 156, 163, 14);
		op_19.add(ins_indirizzo_locale_bibite_a);
		
		indirizzo_locale_bibite_a = new JTextField();
		indirizzo_locale_bibite_a.setBounds(10, 204, 86, 20);
		op_19.add(indirizzo_locale_bibite_a);
		indirizzo_locale_bibite_a.setColumns(10);
		
		JButton invio_bibite_a = new JButton("Invio");
		invio_bibite_a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeL = nome_locale_bibite_a.getText();
				String IndirizzoL = indirizzo_locale_bibite_a.getText();
				
				try {
					tab_bibite_a.setModel(DbUtils.resultSetToTableModel(Driver.BibiteNonAlcoliche(IndirizzoL, NomeL)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
		
			}
		});
		invio_bibite_a.setBounds(7, 260, 89, 23);
		op_19.add(invio_bibite_a);
		
		JScrollPane panel_bibite_a = new JScrollPane();
		panel_bibite_a.setBounds(199, 25, 258, 268);
		op_19.add(panel_bibite_a);
		
		tab_bibite_a = new JTable();
		panel_bibite_a.setViewportView(tab_bibite_a);
		
		op_20 = new JPanel();
		layeredPane.add(op_20, "name_393295525487700");
		op_20.setLayout(null);
		
		JLabel visualizza_ingredienti = new JLabel("INGREDIENTI:");
		visualizza_ingredienti.setBounds(10, 30, 160, 14);
		op_20.add(visualizza_ingredienti);
		
		JLabel ins_nome_pietanza_ingr = new JLabel("Inserisci nome pietanza:");
		ins_nome_pietanza_ingr.setBounds(10, 69, 160, 14);
		op_20.add(ins_nome_pietanza_ingr);
		
		nome_pietanza_ingr = new JTextField();
		nome_pietanza_ingr.setBounds(10, 94, 134, 20);
		op_20.add(nome_pietanza_ingr);
		nome_pietanza_ingr.setColumns(10);
		
		JButton cerca_ingr = new JButton("Cerca");
		cerca_ingr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeP = nome_pietanza_ingr.getText();
				
				try {
					tab_ingr.setModel(DbUtils.resultSetToTableModel(Driver.Ingredienti(NomeP)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		cerca_ingr.setBounds(10, 139, 89, 23);
		op_20.add(cerca_ingr);
		
		JScrollPane panel_ingr = new JScrollPane();
		panel_ingr.setBounds(185, 51, 207, 144);
		op_20.add(panel_ingr);
		
		tab_ingr = new JTable();
		panel_ingr.setViewportView(tab_ingr);
		
		op_21 = new JPanel();
		layeredPane.add(op_21, "name_393298973858900");
		op_21.setLayout(null);
		
		JLabel visualizza_prodotti_menu = new JLabel("MENÙ:");
		visualizza_prodotti_menu.setBounds(204, 11, 71, 31);
		op_21.add(visualizza_prodotti_menu);
		
		JLabel ins_nome_menu_prodotti = new JLabel("Nome menù:");
		ins_nome_menu_prodotti.setBounds(21, 67, 134, 14);
		op_21.add(ins_nome_menu_prodotti);
		
		nome_menù_prodotti = new JTextField();
		nome_menù_prodotti.setBounds(21, 92, 146, 20);
		op_21.add(nome_menù_prodotti);
		nome_menù_prodotti.setColumns(10);
		
		JLabel ins_nome_locale_prodotti = new JLabel("Nome locale:");
		ins_nome_locale_prodotti.setBounds(21, 139, 134, 14);
		op_21.add(ins_nome_locale_prodotti);
		
		nome_locale_prodotti = new JTextField();
		nome_locale_prodotti.setBounds(21, 176, 146, 20);
		op_21.add(nome_locale_prodotti);
		nome_locale_prodotti.setColumns(10);
		
		indirizzo_locale_prodotti = new JTextField();
		indirizzo_locale_prodotti.setBounds(21, 246, 146, 20);
		op_21.add(indirizzo_locale_prodotti);
		indirizzo_locale_prodotti.setColumns(10);
		
		JLabel ins_indirizzo_locale_prodotti = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_prodotti.setBounds(21, 217, 166, 14);
		op_21.add(ins_indirizzo_locale_prodotti);
		
		JButton invio_visualizza_prodotti_menu = new JButton("Invio");
		invio_visualizza_prodotti_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeM = nome_menù_prodotti.getText();
				String NomeL = nome_locale_prodotti.getText();
				String IndirizzoL = indirizzo_locale_prodotti.getText();
				
				try {
					tab_prodotti_menu.setModel(DbUtils.resultSetToTableModel(Driver.VisualizzaProdMenu(NomeM, NomeL, IndirizzoL)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		invio_visualizza_prodotti_menu.setBounds(21, 295, 89, 23);
		op_21.add(invio_visualizza_prodotti_menu);
		
		JScrollPane panel_prodotti_menu = new JScrollPane();
		panel_prodotti_menu.setBounds(230, 67, 207, 335);
		op_21.add(panel_prodotti_menu);
		
		tab_prodotti_menu = new JTable();
		panel_prodotti_menu.setViewportView(tab_prodotti_menu);
		
		op_22 = new JPanel();
		layeredPane.add(op_22, "name_393303603160600");
		op_22.setLayout(null);
		
		JLabel vantaggi = new JLabel("LOCALI CHE OFFRONO SIA COUPON CHE FIDELITY CARD");
		vantaggi.setBounds(27, 31, 435, 14);
		op_22.add(vantaggi);
		
		JScrollPane panel_vantaggi = new JScrollPane();
		panel_vantaggi.setBounds(27, 85, 452, 210);
		op_22.add(panel_vantaggi);
		
		tab_vantaggi = new JTable();
		panel_vantaggi.setViewportView(tab_vantaggi);
		
		op_23 = new JPanel();
		layeredPane.add(op_23, "name_393306993959000");
		op_23.setLayout(null);
		
		JLabel resoconto_mensile = new JLabel("Resoconto mensile");
		resoconto_mensile.setBounds(146, 26, 148, 14);
		op_23.add(resoconto_mensile);
		
		JLabel ins_nome_locale_resoconto = new JLabel("Nome locale:");
		ins_nome_locale_resoconto.setBounds(10, 68, 114, 14);
		op_23.add(ins_nome_locale_resoconto);
		
		JLabel ins_indirizzo_locale_resoconto = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_resoconto.setBounds(265, 68, 133, 14);
		op_23.add(ins_indirizzo_locale_resoconto);
		
		nome_locale_resoconto = new JTextField();
		nome_locale_resoconto.setBounds(10, 96, 148, 20);
		op_23.add(nome_locale_resoconto);
		nome_locale_resoconto.setColumns(10);
		
		indirizzo_locale_resoconto = new JTextField();
		indirizzo_locale_resoconto.setBounds(264, 96, 145, 20);
		op_23.add(indirizzo_locale_resoconto);
		indirizzo_locale_resoconto.setColumns(10);
		
		JLabel ins_nome_prodotto_resoconto = new JLabel("Nome prodotto:");
		ins_nome_prodotto_resoconto.setBounds(10, 155, 122, 14);
		op_23.add(ins_nome_prodotto_resoconto);
		
		JLabel ins_data_resoconto = new JLabel("Mese e anno:");
		ins_data_resoconto.setBounds(265, 155, 133, 14);
		op_23.add(ins_data_resoconto);
		
		nome_prodotto_resoconto = new JTextField();
		nome_prodotto_resoconto.setBounds(10, 187, 148, 20);
		op_23.add(nome_prodotto_resoconto);
		nome_prodotto_resoconto.setColumns(10);
		
		data_resoconto = new JTextField();
		data_resoconto.setText("YYYY-MM");
		data_resoconto.setBounds(264, 187, 145, 20);
		op_23.add(data_resoconto);
		data_resoconto.setColumns(10);
		
		JButton invio_resoconto = new JButton("Invio");
		invio_resoconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeL = nome_locale_resoconto.getText();
				String IndirizzoL = indirizzo_locale_resoconto.getText();
				String NomeP = nome_prodotto_resoconto.getText();
				String Data = data_resoconto.getText();
				
				try {
					tab_resoconto.setModel(DbUtils.resultSetToTableModel(Driver.Resoconto(NomeL, IndirizzoL, Data, NomeP, NomeP)));
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		invio_resoconto.setBounds(159, 237, 89, 23);
		op_23.add(invio_resoconto);
		
		JScrollPane panel_resoconto = new JScrollPane();
		panel_resoconto.setBounds(20, 328, 442, 182);
		op_23.add(panel_resoconto);
		
		tab_resoconto = new JTable();
		panel_resoconto.setViewportView(tab_resoconto);
		
		op_7 = new JPanel();
		layeredPane.add(op_7, "name_402048862381400");
		op_7.setLayout(null);
		
		JLabel registrazione_fc = new JLabel("ISCRIVITI AL NOSTRO PROGRAMMA FEDELTÀ");
		registrazione_fc.setBounds(103, 21, 307, 51);
		op_7.add(registrazione_fc);
		
		JLabel ins_nome_locale_fc = new JLabel("Nome locale:");
		ins_nome_locale_fc.setBounds(10, 79, 157, 14);
		op_7.add(ins_nome_locale_fc);
		
		JLabel ins_indirizzo_locale_fc = new JLabel("Indirizzo locale:");
		ins_indirizzo_locale_fc.setBounds(10, 147, 146, 14);
		op_7.add(ins_indirizzo_locale_fc);
		
		JLabel ins_email_fc = new JLabel("Inserisci la tua e-mail:");
		ins_email_fc.setBounds(10, 214, 178, 14);
		op_7.add(ins_email_fc);
		
		nome_locale_fc = new JTextField();
		nome_locale_fc.setBounds(10, 104, 157, 20);
		op_7.add(nome_locale_fc);
		nome_locale_fc.setColumns(10);
		
		indirizzo_locale_fc = new JTextField();
		indirizzo_locale_fc.setBounds(10, 172, 157, 20);
		op_7.add(indirizzo_locale_fc);
		indirizzo_locale_fc.setColumns(10);
		
		email_fc = new JTextField();
		email_fc.setBounds(10, 239, 157, 20);
		op_7.add(email_fc);
		email_fc.setColumns(10);
		
		codice_fc = new JLabel("");
		codice_fc.setBounds(10, 314, 423, 29);
		op_7.add(codice_fc);
	   
		
		JButton salva_fc = new JButton("Salva");
		salva_fc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Codice = Driver.randomCodice();
				codice_fc.setText("Questo è il codice della tua Fidelity Card: "+ Codice);
				String NomeL = nome_locale_fc.getText();
				String IndirizzoL = indirizzo_locale_fc.getText();
				String Email = email_fc.getText();
				
				try {
					Driver.CreaFidelityCard(Codice, NomeL, IndirizzoL, Email);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		salva_fc.setBounds(39, 280, 89, 23);
		op_7.add(salva_fc);
		
		op_6 = new JPanel();
		layeredPane.add(op_6, "name_526824596652900");
		op_6.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 489, 69);
		op_6.add(panel_4);
		panel_4.setLayout(null);
		
		JButton bot_aggiungi_pietanza = new JButton("Pietanza");
		bot_aggiungi_pietanza.setBounds(69, 26, 100, 23);
		panel_4.add(bot_aggiungi_pietanza);
		bot_aggiungi_pietanza.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton bot_aggiungi_bibita = new JButton("Bibita");
		bot_aggiungi_bibita.setBounds(256, 26, 86, 23);
		panel_4.add(bot_aggiungi_bibita);
		bot_aggiungi_bibita.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bot_aggiungi_bibita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(aggiungi_bibita);
			}
		});
		bot_aggiungi_pietanza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(aggiungi_pietanza);
			}
		});
		
		JLayeredPane aggiungi_prodotto = new JLayeredPane();
		aggiungi_prodotto.setBounds(0, 72, 489, 570);
		op_6.add(aggiungi_prodotto);
		aggiungi_prodotto.setLayout(new CardLayout(0, 0));
		
		
		aggiungi_pietanza = new JPanel();
		aggiungi_prodotto.add(aggiungi_pietanza, "name_393202843147600");
		aggiungi_pietanza.setLayout(null);
		
		JLabel inserimento_pietanza = new JLabel("AGGIUNGI UNA NUOVA PIETANZA AL TUO MENÙ");
		inserimento_pietanza.setBounds(20, 28, 344, 14);
		aggiungi_pietanza.add(inserimento_pietanza);
		
		JLabel ins_nome_menu = new JLabel("Nome menù:");
		ins_nome_menu.setBounds(20, 66, 130, 14);
		aggiungi_pietanza.add(ins_nome_menu);
		
		JLabel ins_nome_locale_menu = new JLabel("Locale:");
		ins_nome_locale_menu.setBounds(20, 134, 46, 14);
		aggiungi_pietanza.add(ins_nome_locale_menu);
		
		JLabel ins_indirizzo_locale_menu = new JLabel("Indirizzo:");
		ins_indirizzo_locale_menu.setBounds(20, 211, 154, 14);
		aggiungi_pietanza.add(ins_indirizzo_locale_menu);
		
		JLabel ins_nome_pietanza = new JLabel("Nome pietanza");
		ins_nome_pietanza.setBounds(20, 289, 130, 14);
		aggiungi_pietanza.add(ins_nome_pietanza);
		
		JLabel ins_prezzo = new JLabel("Prezzo:");
		ins_prezzo.setBounds(20, 365, 46, 14);
		aggiungi_pietanza.add(ins_prezzo);
		
		nome_menu = new JTextField();
		nome_menu.setBounds(20, 91, 166, 20);
		aggiungi_pietanza.add(nome_menu);
		nome_menu.setColumns(10);
		
		nome_locale_menu = new JTextField();
		nome_locale_menu.setBounds(20, 172, 166, 20);
		aggiungi_pietanza.add(nome_locale_menu);
		nome_locale_menu.setColumns(10);
		
		indirizzo_locale_menu = new JTextField();
		indirizzo_locale_menu.setBounds(20, 246, 166, 20);
		aggiungi_pietanza.add(indirizzo_locale_menu);
		indirizzo_locale_menu.setColumns(10);
		
		nome_pietanza = new JTextField();
		nome_pietanza.setBounds(20, 325, 166, 20);
		aggiungi_pietanza.add(nome_pietanza);
		nome_pietanza.setColumns(10);
		
		prezzo_pietanza = new JTextField();
		prezzo_pietanza.setText("€");
		prezzo_pietanza.setBounds(20, 399, 166, 20);
		aggiungi_pietanza.add(prezzo_pietanza);
		prezzo_pietanza.setColumns(10);
		
		JButton bott_inserisci_pietanza = new JButton("Inserisci");
		bott_inserisci_pietanza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeM = nome_menu.getText();
				String NomeL = nome_locale_menu.getText();
				String Indirizzo = indirizzo_locale_menu.getText();
				String NomeP = nome_pietanza.getText();
				String Prezzo = prezzo_pietanza.getText();
				double Prezzo_d = Double.parseDouble(Prezzo);
				
				try {
					Driver.È_composto_p(NomeM, NomeL, Indirizzo, NomeP, Prezzo_d);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		bott_inserisci_pietanza.setBounds(183, 445, 89, 23);
		aggiungi_pietanza.add(bott_inserisci_pietanza);
		
		aggiungi_bibita = new JPanel();
		aggiungi_prodotto.add(aggiungi_bibita, "name_393205711715700");
        aggiungi_bibita.setLayout(null);
		
		JLabel inserimento_bibita = new JLabel("AGGIUNGI UNA NUOVA BIBITA AL TUO MENÙ");
		inserimento_bibita.setBounds(20, 28, 344, 14);
		aggiungi_bibita.add(inserimento_bibita);
		
		JLabel ins_nome_menu_bibita = new JLabel("Nome menù:");
		ins_nome_menu_bibita.setBounds(20, 66, 130, 14);
		aggiungi_bibita.add(ins_nome_menu_bibita);
		
		JLabel ins_nome_locale_menu_bibita = new JLabel("Locale:");
		ins_nome_locale_menu_bibita.setBounds(20, 134, 46, 14);
		aggiungi_bibita.add(ins_nome_locale_menu_bibita);
		
		JLabel ins_indirizzo_locale_menu_bibita = new JLabel("Indirizzo:");
		ins_indirizzo_locale_menu_bibita.setBounds(20, 211, 166, 14);
		aggiungi_bibita.add(ins_indirizzo_locale_menu_bibita);
		
		JLabel ins_nome_bibita = new JLabel("Nome bibita");
		ins_nome_bibita.setBounds(20, 289, 130, 14);
		aggiungi_bibita.add(ins_nome_bibita);
		
		JLabel ins_prezzo_bibita = new JLabel("Prezzo:");
		ins_prezzo_bibita.setBounds(20, 365, 46, 14);
		aggiungi_bibita.add(ins_prezzo_bibita);
		
		nome_menu_bibita = new JTextField();
		nome_menu_bibita.setBounds(20, 91, 166, 20);
		aggiungi_bibita.add(nome_menu_bibita);
		nome_menu_bibita.setColumns(10);
		
		nome_locale_menu_bibita = new JTextField();
		nome_locale_menu_bibita.setBounds(20, 172, 166, 20);
		aggiungi_bibita.add(nome_locale_menu_bibita);
		nome_locale_menu_bibita.setColumns(10);
		
		indirizzo_locale_menu_bibita = new JTextField();
		indirizzo_locale_menu_bibita.setBounds(20, 246, 166, 20);
		aggiungi_bibita.add(indirizzo_locale_menu_bibita);
		indirizzo_locale_menu_bibita.setColumns(10);
		
		nome_bibita = new JTextField();
		nome_bibita.setBounds(20, 325, 166, 20);
		aggiungi_bibita.add(nome_bibita);
		nome_bibita.setColumns(10);
		
		prezzo_bibita = new JTextField();
		prezzo_bibita.setText("€");
		prezzo_bibita.setBounds(20, 399, 166, 20);
		aggiungi_bibita.add(prezzo_bibita);
		prezzo_bibita.setColumns(10);
		
		JButton bott_inserisci_b = new JButton("Inserisci");
		bott_inserisci_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeM = nome_menu_bibita.getText();
				String NomeL = nome_locale_menu_bibita.getText();
				String Indirizzo = indirizzo_locale_menu_bibita.getText();
				String NomeB = nome_bibita.getText();
				String Prezzo = prezzo_bibita.getText();
				double Prezzo_d = Double.parseDouble(Prezzo);
				
				try {
					Driver.È_composto_b(NomeM, NomeL, Indirizzo, NomeB, Prezzo_d);
					if(Driver.getFlag()==0)
						JOptionPane.showMessageDialog(null, "Errore");
				}catch(Exception e1){
					System.out.println(e1);
				}
			}
		});
		bott_inserisci_b.setBounds(169, 443, 89, 23);
		aggiungi_bibita.add(bott_inserisci_b);
		
		
		
	}
}

