package nl.graduateproject.localSkill.model.customer;

public enum CustomerGuild {
    // the fields of the enum
    NONE("NONE"),
    FINANCE("FINANCE"),
    CONSTRUCTION("CONSTRUCTION"),
    CREATIVE_DESIGN("CREATIVE_DESIGN"),
    LEISURE("LEISURE"),
    MEDIA("MEDIA"),
    SECURITY("SECURITY"),
    HEALTHCARE("HEALTHCARE"),
    IT("IT"),
    BEAUTY("BEAUTY"),
    SPORT("SPORT"),
    FOOD("FOOD"),
    HOBBY("HOBBY"),
    SALES("SALES"),
    EDUCATION("EDUCATION"),
    LOGISTICS("LOGISTICS"),
    LEGAL("LEGAL"),
    HUMAN_RESOURCES("HUMAN_RESOURCES");

    // store fields of the enum in "name"
    private final String name;

    // constructor needs as one of the two fields
    CustomerGuild(String name){
        this.name = name;
    }
}
