import java.util.ArrayList;
import java.util.List;

public class All_Less_5 {

    /*


        i just go through the heap and make it an array ?

        im given an array of a heap so thats te input
        then also im given a number x and i am supposed to return all the strings
        from the array that are less than the number x for their lenghts
        so i dont even do anything i just look at them

        lexicographically ?
        the heap proerpty is that te parents are greater than or equalt o the children
        but that doesnt even matter for length since its going by abc or 123

        do null empty, spaces - do spaces count for size or nah
        just a freaking loop basicall y


     */




    public static List<String> allLess(String[] heap, int x){

        List<String> result = new ArrayList<>();

        if (heap == null || heap.length == 0){
            return result;
        }
        for (String item : heap){
            if (item.length() < x && item!=null){
                result.add(item);
            }
        }
        return result;
    } // END ALLLESS method

    public static void main(String []args){

        String[] s = {"zero", " size", "nutella", "jojo", "luna", "isse", "astor", "as", "entretien", "", "cal"};
        int x = 3;

        List<String> result = allLess(s, x);

       // String s1 = "zero", " size", "nutella", "jojo", "luna", "isse", "astor", "as", "entretien", “”, "cal";


        System.out.println(result);
    }





}// LAST BRACKET END CLASS
