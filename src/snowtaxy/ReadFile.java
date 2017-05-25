package snowtaxy;

import java.io.IOException;

public class ReadFile
{
	public static void main(String[] args)
	{
		ComponentFactory componentFactory = new ComponentFactory(args);

		try (Input input = componentFactory.createInput(); Output output = componentFactory.createOutput();)
		{
			Utente utente;
			while ((utente = input.read()) != null)
			{
				output.write(utente);
			}
			System.out.println("Transfer succeded!!!!!");
		} catch (ComponentCreationException | OutputWriteException | InputReadException e)
		{
			e.printStackTrace();
		}
	}
}