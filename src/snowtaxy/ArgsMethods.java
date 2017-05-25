package snowtaxy;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ArgsMethods implements IArgs
{
	public static void methodWithFiles(String[] args) throws IOException
	{
		Input input = new FileInput(args[1], UtenteTransformers.fromSemicolonSeparated());
		Output output = new FileOutput(args[2], UtenteTransformers.toSemicolonSeparated());

		try
		{
			Utente utente;
			while ((utente = input.read()) != null)
			{
				output.write(utente);
			}
			System.out.println("Transfer succeded!!!!!");
		} finally
		{
			output.close();
			input.close();
		}
	}

	public static void methodWithStdInAndFile(String[] args) throws IOException
	{
		Input in = new StdInput(UtenteTransformers.fromSemicolonSeparated());
		Output output = new FileOutput(args[1], UtenteTransformers.toSemicolonSeparated());

		try
		{
			Utente utente;
			while ((utente = in.read()) != null)
			{
				output.write(utente);
			}
			System.out.println("Transfer succeded!!!!!");
		} finally
		{
			output.close();
			in.close();
		}
	}

	public static void methodWithStdInAndStdOut() throws IOException
	{
		Input in = new StdInput(UtenteTransformers.fromSemicolonSeparated());
		Output output = new StdOutput(UtenteTransformers.toSemicolonSeparated());

		try
		{
			Utente utente;
			while ((utente = in.read()) != null)
			{
				output.write(utente);
			}
			System.out.println("Transfer succeded!!!!!");
		} finally
		{
			output.close();
			in.close();
		}
	}

	public static void methodWithFileAndStdOut(String[] args) throws IOException
	{
		Input in = new FileInput(args[1], UtenteTransformers.fromSemicolonSeparated());
		Output output = new StdOutput(UtenteTransformers.toSemicolonSeparated());

		try
		{
			Utente utente;
			while ((utente = in.read()) != null)
			{
				output.write(utente);
			}
			System.out.println("Transfer succeded!!!!!");
		} finally
		{
			output.close();
			in.close();
		}
	}

}