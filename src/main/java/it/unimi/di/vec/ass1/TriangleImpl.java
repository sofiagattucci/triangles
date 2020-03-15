package it.unimi.di.vec.ass1;

public class TriangleImpl implements Triangle{
    int l1, l2, l3;
    public TriangleImpl(int l1, int l2, int l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }
    public void describe() {
        if (this.l1 == this.l2) {
            if (this.l1 == this.l3)
                System.out.print("equilatero");
            else
                System.out.print("isoscele");
        } else if (this.l1 == this.l3 || this.l2 == this.l3) {
            System.out.print("isoscele");
        } else {
            System.out.print("scaleno");
        }
    }
}
