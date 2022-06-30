package it.accenture.designpatterns.factory.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {

    HardwareStore hs1 = new ModernHardwareStore();
    HardwareStore hs2 = new ClassicHardwareStore();


    @Test
    public void modern_store_should_create_ultra_wide_monitor() {
        Monitor x = hs1.createMonitor();
        assertEquals(UltrawideMonitor.class, x.getClass());
    }

    @Test
    public void classic_store_should_create_crt_monitor() {
        Monitor x = hs2.createMonitor();
        assertEquals(CRTMonitor.class, x.getClass());
    }
}