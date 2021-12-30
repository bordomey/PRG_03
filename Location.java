public enum Location {

    ANYWHERE("Где-то", false),
    TRAP("Западня", true);

    private final String name;
    public final boolean hardToGetOut;

    Location(String name, boolean hardness){
        this.name = name;
        this.hardToGetOut = hardness;
    }

    @Override
    public String toString(){
        return name;
    }

}
