package progBd;
import java.security.SecureRandom;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;

import javax.swing.JOptionPane;

public class Driver {
	
	static Connection con;
	public static String exc;
	public static int flag;
	//op1
	public static void CreaAccount(String nome,String cognome,String email,String password,String indirizzo,String telefono)
	{
		String query="INSERT INTO accountuser VALUES('" + email+ "','" + password + "','" + nome + "','" + cognome + "','" + indirizzo + "','" + telefono + "')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(SQLIntegrityConstraintViolationException g) {
			System.out.println("Account già esistente");
			flag=0;
		}catch(Exception e) {
			System.out.println("Operazione non eseguita\n");
			flag=1;
			
		}
		
	}
	
	//op2
	public static void RegistraLocale(String nome,String tipologia,String indirizzo,String telefono) {
		String query= "INSERT INTO locale VALUES('" + nome + "','" + indirizzo + "','" + tipologia + "','" + telefono +"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(SQLIntegrityConstraintViolationException g) {
			System.out.println("Locale già esistente");
			flag=0;
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=1;
			
		}
	}
	
	//op3
	public static void Fattorino(String cf,String nome,String cognome,String telefono,String locale_nome,String locale_indirizzo)
	{
		String query="INSERT INTO fattorino VALUES('"+ cf + "','" + nome+ "','" +cognome+ "','" +telefono+ "','" +locale_nome+ "','" +locale_indirizzo +"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(SQLIntegrityConstraintViolationException g) {
			System.out.println("Dati non corretti");
			flag=0;
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=1;
		}
	}
	//op4
	public static void Recensione(String account_email,String descrizione,int stelle,String locale_nome,String locale_indirizzo)
	{
		String query= "INSERT INTO recensione(account_email,descrizione,stelle,locale_nome,locale_indirizzo) VALUES('" + account_email + "','" +descrizione+ "','" +stelle+ "','" +locale_nome+ "','" +locale_indirizzo+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			
			flag=0;
		}
	}
	
	//op5
	public static void EffettuaOrdine(String codice,String nota,double prezzo_tot,String email,String nome_locale,String indirizzo_locale,String codice_fiscale,String orario_previsto)
	{
		String query="INSERT INTO ordine(codice,nota,prezzo_tot,account_email,locale_nome,locale_indirizzo,fattorino_cf,orario_previsto) VALUES('"+codice+"','"+nota+"','"+prezzo_tot+"','"+email+"','"+nome_locale+"','"+indirizzo_locale+"','"+codice_fiscale+"','"+orario_previsto+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	public static void ComprendeP(String codice,String nome,int quantità) {
		String query="INSERT INTO comprende_p VALUES('"+codice+"','"+nome+"','"+quantità+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	public static void ComprendeB(String codice,String nome,int quantità) {
		String query="INSERT INTO comprende_b VALUES('"+codice+"','"+nome+"','"+quantità+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	public static double PrezzoP(String menu_nome,String NomeL,String IndirizzoL,String NomeP) {
		String query="SELECT prezzo FROM è_composto_p WHERE menù_nome='"+menu_nome+"'AND menù_locale_nome='"+NomeL+"'AND menù_locale_indirizzo='"+IndirizzoL+"'AND pietanza_nome='"+NomeP+"'\n";
		Statement s=null;
		ResultSet rs= null;
		double prezzo=0;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			while(rs.next()) {
				prezzo=rs.getDouble("prezzo");
			}
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return prezzo;
	}
	
	public static double PrezzoB(String menu_nome,String NomeL,String IndirizzoL,String NomeB) {
		String query="SELECT prezzo FROM è_composto_b WHERE menù_nome='"+menu_nome+"'AND menù_locale_nome='"+NomeL+"'AND menù_locale_indirizzo='"+IndirizzoL+"'AND bibita_nome='"+NomeB+"'\n";
		Statement s=null;
		ResultSet rs= null;
		double prezzo=0;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			while(rs.next()) {
				prezzo=rs.getDouble("prezzo");
			}
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			
			flag=0;
		}
		return prezzo;
	}
	
	public static String FattorinoRandom(String NomeL,String IndL) {
		String query="SELECT cf FROM fattorino WHERE locale_nome='"+NomeL+"' AND locale_indirizzo='"+IndL+"'\n";
		Statement s=null;
		ResultSet rs= null;
		String cf = null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			while(rs.next()) {
				cf=rs.getString("cf");
			}
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return cf;
	}
	
	public static void È_applicata(String codiceFC,String nomeL,String indL,String codiceOrdine) {
		String query="INSERT INTO è_applicata VALUES('"+codiceFC+"','"+nomeL+"','"+indL+"','"+codiceOrdine+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	public static int NumConsumazioniFC(String codice,String nomeL,String indL,String Email) {
		String query="SELECT num_consumazioni FROM fidelitycard WHERE codice='"+codice+"'AND locale_nome='"+nomeL+"'AND locale_indirizzo='"+indL+"'AND account_email='"+Email+"'\n";
		Statement s=null;
		ResultSet rs = null;
		int num_consumazioni=0;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			while(rs.next())
				num_consumazioni=rs.getInt("num_consumazioni");
		
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return num_consumazioni;
	}
	
	public static void AggiornaConsumazioni(String codice,String nomeL,String indL,String Email,int num_consumazioni) {
		String query = "update fidelitycard set num_consumazioni='"+num_consumazioni+"' WHERE codice='"+codice+"'AND locale_nome='"+nomeL+"'AND locale_indirizzo='"+indL+"'AND account_email='"+Email+"'\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	public static double SpesaMinima(String nomeL,String codiceCoupon,String indL) {
		String query="SELECT spesa_minima FROM coupon WHERE codice='"+codiceCoupon+"'AND locale_nome='"+nomeL+"'AND locale_indirizzo='"+indL+"'\n";
		Statement s=null;
		ResultSet rs = null;
		double spesa_minima=0;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			while(rs.next())
				spesa_minima=rs.getDouble("spesa_minima");
		
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return spesa_minima;
	}
	
	public static int Percentuale(String nomeL,String codiceCoupon,String indL) {
		String query="SELECT valore_sconto FROM coupon WHERE codice='"+codiceCoupon+"'AND locale_nome='"+nomeL+"'AND locale_indirizzo='"+indL+"'\n";
		Statement s=null;
		ResultSet rs = null;
		int valore_sconto=0;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			while(rs.next())
				valore_sconto=rs.getInt("valore_sconto");
		
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return valore_sconto;
	}
	
	public static void È_inserito(String codiceCoupon, String codiceOrdine) {
		String query = "INSERT INTO è_inserito VALUES('"+codiceCoupon+"',"+codiceOrdine+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	public static void FineOrdine(double prezzo_tot,String codiceOr,String cfFat,String orario_previsto1) {
		String query="update ordine set fattorino_cf='" +cfFat+ "',orario_previsto='"+orario_previsto1+"',prezzo_tot='"+prezzo_tot+"'WHERE codice='"+codiceOr+"'\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	//op6
	public static void È_composto_p (String menu_nome,String menu_locale_nome,String menu_locale_indirizzo,String pietanza_nome, double prezzo)
	{
		String query="INSERT INTO è_composto_p VALUES('" + menu_nome+ "','" +menu_locale_nome+ "','" +menu_locale_indirizzo+ "','" +pietanza_nome+ "','" +prezzo+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	//op6bis
	public static void È_composto_b (String menu_nome,String menu_locale_nome,String menu_locale_indirizzo,String bibita_nome, double prezzo)
	{
		String query="INSERT INTO è_composto_b VALUES('" + menu_nome+ "','" +menu_locale_nome+ "','" +menu_locale_indirizzo+ "','" +bibita_nome+ "','" +prezzo+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	//op7
	
	public static void CreaFidelityCard(String codice,String locale_nome,String locale_indirizzo,String email)
	{
		
		String query="INSERT INTO fidelitycard(codice,locale_nome,locale_indirizzo,account_email) VALUES('" +codice+ "','"  + locale_nome + "','" + locale_indirizzo + "','" +email+"')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	//op8
	public static ResultSet VisualizzaFidelityCard(String email)
	{
		String query="SELECT codice,locale_nome,num_consumazioni FROM fidelitycard WHERE account_email='" +email + "'\n ";
		Statement s=null;
		ResultSet rs = null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
	}
	
	//op9
	public static ResultSet ContaOrdini(String email)
	{
		String query="SELECT count(*) AS num_ordini FROM ordine WHERE account_email='"+ email+ "'\n";
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
	}
	
	//op10
	public static ResultSet VisualizzaFattorinoOrdine(String codice) {
		String query="SELECT nome,cognome,telefono FROM fattorino,ordine WHERE fattorino_cf=cf AND codice='"+ codice +"'\n";
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
	}
	
	//op11
	public static ResultSet VisualizzaOrdine(String codice) {
		String query="(SELECT pietanza_nome AS prodotto,quantità FROM ordine,comprende_p WHERE ordine_codice=codice and codice='"+ codice +"') UNION (SELECT	bibita_nome,quantità FROM ordine,comprende_b WHERE	ordine_codice=codice and codice='"+ codice +"')\n";
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
	}
	
	//op12
	public static void OffrireCoupon(String codice,String data_inizio,double spesa_minima,int valore_sconto,String scadenza,String locale_nome,String locale_indirizzo) {
		String query="INSERT INTO coupon VALUES('"+codice + "','" + data_inizio + "','" + spesa_minima + "','" + valore_sconto + "','" + scadenza + "','" + locale_nome + "','" + locale_indirizzo + "')\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			if(Driver.getFlag()==0)
				JOptionPane.showMessageDialog(null, "Errore");
		}
	}
	
	//op13
	public static ResultSet MediaStelle()
	{
		String query= "SELECT nome,telefono,avg(stelle) AS Valutazione_media FROM recensione,locale WHERE nome=locale_nome AND indirizzo=locale_indirizzo GROUP BY nome,indirizzo HAVING	Valutazione_media>=3";
		Statement s=null;
		ResultSet rs=null;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			
		}
		return rs;
	}
	
	
	//op14
	public static ResultSet PizzerieInLocalità(String localita)
	{
		String query="SELECT nome,indirizzo,telefono FROM locale WHERE tipologia=\"Pizzeria\" AND indirizzo LIKE '%"+ localita + "'\n" ;
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
	}
	
	//op15
	public static ResultSet DatiOrdine(String codice) {
		String query="SELECT codice,locale_nome,prezzo_tot,orario AS data_e_orario,orario_previsto AS orario_consegna,nota FROM ordine WHERE codice='"+codice+"'\n" ;
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=-1;
		}
		return rs;
	}
	
	//op16
	public static void RimuoviPietanzaMenu(String menu_nome,String menù_locale_nome,String menù_locale_indirizzo,String pietanza_nome)
	{
		String query="DELETE FROM è_composto_p WHERE  menù_nome='"+menu_nome + "' AND menù_locale_nome='" + menù_locale_nome + "'AND menù_locale_indirizzo='"+menù_locale_indirizzo+ "'AND pietanza_nome='"+pietanza_nome+"'\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	//op16bis
	public static void RimuoviBibitaMenu(String menu_nome,String menù_locale_nome,String menù_locale_indirizzo,String bibita_nome)
	{
		String query="DELETE FROM è_composto_b WHERE  menù_nome='"+menu_nome + "' AND menù_locale_nome='" + menù_locale_nome + "'AND menù_locale_indirizzo='"+menù_locale_indirizzo+ "'AND bibita_nome='"+bibita_nome+"'\n";
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	//op17
	public static ResultSet VisualizzaMenù(String locale_nome,String locale_indirizzo)
	{
		String query="SELECT nome FROM menù WHERE locale_nome='"+locale_nome+ "'AND locale_indirizzo='"+locale_indirizzo+"'\n";
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;

	}
	
	//op18
	public static void ModPrezzoPietanza(double prezzo,String menu_locale_nome,String menu_locale_indirizzo,String pietanza_nome,String menu_nome ) {
		String query="update è_composto_p set prezzo='"+ prezzo +"'where pietanza_nome='"+pietanza_nome+"' AND menù_locale_nome='"+menu_locale_nome+ "'AND menù_locale_indirizzo='"+menu_locale_indirizzo+ "'AND menù_nome='"+menu_nome+"'\n" ;
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	//op18bis
	public static void ModPrezzoBibita(double prezzo,String menu_locale_nome,String menu_locale_indirizzo,String bibita_nome,String menu_nome ) {
		String query="update è_composto_b set prezzo='"+ prezzo +"'where bibita_nome='"+bibita_nome+"' AND menù_locale_nome='"+menu_locale_nome+ "'AND menù_locale_indirizzo='"+menu_locale_indirizzo+ "'AND menù_nome='"+menu_nome+"'\n" ;
		Statement s=null;
		flag=-1;
		try {
			s=con.createStatement();
			s.execute(query);
			System.out.println("Operazione eseguita");
			s.close();
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
	}
	
	//op19
	public static ResultSet BibiteNonAlcoliche(String menu_locale_indirizzo,String menu_locale_nome)
	{
		String query="SELECT nome FROM bibita,è_composto_b WHERE grado_alcolico=0 AND nome=bibita_nome AND menù_locale_nome='"+menu_locale_nome+"' AND menù_locale_indirizzo='"+menu_locale_indirizzo+"'\n";
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
	}
	//op20
	public static ResultSet Ingredienti(String pietanza_nome)
	{
		String query="SELECT nome FROM ingrediente WHERE pietanza_nome='"+pietanza_nome+"'\n";
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
	}
	
	//op21
	public static ResultSet VisualizzaProdMenu(String menu_nome,String menu_locale_nome,String menu_locale_indirizzo)
	{
		String query="(SELECT bibita_nome AS nome,prezzo FROM è_composto_b WHERE menù_nome= '"+menu_nome+"' AND menù_locale_nome='"+ menu_locale_nome +"'AND menù_locale_indirizzo='"+ menu_locale_indirizzo+ "')"
				+ "UNION\r\n"
				+ "(SELECT pietanza_nome,prezzo\r\n"
				+ "FROM è_composto_p\r\n"
				+ "WHERE menù_nome='"+menu_nome+"'AND menù_locale_nome='"+menu_locale_nome +"'AND menù_locale_indirizzo='"+menu_locale_indirizzo+"')\n";

		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
	}
	
	//op22
	public static ResultSet FidCardAndCoupon()
	{
		String query="SELECT l.nome,l.indirizzo,l.telefono\r\n"
				+ "FROM locale as l,coupon as c\r\n"
				+ "WHERE l.nome=c.locale_nome \r\n"
				+ "		AND l.indirizzo=c.locale_indirizzo\r\n"
				+ "        AND l.nome IN (\r\n"
				+ "						SELECT l1.nome\r\n"
				+ "                        FROM locale as l1,fidelitycard as f\r\n"
				+ "                        WHERE l1.nome=f.locale_nome \r\n"
				+ "								AND l1.indirizzo=f.locale_indirizzo\r\n"
				+ ")";
		Statement s=null;
		ResultSet rs=null;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			//System.out.println(e);
		}
		return rs;
	}
	
	//op23
	public static ResultSet Resoconto(String nome_locale,String indirizzo,String anno_mese,String pietanza_nome,String bibita_nome){
		String query="SELECT count(o.codice) AS Ordinazioni_totali\r\n"
				+ "FROM ordine AS o,locale \r\n"
				+ "WHERE nome='"+nome_locale+"'AND indirizzo='"+indirizzo+"' AND nome=o.locale_nome AND indirizzo=o.locale_indirizzo AND o.orario LIKE'"+anno_mese+"%'\r\n"
				+ "	AND (o.codice IN(\r\n"
				+ "	SELECT o1.codice\r\n"
				+ "	FROM ordine as o1,comprende_p\r\n"
				+ "	WHERE o1.codice=ordine_codice AND pietanza_nome='"+pietanza_nome+"'\r\n"
				+ "	)\r\n"
				+ "	OR o.codice IN\r\n"
				+ " (\r\n"
				+ "	SELECT o2.codice\r\n"
				+ "	FROM ordine AS o2,comprende_b\r\n"
				+ "	WHERE o2.codice=ordine_codice AND bibita_nome='"+bibita_nome+"'\r\n"
				+ " )\r\n"
				+ ")";
		Statement s=null;
		ResultSet rs=null;
		flag=-1;
		try {
			s=con.createStatement();
			rs=s.executeQuery(query);
			System.out.println("Operazione eseguita");
			
		}catch(Exception e) {
			System.out.println("Operazione non eseguita");
			flag=0;
		}
		return rs;
		
	}
	
	public static boolean Accesso(String passw) throws Exception {

	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      
	      String DB_URL = "jdbc:mysql://localhost:3306/clickandeat";
	      con= DriverManager.getConnection(DB_URL,"root",passw); 
	      
	      
	      return true;
	    
	    }catch(Exception e) {
	    //salvo messaggio generato dall'eccezione
	    exc = e.getMessage();
	    return false;
	    }
	    
	  }
	  
	  //controllo password
	  public static boolean isValid(String pass) {
	      int minLenght = 8;
	      boolean maiuscola = false;
	      boolean minuscola = false;
	      boolean numero = false;
	      if (pass.length()>=minLenght) { 
	          for (int i = 0; i<pass.length(); i++) {
	              if (Character.isDigit(pass.charAt(i))) {
	                  numero = true;
	              } else {
	                  if (Character.isLowerCase(pass.charAt(i))) {
	                      minuscola = true;
	                  } else {
	                      if (Character.isUpperCase(pass.charAt(i))) {
	                          maiuscola = true;
	                      }
	                  }
	              }
	          }
	      } else {
	          return false;
	      }
	      return (maiuscola && minuscola && numero);
	  }
	  
	  //genero codice casuale
	  public static String randomCodice() {
		  String lower = "abcdefghijklmnopqrstuvwxyz";
	      String upper = lower.toUpperCase();
	      String numeri = "0123456789";
	      String perRandom = upper + lower + numeri;
	      int lunghezzaRandom = 10;

	      SecureRandom sr = new SecureRandom();
	      StringBuilder sb = new StringBuilder(lunghezzaRandom);
	      for (int i = 0; i < lunghezzaRandom; i++) {
	          int randomInt = sr.nextInt(perRandom.length());
	          char randomChar = perRandom.charAt(randomInt);
	          sb.append(randomChar);
	          }
	      return sb.toString();
	  }

	public static int getFlag() {
		return flag;
	}
}
