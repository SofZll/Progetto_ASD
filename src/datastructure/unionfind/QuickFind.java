package src.datastructure.unionfind;

/**
 * Union find implementation based on Quick Find.
 * Nodes have a parent set, i.e. the set to which they belong.
 * Moreover, a node points to its brother node, in order
 * to have the possibility to traverses all the nodes in 
 * set. This is used to implement union: all the nodes in the
 * second set must change their parent set.
 * In this way, the complexity of union is proportional to the
 * size of the second set, i.e. O(n) given that sets contain
 * at most n elements.
 *
 * @param <D> type of the data object 
 */	
public class QuickFind<D> implements UnionFind<D, QFnode<D>, QFset<D>> {

	/**
	 * Creates an union find structure following the QuickFind implementation
	 */	
	public QuickFind() { }	

	public QFnode<D> makeSet(D d) {
		return null;
	}

	public void union(QFset<D> s, QFset<D> t) {
		
	}
	
	public QFset<D> find(QFnode<D> n) {
		return null;
	}

}
