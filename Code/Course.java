    public class Course {
        private String name;
        private String description;
        private String duration;

        public Course() {
            // Constructor vacío
        }

        public Course(String name, String description, String duration) {
            this.name = name;
            this.description = description;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void getInformation() {
            System.out.println("Course Name: " + name);
            System.out.println("Description: " + description);
            System.out.println("Duration: " + duration);
        }
    }
