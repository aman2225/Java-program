import java.util.ArrayList;
import java.util.List;

public class PageReplacement {

    public static void fifo(List<Integer> pages, int frames) {
        List<Integer> memory = new ArrayList<>();
        int pageFaults = 0;
        for (int page : pages) {
            if (!memory.contains(page)) {
                if (memory.size() < frames) {
                    memory.add(page);
                } else {
                    memory.remove(0);
                    memory.add(page);
                }
                pageFaults++;
            }
            System.out.print("Page Frames after request " + page + ": ");
            for (int value : memory) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println("Total Page Faults: " + pageFaults);
    }

    public static void main(String[] args) {
        System.out.println("FIFO:");
        List<Integer> fifoPages = List.of(1, 3, 0, 3, 5, 6, 3);
        fifo(fifoPages, 3);
    }
}
