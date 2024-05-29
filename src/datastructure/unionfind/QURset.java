package src.datastructure.unionfind;

/**
 * Generic set class for Quick Union with heuristic on the rank 
 */
public class QURset extends QUset {
		
	/** the rank of the set */
	protected int rank;
	
	/**
   	 * Constructs a set object with rank 0
	 */	
	public QURset() {
		super();
		this.rank = 0;
	}
	
}

