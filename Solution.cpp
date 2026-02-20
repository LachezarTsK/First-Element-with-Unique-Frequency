
#include <vector>
using namespace std;

class Solution {

    static const int NO_UNIQUE_FREQUENCY = -1;

public:
    int firstUniqueFreq(const vector<int>& input) const {
        // inclusive range of possible values: [1, pow(10, 5)]
        int maxValue = *ranges::max_element(input);
        vector<int> frequencyOfValues(maxValue + 1);
        vector<int> frequencyOfFrequencies(input.size() + 1);

        for (const auto& value : input) {
            --frequencyOfFrequencies[frequencyOfValues[value]];
            ++frequencyOfValues[value];
            ++frequencyOfFrequencies[frequencyOfValues[value]];
        }

        int firstUniqueFrequency = NO_UNIQUE_FREQUENCY;
        for (const auto& value : input) {
            if (frequencyOfFrequencies[frequencyOfValues[value]] == 1) {
                firstUniqueFrequency = value;
                break;
            }
        }

        return firstUniqueFrequency;
    }
};
