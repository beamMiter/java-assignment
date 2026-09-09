public class MyInfo {
    public static void main(String[] args) {
        // สร้าง object ของ Car โดยส่ง brand เข้า constructor
        Car car = new Car("Toyota");

        car.start();   // เรียก method ที่สืบทอดมาจาก Vehicle (inherited method)
        car.drive();   // เรียก method ที่เพิ่มเข้ามาเองในคลาส Car
    }
}

// superclass (parent): คลาสแม่ที่เก็บ property และ behavior ร่วมของยานพาหนะทุกชนิด
class Vehicle {
    // protected = subclass เข้าถึง field นี้ได้โดยตรง แต่โค้ดนอก hierarchy เข้าไม่ได้
    protected String brand;

    // constructor: รับค่า brand ตอนสร้าง object มาเก็บลง field
    public Vehicle(String brand) {
        this.brand = brand;
    }

    // behavior ร่วม: ทุกคลาสที่สืบทอดจาก Vehicle จะได้ method นี้ไปใช้ด้วย
    public void start() {
        System.out.println(brand + " กำลังสตาร์ท...");
    }
}

// subclass (child): Car สืบทอดทุกอย่างจาก Vehicle ด้วยคีย์เวิร์ด extends
class Car extends Vehicle {

    // constructor ของ Car เรียก super(...) เพื่อส่ง brand ต่อให้ constructor ของ Vehicle
    public Car(String brand) {
        super(brand);
    }

    // method เพิ่มเติมเฉพาะของ Car (Vehicle ไม่มี drive())
    public void drive() {
        System.out.println(brand + " กำลังขับเคลื่อนบนถนน");
    }
}
