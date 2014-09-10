package Model;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * RSS element in xml.
 * @author Suttanan Charoenpanich 5510547031
 *
 */
public class Rss {
	private Channel channel; 
	
	public Rss(){
		
	}
	
	/**
	 * to get channel in xml.
	 * @return
	 */
	public Channel getChannel(){
		return channel;
	} 
}
