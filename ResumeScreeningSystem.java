import java.util.List;
import java.util.ArrayList;

abstract class JobRole {
    private String roleName;
    private String requiredSkills;

    public JobRole(String roleName, String requiredSkills) {
        this.roleName = roleName;
        this.requiredSkills = requiredSkills;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public abstract String getJobDescription();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String requiredSkills) {
        super("Software Engineer", requiredSkills);
    }

    @Override
    public String getJobDescription() {
        return "Responsible for writing, testing, and maintaining software code.";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String requiredSkills) {
        super("Data Scientist", requiredSkills);
    }

    @Override
    public String getJobDescription() {
        return "Responsible for analyzing data and creating predictive models.";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String requiredSkills) {
        super("Product Manager", requiredSkills);
    }

    @Override
    public String getJobDescription() {
        return "Responsible for overseeing product development and strategy.";
    }
}

class Resume<T extends JobRole> {
    private T jobRole;
    private String candidateName;
    private String resumeContent;

    public Resume(T jobRole, String candidateName, String resumeContent) {
        this.jobRole = jobRole;
        this.candidateName = candidateName;
        this.resumeContent = resumeContent;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getResumeContent() {
        return resumeContent;
    }

    public void displayResume() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Applying for: " + jobRole.getRoleName());
        System.out.println("Job Description: " + jobRole.getJobDescription());
        System.out.println("Resume Content: " + resumeContent);
        System.out.println("Required Skills: " + jobRole.getRequiredSkills());
        System.out.println("-------------------------");
    }

    public static void screenResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Screening resumes for role: " + role.getRoleName());
            System.out.println("Job Description: " + role.getJobDescription());
            System.out.println("Required Skills: " + role.getRequiredSkills());
            System.out.println("-------------------------");
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        SoftwareEngineer seRole = new SoftwareEngineer("Java, C++, Problem Solving");
        DataScientist dsRole = new DataScientist("Python, Machine Learning, Data Analysis");
        ProductManager pmRole = new ProductManager("Product Strategy, Agile, Cross-functional Team Management");

        Resume<SoftwareEngineer> seResume = new Resume<>(seRole, "Alice", "Experienced in Java and C++.");
        Resume<DataScientist> dsResume = new Resume<>(dsRole, "Bob", "Worked on data models using Python.");
        Resume<ProductManager> pmResume = new Resume<>(pmRole, "Charlie", "Led agile teams in product development.");

        seResume.displayResume();
        dsResume.displayResume();
        pmResume.displayResume();

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(seRole);
        jobRoles.add(dsRole);
        jobRoles.add(pmRole);

        System.out.println("\nScreening Resumes for Different Job Roles:");
        Resume.screenResumes(jobRoles);
    }
}
