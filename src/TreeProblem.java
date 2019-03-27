
class Node {

	Node rightNode;
	Node leftNode;
	int leftCount = 0;
	int data;

	public void insert(int value) {

		if (value == data)
			return;
		else {
			if (value < data) {

				if (leftNode == null) {
					leftNode = new Node();
					leftCount++;
					leftNode.data = value;
				} else {
					leftCount++;
					leftNode.insert(value);
				}

			} else {
				if (rightNode == null) {
					rightNode = new Node();
					// leftCount++;
					rightNode.data = value;
				} else {
					rightNode.insert(value);
				}
			}
		}
	}

	public int getRank(int value) {

		if (data == value) {
			return leftCount;
		} else {
			if (value < data && leftNode != null) {
				return leftNode.getRank(value);
			} else if (rightNode != null) {
				if (rightNode.getRank(value) != -1)
					return leftCount + 1 + rightNode.getRank(value);
				else
					return -1;
			} else {
				return -1;
			}
		}
	}
}

public class TreeProblem {

	public static void main(String[] arg) {
		/*Node rootNode = new Node();
		rootNode.data = 20;

		rootNode.insert(15);
		rootNode.insert(18);
		rootNode.insert(9);
		rootNode.insert(17);
		rootNode.insert(19);
		rootNode.insert(30);
		System.out.println(rootNode.getRank(21));*/
		
		StringBuilder sb = new StringBuilder();
		sb.append((char)'c');
		sb.append("Angel Of Death");
		sb.append(666);
		System.out.println(sb.toString());
	}
}
