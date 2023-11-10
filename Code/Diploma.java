public class Diploma {
    private String name;
    private String description;
    private String duration;

    public Diploma(String name, String description, String duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void getInformation() {
    System.out.println("Diploma Name: " + name);
    System.out.println("Description: " + description);
    System.out.println("Duration: " + duration);
    }
}
