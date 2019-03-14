import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

class PanelTree extends JPanel {
	public Node tree;
	private FontMetrics fm;
	private int marge = 0;
	private int delta = 30;
	private int space = 5;
	private int start = 10;

	PanelTree(Node tree) {
		Font font = new Font("Helvetica", Font.PLAIN, 12);
		this.setFont(font);
		this.fm = this.getFontMetrics(font);
		this.tree = tree;
	}

	public void drawNode(Graphics g, int x, int y, String text) {
		int width = this.fm.stringWidth(text);
		int height = this.fm.getHeight();
		g.drawString(text, x-width/2, y+height/2);
		g.drawOval(x-width/2, y-height/2, width, height);
	}

	public void paintComponentRec(Graphics g, NodeDisplay nodeDisplay) {
		this.drawNode(g, nodeDisplay.posX, nodeDisplay.posY, nodeDisplay.val+"");
		if (nodeDisplay.filsDroit != null)
			paintComponentRec(g, nodeDisplay.filsDroit);
		if (nodeDisplay.filsGauche != null)
			paintComponentRec(g, nodeDisplay.filsGauche);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		NodeDisplay nodeDisplay = this.getDisplayInfo(this.tree);
		if (nodeDisplay != null)
			this.paintComponentRec(g, nodeDisplay);
	}

	public NodeDisplay getDisplayInfoRec(Node tree, int xN, int pos) {
		NodeDisplay nodeDisplay = new NodeDisplay();
		nodeDisplay.posX = xN;
		nodeDisplay.posY = pos;
		nodeDisplay.val = tree.elt;
		int width = this.fm.stringWidth(tree.elt+"");

		if (tree.nL == null)
			nodeDisplay.filsGauche = null;
		else {
			int sG = tree.nL.nR == null ? width/2+this.space : tree.nL.nR.countPlaceGraphique(this.fm, this.marge);
			nodeDisplay.filsGauche = this.getDisplayInfoRec(tree.nL, xN-sG, pos+this.delta);
		}
		if (tree.nR == null)
			nodeDisplay.filsDroit = null;
		else {
			int sD = tree.nR.nL == null ? width/2+this.space : tree.nR.nL.countPlaceGraphique(this.fm, this.marge);
			nodeDisplay.filsDroit = this.getDisplayInfoRec(tree.nR, xN+sD, pos+this.delta);
		}
		return nodeDisplay;
	}

	public NodeDisplay getDisplayInfo(Node tree) {
		if (tree != null) {
			if (tree.nL == null)
				return getDisplayInfoRec(tree, this.start, this.start);
			return getDisplayInfoRec(tree, tree.nL.countPlaceGraphique(this.fm, this.marge), this.start);
		}
		return null;
	}

	public FontMetrics getFontMetrics() {
		return this.fm;
	}
}