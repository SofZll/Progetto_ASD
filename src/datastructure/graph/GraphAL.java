package src.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Implementation of graphs using adjacent lists
 * @param <D> type of the data object in the graph vertexes
 */	
public class GraphAL<D> implements Graph<D> {

	/** number of vertexes */
	protected int n;
	
	/** number of edges */
	protected int m;
	
	/** list of vertexes */
	protected ArrayList<VertexAL<D>> vertexes;

	/**
   	 * Constructs a graph with implementation using adjacent lists
	 */		
	public GraphAL(){
		n = 0;
		m = 0;
		vertexes = new ArrayList<VertexAL<D>>();
	}

	public int vertexNum() { }

	public int edgeNum() { }

	public ArrayList<Vertex<D>> vertexes() { }
	
	public ArrayList<Edge<D>> edges() {	}

	public int outDegree(Vertex<D> v) {	}
	
	public ArrayList<Edge<D>> outEdges(Vertex<D> v) { }
	
	public Edge<D> areAdjacent(Vertex<D> x, Vertex<D> y) { }

	public Vertex<D> addVertex(D data) { }

	public void addEdge(Edge<D> e) { }
	
	public void removeVertex(Vertex<D> v) {
		VertexAL<D> vAL = (VertexAL<D>)v;
		m = m - vAL.adjac.size();
		n = n - 1;
		if (vAL.index == n) {
			vertexes.remove(n);
		} else {
			VertexAL<D> vert = vertexes.remove(n);
			vert.index = vAL.index;
			vertexes.set(vert.index,vert);
		}
		Edge<D> e;
		for (int i=0; i<vertexes.size(); i++) {
			Iterator<Edge<D>> it = (vertexes.get(i)).adjac.iterator();
			while (it.hasNext()) { 
				e = it.next();
				if (e.dest == v) {
					it.remove();
					m = m - 1;
				}
			}					
		}
	}

	public void removeEdge(Edge<D> e) { }

	/**
	 *  Returns the index of a vertex
     *  @param v vertex
	 *  @return the index of the vertex v
	 */	
	protected int index(VertexAL<D> v) {
		return v.index;
	}

	/**
	 *  Returns the vertex with a given index
     *  @param i the index
	 *  @return the vertex v with index i
	 */		
 	protected VertexAL<D> vertex(int i) {
		if (i < 0 || i >= n) return null;
		return vertexes.get(i);
 	}

}
