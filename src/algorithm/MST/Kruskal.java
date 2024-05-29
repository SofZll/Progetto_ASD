package src.algorithm.MST;

import src.datastructure.graph.*;
import src.datastructure.unionfind.*;

/**
 * This class contains the implementation of the Kruskal's algorithm for the construction of a Minimum Spanning Tree (MST) of a weighted graph.
 * 
 * @param <D> type of the data stored in the nodes of the graph
 */
public class Kruskal<D> implements MST<D> {

	// The WeightedGraph on which the MST is computed
	private WeightedGraph<D> t;
	
	// The total weight of the MST
	private double weight;

	/** 
	 * Computes the Minimum Spanning Tree (MST) of the specified weighted graph.
	 * 	
	 * @param g the weighted graph
	 */
    public void compute(WeightedGraph<D> g) {
		UnionFind<D, UFnode, UFset> UF = new UnionFindImpl<D, UFnode, UFset>();
		WeightedGraph<D> T = new WeightedGraphImpl<D>();
		for(int i = 1; i <= g.numNodes(); i++) {
			UF.makeSet(i);
		}
		sortedEdges = g.sortedEdges();
		double weight_g = 0;
		for(Edge<D> e : sortedEdges) {
			UFset<D> set1 = UF.find(e.getNode1());
			UFset<D> set2 = UF.find(e.getNode2());
			if(set1 != set2) {
				T.addEdge(e.getNode1(), e.getNode2(), e.getWeight());
				UF.union(set1, set2);
				weight_g += e.getWeight();
			}
		}
		g = T;
		weight = weight_g;
    }
	
	/**
	 * Returns the Minimum Spanning Tree (MST) of the weighted graph.
	 * 
	 * @return the Minimum Spanning Tree (MST) of the weighted graph
	 */
	public WeightedGraph<D> spanningTree() {
		WeightedGraph<D> T = new WeightedGraphImpl<D>();
		for(Edge<D> e : t.edges()) {
			T.addEdge(e.getNode1(), e.getNode2(), e.getWeight());
		}
		compute(T);
		return T;
		
	}
	
	/**
	 * Returns the total weight of the Minimum Spanning Tree (MST) of the weighted graph.
	 * 
	 * @return the total weight of the Minimum Spanning Tree (MST) of the weighted graph
	 */
	public double totalWeight() {
		return weight;		
	}
}