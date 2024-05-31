package src.algorithm.MST;

import src.algorithm.sorting.Sorting;
import src.datastructure.graph.*;
import src.datastructure.unionfind.*;
import java.util.*;
import org.w3c.dom.css.Counter;

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
	QuickUnion<D> uf = new QuickUnion<D>();
	WeightedGraph<D> t = new WeightedGraphAL<D>();
	weight = 0;
	ArrayList<QUnode<D>> uf_node = new ArrayList<QUnode<D>>(g.vertexNum());

	for (Vertex<D> v : g.vertexes()) {
		t.addVertex(v.data);
		uf_node.add((int)v.data, uf.makeSet(v.data));
	}

	ArrayList<Edge<D>> edges = g.edges();
	Double[] sort_edge = new Double[edges.size()];
	for (int i = 0; i < edges.size(); i++) {
		WeightedEdge<D> we = (WeightedEdge<D>) edges.get(i);
		weight += we.weight;
		sort_edge[i] = we.weight;
	}

	Sorting.heapsort(sort_edge);

	for(Double w : sort_edge) {
		for (Edge<D> e : edges) {
			WeightedEdge<D> we = (WeightedEdge<D>) e;
			if (we.weight == w) {
				QUset source = uf.find(uf_node.get((int)we.source.data));
				QUset dest = uf.find(uf_node.get((int)we.dest.data));
				if(source != dest){
					t.addEdge(we);
					uf.union(source, dest);
				}
			}
		}
	}
	g = t;
	
}
	
	/**
	 * Returns the Minimum Spanning Tree (MST) of the weighted graph.
	 * 
	 * @return the Minimum Spanning Tree (MST) of the weighted graph
	 */
	public WeightedGraph<D> spanningTree() {
		WeightedGraph<D> T = new WeightedGraphAL<D>();
		for(Vertex<D> v : t.vertexes()) {
			T.addVertex(v.data);
		}
		for(Edge<D> e : t.edges()) {
			T.addEdge(e);
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