package com.practice;

/**
 * Created by shruti.mantri on 05/04/15.
 */
import java.io.*;
import java.util.*;
class Tree{
    int key;
    Tree right;
    Tree left;
    Tree(int key){
        this.key=key;
        this.right=null;
        this.left=null;
    }
}
public class TreeFromInordernPreorder{
    static int[] inorder;
    static int[] preorder;
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String[] inorderStr=br.readLine().split(" ");
            inorder=new int[inorderStr.length];
            String[] preorderStr=br.readLine().split(" ");
            preorder=new int[preorderStr.length];
            for(int i=0;i<inorder.length;i++)inorder[i]=Integer.parseInt(inorderStr[i]);
            for(int i=0;i<inorder.length;i++)preorder[i]=Integer.parseInt(preorderStr[i]);
            Tree tr=makeTree(inorder,0,inorder.length-1);
            // if(tr!=null)
            postorderTree(tr);
            //else{
            //System.out.println("sry No Tree");
            //}
        }catch(IOException e){
            System.out.println(e);
        }
    }
    static int p=-1;
    public static Tree makeTree(int[] a, int i,int j)
    {
        ++p;
        if(i<a.length && p<a.length){
            if(i==j){
                return new Tree(a[i]);
            }
            else{
                int index=find(preorder[p]);
                Tree root=new Tree(a[index]);
                root.left=makeTree(a, i, index-1);
                root.right=makeTree(a,index+1,j);
                // p++;
                return root;
            }
        }else{
            return null;
        }

    }
    public static int find(int key){
        int k=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==key){
                k=i;
                break;
            }
        }
        return k;
    }
    public static void postorderTree(Tree t){
        if(t!=null){
            postorderTree(t.left);
            postorderTree(t.right);
            System.out.println(t.key);
//inorderTree(t.right);
        }
    }
}
