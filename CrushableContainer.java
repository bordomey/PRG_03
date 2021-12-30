public class CrushableContainer extends Container {
    private final boolean fragile;

    public CrushableContainer(String name, boolean opaque, boolean fragile) {
        super(name, opaque);
        this.fragile = fragile;
    }
    @Override
    public boolean isFragile(){ return fragile; }
}
