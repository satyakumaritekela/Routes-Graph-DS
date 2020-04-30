/***** Author: Satya Kumar Itekela, Banner ID: B00839907 ****/

public class Edge {
	protected Vertex source, destination;
	protected int distance;

	public Edge(Vertex source, Vertex destination, int distance) {
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}	

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
