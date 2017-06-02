/*
 */
package page_objects;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class AbstractPageObject {

    @Autowired
    @Lazy
    public WebDriver driver;


}
