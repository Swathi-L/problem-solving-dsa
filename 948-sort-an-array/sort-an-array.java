class Solution {
    
     void merge(int arr[], int l, int m, int r)
    {
        //Your code here
        int[] tmp = new int[r-l+1];
        int ptr1 = l;
        int ptr2 = m+1;
        int tmpPtr = 0;
        while(ptr1 <= m && ptr2 <= r) {
            if (arr[ptr1] > arr[ptr2]) {
                tmp[tmpPtr++] = arr[ptr2];
                ptr2++;
            } else if (arr[ptr1] < arr[ptr2]) {
                tmp[tmpPtr++] = arr[ptr1];
                ptr1++;
            } else {
                tmp[tmpPtr++] = arr[ptr1];
                tmp[tmpPtr++] = arr[ptr2];
                ptr1++;
                ptr2++;
            }
        }

        while(ptr1 <= m) {
            tmp[tmpPtr++] = arr[ptr1];
            ptr1++;
        }
        while(ptr2 <= r) {
            tmp[tmpPtr++] = arr[ptr2];
            ptr2++;
        }

        //copy from tmp to arr
        int k=0;
        for(int i=l; i <= r; i++) {
            arr[i] = tmp[k++];
        }
    }

    void sort(int arr[], int l, int r)
    {
        //Write your code here
        //Call mergeSort from here
        if(l == r) {
            return;
        }
        int m = l + ((r - l)/2);
        // divide left
        sort(arr, l, m);
        // divide right
        sort(arr, m+1, r);
        // merge
        merge(arr, l, m, r);
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }
}