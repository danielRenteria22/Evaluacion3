/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_selection_sort;

/**
 *
 * @author dany
 */
public class EVA3_1_SELECTION_SORT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int size = (int)(Math.random()*50+1);
        int size = 1000;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int)(Math.random()*20+1);
        }
        sel_sort(a);
        /*for (int i = 0; i < a.length; i++) {
            System.out.print("["+a[i]+"]");
        }
        System.out.println("");
        sel_sort(a);
         for (int i = 0; i < a.length; i++) {
            System.out.print("["+a[i]+"]");
        }
        System.out.println("");*/
    }
    
    public static void sel_sort(int[] a){
        int min,index,temp;
        //int comp=0,swaps=0;
        for (int i = 0; i < a.length; i++) {
            index = i;
            min = a[i];
            for (int j = i+1; j < a.length; j++) {
                //comp++;
                if(a[j]<min){
                    min = a[j];
                    index = j;
                }
            }
            temp = a[i];
            a[i]=min;
            a[index] = temp;
            //swaps++;
        }
//        System.out.println("Tamaño: "+a.length);
//        System.out.println("Comparaciones: "+comp);
//        System.out.println("Swaps: "+swaps);
    }
    
}
