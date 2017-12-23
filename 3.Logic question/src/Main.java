
public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		char latterToSearch = 'X',
		latterToSwitch = 'T';

		String buildStringTree="ABCTXTAXXS";

		bst.buildSBTWithSwitchLatter(null, buildStringTree, latterToSearch, latterToSwitch);
		bst.display(bst.root);
	}

}
