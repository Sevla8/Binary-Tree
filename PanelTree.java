import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

class PanelTree extends JPanel {
	public Node root;
	private FontMetrics fm;
	private int delta = 50;
	private int space = 10;

	public PanelTree(Node root) {
		Font font = new Font("Helvetica", Font.PLAIN, 12);
		this.setFont(font);
		this.fm = this.getFontMetrics(font);
		this.root = root;
	}

	public void drawNode(Graphics g, int x, int y, String text) {
		int widthText = this.fm.stringWidth(text);
		int heightText = this.fm.getHeight();
		g.drawString(text, x-widthText/2, y+heightText/2);
		int widthOval = widthText + 10;
		int heightOval = heightText + 10;
		g.drawOval(x-widthOval/2, y-heightOval/2, widthOval, heightOval);
	}

	public void drawArete(Graphics g, NodeDisplay nodeDisplay) {
		if (nodeDisplay.filsGauche != null) {
			int height = this.fm.getHeight();
			g.drawLine(nodeDisplay.posX, nodeDisplay.posY+height, nodeDisplay.filsGauche.posX, nodeDisplay.filsGauche.posY-height);
			this.drawArete(g, nodeDisplay.filsGauche);
		}
		if (nodeDisplay.filsDroit != null) {
			int height = this.fm.getHeight();
			g.drawLine(nodeDisplay.posX, nodeDisplay.posY+height, nodeDisplay.filsDroit.posX, nodeDisplay.filsDroit.posY-height);
			this.drawArete(g, nodeDisplay.filsDroit);
		}	
	}

	public void paintComponentRec(Graphics g, NodeDisplay nodeDisplay) {
		this.drawNode(g, nodeDisplay.posX, nodeDisplay.posY, nodeDisplay.val+"");
		if (nodeDisplay.filsGauche != null)
			paintComponentRec(g, nodeDisplay.filsGauche);
		if (nodeDisplay.filsDroit != null) 
			paintComponentRec(g, nodeDisplay.filsDroit);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		NodeDisplay nodeDisplay = this.getDisplayInfo(this.root);
		if (nodeDisplay != null) {
			this.paintComponentRec(g, nodeDisplay);
			this.drawArete(g, nodeDisplay);
		}
		// this.drawNode(g, 80, 150, "55");
	}

	public NodeDisplay getDisplayInfoRec(Node tree, int xNode, int yNode) {
		NodeDisplay nodeDisplay = new NodeDisplay();
		nodeDisplay.posX = xNode;
		nodeDisplay.posY = yNode;
		nodeDisplay.val = tree.val;

		if (tree.nodeLeft == null)
			nodeDisplay.filsGauche = null;
		else {
			int sG;
			sG = tree.sizeValue(this.fm)/2+this.space/2 + tree.nodeLeft.sizeValue(this.fm)/2+this.space/2;
			if (tree.nodeLeft.nodeRight != null)				
				sG += tree.nodeLeft.nodeRight.countPlaceGraphique(this.fm, this.space);
			nodeDisplay.filsGauche = this.getDisplayInfoRec(tree.nodeLeft, xNode-sG, yNode+this.delta);
		}
		if (tree.nodeRight == null)
			nodeDisplay.filsDroit = null;
		else {
			int sD;
			sD = tree.sizeValue(this.fm)/2+this.space/2 + tree.nodeRight.sizeValue(this.fm)/2+this.space/2;
			if (tree.nodeRight.nodeLeft != null)
				sD += tree.nodeRight.nodeLeft.countPlaceGraphique(this.fm, this.space);
			nodeDisplay.filsDroit = this.getDisplayInfoRec(tree.nodeRight, xNode+sD, yNode+this.delta);
		}
		return nodeDisplay;
	}

	public NodeDisplay getDisplayInfo(Node tree) {
		NodeDisplay nodeDisplay = new NodeDisplay();
		if (tree != null) {
			if (tree.nodeLeft != null)
				nodeDisplay = getDisplayInfoRec(tree, tree.nodeLeft.countPlaceGraphique(this.fm, this.space)+tree.sizeValue(this.fm)/2+this.space/2, this.delta);
			else
				nodeDisplay = getDisplayInfoRec(tree, tree.sizeValue(this.fm)/2+this.space, this.delta);
			return nodeDisplay;
		}
		return null;
	}

	public FontMetrics getFontMetrics() {
		return this.fm;
	}
}