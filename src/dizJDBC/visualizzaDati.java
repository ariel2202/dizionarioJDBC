package dizJDBC;
import java.sql.*;


public class visualizzaDati {
	
	
	//METODO PER VISUALIZZARE PAROLE DAL DIZIONARIO
	public void risposta() {
		try
		{
			//CREO LA CONNESSIONE
			Connection connessione =DriverManager.getConnection("jdbc:mysql://localhost:3306/dizionario","root","");
			Statement mioStatement = connessione.createStatement();
				
				//SELEZIONO LA PAROLA DA RICERCARE
				/*la parola 'alto' può essere sostituita da una qualsiasi parola
				che vogliamo visulaizzare presente nel nostro dizioanario*/
				String istruzione = "SELECT * FROM parola WHERE pChiave ='alto'";
				ResultSet mioResultset = mioStatement.executeQuery(istruzione);
			
				
				while(mioResultset.next()) {
					
					System.out.println("PAROLA :"+mioResultset.getString("pChiave"));
					System.out.println("SINONIMO :"+mioResultset.getString("sinonimo"));
					System.out.println("CONTRARIO :"+mioResultset.getString("contrario"));
				}
		}
		catch (SQLException e)
		{

			System.out.println("non si connette!!");
			
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) {
		
		//ISTANZIO UN OBJECT DI TIPO visualizzaDati
		visualizzaDati dd = new visualizzaDati();
		//RICHIAMO IL SUO METODO
		dd.risposta();
		
		

	}

}