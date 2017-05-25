package snowtaxy;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ComponentFactory
{
	private final String[] args;

	public ComponentFactory(String[] args)
	{
		this.args = args;
	}

	public Input createInput() throws ComponentCreationException
	{
		if (args.length >= 2 && args.length <= 3 && args[0].equals("f"))
		{
			try
			{
				return new FileInput(args[1], UtenteTransformers.fromDelimitedInput());
			} catch (FileNotFoundException e)
			{
				throw new ComponentCreationException("Error creating file input", e);
			}
		} else if (args.length == 0 || args.length == 2 && args[0].equals("s"))
		{
			return new StdInput(UtenteTransformers.fromDelimitedInput());
		} else
		{
			throw new ComponentCreationException("Parameter not valid");
		}
	}

	public Output createOutput() throws ComponentCreationException
	{
		if (args.length == 3 && args[0].equals("f") || args.length == 2 && args[0].equals("s"))
		{
			try
			{
				return new FileOutput(args[1], UtenteTransformers.toSemicolonSeparated());
			} catch (IOException e)
			{
				throw new ComponentCreationException("Error creating file output", e);
			}
		} else if (args.length == 0 || args.length == 2 && args[0].equals("f"))
		{
			return new StdOutput(UtenteTransformers.toSemicolonSeparated());
		} else
		{
			throw new ComponentCreationException("Parameter not valid");
		}
	}
}