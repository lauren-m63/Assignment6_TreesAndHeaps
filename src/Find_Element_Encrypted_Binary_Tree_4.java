public class Find_Element_Encrypted_Binary_Tree_4 {

    /*
    time complexity is O(n) where n is the number of nodes in the given binary tree array because everytime you run the algorithm at worst every node is visited once when you are computing values for each one and you only traverse through the tree and each node one time every time

    space complaxity is O(n) where n is the height of the tree because everytime you traverse the tree you are just going the highest depth
    because its recursive so everytime i am calling my rebuild method to do new computations i am storing all of the parameter variables again
    so if you have a balanced tree it would be fewer recusrive calls because n would be smaller
     */

    public static void main (String[] args) {
        //rebuild ();
        int[] bt = { -2, -2, -1, -2, -1 };
        int target = 1;

        boolean result = rebuild(bt, 0, 1, target);
        System.out.println(result);

    }// END MAIN


    /*
    i have a remake a reee tree where i am suposed to

    so  ahve -2 is real but value is hidden girl
    then -1 is no node null

    so im just rebuilding the values and go thorugh it just the once it seems like
    dont make a new tree though just walk thorugh the array and compute new values to overwrite whats going on
    in there

    jk i am not overwrititng anything im no modification im just computing values
    start at the root and then i have to do left is ugh
    okay left 3x+1
    right 2x+5
    why
    jsut the directions then i have to do checks and stuff

     */

    //public boolean find()

    public static boolean rebuild(int[] bt, int index, int value, int target){

        if (index>= bt.length || bt[index] == -1){// normal sanity check
            return false;
        }

        if (value == target)
        {
            return true;
        }

        boolean left = rebuild(bt, 2* index + 1, 3 * value + 1, target);
        boolean right = rebuild(bt, 2* index + 2, 2 * value + 5, target);





        return left || right;
    }// END REBUILD

} // LAST BRACKET END CLASS
