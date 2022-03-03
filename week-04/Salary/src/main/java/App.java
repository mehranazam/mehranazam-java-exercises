import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class App {

    public static void main(String[] args) {
        System.out.println(grossSalary(LocalDate.of(2022, 1, 1), BigDecimal.valueOf(50000)));
    }

    public static BigDecimal grossSalary(LocalDate start, BigDecimal yearly)throws IllegalArgumentException {
        if (start.getDayOfMonth() != 1) {
            throw new IllegalArgumentException();
        }

        //start .until end * 1.03

        Period untilEndOfYear = start.until(LocalDate.of(start.getYear(), 12, 31));

        BigDecimal monthly = yearly.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);

        LocalDate end = LocalDate.of(start.getYear(), 12, 31);

        LocalDate threeMonthsAfter = start.plusMonths(3);

        LocalDate sixMonthsAfter = start.plusMonths(6);




        BigDecimal sum = BigDecimal.ZERO;
        for (; start.compareTo(threeMonthsAfter) < 0; start = start.plusMonths(1)) {
//            if (day.getDayOfWeek() != DayOfWeek.SATURDAY && day.getDayOfWeek() != DayOfWeek.SUNDAY) {
//                System.out.printf("%s: %s%n", day.getDayOfWeek(), day);
//            }
            sum = sum.add(monthly);
            System.out.println("sum = " + sum);
    }





        //after 3 months
            //  add 6 percent

        monthly = monthly.multiply(BigDecimal.ONE.add(BigDecimal.valueOf(0.03)));
        for (; threeMonthsAfter.compareTo(sixMonthsAfter) < 0; start = start.plusMonths(1)) {

            sum = sum.add(monthly);
            System.out.println("sum = " + sum);
        }


        //after 6 months

        monthly = monthly.multiply(BigDecimal.ONE.add(BigDecimal.valueOf(0.06)));
        for (; sixMonthsAfter.compareTo(end) < 0; start = start.plusMonths(1)) {

            sum = sum.add(monthly);
            System.out.println("sum = " + sum);
        }



        return null;
    }
}
