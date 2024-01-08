//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import solutions.bellatrix.web.components.Anchor;
import solutions.bellatrix.web.components.TextInput;

public class impersonation extends MapPolaris {
    public impersonation() {
    }

    public void goTo(String instance) {
        app().navigate().to("https://" + instance + ".service-now.com/login.do");
    }

    public void login() {
        TextInput username = (TextInput)app().create().byCss(TextInput.class, "#user_name");
        TextInput password = (TextInput)app().create().byCss(TextInput.class, "#user_password");
        username.setText("Automation.admin");
        password.setText("Nuvolo@2022");
        ((Anchor)app().create().byCss(Anchor.class, "#sysverb_login")).click();
    }

    @BeforeMethod
    public void beforeMethod() {
        goTo("ven02303");
        login();
    }

    @Test
    public void impersonateUser() {
        polarisImpersonateUser("Amol Hiwale");
        polarisLeftMenuNavigation("New Work Order", "Facilities Asset Management");
    }
}
