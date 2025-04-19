package springIntro;

public class MsSqlCustomerDal  implements ICustomerDal{
	
	//String Injection
	
	String connectionString;
	
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	

	@Override
	public void add() {
		System.out.println("Connection String: " +this.connectionString);
		System.out.println("MsSql veritabanına eklendi...");
	}

	@Override
	public void delete() {
		System.out.println("MsSql veritabanından silindi...");
		
	}
	

}
