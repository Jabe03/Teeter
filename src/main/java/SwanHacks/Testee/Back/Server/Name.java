package SwanHacks.Testee.Back.Server;

public class Name {
    String first;
    String last;
    String middle;
    String suffix;

    public Name(String first, String last){
        this(first, null, last, null);
    }

    public Name(String name){
        this(name.split(" ")[0], null, name.split(" ")[1], null);

    }

    public Name(String first, String middle, String last, String suffix){
        this.first = first;
        this.middle = middle;
        this.last = last;
        this.suffix = suffix;

    }

    @Override
    public String toString(){
        return first + " " + (middle == null ? "" : middle + " ") + last + " " +  (suffix == null ? "" : suffix + " ");
    }

}
