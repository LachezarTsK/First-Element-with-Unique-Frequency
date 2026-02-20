
import java.util.Arrays;

public class Solution {

    private static final int NO_UNIQUE_FREQUENCY = -1;

    public int firstUniqueFreq(int[] input) {
        // inclusive range of possible values: [1, pow(10, 5)]
        int maxValue = Arrays.stream(input).max().getAsInt();
        int[] frequencyOfValues = new int[maxValue + 1];
        int[] frequencyOfFrequencies = new int[input.length + 1];

        for (int value : input) {
            --frequencyOfFrequencies[frequencyOfValues[value]];
            ++frequencyOfValues[value];
            ++frequencyOfFrequencies[frequencyOfValues[value]];
        }

        int firstUniqueFrequency = NO_UNIQUE_FREQUENCY;
        for (int value : input) {
            if (frequencyOfFrequencies[frequencyOfValues[value]] == 1) {
                firstUniqueFrequency = value;
                break;
            }
        }

        return firstUniqueFrequency;
    }
}
