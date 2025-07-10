package Gneric_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyzer implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		int count =0;
		int retry = 4;
		if(count<retry) {
			count++;
			return true;
		}
		return false;
	}
	

}
