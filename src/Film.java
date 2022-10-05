public class Film {
    private String name;
    private String trailer_path;
    private String duration;
    
    public Film(String name, String trailer_path, String duration) {
        this.name = name;
        this.trailer_path = trailer_path;
        this.duration = duration;
    }

    public Film() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrailer_path() {
        return trailer_path;
    }

    public void setTrailer_path(String trailer_path) {
        this.trailer_path = trailer_path;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name + " (" + duration + " minutes)";
    }
    
}
