package dizJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class eliminaDati {
	
	
		//METODO PER ELIMINARE PAROLE DAL DIZIONARIO
	public void elimina() {
		try
		{
			//CREO LA CONNESSIONE
			Connection connessione =DriverManager.getConnection("jdbc:mysql://localhost:3306/dizionario","root","");
				Statement mioStatement = connessione.createStatement();
				
				//SELEZIONO LA PAROLA DA ELIMINARE
				//ESEGUO L'ISTRUZIONE
				/*la parola 'bello' può essere sostituita da una qualsiasi parola
				che vogliamo eliminare presente nel nostro dizioanario*/
				String istruzioneSql ="DELETE FROM parola WHERE pChiave='bello'";
				mioStatement.executeUpdate(istruzioneSql);
				System.out.println("parola ELIMINATA correttamente");
				
		}
		catch (SQLException e)
		{

			System.out.println("non si connette!!");
			
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		
		//ISTANZIO UN OBJECT DI TIPO eliminaDati
		eliminaDati uno = new eliminaDati();
		
		//RICHIAMO IL SUO METODO
		uno.elimina();

	}

}

