
import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {
   public void demoXMLParser(InputStream output){

      try {	
         //File inputFile = new File("input.txt");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(output, userhandler);     
      } catch (Exception e) {
         e.printStackTrace();
      }
   }   
}

class UserHandler extends DefaultHandler {

   boolean bCityName = false;
   boolean bStateName = false;
   boolean bZipcode = false;
  // boolean bMarks = false;
   public void startElement(String uri, 
      String localName, String qName, Attributes attributes)
         throws SAXException {
     if (qName.equalsIgnoreCase("CITY")) {
    	 bCityName = true;
      } else if (qName.equalsIgnoreCase("STATE")) {
    	 bStateName = true;
      } else if (qName.equalsIgnoreCase("ZIP")) {
    	  bZipcode = true;
      }
   }

/*   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {
      if (qName.equalsIgnoreCase("Table")) {
         System.out.println("End Element :" + qName);
      }
   }

*/   
   public void characters(char ch[], 
      int start, int length) throws SAXException {
	   String city = null;
	   String state = null;
      if (bCityName) {
         System.out.print( 
          new String(ch, start, length));
//         city = new String(ch, start, length);
         bCityName = false;
      } else if (bStateName) {
         System.out.print(", " 
         + new String(ch, start, length));
//         state = new String(ch, start, length);
         bStateName = false;
      }
      
//      System.out.println(city+","+state);
   }

	
}
