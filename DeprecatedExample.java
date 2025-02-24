class LegacyAPI {
    
    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature. Do not use it!");
    }
    
    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        api.oldFeature(); // This will show a warning but still execute
        api.newFeature(); // Recommended method
    }
}
