package behavioral;

class KV<T> {
    private T key;
    private T value;
    public KV(T key, T value) {
        this.key = key;
        this.value = value;
    }
    public T getKey() { return key; }
    public T getValue() { return value; }
}

interface Iterator<KV> {
    boolean hasNext();
    KV next();
}
interface Container<KV> {
    Iterator<KV> getIterator();
}
class KVIterator<KV> implements Iterator<KV> {
    private KV[] kvs;
    private int position = 0;
    public KVIterator(KV[] kvs) { this.kvs = kvs; }
    @Override
    public boolean hasNext() { return position < kvs.length; }
    @Override
    public KV next() { return hasNext() ? kvs[position++] : null; }
}

class KVContainer<KV> implements Container<KV> {
    private KV[] kvs;
    public KVContainer(KV[] kvs) { this.kvs = kvs; }
    @Override
    public Iterator<KV> getIterator() { return new KVIterator<>(kvs); }
}

public class IteratorPattern {
    public static void main(String[] args){
        KV<String> kv1 = new KV<>("key1", "value1");
        KV<String> kv2 = new KV<>("key2", "value2");

        KV<String>[] kvs = new KV[]{kv1, kv2};
        Container<KV<String>> container = new KVContainer<>(kvs);
        Iterator<KV<String>> iterator = container.getIterator();
        while(iterator.hasNext()){
            KV<String> kv = iterator.next();
            System.out.println("Key: " + kv.getKey() + ", Value: " + kv.getValue());
        }
    }

}
