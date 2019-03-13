import javax.swing.JFrame;
import java.awt.Font;
import java.awt.FontMetrics;

class Main {
	public static void main(String[] args) {
		// affichage d'un noeud
		/*JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BinaryTree");
		PanelTree panelTree = new PanelTree();
		panelTree.setOpaque(true);
		frame.add(panelTree);
		frame.setVisible(true);*/

		// affichage du nombre de noeud
		/*Node tree = new Node(55);
		Node tmp = new Node(14);
		tmp.add(new Node(15), new Node(99));
		tree.add(null, tmp);
		System.out.println(tree.countNode());*/

		// affichage de la largeure nécéssaire
		/*Node tree = new Node(55);
		Node tmp = new Node(14);
		tmp.add(new Node(15), new Node(99));
		tree.add(null, tmp);
		PanelTree panelTree = new PanelTree(tree);
		System.out.println(panelTree.tree.countPlaceGraphique(panelTree.getFontMetrics(), 0));*/

		// affichage nodeDisplayInfo
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BinaryTree");
		Node tree = new Node(55);
		// Node tmp = new Node(14);
		// Node tmp2 = new Node(77);
		// Node tmp3 = new Node(11);
		// Node tmp4 = new Node(22);
		// tmp4.add(new Node(15), new Node(99));
		// tmp.add(new Node(998888889), new Node(777));
		// tmp3.add(tmp4, null);
		// tmp2.add(tmp, tmp3);
		tree.add(new Node(998888889), new Node(777));
		PanelTree panelTree = new PanelTree(tree);
		panelTree.setOpaque(true);
		frame.add(panelTree);
		frame.setVisible(true);
	}
}