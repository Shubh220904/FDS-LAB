package second;

 

import java.util.Random;

import second.MyLongArray;

 
class LongArray extends MyLongArray {

    public LongArray(int size) {
        super(size);
    }

     
    public void initArray(int Arraysize) {
        Random random = new Random();
        for (int i = 0; i < Arraysize; i++) {
            a[i] = random.nextLong();
        }
        currentIndex=Arraysize-1;
    }

    public void bubbleSort() {
        int n = a.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    long temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    

    public void selectionSort() {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    public void insertionSort() {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            long key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
             
        }
    }

    

      
}