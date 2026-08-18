class MedianFinder {
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();

    // small for maxHeap 
    // large for minHeap

    public MedianFinder() {}
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());

        if(small.size() < large.size()){
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size() > large.size()){
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}