public class QuickUnionUF {
    private int[] id;
    private int[] size;


    public QuickUnionUF(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[i] = i;
            size[i] += size[j];
        }
    }

    public static void main(String args[]) {
        QuickUnionUF obj = new QuickUnionUF(10);
        obj.union(3, 4);
        obj.union(4, 9);
        obj.union(8, 0);
        obj.union(2, 3);
        obj.union(5, 6);
        obj.union(5, 9);
        System.out.println(obj.connected(0,4));

    }
}





