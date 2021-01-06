import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    private final boolean [][] grid;
    private final int lenght;
    private WeightedQuickUnionUF uf;
    private final int top = 0;
    private int bottom;
    private int numOfSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n <= 0) throw new IllegalArgumentException();
        grid = new boolean[n][n];
        lenght = n;
        bottom = n*n +1;
        uf = new WeightedQuickUnionUF(n*n +2);

    }

    // opens the site (row, col) if it is not open already
    public void open (int row, int col) {
        if (row < 0 || row > lenght || col < 0 || col > lenght) throw new java.lang.IllegalArgumentException();
        grid [row-1] [col-1] = true;

        if (row==1) {
            uf.union(getSiteIndex(row, col), top);
        }
        if (row == lenght) {
            uf.union(getSiteIndex(row, col), bottom);
        }
        if (lenght > row && isOpen(row+1, col )) {
            uf.union(getSiteIndex(row, col), getSiteIndex(row + 1, col));
        }
        if (row > 1 && isOpen(row-1, col )) {
            uf.union(getSiteIndex(row, col), getSiteIndex(row - 1, col));
        }
        if (col > 1 && isOpen(row, col-1)) {
            uf.union(getSiteIndex(row, col), getSiteIndex(row, col - 1));
        }
        if (col < lenght && isOpen(row, col+1)) {
            uf.union(getSiteIndex(row, col), getSiteIndex(row, col + 1));
        }

    }
    private int getSiteIndex(int i, int j) {
        return lenght * (i - 1) + j;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > lenght || col <= 0 || col > lenght) throw new java.lang.IllegalArgumentException();
        return grid[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row > lenght || row < 0 || col > lenght || col < 0) throw new IllegalArgumentException();
        return uf.find(getSiteIndex(row, col)) == uf.find(top);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        for (int i = 0; i < lenght; ++i) {
            for (int j = 0; j < lenght; ++j) {
                if (isOpen(i, j))
                    numOfSites++;
            }
        }
        return numOfSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(top) == uf.find(bottom);
    }

    // test client (optional)
     public static void main(String[] args) {
        Percolation pew = new Percolation(3);
        pew.open(1,3);
        pew.open(2,3);
        pew.open(3,3);
        System.out.println(pew.isOpen(1,1));
        System.out.println(pew.percolates());

     }
}
