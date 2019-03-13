import java.awt.FontMetrics;

class Node {
	int elt;
	Node nL;
	Node nR;

	Node(int elt) {
		this.elt = elt;
		this.nL = null;
		this.nR = null;
	}

	public void add(Node nL, Node nR) {
		this.nL = nL;
		this.nR = nR;
	}

	public int countNode() {
		int count = 1;
		if (this.nL == null && this.nR == null)
			return count;
		if (this.nL == null)
			return count + this.nR.countNode();
		if (this.nR == null)
			return count + this.nL.countNode();
		return count + this.nR.countNode() + this.nL.countNode();
	} 

	public int countPlaceGraphique(FontMetrics fm, int marge) {
		int size = fm.stringWidth(this.elt+"");
		if (this.nL == null && this.nR == null)
			return size;
		if (this.nL == null)
			return size + this.nR.countPlaceGraphique(fm, marge) + marge;
		if (this.nR == null)
			return size + this.nL.countPlaceGraphique(fm, marge) + marge;
		return size + this.nL.countPlaceGraphique(fm, marge) + this.nR.countPlaceGraphique(fm, marge) + marge;
	}
}