/***** Author: Satya Kumar Itekela, Banner ID: B00839907 ****/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HalifaxMap {	
	List<LinkedList<Vertex>> adjacencyList = new ArrayList<>();	
	List<Edge> edgeList = new ArrayList<Edge>();
	ArrayList<Vertex> unVisited = new ArrayList<Vertex>();
	protected int totalNumberOfIntersections;
	protected int totalNumberOfRoads;
	
	public int getTotalNumberOfIntersections() {
		return totalNumberOfIntersections;
	}

	public void setTotalNumberOfIntersections(int totalNumberOfIntersections) {
		this.totalNumberOfIntersections = totalNumberOfIntersections;
	}

	public int getTotalNumberOfRoads() {
		return totalNumberOfRoads;
	}

	public void setTotalNumberOfRoads(int totalNumberOfRoads) {
		this.totalNumberOfRoads = totalNumberOfRoads;
	}

	public Boolean newIntersection(int x, int y) {
		Vertex foundVertex = findVertex(x, y);
		if(foundVertex != null) {
			System.out.println("Intersection "+ "("+x+","+y+") already present. Please add new one");
			return false;
		}
		else {
			totalNumberOfIntersections++;
			Vertex newVertex = new Vertex(x, y, getTotalNumberOfIntersections());
			LinkedList<Vertex> newLinkedList = new LinkedList<Vertex>();
			newLinkedList.add(newVertex);
			unVisited.add(newVertex.numberOfVertex - 1, newVertex);
			adjacencyList.add(newVertex.numberOfVertex - 1, newLinkedList);
			return true;			
		}
	}
	
	public Vertex findVertex(int x, int y) {
		if(adjacencyList.size() == 0) {
			return null;
		}
		else {
			Vertex returnVertex = null;
			for(LinkedList<Vertex> list : adjacencyList) {
				for(Vertex i : list) {				
					if(i.getxValue() == x && i.getyValue() == y) {
						returnVertex = i;
					}
				}
			}	
			return returnVertex;		
		}
	}
	
	public Boolean defineRoad(int x1, int y1, int x2, int y2) {
		if(findVertex(x1, y1) == null) {
			System.out.println("Intersection "+ "("+x1+","+y1+") is not present.");
			return false;
		}
		if(findVertex(x2, y2) == null) {
			System.out.println("Intersection "+ "("+x2+","+y2+") is not present.");
			return false;
		}
		Vertex vertexOne = findVertex(x1, y1);
		Vertex vertexTwo = findVertex(x2, y2);

		Vertex returnVertex = null;		
		
		int distance = (int) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		
		for(Vertex i : adjacencyList.get(vertexOne.getNumberOfVertex() - 1)) {	
			if(i == vertexTwo) {
				returnVertex = i;
			}
		}
		
		if(returnVertex != null) {
			System.out.println("Existence of road  ("+ x1 + "," + y1 + ") to ("+ x2 + "," + y2 + ") already exists. Please check the road and add new one");
			return false;
		}
		else {
			adjacencyList.get(vertexOne.getNumberOfVertex() - 1).add(vertexTwo);
			adjacencyList.get(vertexTwo.getNumberOfVertex() - 1).add(vertexOne);
			edgeList.add(getTotalNumberOfRoads(), new Edge(vertexOne, vertexTwo, distance));
			totalNumberOfRoads++;
			return true;
		}
	}
	
	public Void navigate(int x1, int y1, int x2, int y2) {
		Vertex currentVertex = null;
		Vertex shortestDistanceVertex = null;
		Vertex sourceVertex = null;
		int distance = 0;
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		
		if(findVertex(x1, y1) == null) {
			System.out.println("Intersection "+ "("+x1+","+y1+") is not present.");
			return null;
		}
		sourceVertex = findVertex(x1, y1);
		if(findVertex(x2, y2) == null) {
			System.out.println("Intersection "+ "("+x2+","+y2+") is not present.");
			return null;
		}
		else {
			currentVertex = findVertex(x2, y2);
			currentVertex.shortestDistance = 0;
			shortestDistanceVertex = currentVertex;
			currentVertex.previousVertex = null;
			unVisited.remove(currentVertex);
			visited.add(currentVertex);
		}
		
		boolean sourceFound = sourceFound(sourceVertex, currentVertex);
		
		if(sourceFound) {
			while(!unVisited.isEmpty()) {
				int minValue = Integer.MAX_VALUE;
				for(Vertex i : adjacencyList.get(currentVertex.getNumberOfVertex() - 1)) {	
					if((!visited.contains(i)) && (i != currentVertex)) {	
						distance = returnDistance(currentVertex.xValue, currentVertex.yValue, i.xValue, i.yValue);
						if(i.getShortestDistance() > currentVertex.getShortestDistance() + distance) {
							i.shortestDistance = currentVertex.getShortestDistance() + distance;
							i.setPreviousVertex(currentVertex);
						}
						if(minValue > i.shortestDistance) {
							shortestDistanceVertex = i;
							minValue = i.shortestDistance;
						}	
						currentVertex = shortestDistanceVertex;
					}
					unVisited.remove(currentVertex);
					visited.add(currentVertex);
				}	
			}	
			
			System.out.println("The Shortest path is:");
			while(sourceVertex != null) {
				System.out.println(sourceVertex.xValue +"\t"+ sourceVertex.yValue);
				sourceVertex = sourceVertex.previousVertex;
			}	
		}
		else {
			System.out.println("No path between: ("+ x1 + "," + y1 + ") to ("+ x2 + "," + y2 + ")");			
		}
		return null;		
	}
	
	public boolean sourceFound(Vertex soureVertex, Vertex destinationVertex) {
		boolean visitedVertices[] = new boolean[totalNumberOfIntersections];
		LinkedList<Vertex> queueList = new LinkedList<Vertex>(); 
		visitedVertices[soureVertex.getNumberOfVertex() - 1] = true; 
		queueList.add(soureVertex); 
		Iterator<Vertex> vertexChecker; 
		
        while(queueList.size() != 0) { 
        	soureVertex = queueList.poll(); 
            Vertex nextVertex; 
            vertexChecker = adjacencyList.get(soureVertex.getNumberOfVertex() - 1).listIterator();  
            while(vertexChecker.hasNext()) { 
            	nextVertex = vertexChecker.next(); 
                if(nextVertex == destinationVertex) {
                    return true;
                }  
                if(!visitedVertices[nextVertex.getNumberOfVertex() - 1]) { 
                	visitedVertices[nextVertex.getNumberOfVertex() - 1] = true;  
            		queueList.add(nextVertex); 
                } 
            }
        }         
		return false;
	}
	
	public int returnDistance(int x1, int y1, int x2, int y2) {
		int distance = 0;
		for(Edge e : edgeList) {	
			if((e.getSource().xValue == x1) && (e.getSource().yValue == y1) && (e.getDestination().xValue == x2) && (e.getDestination().yValue == y2)) {
				distance = e.getDistance();
			}
		}
		return distance;
	}
	
	public boolean displayMap() {
		if(totalNumberOfIntersections == 0) {
			System.out.println("There are no Intersections present in the Map");
		}
		else {
			System.out.println("List of Intersections and its connecting routes: ");
			for(LinkedList<Vertex> l : adjacencyList) {
				for(Vertex i : l) {				
					System.out.print("V"+i.getNumberOfVertex()+"("+ i.xValue +", "+ i.yValue + ") --> ");
				}
				System.out.println();
			}
		}
		System.out.println();
		return true;
	}
	
	public void displayEdgeList() {
		if(totalNumberOfRoads == 0) {
			System.out.println("There are no roads present in the Map");
		}
		else {
			System.out.println("List of Routes with distances: ");
			for(Edge e : edgeList) {		
				System.out.print("V"+e.getSource().getNumberOfVertex()+"("+ e.getSource().xValue +", "+ e.getSource().yValue + ") <--> ");
				System.out.print("V"+e.getDestination().getNumberOfVertex()+"("+ e.getDestination().xValue +", "+ e.getDestination().yValue + ") ");
				System.out.println("Distance between the route is: "+ e.getDistance());
			}
		}	
		System.out.println();	
	}
}
