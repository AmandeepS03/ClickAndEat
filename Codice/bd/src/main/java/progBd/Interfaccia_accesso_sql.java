package progBd;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Interfaccia_accesso_sql extends JFrame {

	private JPanel contentPane;
	private JLabel eccezione;
	private JPasswordField pass_sql;
	public static Interfaccia_accesso_sql frame;
	public static String passw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Interfaccia_accesso_sql();
					frame.setVisible(true);
					
				} catch (Exception e) {
				
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Interfaccia_accesso_sql() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton accedi = new JButton("Accedi");
		accedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passw= pass_sql.getText();
				try {
					//se la password è giusta apre l'interfaccia
					if(Driver.Accesso(passw)) {
					Interfaccia_progetto i = new Interfaccia_progetto();	
					i.show();
					frame.setVisible(false);
					}
					else
						
						eccezione.setText("Accesso negato, riprova");
				} 
				catch (Exception e1) {
				
				}
				
						}
			
			
		});
		accedi.setBounds(163, 86, 89, 23);
		contentPane.add(accedi);
		
		JLabel inserisci_pass = new JLabel("Inserisci password per accesso a MySQL:");
		inserisci_pass.setBounds(89, 21, 316, 14);
		contentPane.add(inserisci_pass);
		
		eccezione = new JLabel("");
		eccezione.setBounds(124, 120, 169, 53);
		contentPane.add(eccezione);
		
		pass_sql = new JPasswordField();
		pass_sql.setBounds(118, 55, 175, 20);
		contentPane.add(pass_sql);
	}

	public static String getPassw() {
		return passw;
	}
}
