package snowtaxy;

@SuppressWarnings("serial")
public class InputReadException extends Exception
{

	public InputReadException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public InputReadException(String message)
	{
		super(message);
	}

	public InputReadException(Throwable cause)
	{
		super(cause);
	}

}
