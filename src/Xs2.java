import java.util.Scanner;

public class Xs2 {
    public static int checkSort = 0;

    public static void showSalary(double[] salaries) {
        System.out.println("Danh sách lương nhân viên: ");
        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("Nhân viên %d : %f\n", i + 1, salaries[i]);
        }
    }

    public static int selectionSort(double[] salaries, int check) {
        if (check == 1) {
            for (int i = 0; i < salaries.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < salaries.length; j++) {
                    if (salaries[minIndex] > salaries[j]) {
                        minIndex = j;
                    }
                }
                double temp = salaries[minIndex];
                salaries[minIndex] = salaries[i];
                salaries[i] = temp;

            }
            checkSort = 1;
            return 1;
        }
        if (check == 2) {
            for (int i = 0; i < salaries.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < salaries.length; j++) {
                    if (salaries[minIndex] < salaries[j]) {
                        minIndex = j;
                    }
                }
                double temp = salaries[minIndex];
                salaries[minIndex] = salaries[i];
                salaries[i] = temp;

            }
            checkSort = 2;

            return 2;
        }
        return 0;
    }

    public static boolean linearSearch(double[] salaries, double value) {
        for (int i = 0; i < salaries.length; i++) {
            if (salaries[i] == value) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySearch(double[] salaries, double value) {

        int left = 0, right = salaries.length - 1;
        if (checkSort != 1) {
            selectionSort(salaries, 1);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (salaries[mid] == value) {
                return true;
            }
            if (salaries[mid] < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void salaryMinMax(double[] salaries) {
        double min, max;
        if (checkSort == 1) {
            min = salaries[0];
            max = salaries[salaries.length - 1];
            System.out.println("Lương cao nhất: " + max);
            System.out.println("Lương thấp nhất: " + min);
        } else if (checkSort == 2) {
            max = salaries[0];
            min = salaries[salaries.length - 1];
            System.out.println("Lương cao nhất: " + max);
            System.out.println("Lương thấp nhất: " + min);
        } else {
            min = salaries[0];
            max = salaries[0];

            for (int i = 0; i < salaries.length - 1; i++) {
                if (salaries[i] < min) {
                    min = salaries[i];
                }
                if (salaries[i] > max) {
                    max = salaries[i];
                }
            }
            System.out.println("Lương cao nhất: " + max);
            System.out.println("Lương thấp nhất: " + min);
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(scanner.nextLine());
        double[] salaries = new double[n];
        double sum = 0;
        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("Lương nhân viên thứ %d: ", i + 1);
            salaries[i] = Double.parseDouble(scanner.nextLine());
            sum += salaries[i];
        }
        do {
            System.out.println("--- QUẢN LÝ LƯƠNG NHÂN VIÊN ---");
            System.out.println("1. Xem danh sách lương");
            System.out.println("2. Sắp xếp lương");
            System.out.println("3. Tìm kiếm lương cụ thể");
            System.out.println("4. Thống kê lương");
            System.out.println("5. Thoát");
            System.out.printf("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showSalary(salaries);
                    break;
                case 2:
                    System.out.println("Chọn cách sắp xếp:");
                    System.out.println("1. Tăng dần");
                    System.out.println("2. Giảm dần");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            int check1 = selectionSort(salaries, choice2);
                            if (check1 == 1) {
                                System.out.println("Đã sắp xếp lương tăng dần.");
                            }
                            break;
                        case 2:
                            int check2 = selectionSort(salaries, choice2);
                            if (check2 == 2) {
                                System.out.println("Đã sắp xếp lương giảm dần.");
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.printf("Nhập lương cần tìm: ");
                    double salariSearch = Double.parseDouble(scanner.nextLine());

                    if (linearSearch(salaries, salariSearch)) {
                        System.out.printf("Linear Search: %f\n", salariSearch);

                    } else {
                        System.out.println("Linear Search: Không tìm thấy");
                    }
                    if (binarySearch(salaries, salariSearch)) {
                        System.out.printf("Binary Search (mảng tăng dần): %f\n", salariSearch);
                    } else {
                        System.out.println("Binary Search (mảng tăng dần): Không tìm thấy");
                    }
                    break;
                case 4:
                    System.out.println("Tổng lương: " + sum);
                    System.out.println("Lương trung bình: " + sum / salaries.length);
                    salaryMinMax(salaries);
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
