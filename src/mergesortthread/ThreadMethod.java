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
public class ThreadMethod implements Runnable{

    int[] array;
    int left , right;

    public ThreadMethod(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run () {
     
         mergeSort(array, left, right);
             
    }
      private void mergeSort(int[] array,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array,left,right,mid);
        }
    }
    

    private void merge(int[] array, int left, int right, int mid) {
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
               
             
            }
    }
    
    
    
}
