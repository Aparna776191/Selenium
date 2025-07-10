import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.openqa.selenium.devtools.v123.io.IO;


//public class Readdatafrompdf {
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		
//		File file = new File ("../Selenium/src/test/resources/Popup.pdf");
//		PDDocument document = PDDocument.load(file);
//		
//		int pages = document.getNumberOfPages();
//		
//		System.out.println(pages);
//		
//		 PDFTextStripper pdfStripper = new PDFTextStripper();
//          String text = pdfStripper.getText(document);
//          
// //         pdfStripper.setStartPage(3);
////          pdfStripper.setEndPage(6);
////          String data = pdfStripper.getText(pdfStripper);
//  //        System.out.println(data);
//          