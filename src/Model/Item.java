package Model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
/**
 * item element in xml
 * @author Suttanan Charoenpanich 5510547031
 *
 */
public class Item {
	//title of item.
	private String title;
	//description of item.
	private String description;
	//id of item.
	private int id;
	//link of item
	private String link;
	
	public Item(){
		
	}
	/**
	 * to get title of item.
	 * @return title of item.
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * to get description of item.
	 * @return description of item.
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * to get id of item.
	 * @return id of item.
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * to get link of item.
	 * @return link of item.
	 */
	public String getLink(){
		return link;
	}
	
	@Override
	public String toString(){
		return title;
	}
}
