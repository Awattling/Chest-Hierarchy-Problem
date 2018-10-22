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
	}
	public void addChild(Node child){
		children.add(child);
	}
	
	
	
	public String getName(){
		return name;
	}
	public Node getParent(){
		return parent; 
	}
}
