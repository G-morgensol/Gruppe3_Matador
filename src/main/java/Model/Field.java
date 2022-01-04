package Model;

public abstract class Field {
    protected String name;
    protected int position;

    public Field(String name, int position) {
        this.name = name;
        this.position = position;
    }
}
