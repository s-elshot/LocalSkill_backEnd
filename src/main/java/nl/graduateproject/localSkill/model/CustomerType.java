package nl.graduateproject.localSkill.model;


public enum CustomerType {
    // the fields of the enum
    CUSTOMER("CUSTOMER"),
    GUILDER("GUILDER"),
    ADMIN("ADMIN");

    // store fields of the enum in "name"
    private final String name;

    // constructor needs as one of the two fields
    CustomerType(String name){
      this.name = name;
    }

}
