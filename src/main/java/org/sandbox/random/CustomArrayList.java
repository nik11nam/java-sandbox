package org.sandbox.random;

public class CustomArrayList {

    int[] array;
    int size, lastIndex;

    // This must be dynamic and the operations must be done in the Amortized constant time. O(1)
    public CustomArrayList() {
        lastIndex = 0;
        size = 2;
        array = new int[2];
    }

    // Private method that makes in dynamic growing nature of the ArrayList
    private void dynamic() {
        size = size * 2;
        int[] newArray = new int[size];
        for (int i=0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // Method used to add the element in the list.
    public void add(int value) {
        if (lastIndex == size) {
            dynamic();
        }
        array[lastIndex++] = value;
    }

    // Method that removes the element at particular index.
    public void remove(int index) {
        for (int i=index; i < lastIndex; i++) {
            array[i] = array[i+1];
        }
        lastIndex--;
    }

    public int get(int index) {
        return array[index];
    }

    // Overridden toString method used to print the elements of the ArrayList
    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append("[");
        for(int i = 0; i < lastIndex; i++)
            temp.append(array[i]+",");
        temp.deleteCharAt(temp.length()-1);
        temp.append("]");
        return temp.toString();
    }

    public static void main(String[] args) {
        CustomArrayList al = new CustomArrayList();
        for(int i = 0; i < 20; i++){
            al.add((int)(Math.random()*9000));
        }
        System.out.println(al);
        al.remove(9);
        System.out.println(al.get(6));
        System.out.println(al);
    }
}



