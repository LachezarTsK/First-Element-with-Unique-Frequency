
/**
 * @param {number[]} input
 * @return {number}
 */
var firstUniqueFreq = function (input) {
    const NO_UNIQUE_FREQUENCY = -1;
    // inclusive range of possible values: [1, pow(10, 5)]
    const maxValue = Math.max(...input);
    const frequencyOfValues = new Array(maxValue + 1).fill(0);
    const frequencyOfFrequencies = new Array(input.length + 1).fill(0);

    for (let value of input) {
        --frequencyOfFrequencies[frequencyOfValues[value]];
        ++frequencyOfValues[value];
        ++frequencyOfFrequencies[frequencyOfValues[value]];
    }

    let firstUniqueFrequency = NO_UNIQUE_FREQUENCY;
    for (let value of input) {
        if (frequencyOfFrequencies[frequencyOfValues[value]] === 1) {
            firstUniqueFrequency = value;
            break;
        }
    }

    return firstUniqueFrequency;
};
