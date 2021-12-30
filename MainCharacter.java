public class MainCharacter extends Character {
    public MainCharacter(){
        super();
    }

    public MainCharacter(String name, Location location){
        super(name, location);
    }

    public void shake(BodyPart part) {
        System.out.print(this.toString() + " тряс " + part.toString() + ". ");
        if(isStucked(part)){
            setStuckness(part, getStuckness(part) + 1);
        }
    }

    public void tryCrush(BodyPart part){
        System.out.print(this.toString() + " пытался ударится обо что-нибудь и");
        if(this.isBlinded()){
            System.out.print(" не смог так-как ничего не видел. ");
        }
        else {
            if (getStuckedContainer(part) instanceof CrushableContainer) {
                if (!(this.getStuckedContainer(part).isFragile())) {
                    System.out.print(" не смог разбить " + this.getStuckedContainer(part).toString() + ". ");
                } else {
                    System.out.print(" разбил " + this.getStuckedContainer(part).toString() + ". ");
                    unstuck(part);
                }
            }
        }
    }

    @Override
    public void goToLocation(Location goal) {
        if(getCharacterLocation().hardToGetOut && isBlinded()){
            System.out.print("Не смог выбраться так как ничего не видел. ");
        }
        else
            setCharacterLocation(goal);
    }

    @Override
    public void shout(String phrase){
        System.out.print(this.toString() + " кричал \"" + phrase + "\". ");
    }

    @Override
    public void callCharacter(Character target) {
        shout(target.toString() + "!");
    }

    @Override
    public void callHelp() {
        shout("Помогите!");
    }

    @Override
    public void scream() {
        shout("Ай-ай-ай!");
    }

    @Override
    public void tryUnstuck(BodyPart bodyPart) {
        if(isStucked(bodyPart)) {
            if(getStuckness(bodyPart) > 0)
                System.out.print(this.toString() + " не мог снять " + getStuckedContainer(bodyPart) + " c " + bodyPart.toString() + ". ");
            else {
                System.out.print(this.toString() + " снял " + getStuckedContainer(bodyPart) + " c " + bodyPart.toString() + ". ");
                this.unstuck(bodyPart);
            }
        }
    }


}
