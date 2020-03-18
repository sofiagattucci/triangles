package it.unimi.di.vec.ass1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleImpl implements Triangle{
    int l1, l2, l3;
    public TriangleImpl() throws IllegalArgumentException, InputMismatchException {
        Scanner catchInput = new Scanner(System.in);
        this.l1 = catchInput.nextInt();
        this.l2 = catchInput.nextInt();
        this.l3 = catchInput.nextInt();

        if(!checkPositivity())
            throw new IllegalArgumentException("Number must be positive");

        if (!checkTriangleValidity())
            throw new IllegalArgumentException("Number of sides cannot create triangle");
    }
    public void describe() {
        if (this.l1 == this.l2) {
            if (this.l1 == this.l3)
                System.out.print("equilateral");
            else
                System.out.print("isosceles");
        } else if (this.l1 == this.l3 || this.l2 == this.l3) {
            System.out.print("isosceles");
        } else {
            System.out.print("scalene");
        }
    }

    private boolean checkPositivity(){
        return this.l1 > 0 && this.l2 > 0 && this.l3 > 0;
    }

    private boolean checkTriangleValidity() {
        return this.l1 + this.l2 > this.l3 && this.l1 + this.l3 > this.l2 && this.l2 + this.l3 > this.l1;
    }
}
