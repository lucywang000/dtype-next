package tech.v3.datatype;

import clojure.lang.Keyword;
import clojure.lang.RT;


public interface CharWriter extends PrimitiveWriter
{
  void write(long idx, char value);
  default void writeBoolean(long idx, boolean val) {
    write(idx, (char)(val ? 1 : 0));
  }
  default void writeByte(long idx, byte val) {
    write(idx, (char)val);
  }
  default void writeShort(long idx, short val) {
    write(idx, RT.charCast(val));
  }
  default void writeChar(long idx, char val) {
    write(idx, val);
  }
  default void writeInt(long idx, int val) {
    write(idx, RT.charCast(val));
  }
  default void writeLong(long idx, long val) {
    write(idx, RT.charCast(val));
  }
  default void writeFloat(long idx, float val) {
    write(idx, RT.charCast(val));
  }
  default void writeDouble(long idx, double val) {
    write(idx, RT.charCast(val));
  }
  default void writeObject(long idx, Object val) {
    write(idx, RT.charCast(val));
  }
  default Object elemwiseDatatype () { return Keyword.intern(null, "char"); }

}