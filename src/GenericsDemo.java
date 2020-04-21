
import java.util.*;

//定义小轿车类
class Car {
    String carCode; //车辆代号
    String brand; //品牌
    String mode;  //款式
    String color; //颜色
    int price;
    //写构造方法
    Car (){

    }
    Car(String carCode,String brand,String mode,String color,int price){
        this.carCode=carCode;
        this.brand=brand;
        this.mode=mode;
        this.color=color;
        this.price=price;
    }
    public void printCarInfo(){ //打印方法
        System.out.println(carCode+"\t"+brand+"\t"+mode+"\t"+color+"\t"+price);//……
    }

}

class CarDealer{ //车行
    String dealerName; //车行名称
    ArrayList<Car> cars;
    //构造方法
    CarDealer(){

    }
    CarDealer(String dealerName){
        this.dealerName=dealerName;
    }
}
class Customer{ //顾客
    String name;
    HashMap<String,Car> cars; //String是购买日期，Car是该顾客购买的车
    //构造方法
    Customer(){

    }
    Customer(String name, HashMap<String, Car> map) {
        this.name=name;
    }
    public void printInfo() {

    }
}
class AvgComp implements Comparator<Car>{

    @Override
    public int compare(Car c1, Car c2) {
        return c2.price-c1.price;
    }
}

public class GenericsDemo {

    public static void main(String[] args) {
        //1-实例化三个Car对象
        Car c1=new Car("CS4634","丰田","皇冠","灰色",210000);
        Car c2=new Car("CS1678","丰田","佳美","白色",200000);
        Car c3=new Car("CS7789","丰田","科罗拉","蓝色",180000);
        Car c4=new Car("CS9234","本田","雅阁","黑色",220000);
        Car c5=new Car("CS2344","本田","飞度","红色",170000);
        Car c6=new Car("CS6577","本田","思域","银色",150000);
        Car c7=new Car("CS7689","别克","君威","银色",250000);
        Car c8=new Car("CS4356","别克","凯越","黑色",240000);
        Car c9=new Car("CS8122","别克","阅朗","红色",230000);
        //2-实例化一个ArrayList泛型集合对象
        ArrayList<Car> list1 = new ArrayList<Car>();
        ArrayList<Car> list2 = new ArrayList<Car>();
        ArrayList<Car> list3 = new ArrayList<Car>();
        //3-把以上三部车加入到这个ArrayList泛型集合里
        list1.add(c1);
        list1.add(c2);
        list1.add(c3);
        list2.add(c4);
        list2.add(c5);
        list2.add(c6);
        list3.add(c7);
        list3.add(c8);
        list3.add(c9);
        //4-实例化一个CarDealer对象
        CarDealer C1=new CarDealer("丰田");
        C1.cars=list1;
        CarDealer C2=new CarDealer("本田");
        C2.cars=list2;
        CarDealer C3=new CarDealer("别克");
        C3.cars=list3;
        //5-输出该CarDealer车行所热销的车
        AvgComp ac=new AvgComp();
        Collections.sort(list1,ac); //排序。自动调用AvgComp类中重写的compare方法
        Collections.sort(list2,ac);
        Collections.sort(list3,ac);
        System.out.println("车号"+"\t"+"品牌"+"\t"+"类型"+"\t"+"颜色"+"\t"+"价格");
        System.out.println("====================================================");
        for(Car c:list1){//无需类型转换
            c.printCarInfo();
        }
        System.out.println("****************************************************");
        System.out.println("车号"+"\t"+"品牌"+"\t"+"类型"+"\t"+"颜色"+"\t"+"价格");
        System.out.println("====================================================");
        for(Car c:list2){//无需类型转换
            c.printCarInfo();
        }
        System.out.println("****************************************************");
        System.out.println("车号"+"\t"+"品牌"+"\t"+"类型"+"\t"+"颜色"+"\t"+"价格");
        System.out.println("====================================================");
        for(Car c:list3){//无需类型转换
            c.printCarInfo();
        }
        System.out.println("****************************************************");
        //6-步骤1-5一共重复三次，分别输出三个车行所热销的车
        //7-实例化一个HashMap<String,Car>集合对象
        HashMap<String,Car> map1=new HashMap<String,Car>();
        HashMap<String,Car> map2=new HashMap<String,Car>();
        //8-从上面的车行里挑两部车放进该集合里
        map1.put("购买时间：2018.11.30",c1);
        map1.put("购买时间：2019.11.30",c4);
        map2.put("购买时间：2018.11.30",c3);
        map2.put("购买时间：2019.11.30",c9);
        //9-输出该顾客购买日期和车
        Customer cr1=new Customer("李伟文",map1);
        Customer cr2=new Customer("吴浩强",map2);
        System.out.println("第一个顾客："+cr1.name+"所买车：");
        System.out.println("车号"+"\t"+"品牌"+"\t"+"类型"+"\t"+"颜色"+"\t"+"价格");
        System.out.println("====================================================");
        Set<Map.Entry<String,Car>> set1= map1.entrySet();
        Iterator<Map.Entry<String,Car>> it1 = set1.iterator();
        while (it1.hasNext()){
            Map.Entry<String,Car> en1 = it1.next();
            String key = en1.getKey();
            Car car1 = en1.getValue();
            car1.printCarInfo();
            String time=en1.getKey();
            System.out.println(time);
        }
        System.out.println("****************************************************");
        System.out.println("第二个顾客："+cr2.name+"所买车：");
        System.out.println("车号"+"\t"+"品牌"+"\t"+"类型"+"\t"+"颜色"+"\t"+"价格");
        System.out.println("====================================================");
        Set<Map.Entry<String,Car>> set2= map2.entrySet();
        Iterator<Map.Entry<String,Car>> it2 = set2.iterator();
        while (it2.hasNext()){
            Map.Entry<String,Car> en2 = it2.next();
            String key = en2.getKey();
            Car car2 = en2.getValue();
            car2.printCarInfo();
            String time=en2.getKey();
            System.out.println(time);
        }
        //10-步骤7-9一共重复两次，分别输出两个顾客所购买的车的信息
        System.out.println("github修改成功");
    }

}

