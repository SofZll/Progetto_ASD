package src.datastructure.graph;

import java.lang.reflect.Array;
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

	public int vertexNum() {
		return n;
	}

	public int edgeNum() {
		return m;
	}

	public ArrayList<Vertex<D>> vertexes() { 
		ArrayList<Vertex<D>> v = new ArrayList<Vertex<D>>();
		for (int i=0; i<n; i++) {
			v.add(vertex(i));
		}
		return v;
	}
	
	public ArrayList<Edge<D>> edges() {
		ArrayList<Edge<D>> l = new ArrayList<Edge<D>>();
		
		for(Vertex<D> v : vertexes()) {
			for(Edge<D> e : ((VertexAL<D>)v).adjac) {
				l.add(e);
			}
		}
		return l;
	}	

	public int outDegree(Vertex<D> v) {
		return ((VertexAL<D>)v).adjac.size();
	}
	
	public ArrayList<Edge<D>> outEdges(Vertex<D> v) {
		ArrayList<Edge<D>> l = new ArrayList<Edge<D>>();
		for (Edge<D> e : ((VertexAL<D>)v).adjac) {
			l.add(e);
		}
		return l;
	}
	
	public Edge<D> areAdjacent(Vertex<D> x, Vertex<D> y) {
		Edge<D> f = null;
		for (Edge<D> e : outEdges(x)) {
			if (e.dest == y) f = e;
		}
		return f;
	}

	public Vertex<D> addVertex(D data) {
		VertexAL<D> v = new VertexAL<D>(data,n);
		vertexes.add(v);
		n = n + 1;
		return v;
	}

	public void addEdge(Edge<D> e) {
		VertexAL<D> v = (VertexAL<D>)e.source;
		v.adjac.add(e);
		v = (VertexAL<D>)e.dest;
		v.adjac.add(e);
		m = m + 1;
	}
	
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
