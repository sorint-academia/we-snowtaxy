package snowtaxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	public static void main(String[] args) {
		//LETTURA INFO DA FILE E SALVATAGGIO SU FILE
		ArrayList<Utente> listaUtenti = new ArrayList<>();
		String nome, cognome, ruolo;
		File fileOrigine = new File("C:/Users/gava3/Desktop/corso-java/info.txt");
		File fileDest = new File("C:/Users/gava3/Desktop/corso-java/destinazione.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileOrigine))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				nome = linea.substring(0, linea.indexOf(";"));
				linea = linea.substring(nome.length() + 1, linea.length());
				cognome = linea.substring(0, linea.indexOf(";"));
				linea = linea.substring(cognome.length() + 1, linea.length());
				ruolo = linea.substring(0, linea.indexOf(";"));
				listaUtenti.add(new Utente(nome, cognome, ruolo));
			}
		} catch (FileNotFoundException err) {
			System.out.println(err);
		} catch (IOException err) {
			System.out.println(err);
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileDest))) {
			bw.write("Nome;Cognome;Ruolo;");
			bw.newLine();
			for(int i=0; i<listaUtenti.size(); i++) {
				bw.write(listaUtenti.get(i).getNome()+";"+listaUtenti.get(i).getCognome()+";"+listaUtenti.get(i).getRuolo()+";");
				bw.newLine();
			}
		} catch (IOException err) {
			System.out.println(err);
		}
	}

}
