import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        //1. figure out first Friday of the year
        //2. Fast forward until 2 week period after date
        //3. count until end of year

        BigDecimal total = BigDecimal.ZERO;

        LocalDate currentDate = LocalDate.of(date.getYear(), 1, 1);
        LocalDate endOfYear = LocalDate.of(date.getYear(), 12, 31);

        while(currentDate.getDayOfWeek() != DayOfWeek.FRIDAY){
            currentDate = currentDate.plusDays(1);
        }

        while(currentDate.compareTo(endOfYear) <= 0){
            if(currentDate.compareTo(date) >= 0){
                
            }
            currentDate = currentDate.plusWeeks(2);
        }
        return total;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        return null;
    }

}
