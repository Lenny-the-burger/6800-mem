public interface memoryDevice {

    public byte read(int address);
    public void write(int address, byte newData);
}
