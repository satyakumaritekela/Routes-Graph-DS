/***** Author: Satya Kumar Itekela, Banner ID: B00839907 ****/

public class Vertex {
	protected int xValue;
	protected int yValue;
	protected int numberOfVertex;
	protected int shortestDistance;
	protected Vertex previousVertex;

	public Vertex(int xValue, int yValue, int numberOfVertex) {
		this.xValue = xValue;
		this.yValue = yValue;
		this.numberOfVertex = numberOfVertex;
		this.shortestDistance = Integer.MAX_VALUE;
	}

	public int getxValue() {
		return xValue;
	}

	public void setxValue(int xValue) {
		this.xValue = xValue;
	}

	public int getyValue() {
		return yValue;
	}

	public void setyValue(int yValue) {
		this.yValue = yValue;
	}

	public int getNumberOfVertex() {
		return numberOfVertex;
	}

	public void setNumberOfVertex(int numberOfVertex) {
		this.numberOfVertex = numberOfVertex;
	}

	public int getShortestDistance() {
		return shortestDistance;
	}

	public void setShortestDistance(int shortestDistance) {
		this.shortestDistance = shortestDistance;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}	
}