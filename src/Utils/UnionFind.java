package Utils;

public class UnionFind {
    private int[] father;
    private int[] rank;
    private int len;

    public UnionFind(int n) {
        assert n >= 0;
        this.father = new int[n];
        this.rank   = new int[n];
        this.len = n;
        for (int i = 0; i < len; i++){
            this.father[i] = i;
            this.rank[i] = 1;
        }
    }

    public void union(int x, int y){
        assert x >= 0 && x < len && y >= 0 && y < len;
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        if (rank[rootX] == rank[rootY]){
            father[rootX] = rootY;
            rank[rootY] ++;
        }else if (rank[rootX] < rank[rootY]){
            father[rootX] = rootY;
        }else
            father[rootY] = rootX;
    }

    public int find(int x){
        assert x >= 0 && x < len;
        return (x == father[x]) ? x : (father[x] = find(father[x]));
    }
}
