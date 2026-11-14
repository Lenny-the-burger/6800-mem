public class vectorTable implements memoryDevice {

    public static final int BASE  = 0xFFF8;
    public static final int IRQ   = 0xFFF8;
    public static final int SWI   = 0xFFFA;
    public static final int NMI   = 0xFFFC;
    public static final int RESET = 0xFFFE;

    byte linear[];

    public vectorTable() {
        linear = new byte[8];
    }

    @Override
    public byte read(int address) {
        return linear[address - BASE];
    }

    @Override
    public void write(int address, byte newData) {
        linear[address - BASE] = newData;
    }

    private short getVector(int address) {
        int hi = linear[address - BASE] & 0xFF;
        int lo = linear[address - BASE + 1] & 0xFF;
        return (short) ((hi << 8) | lo);
    }

    private void setVector(int address, short value) {
        linear[address - BASE]     = (byte) ((value >> 8) & 0xFF);
        linear[address - BASE + 1] = (byte) (value & 0xFF);
    }

    public short getIrq()   { return getVector(IRQ); }
    public short getSwi()   { return getVector(SWI); }
    public short getNmi()   { return getVector(NMI); }
    public short getReset() { return getVector(RESET); }

    public void setIrq(short value)   { setVector(IRQ, value); }
    public void setSwi(short value)   { setVector(SWI, value); }
    public void setNmi(short value)   { setVector(NMI, value); }
    public void setReset(short value) { setVector(RESET, value); }
}
