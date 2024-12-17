<?php  

// 354ms 31.12MB
class Solution {

    /**
     * @param string $s
     * @param integer $repeatLimit
     * @return string
     */
    function repeatLimitedString($s, $repeatLimit) {
        // Count the frequency of each character in the string
        $charFrequencies = array_count_values(str_split($s));
        
        // Convert the frequency array into an array of [char, frequency] pairs
        $sortedCharacters = [];
        foreach ($charFrequencies as $char => $freq) {
            $sortedCharacters[] = [$char, $freq];
        }
        
        // Sort the characters in descending order based on their frequency
        usort($sortedCharacters, function($a, $b) {
            return strcmp($b[0], $a[0]);
        });
        
        $result = [];
        
        while (!empty($sortedCharacters)) {
            // Get the character with the highest frequency
            list($currentChar, $currentFreq) = array_shift($sortedCharacters);
            
            // If the current character's frequency is within the repeat limit
            if ($currentFreq <= $repeatLimit) {
                // Append all occurrences of the current character to the result
                $result[] = str_repeat($currentChar, $currentFreq);
            } else {
                // Append up to repeatLimit occurrences of the current character
                $result[] = str_repeat($currentChar, $repeatLimit);
                // Update the frequency of the current character
                $currentFreq -= $repeatLimit;
                
                // Check if there is a next character to break the sequence
                if (!empty($sortedCharacters)) {
                    // Get the next character and its frequency
                    list($nextChar, $nextFreq) = array_shift($sortedCharacters);
                    // Append one occurrence of the next character
                    $result[] = $nextChar;
                    // Update the frequency of the next character
                    $nextFreq -= 1;
                    
                    // If the next character's frequency is not zero, put it back in the list
                    if ($nextFreq > 0) {
                        $sortedCharacters[] = [$nextChar, $nextFreq];
                    }
                    
                    // Put the current character back in the list if its frequency is not zero
                    if ($currentFreq > 0) {
                        $sortedCharacters[] = [$currentChar, $currentFreq];
                    }
                    
                    // Re-sort the array to maintain the order after updating the frequency
                    usort($sortedCharacters, function($a, $b) {
                        return strcmp($b[0], $a[0]);
                    });
                } else {
                    // If no next character is available, break the loop
                    break;
                }
            }
        }
        
        return implode('', $result);
    }
}