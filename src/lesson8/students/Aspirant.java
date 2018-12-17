package lesson8.students;

public class Aspirant extends Student {
    private String scienceWork;

    public Aspirant(String firstName, String lastName, String group, double avgMark, String scienceWork) {
        super(firstName, lastName, group, avgMark);
        this.scienceWork = scienceWork;
    }

    public Aspirant(String scienceWork) {
        this.scienceWork = scienceWork;
    }

    public Aspirant() {
    }

    public String getScienceWork() {
        return scienceWork;
    }

    public void setScienceWork(String scienceWork) {
        this.scienceWork = scienceWork;
    }

    @Override
    public int getScholarship() {
        return getAvgMark() == 5 ? 200 : 180;
    }
}
