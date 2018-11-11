/**

*Description: This program will bubble sort an integer array sorting in ascending order

*Used as a class assignment 

*Date: 08/04/2018

*@author  mk-wintr

*/  

public class BubbleSort
{
    static boolean toBubble = false;                          // flag variable for if needs to bubble again
    public static void BubbleSort(int[] arr)
    {
        int arrPass = 0;                                      // counts the number of array passes
        
        do                                                    // do-while loop
        {
            toBubble = false;                                 // put toBubble back to standard value
            arr = bubbleAlgo(arr);                            // reun the bubble algorithm and store new array into old array
            arrPass++;                                        // increment the array pass value
        }
            while(toBubble != false);                           // while the program indicates the array is not sorted
        
        System.out.println("Array went through " + arrPass + " passes of the BubbleSort Algorithm");  // output the number of array passes
        
        for(int n = 0; n < arr.length; n++)                   // print out the values of arr1 in order
        {
            System.out.print(arr[n] + " ");
        }
        System.out.println();
    }
    
/**Method bubbleAlgo takes the integer array and performs a bubblesort pass

* @param int[] arry is the array where bubblesort is being performed

* @return int[] arry

* @throws Nothing is implemented

*/
    public static int[] bubbleAlgo(int[] arry)
    {
        int arrayLength = arry.length;                        // set arrayLength = arr.length
        for(int n = 0; n < arrayLength - 1; n++)              // for loop that cycles through n to arrayLenght indices of arr
        {
            int cmp = compareArr(arry[n],arry[n + 1]);        // set integer variable cmp to the value returned by compare(index n, index n+1)
            if(cmp > 0)                                      // if arr[n] >  arr[n + 1] then swap the indices
            {
                toBubble = true;                              // set toBubble to indicate had to sort in this pass
                arry = swapArr(arry, n, n+1);
            }
        }
        return arry;
    }
    
/**Method compareArr takes two integers and compares to determine which is larger

* @param int first and int second are the integers

* @return 1 if first is greater, -1 if second is greater

* @throws Nothing is implemented

*/
    public static int compareArr(int first, int second)
    {
        if(first > second)                                    // if first integer is greater than second integer
        {
            return 1;                                         // return indicator 1 to show that first is greater
        }
        
        return -1;                                            // return indicator -1 to show second is greater
    }

/**Method swapArr takes an integer array, swaps the values at index first and second and then returns a new int array

* @param int[] aRay is the array to be swapped, int first, int second

* @return int[] aRay

* @throws Nothing is implemented

*/
    public static int[] swapArr(int[] aRay, int first, int second)
    {
        int temp = aRay[second];                              // set the second index value to temp
        aRay[second] = aRay[first];                           // set the second index value = to first index value of aRay
        aRay[first] = temp;                                   // set the first index value = the value stored in temp
        return aRay;                                          // return the new integer array
    }
}