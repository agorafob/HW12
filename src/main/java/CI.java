public interface CI {

   boolean add(Object o);

    boolean add(int index, Object o);

    boolean delete(Object o);

    Object get(int index);

    boolean contain(Object o);

    boolean equals(MyCollection str);

    boolean clear();

    int size();
}