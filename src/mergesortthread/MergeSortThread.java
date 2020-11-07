/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortthread;

/**
 *
 * @author rewas
 */
public class MergeSortThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     int[] array ={3,5,2,1,7,9,22,4,88};
     
      int right, left;
      right = array.length-1;
      left = 0;
      
       mergeSort(array,left,right);
      for(int i=0 ; i<array.length;i++){
           System.out.print(array[i]+" ");
       }
       
    }
    public static void mergeSort(int[] array,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
             ThreadMethod lm = new ThreadMethod(array, left, mid);
             ThreadMethod rm = new ThreadMethod(array, mid+1, right);
             Thread t1 = new Thread(lm);
             Thread t2 = new Thread(rm);
             t1.run();
             t2.start();
            
              merge(array,left,right,mid);
             
        }
    }
    

    private static void merge(int[] array, int left, int right, int mid) {
        int i, j, k;
        int[] c = new int[array.length];
            i = left;
            k = left;
            j = mid + 1;
            while (i <= mid && j <= right)
            {
                if (array[i] < array[j])
                {
                    c[k] = array[i];
                    k++;
                    i++;
                }
                else
                {
                    c[k] = array[j];
                    k++;
                    j++;
                }
            }
            while (i <= mid)
            {
                c[k] = array[i];
                k++;
                i++;
            }
            while (j <= right)
            {
                c[k] = array[j];
                k++;
                j++;
            }
            for (i = left; i < k; i++)
            {
                array[i] = c[i];
                 //System.out.print(array[i]+" ");
            }
    }
    
}
