import java.util.*;
interface StringCollection {
    public int getSize();
    public void add(String e);
    public boolean contains(String e);
    public boolean remove(String e);
    public void addAllFromCollection(StringCollection collection);
    public List<String> toList();

}
