import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

	@Test(dataProvider = "getData")
	public void trainTickets(String src, String dest,int total) {
		System.out.println("trainticket is from :" + src + "to" + dest + total + ""); 
	}
	
	@DataProvider()
	public  Object[][] getData() {
		
		Object[][] obj = new Object[3][3];
		
		obj[0][0] = "Hyd";
		obj[0][1]= "BNG";
		obj[0][2]= 10;
		
		obj[1][0]="CHN";
		obj[1][1]="KRN";
		obj[1][2]= 20;
		
		obj[2][0]="KYD";
		obj[2][1]="MRK";
		obj[2][2]= 30;
		
		
		return obj;
		
	}
}
