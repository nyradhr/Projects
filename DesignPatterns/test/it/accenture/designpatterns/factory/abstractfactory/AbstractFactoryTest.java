package it.accenture.designpatterns.factory.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractFactoryTest {

    AbstractHardwareFactory af1 = new ModernHardwareFactory();
    AbstractHardwareFactory af2 = new ClassicHardwareFactory();

    @Test
    public void modern_hardware_factory_should_return_ssd() {
        Disk d = af1.createDisk();
        assertEquals(SSD.class, d.getClass());
    }

    @Test
    public void classic_hardware_factory_should_return_magnetic_disk() {
        Disk d = af2.createDisk();
        assertEquals(MagneticDisk.class, d.getClass());
    }

    @Test
    public void modern_hardware_factory_should_return_wifi_card() {
        NetworkCard nc = af1.createNetworkCard();
        assertEquals(WiFiCard.class, nc.getClass());
    }

    @Test
    public void classic_hardware_factory_should_return_ethernet_card() {
        NetworkCard nc = af2.createNetworkCard();
        assertEquals(EthernetCard.class, nc.getClass());
    }

}
