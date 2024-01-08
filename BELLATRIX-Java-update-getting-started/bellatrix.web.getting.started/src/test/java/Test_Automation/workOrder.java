//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class workOrder extends BaseClass {

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven02303");
        login();
    }

    @Test
    public void workOrder() throws InterruptedException {
        leftMenuNavigation("New Work Order", "Clinical Asset Management");
    }
}
