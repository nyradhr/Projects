package it.accenture.designpatterns.factory.abstractfactory;

public class ClassicHardwareFactory extends AbstractHardwareFactory {
    @Override
    public Disk createDisk() {
        return new MagneticDisk();
    }

    @Override
    public NetworkCard createNetworkCard() {
        return new EthernetCard();
    }
}
