
public class TreeNode {
	private Integer data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private boolean isDeleted = false;

	public TreeNode(Integer data) {
		this.data = data;
	}
	
	public void insert (Integer data) {
		TreeNode newNode = new TreeNode(data);
		if (data < this.data) {
			if (leftChild == null) {
				this.setLeftChild(newNode);
			} else {
				leftChild.insert(data);
			}
		} else if (rightChild == null) {
			this.setRightChild(newNode);
		} else {
			rightChild.insert(data);
		}
	}

	public TreeNode find(Integer data) {
		if (this.data == data && !this.isDeleted)
			return this;
		if (data < this.data && leftChild != null)
			return leftChild.find(data);
		if (rightChild != null)
			return rightChild.find(data);
		return null;
	}

	public Integer getData() {
		return data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode left) {
		this.leftChild = left;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode right) {
		this.rightChild = right;
	}
	
	public void delete() {
		this.isDeleted = true;
	}
	
	public boolean isDeleted () {
		return isDeleted;
	}
	
	public TreeNode findMin () {
		if (this.getLeftChild() == null) {
			return this;
		} else {
			return this.getLeftChild().findMin();
		}
	}
	
	public TreeNode findMax () {
		if (this.getRightChild() == null) {
			return this;
		} else {
			return this.getRightChild().findMax();
		}
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
}
