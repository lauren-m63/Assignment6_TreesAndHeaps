import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heap_problem_3 {

    public static void main(String[] args) {
        System.out.println();

    }// END MAIN




    /*
CLASSES
     */

    class Huffman { // i guess i could just put this in given class i dont rlly need second but
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, String> codeMap = new HashMap<>();
        private Node root;


        /*
        in here is where i need to do all the logic stuff so like
        im going to loop through my array nad do the frequencies and then also put them in their hashmap
        then build the tree and tehn i think ill do the binary in another class? or is that part of here
        no i do it all in here okay
         */


        public void countFreq(String input) {
            for (char c : input.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        } // END COUNTFREQ

        public void buildTree(){
            PriorityQueue<Node> queue = new PriorityQueue<>((a,b) ->a.freq- b.freq);
                        //  this is saying like add the smallest first so you put it like smallest first so theyre in order
            //              this is jsut ordering them so when yu add it to the queue thats the ordering
            for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
                queue.add(new Node(entry.getKey(), entry.getValue())); // im adding it to the queue but as a mpa entry so it adds the key value pair in the queue
                // it is also creatying a node to put into the heap queue so its a node with a map in the queue
            }
            while(queue.size()>1){ // now i am building the tree by taking the smallest two in the queue and making a new parent for them each time
                // until the queue just has te one left then i put it back into the heap
                Node left = queue.poll();
                Node right = queue.poll();

                Node parent = new Node(left.freq +right.freq, left, right);
                queue.add(parent); // putting back in the heap
            }
            root = queue.poll(); // the last node left will be the highest and the most used aharacters so it makes that node the entire tree it is the root
        }// END BUILD TREE

        /*
        now generating the binary codes by going through each node in the tree and addig either 0 or 1
         */

        public void buildCode(Node node, String code){
            if (node == null) return;

            if (node.left==null && node.right==null){
                // if a leaf
                codeMap.put(node.ch, code);
                return;
            }
            buildCode(node.left,code + "0");
            buildCode(node.right,code + "1");
        } // END BUILD CODE


        // now makign the string to retun

        public String makeString(String input){
            //char[] chars = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                sb.append(codeMap.get(c));
            }
            return sb.toString();
        } // END MAKESTRING





    }// END HUFFMAN CLASS




    class Node{ // just node class for object no logic in here
        char ch;
        Node left;
        Node right;
        int freq;
        public Node(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        Node(int freq, Node left, Node right){
            this.freq = freq;
            this.left = left;
            this.right = right;
            this.ch = '\0';
        }

    } // END NODE CLASS

} // LAST BRACKET end class


/*

NOTES:

IMPLEMENT HUFfman coding system with proprity queue which is min heap


so im given a string and i caluclate the frequency of how much each letter shows up/character
so i count them then build a min heap so the ones with the lowest frequency are first

i need to merge these nodes into a tree so ill just assign value then sort list? then put into tree

so ascii is always 8 bits and each character has a different code
but i am giving shorter bit codes to the letters that appear more to save space?
and then longer codes to the more rare letters in a given string

so i should count frequency, by how many times they appear so if i see a L add 1 to the L count
also do spaces and other characters- is there a method for this

build a min heap out of this so sort them from least to greatest and make priority queue min heap

then i put in  a loop the two smallest and combine them itno theparent?
then i get the code from the tree so like the balance factor
then replace each letter with the code you gave it and return that
classes:
huffman builds teh tree and encodes test then





redo

- so i do count frequency of a charcater
Map<Character, Integer> freq = new HashMap<>();

for (char c : text.toCharArray()) {
    freq.put(c, freq.getOrDefault(c, 0) + 1);
}

use hashmap with character and then the number next to it and then if it is seen again you increase value

then im going to create a priority queue of nodes

PriorityQueue<>( (a, b) -> a.freq - b.freq );
- thi just means if a is less than b then a goes first and vice versa
so this orders the queue as you put them in from smallest to largest

then i build the tree using huffman ?
so i want the smallest so i just ask for it since its already in the queue i jsut made because its ordered
- i get the smallest and the second smallest in there
then i continue to do that and im just putting them in the heap until my queue has 1 since ive been taking out 2 at a time


okay but eveyrtime i ask for the smallest two i add them together and that is their parent, so
all the parents represent the childrens total because its supposed to be like this subtree has this many occurences

then larer that parent node will be compared with the other nodes so itll end up being the sum of whats under it
because when you compare the smaller numbers those are the ones that are more rare
when you combine them they get pushed down one more level in the tree because you have them straight,
then you combine now they have a parent and they are below that parent = one level deeper
since they are now deeper in the tree they will be givne longer codes when we do that later whcih is good bc they are more rare
if you didnt add them you wouldnt know how often that subtree appears so you dont know how important it is

now i have my tree so i have to generate the code
so im going to traverse the tree in preorder maybe? and when i go left i add a 0 and everytime i go right i add 1
so i dont even i would start at the root and then jut visit every node
only when you hit a leaf node do you actually store the binary code though because the other ones are
just saying how much work to do but the leaf is the actual character
 */
