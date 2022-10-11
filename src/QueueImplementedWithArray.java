public class QueueImplementedWithArray<T> {
    private Object[] _array;
    private int _head;
    private int _tail;
    private int _size;

    public QueueImplementedWithArray(int size){
        _array = new Object[size];
        _head = 0;
        _tail = -1;
        _size = size;
    }

    public void enqueue(T value){
        if(_tail == _size-1) {
            if (_head > 0) {
                _tail = 0;
            } else {
                resize();
                _tail++;
            }
        } else if(_tail < _head && _tail != -1){
            _tail++;
            if(_tail == _head) {
                resize();
                _tail++;
            }
        } else {
            _tail++;
        }
        _array[_tail] = value;
    }

    public T dequeue(){
        if(_array[_head] == null){
            System.out.println("No element to dequeue");
            return null;
        }
        T returnValue = (T) _array[_head];
        _array[_head] = null;
        _head++;
        if(_head == _size){
            _head = 0;
        }
        if(_array[_tail] == null){
            _head = 0;
            _tail = -1;
        }
        return returnValue;
    }

    public T peek(){
        return (T) _array[_head];
    }

    public void printArrayImplementation(){ //For debugging/viewing how it works
        for(int i = 0; i < _size; i++){
            if(_array[i] == null){
                System.out.print("null ");
                continue;
            }
            System.out.print(_array[i] + " ");
        }
        System.out.println();
    }

    public void print(){ //To print the queue
        int index = _head;
        while(index < _size && _array[index] != null){
            System.out.print(_array[index] + " ");
            index++;
        }
        if(_tail < _head){
            index = 0;
            while(index < _head && _array[index] != null){
                System.out.print(_array[index] + " ");
                index++;
            }
        }
        System.out.println();
    }

    public void resize(){
        Object[] temp = new Object[_size*2];
        int i;
        if(_head == 0){
            for(i = 0; i < _size; i++){
                temp[i] = _array[i];
            }
        } else {
            for(i=0; i < (_size-_head); i++){
                temp[i] = _array[_head+i];
            }
            for(int j = 0; j <= _tail; j++){
                temp[i+j] = _array[j];
            }
        }
        _array = temp;
        temp = null;
        _head = 0;
        _tail = _size-1;
        _size *= 2;
        System.out.println("Queue resized to " + _size);
    }
}