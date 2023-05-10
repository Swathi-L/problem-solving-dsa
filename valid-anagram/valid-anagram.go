func isAnagram(s string, t string) bool {
    m1 := make(map[rune]int)

    for _, char := range s {
        count, ok := m1[char]
        if(ok) {
            count += 1
            m1[char] = count
        }else {
            m1[char] = 1
        }
    }


    for _, char := range t {
        count, ok := m1[char]
        if(ok) {
            count -= 1
            m1[char] = count
        }else {
          return false
        }
    }

    for _, val := range m1 {
        if val!=0 {
            return false
        }
    }

    return true
}