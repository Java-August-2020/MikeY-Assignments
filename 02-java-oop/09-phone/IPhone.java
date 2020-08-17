public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return String.format("Iphone %s says %s", this.getVersionNumber(), this.getRingTone());
    }
    @Override
    public String unlock() {
        return "Unlocking via facial recognition";
    }
    @Override
    public void displayInfo() {
        System.out.println(String.format("Iphone %s from %s Battery %s", this.getVersionNumber(), this.getCarrier(), this.getBatteryPercentage()));       
    }
}