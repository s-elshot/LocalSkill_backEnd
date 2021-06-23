package nl.graduateproject.localSkill.exceptions;

public class UsernameNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameNotFoundException(Long id) {
        super("Cannot find user " + id);
    }

}
