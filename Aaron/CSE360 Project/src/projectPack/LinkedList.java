package projectPack;

public class LinkedList {
	Player root;
	
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
	
	void LLPrint()
	{
		Player tempNode = root;
		while (tempNode.next != null)
		{
			System.out.println(tempNode.getName() + ": " + tempNode.getWins() + " wins/" + tempNode.getLosses() + " losses.");
			tempNode=tempNode.next;
		}
	}
}
