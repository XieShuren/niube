package niube.priorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue priorityQueue = new PriorityQueue(10);
		priorityQueue.insert(1);
		priorityQueue.insert(2);
		priorityQueue.insert(13);
		priorityQueue.insert(4);
		while(!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.getAndExtract());
		}
	}
}
