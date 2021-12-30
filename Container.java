public abstract class Container implements Fillable{
    private boolean empty = true;
    private final boolean opaque;

    private final String name;


    public Container(String name, boolean opaque) {
        this.name = name;
        this.opaque = opaque;
    }

    public abstract boolean isFragile();
    public boolean isOpaque(){
        return opaque;
    }
    @Override
    public boolean isEmpty() {
        return empty;
    }
    @Override
    public void setEmpty(boolean empty){ this.empty = empty; }
    @Override
    public String toString() {
        return name;
    }
}
