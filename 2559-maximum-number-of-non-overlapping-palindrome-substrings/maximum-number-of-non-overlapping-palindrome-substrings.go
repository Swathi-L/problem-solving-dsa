func maxPalindromes(s string, k int) int {
	ans := 0
	sb := []rune(s)

	for i := 0; i < len(sb); i++ {
		// odd length
		l, r := i, i
		for l >= 0 && r < len(sb) && sb[l] == sb[r] && sb[l] != '$' && sb[r] != '$' {
			if r-l+1 >= k {
				ans++
				sb[l] = '$'
				sb[r] = '$'
				break
			}
			l--
			r++
		}
		// even length
		l, r = i, i+1
		for l >= 0 && r < len(sb) && sb[l] == sb[r] && sb[l] != '$' && sb[r] != '$' {
			if r-l+1 >= k {
				ans++
				sb[l] = '$'
				sb[r] = '$'
				break
			}
			l--
			r++
		}
	}

	return ans
}

