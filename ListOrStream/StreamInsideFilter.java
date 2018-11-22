package java8.tips.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInsideFilter {

    public static void main(String args[]) {
        List<String> uiInput = new ArrayList<String>();
        uiInput.add("a");
        uiInput.add("b"); // Newly added element in UI screen
        List<String> dbInput = new ArrayList<String>();
        dbInput.add("a");
        dbInput.add("c"); // Removed element from UI screen

        System.out.println("Not in DB : have to add in database");
        System.out.println(uiInput.stream()
                                  .filter(ui -> dbInput.stream().allMatch(db -> !ui.equals(db)))
                                  .collect(Collectors.toList()));
        System.out.println("Not in UI : have to delete from database");
        System.out.println(dbInput.stream()
                                  .filter(db -> uiInput.stream().allMatch(ui -> !db.equals(ui)))
                                  .collect(Collectors.toList()));
        // Note: List.removeAll() is the best suitable solution in such case
        // This is a Sample usage for using stream() inside filter()
    }
}
// Expected output
//Not in DB : have to add in database
//[b]
//Not in UI : have to delete from database
//[c]
