package it.accenture.designpatterns.factory.abstractfactory;

public class ModernHardwareFactory extends AbstractHardwareFactory {
    @Override
    public Disk createDisk() {
        return new SSD();
    }

    @Override
    public NetworkCard createNetworkCard() {
        return new WiFiCard();
    }
}
