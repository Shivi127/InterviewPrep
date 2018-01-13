import java.util.ArrayList;

/**
 * 
 */

/**
 * @author shivangisingh
 *Build Order you are given a list of properties and a list of dependencies. All of the dependencies must be built 
 *before a project is. Find a build order that will allow the project to be build. If there is no valid build order than
 *return an error.
 *
 *Implementation from Cracking the Coding Interview.
 */
public class BuildOrder {

//	Find a correct Build Order
	
	Project[] findBuildOrfer(String[] projects, String[][] dependencies) {
		Graph g= buildGraph(projects, dependencies);
		return orderProjects(g.getNodes());
	}
	
/*Build the graph, adding the edge (a,b) if b is dependent on a. Assume a pair is listed in "build order". The pair
 * (a,b) dependencies indicate that b depends on a and a must be built before b.
 */
	Graph buildGraph(String[] projects,String[][] dependencies) {
		Graph g = new Graph();
		
		for(String p: projects) {
			g.getOrCreateNode(p);
		}
		
		for(String[] d: dependencies) {
			String f= d[0];
			String s=d[1];
			g.addEdge(f,s);
		}
		return g;
	}
	
	
	/* Return a list of the projects a correct build order. */
	
	Project[] orderProjects(ArrayList<Project> p) {
		Project[] order= new Project[p.size()];
		
		
		
//		Add roots to Build order- those nodes that dont have incoming edges
		int endOfList= addNonDependent(order,p,0);
		
		int toBeProcessed=0;
		
		while(toBeProcessed <order.length) {
			Project current =order[toBeProcessed];
			
			if(current == null) {
//				circular dependencies
				return null;
			}
			
//			Remove itself as a dependency
			ArrayList<Project> children= current.getChildren();
			for(Project c: children) {
				c.decrementDependencies();
			}
			
//			Add children with no dependencies
			endOfList=addNonDependent(order, children,endOfList);
			toBeProcessed++;
		}
		return order;
	}
	
//	Helper Function to insert projects with zero dependencies into the order array, starting at index off set.
	
	int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for(Project p: projects) {
			if(p.getNumberDependencies()==0) {
				order[offset]=p;
				offset++;
			}
		}
		return offset;
	}	
}
