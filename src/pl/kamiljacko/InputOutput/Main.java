package pl.kamiljacko.InputOutput;

import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        //io package
        //Scanner scanner = new Scanner(new FilerReader("")));
        //scanner.close() zamknie tez filereadera , musi implementowac interfejs Closeable , to samo z try with resources
        //binary data DataOutputStream/DataInputStream primitive types can be saved

// 1.   //BufferedWriter locFile = new BufferedWriter(new FileWriter("..");

        //ObjectOutputStream/ObjectinputStream przy serializacji trzeba implementowac interfejs Serializable
        //private long serialversionUID = 1L; <- wersja klasy

        //randomaccessfile class  // file pointer, offset is a byte location in a file
        // index record <- record length

        //nio package
// 2.   //Path locPath = FileSystems.getDefault().getPath("....");
        //BufferedWriter locFile = Files.newBufferedWriter(...);


//        ==========================================
//        The three dots can only be used in a method argument, and are called 'varargs'. It means you can pass in an array of parameters without explicitly creating the array.
//
//        private void method(String[] args) {} is called like method(new String[]{"first", "second"});
//
//        private void method(String... args) {} is called like method("first", "second");
//
//        public class Program {
//            private static void printArgs(String... strings) {
//                for (String string : strings) {
//                    System.out.println(string);
//                }
//            }
//
//            public static void main(String[] args) {
//
//                // the compiler wraps the argument(s) passed to printArgs inside an array
//                // meaning printArgs is just method that takes a single argument which is a string array of variable length
//
//                printArgs("hello");                 // short for printArgs( ["hello"] )
//                printArgs("hello", "world");        // short for printArgs( ["hello", "world"] )
//            }
//        }

    }
}