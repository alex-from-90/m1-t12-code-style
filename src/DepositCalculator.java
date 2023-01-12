import java.util.Scanner;

public class DepositCalculator { // Считаем процентную ставку
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return rand(pay, 2);
    }

    double calculateSimplePercent(double Amount, double yearRate, int depositPeriod) {
        return rand(Amount + Amount * yearRate * depositPeriod, 2);
    }

    double rand(double value
            , int places) {
        double scale = Math.pow
                (10, places);
        return Math.round(value * scale)
                / scale;
    }

    void viewMenuAndCalculatingIncome() { //Узнаём входные даные и высчитываем сумму по окончанию вклада
        int period, action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double deposit = 0;
        if (action == 1) deposit = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            deposit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + deposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().viewMenuAndCalculatingIncome();
    }

}
