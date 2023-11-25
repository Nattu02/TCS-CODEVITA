import java.util.Scanner;

public class bestbubble {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int swapsAscending = ascendingBubble(numbers.clone());
        int swapsDescending = descendingBubble(numbers.clone());

        System.out.println(Math.min(swapsAscending, swapsDescending));
    }

    static int ascendingBubble(int[] arr) {
        int n = arr.length;
        boolean swapped;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                    swapCount++;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return swapCount;
    }

    static int descendingBubble(int[] arr) {
        int n = arr.length;
        boolean swapped;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                    swapCount++;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return swapCount;
    }
}
