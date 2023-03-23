package homeworks.homework18;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        SymmetricMatrix matrix = new SymmetricMatrix(3, 0);

        matrix.set(1, 1, 1);

        matrix.printMatrix();

        try {
            SymmetricMatrix matrix2 = new SymmetricMatrix(-5, 0);

            matrix2.set(1, 1, 1);

            matrix2.printMatrix();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SymmetricMatrix matrix3 = new SymmetricMatrix(3, 0);

            matrix3.set(-1, 0, 1);

            matrix3.printMatrix();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class SymmetricMatrix {
        private int size;
        private int[] matrix;

        public SymmetricMatrix(int size, int defaultValue) {
            if (size <= 0) {
                throw new IllegalArgumentException("Size cannot be zero or negative.");
            }

            this.size = size;
            int numElements = size * (size + 1) / 2;
            matrix = new int[numElements];

            Arrays.fill(matrix, defaultValue);
        }

        public int get(int row, int column) {
            if (row < 0 || column < 0 || row >= size || column >= size) {
                throw new IllegalArgumentException("Invalid rows and columns.");
            }

            int index = calculateIndex(row, column);

            return matrix[index];
        }

        public void set(int row, int column, int value) {
            if (row < 0 || column < 0 || row >= size || column >= size) {
                throw new IllegalArgumentException("Invalid rows and columns.");
            }

            int index = calculateIndex(row, column);
            matrix[index] = value;
        }

        public void printMatrix() {
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    System.out.print(get(row, column) + " ");
                }
                System.out.println();
            }
        }

        private int calculateIndex(int row, int column) {
            return row * size + column - (row * (row + 1)) / 2;
        }
    }
}
