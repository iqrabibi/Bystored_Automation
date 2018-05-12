package General;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

/**
 * Created by VenD on 5/3/2018.
 */

@Resource.Classpath("ApplicationConfig.properties")

public class ApplicationConfigReader {
    public ApplicationConfigReader()
    {
        PropertyLoader.newInstance().populate(this);
    }

    @Property(value = "url")
    public String Url;

    public String getUrl() {
        return Url;
    }





    @Property(value = "downloadPath")
    public String downloadPath;

    public String getDownloadPath() {

        return downloadPath;
    }



}
