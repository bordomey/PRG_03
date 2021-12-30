public class Main {
    public static void main(String[] args )
    {
        MainCharacter VP = new MainCharacter("Винни-Пух", Location.TRAP);
        CrushableContainer Pot = new CrushableContainer("горшок", true, false);
        VP.stuck(BodyPart.HEAD, Pot);
        VP.tryUnstuck(BodyPart.HEAD);
        VP.shake(BodyPart.HEAD);
        VP.callCharacter(new MainCharacter("Мама", Location.ANYWHERE));
        VP.callHelp();
        VP.scream();
        VP.tryUnstuck(BodyPart.HEAD);
        VP.tryCrush(BodyPart.HEAD);
        VP.goToLocation(Location.ANYWHERE);
    }
}
