package contacts;

import java.io.*;

public class SerializationUtils {
    //serialize
    public static void serialize(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName); //makes possible to write and convert to outputStream
        BufferedOutputStream bos = new BufferedOutputStream(fos); //buffers the data
        ObjectOutputStream oos = new ObjectOutputStream(bos); //converts to a writer
        oos.writeObject(obj);
        oos.close();
    }

    //deserialize
    public static Object deserialization(String fileName) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}
