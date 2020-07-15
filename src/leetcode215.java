public class leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    public void quickSort(int[] nums,int left,int right){
        if(left>=right) return;
        int start = left,end = right;
        int target = nums[left];
        while(left<right){
            while(left<right&&nums[right]>target) right--;
            if(left<right) nums[left++] = nums[right];
            while(left<right&&nums[left]<target) left++;
            if(left<right) nums[right--] = nums[left];
        }
        nums[left] = target;
        quickSort(nums,start,left-1);
        quickSort(nums,left+1,end);
    }
    public void mergeSort(int[] nums,int low,int high){
        if(low>=high) return;
        int mid = (low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);

        int[] num = new int[high-low+1];
        int i=low,j=mid+1,k=0;
        while (i<=mid&&j<=high){
            num[k++] = nums[i]<nums[j]? nums[i++]:nums[j++];
        }
        while(i<=mid) num[k++] = nums[i++];
        while(j<=high) num[k++] = nums[j++];
        System.arraycopy(num,0,nums,low,high-low+1);
    }
    public void heapSort(int[] nums,int len){
        for (int i = len/2; i >=0 ; i--) {
            adjustHeap(nums,i,len);
        }
        for(int i = len;i>=0;i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustHeap(nums,0,i-1);
        }
    }
    public void adjustHeap(int[] nums,int pos,int len){
        int child,temp;
        for(temp = nums[pos];2*pos+1<=len;pos = child){
            child = 2*pos+1;
            if(child+1<=len&&nums[child]<nums[child+1]){
                child++;
            }
            if(temp<nums[child]){
                nums[pos] = nums[child];
            }else{
                break;
            }
        }
        nums[pos] = temp;
    }
    public  void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public void shellSort(int[] nums){
        int len = nums.length;
        for (int gap = len/2; gap >0 ; gap/=2) {
            for (int i = gap; i < len ; i++) {
                int temp = nums[i];
                int j;
                for(j=i-gap;j>=0&&temp<nums[j];j-=gap){
                    nums[j+gap] = nums[j];
                }
                nums[j+gap] = temp;
            }
        }

    }
}
