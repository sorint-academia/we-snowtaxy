package snowtaxy;

public class ReadFile
{
    public static void main(String[] args) throws Exception 
    {
    	if(args.length > 0)
    	{
    		if(args[0].equals("f") && args.length == 3)
    		{
    			ArgsMethods.methodWithFiles(args);
    		}
    	}
    }
}