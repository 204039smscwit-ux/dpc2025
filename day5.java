import java.util.*;

public class LeadersInArray {

    public static List<Integer> findLeaders(int[] arr, int n) {
        List<Integer> leaders = new ArrayList<>();
        int maxFromRight = arr[n - 1];

        
        leaders.add(maxFromRight);

        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> result = findLeaders(arr, n);

        System.out.println("Leaders: " + result);

        sc.close();
    }
}
