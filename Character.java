import java.util.Arrays;
import java.util.Objects;

public abstract class Character implements AbleToSpeak {
    private final String name;
    private Location characterLocation;
    private boolean[] stucked = new boolean[BodyPart.values().length];
    private Container[] stuckedIn = new Container[BodyPart.values().length];
    private int[] stuckness = new int[BodyPart.values().length];


    public Character(){
        this("Unnamed");
    }

    public Character(String name){
        this(name, Location.ANYWHERE);
    }

    public Character(String name, Location location){
        this.name = name;
        this.characterLocation = location;
    }

    public abstract void goToLocation(Location goal);

    public abstract void tryUnstuck(BodyPart bodyPart);

    public void unstuck(BodyPart part){
        stuckedIn[part.ordinal()].setEmpty(true);
        stucked[part.ordinal()] = false;
        stuckedIn[part.ordinal()] = null;
    }

    public void stuck(BodyPart part, Container cont, int stuckness){
        if(!stucked[part.ordinal()] && cont.isEmpty()){
            System.out.print(part.toString() + " персонажа " + name + " застряла в " + cont + ". ");
            stucked[part.ordinal()] = true;
            stuckedIn[part.ordinal()] = cont;
            cont.setEmpty(false);
            this.setStuckness(part, stuckness);
        }
        else if(!cont.isEmpty()){
            System.out.print(cont + " уже занят. ");
        }
        else{
            System.out.print(part.name() + "уже застряла. ");
        }
    }

    public void stuck(BodyPart part, Container cont){
        stuck(part, cont, 1);
    }

    public boolean isStucked(BodyPart part){ return stucked[part.ordinal()]; }

    public Container getStuckedContainer(BodyPart part) {
        return stuckedIn[part.ordinal()];
    }

    public Location getCharacterLocation() { return characterLocation; }

    public void setCharacterLocation(Location location) {
        this.characterLocation = location; System.out.print(this.toString() + " пришёл в " + location.toString());
    }

    public boolean isBlinded() { return stucked[BodyPart.HEAD.ordinal()]; }

    public int getStuckness(BodyPart part) {
        return stuckness[part.ordinal()];
    }

    public void setStuckness(BodyPart part, int stuckness){
        if (stuckness > this.stuckness[part.ordinal()])
            System.out.print( getStuckedContainer(part) + " стал сидеть крепче. ");
        else
            System.out.print( getStuckedContainer(part) + " сидит не так крепко. ");
        this.stuckness[part.ordinal()] = stuckness;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) && Arrays.equals(stucked, character.stucked);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(stucked);
        return result;
    }
}
