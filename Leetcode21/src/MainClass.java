interface MyInterface{
    void add(int a,int b);
}

public class MainClass {

    public static void main(String[] args) {


        class Computer implements MyInterface{

            @Override
            public void add(int a, int b){
                System.out.println(a + b);
            }
        }
        MyInterface computer1 = new Computer();

        //创建了一个实现类MyInterface接口的匿名实现类的对象
        MyInterface computer = new MyInterface(){
            @Override
            public void add(int a, int b){
                System.out.println("匿名实现类的对象");
            }
        };

        //可以使用alt + /
        new MyInterface() { //创建的是该接口的实现类的对象
            @Override
            public void add(int a, int b) {
                // TODO Auto-generated method stub
                System.out.println(a + b);
            }
        };
        test(computer);
    }

    //如果形参是一个接口的类型，那么实参只能是接口实现类的对象
    public static void test(MyInterface mi){
        mi.add(5, 10);
    }
}
