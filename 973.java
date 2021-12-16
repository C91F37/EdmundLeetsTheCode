import java.lang.Math;
class Solution {
    
    double d (int a[]) {
        return Math.hypot(a[0], a[1]);
    }
    
    int partition (int a[][], int low, int high) {
        double p = d(a[high]);
        int i = (low-1); 
        for (int j = low; j < high; j++) {
            if (d(a[j]) <= p) {
                i++;
                int t [] = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        
        int t [] = a[i+1];
        a[i+1] = a[high];
        a[high] = t;
        
        return i+1;
    }
    
    void quicksort(int a[][], int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            
            quicksort(a, low, p-1);
            quicksort(a, p+1, high);
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        quicksort(points, 0, points.length-1);
        int ret[][] = new int[k][2];
        for (int i = 0; i < k; i ++) {
            ret[i] = points[i];
        }
        return ret;
    }
}
