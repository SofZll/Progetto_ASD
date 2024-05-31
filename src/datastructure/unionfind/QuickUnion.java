package src.datastructure.unionfind;

/**
 * Union find implementation based on Quick Union.
 * Sets are initially singleton (they points to themselves as
 * the parent set). Then they change their parent when 
 * they are the second parameter of the union operation.
 * The complexity of union is constant.
 * The find operation traverses the tree from a set of interest 
 * to return the root set. The complexity is O(h), where h is the 
 * distance from the initial set to the root. The maximal h is n-1,
 * hence the worst complexity for find is O(n).
 *   
 * @param <D> type of the data object 
 */	
public class QuickUnion<D> implements UnionFind<D, QUnode<D>, QUset> {

	/**
	 * Creates an union find structure following the QuickUnion implementation
	 */	
	public QuickUnion() { }	

	public QUnode<D> makeSet(D d) {
		QUset s = new QUset();
		QUnode node = new QUnode(d, s);
		return node;
	}

	public void union(QUset s, QUset t) {
		if (s != t && s.parent == s && t.parent == t){
			t.parent = s;
		}
	}
	
	public QUset find(QUnode<D> n) {
		QUset s = n.set;
		while(s != s.parent){
			s = s.parent;
		}
		return s;
	}

}
