import java.util.Arrays;

class Node {
    int data;
    Node right;
    Node left;

    public Node(int data){
        this.data = data;
    }
}

class BuildBSTMinHeight {


    //Recursive soluation
    private void buildBSTMinHeight(Node root, int[] arr){
        int midInd = arr.length() /2;
        if(arr.length() <= 3) {

            // set value for left node
            root.left = new Node(arr[midInd -1]);

            // set value for right node
            if(arr.length() == 3 ) {
                root.right = new Node(arr[midInd+1]);
            }


        } else {
            int leftInd = 0, rightInd = arr.length()-1;
            //edge case if root is not declared
            if(root == null){
                root = new Node();
            }
            // initaite memory for new left node
            root.left = new Node();
            buildBSTMinHeight(root.left,Arrays.copyOfRange(arr,leftInd, midInd -1 ));

            //set value root data
            root.data = arr[midInd];

            // initaite memory for new right node
            root.right = new Node();
            buildBSTMinHeight(root.right,Arrays.copyOfRange(arr,midInd +1 , rightInd ));
        }
    }
    public void static main(String[] args) {

        int[] arr = [1,2,3,4,5,6,7];
        Node root;
        BuildBSTMinHeight _BuildBSTMinHeight = new BuildBSTMinHeight();
        _BuildBSTMinHeight.buildBSTMinHeight(root,arr);

    }

}