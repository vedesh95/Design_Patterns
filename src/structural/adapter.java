package structural;

class Add{
    int add(int x, int y) { return x + y;}
}

interface Target{
    String add(String x, String y) ;
}
class AddAdapter implements Target{
    Add add;
    AddAdapter() {this.add = new Add();}
    @Override
    public String add(String x, String y) {
        return String.valueOf(add.add(Integer.parseInt(x), Integer.parseInt(y)));
    }
}

// adapt interface of a class to one that client expect
public class adapter {
    public static void main(String[] args) {
        AddAdapter adp = new AddAdapter();
        System.out.println(adp.add("1" ,"2" ));
    }
}
