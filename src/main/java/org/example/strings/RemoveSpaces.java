package org.example.strings;
/*
Notes :
+/Removing Whitespace
How to remove whitespace, specifically leading and trailing whitespace.

For example, here you have strings with whitespace at the start and the end. To remove them, we can simply invoke the
trim method on each like so.
 Run this code, and indeed, we see that these words are concatenated together without any whitespace between them.
 But, I could also use the strip method added in Java 11, and the result will be the same.
 So what's the difference between these two?

 Computers started with ASCII 128 characters just enough to fit on an old keyboard.  These included numbers and letters,
  as well as tab, line feed, carriage return, and of course, the space, invisible  characters. Then all the other
  languages and alphabets and signs needed to be included so Unicode had to be created, which is essentially a huge
  superset of ASCII. The first 128 characters in Unicode are the same as in ASCII.
 So the Space character or graphic is at position 32 and its code in Unicode is 0020.
 This is important because if we look at the Java doc of trim available since Java 1, it reads that it considers
 whitespace as any character whose code point is less than or equal to Unicode 0020, the Space character.
 So trim removes spaces, tabs, line feeds, and carriage returns, and that's great, but Unicode kept evolving, and as
 years went by, all sorts of new whitespace characters got added. If you search for Unicode space characters,
 you'll see that there is a lot of them. The only difference between many of them is their width and
 it's fine to add more characters, but as you might know, Java avoids breaking changes, so changing the
 implementation of trim and making it remove extra space characters would have been dangerous and could break a
  lot of existing software. That is why they added strip. To sum up, strip is a Unicode‑aware evolution of trim,
  and accepts some low‑level control characters, it will remove many more whitespace characters that got added to
  Unicode over time. My advice is to prefer strip to trim where you can. To see it in action, here we have a
  single escaped character, the so‑called end space. We will use the isWhitespace method to check if it's considered
  whitespace and it will be, and we'll try to trim it and strip it. Trim will not remove it, but strip will.
  Run the code and see here the end space is indeed considered to be whitespace. T
  rim failed to remove it, but strip did.

 */
public class RemoveSpaces {
   public static void main(String[] args) {

        System.out.println("hello   ".trim() + "     there".trim());

        char space = '\u2002';
        System.out.println("\\u2002 is whitespace: " + Character.isWhitespace(space));

        /* trim() only removes ascii white spaces
        * strip() takes into account all unicode white spaces
        * Good idea to use to use strip*/
        System.out.println("hello\u2002".trim() + "\u2002there".trim());
        System.out.println("hello\u2002".strip() + "\u2002there".strip());

    }

}
