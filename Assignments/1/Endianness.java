import static java.lang.System.out;

public class Endianness {

  public static int bigEndianValue (Byte[] mem) {
    //Byte: 8 bits
    //Byte[]: array of bytes
    // returns: an integer

//    for (int i=3; i > -1; i--) {
//      if (i == 3) {
         // << 0
//
//
//      } else if (i == 2) {
      //      << 8
//
//      } else if (i == 1) {
//        retVal = retVal + mem[i] << 16;
//        System.out.println("i = 1, retVal: " + retVal);
//
//      } else { // i = 0
//        retVal = mem[i] << 24;
//        System.out.println("i = 0, retVal: " + retVal);
//      }
    int retVal = 0;
    for (int i = 0; i < 4; i++) {
      int shiftAmt = 24 - (i*8);
      int unsignedMem = mem[i] & 0xFF;
      retVal += unsignedMem << shiftAmt;
    }
    return retVal;
  }
  
  public static int littleEndianValue (Byte[] mem) {
    int retVal = 0;
    for (int i = 3; i > -1; i--) {
      int shiftAmt = i*8;
      int unsignedMem = mem[i] & 0xFF;
      retVal += unsignedMem << shiftAmt;
    }
    return retVal;
  }
  
  public static void main (String[] args) {
    //byte = 8 bit int
    //we're restricting it to be a byte, to ensure we're only using an 8-bit value
    Byte mem[] = new Byte[4];
    try {
      System.out.println("in for loop: ");
      for (int i=0; i<4; i++) {
        //converts the numbers inputted as strings into hexadecimal ints stored as Bytes (8 bits)
        mem [i] = Integer.valueOf (args[i], 16) .byteValue();
        //System.out.println("args[i]: " + args[i] + "Integer.valueOf(args[i], 16): " + Integer.valueOf(args[i], 16) + "Integer.valueOf(args[i], 16).byteValue(): " + Integer.valueOf(args[i], 16).byteValue());
      }
    } catch (Exception e) {
      out.printf ("usage: java Endianness n0 n1 n2 n3\n");
      out.printf ("where: n0..n3 are byte values in memory at addresses 0..3 respectively, in hex (no 0x).\n");
      return;
    }
  
    int bi = bigEndianValue    (mem);
    int li = littleEndianValue (mem);

    System.out.printf ("Memory Contents\n");
    out.printf ("  Addr   Value\n");
    for (int i=0; i<4; i++)
      out.printf ("  %3d:   0x%-5x\n", i, mem[i]);
    out.printf ("The big    endian integer value at address 0 is %d\n", bi);
    out.printf ("The little endian integer value at address 0 is %d\n", li);
  }
}