package com.sample.jwt;

import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

@ApplicationPath("/rest")
@LoginConfig(authMethod = "MP-JWT", realmName = "myrealm")
@DeclareRoles({"admin","user"})
public class JaxRsActivator extends Application {
    /* class body intentionally left blank */
}
