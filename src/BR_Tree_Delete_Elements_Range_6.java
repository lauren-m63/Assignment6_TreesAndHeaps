public class BR_Tree_Delete_Elements_Range_6 {

    /*

    so i am given a red black tree and two values and then i have to go through the tree
    and then delet the values tha are less than or equal to a and like jsu tin between or equal to a and b
    so ill have to check to make sure a is less than b or can i just take the smaller one of the input no prob not imll do a check

    but then im deleting so i still have to keep th black red structure ughhh and bst so
    wait
    no balance just the red and black proerties and then bst of course
    do i hvae to make one black or red can it jus tbe conceptual or no i have to i think
    do i jsut add a variable black or red to each node i guess should i do a map
    hashmap maybe like value, color, balance
    no balance i think


     */

    /*
    time complexity is


    space complexity is
     */

    public static void main (String[] args) {

        System.out.println();



    }// END MAIN





    public class deletNode{

        private Node findMin (Node node){
            while (node.left != null){
                node = node.left;
            }
            return node;
        }// END FINDMIN METHOD



        public Node deleteRange (Node root, int a , int b){


            if (root == null){
                return null;
            }
            if (b > a){
                return null;
            }

            if (root.val<a ){
                return deleteRange(root.right,a,b); // if small then i skip the left bc outo f range
            }
            if (root.val>b ){ // same but too big so skipping right bc b is the bigger one
                return deleteRange(root.left,a,b);
            }

            root.left = deleteRange(root.left,a,b);// if it is in the range then im going to delete it per instructions
            root.right = deleteRange(root.right,a,b);

            // children
            // for the current node you have to remove it by putting children together
            if (root.left == null ){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }


            Node minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteRange(root.right,minNode.val, minNode.val);



            return root;



        }// END DELETERANGE METHOD





    } // END DELETENODE CLASS




    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }// END NODE CLASS




} // LAST BRACKET END CLASS
