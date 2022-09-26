public class Main {
    public static void main(String[] args) {
        StringLinkedList s1=new StringLinkedList("Hello");
        StringLinkedList s2=new StringLinkedList("Yo");
        s2.add("Hey");
        s1.add("Hi");
        System.out.println(s1.getValue());
        System.out.println(s1.getSize());
        System.out.println(s1.getNextElement().getValue());
        System.out.println(s1.toList().toString());
        System.out.println(s1.remove("Hi"));
        System.out.println(s1.getSize());
        System.out.println(s1.toList().toString());
        s1.addAllFromCollection(s2);
        System.out.println(s1.toList().toString());
        System.out.println(s1.getIndexOf("Yo"));
        System.out.println(s1.contains("Hey"));
        s1.add("Howdy",1);
        System.out.println(s1.toList().toString());

    }
}
