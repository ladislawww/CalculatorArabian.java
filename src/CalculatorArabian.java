import java.util.Scanner;

class CalculatorArabian {
    public static void main(String[] args) throws ExprExeption {
        System.out.println("Введите систему счисления. Доступные: Арабская, Римская");
        Scanner scn = new Scanner(System.in);
        String choice = scn.nextLine();
        if (choice.equalsIgnoreCase("Арабская")) {
            String[] actions = {"+", "-", "/", "*"};
            String[] regexActions = {"\\+", "-", "/", "\\*"};

            System.out.print("Введите выражение: ");
            String exp = scn.nextLine();

            int actionIndex = -1;
            for (int i = 0; i < actions.length; i++) {
                if (exp.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            }

            if (actionIndex == -1) {
                throw new ExprExeption("Строка не является математической операцией");
            }

            String[] data = exp.split(regexActions[actionIndex]);
            if (data.length > 2) {
                throw new ExprExeption("Формат математической операции не удовлетворяет заданию");
            }

            int a, b;
            a = Integer.parseInt(data[0]);

            if (Integer.parseInt(data[0]) > 10) {
                throw new ExprExeption("Нельзя вводить число больше 10");
            }

            b = Integer.parseInt(data[1]);

            if (b > 10) {
                throw new ExprExeption("Нельзя вводить число больше 10");
            }


            //выполняем с числами арифметическое действие
            int result = switch (actions[actionIndex]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default -> a / b;
            };
            //если числа были арабские, возвращаем результат в арабском числе
            System.out.println(result);

        } else if (choice.equalsIgnoreCase("Римская")) {
            String[] actions = {"+", "-", "/", "*"};
            String[] regexActions = {"\\+", "-", "/", "\\*"};

            System.out.println("Введите выражение");
            String exp2 = scn.nextLine();



            int actionIndex = -1;
            for (int i = 0; i < actions.length; i++) {
                if (exp2.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            }

            if (actionIndex == -1) {
                throw new ExprExeption("Строка не является математической операцией");
            }

            String[] rmnExp = exp2.split(regexActions[actionIndex]);

            if (rmnExp.length > 2 ) {
                throw new ExprExeption("Формат математической операции не удовлетворяет заданию");
            }

            String a;
            String b;
            int x;
            int y;



            switch (rmnExp[0]) {
                case "I" -> {
                    a = Roman.I.getValue();
                    x = Integer.parseInt(a);
                }
                case "II" -> {
                    a = Roman.II.getValue();
                    x = Integer.parseInt(a);
                }
                case "III" -> {
                    a = Roman.III.getValue();
                    x = Integer.parseInt(a);
                }
                case "IV" -> {
                    a = Roman.IV.getValue();
                    x = Integer.parseInt(a);
                }
                case "V" -> {
                    a = Roman.V.getValue();
                    x = Integer.parseInt(a);
                }
                case "VI" -> {
                    a = Roman.VI.getValue();
                    x = Integer.parseInt(a);
                }
                case "VII" -> {
                    a = Roman.VII.getValue();
                    x = Integer.parseInt(a);
                }
                case "VIII" -> {
                    a = Roman.VIII.getValue();
                    x = Integer.parseInt(a);
                }
                case "IX" -> {
                    a = Roman.IX.getValue();
                    x = Integer.parseInt(a);
                }
                case "X" -> {
                    a = Roman.X.getValue();
                    x = Integer.parseInt(a);
                }
                default -> throw new ExprExeption("Используются одновременно разные системы счисления");
            }


            switch (rmnExp[1]) {
                case "I" -> {
                    b = Roman.I.getValue();
                    y = Integer.parseInt(b);
                }
                case "II" -> {
                    b = Roman.II.getValue();
                    y = Integer.parseInt(b);
                }
                case "III" -> {
                    b = Roman.III.getValue();
                    y = Integer.parseInt(b);
                }
                case "IV" -> {
                    b = Roman.IV.getValue();
                    y = Integer.parseInt(b);
                }
                case "V" -> {
                    b = Roman.V.getValue();
                    y = Integer.parseInt(b);
                }
                case "VI" -> {
                    b = Roman.VI.getValue();
                    y = Integer.parseInt(b);
                }
                case "VII" -> {
                    b = Roman.VII.getValue();
                    y = Integer.parseInt(b);
                }
                case "VIII" -> {
                    b = Roman.VIII.getValue();
                    y = Integer.parseInt(b);
                }
                case "IX" -> {
                    b = Roman.IX.getValue();
                    y = Integer.parseInt(b);
                }
                case "X" -> {
                    b = Roman.X.getValue();
                    y = Integer.parseInt(b);
                }
                default -> throw new ExprExeption("Используются одновременно разные системы счисления или вы ввели число > 10");
            }


            int result = switch (actions[actionIndex]) {
                case "+" -> x + y;
                case "-" -> x - y;
                case "*" -> x * y;
                default -> x / y;
            };

            if (result < 0) {
                throw new ExprExeption("В римской системе счисления нет отрицательных чисел");
            }


            System.out.println(result);


        }
    }
}
