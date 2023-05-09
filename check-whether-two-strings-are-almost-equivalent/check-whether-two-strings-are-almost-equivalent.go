func checkAlmostEquivalent(word1 string, word2 string) bool {
    // maps to store the char and frequency of each char in word1 & word2
    // iterate over each map and find fre diff, if diff > 3, return false 
    // Return true

    map1 := make(map[rune]int)
    map2 := make(map[rune]int)

    for _, val := range word1 {
        count, ok := map1[val]
        if !ok {
            map1[val] = 1
        } else {
            map1[val] = count+1
        }
    }

    for _, val := range word2 {
        count, ok := map2[val]
        if !ok {
            map2[val] = 1
        } else {
            map2[val] = count+1
        }
    }

    for key, val := range map1 {
        val2 := map2[key]
        if math.Abs(float64(val - val2)) > float64(3) {
            return false
        }
    }

    for key, val := range map2 {
        val2 := map1[key]
        if  math.Abs(float64(val - val2)) > float64(3) {
            return false
        }
    }

    return true

}