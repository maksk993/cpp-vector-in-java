import myPackages.myCollections.vector;
import java.util.Arrays;

class Program {
    public static void main(String[] args) {
        vector<Integer> a = new vector<>(Arrays.asList(0,1,2,3,4,5));
        
        System.out.println("a: " + a);

        a.insert(6, Arrays.asList(1,2,3,4,5,6));

        a.resize(10);
        
        System.out.println("a: " + a);
        System.out.println("a.size(): " + a.size());
        System.out.println("a.capacity(): " + a.capacity());

        vector<Integer> b = new vector<>(a);

        b.push_back(5);
        b.push_back(6);
        b.push_back(7);
        
        b.erase(0, 10);

        System.out.println("b: " + b);
        System.out.println("b.size(): " + b.size());
        System.out.println("b.capacity(): " + b.capacity());
    }
}