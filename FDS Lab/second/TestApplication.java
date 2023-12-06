package second;

import java.util.*;

public class TestApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size Of Array : ");
        int size = sc.nextInt();
        System.out.println();
        MyLongArray a1 = new MyLongArray(size);
        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println("Enter 1 to 7 to do following operations:");
            System.out.println("Enter Numbers as per the following Menu");
            System.out.println("1:Find index of array element");
            System.out.println("2:Insert value at end");
            System.out.println("3:Get element value at a index");
            System.out.println("4:Delete value from array(First occurance)");
            System.out.println("5:Display all elements of array");
            System.out.println("6:Delete all occurences of value from array");
            System.out.println("7:insert value at a index");
            System.out.println("Enter any value other than 1 to 7 to exit");


            System.out.println("Enter Choice:");
            int choice = sc.nextInt();

             

            switch (choice) {
                case 1:
                    System.out.println("Enter value:");
                    long searchKey = sc.nextLong();
                    int ans=a1.find(searchKey);
                    System.out.println("Index:" + ans);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter value to insert:");
                    long value = sc.nextLong();
                    a1.insert(value);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter index:");
                    int index = sc.nextInt();
                    long ans1=a1.getElement(index);
                    System.out.println("Element at Postion: "+ans1);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter value to delete:");
                    long value1 = sc.nextLong();
                    a1.delete(value1);
                    System.out.println();
                    break;
                case 5:
                    a1.display();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Enter value to delete all occurences:");
                    long value2 = sc.nextLong();
                    a1.dupDelete(value2);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Enter index at which you have to insert:");
                    int index1 = sc.nextInt();
                    System.out.println("Enter value to be insert:");
                    long value3 = sc.nextLong();
                    a1.insertAt(index1, value3);
                    System.out.println();
                    break;


                default:
                    System.out.println("Do you want to Continue?");
                    System.out.println("Enter 1 if yes and 0 if no");
                    int conti = sc.nextInt();
                    if (conti == 0) {
                        continueMenu = false;
                    }
                     
                    System.out.println();

            }
        }


        sc.close();
    }
}


