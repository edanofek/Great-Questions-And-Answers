
public class BinarySearchTree {
	public  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	public boolean find(char id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public boolean delete(char id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
	//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
    }
   
	public void insert(char data,char latterToSearch,char latterToSwitch){
		Node newNode = new Node(data);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(data == latterToSearch){
				current = current.right;
				parent.right = newNode;
				Node nodeLatterToSwitch = new Node(latterToSwitch);
				parent.left = nodeLatterToSwitch;
				return;

			}else{
				current = current.right;
				parent.right = newNode;
				return;
			}
		}
	}
	public void buildSBTWithSwitchLatter(Node current,String buildStringTree,char latterToSearch,char latterToSwitch){
		
		char data = buildStringTree.substring(0, 1).charAt(0);
		String subStrTree = buildStringTree.substring(1,buildStringTree.length());

		// System.out.print(" " + subStrTree);

		Node newNode = new Node(data);
		if(current==null){
			root = newNode;
			buildSBTWithSwitchLatter(root,subStrTree, latterToSearch, latterToSwitch);
		}else{
			// Node current = root;
			Node parent = current;

			if(subStrTree.length() > 0){
				if(data == latterToSearch){
					current = current.left;
					parent.left = newNode;
					buildSBTWithSwitchLatter(parent.left,subStrTree, latterToSearch, latterToSwitch);
					Node nodeLatterToSwitch = new Node(latterToSwitch);
					parent.right = nodeLatterToSwitch;
					buildSBTWithSwitchLatter(parent.right,subStrTree, latterToSearch, latterToSwitch);
				}else{
					current = current.left;
					parent.left = newNode;
					buildSBTWithSwitchLatter(parent.left,subStrTree, latterToSearch, latterToSwitch);
				}
			}
		}
		//end of recursion 
	}
	public void displayAll(Node root){
		if(root!=null){
			displayAll(root.left);
			System.out.print(" " + root.data);
			displayAll(root.right);
		}
	}
	public void displayLeft(Node root){
		if(root!=null){
			displayLeft(root.left);
			System.out.print(" " + root.data);
		}
	}
	public void displayRight(Node root){
		if(root!=null){
			System.out.print(" " + root.data);
			displayRight(root.right);
		}
	}

}
