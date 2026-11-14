public class memory {
    memoryDevice[] devices;

    public memory() {
        this.devices = new memoryDevice[] {new vectorTable()};
    }

    private memoryDevice select_device(int address) {
        if (address >= 0xFFF8) {
            return devices[0];
        }
        return devices[0];
    }

    public byte read(int address) {
        return select_device(address).read(address);
    }

    public void write(int address, byte newData) {
        select_device(address).write(address, newData);
    }
}
