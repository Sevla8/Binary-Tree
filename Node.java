import java.awt.FontMetrics;

class Node {
	public int val;
	public Node nodeLeft;
	public Node nodeRight;

	public Node(int val) {
		this.val = val;
		this.nodeLeft = null;
		this.nodeRight = null;
	}
	public Node(int val, Node nodeLeft, Node nodeRight) {
		this.val = val;
		this.nodeLeft = nodeLeft;
		this.nodeRight = nodeRight;
	}

	public void add(Node nodeLeft, Node nodeRight) {
		this.nodeLeft = nodeLeft;
		this.nodeRight = nodeRight;
	}

	public int sizeValue(FontMetrics fm) {
		return fm.stringWidth(this.val+"");
	}

	public int countNode() {
		int count = 1;
		if (this.nodeLeft == null && this.nodeRight == null)
			return count;
		if (this.nodeLeft == null)
			return count + this.nodeRight.countNode();
		if (this.nodeRight == null)
			return count + this.nodeLeft.countNode();
		return count + this.nodeRight.countNode() + this.nodeLeft.countNode();
	} 

	public int countPlaceGraphique(FontMetrics fm, int space) {
		int size = sizeValue(fm);
		if (this.nodeLeft != null)
			size +=  this.nodeLeft.countPlaceGraphique(fm, space);
		if (this.nodeRight != null)
			size +=  this.nodeRight.countPlaceGraphique(fm, space);
		return size + space;
	}
}