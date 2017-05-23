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

	static String readLine(BufferedReader br) throws IOException {
		return br.readLine();
	}
	
	static Utente from(String linea) {
		if(linea != null)
		{
			String nome, cognome, ruolo;
			nome = linea.substring(0, linea.indexOf(";"));
			linea = linea.substring(nome.length() + 1, linea.length());
			cognome = linea.substring(0, linea.indexOf(";"));
			linea = linea.substring(cognome.length() + 1, linea.length());
			ruolo = linea.substring(0, linea.indexOf(";"));
			return new Utente(nome, cognome, ruolo);
		}
		return null;
	}
	
	static String record(Utente ut) {
		return ut.getNome() + ";" + ut.getCognome() + ";" + ut.getRuolo() + ";";
	}
	
	public static void main(String[] args) throws Exception {
		//LETTURA INFO DA FILE E SALVATAGGIO SU FILE
		ArrayList<Utente> listaUtenti = new ArrayList<>();
		String nome, cognome, ruolo;
		File fileOrigine = new File("source_file.txt").getAbsoluteFile();
		File fileDest = new File("destination_file.txt").getAbsoluteFile();
				
		BufferedReader br = new BufferedReader(new FileReader(fileOrigine));
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileDest));
		
		try {
			String linea;
			while ((linea = readLine(br)) != null) {
				listaUtenti.add(from(linea));
			}
		} catch (FileNotFoundException err) {
			System.out.println(err);
		} catch (IOException err) {
			System.out.println(err);
		} finally {
			br.close();
		}
		
		try {
			bw.write("Nome;Cognome;Ruolo;");
			bw.newLine();
			for(int i=0; i<listaUtenti.size(); i++) {
				bw.write(record(listaUtenti.get(i)));
				bw.newLine();
			}
		} catch (IOException err) {
			System.out.println(err);
		}
		finally {
			bw.close();
		}
	}

}
