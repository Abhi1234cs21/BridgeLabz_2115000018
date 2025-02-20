class CircularBuffer {
    private int[] buffer;
    private int size;
    private int front;
    private int rear;
    private int currentSize;

    public CircularBuffer(int capacity) {
        size = capacity;
        buffer = new int[size];
        front = 0;
        rear = 0;
        currentSize = 0;
    }

    // Insert an element into the buffer
    public void insert(int value) {
        if (currentSize == size) {
            // If buffer is full, overwrite the oldest element
            front = (front + 1) % size;  // Move front forward
        } else {
            currentSize++;
        }

        // Insert the new value at the rear
        buffer[rear] = value;

        // Move rear to the next position, wrapping around if needed
        rear = (rear + 1) % size;
    }

    // Display the elements of the buffer
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < currentSize; i++) {
            int index = (front + i) % size;
            System.out.print(buffer[index]);
            if (i < currentSize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3); // Buffer size is 3

        // Insert elements into the buffer
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display();  // Output: Buffer: [1, 2, 3]

        // Insert more elements and show the overwriting
        buffer.insert(4);
        buffer.display();  // Output: Buffer: [2, 3, 4]
    }
}
