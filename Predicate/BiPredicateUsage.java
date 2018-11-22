
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateUsage {

    public static void main(String[] args) {
        List<String> schedules = new ArrayList<>();
        schedules.add("MONDAY");
        schedules.add("WEDNESDAY");
        schedules.add("SATURDAY");
        schedules.add("SUNDAY");

        // it can be used used by passing 
        System.out.println("Monday set?    " + isScheduled(schedules, daysOfweek.MONDAY));
        System.out.println("Tuesday set?   " + isScheduled(schedules, daysOfweek.TUESDAY));
        System.out.println("Sunday set?    " + isScheduled(schedules, daysOfweek.SUNDAY));
    }

    private static String isScheduled(List<String> schedules, daysOfweek selectedDay) {
        // Declaring BiPredicate to compare two objects
        BiPredicate<String, daysOfweek> dayFlag = (s, d) -> s.equals(d.toString());
        // ParallelStream is same as stream; you can use this if your operation is independent
        // and execution order is not necessary
        return schedules.parallelStream().filter(s -> dayFlag.test(s, selectedDay)).findAny().isPresent() ? "Y" : "N";
    }

    enum daysOfweek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
//Expected output
//Monday set?    Y
//Tuesday set?   N
//Sunday set?    Y