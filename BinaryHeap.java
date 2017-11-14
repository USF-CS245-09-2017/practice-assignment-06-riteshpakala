import java.util.Arrays;

public class BinaryHeap {
    int[] heap;
    static int size = 0;
    
    public BinaryHeap() {
        heap = new int[10];  
        size = 0;
    }

    public void add(int item) {
        if (size >= heap.length - 1) {
                heap = resize();
        }        
        
        if(size == 0){
            heap[size+1] = item;
            size = 2;
        }else{
            heap[size++] = item;
            bubbleUp();
        }
    }
    
    public int remove() {
        if (size == 0) {
            throw new IllegalStateException();//Ends once empty heap is detected
        }
        
        int min = heap[1];
        heap[1] = heap[size-1];
        heap[size-1] = 0;
        size--;
        
        bubbleDown(1);
        
        return min;
    }
    
    public void bubbleUp(){
        int index = size-1;
        while(index > 0 && heap[index/2] > heap[index]){
            int y = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = y;
            index = index/2;
        }
    }
    
    
    public void bubbleDown(int index){
        int min = index;
        if (2*index < size && heap[min] > heap[2*index]) {
            min = 2*index;
        }
        if(2*index+1 < size && heap[min] > heap[2*index+1]){
            min = 2*index + 1;
        }
        if(min != index){
            swap(index, min);
            bubbleDown(min);
        }
            
    }
    
    //swaps elements if criteria of bubbleUp or bubbleDown is met
    private void swap(int index, int index2) {
        int tmp = heap[index];
        heap[index] = heap[index2];
        heap[index2] = tmp; 
    }
    
    //Doubles the size of an array if limit is reached
    protected int[] resize() {
        return Arrays.copyOf(heap, heap.length * 2);
    }
}
