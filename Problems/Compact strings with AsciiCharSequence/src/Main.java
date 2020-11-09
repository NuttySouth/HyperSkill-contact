import java.util.*;

class AsciiCharSequence implements java.lang.CharSequence {
    // implementation
    private byte[] array;
    public AsciiCharSequence(byte[] arr){
        this.array = arr;
    }

    @Override
    public int length(){
        return this.array.length;
    }

    @Override
    public char charAt(int index){
        char toReturn = (char) this.array[index];
        return toReturn;
    }

    @Override
    public String toString(){
        String string = new String(this.array);
        return string;
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end){

        byte[] arr2 = Arrays.copyOfRange(this.array, start, end);
        return new AsciiCharSequence(arr2);
    }

}