class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
         if(low >= high)
            return;
            
        int pIdx = partition(arr, low, high);
        
        // for left
        quickSort(arr, low, pIdx-1);
        //for right
        quickSort(arr, pIdx+1, high);
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
          int pivot = arr[high];
        int i = low-1;
        for(int j = low; j < high; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    } 
}
