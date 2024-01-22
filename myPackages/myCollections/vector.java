package myPackages.myCollections;
import java.util.List;

public class vector<T> {
    // private fields
    private int cp;
    private int sz;
    private Object[] data;

    // constructors
    public vector () {
        cp = 1;
        sz = 0;
        data = new Object[cp];
    }

    public vector (int size) throws NegativeArraySizeException {
        if (size <= 0) throw new NegativeArraySizeException("Size must be greater than 0.");
        cp = sz = size;
        data = new Object[cp];
    }

    public vector (int size, T value) throws NegativeArraySizeException {
        if (size <= 0) throw new NegativeArraySizeException("Size must be greater than 0.");
        cp = sz = size;
        data = new Object[cp];
        for (int i = 0; i < data.length; i++) {
            data[i] = value;
        }
    }

    public vector (List<T> list) { // initialization with Arrays.asList(...)
        cp = sz = list.size();
        data = new Object[cp];
        for (int i = 0; i < sz; i++) {
            data[i] = list.get(i);
        }
    }

    public vector (vector<T> other) { // copy constructor
        cp = other.cp;
        sz = other.sz;
        data = new Object[cp];
        for (int i = 0; i < sz; i++) {
            data[i] = other.data[i];
        }
    }

    // public methods
    public T at(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= sz) throw new IndexOutOfBoundsException("out of range.");
        return (T) data[index];
    }

    public int size(){
        return sz;
    }

    public int capacity(){
        return cp;
    }

    public void push_back(T value){
        if (sz == cp){
            cp <<= 1;
            Object[] new_data = new Object[cp];
            for (int i = 0; i < data.length; i++) {
                new_data[i] = data[i];
            }
            data = new_data;
        }
        data[++sz - 1] = value;
    }

    public void pop_back() throws IndexOutOfBoundsException {
        if (sz == 0) throw new IndexOutOfBoundsException("vector empty before pop.");
        --sz;
    }

    public void insert(int pos, T value) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > sz) throw new IndexOutOfBoundsException("out of range.");
        push_back(null);
        for (int i = sz - 2; i >= pos; i--){
            data[i + 1] = data[i];
        }
        data[pos] = value;
    }

    public void insert(int pos, List<T> list) throws IndexOutOfBoundsException {
        for (int i = 0; i < list.size(); i++){
            insert(pos++, list.get(i));
        }
    }

    public void insert(int pos, vector<T> vec) throws IndexOutOfBoundsException, StackOverflowError {
        if (vec == this) throw new StackOverflowError("vectors must be different.");
        for (int i = 0; i < vec.size(); i++){
            insert(pos++, vec.at(i));
        }
    }

    public void clear(){
        sz = 0;
    }

    public void erase(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= sz) throw new IndexOutOfBoundsException("out of range.");
        for (int i = pos; i < sz - 1; i++){
            data[i] = data[i + 1];
        }
        sz--;
    }

    public void erase(int first, int second) throws IndexOutOfBoundsException {
        int diff = second - first;
        if (diff < 0) throw new IndexOutOfBoundsException("first position must be greater than second position.");
        for (int i = 0; i < diff; i++){
            erase(first);
        }
    }

    public void resize(int size) throws NegativeArraySizeException {
        if (size < 0) throw new NegativeArraySizeException("new size must be >= 0");
        sz = size;
        if (sz > cp){
            cp = sz;
            Object[] new_data = new Object[cp];
            for (int i = 0; i < data.length; i++) {
                new_data[i] = data[i];
            }
            data = new_data;
        }
    }

    public void reserse(int capacity) throws NegativeArraySizeException {
        if (capacity < 0) throw new NegativeArraySizeException("new capacity must be >= 0");
        if (capacity > cp){
            cp = capacity;
            Object[] new_data = new Object[cp];
            for (int i = 0; i < data.length; i++) {
                new_data[i] = data[i];
            }
            data = new_data;
        }
    }

    public boolean empty(){
        return sz == 0;
    }

    public String toString(){
        StringBuilder s = new StringBuilder("[ ");
        for (int i = 0; i < sz; i++){
            s.append(data[i] + " ");
        }
        s.append("]");
        return s.toString();
    }

    public boolean equals(vector<T> other){
        if (sz != other.sz) return false;
        for (int i = 0; i < sz; i++) {
            if (data[i] != other.data[i]) return false;
        }
        return true;
    }

    public vector<T> clone(){
        vector<T> new_vector = new vector<>(this);
        return new_vector;
    }
}