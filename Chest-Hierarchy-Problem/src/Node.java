import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;
	private Node parent;
	private List<Node> children = new ArrayList<Node>(); 
	
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
	}
	
	// Used for Testing // 
	public void print(){
		System.out.println(name + " {");
		for(int x = 0; x < children.size(); x++){
			children.get(x).print();
		}
		System.out.println(" }");
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
}
