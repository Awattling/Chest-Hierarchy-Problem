import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Window implements Runnable{

	JFrame frame = new JFrame("Chest Hierarchy");
	JPanel panel = new JPanel(null);
	Node root;
	
	/* Because the window is intended to run in a separate thread from the main program it must implement the runnable interface and override the run method*/
	@Override
	public void run() {
		/* Setting up basics on window such as visibility and close operations */ 
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		/* Adding Panel to window to act as lightweight container*/
		frame.add(panel); 
	}
	
	/* Method to build the contents of the window and refresh as needed */
	public void buildDisplay(){
		/* Remove panel elements to build new one*/
		panel.removeAll();
		
		
		/* Images */	
		//showImages(root ,0);
		
		
		
		/* Recursive call to root to show all components required for the tree structure buttons*/
		displayTree(root, 0, 0);
		
	
		
		/* Display updates to panel */
		panel.revalidate();
		panel.repaint();
		
		/* Resizes the window so everything fits */
		//frame.pack();
	
	}
	
	/*private void showImages(Node branch, int layer) {
		JLayeredPane pan = new JLayeredPane();
		pan.setPreferredSize(new Dimension(300,300));
		pan.setBackground(Color.BLUE);
		if(!branch.getChildren().isEmpty()){
			for(int i = 0; i < branch.getChildren().size(); i++){
				showImages(branch.getChildren().get(i), gbc, layer + 1);
			}
		}
		if(branch.getActive() && branch.getPic() != null){
			System.out.println(branch.getName());
			//JLabel picLabel = new JLabel(new ImageIcon(branch.getPic()));
			JLabel picLabel = new JLabel(branch.getName());
			pan.add(picLabel, new Integer(layer), 0);
		} 
		gbc.gridx = 100;
		gbc.gridy = 100;
		panel.add(pan, gbc);	
	
	}*/
	
	/* Recursive method to build the buttons with proper x, y coordinates according to gridbag layout */
	private void displayTree(Node branch, int x, int y) {
		/* Make button with name of node */
		JButton btn = new JButton(branch.getName());
		
		/* Change listener and button color based on active state of Node */
		if(branch.getActive()){
			btn.setBackground(Color.GREEN);
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					branch.setInActive();
					buildDisplay();
				}
			});
		}else{
			btn.setBackground(Color.RED);
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					branch.setActive();
					buildDisplay();
				}
			});
		}
		

		panel.add(btn);	
				/* Add button to panel display at given x and y coordinates */
		btn.setSize(150, 50);
		btn.setLocation(x, y);
		
		/* Calculate x and y coordinates for children and recursive call*/
		if(!branch.getChildren().isEmpty()){
			for(int i = 0; i < branch.getChildren().size(); i++){
				/* Recursive call for children of given branch */
				displayTree(branch.getChildren().get(i), x+100, y + 50);
				/* Calculate y for next child based on how many total children nodes each child has (saved in node)*/
				if(branch.getChildren().get(i).getChildren().isEmpty()){
					y+=100;
				}else{
					y += branch.getChildren().get(i).getSize()*50;
				}
				
				
			}
		}
		
	}
	
	/* Set root node of tree to be displayed
	 * Note: if this changes past first render you will need to call buildDisplay()*/
	public void setRoot(Node root){
		this.root = root; 
	}

}
