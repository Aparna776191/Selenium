import org.testng.annotations.Test;
import org.testng.Assert;
public class Asssert {

	

	@Test
	

	public void m1() {
		
		
		String expData = "Appu";
		String actData = "Appa";
		//Assert.assertTrue( actData.equals(expData),"false");
		Assert.assertSame(expData, actData);
	}
}


