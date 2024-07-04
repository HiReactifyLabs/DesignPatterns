import java.util.*;

// Product
class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private boolean coolingSystem;
    
    public void setCPU(String CPU) {
        this.CPU = CPU;
    }
    
    public void setRAM(String RAM) {
        this.RAM = RAM;
    }
    
    public void setStorage(String storage) {
        this.storage = storage;
    }
    
    public void setGPU(String GPU) {
        this.GPU = GPU;
    }
    
    public void setCoolingSystem(boolean coolingSystem) {
        this.coolingSystem = coolingSystem;
    }
    
    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU + ", coolingSystem=" + coolingSystem + "]";
    }
}

class ComputerBuilder {
	protected Computer computer;
    
    public Computer getComputer() {
        return computer;
    }
    
    public ComputerBuilder createNewComputer() {
        computer = new Computer();
        return this;
    }
    
    public ComputerBuilder buildCPU() {
        computer.setCPU("Basic CPU");
        System.out.println("SimpleComputerBuilder: CPU complete.");
        return this;
    }
    
    public ComputerBuilder buildRAM() {
        computer.setRAM("4GB RAM");
        System.out.println("SimpleComputerBuilder: RAM complete.");
        return this;
    }
    
    public ComputerBuilder buildStorage() {
        computer.setStorage("256GB SSD");
        System.out.println("SimpleComputerBuilder: Storage complete.");
        return this;
    }
    
    public ComputerBuilder buildGPU() {
        computer.setGPU("High-end Gaming GPU");
        System.out.println("GamingComputerBuilder: GPU complete.");
        return this;
    }
    
    public ComputerBuilder buildCoolingSystem() {
        computer.setCoolingSystem(true);
        System.out.println("GamingComputerBuilder: Cooling system complete.");
        return this;
    }
}

// Client
public class BuilderPattern {
    public static void main(String[] args) {
        ComputerBuilder simpleComputerBuilder = new ComputerBuilder();

        Computer simpleComputer = simpleComputerBuilder.createNewComputer()
                                                       .buildCPU()
                                                       .buildRAM()
                                                       .buildStorage()
                                                       .getComputer();
        System.out.println("Simple Computer is: " + simpleComputer);
        
        ComputerBuilder gamingComputerBuilder = new ComputerBuilder();

        Computer gamingComputer = gamingComputerBuilder.createNewComputer()
                                                       .buildCPU()
                                                       .buildRAM()
                                                       .buildStorage()
                                                       .buildGPU()
                                                       .buildCoolingSystem()
                                                       .getComputer();
        System.out.println("Gaming Computer is: " + gamingComputer);
    }
}
