import java.util.*;

public class Ring2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of processes: ");
        int n = sc.nextInt(), ids[] = new int[n];
        boolean[] active = new boolean[n];
        
        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
            active[i] = true;
        }
        
        System.out.print("Initiator index (0–" + (n - 1) + "): ");
        int init = sc.nextInt(), curr = init, max = ids[init];
        System.out.println("Process " + ids[init] + " starts election.");

        do {
            curr = (curr + 1) % n;
            if (active[curr]) {
                System.out.println("Process " + ids[curr] + " gets message.");
                if (ids[curr] > max) max = ids[curr];
            }
        } while (curr != init);

        System.out.println("New coordinator: Process " + max);
        sc.close();
    }
}