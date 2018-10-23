import javax.swing.SwingUtilities;
public class Main {
	static Node root;
	static Window window = new Window();
	
	/* Main Application running thread */
	public static void main(String[] args) {
		
		// Start UI in separate thread // 
		SwingUtilities.invokeLater(window);
		
		// Make the tree structure //
		buildTree();
		/* Give window the tree*/
		window.setRoot(root);
		/* Refresh the window display */
		window.buildDisplay();
		
	}
	
	/* Builds the tree specified in the assignment*/
	/* Note modfication of this tree will reflect in the UI*/
	public static void buildTree(){		
		root = new Node("Chest");
		// Adding Lung Structures // 
		Node lungs = new Node("Lungs", root);
		Node Rlung = new Node("Right Lung", lungs);
		Node Llung = new Node("Left Lung", lungs);
		Rlung.addChild(new Node("Superior Lobe"));
		Rlung.addChild(new Node("Middle Lobe"));
		Rlung.addChild(new Node("Inferior Lobe"));
		Llung.addChild(new Node("Superior Lobe"));
		Llung.addChild(new Node("Inferior Lobe"));
		// Adding Heart Structure // 
		Node Heart = new Node("Heart", root);
		Heart.addChild(new Node("Left Vantricle"));
		Heart.addChild(new Node("Right Vantricle"));
		Heart.addChild(new Node("Left Aorta"));
		Heart.addChild(new Node("Right Aorta"));
		Heart.addChild(new Node("Septum"));
	}

}
