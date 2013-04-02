package gui;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import lists.ShipList;

public class GUI extends JFrame {
	private static final int width = 800;
	private static final int height = 600;
	
	private JLabel shipNameLabel, shipHullLevelLabel, shipSectorLocationLabel, shipPlanetLocationLabel, shipDetailedLocationLabel;
	private JTextField shipNameField, shipHullLevelField, ShipSectorLocationField, shipPlanetLocationField, shipDetailedLocationField;
	
	private Image guyImage;
	
	// TODO can't think of any buttons, sort this shit out Stanners
	private JButton launchLandButton, button2, button3, button4;	
	
	public GUI() {
		
		// guy = ImageIO.read(File /guy.png);
		
		// labels
		shipNameLabel = new JLabel("Ship Name: " + ShipList.shiplist.get(0).shipName, SwingConstants.CENTER);
		shipHullLevelLabel = new JLabel("Ship Hull Level: " + ShipList.shiplist.get(0).hullLevel + "/" + ShipList.shiplist.get(0).maxHull, SwingConstants.CENTER);
		shipDetailedLocationLabel = new JLabel(ShipList.shiplist.get(0).getLandedStatus(), SwingConstants.CENTER);
		
		// fields
		// shipNameField = new JTextField(ShipList.shiplist.get(0).shipName, SwingConstants.LEFT);
		// shipHullLevelField = new JTextField(ShipList.shiplist.get(0).hullLevel + "/" + ShipList.shiplist.get(0).maxHull, SwingConstants.LEFT);
		
		// buttons
		launchLandButton = new JButton("Launch/Land");
				
		
		setTitle("RaumSchiff92 - Very early development");
		
		// Container content = new Container();
		Container content = getContentPane();
		content.setLayout(new GridLayout(4,2));
		
		content.add(shipNameLabel);
		content.add(shipHullLevelLabel);
		content.add(shipDetailedLocationLabel);
		content.add(launchLandButton);
		
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		launchLandButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent launchLandButtonClick) {
				// TODO Auto-generated method stub
				ShipList.shiplist.get(0).launchOrLandShip();
				shipDetailedLocationLabel.setText(ShipList.shiplist.get(0).getLandedStatus());
				shipDetailedLocationLabel.repaint();
			}
			
		});			
	}
}
