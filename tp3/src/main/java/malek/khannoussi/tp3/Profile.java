package malek.khannoussi.tp3;

public class Profile {
    public String firstName, lastName, pseudo;

    public Profile(String firstName, String lastName, String pseudo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return pseudo;
    }

}
