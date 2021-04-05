package Utils;

public class LineTree1 implements Comparable{
    LineTree1 leftNode, rightNode;
    int leftPoint, rightPoint, leftHeight, rightHeight;
    LineTree1 father;

    public LineTree1(int leftPoint, int rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
        this.father = null;
        this.leftHeight = 0;
        this.rightHeight = 0;
    }

    public void addNode(int leftPoint, int rightPoint){
        LineTree1 child = new LineTree1(leftPoint, rightPoint);
        this.leftPoint = (this.leftPoint >= leftPoint) ? leftPoint : this.leftPoint;
        this.rightPoint = (this.rightPoint <= rightPoint) ? rightPoint : this.rightPoint;

    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof LineTree1))
            throw new RuntimeException("Do not accept an object is not LineTree or its child to compare");
        LineTree1 node = (LineTree1)o;
        return Integer.compare(this.leftPoint, node.leftPoint);
    }
}
