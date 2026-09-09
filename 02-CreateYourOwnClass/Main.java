public class Main {
    public static void main(String[] args) {
        // new Car() จองหน่วยความจำสร้าง object ใหม่ แล้วเก็บ reference ไว้ในตัวแปร car
        Car car = new Car();

        // เรียก setter เพื่อส่งค่าเข้าไปเซ็ตให้ field ที่เป็น private (แก้จากข้างนอกตรงๆ ไม่ได้)
        car.setBrand("Toyota");   // ส่ง "Toyota" ไปเก็บใน field brand ของ object car
        car.setSpeed(120);        // ส่ง 120 ไปเก็บใน field speed ของ object car

        // เรียก method ของ object ให้ทำงาน: อ่านค่า field ปัจจุบันแล้ว print ออกจอ
        car.displayInfo();

        // เรียก getter เพื่อดึงค่าจาก field ออกมาใช้ต่อ แล้วเชื่อมกับข้อความด้วย operator +
        System.out.println("getBrand() -> " + car.getBrand());
        System.out.println("getSpeed() -> " + car.getSpeed());
    }
}

// คลาส Car ทำหน้าที่เป็น blueprint: บอกว่า object แต่ละตัวเก็บข้อมูลอะไรและทำอะไรได้
class Car {
    // field แบบ private = encapsulation: เข้าถึงได้เฉพาะโค้ดในคลาส Car เท่านั้น
    private String brand;   // เก็บยี่ห้อรถ
    private int speed;       // เก็บความเร็ว (หน่วย km/h)

    // setter: รับค่าจากภายนอก (parameter) มาเขียนทับ field ของ object ตัวที่ถูกเรียก
    public void setBrand(String newBrand) {
        this.brand = newBrand;   // this.brand = field ของ object, newBrand = ค่าที่รับเข้ามา
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    // getter: คืนค่าที่เก็บอยู่ใน field กลับไปให้ฝั่งที่เรียก (return)
    public String getBrand() {
        return this.brand;
    }

    public int getSpeed() {
        return this.speed;
    }

    // behavior ของ object: ประกอบข้อความจากค่า field ปัจจุบันด้วย + แล้วแสดงผลทาง console
    public void displayInfo() {
        System.out.println("Car brand: " + brand + ", Speed: " + speed + " km/h");
    }
}
