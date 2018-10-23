import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;
	private Node parent;
	private boolean isActive = false; 
	private List<Node> children = new ArrayList<Node>(); 
	private int size = 0;
	
	public Node(String name){
		this.name = name; 
	}
	public Node(String name, Node parent){
		this.name = name; 
		this.parent = parent; 
		parent.addChild(this);
	}
	public void addChild(Node child){
		children.add(child);
		child.setParent(this);
		incrementSize();
	}
	
	public void incrementSize(){
		size +=1; 
		if(parent != null){
			parent.incrementSize();
		}
	}
	
	public void setActive(){
		isActive = true;
		if(parent != null){
			parent.setActive();
		}
	}
	
	public void setInActive(){
		isActive = false; 
		for(int i = 0; i < children.size(); i++){
			children.get(i).setInActive();
		}
	}
	/* Getters and Setters */
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
	
}
