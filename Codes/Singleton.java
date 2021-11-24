package test;
enum SingletonTest
{
    INSTANCE;
    // instance vars, constructor
 
    private final String connection;
     
    SingletonTest()
    {
        // Initialize the connection
        connection = "singleton connection";
    }
 
    // Static getter
    public static SingletonTest getInstance()
    {
        return INSTANCE;
    }
 
    public String getConnection()
    {
        return connection;
    }
}

class Singleton{
	
	public static void main(String[] args) {
		SingletonTest test = SingletonTest.INSTANCE;
		System.out.println( SingletonTest.INSTANCE);
		System.out.println(test.getConnection());
	}	
}