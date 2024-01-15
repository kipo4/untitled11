public class LogicalEquivalenceChecker {
    // Определение базисных логических функций
    public static boolean AND(boolean x, boolean y) {
        return x && y;
    }
    public static boolean OR(boolean x, boolean y) {
        return x || y;
    }
    public static boolean NOT(boolean x) {
        return !x;
    }
    // Исходное логическое выражение
    public static boolean originalExpression(boolean x1, boolean x2) {
        // Измененное исходное логическое выражение
        return OR(x2, x1);
    }
    // Упрощенное логическое выражение
    public static boolean simplifiedExpression(boolean x1, boolean x2) {
        // Пример упрощенного логического выражения (так как x2 OR x1 эквивалентно x1 OR x2, то можно использовать OR(x1, x2))
        return OR(x1, x2);
    }
    public static void main(String[] args) {
        // Проверка равносильности для каждого возможного набора значений
        for (boolean x1 : new boolean[]{false, true}) {
            for (boolean x2 : new boolean[]{false, true}) {
                boolean originalResult = originalExpression(x1, x2);
                boolean simplifiedResult = simplifiedExpression(x1, x2);

                // Вывод результатов
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
                System.out.println("Исходное выражение: " + originalResult);
                System.out.println("Упрощенное выражение: " + simplifiedResult);
                System.out.println("Равносильны: " + (originalResult == simplifiedResult));
                System.out.println("-------------------------");
            }
        }
    }
}
