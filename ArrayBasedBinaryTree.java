/**

*Description: This class is an abridged binary tree that is array based with the NLR Traversal method
********* The abridged nature of the binary tree is a quick and partial implementation to test the method

*Used as a class assignment

*Date: 08/04/2018

*@author  Michael Nguyen

*/  

import java.util.ArrayList;
import java.util.List;

public class ArrayBasedBinaryTree
{
    public int N = 100;
    public String[] treeNodes = new String[N];
    public ArrayBasedBinaryTree(String firstStr)
    {
        treeNodes[0] = firstStr;                                 // bring in parent node firstString into the first index;
    }

/**Method addLeft takes a parent string and adds the new string node as a left node in an arraybased binary tree

* @param String p is the parent node, String nChar is the new node

* @return boolean to indicate insertion

* @throws Nothing is implemented

*/
    public boolean addLeft(String p, String nChar)               // add left node to parent string with new string
    {
        int pDex = findNode(treeNodes, p);                       // set parent Index using find node method
        int nIndex = 2 * pDex + 1;                               // set new index = to 2*parentIndex + 1
        if(pDex == -1 || treeNodes[nIndex] != null)                                           // check if new index is empty or if parent node is not yet initiated
        {
            return false;
        }
        treeNodes[nIndex] = nChar;                               // set array index to the new string value
        return true;
    }
    
/**Method addRight takes a parent string and adds the new string node as a right node in an arraybased binary tree

* @param String p is the parent node, String nChar is the new node

* @return boolean to indicate insertion

* @throws Nothing is implemented

*/
    public boolean addRight(String p, String nChar)               // add left node to parent string with new string
    {
        int pDex = findNode(treeNodes, p);                       // set parent Index using find node method
        int nIndex = 2 * pDex + 2;                               // set new index = to 2*parentIndex + 2
        if(pDex == -1 || treeNodes[nIndex] != null)              // check if new index is empty or if parent node is not yet initiated
        {
            return false;
        }
        treeNodes[nIndex] = nChar;                               // set array index to the new string value
        return true;
    }
    
/**Method findNode finds a string within a string array

* @param String[] strArr is the string array and String str is the string to be found

* @return int n the index of the string found or -1 if failed to find

* @throws Nothing is implemented

*/
    public int findNode(String[] strArr, String str)             // find the node that matches the string
    {
        for(int n = 0; n < N; n++)                               // for loop with max of treeNodes indices
        {
            if(treeNodes[n] == str)                              // if treeNode index is same, return the index number
            {
                return n;
            }
        }
        
        return -1;                                               // otherwise return -1
    }

/**Method nlr is the node left right traversal recursive algorithm

* @param String rootNode which is the starting position

* @return String prStr which is either nothing if base case or the string of nodes for output

* @throws Nothing is implemented

*/
    public String nlr(String rootNode)                                // method to traverse and print node, left node, right node
    {
        String prStr = "";                                               // create a string to print
        if(rootNode == null)                                        // base case: if rootNode is null, then return
        {
            return prStr;
        }
        
        int rootIndex = findNode(treeNodes, rootNode);              // find the root index of root node within treeNodes array
        int leftIndex = 2 * rootIndex + 1;                          // set left index to 2 * rootIndex + 1
        int rightIndex = 2 * rootIndex + 2;                         // set right index to 2 * rootIndex + 2
        prStr = rootNode;
        prStr = prStr + nlr(treeNodes[leftIndex]);                                  // traverse the left node
        prStr = prStr + nlr(treeNodes[rightIndex]);                                 // traverse the right node
        return prStr;
    }
}