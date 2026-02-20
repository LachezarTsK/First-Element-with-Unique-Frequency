
using System;

public class Solution
{
    private static readonly int NO_UNIQUE_FREQUENCY = -1;

    public int FirstUniqueFreq(int[] input)
    {
        // inclusive range of possible values: [1, pow(10, 5)]
        int maxValue = input.Max();
        int[] frequencyOfValues = new int[maxValue + 1];
        int[] frequencyOfFrequencies = new int[input.Length + 1];

        foreach (int value in input)
        {
            --frequencyOfFrequencies[frequencyOfValues[value]];
            ++frequencyOfValues[value];
            ++frequencyOfFrequencies[frequencyOfValues[value]];
        }

        int firstUniqueFrequency = NO_UNIQUE_FREQUENCY;
        foreach (int value in input)
        {
            if (frequencyOfFrequencies[frequencyOfValues[value]] == 1)
            {
                firstUniqueFrequency = value;
                break;
            }
        }

        return firstUniqueFrequency;
    }
}
