package View;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.bind.JAXBException;

import Controller.RssController;
import Model.Item;
import Model.Rss;
/**
 * Show and manage GUI.
 * @author Suttanan Charoenpanich 5510547031
 *
 */
public class GUI extends JFrame{
	
	
	private JButton button;
	private JPanel panel;
	private JPanel topLayout;
	private JPanel bottomLayout;
	private JPanel channelLayout;
	private JPanel itemLayout;
	private JPanel inputLayout;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private JTextField urlTextField;
	private RssController controller;
	private String url;
	private Item[] listItems;
	private JList jlists;
	private JLabel description;
	private JLabel linkLabel;
	private String link;
	
	/**
	 * constructor of this class.
	 */
	public GUI(){
		controller = new RssController();
		initUI();
	}
	
	/**
	 * initial GUI
	 */
	private void initUI(){
		
		this.createComponent();
		this.setLayout();
		this.addComponent();
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				url = urlTextField.getText();
				try {
					controller.setRss(url);
					listItems = new Item[controller.getItems().size()];
					jlists .setListData(controller.getItems().toArray(listItems));
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
		jlists.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent index) {
				// TODO Auto-generated method stub
				Item item = (Item) jlists.getSelectedValue();
				description.setText("<html>" + item.getDescription() + "</html>"  );
				link = item.getLink();
				linkLabel.setText(link);
			}
		});
		
		openLink();
		setTitle("Rss Reader");
		this.setSize(800,600);
		add(panel);
		setVisible(true);
	}
	
	/**
	 * add action in link
	 */
	private void openLink(){
		linkLabel.addMouseListener(new MouseAdapter() {
			   public void mouseClicked(MouseEvent e) {
				      if (e.getClickCount() > 0) {
				          if (Desktop.isDesktopSupported()) {
				                Desktop desktop = Desktop.getDesktop();
				                try {
				                    URI uri = new URI(link);
				                    desktop.browse(uri);
				                } catch (IOException ex) {
				                    ex.printStackTrace();
				                } catch (URISyntaxException ex) {
				                    ex.printStackTrace();
				                }
				        }
				      }
				   }
				});
		
	}
	
	/**
	 * to add all component.
	 */
	private void addComponent() {
		panel.add(topLayout);
		panel.add(bottomLayout); 
		
		topLayout.add(channelLayout);
		topLayout.add(itemLayout);
		
		bottomLayout.add(urlTextField);
		bottomLayout.add(button);

		channelLayout.add(scrollPane);
		itemLayout.add(scrollPane2);
		itemLayout.add(linkLabel);
	}

	/**
	 * set size of all component.
	 */
	private void setLayout(){
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		topLayout.setLayout(new BoxLayout(topLayout, BoxLayout.X_AXIS));
		bottomLayout.setLayout(new BoxLayout(bottomLayout, BoxLayout.X_AXIS));
		channelLayout.setLayout(new BoxLayout(channelLayout, BoxLayout.Y_AXIS));
		itemLayout.setLayout(new BoxLayout(itemLayout, BoxLayout.Y_AXIS));

		itemLayout.setPreferredSize(new Dimension(500, 570));
		topLayout.setPreferredSize(new Dimension(800,570));
		bottomLayout.setPreferredSize(new Dimension(800, 30));
		channelLayout.setPreferredSize(new Dimension(300, 570));
		description.setPreferredSize(new Dimension(500,550));
		linkLabel.setPreferredSize(new Dimension(500, 20));
		
//		description.setLineWrap(true);
	}
	
	/**
	 * declare all component.
	 */
	private void createComponent(){
		panel = new JPanel();
		topLayout = new JPanel();
		bottomLayout = new JPanel();
		inputLayout = new JPanel();
		channelLayout = new JPanel();
		itemLayout = new JPanel();
		urlTextField = new JTextField();
		jlists = new JList();
		description = new JLabel();
		button =  new JButton("Enter");
		scrollPane = new JScrollPane(jlists);
		scrollPane2 = new JScrollPane(description); 
		linkLabel = new JLabel();
	}
}
