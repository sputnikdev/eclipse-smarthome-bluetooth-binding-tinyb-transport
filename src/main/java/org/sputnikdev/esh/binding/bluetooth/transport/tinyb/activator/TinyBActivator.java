package org.sputnikdev.esh.binding.bluetooth.transport.tinyb.activator;

import org.osgi.framework.BundleContext;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.sputnikdev.bluetooth.manager.transport.BluetoothObjectFactory;
import org.sputnikdev.bluetooth.manager.transport.tinyb.TinyBFactory;

@Component(immediate = true, name = "binding.bluetooth.transport.tinyb.activator")
public class TinyBActivator {

    @Activate
    public void activate(BundleContext bundleContext) {
        if (!TinyBFactory.loadNativeLibraries()) {
            throw new IllegalStateException("Could not load native libraries for TinyB");
        }
        bundleContext.registerService(BluetoothObjectFactory.class.getName(), new TinyBFactory(), null);
    }

}
