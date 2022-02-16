package lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"4", "3", "2", "1"},
                {"5", "6", "7", "8"},
                {"8", "7", "6", "5"}
        };
        String[][] arr1 = new String[][]{
                {"1", "2", "3", "4"},
                {"4", "3", "5", "1"},
                {"5", "6", "7", "8"},
                {"8", "e", "6", "5"}
        };
        int sum = 0;
        int sum1 = 0;
        try {
            try {
                sum = matrix(arr);
                sum1 = matrix(arr1);
                System.out.println(sum);
                System.out.println(sum1);
            } catch (MyArraySizeException e) {
                System.out.println("Невернный размер массива!");
            }
        } catch (MyArrayDataException e) {
            System.out.println(new StringBuilder().append("Неверное значение в ячейке: ").append(e.a).append(",").append(e.b).toString());
        } finally {
            for (int i : new int[]{sum, sum1}) System.out.println(i);
        }
    }
    public static int matrix(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int x = 0;
        if (arr.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    x += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return x;
    }
}