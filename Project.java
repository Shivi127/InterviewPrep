import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author shivangisingh
 *
 */
public class Project {
private ArrayList<Project> children = new ArrayList<Project>();
private HashMap<String, Project> map= new HashMap<String,Project>();
public String name;
public int dependencies=0;

public Project(String s) {
	name=s;
}
public void addNeighbor(Project node) {
	if(!map.containsKey(node.name)) {
		children.add(node);
		map.put(node.name, node);
		node.dependencies++;
	}
}

public void incrementDependencies() {
	dependencies++;
}
public void decrementDependencies() {
	dependencies--;
}
public String getName() { return name; }
public ArrayList<Project> getChildren(){ return children;}
public int getNumberDependencies() {return dependencies;}
}
