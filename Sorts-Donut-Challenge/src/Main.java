import java.util.Random;
import java.util.Scanner;

public class Main {

    // N people are taking part in the donut eating competition.
    // To win, you need to eat as many donuts as possible in 10 minutes.
    // Display on the screen the result of 3 winners and the worst result.
    // (Hint: The program allocates dynamic memory for an array of n elements
    // and requests the array from a keyboard.
    // Try sorting the data using different methods.
    // The case when several participants ate the same number of donuts should not be considered).

    // 1. Get user input
    // 2. Randomize amount or donuts eaten by evey participant.
    // 3. Sort numbers in Array
    // 4. Output results

    static void input(int[] x) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press '1' if you want to randomize how many donuts each" +
                " participants have eaten or press '2' to enter values manually: ");
        int respond = sc.nextInt();
        switch (respond) {
            case 1:
                for (int i = 0; i < x.length; i++) {
                    Random r = new Random();
                    x[i] = r.nextInt(35);
                }
                break;
            case 2:
                for (int i = 0; i < x.length; i++) {
                    System.out.print("Enter a number of donuts eaten by participant " + (i + 1) + ": ");
                    x[i] = sc.nextInt();

                    while (x[i] < 0) {
                        System.out.println("Please enter a positive value.");
                        System.out.print("Enter a number of donuts eaten by participant " + (i + 1) + ": ");
                        x[i] = sc.nextInt();
                    }
                }
                break;
        }
    }

    static void show(int[] x) {
        System.out.print("Donuts eaten by participants: ");
        for (int j : x) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    static void sort(int[] arr) {
        String nl = System.lineSeparator();
        Scanner sc = new Scanner(System.in);

        System.out.println(nl + "Choose sorting method " + nl +
                "Enter '1' for bubble sort" + nl +
                "Enter '2' for insertion sort " + nl +
                "Enter '3' for selection sort " + nl +
                "Enter '4' for heap sort " + nl +
                "Enter '5' for radix sort " + nl +
                "Enter '6' for merge sort " + nl +
                "Enter '7' for quick sort ");
        int respond = sc.nextInt();

        System.out.println("Sorting results...");

        switch (respond) {
            case 1 -> bubbleSort(arr);
            case 2 -> insertionSort(arr);
            case 3 -> selectionSort(arr);
            case 4 -> heapSort(arr);
            case 5 -> radixSort(arr);
            case 6 -> mergeSort(arr, 0, arr.length - 1);
            case 7 -> quickSort(arr, 0, arr.length - 1);
        }
    }

    static void bubbleSort(int[] arr)
    {
        int count = 0;
        boolean needIteration = true;
        while(needIteration) {
            needIteration = false;
            int n = arr.length;
            for(int i = 0; i < n-1; i++)
                for(int j = 0; j < n-i-1; j++)
                    if(arr[j] > arr[j+1])
                    {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        needIteration = true;
                        count++;
                    }
        }
        System.out.println("The number of permutations is " + count);
    }

    static void insertionSort(int[] arr)
    {
        int count=0;
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int keyItem = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > keyItem) {
                arr[j + 1] = arr[j];
                j = j - 1;
                count++;
            }
            arr[j + 1] = keyItem;
        }
        System.out.println("The number of permutations is " + count);
    }
    static void selectionSort(int[] arr)
    {
        int count=0;
        int n = arr.length;
        for(int i = 0; i < n-1; i++)
        {
            int min = i;
            for(int j = i+1; j < n; j++)
                if(arr[j] < arr[min])
                    min = j;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            count++;
        }
        System.out.println("The number of permutations is " + count);
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {// Build max heap
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) { // Heap sort
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);// Heapify root element to get highest element at root again
        }
    }
    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void mergeSort(int[] arr, int left, int right)
    {
        if (left < right) {
            int mean = (left + right) / 2;
            mergeSort(arr, left, mean);
            mergeSort(arr, mean+1, right);
            merge(arr, left, mean, right);
        }
    }

    private static void merge(int[] items, int left, int mean, int right)
    {
        int leftSize = mean - left + 1;
        int rightSize = right - mean;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        for (int i = 0; i < leftSize; i++)
            leftArr[i] = items[left + i];
        for (int j = 0; j < rightSize; j++)
            rightArr[j] = items[mean + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i = 0;
        int j = 0;
        int k = left;

        // Until we reach the end of either leftArr or rightArr, pick larger among
        // elements leftArr and rightArr and place them in the correct position at
        //items[left..right]
        while(i < leftSize && j < rightSize)
        {
            if (leftArr[i] <= rightArr[j]) {
                items[k] = leftArr[i];
                i++;
            } else {
                items[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            items[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            items[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int left, int right)
    {
        if (left < right) {
            int keyIndex = partition(arr, left, right);
            quickSort(arr, left, keyIndex - 1);// Sort the elements on the left of a key element
            quickSort(arr, keyIndex + 1, right);// Sort the elements on the right of a key element
        }
    }

    private static int partition(int[] items, int left, int right)
    {
        int key = items[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (items[j] <= key) {
                i++;
                int temp = items[i];
                items[i] = items[j];
                items[j] = temp;
            }
        }
        int temp = items[i + 1];
        items[i + 1] = items[right];
        items[right] = temp;
        return (i + 1);
    }

    static int findMax(int[] arr)
    {
        int maxItem = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > maxItem)
                maxItem = arr[i];
        return maxItem;
    }

    static void countingSort(int[] arr, int place) {
        int size = arr.length;
        int[] output = new int[size + 1];
        int maxItem = findMax(arr);

        int[] count = new int[maxItem + 1];
        for (int i = 0; i < maxItem; ++i)
            count[i] = 0;

        // Determine count of elements
        for (int j : arr) count[(j / place) % 10]++;

        // Determine cummulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in the correct place
        for (int i = size - 1; i >= 0; i--) {
            output[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }
        for (int i = 0; i < size; i++)
            arr[i] = output[i];
    }

    // Main function to implement radix sort
    static void radixSort(int[] arr) {
        int max = findMax(arr);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(arr, place);
    }

    static void win(int[] x) {
        System.out.println("____Highscore____");
        System.out.println("Fist place: " + x[x.length-1]);
        System.out.println("Second place: " + x[x.length-2]);
        System.out.println("Third place: " + x[x.length-3]);
        System.out.println("The worst result: "+ x[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number of participants (must be bigger than 4): ");
        int participants = sc.nextInt();
        while(participants<=4) {
            System.out.print("Please enter a number bigger than four: ");
            participants = sc.nextInt();
        }

        int[] results = new int[participants];

        input(results);
        show(results);
        sort(results);
        show(results);
        win(results);
    }
}