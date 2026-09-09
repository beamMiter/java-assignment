public class MyInfo {
    public static void main(String[] args) {
        // สร้าง object จาก concrete class ทั้งสองตัว
        CDPlayer cd = new CDPlayer("Sony");
        Smartphone phone = new Smartphone("Samsung");

        // เรียก method ของ CDPlayer: connect() มาจาก abstract method, info() มาจากคลาสแม่, play() มาจาก interface
        cd.connect();
        cd.info();
        cd.play();

        phone.connect();
        phone.info();
        phone.play();
    }
}

// interface = สัญญา (contract): คลาสที่ implements ต้องเขียน method เหล่านี้ให้ครบ
interface Playable {
    void play();   // ใน interface method เป็น abstract โดยปริยาย ไม่มี body
}

// abstract class = คลาสที่สร้าง object ตรงๆ ไม่ได้ ใช้เป็นแม่แบบร่วมให้ subclass สืบทอด
abstract class MusicDevice {
    protected String brand;   // field ร่วม เข้าถึงได้จาก subclass

    // constructor: รับ brand ตอนสร้าง object มาเก็บลง field
    public MusicDevice(String brand) {
        this.brand = brand;
    }

    // concrete method (มี body): subclass ได้ไปใช้ต่อโดยไม่ต้องเขียนเอง
    public void info() {
        System.out.println("เครื่องเล่นเพลงยี่ห้อ " + brand);
    }

    // abstract method (ไม่มี body): บังคับให้ทุก subclass ต้อง override เขียนรายละเอียดเอง
    public abstract void connect();
}

// CDPlayer สืบทอด (extends) MusicDevice และทำตามสัญญา (implements) Playable
class CDPlayer extends MusicDevice implements Playable {

    public CDPlayer(String brand) {
        super(brand);   // ส่ง brand ต่อให้ constructor ของ MusicDevice
    }

    @Override
    public void connect() {   // เขียนรายละเอียดให้ abstract method
        System.out.println("เชื่อมต่อแผ่น CD...");
    }

    @Override
    public void play() {      // เขียนรายละเอียดให้ method จาก interface Playable
        System.out.println("กำลังเล่นเพลงจาก CD");
    }
}

// Smartphone สืบทอดจากคลาสแม่ตัวเดียวกัน แต่ override พฤติกรรมเป็นแบบของตัวเอง (polymorphism)
class Smartphone extends MusicDevice implements Playable {

    public Smartphone(String brand) {
        super(brand);
    }

    @Override
    public void connect() {
        System.out.println("เชื่อมต่อผ่าน Bluetooth...");
    }

    @Override
    public void play() {
        System.out.println("กำลังเล่นเพลงจาก Spotify");
    }
}
