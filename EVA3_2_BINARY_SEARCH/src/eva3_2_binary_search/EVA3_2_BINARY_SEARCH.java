/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_2_binary_search;


/**
 *
 * @author CodeSlayer22
 */
import java.util.Scanner;
public class EVA3_2_BINARY_SEARCH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int size = 1000000;
        int[] a = new int[size];
        int x;
        int n = 1;
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < size; i++) {
            a[i] = (int)(Math.random()*(size*n));
        }
        quick_sort(a);
        System.out.println("");
        x =  a[(a.length/2-1)];
        System.out.println("\nSe encuentra en la posicion: "+
                binary_search(a, x));
        System.out.println("\nSe encuentra en la posicion: "+
                linear_search(a, x));
        
    }
    
    public static void quick_sort(int a[]){
        quick_sort(a, 0, a.length);
    }
    
    public static void quick_sort(int[] a,int inicio,int fin){
        //Si la seccion es de tamaño 1, se termina la recursion
        if(inicio == fin) return;
        int iLeft=inicio,iRight=fin-1;
        //Seleccionamos un pivote al azar entre el inicio y el fin
        int pivote = (int)(Math.random()*(fin-inicio))+inicio;
        //int pivote = inicio;
        int temp;
        
        //Movemos el pivote al final de la seccion
        temp = a[pivote];
        a[pivote] = a[fin-1];
        a[fin-1] = temp;
        
        while(iRight > iLeft){
            //Busca valres mayores al pivote, moviendose de izq a derecha
            for (iLeft = iLeft; iLeft < fin-1; iLeft++) {
                if(a[iLeft]>a[fin-1]){
                    break;
                }
            }
            //Busca valores menores, moviendose de derecha a izq
            for (iRight = iRight; iRight >= inicio; iRight--) {
                if(a[iRight]<a[fin-1]){
                    break;
                }
            }
            
            //Si el valor de la izq sigue siendo menor, hace el cambio
            if(iLeft < iRight){
                temp = a[iLeft];
                a[iLeft] = a[iRight];
                a[iRight] = temp;
            }
        }
        
        //Almacenamos el pivote
        temp = a[fin-1];
        //Insertamos el pivote solo si es antes de la posicion donde el pivote
        //se encuentra actualmente
        if(iLeft < fin-1){
            a[fin-1] = a[iLeft];
            a[iLeft] = temp;
        }
         
        //Aplicamos quick sort al lado izquierdo
        if(inicio < iLeft){
            quick_sort(a, inicio, iLeft);
        }
        
        //Aplicamos quick sort al lado derecho
        if(iLeft < fin){
            //System.out.println("Derecha: fin="+fin);
            quick_sort(a, iLeft+1, fin);
        }
        
        
    }
    
    public static int binary_search(int[] a,int x){
        if(x < a[0] || x > a[a.length-1]){
            return -1;
        }
        return binary_search(a, x, 0, a.length-1);
    }
    
    public static int binary_search(int[] a,int x,int lDer,int lIzq){
        System.out.println(lDer+"-"+lIzq);
        int midPoint = lDer+ (lIzq-lDer)/2;
        
        if(lDer > lIzq) return -1;
        if(a[midPoint] == x){
            return midPoint;
        } else if(x < a[midPoint]){
            return binary_search(a, x,lDer,midPoint-1);
        } else{
            return binary_search(a, x, midPoint+1, lIzq);
        }
    }
    
    public static int linear_search(int[] a,int x){
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == x){
                index = i;
                break;
            }
        }
        return index;
    }
}
