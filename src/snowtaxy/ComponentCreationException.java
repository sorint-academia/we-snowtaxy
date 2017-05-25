package snowtaxy;

@SuppressWarnings("serial")
public class ComponentCreationException extends Exception
{
	public ComponentCreationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ComponentCreationException(String message)
	{
		super(message);
	}

	public ComponentCreationException(Throwable cause)
	{
		super(cause);
	}

}