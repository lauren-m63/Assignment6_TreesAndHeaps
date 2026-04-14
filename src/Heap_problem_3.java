public class Heap_problem_3 {





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


 */
