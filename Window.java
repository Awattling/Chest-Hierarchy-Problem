import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window implements Runnable{

	JFrame frame = new JFrame("Chest Hierarchy");
	JPanel panel = new JPanel();
	Node root;
	
	/* Because the window is intended to run in a separate thread from the main program it must implement the runnable interface and override the run method*/
	@Override
	public void run() {
		/* Setting up basics on window such as size, visibility and close operations */ 
		frame.setSize(700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		/* Adding Panel to window to act as lightweight container*/
		frame.add(panel); 
	}
	
	/* Method to build the contents of the window and refresh as needed */
	public void buildDisplay(){
		/* Remove panel elements to build new one*/
		panel.removeAll();
		
		/* Building gridbag layout */
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.insets = new Insets(5,5,5,-20);
		
		/* Recursive call to root to show all components nessary for the tree structure*/
		displayTree(root, gbc, 0, 0);
		
		/* Display updates to panel */
		panel.revalidate();
		panel.repaint();
	
	}

	/* Recursive method to build the buttons with proper x, y coordinates according to gridbag layout */
	private void displayTree(Node branch, GridBagConstraints gbc, int x, int y) {
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
		
		/* Add button to panel display at given x and y coordinates */
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(btn, gbc);	
		
		/* Calculate x and y coordinates for children and recursive call*/
		if(!branch.getChildren().isEmpty()){
			for(int i = 0; i < branch.getChildren().size(); i++){
				/* Recursive call for children of given branch */
				displayTree(branch.getChildren().get(i), gbc, x+1, y + 1);
				/* Calculate y for next child based on how many total children nodes each child has (saved in node)*/
				y += branch.getChildren().get(i).getSize() + 1;
				
			}
		}
	}
	
	/* Set root node of tree to be displayed
	 * Note: if this changes past first render you will need to call buildDisplay()*/
	public void setRoot(Node root){
		this.root = root; 
	}

}
