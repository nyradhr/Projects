package it.accenture.designpatterns.factory.abstractfactory;

public abstract class AbstractHardwareFactory {
    public abstract Disk createDisk();

    public abstract NetworkCard createNetworkCard();
}
