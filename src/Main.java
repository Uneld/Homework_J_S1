import java.util.Scanner;

//  1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
//  2) Вывести все простые числа от 1 до 1000
//  3) Реализовать простой калькулятор
public class Main {
    public static void main(String[] args) {
        // (T1)
        System.out.println(Factorial_T1(5));
        System.out.println(Triangle_T1(365));

        // (T2)
        PrintSimpleNumbers(1, 1000);

        //(T3)
        Calculator_T3();
    }

    private static int Factorial_T1(int num) {
        if (num == 1)
            return 1;
        return Factorial_T1(num - 1) * num;
    }

    private static int Triangle_T1(int num) {
        return num * (num + 1) / 2;
    }

    private static void PrintSimpleNumbers(int start, int end){
        for (int i = start; i < end; i++) {
            if (CheckPrime_T2(i)){
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    private static boolean CheckPrime_T2(int num) {
        return CheckPrime_T2(num, 2);
    }

    private static boolean CheckPrime_T2(int num, int div) {
        //div - дополнительный параметр для проверки на делимость. При вызове должен быть равен 2 т.к. первое простое число 2
        if (num < 2) {  // если меньше то не простое
            return false;
        } else if (num == 2 || num == 3) {// если два то сразу простое
            return true;
        } else if (num % div == 0) { //если делится на 2 без остатка сразу выходим - не простое
            return false;
        } else if (div * div > num) { //Проверка что делитель на меньше половины от числа т.к. все что больше половины будет остаток поэтому смысла дальше проверять нет
            return CheckPrime_T2(num, div + 1);
        } else {
            return true;
        }
    }

    public static void Calculator_T3() {
        double num1;
        double num2;
        double ans;
        char op;
        char act;
        boolean work = true;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число 1: ");
            num1 = scanner.nextDouble();
            System.out.print("Введите число 2: ");
            num2 = scanner.nextDouble();
            System.out.print("ведите действие (+, -, *, /): ");
            op = scanner.next().charAt(0);
            switch (op) {
                case '+' -> ans = num1 + num2;
                case '-' -> ans = num1 - num2;
                case '*' -> ans = num1 * num2;
                case '/' -> ans = num1 / num2;
                default -> {
                    System.out.println("Ошибка! Введите корректное действие");
                    continue;
                }
            }
            System.out.print("\nРезультат: ");
            System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);

            System.out.print("\nВведите \"q\" для выхода: ");
            act = scanner.next().charAt(0);
            if (act == 'q'){
                work = false;
            }
            System.out.println("Конец");
        }while (work);
    }
}