public class User {
    private String username;
    private String hashedPassword;
    private boolean isClubMember;
    private boolean isAdmin;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    
    public boolean getIsClubMember() {
        return isClubMember;
    }
    public void setClubMember(boolean isClubMember) {
        this.isClubMember = isClubMember;
    }
    public boolean getIsAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public User(String username, String hashedPassword, boolean isClubMember, boolean isAdmin) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.isClubMember = isClubMember;
        this.isAdmin = isAdmin;
    }
    public User() {
    }
    @Override
    public String toString() {
        return username;
    }
}
