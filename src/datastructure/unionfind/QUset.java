package src.datastructure.unionfind;

/**
 * Generic Quick Union set class.
 */
public class QUset implements UFset {
		
	/** the parent set object (it is the same object if there is no parent) */
	protected QUset parent;

	/**
   	 * Constructs a set object 
	 */	
	public QUset () {
		this.parent = this;
	}
	
}

