package tests.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/main/resources/base.properties"
})
public interface Props extends Reloadable  {
    Props props = ConfigFactory.create(Props.class);

    @Key("browser.size")
    String browserSize();

    @Key("page.load.timeout")
    String pageLoadTimeout();

    @Key("timeout")
    String timeout();

    @Key("browser")
    String browser();

    @Key("host")
    String host();

}
