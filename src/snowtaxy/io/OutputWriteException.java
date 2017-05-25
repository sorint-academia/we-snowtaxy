package snowtaxy.io;

@SuppressWarnings("serial")
public class OutputWriteException extends Exception
{

	public OutputWriteException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public OutputWriteException(String message)
	{
		super(message);
	}

	public OutputWriteException(Throwable cause)
	{
		super(cause);
	}

}
