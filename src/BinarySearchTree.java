
public class BinarySearchTree { // for an illustrated guide, please refer to notes (or in an outsider's case, udemy's course on java data structures and algorithms section 7)
	public TreeNode root;
	
	public TreeNode find (int data) {
		if (root != null) {
			return root.find(data);
		} else {
			return null;
		}
	}
	
	public void insert (int data) {
		if (root == null) {
			this.root = new TreeNode(data);
		} else {
			this.root.insert(data);
		}
	}
	
	public void softDelete (int data) {
		this.find(data).delete();
	}
	
	public void delete (Integer data) {
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;
		if (current == null) {
			return; // this stops void type functions!
		}
		while (current != null && current.getData() != data) {
			parent = current;
			if (data < current.getData()) {
				current = current.getLeftChild();
				isLeftChild = true;
			} else {
				current = current.getRightChild();
				isLeftChild = false;
			}
		}
		if (current == null) {
			return;
		}
		if (current.getLeftChild() == null && current.getRightChild() == null) { // case 1: the node to be deleted has no children
			if (current == this.root) {
				this.root = null;
			} else if (isLeftChild == true) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
		} else if (current.getLeftChild() != null && current.getRightChild() == null) {// type 2 delete: node has 1 child
			if (current == this.root) {
				this.root = current.getLeftChild();
			} else if (isLeftChild == true) {
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild());
			}
		} else if (current.getRightChild() != null && current.getLeftChild() == null) { // type 2 delete: node has 1 child
			if (current == this.root) {
				this.root = current.getRightChild();
			} else if (isLeftChild == true) {
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
		} else {// type 3 delete: node has two children
			TreeNode successor = current.getRightChild();
			TreeNode parentOfSuccessor = current;
			while (successor.getLeftChild() != null) {
				parentOfSuccessor = successor;
				successor = successor.getLeftChild();
			}
			successor.setLeftChild(current.getLeftChild());
			TreeNode reassigned = null;
			if (successor.getRightChild() != null) {
				reassigned = successor.getRightChild();
			}
			successor.setRightChild(current.getRightChild());
			if (isLeftChild) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			successor.setRightChild(current.getRightChild());
			parentOfSuccessor.setLeftChild(reassigned);
		}
	}
	
	public TreeNode findMin () {
		return this.root.findMin();
	}
	
	public TreeNode findMax () {
		return this.root.findMax();
	}
	
	public void traverse (TreeNode node) {
		if (node.getLeftChild() != null) {
			traverse(node.getLeftChild());
		}
		System.out.println(node);
		if (node.getRightChild() != null) {
			traverse(node.getRightChild());
		}
	}
	
	public int leafCounter (TreeNode node, int counter) { // recursive method to find the number of leaves
		if (node.getLeftChild() != null || node.getRightChild() != null) {
			if (node.getLeftChild() != null) {
				counter = leafCounter(node.getLeftChild(), counter);
			}
			if (node.getRightChild() != null) {
				counter = leafCounter(node.getRightChild(), counter);
			}
		} else {
			counter++;
		}
		return counter;
	}
	
	public int getHeight (TreeNode node, int heightCounter) {
		heightCounter++;
		int heightRight = -1;
		int heightLeft = -1;
		if (node.getLeftChild() != null) {
			heightLeft = getHeight(node.getLeftChild(),heightCounter);
		}
		if (node.getRightChild() != null) {
			heightRight = getHeight(node.getRightChild(),heightCounter);
		}
		if (heightLeft != -1 || heightRight != -1) {
			if (heightRight > heightLeft) {
				return heightRight;
			} else {
				return heightLeft;
			}
		} else {
			return heightCounter;
		}
	}
	
	public void createBalancedTree (int[] array) {
		int start = 0;
		int end = array.length - 1;
		this.newBalancedTree(array, start, end);
		this.insert(array[array.length - 1]);
	}
	
	public void newBalancedTree (int[] arr, int start, int end) {
		System.out.println("Function initializes");
		if (start >= end || end > arr.length - 1) {
			System.out.println("Hitting end");
			return;
		} else {
			System.out.println("Going through else");
			int middle = (int) Math.floor((end - start)/2);
			middle = middle + start;
			this.insert(arr[middle]);
			newBalancedTree(arr, start, middle);
			newBalancedTree(arr, middle + 1, end);
		}
	}
}
