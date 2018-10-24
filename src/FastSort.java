import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FastSort {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        List<Integer> list = read();
        long readtime = System.currentTimeMillis();
        System.out.println(readtime - start);
        Collections.sort(list);
        long sortime = System.currentTimeMillis();
        System.out.println(sortime-readtime);
        write(list);
        long end = System.currentTimeMillis();
        System.out.println(end - sortime);
        System.out.println(end - start);


    }

    public static List<Integer> read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("random.txt"));
        List<Integer> list = new ArrayList<>();
        String line = br.readLine();
        while(line != null){
            list.add(Integer.parseInt(line));
            line = br.readLine();
        }
        br.close();
        return list;
    }

    public static void write(List<Integer>list) throws IOException {
        FileWriter fw = new FileWriter("sort.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(list.toString());
    }

    public static void quickSort(List<Integer> arr, int low, int high){
        if (arr == null || arr.size() == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr.get(middle);

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr.get(i) < pivot) {
                i++;
            }

            while (arr.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

}
