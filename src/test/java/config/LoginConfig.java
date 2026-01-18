package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:properties/login.properties")
public interface LoginConfig extends Config{
    @Key("email")
    String email();

    @Key("password")
    String password();
}
