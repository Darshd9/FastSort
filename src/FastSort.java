import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FastSort {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        List<String> list = read();
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

    public static List<String> read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("random.txt"));
        List<String> list = new ArrayList<>();
        String line = br.readLine();
        while(line != null){
            list.add(line);
            line = br.readLine();
        }
        br.close();
        return list;
    }

    public static void write(List<String>list) throws IOException {
        FileWriter fw = new FileWriter("sort.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(list.toString());
    }

}
