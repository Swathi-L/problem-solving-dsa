func maxProduct(nums []int) int {
    
    var product int 

    maxProduct := math.MinInt

    for idx, _ := range nums {
        product = 1
        for i:=idx; i<len(nums); i++{
            product *= nums[i]
            
            if(product > maxProduct) {
            maxProduct = product
            }
        }   
    }

    if(product > maxProduct) {
        maxProduct = product
    }

    return maxProduct
}