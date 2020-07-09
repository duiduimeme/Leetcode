public class leetcode912 {
    /*leetcode912排序数组
    给你一个整数数组 nums，请你将该数组升序排列.
    * */
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int start,int end){
        if(start>end) return ;
        int i=start,j=end;
        int temp = nums[i];
        while(i<j){
            while(i<j&&nums[j]>temp){
                j--;
            }
            if(i<j) nums[i++] = nums[j];
            while(i<j&&nums[i]<temp){
                i++;
            }
            if(i<j) nums[j--] = nums[i];
        }
        nums[i] = temp;
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
    }
    public void initHeap(int[] nums,int pos,int len){
        int temp;
        int child;
        for(temp = nums[pos];2*pos+1<=len;pos = child){
            child = 2*pos+1;
            if(child<len&&nums[child]>nums[child+1])
                child++;
            if(temp<nums[child]){
                nums[pos] = nums[child];
            }else{
                break;
            }
        }
        nums[pos] = temp;
    }
    public static void heapSort(int[] a){
        int len = a.length;
        for(int i=a.length/2;i>=0;i--){
            dajustHeap(a,i,len-1);
        }
        for(int j=len-1;j>=0;j--){
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;
            dajustHeap(a,0,j-1);
        }
    }
    public static void dajustHeap(int[] a,int pos,int len){
        int temp;
        int child;
        for(temp = a[pos];2*pos+1<=len;pos=child){
            child = 2*pos+1;
            if(child<len&&a[child]>a[child+1]){
                child++;
            }
            if(a[child]<temp){
                a[pos] = a[child];
            }else{
                break;
            }
        }
        a[pos] = temp;
    }
}
