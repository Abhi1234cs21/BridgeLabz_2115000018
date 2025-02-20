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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return Objects.equals(policyNumber, other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolderName +
               ", Expiry: " + expiryDate + ", Type: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    private List<InsurancePolicy> policyList;

    public InsurancePolicyManagement() {
        policyList = new ArrayList<>();
    }

    public void addPolicy(InsurancePolicy policy) {
        policyList.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Policies:");
        for (InsurancePolicy policy : policyList) {
            System.out.println(policy);
        }
    }

    public void displayPoliciesExpiringSoon() {
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = cal.getTime();

        System.out.println("Policies Expiring Within 30 Days:");
        for (InsurancePolicy policy : policyList) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    public void displayPoliciesByCoverageType(String type) {
        System.out.println("Policies with Coverage Type: " + type);
        for (InsurancePolicy policy : policyList) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Map<String, List<InsurancePolicy>> policyMap = new HashMap<>();
        
        for (InsurancePolicy policy : policyList) {
            policyMap.putIfAbsent(policy.getPolicyNumber(), new ArrayList<>());
            policyMap.get(policy.getPolicyNumber()).add(policy);
        }

        System.out.println("Duplicate Policies:");
        for (Map.Entry<String, List<InsurancePolicy>> entry : policyMap.entrySet()) {
            if (entry.getValue().size() > 1) {  // More than one policy with same number
                for (InsurancePolicy policy : entry.getValue()) {
                    System.out.println(policy);
                }
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        
        Calendar cal = Calendar.getInstance();
        
        cal.set(2025, Calendar.MARCH, 10);
        InsurancePolicy policy1 = new InsurancePolicy("P1001", "Abhishek", cal.getTime(), "Health", 5000);
        
        cal.set(2025, Calendar.APRIL, 5);
        InsurancePolicy policy2 = new InsurancePolicy("P1002", "Arun", cal.getTime(), "Auto", 3000);
        
        cal.set(2025, Calendar.FEBRUARY, 20);
        InsurancePolicy policy3 = new InsurancePolicy("P1003", "Aditya", cal.getTime(), "Home", 7000);
        
        cal.set(2025, Calendar.FEBRUARY, 28);
        InsurancePolicy policy4 = new InsurancePolicy("P1004", "Harsh", cal.getTime(), "Health", 4500);
        
        cal.set(2025, Calendar.MARCH, 10);
        InsurancePolicy policy5 = new InsurancePolicy("P1001", "Piyush", cal.getTime(), "Health", 5000); // Duplicate

        system.addPolicy(policy1);
        system.addPolicy(policy2);
        system.addPolicy(policy3);
        system.addPolicy(policy4);
        system.addPolicy(policy5);

        system.displayAllPolicies();
        System.out.println();
        system.displayPoliciesExpiringSoon();
        System.out.println();
        system.displayPoliciesByCoverageType("Health");
        System.out.println();
        system.findDuplicatePolicies();
    }
}