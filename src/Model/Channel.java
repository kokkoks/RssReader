package Model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="channel")
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * Channel element in xml.
 * @author Suttanan Charoenpanich 5510547031
 *
 */
public class Channel {
	//title of channel
	private String title;
	//link of channel
	private String link;
	//link of description
	private String description;
	// time of last update
	private String lastBuildDate;
	// time to live
	private String ttl;
	// item element
	private List<Item> item;
	
	public Channel(){
		
	}
	/**
	 * to get title of this channel.
	 * @return title is title of channel.
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * to set title  of channel.
	 * @param title is new title of channel.
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * to get link of channel.
	 * @return link of channel.
	 */
	public String getLink(){
		return link;
	}
	
	/**
	 * to set link of channel.
	 * @param link is new link of channel.
	 */
	public void setLink(String link){
		this.link = link;
	}
	
	/**
	 * to get description of channel.
	 * @return description of channel.
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * to set description of channel.
	 * @param description is new description of channel.
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	/**
	 * to get time of last update.
	 * @return tiem of last update.
	 */
	public String getLastBuildDate(){
		return lastBuildDate;
	}
	
	/**
	 * to get time to live
	 * @return time to live
	 */
	public String getTtl(){
		return ttl;
	}
	
	/**
	 * list of item in channel.
	 * @return items of channel.
	 */
	public List<Item> getItem(){
		return item;
	}
}
