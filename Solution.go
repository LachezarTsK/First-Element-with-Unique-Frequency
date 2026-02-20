
package main

import "slices"

const NO_UNIQUE_FREQUENCY = -1

func firstUniqueFreq(input []int) int {
    // inclusive range of possible values: [1, pow(10, 5)]
    maxValue := slices.Max(input)
    frequencyOfValues := make([]int, maxValue + 1)
    frequencyOfFrequencies := make([]int, len(input) + 1)

    for _, value := range input {
        frequencyOfFrequencies[frequencyOfValues[value]]--
        frequencyOfValues[value]++
        frequencyOfFrequencies[frequencyOfValues[value]]++
    }

    firstUniqueFrequency := NO_UNIQUE_FREQUENCY
    for _, value := range input {
        if frequencyOfFrequencies[frequencyOfValues[value]] == 1 {
            firstUniqueFrequency = value
            break
        }
    }

    return firstUniqueFrequency
}
