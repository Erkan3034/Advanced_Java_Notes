package springIntro;

//DAL içinde insert operasyonlarını yazarız
public class OracleCustomerDal implements ICustomerDal {
	
	//String Injection
	
	String connectionString;
	
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	//Db kodları yer alır.
	public void add() {
		System.out.println("Connection String: " +this.connectionString);
		System.out.println("Oracle veritabanına eklendi");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
}
