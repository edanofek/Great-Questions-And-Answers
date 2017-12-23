
public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		char latterToSearch = 'X',
		latterToSwitch = 'T';

		String buildStringTree="ABCTXTAXXSA";

		bst.buildSBTWithSwitchLatter(null, buildStringTree, latterToSearch, latterToSwitch);
		bst.displayAll(bst.root);

	}

}
