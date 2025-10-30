package entities;

public class Guest {
    private String fullName;
    private String email;

    public Guest() {
    }

    public Guest(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}
