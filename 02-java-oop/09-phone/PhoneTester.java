public class PhoneTester{ 
    public static void main(String[] args) {
        IPhone iphoneTen = new IPhone("ten", 50, "AT&T", "Zing!");
        iphoneTen.displayInfo();
        System.out.println(iphoneTen.unlock());;
        System.out.println(iphoneTen.ring());

        Galaxy s7 = new Galaxy("s7", 70, "Verizon", "Ring!Ring!Ring!");
        s7.displayInfo();
        System.out.println(s7.ring());
        System.out.println(s7.unlock());
    }
}