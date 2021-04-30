import java.util.Arrays;

public class MyCollection implements CI {

    private int initialSize = 1;
    private int size;
    private String[] collection = new String[initialSize];

    public static void main(String[] args) {
        MyCollection str = new MyCollection();
        str.add("111");
        str.add("222");
        str.add("333");
        System.out.println("Простое добавление " + str);
        str.add(2, "444");
        System.out.println("Добавление по индексу с заменой " + str);
        str.add(2, "555");
        System.out.println(str);
        str.add("666");
        System.out.println(str);
        str.add(6, "777");
        System.out.println("Добавление по индексу в конец " + str);
        str.add("888");
        str.delete("666");
        System.out.println("Удаление " + str);
        System.out.println("Получение по индексу " + str.get(2));
        System.out.println("Размер " + str.size);

        MyCollection str1 = new MyCollection();
        str1.add("111");
        str1.add("222");
        MyCollection str2 = new MyCollection();
        str2.add("111");
        str2.add("333");
        System.out.println("Сравнение " + str1.equals(str2));

    }


    @Override
    public boolean add(Object o) {
        add(this.size, o);
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        if (index < 0 || index > size) {
            System.out.println("Incorrect index");
            return false;
        } else {
            if (index == size) {
                collection = getNewCollection(size + 1, collection);
                size++;
            } else if (collection[index] != null) {
                collection = getNewCollection(size + 1, collection);
                collection[size] = collection[index];
                size++;
            }
        }
        collection[index] = o.toString();

        return true;
    }


    @Override
    public boolean delete(Object o) {
        if (collectionIsEmpty()) {
            System.out.println("Collection is empty");
            return false;
        } else {
            for (int i = 0; i < collection.length; i++) {
                if (collection[i].equals(o.toString())) {
                    collection = deleteIndex(collection, i);
                    size--;
                } else {
                    System.out.println("No such element");
                }
            }
        }
        return true;
    }

    @Override
    public Object get(int index) {
        return collection[index];
    }

    @Override
    public boolean contain(Object o) {
        int counter;
        if (collectionIsEmpty()) {
            System.out.println("Collection is empty");
            return false;
        } else {
            counter = 0;
            for (String s : collection) {
                if (s.equals(o)) {
                    counter++;
                }
            }
        }
        return counter > 0;
    }

    @Override
    public boolean equals(MyCollection str) {
        int counter = 0;
        if(collectionIsEmpty() || str.collectionIsEmpty()){
            System.out.println("One or both collections are empty ");
            return false;
        }else if (this.collection.length != str.collection.length) {
            return false;
        }else {
            for (int i = 0; i < collection.length; i++) {
                if (this.collection[i].equals(str.collection[i])) {
                    counter++;
                }
            }
        }
        return counter == collection.length;
    }

    @Override
    public boolean clear() {
        collection = new String[initialSize];
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(collection);
    }

    private String[] getNewCollection(int newSize, String[] oldCollection) {
        String[] newCollection = new String[newSize];
        for (int i = 0; i < oldCollection.length; i++) {
            newCollection[i] = oldCollection[i];
        }
        return newCollection;
    }

    private String[] deleteIndex(String[] arr, int index) {
        String[] strArr = new String[arr.length - 1];
        int counter = 0;
        if (index >= arr.length) {
            System.out.println("Wrong input");
            return null;
        } else {
            if (index == 0) {
                while (counter < strArr.length) {
                    strArr[counter] = arr[counter + 1];
                    counter++;
                }
            } else if (index == arr.length - 1) {
                while (counter < arr.length - 1) {
                    strArr[counter] = arr[counter];
                    counter++;
                }
            } else {
                while (counter < index) {
                    strArr[counter] = arr[counter];
                    counter++;
                }
                counter = index + 1;
                while (counter >= index && counter < arr.length) {
                    strArr[counter - 1] = arr[counter];
                    counter++;
                }
            }
        }
        return strArr;
    }

    private boolean collectionIsEmpty() {
        return this.size == 0;
    }
}
