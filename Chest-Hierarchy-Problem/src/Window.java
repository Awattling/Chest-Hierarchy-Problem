import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window implements Runnable{

	JFrame frame = new JFrame("Chest Hierarchy");
	JPanel panel = new JPanel();
	Node root;
	@Override
	public void run() {
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		frame.add(panel); 
	}
	
	public void setRoot(Node root){
		this.root = root; 
	}
	public void showTree(){
		panel.removeAll();
		panel.revalidate();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.insets = new Insets(5,5,5,5);
		recursor(root, gbc, 0, 0);
		

		panel.revalidate();
		panel.repaint();
	
	}

	private void recursor(Node branch, GridBagConstraints gbc, int x, int y) {
		
		JButton btn = new JButton(branch.getName());
		if(branch.getActive()){
			btn.setBackground(Color.GREEN);
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					branch.setInActive();
					showTree();
				}
			});
		}else{
			btn.setBackground(Color.RED);
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					branch.setActive();
					showTree();
				}
			});
		}
		
		
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(btn, gbc);
		
		if(!branch.getChildren().isEmpty()){
			for(int i = 0; i < branch.getChildren().size(); i++){
				recursor(branch.getChildren().get(i), gbc, x+1, y + 1);
				if(branch.getChildren().get(i).getSize() == 0){
					y += 1; 
				}else{
					y += branch.getChildren().get(i).getSize() + 1;
				}
			}
		}
		
	}

}
