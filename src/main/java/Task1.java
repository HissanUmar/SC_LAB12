package src.main.java;

public class Task1 {
    
    public static int search(int[] array, int start, int end, int num){
        int mid = (start + end) / 2;

        if(start > end || array.length == 0){
            return -1;
        }

        else {
            if (array[mid] == num){
                return mid;
            }
            else if(array[mid] > num){
                return search(array, start, mid-1, num);
            }
            else if(array[mid] < num){
                return search(array, mid+1, end, num);
            }
        }   

        System.err.println("Code not executing");
        return 0;
    }


    public static void lookForOthers(int[] index, int[] array, int num) {
        int location = index[0];
        int more_locations = 1;
    
        // Check both directions simultaneously
        for (int i = 1; i < array.length; i++) {
            if (location + i < array.length && array[location] == array[location + i]) {
                index[more_locations++] = location + i;
            }
            if (location - i >= 0 && array[location] == array[location - i]) {
                index[more_locations++] = location - i;
            }
        }
    }
    

    
    public static int[] recursiveBinarySearch(int[] array, int num){
        int[] index = new int[10];

        if(array[0] == num){
            index[0] = 0;
        }
        else{
            index[0] = search(array, 0, array.length-1, num);
        }

        if(index[0] == -1){
            return index;
        }
        else {
            lookForOthers(index, array, num);
        }

        int display_count = 0;
        for (int a: index){
            System.out.println(a);
            
        }

        return index;
    }

    public static void main(String[] args){

        int array[] = {3, 5, 7, 7, 7, 8, 9, 12};
        int num = 7;

        System.out.println(recursiveBinarySearch(array, num));
    }
}
