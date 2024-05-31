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
	@Override
	public void compute(WeightedGraph<D> g) {
		QuickUnion<D> uf = new QuickUnion<D>();
		t = new WeightedGraphAL<D>();
		weight = 0;
		ArrayList<QUnode<D>> uf_node = new ArrayList<QUnode<D>>(g.vertexNum());
		ArrayList<Vertex<D>> vertexes = new ArrayList<Vertex<D>>(g.vertexes());

		for (Vertex<D> v : g.vertexes()) {
			vertexes.add((int)v.data, t.addVertex(v.data));
			uf_node.add((int)v.data, uf.makeSet(v.data));
		}

		ArrayList<Edge<D>> edges = g.edges();
		ArrayList<WeightedEdge<D>> sort_edge = new ArrayList<WeightedEdge<D>>(edges.size());
		for (int i = 0; i < edges.size(); i++) {
			sort_edge.add((WeightedEdge<D>) edges.get(i));
		}

		Sorting.heapsort(sort_edge);
		

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
	@Override
	public WeightedGraph<D> spanningTree() {
		return t;
	}

	/**
	 * Returns the total weight of the Minimum Spanning Tree (MST) of the weighted graph.
	 * 
	 * @return the total weight of the Minimum Spanning Tree (MST) of the weighted graph
	 */
	@Override
	public double totalWeight() {
		return weight;
	}
}