func checkAlmostEquivalent(word1 string, word2 string) bool {
    // maps to store the char and frequency of each char in word1 & word2
    // iterate over each map and find fre diff, if diff > 3, return false 
    // Return true

    map1 := make(map[rune]int)
    map2 := make(map[rune]int)

    countFrequency(word1, map1)
    countFrequency(word2, map2)

    return checkFrequencyDiff(map1, map2) &&
        checkFrequencyDiff(map2, map1)
}

func countFrequency(word string, countMap map[rune]int) {
     for _, val := range word {
        count, ok := countMap[val]
        if !ok {
            countMap[val] = 1
        } else {
            countMap[val] = count+1
        }
    }
}

func checkFrequencyDiff(map1, map2 map[rune]int) bool {
    for key, val := range map1 {
        val2 := map2[key]
        if math.Abs(float64(val - val2)) > float64(3) {
            return false
        }
    }
    return true
}