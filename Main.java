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
		/*Node root = new Node(1, 
			new Node(2,
				new Node(3,
					new Node(4),
					new Node(5)),
				new Node(6,
					new Node(7),
					new Node(8))), 
			new Node(9,
				new Node(10,
					new Node(11,
						new Node(12),
						new Node(13)),
					new Node(14, 
						new Node(15),
						new Node(16,
							new Node(17,
								null,
								new Node(18,
									new Node(19,
										new Node(20,
											new Node(21),
											null),
										null),
									new Node(22))),
							null))),
				new Node(23)));
		System.out.println(root.countNode());*/

		// affichage de la largeure necessaire
		/*Node root = new Node(1, 
			new Node(1,
				new Node(1,
					new Node(1),
					new Node(1)),
				new Node(1,
					new Node(1),
					new Node(1))), 
			new Node(9,
				new Node(1,
					new Node(1,
						new Node(1),
						new Node(1)),
					new Node(1, 
						new Node(1),
						new Node(1,
							new Node(1,
								null,
								new Node(1,
									new Node(1,
										new Node(1,
											new Node(1),
											null),
										null),
									new Node(1))),
							null))),
				new Node(1)));
		PanelTree panelTree = new PanelTree(root);
		System.out.println(root.sizeValue(panelTree.getFontMetrics()));
		System.out.println(panelTree.root.countPlaceGraphique(panelTree.getFontMetrics(), 0));*/

		// affichage arbre
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setLocation(0, 25);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BinaryTree");
		Node root = new Node(1, 
			new Node(2,
				new Node(3,
					new Node(4),
					new Node(5)),
				new Node(6,
					new Node(7),
					new Node(8))), 
			new Node(9,
				new Node(10,
					new Node(11,
						new Node(12),
						new Node(13)),
					new Node(14, 
						new Node(15),
						new Node(16,
							new Node(17,
								null,
								new Node(18,
									new Node(19,
										new Node(20,
											new Node(21),
											null),
										null),
									new Node(22,
										new Node(24,
											new Node (38),
											new Node(30)),
										new Node(25,
											new Node(26),
											new Node(27))))),
							new Node(31,
								new Node(32),
								new Node(33))))),
				new Node(23)));
		// Node root = new Node(101, 
		// 	new Node(22, new Node(40, new Node(8321), new Node(922224)), new Node(5, new Node(224), new Node(3, new Node(22), new Node(43, new Node(22), new Node(43))))), 
		// 	new Node(321209, new Node(6109, new Node(82367, new Node(20), new Node(13)), new Node(9097)), new Node(709)));	
		PanelTree panelTree = new PanelTree(root);
		panelTree.setOpaque(true);
		frame.add(panelTree);
		frame.setVisible(true);
	}
}