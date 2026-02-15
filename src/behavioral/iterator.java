package behavioral;

class KV<T> {
    private T key, value;
    public KV(T key, T value) { this.key = key; this.value = value; }
    public T getKey() { return key; }
    public T getValue() { return value; }
}

interface Iterate<KV> {
    boolean hasNext();
    KV next();
}

interface Container<KV> {
    Iterate<KV> getIterator();
}

class KVIterator<KV> implements Iterate<KV> {
    private KV[] kvs;
    private int index = 0;
    public KVIterator(KV[] kvs) { this.kvs = kvs; }
    @Override
    public boolean hasNext() { return index < kvs.length; }
    @Override
    public KV next() { return kvs[index++]; }
}

class KVContainer<KV> implements Container<KV> {
    private KV[] kvs;
    public KVContainer(KV[] kvs) { this.kvs = kvs; }
    @Override
    public Iterate<KV> getIterator() {
        return new KVIterator<>(kvs);
    }
}
public class iterator {
    public static void main(String[] args) {
        KV<String> kv1 = new KV<>("a", "1");
        KV<String> kv2 = new KV<>("b", "2");
        KV<String>[] kvs = new KV[]{kv1, kv2};
        Container<KV<String>> container = new KVContainer<>(kvs);
        Iterate<KV<String>> iterator = container.getIterator();
        while(iterator.hasNext()) {
            KV<String> kv = iterator.next();
            System.out.println(kv.getKey() + " : " + kv.getValue());
        }
    }
}
