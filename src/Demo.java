
public class Demo {

	public static void main(String[] args) {
		
		// demoing creation and insert
		
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(52);
		binarySearchTree.insert(33);
		binarySearchTree.insert(65);
		binarySearchTree.insert(25);
		binarySearchTree.insert(39);
		binarySearchTree.insert(60);
		binarySearchTree.insert(78);
		binarySearchTree.insert(12);
		binarySearchTree.insert(27);
		binarySearchTree.insert(34);
		binarySearchTree.insert(48);
		binarySearchTree.insert(72);
		binarySearchTree.insert(90);
		binarySearchTree.insert(70);
		binarySearchTree.insert(38);
		System.out.println(binarySearchTree.root);//52
		System.out.println(binarySearchTree.root.getLeftChild());//33
		System.out.println(binarySearchTree.root.getRightChild());//65
		System.out.println(binarySearchTree.root.getRightChild().getLeftChild());//60
		System.out.println(binarySearchTree.root.getRightChild().getRightChild());//78
		System.out.println(binarySearchTree.root.getRightChild().getRightChild().getLeftChild());//72
		System.out.println(binarySearchTree.root.getRightChild().getRightChild().getRightChild());//90
		System.out.println(binarySearchTree.root.getRightChild().getRightChild().getLeftChild().getLeftChild());//70
		System.out.println(binarySearchTree.root.getLeftChild().getLeftChild());//25
		System.out.println(binarySearchTree.root.getLeftChild().getRightChild());//39
		System.out.println(binarySearchTree.root.getLeftChild().getRightChild().getLeftChild());//34
		System.out.println(binarySearchTree.root.getLeftChild().getRightChild().getRightChild());//48
		System.out.println(binarySearchTree.root.getLeftChild().getLeftChild().getLeftChild());//12
		System.out.println(binarySearchTree.root.getLeftChild().getLeftChild().getRightChild());//27
		System.out.println(binarySearchTree.root.getLeftChild().getLeftChild().getRightChild().getLeftChild());//null
		
		// demoing find
		
		System.out.println(binarySearchTree.find(39).getRightChild());// 48
		System.out.println(binarySearchTree.find(39));// 39
		System.out.println(binarySearchTree.find(72));// 72
		System.out.println(binarySearchTree.find(72).getLeftChild());// 70
		System.out.println(binarySearchTree.find(72).getRightChild());// null
		
		// demoing delete
		
		binarySearchTree.delete(34); // type 1 delete: TreeNode with no children
		
		System.out.println(binarySearchTree.find(39));// 39
		System.out.println(binarySearchTree.find(39).getRightChild());// 48
		System.out.println(binarySearchTree.find(39).getLeftChild());// null
		System.out.println(binarySearchTree.find(34));// null
		
		binarySearchTree.delete(34); // no ill effect
		
		binarySearchTree.delete(72); // type 2 delete: TreeNode with one child
		
		System.out.println(binarySearchTree.find(78));// 78
		System.out.println(binarySearchTree.find(78).getRightChild());// 90
		System.out.println(binarySearchTree.find(78).getLeftChild());// 70
		System.out.println(binarySearchTree.find(72));// null
		
		binarySearchTree.insert(34);
		binarySearchTree.insert(72);// restore tree to original state
		
		binarySearchTree.delete(33);// type 3 delete: TreeNode with two children
		
		System.out.println(binarySearchTree.find(33));// null
		System.out.println(binarySearchTree.find(34));// 34
		System.out.println(binarySearchTree.find(34).getRightChild());// 39
		System.out.println(binarySearchTree.find(34).getLeftChild());// 25
		System.out.println(binarySearchTree.find(34).getLeftChild().getLeftChild());// 12
		System.out.println(binarySearchTree.find(34).getLeftChild().getRightChild());// 27
		System.out.println(binarySearchTree.find(34).getRightChild().getLeftChild());// 38
		System.out.println(binarySearchTree.find(34).getRightChild().getRightChild());// 48
		
//		binarySearchTree.delete(65);// type 3 delete: alternative test- comment out all previous delete tests to run this one
//		
//		System.out.println(binarySearchTree.find(65));// null
//		System.out.println(binarySearchTree.find(70));// 70
//		System.out.println(binarySearchTree.find(70).getRightChild());// 78
//		System.out.println(binarySearchTree.find(70).getLeftChild());// 60
//		System.out.println(binarySearchTree.find(70).getRightChild().getLeftChild());// 72
//		System.out.println(binarySearchTree.find(70).getRightChild().getRightChild());// 90
		
		// demoing findMin and findMax
		
		System.out.println(binarySearchTree.findMin());// 12
		System.out.println(binarySearchTree.findMax());// 90
		
		binarySearchTree.traverse(binarySearchTree.root);
		
		// demoing leafCounter
		
		System.out.println(binarySearchTree.leafCounter(binarySearchTree.root, 0));// 7
		
		binarySearchTree.insert(89);
		binarySearchTree.insert(91);
		
		System.out.println(binarySearchTree.leafCounter(binarySearchTree.root, 0));// 8
		
		// demoing height calculator
		
		BinarySearchTree binarySearchTree2 = new BinarySearchTree();
		binarySearchTree2.insert(52);
		binarySearchTree2.insert(33);
		binarySearchTree2.insert(65);
		binarySearchTree2.insert(25);
		binarySearchTree2.insert(39);
		binarySearchTree2.insert(60);
		binarySearchTree2.insert(78);
		binarySearchTree2.insert(12);
		binarySearchTree2.insert(27);
		binarySearchTree2.insert(34);
		binarySearchTree2.insert(48);
		binarySearchTree2.insert(72);
		binarySearchTree2.insert(90);
		binarySearchTree2.insert(70);
		binarySearchTree2.insert(38);
		
		System.out.println(binarySearchTree2.getHeight(binarySearchTree2.root, 0));//5
		
		BinarySearchTree binarySearchTree3 = new BinarySearchTree();
		binarySearchTree3.insert(52);
		binarySearchTree3.insert(33);
		binarySearchTree3.insert(32);
		binarySearchTree3.insert(31);
		binarySearchTree3.insert(30);
		binarySearchTree3.insert(15);
		binarySearchTree3.insert(14);
		binarySearchTree3.insert(12);
		binarySearchTree3.insert(1);
		binarySearchTree3.insert(54);
		binarySearchTree3.insert(61);
		
		System.out.println(binarySearchTree3.getHeight(binarySearchTree3.root, 0));//9
		
		// demoing balancing a tree
		
		int[] arry = new int[14];
		arry[0] = 1;
		arry[1] = 2;
		arry[2] = 3;
		arry[3] = 4;
		arry[4] = 5;
		arry[5] = 6;
		arry[6] = 7;
		arry[7] = 8;
		arry[8] = 9;
		arry[9] = 10;
		arry[10] = 11;
		arry[11] = 12;
		arry[12] = 13;
		arry[13] = 14;
		
		BinarySearchTree newTree = new BinarySearchTree();
		
		newTree.createBalancedTree(arry);
		
		System.out.println(newTree.root);
		System.out.println(newTree.root.getLeftChild());
		System.out.println(newTree.root.getRightChild());
		System.out.println(newTree.root.getLeftChild().getLeftChild());
		System.out.println(newTree.root.getLeftChild().getRightChild());
		System.out.println(newTree.root.getRightChild().getRightChild());
		System.out.println(newTree.root.getRightChild().getLeftChild());
		System.out.println(newTree.root.getLeftChild().getLeftChild().getLeftChild());
		System.out.println(newTree.root.getLeftChild().getLeftChild().getRightChild());
		System.out.println(newTree.root.getLeftChild().getRightChild().getLeftChild());
		System.out.println(newTree.root.getLeftChild().getRightChild().getRightChild());
		System.out.println(newTree.root.getRightChild().getLeftChild().getLeftChild());
		System.out.println(newTree.root.getRightChild().getLeftChild().getRightChild());
		System.out.println(newTree.root.getRightChild().getRightChild().getLeftChild());
		System.out.println(newTree.root.getRightChild().getRightChild().getRightChild());
		
	}

}
