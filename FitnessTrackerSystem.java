abstract class FitnessDevice {
    private String deviceId;
    private String deviceName;
    private double batteryLevel;

    public FitnessDevice(String deviceId, String deviceName, double batteryLevel) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.batteryLevel = batteryLevel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        if(batteryLevel >= 0) {
            this.batteryLevel = batteryLevel;
        }
    }

    public abstract double calculateCaloriesBurned(int steps);
}

class SmartWatch extends FitnessDevice {
    public SmartWatch(String deviceId, String deviceName, double batteryLevel) {
        super(deviceId, deviceName, batteryLevel);
    }

    @Override
    public double calculateCaloriesBurned(int steps) {
        return steps * 0.04;
    }
}

class FitnessBand extends FitnessDevice {
    public FitnessBand(String deviceId, String deviceName, double batteryLevel) {
        super(deviceId, deviceName, batteryLevel);
    }

    @Override
    public double calculateCaloriesBurned(int steps) {
        return steps * 0.03;
    }
}

interface Synchronizable {
    void syncData();
    void showSyncDetails();
}

public class FitnessTrackerSystem {
    public static void main(String[] args) {
        SmartWatch watch = new SmartWatch("SW001", "Galaxy Watch", 75);
        FitnessBand band = new FitnessBand("FB001", "Fitbit", 80);

        FitnessDevice[] devices = {watch, band};
        for (FitnessDevice device : devices) {
            System.out.println("Device ID: " + device.getDeviceId());
            System.out.println("Device Name: " + device.getDeviceName());
            System.out.println("Battery Level: " + device.getBatteryLevel() + "%");
            System.out.println("Calories Burned for 1000 steps: " + device.calculateCaloriesBurned(1000));
        }
    }
}
