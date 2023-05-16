func backtrack(cur string, openN int, closeN int, result *[]string) {
    if openN == 0 && closeN == 0 {
       *result = append( *result, cur)
       return
    }    

    if openN > 0 {
        backtrack(cur + "(", openN-1, closeN, result)
    }
    if openN < closeN {
        backtrack(cur + ")", openN, closeN-1, result)
    }
    
}

func generateParenthesis(n int) []string {
    result := []string{} 
    backtrack("(", n-1, n, &result)
    return result
}