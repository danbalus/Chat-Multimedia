package Chat;


public class FileChat
{
    public static Monitor monitor;
    private static String nameToSend;
    public static void play()    
    {
        if(FileChat.monitor == null)
        {
            FileChat.monitor = new Monitor(nameToSend);
            monitor.setNameUserMonitor(nameToSend);
        }
        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                FileChat.monitor.setVisible(true);
            }
        });
    }
    
	public void setNameUser(String name) {
		// TODO Auto-generated method stub
		nameToSend = name;
		//System.out.println("nameToSend " +nameToSend);
	}
}