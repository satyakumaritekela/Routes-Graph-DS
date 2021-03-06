# CSCI-3901-A3
Software Development Concepts - Dijkstra's Graph Algorithm

Overview
---------

This program lets you add new intersections, to define roads and navigate between the intersections to create a Halifax Map. The intersections are unique in the map and has x and y coordinates.

This program uses several implementations to create a road between the intersections and navigate through the shortest path between two intersections.

	-	The intersections contains only integer values.
	-	The defineRoad and navigate methods accepts two intersections.

Each of these cases have their own implementation using array lists of linked lists to create a path between the intersections.

Files and external data
-----------------------

  - HalifaxMap.java -- class that helps to create new intersections, define roads and navigate between the intersections
  -	Vertex.java	-- Class that helps to create a Vertex to store each intersection
  -	Edge.java	-- Class that helps to create a Edge between two intersections

Data structures and their relations to each other
-------------------------------------------------

The program uses newIntersection or defineRoad methods that takes coordinates as integer values and are stored in 
array lists of linked lists which is collection of all intersections that are adjacent to each other called Adjacency list and all the edges are added to arraylist called edgeList.

navigate method uses arraylist and queue data structure for storing all the univisted and visited intersections in the path to find the source and also for performing Dijkstra's algorithm.

	adjacenyList - Each new intersection is added to the arrayList and if any new intersection is adjacent to the 
		any vertex is added in the linked list.

	queuelist - Add all the intersections that are in the shortest path and add these intersections in the arraylist
		called unvisited list to perform dijkstra's algorithm.

Key algorithms and design elements
----------------------------------

	newIntersection
		- 	accepts the integer values x any y.
		-	new intersections in the map are created after finding whether they already exists or not in the map.
		-	this method uses findVertex to check if already exists
		-	if not found in the map new intersection is added to the Arraylist of linked lists to store the intersection.
		-	returns true if added to the map, else return false

	define Road
		-	accepts the four integer values for two intersections to define the road.
		- 	checks with the intersections if already present or not in the map using findvertex method.
		-	checks the road if already exists in the map and adds to the arraylist called edge list with the source and 
			destination intersection and the distance between them.
		- 	returns true if road is defined, else return false.

	navigate
		-	accepts the four integer values to find the shortest path between the two intersections.
		-	finds the existence of path present or not between the source and destination intersection using source 		found method which uses the queue and arraylist for adding all the intersections present between the path
		-	add all the intersections in the unvisited arraylist to perform dijkstra's algorithm.
		-	perform the dijkstra's algorithm to find the shortest path between the two intersections and print the 			following intersections in between.
		-	if there is no path present betweent the source and destination, print "no path"

Assumptions and Limitations
---------------------------
	- 	All the coordinates must be integer values.
	-	Distance between two intersections can be round off to integer value.
	-	All roads between the intersections are straight lines.
	-	Should not use any library package for your graph or for the algorithm to do matchings on your graph.
