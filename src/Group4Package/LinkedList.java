package Group4Package;

/** LinkedList(): Class that handles the Linked List objects and methods
 * @author Aaron Prieger
 * @see LLInsert(), LLPrint(), LLSort()
 */
public class LinkedList {
	Player root;
	int nodeCount;
	
	/** LLPInsert(): inserts a node into a sorted linked list
	 * @param insertNode: node to be inserted into linked list
	 * @return void
	 */
	void LLInsert(Player insertNode)
	{
		Player tempNode;
        if (root == null || root.getWins() <= insertNode.getWins()){
        	insertNode.next = root;
        	root = insertNode;
        }
        else {
        	tempNode = root;
        	while (tempNode.next != null && tempNode.next.getWins() > insertNode.getWins()){
        		tempNode = tempNode.next;
        	}
        	insertNode.next = tempNode.next;
        	tempNode.next = insertNode;
        }
        nodeCount = nodeCount + 1;
	}
	
	/** LLPrint(): prints out the linked list for the leaderboard
	 * @return void
	 */
	String LLPrint()
	{
		Player tempNode = root;
		String output="";
		while (tempNode != null)
		{
			output = output + tempNode.getName() + ": Points: " + tempNode.getPoints() + ", Wins/Losses: " + tempNode.getWins() + "/" + tempNode.getLosses() + "\n";
			tempNode=tempNode.next;
		}
		return output;
	}
	
	/** LLSort(): sorts out the linked list for the leaderboard based on point count
	 */
	void LLSort()
	{
		Player front = root;
		Player test = root;
		Player temp;
		for (int i = 0; i < nodeCount; i++)
			while (test.next != null)
			{
				if (test.getPoints() > front.getPoints())
					temp = test;
				test = test.next;
			}
	}
}

