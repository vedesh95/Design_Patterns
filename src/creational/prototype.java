package creational;

class Gift implements Cloneable {
    private Object commonitem;
    private Object wrapper;

    public Gift(Object item, Object wrapper) {
        this.commonitem = item;
        this.wrapper = wrapper;
    }

    @Override
    public Gift clone() {
        try {
            Gift clone = (Gift) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // deep cloning - let item be same but change wrapper
    public Gift deepClone() {
        return new Gift(this.commonitem, new Object());
    }

    public Object getCommonitem() { return commonitem; }
    public Object getWrapper() { return wrapper; }
}


public class prototype {
    public static void main(String[] args) {
        Gift gift = new Gift(new Object(), new Object());
        Gift clone = gift.clone();
        Gift deepClone = gift.deepClone();
        // common item is same
        System.out.println(gift.getCommonitem() == clone.getCommonitem());
        System.out.println(gift.getCommonitem() == deepClone.getCommonitem());
        // wrapper is different
        System.out.println(gift.getWrapper() == clone.getWrapper());
        System.out.println(gift.getWrapper() == deepClone.getWrapper());
    }
}
