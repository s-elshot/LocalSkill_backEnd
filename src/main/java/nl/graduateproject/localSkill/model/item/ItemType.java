package nl.graduateproject.localSkill.model.item;

public enum ItemType {
    PRODUCT("PRODUCT"),
    SERVICE("SERVICE");

    private final String name;

    ItemType(String name){
        this.name = name;
    }
}
