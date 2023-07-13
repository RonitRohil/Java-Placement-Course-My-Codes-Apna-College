public class MaxMinElementQueries {

    static int tree[];

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static void buildST(int arr[], int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = (start + end) /2;
        buildST(arr, 2*i+1, start, mid);
        buildST(arr, 2*i+2, mid+1, end);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) {
            // no overlap
            return Integer.MIN_VALUE;
        }

        else if (si >= qi && sj <= qj) {
            //complete overlap
            return tree[i];
        }

        else{
            //partial overlap
            int mid = (si + sj)/2;
            int leftAns = getMaxUtil(2*i+1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if (idx > sj || idx < si) {
            return;
        }

        tree[i] = Math.max(tree[i], newVal);
        if (si != sj) {
            int mid = (si + sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal); //left
            updateUtil(2*i+2, mid+1, sj, idx, newVal); //right
        }
    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        arr[idx] = newVal;
        updateUtil(0, 0, n-1, idx, newVal); // segemnt tree updation
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println(getMax(arr, 2, 5));
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));
    }
}

/*
 * 
 * 
 * Max/Min Element Queries
 * Given an arr[], we have to answer few queries:
 *  a. Output Max/Min for the subarray[i..j]
 *  b. Update the element at idx
 * 
 *  {6, 8, -1, 2, 17, 1, 3, 2, 4}
 * 
 * 
 */