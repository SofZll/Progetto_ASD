package src.datastructure.unionfind;

/**
 * Generic Quick Union node class.
 * @param <D> type of the data object
 */
public class QUnode<D> implements UFnode {
		
	/** the data element */
	protected D elem;
	
	/** the initial set of the node */
	protected QUset set;
	
	/**
   	 * Constructs a node object 
   	 * @param data data value
     * @param set  the initial set of the new node
	 */	
	public QUnode (D data, QUset set) {
		this.elem = data; this.set = set;
	}
	
}