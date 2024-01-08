//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import java.util.Iterator;
import java.util.List;
import solutions.bellatrix.web.components.Anchor;
import solutions.bellatrix.web.components.Frame;
import solutions.bellatrix.web.components.TextInput;
import solutions.bellatrix.web.components.WebComponent;
import solutions.bellatrix.web.infrastructure.DriverService;
import solutions.bellatrix.web.infrastructure.testng.WebTest;

public class Polaris extends WebTest {
    String polarisLayout = "sn-polaris-layout[component-id$='polarisLayout']";
    String polarisHeader = "sn-polaris-header[dir='ltr']";
    String avatar = "div[aria-label^='Avatar'] now-avatar";
    String avatarContent = ".now-avatar-content";
    String impersonateUserLink = "button[data-id='impersonateUser']";
    String filterValue = "div[class='content-area can-animate'] sn-impersonation";
    String typeHeadele = "div[class='impersonation'] now-typeahead";
    String nativInput = "input[class$='native-input']";
    String seismicHoist = "seismic-hoist[slot='content']";
    String nowModelRoot = "now-modal[dir='ltr']";
    String nowButtonRoot = "now-button[class='now-modal-footer-button']:nth-child(2)";
    String impersonateButton = ".now-line-height-crop";
    String userLabel = "div div div div.now-dropdown-list-label";
    String userSubLabel = "div div div div.now-dropdown-list-sublabel";
    String allButton = "div[aria-label='All']";
    String polarisMenu = "sn-polaris-menu[aria-label='Unpinned All menu']";
    String pinButtonClick = ".sn-polaris-nav-btn.can-animate";
    String isPinned = "sn-polaris-menu[aria-label='Pinned All menu']";
    String clickPinned = ".sn-polaris-nav-btn.is-pinned.can-animate";
    String pinnedIcon = ".pinned-icon";
    String svg = "svg";
    String canAnimateMenu = "sn-polaris-menu[class~='is-pinned']";
    String collapsibleList = "div[class^='sn-polaris-nav-body'] sn-collapsible-list";

    public Polaris() {
    }

    WebComponent polarisMenuShadowTest() {
        return app().create().byCss(WebComponent.class, "macroponent-f51912f4c700201072b211d4d8c26010").toShadowRootToBeAttached();
    }

    public Anchor polarisMenuItem(String mainLabel, String searchMenu) {
        String cssLocator = String.format("[aria-label='%s']~div a[aria-label^='%s']", mainLabel, searchMenu);
        return (Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout").shadowRootCreateByCss(WebComponent.class, "sn-polaris-header").shadowRootCreateByCss(WebComponent.class, "sn-polaris-menu.is-main-menu").shadowRootCreateByCss(WebComponent.class, "sn-collapsible-list:last-child").shadowRootCreateByCss(Anchor.class, cssLocator);
    }

    public WebComponent filterImpersonate() {
        return polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout[component-id$='polarisLayout']").shadowRootCreateByCss(WebComponent.class, filterValue).shadowRootCreateByCss(WebComponent.class, typeHeadele);
    }

    public void polImpersonate(String user) throws InterruptedException {
        WebComponent shadow1 = polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout[component-id$='polarisLayout']");
        WebComponent shadow2 = shadow1.shadowRootCreateByCss(WebComponent.class, "sn-polaris-header[dir='ltr']");
        WebComponent shadow3 = shadow2.shadowRootCreateByCss(WebComponent.class, avatar);
        ((Anchor)shadow3.shadowRootCreateByCss(Anchor.class, avatarContent)).click();
        Thread.sleep(2000L);
        ((Anchor)shadow2.shadowRootCreateByCss(Anchor.class, "button[data-id='impersonateUser']")).click();
        Thread.sleep(2000L);
        WebComponent impersonation = shadow1.shadowRootCreateByCss(WebComponent.class, filterValue);
        WebComponent typeHead = impersonation.shadowRootCreateByCss(WebComponent.class, typeHeadele);
        ((TextInput)typeHead.shadowRootCreateByCss(TextInput.class, "input[class='now-typeahead-native-input']")).setText(user);
        WebComponent seismic = app().create().byCss(WebComponent.class, seismicHoist).toShadowRootToBeAttached();
        String labelUser = "div div div div.now-dropdown-list-label div div[aria-label='" + user + "']";
        List<Anchor> labels = seismic.shadowRootCreateAllByCss(Anchor.class, labelUser);
        Iterator var11 = labels.iterator();

        while(var11.hasNext()) {
            Anchor label = (Anchor)var11.next();
            if (label.toString().equals(user)) {
                label.click();
                break;
            }

            String subLabelUser = "div div div div.now-dropdown-list-sublabel div div[aria-label='" + user + "']";
            List<Anchor> subLabels = seismic.shadowRootCreateAllByCss(Anchor.class, subLabelUser);
            Iterator var15 = subLabels.iterator();

            while(var15.hasNext()) {
                Anchor subLabel = (Anchor)var15.next();
                if (subLabel.toString().equals(user)) {
                    subLabel.click();
                    break;
                }
            }
        }

        WebComponent nowModel = impersonation.shadowRootCreateByCss(WebComponent.class, nowModelRoot);
        WebComponent nowButton = nowModel.shadowRootCreateByCss(WebComponent.class, nowModelRoot);
        ((Anchor)nowButton.shadowRootCreateByCss(Anchor.class, impersonateButton)).click();
    }

    public boolean checkAll() {
        polarisMenuShadowTest().waitToBe();
        WebComponent button = polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout).shadowRootCreateByCss(WebComponent.class, polarisHeader);

        try {
            ((Anchor)button.shadowRootCreateByCss(Anchor.class, allButton)).isVisible();
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public Anchor allButton() {
        polarisMenuShadowTest().waitToBe();
        return (Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout).shadowRootCreateByCss(WebComponent.class, polarisHeader).shadowRootCreateByCss(Anchor.class, allButton);
    }

    public boolean checkPinButton() {
        polarisMenuShadowTest().waitToBe();

        try {
            Anchor pinButton = (Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout).shadowRootCreateByCss(WebComponent.class, polarisHeader).shadowRootCreateByCss(WebComponent.class, isPinned).shadowRootCreateByCss(Anchor.class, clickPinned);
            pinButton.isVisible();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public Anchor pinButton() {
        polarisMenuShadowTest().waitToBe();
        return (Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout).shadowRootCreateByCss(WebComponent.class, polarisHeader).shadowRootCreateByCss(WebComponent.class, polarisMenu).shadowRootCreateByCss(Anchor.class, pinButtonClick);
    }

    public void unpinButton() {
        polarisMenuShadowTest().waitToBe();
        ((Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout).shadowRootCreateByCss(WebComponent.class, polarisHeader).shadowRootCreateByCss(WebComponent.class, isPinned).shadowRootCreateByCss(WebComponent.class, pinnedIcon).createByCss(Anchor.class, svg)).click();
    }

    public void pinButtonMechanism() {
        polarisMenuShadowTest().waitToBe();
        if (!checkPinButton()) {
            try {
                unpinButton();
                allButton().click();
            } catch (Exception var2) {
                allButton().click();
                pinButton().click();
            }
        }

    }

    public WebComponent filterMechanism(String module) {
        polarisMenuShadowTest().waitToBe();
        WebComponent filter = polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout).shadowRootCreateByCss(WebComponent.class, polarisHeader).shadowRootCreateByCss(WebComponent.class, canAnimateMenu);
        ((TextInput)filter.shadowRootCreateByCss(TextInput.class, "#filter")).setText(module);
        return filter;
    }

    public void selectModule(String app, String module) {
        pinButtonMechanism();
        filterMechanism(module);
        WebComponent application = polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout).shadowRootCreateByCss(WebComponent.class, polarisHeader).shadowRootCreateByCss(WebComponent.class, canAnimateMenu).shadowRootCreateByCss(WebComponent.class, collapsibleList);
        String moduleLocator = "div[class='snf-collapsible-list'] button +div ul li span a[aria-label^='" + module + "'] span span mark.filter-match";
        ((Anchor)application.createByCss(Anchor.class, moduleLocator)).click();
        unpinButton();
        allButton().click();
    }

    public boolean checkApplication(String module, String app) {
        try {
            WebComponent application = polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout).shadowRootCreateByCss(WebComponent.class, polarisHeader).shadowRootCreateByCss(WebComponent.class, canAnimateMenu).shadowRootCreateByCss(WebComponent.class, collapsibleList);
            ((TextInput)application.createByCss(TextInput.class, "#filter")).setText(module);
            String appn = "div button[aria-label='" + app + "'] + div>ul>li>sn-collapsible-list[class='nested-item']";
            Anchor checkApp = (Anchor)application.createByCss(Anchor.class, appn);
            checkApp.isVisible();
            return true;
        } catch (Exception var6) {
            return false;
        }
    }

    public void DefaultLeftMenu(String module, String app) {
        pinButtonMechanism();
        WebComponent shadow3 = filterMechanism(module);
        List<WebComponent> elements = shadow3.createAllByCss(WebComponent.class, collapsibleList);
        String moduleLocator = "div[class='snf-collapsible-list'] button +div ul li span a[aria-label^='" + module + "'] span span mark.filter-match";
        int i;
        WebComponent shadow4;
        String appLocator;
        List applications;
        int j;
        WebComponent shadow5;
        if (checkApplication(module, app)) {
            for(i = 1; i < elements.size() + 1; ++i) {
                shadow4 = shadow3.shadowRootCreateByCss(WebComponent.class, "div[class^='sn-polaris-nav-body'] sn-collapsible-list:nth-child(" + i + ")");
                appLocator = "div button[aria-label='" + app + "'] + div>ul>li>sn-collapsible-list[class='nested-item']";
                applications = shadow4.shadowRootCreateAllByCss(WebComponent.class, appLocator);

                for(j = 1; j < applications.size() + 1; ++j) {
                    shadow5 = shadow4.shadowRootCreateByCss(WebComponent.class, "div button[aria-label='" + app + "'] + div>ul>li>sn-collapsible-list[class='nested-item']:nth-child(" + j + ")");
                    ((Anchor)app().create().byCss(Anchor.class, moduleLocator)).scrollToVisible();
                    ((Anchor)shadow5.shadowRootCreateByCss(Anchor.class, moduleLocator)).click();
                    unpinButton();
                    allButton().click();
                }
            }
        } else {
            for(i = 1; i < elements.size() + 1; ++i) {
                shadow4 = shadow3.shadowRootCreateByCss(WebComponent.class, "div[class^='sn-polaris-nav-body'] sn-collapsible-list:nth-child(" + i + ")");
                appLocator = "div button[aria-label='" + app + "'] + div>ul>li>sn-collapsible-list[class='nested-item']";
                applications = shadow4.shadowRootCreateAllByCss(WebComponent.class, appLocator);

                for(j = 1; j < applications.size() + 1; ++j) {
                    shadow5 = shadow4.shadowRootCreateByCss(WebComponent.class, "div button[aria-label='" + app + "'] + div>ul>li>sn-collapsible-list[class='nested-item']:nth-child(" + j + ")");
                    ((Anchor)app().create().byCss(Anchor.class, moduleLocator)).scrollToVisible();
                    ((Anchor)shadow5.shadowRootCreateByCss(Anchor.class, moduleLocator)).click();
                    unpinButton();
                    allButton().click();
                }
            }
        }

    }

    public void selectFilterValue(String app, String module) {
        DriverService.getWrappedDriver().switchTo().defaultContent();
        DefaultLeftMenu(app, module);
    }

    public void polFrame() {
        WebComponent frame = polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, polarisLayout);
        Frame iFrame = (Frame)frame.createByCss(Frame.class, "gsft_main");
        app().browser().switchToFrame(iFrame);
    }

    public Anchor leftIMenu() {
        return (Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout").shadowRootCreateByCss(WebComponent.class, "sn-polaris-header").shadowRootCreateByCss(WebComponent.class, "sn-polaris-menu.is-main-menu").shadowRootCreateByCss(WebComponent.class, "li[class='sn-polaris-nav-list-item is-collapsible-item can-animate is-filtered'] sn-collapsible-list").shadowRootCreateByCss(Anchor.class, ".filter-match");
    }
}
