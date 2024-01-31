/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {

    public void helper(NestedInteger nested, int dep, List<Integer> products) {
        
            if(nested.isInteger()) {
                products.add(nested.getInteger() * dep); 
                // System.out.println("num: "+nested.getInteger()+ " dep: "+dep);
            }
            else {
                for(NestedInteger n : nested.getList()) {
                    helper(n, dep+1, products);
                }   
            }
        }

    public int depthSum(List<NestedInteger> nestedList) {
        List<Integer> products = new ArrayList<>();
        
        for(NestedInteger n : nestedList) {
            helper(n, 1, products);
        }

        int sum = 0;
        for(int p : products) {
            sum += p;
        }
        return sum;
    }
}