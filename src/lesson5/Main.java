package lesson5;

public class Main {

    public static void main(String[] args) {
        array1();
        array2();
    }
    public static void array1() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long timeOne = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы первого метода: " + (System.currentTimeMillis() - timeOne) + " ms.");
    }

    public static void array2() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long timeOne = System.currentTimeMillis();
        float[] leftArry = new float[size / 2];
        float[] rightArry = new float[size / 2];
        System.arraycopy(arr, 0, leftArry, 0, size / 2);
        System.arraycopy(arr, size / 2, rightArry, 0, size / 2);

        MyThread t1 = new MyThread() {
            @Override
            public void run() {
                for (int i = 0; i < leftArry.length; i++) {
                    leftArry[i] = (float) (leftArry[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        MyThread t2 = new MyThread() {
            @Override
            public void run() {
                for (int i = 0; i < rightArry.length; i++) {
                    rightArry[i] = (float) (rightArry[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        t1.start();
        t2.start();
        float[] arr2 = new float[size];
        System.arraycopy(leftArry, 0, arr2, 0, size / 2);
        System.arraycopy(rightArry, 0, arr2, size / 2, size / 2);

        System.out.println("Время работы второго метода: " + (System.currentTimeMillis() - timeOne) + " ms.");
    }
}
