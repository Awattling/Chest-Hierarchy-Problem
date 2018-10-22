
public class Main {
	static Node root;
	/* Main Application running thread */
	public static void main(String[] args) {
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
		root.print();
	}

}
