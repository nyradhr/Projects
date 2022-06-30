package it.accenture.designpatterns.factory.factorymethod;

public abstract class HardwareStore {
    public void receiveOrder() {
        System.out.println("I'm receiving the order.");
    }

    public void sendOrder() {
        Monitor m = createMonitor();
        System.out.println("I'm sending a monitor of type "+m.getClass().getSimpleName());
    }

    public abstract Monitor createMonitor();
}
