import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Sorter here.
 *
 * @author Kieran Sutton
 * @version 10/18/17
 */
public class Sorter {
    public List<String> quicksort(List<String> inputArray) {
        String pivot = inputArray.get(inputArray.size() - 1);
        int wall = 0;
        for(int i = 0; i < inputArray.size(); i++) {
            String value = inputArray.get(i);
            if(value.compareTo(pivot) < 0) {
                inputArray.set(i, inputArray.get(wall));
                inputArray.set(wall, value);
                wall++;
            }
        }
        for(int i = inputArray.size() - 1; i > wall; i--) {
            inputArray.set(i, inputArray.get(i - 1));
        }
        inputArray.set(wall, pivot);
        
        Sorter sorter = new Sorter();
        List<String> lowArray = new ArrayList<String>();
        for(int i = 0; i < wall; i++) {
            lowArray.add(inputArray.get(i));
        }
        if(lowArray.size() > 1 && lowArray.size() > Collections.frequency(lowArray, lowArray.get(0))) {
            lowArray = sorter.quicksort(lowArray);
        }
        
        List<String> highArray = new ArrayList<String>();
        for(int i = wall; i < inputArray.size(); i++) {
            highArray.add(inputArray.get(i));
        }
        if(highArray.size() > 1 && highArray.size() > Collections.frequency(highArray, highArray.get(0))) {
            highArray = sorter.quicksort(highArray);
        }
        
        List<String> outputArray = new ArrayList<String>();
        for(String value : lowArray) {
            outputArray.add(value);
        }
        for(String value : highArray) {
            outputArray.add(value);
        }
        
        return outputArray;
    }
}