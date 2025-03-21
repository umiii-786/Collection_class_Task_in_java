// BY 22-SW-01
public class Implementing_List {
    private int[] array = new int[20];
    private int current = -1;
    private int size = 0;

    // incrementing the shift
    public void next() {
        if (current == size - 1) {
            System.out.println("having no any element ");
            return;
        }
        current++;
    }
        // printing the list
        public void print() {
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(array[i] + ",");
            }
            System.out.print("]");
            System.out.println("\n");
        }
    
    // decrementing the current
    public void back() {
        if (current == -1) {
            System.out.println("not going to previous");
            return;
        }
        current--;
    }

    // adding the element at the current +1 position
    public void add(int value) {
        if (current == size - 1) {
            array[current + 1] = value;
            current++;
            size++;
        }
        else {
            for (int i = size - 1; i > current; i--) {
                array[i + 1] = array[i];
            }
            array[current + 1] = value;
            current++;
            size++;
        }}




    // changing the value on the current position
    public void update(int val) {
        array[current] = val;
    }

    // removing the element at the current position
    public void remove() {
        if (current == size - 1) {
            array[current] = 0;
        } else {
            for (int i = current; i < size; i++) {
                array[i] = array[i + 1];
            }
        }
        size--;
    }

    // pointing the current at the last element
    public void End() {
        current = size - 1;
    }

    // setting the current at -1 position
    public void start() {
        current = -1;
    }

    public static void main(String[] args) {

        Implementing_List l = new Implementing_List();
        l.add(24);
        l.add(67);
        l.add(89);
        l.start();
        l.add(5);
    }
}
