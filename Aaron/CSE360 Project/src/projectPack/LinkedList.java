package projectPack;

/** LinkedList(): Class that handles the Linked List objects and methods
 * @author Aaron Prieger
 * @see LLInsert(), LLPrint(), LLSort()
 */
public class LinkedList {
	Player root;
	
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
	}
	
	/** LLPrint(): prints out the linked list for the leaderboard
	 * @return void
	 */
	void LLPrint()
	{
		Player tempNode = root;
		while (tempNode != null)
		{
			System.out.println(tempNode.getName() + ": " + tempNode.getWins() + " wins/" + tempNode.getLosses() + " losses.");
			tempNode=tempNode.next;
		}
	}
	/** LLSort(): returns a sorted linked list based on the number of wins
	 * @return tempList: sorted list
	 */
	LinkedList LLSort()
	{
		Player temp = root;
		LinkedList tempList = new LinkedList();
		while (temp != null)
		{
			tempList.LLInsert(temp);
			temp=temp.next;
		}
		return tempList;
	}
}
