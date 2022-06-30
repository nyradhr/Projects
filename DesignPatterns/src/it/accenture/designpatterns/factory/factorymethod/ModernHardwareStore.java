package it.accenture.designpatterns.factory.factorymethod;

public class ModernHardwareStore extends HardwareStore {
    @Override
    public Monitor createMonitor() {
        return new UltrawideMonitor();
    }
}
