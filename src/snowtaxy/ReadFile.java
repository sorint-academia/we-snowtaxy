package snowtaxy;

import snowtaxy.io.Input;
import snowtaxy.io.Output;
import snowtaxy.messages.MessageQueue;

public class ReadFile
{

	public static void main(String[] args)
	{
		ComponentFactory componentFactory = new ComponentFactory(args);
		MessageQueue messageQueue = new MessageQueue();

		try
		{

			Input input = componentFactory.createInput(messageQueue);
			input.start();
			
			Output output = componentFactory.createOutput(messageQueue);
			output.start();

		} catch (ComponentCreationException e)
		{
			e.printStackTrace();
		}
	}
}