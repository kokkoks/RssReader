package Controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Model.Item;
import Model.Rss;

/**
 * To be controller between model part and view part.
 * @author Suttanan Charoenpanich 5510547031
 *
 */
public class RssController {
	private Rss rss;
	
	public RssController(){
		
	}
	/**
	 * to read xml file and change to object.
	 * @param urls url of website.
	 * @throws JAXBException
	 * @throws MalformedURLException
	 */
	public void setRss(String urls) throws JAXBException, MalformedURLException {
		JAXBContext ctx = JAXBContext.newInstance( Rss.class );
		Unmarshaller unmarshaller = ctx.createUnmarshaller( );
		URL file = new URL( urls );
		Object obj = unmarshaller.unmarshal( file );
		// the result (obj) is an instance of the XmlRootElement type
		rss = (Rss) obj;
	}
	
	/**
	 * to call list of items in xml file.
	 * @return items of xml.
	 */
	public List<Item> getItems(){
		return rss.getChannel().getItem(); 
	}
	
	/**
	 * to call description in each item.
	 * @param index is index of item.
	 * @return string of description in item.
	 */
	public String getDescription(int index){
		return rss.getChannel().getItem().get(index).getDescription();
	}
	
	/**
	 * to call title in each item.
	 * @param index is index of item.
	 * @return string of title in item.
	 */
	public String getTitle(int index){
		return rss.getChannel().getItem().get(index).getTitle();
	}
}
