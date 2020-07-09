public class sort {
        public static void insertSort(int []a){
            if(a!=null)
            {int temp;
                for(int i=1;i<a.length;i++){
                    temp = a[i];
                    int j=i;

                    while(j>0&&a[j-1]>temp){
                        a[j]=a[j-1];
                        j--;

                        a[j] = temp;}
                }
            }
        }
        public static void selectSort(int []a){
            int flag,temp;
            for(int i=0;i<a.length;i++){
                temp = a[i];
                flag=i;
                for(int j=i+1;j<a.length;j++){
                    if(a[j]<temp){
                        temp = a[j];
                        flag = j;
                    }
                }
                if(flag!=i){
                    a[flag] = a[i];
                    a[i] = temp;}
            }
        }
        public static void quickSort(int[] a,int low,int high){
            if(low>high) return;
            int i=low,j=high;
            int temp=a[i];
            while(i<j){
                while(i<j&&a[j]>temp){
                    j--;
                }
                if(i<j) a[i++] = a[j];
                while(i<j&&a[i]<temp){
                    i++;
                }
                if(i<j) a[j--] = a[i];
            }
            a[i] = temp;
            quickSort(a,low,i-1);
            quickSort(a,i+1,high);

        }
        public static void merge(int[] arr, int start, int end) {
            if (start >= end) return;
            int mid = (start + end) / 2;
            merge(arr, start, mid);
            merge(arr, mid + 1, end);

            int[] temp = new int[end - start + 1];
            int i = start, j = mid + 1, k = 0;
            while(i <= mid && j <= end)
                temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
            while(i <= mid)
                temp[k++] = arr[i++];
            while(j <= end)
                temp[k++] = arr[j++];
            //System.arraycopy(复制数组，起点，目标数组，起点，复制数据个数)
            System.arraycopy(temp, 0, arr, start, end-start+1);
        }
    public static void initHeap(int[] nums,int pos,int len){
        int temp;
        int child;
        for(temp = nums[pos];2*pos+1<=len;pos = child){
            child = 2*pos+1;
            if(child<len&&nums[child]<nums[child+1])
                child++;
            if(temp<nums[child]){
                nums[pos] = nums[child];
            }else{
                break;
            }
        }
        nums[pos] = temp;
    }
    public static void heapSort(int[] nums){
        int len = nums.length;
        for (int i = nums.length/2; i >=0 ; i--) {
            initHeap(nums,i,len-1);
        }
        for(int j=len-1;j>=0;j--){
            int temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;
            initHeap(nums,0,j-1);
        }
    }
        public static void main(String[] args) {
            int[] a = {5,2,3,1};
//        selectSort(a);
//        insertSort(a);
//        quickSort(a,0,a.length-1);
//        merge(a,0,a.length-1);
            heapSort(a);
            for(int i=0;i<a.length;i++){
                System.out.println(a[i]);
            }
        }
    }


