import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Node {
	private String name;
	private Node parent;
	private boolean isActive = false; 
	private List<Node> children = new ArrayList<Node>(); 
	private int size = 0;
	private BufferedImage pic; 
	
	/* Constructor to set name of node*/
	public Node(String name){
		this.name = name; 
	}
	/* Constructor to set name and parent of node*/
	public Node(String name, Node parent){
		this.name = name; 
		this.parent = parent; 
		parent.addChild(this);
	}

	/* Method to add child to node */
	public void addChild(Node child){
		children.add(child);
		child.setParent(this);
		incrementSize();
	}
	
	/* Method called to update total number of children for self and all parents*/
	public void incrementSize(){
		size +=1; 
		if(parent != null){
			parent.incrementSize();
		}
	}
	
	/* Method to set self as active and update all parents */
	public void setActive(){
		isActive = true;
		if(parent != null){
			parent.setActive();
		}
	}
	
	/* Method to set self as inactive and update all children if needed*/
	public void setInActive(){
		isActive = false; 
		for(int i = 0; i < children.size(); i++){
			children.get(i).setInActive();
		}
	}
	
	/* Getters and Setters */
	public void setPic(String path){
		try {
			this.pic = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public String getName(){
		return name;
	}
	public Node getParent(){
		return parent; 
	}
	public void setParent(Node parent){
		this.parent = parent; 
	}
	public List<Node> getChildren() {
		return children; 
	}
	public int getSize(){
		return size; 
	}
	public boolean getActive(){
		return isActive; 
	}
	public BufferedImage getPic() {
		return pic;
	}	
	
}
