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

	public static void main(String[] args) throws Exception {
		ArrayList<Utente> listaUtenti = new ArrayList<>();
		File fileOrigine = new File("file/input.txt");
		File fileDest = new File("file/output.txt");
		BufferedReader br = new BufferedReader(new FileReader(fileOrigine));
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileDest));
		Input input = new Input();
		Output output = new Output();
		
		try {
			String linea;
			while ((linea = br.readLine()) != null) {
				Utente utente = input.utenteFromFile(linea);
				if (utente != null) {
					listaUtenti.add(utente);
				}
			}
		} catch (FileNotFoundException err) {
			System.out.println(err);
		} catch (IOException err) {
			System.out.println(err);
		}
		br.close();
		
		try {
			bw.write("Nome;Cognome;Ruolo;");
			bw.newLine();
			for(int i=0; i<listaUtenti.size(); i++) {
				bw.write(output.utenteToString(listaUtenti.get(i)));
				if (i < listaUtenti.size() - 1) {
					bw.newLine();
				}
			}
		} catch (IOException err) {
			System.out.println(err);
		}
		bw.close();
	}

}
