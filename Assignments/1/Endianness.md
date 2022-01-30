- examples -- work thru on paper first
- how the fn should go from input(s) to output in terms of answer, types, what each part of the input is responsible for

1. Terminal: "java Endianness 01 02 8A FF"

2. This is taken into main() as an array of Strings "args". args has length 4, and looks like: [ "01", "02", "8A", "FF" ]

3. In main, we init. an array "mem", which is 4 units long, and contains type "Byte"

4. For loop: for 0, 1, 2, 3: args[i] converts to an Int, base 16, w the same val. *IT ASSUMES THE INPUT STRING IS ALREADY IN THAT BASE, AND CONVERTS TO DECIMAL*)

i.e. 01 => 1
     02 => 2
     8A => 138
     FF => 255

This is then converted, via byteValue(), into "the numeric value represented by this object after conversion to type Byte. int.byteValue is the same as (byte)Integer.valueOf(...))

i.e. 1 => 1 
     2 => 2
     138 => -118
     255 => -1
     

This Byte value (8 bits) is then placed into mem[i]

BE: 

5. int bi = bigEndianValue (mem). Go into bigEndianValue

6. in bigEndianValue, we've received mem[] = arr of Bytes containing 4 Bytes. 
We need to return an integer that is the BE interpretation of this array, i.e. most significant bit = mem[0]. An int is 32 bits, the entirety of mem contains 32 bits (4 * 1x Byte = 4 * 8 bits = 32 bits). 

The value of each byte is possibly different than the original int because of the lossy type coercion int => byte. Our original hex int inputs are unsigned, but this coercion leads to signed bytes.  
To get back the original int value, we must do int unsignedMem = mem[i] & 0xFF.

7. Then, we must put this new unsigned (original) value into its correct position based on the fact that
a.) it's BE
and b.) its position in the original array

LE: 

8. int li = littleEndianValue(mem). Go into littleEndianValue.

9. In littleEndianValue, we've received mem[] = arr of Bytes containing 4 Bytes. 

The value of each byte is different from the original int b/c lossy type coercion int => byte. OG hex int inputs are unsigned, but coercion leads to signed bytes. To get back the original int value, we must do int unsignedMem = mem[i] & 0xFF. 

We need to return an integer that is the LE interpretation of this array, i.e. most significant bit = mem[3]









mem[] is an array of Bytes of size 4
