package nl.graduateproject.localSkill.model;

public enum ItemType {
   // the fields of the enum 
    PRODUCT("PRODUCT"),
    SERVICE("SERVICE");

    // store fields of the enum in "name"
    private final String name;

    // constructor needs as one of the two fields
    ItemType(String name){
        this.name = name;
    }
}
