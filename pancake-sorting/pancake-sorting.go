import (
    "math"
)
func flip(arr []int, k int) {

    for i:=0; i<k/2; i++ {
        tmp := arr[i]
        arr[i] = arr[k-1-i]
        arr[k-1-i] = tmp
    }
}

func findMaxIdx(arr []int, n int) (int) {
    max := math.MinInt32
    maxIdx := 0
    for i:=0; i<=n; i++ {
        if max < arr[i] {
            max = arr[i]
            maxIdx = i
        }
    }
    return maxIdx
}

func pancakeSort(arr []int) []int {
    
    result := []int{}
    for i:=len(arr)-1; i>0; i-- {
        idx := findMaxIdx(arr, i)
        flip(arr, idx+1)
        flip(arr, i+1)
        result = append(result, idx+1, i+1)
    }
    
    return result
}
