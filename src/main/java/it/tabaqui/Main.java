package it.tabaqui;

import java.lang.management.ManagementFactory;
import java.time.Duration;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import it.tabaqui.jmx.HeapManager;

public class Main {
	
	// Static methods
	
	public static void main(String[] args) throws Exception {
		// Registrazione MBean custom
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		server.registerMBean(new HeapManager(), new ObjectName("it.tabaqui:type=Memory,name=HeapManager"));
		// Esecuzione applicazione (ciclo infinito)
		while (true) {
			Thread.sleep(Duration.ofMillis(1));
		}
	}
}
