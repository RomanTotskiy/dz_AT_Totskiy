package day2quest1;

public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 6, 8, 3, 7, 9};
        for (int a_b = 0; a_b < array.length; a_b++)

            System.out.print(array[a_b] + " ");
        System.out.println("");
        for (int a = 0; a < array.length; a++) {
            int min = array[a];
            int min_a = a;
            for (int b = a +1; b < array.length; b++){
                if (array[b] < min){
                    min = array[b];
                    min_a = b;
                }
                if (a != min_a) {
                    int tmp = array[a];
                    array[a] = array[min_a];
                    array[min_a] = tmp;
                }
            }
            System.out.print(array[a] + " ");
        }

    }
}
