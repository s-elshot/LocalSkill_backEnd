package nl.graduateproject.localSkill.model.customer;


public enum CustomerType {
    CUSTOMER("CUSTOMER"),
    GUILDER("GUILDER"),
    ADMIN("ADMIN");

    private final String name;

    CustomerType(String name){
      this.name = name;
    }

}
