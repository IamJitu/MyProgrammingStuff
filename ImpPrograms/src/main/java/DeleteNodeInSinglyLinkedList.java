package main.java;
class DeleteNodeInSinglyLinkedList {
	static Node head;
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	void deleteNode(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		System.gc();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(12);
		list.head.next.next = new Node(1);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(1);

		list.printList(head);
		list.deleteNode(head.next.next);
		list.printList(head);
	}
}