package dizJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class aggiungiDati {
	
	
	
		//METODO PER AGGIUNGERE PAROLE AL DIZIONARIO
	public void aggiungiParola() {
		try
		{
			//CREO LA CONNESSIONE
			Connection connessione =DriverManager.getConnection("jdbc:mysql://localhost:3306/dizionario","root","");
				Statement mioStatement = connessione.createStatement();
				
				//SELEZIONO I CAMPI DOVE VERRANNO AGGIUNTI I NUOVI DATI
				//ESEGUO L'ISTRUZIONE
				//i dati presenti nel campo VALUES possono essere sostituiti da altri dati!! 
				String istruzioneSql ="INSERT INTO parola (pChiave,sinonimo,contrario) VALUES ('forte','muscoloso','debole')";
				mioStatement.executeUpdate(istruzioneSql);
				System.out.println("parola aggiunta correttamente");
				
		}
		catch (SQLException e)
		{

			System.out.println("non si connette!!");
			
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		
		//ISTANZIO UN OBJECT DI TIPO modificaDATABASE
		aggiungiDati uno = new aggiungiDati();
		
		//RICHIAMO IL SUO METODO
		uno.aggiungiParola();

	}

}
