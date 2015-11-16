package interview_practice;

import java.util.Arrays;

public class ProductOfAllOtherNumbers {

    public static void main(String[] args) {
        int[] integers = new int[] {1, 7, 3, 4};
        System.out.println(Arrays.toString(get_products_of_all_ints_except_at_index(integers)));
    }

    public static int[] get_products_of_all_ints_except_at_index(int[] integers) {
        int[] products = new int[integers.length];
        for(int i = 0; i < integers.length; i++) {
            products[i] = multiply(integers, i);
        }
        return products;
    }

    public static int multiply(int[] integers, int index) {
        int product = 1;
        for(int i = 0; i < integers.length; i++) {
            if(i == index) {
                continue;
            }
            product = product * integers[i];
        }
        return product;
    }
}