func backtrack(cur string, openN int, closeN int) ([]string) {
    if openN == 0 && closeN == 0 {
        // result = append(result, cur)
        return []string{cur}
    }    

    var left, right []string

    if openN > 0 {
        left = backtrack(cur + "(", openN-1, closeN)
    }
    if openN < closeN {
        right = backtrack(cur + ")", openN, closeN-1)
    }
    return append(left, right...)
}

func generateParenthesis(n int) []string {
    return backtrack("(", n-1, n)
}