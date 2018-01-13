import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 */

/**
 * @author shivangisingh
 *Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route
 * between two nodes.
 *
 *Questions to ask:
 *Do you want to find the path too?
 *How are the adjacent nodes stored? Can we assume a Graph structure with adjacency lists?
 */
public class RouteBetweenNodes {

	enum State{ Univisted, Visiting, Visited;}
//	Depth first search
	
	public boolean pathExists(Graph g,Node start, Node end) {
//		Base case when you have found the node
		if(start == end) {
			return true;
		}
		
		LinkedList<Node> q= new LinkedList<Node>();
//		Mark all nodes as unvisited
		for( Node u: g.getNodes()) {
			u.state=State.Unvisited;
		}
		
		start.state=State.Visiting;
		q.add(start);
		Node u;
		
		while(!q.isEmpty()) {
			u=q.removeFirst();
			
			if(u!=null) {
				for(Node v=u.getAdjacent()) {
					if(v.state=State.Univisted) {
						if(v== end) {
							return true;
						}
						else {
							v.state=State.Visiting;
							q.add(v);
						}
					}
				}
				u.state=State.Visited;
			}	
		}
		return false;	
	}
	
	
	
//	Key concepts:
//	Should have a state
	
	
	public boolean DFS(Graph g, Node s, Node e) {
		if(s==e) {
			return true;
		}
		
		else {
			Stack<Node> st= new Stack<Node>();
			
			for(Node n : g.getNodes()) {
				n.state=State.Univisted;
			}
			
			st.push(s);
			Node temp;
			
			while(!st.isEmpty()){
				temp=st.pop();
				temp.state=State.Visited;
				for(Node n: temp.getAdjacent()) {
					if(n.state=State.Univisted) {
						if(n==e) {
							return true;
						}
						st.push(n);
					}
				}
				return false;
			}
			
		}
		
	}
}
