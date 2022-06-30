package it.accenture.designpatterns.factory.factorymethod;

public class ClassicHardwareStore extends HardwareStore {
    @Override
    public Monitor createMonitor() {
        return new CRTMonitor();
    }
}
