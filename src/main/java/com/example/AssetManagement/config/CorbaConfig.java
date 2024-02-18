package com.example.AssetManagement.config;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorbaConfig {
    @Bean
    public ORB orb() {
        return ORB.init();
    }

    @Bean
    public POA rootPOA(ORB orb) throws InvalidName {
        // Obtain and return the root POA
        return POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
    }
}
