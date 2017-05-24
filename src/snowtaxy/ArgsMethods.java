package snowtaxy;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ArgsMethods implements IArgs
{
	public static void methodWithFiles(String[] args) throws IOException
	{
		Input<Utente> input = new FileInput<>(args[1], UtenteTransformers.fromSemicolonSeparated());
		Output<Utente> output = new FileOutput<>(args[2], UtenteTransformers.toSemicolonSeparated());
		
		try 
		{
			Utente utente;
			while ((utente = input.read()) != null) 
			{
				output.write(utente);
			}
			System.out.println("Tranfer succeded!!!!!");
		} 
		finally 
		{
			output.close();
			input.close();
		}
	}

}