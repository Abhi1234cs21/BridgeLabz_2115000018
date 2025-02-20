import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyHolderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyHolderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolderName +
               ", Expiry: " + expiryDate + ", Type: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagement2 {
    private Map<String, InsurancePolicy> hashMapPolicies;
    private Map<String, InsurancePolicy> linkedHashMapPolicies;
    private TreeMap<Date, InsurancePolicy> treeMapPolicies;

    public InsurancePolicyManagement2() {
        hashMapPolicies = new HashMap<>();
        linkedHashMapPolicies = new LinkedHashMap<>();
        treeMapPolicies = new TreeMap<>();
    }

    public void addPolicy(InsurancePolicy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }

    public void listPoliciesExpiringSoon() {
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = cal.getTime();

        System.out.println("Policies Expiring Within 30 Days:");
        for (Map.Entry<Date, InsurancePolicy> entry : treeMapPolicies.entrySet()) {
            if (entry.getKey().before(thresholdDate)) {
                System.out.println(entry.getValue());
            }
        }
    }

    public void listPoliciesByHolder(String policyHolderName) {
        System.out.println("Policies for " + policyHolderName + ":");
        for (InsurancePolicy policy : hashMapPolicies.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                System.out.println(policy);
            }
        }
    }

    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        Iterator<Map.Entry<Date, InsurancePolicy>> iterator = treeMapPolicies.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Date, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().before(currentDate)) {
                hashMapPolicies.remove(entry.getValue().getPolicyNumber());
                linkedHashMapPolicies.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            }
        }
        System.out.println("Expired policies removed.");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement2 system = new InsurancePolicyManagement2();
        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.MARCH, 10);
        InsurancePolicy policy1 = new InsurancePolicy("P1001", "Abhishek", cal.getTime(), "Health", 5000);

        cal.set(2025, Calendar.APRIL, 5);
        InsurancePolicy policy2 = new InsurancePolicy("P1002", "Arun", cal.getTime(), "Auto", 3000);

        cal.set(2025, Calendar.FEBRUARY, 20);
        InsurancePolicy policy3 = new InsurancePolicy("P1003", "Aditya", cal.getTime(), "Home", 7000);

        cal.set(2025, Calendar.FEBRUARY, 28);
        InsurancePolicy policy4 = new InsurancePolicy("P1004", "Harsh", cal.getTime(), "Health", 4500);

        system.addPolicy(policy1);
        system.addPolicy(policy2);
        system.addPolicy(policy3);
        system.addPolicy(policy4);

        System.out.println("Retrieve Policy P1001: " + system.getPolicyByNumber("P1001"));
        System.out.println();
        system.listPoliciesExpiringSoon();
        System.out.println();
        system.listPoliciesByHolder("Abhishek");
        System.out.println();
        system.removeExpiredPolicies();
    }
}