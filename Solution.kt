
class Solution {

    private companion object {
        const val NO_UNIQUE_FREQUENCY = -1
    }

    fun firstUniqueFreq(input: IntArray): Int {
        // inclusive range of possible values: [1, pow(10, 5)]
        val maxValue = input.max()
        val frequencyOfValues = IntArray(maxValue + 1)
        val frequencyOfFrequencies = IntArray(input.size + 1)

        for (value in input) {
            --frequencyOfFrequencies[frequencyOfValues[value]]
            ++frequencyOfValues[value]
            ++frequencyOfFrequencies[frequencyOfValues[value]]
        }

        var firstUniqueFrequency = NO_UNIQUE_FREQUENCY
        for (value in input) {
            if (frequencyOfFrequencies[frequencyOfValues[value]] == 1) {
                firstUniqueFrequency = value
                break
            }
        }

        return firstUniqueFrequency
    }
}
