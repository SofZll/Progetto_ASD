package src.algorithm.MST;

import java.util.*;
import src.algorithm.sorting.Sorting;
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
		QuickUnionRank<D> uf = new QuickUnionRank<D>(); //creation of the QuickUnionRank uf datastructure
		t = new WeightedGraphAL<D>(); //allocation of spece for the t WeightedGraph
		weight = 0;
		// creaton of two ArrayList to memorize the QUnode<D> and Vertex<D> that will be added to uf and t
		ArrayList<QUnode<D>> uf_node = new ArrayList<QUnode<D>>(g.vertexNum());
		ArrayList<Vertex<D>> vertexes = new ArrayList<Vertex<D>>(g.vertexNum());

		// vertexes are added to the data structures
		for (Vertex<D> v : g.vertexes()) {
			vertexes.add((int)v.data, t.addVertex(v.data));
			uf_node.add((int)v.data, uf.makeSet(v.data));
		}

		// creation of a ArrayList<WeightedEdge<D>> with all the edges of the graph to be sorted
		ArrayList<Edge<D>> edges = g.edges();
		ArrayList<WeightedEdge<D>> sort_edge = new ArrayList<WeightedEdge<D>>(edges.size());
		for (int i = 0; i < edges.size(); i++) {
			sort_edge.add((WeightedEdge<D>) edges.get(i));
		}

		Sorting.heapsort(sort_edge);
		
		/*
		* each edge is picked individually from the sorted ArrayList and if the souce and dest node are not in the same uf set
		* the edge is added to the MST and the two sets are merged
		*/
		for(WeightedEdge<D> we : sort_edge) {
			QUset source = uf.find(uf_node.get((int)we.source.data));
			QUset dest = uf.find(uf_node.get((int)we.dest.data));
			if(source != dest){
				weight += we.weight;
				WeightedEdge<D> e = new WeightedEdge<D>(vertexes.get((int)we.source.data), vertexes.get((int)we.dest.data), we.weight);
				t.addEdge(e);
				uf.union(source, dest);
			}
				
		}
	}
	
	/**
	 * Returns the Minimum Spanning Tree (MST) of the weighted graph.
	 * 
	 * @return the Minimum Spanning Tree (MST) of the weighted graph
	 */
	public WeightedGraph<D> spanningTree() {
		return t;
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