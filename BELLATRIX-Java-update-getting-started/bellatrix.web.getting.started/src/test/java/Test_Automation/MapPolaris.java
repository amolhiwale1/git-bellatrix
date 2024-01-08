//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Test_Automation;

import solutions.bellatrix.web.components.Anchor;
import solutions.bellatrix.web.components.Button;
import solutions.bellatrix.web.components.Div;
import solutions.bellatrix.web.components.Frame;
import solutions.bellatrix.web.components.TextInput;
import solutions.bellatrix.web.components.WebComponent;

public class MapPolaris extends BaseClass {
    public MapPolaris() {
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

    public Div polarisHomeTitle() {
        return (Div)app().create().byXPath(Div.class, "//div[@class='title' and text()]");
    }

    public Anchor gearIcon() {
        return (Anchor)app().create().byXPath(Anchor.class, "(//i[@data-title='Personalize List Columns'])[1]");
    }

    public Anchor showColumnSearchRow() {
        String xpathLocator = "//table[@id='x_nuvo_nps_critical_date_table']/descendant::span[text()='Show column search row']/parent::button/parent::div";
        return (Anchor)app().create().byXPath(Anchor.class, xpathLocator);
    }

    public Anchor hideColumnSearchRow() {
        String xpathLocator = "//table[@id='x_nuvo_nps_critical_date_table']/descendant::span[text()='Hide column search row']/parent::button/parent::div";
        return (Anchor)app().create().byXPath(Anchor.class, xpathLocator);
    }

    public Anchor polarisAllElementButton() {
        return polarisHeader().shadowRootCreateByCss(Anchor.class, "div[aria-label='All']");
    }

    public TextInput polarisMenuShadow() {
        return polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout").shadowRootCreateByCss(WebComponent.class, "sn-polaris-header").shadowRootCreateByCss(WebComponent.class, "sn-polaris-menu.is-main-menu").shadowRootCreateByCss(TextInput.class, "#filter");
    }

    public Anchor polarisMenuItem(String label) {
        String cssSelector = String.format("a[aria-label='%s'][class*='highlighted-item']", label);
        return (Anchor)polarisMenuCollapsibleList().shadowRootCreateByCss(Anchor.class, cssSelector);
    }

    public Anchor polarisMenuItem(String mainLabel, String searchMenu) {
        String cssLocator = String.format("[aria-label='%s']~div a[aria-label^='%s']", mainLabel, searchMenu);
        return (Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout").shadowRootCreateByCss(WebComponent.class, "sn-polaris-header").shadowRootCreateByCss(WebComponent.class, "sn-polaris-menu.is-main-menu").shadowRootCreateByCss(WebComponent.class, "sn-collapsible-list:last-child").shadowRootCreateByCss(Anchor.class, cssLocator);
    }

    public Anchor polarisMenuItems(String searchMenu) {
        String cssLocator = String.format("li a[aria-label='%s']", searchMenu);
        return (Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout").shadowRootCreateByCss(WebComponent.class, "sn-polaris-header").shadowRootCreateByCss(WebComponent.class, "sn-polaris-menu").shadowRootCreateByCss(WebComponent.class, "sn-collapsible-list").shadowRootCreateByCss(WebComponent.class, "sn-collapsible-list").shadowRootCreateByCss(Anchor.class, cssLocator);
    }

    public Frame polarisMainPageFrame() {
        return (Frame)polarisMainMacroponent().shadowRootCreateByCss(Frame.class, "#gsft_main");
    }

    public void iFrame() {
        app().browser().switchToFrame(polarisMainPageFrame());
    }

    public Anchor polarisAvatarUser() {
        return (Anchor)polarisAvatar().shadowRootCreateByCss(Anchor.class, "span[aria-label*='User Avatar']");
    }

    public Anchor polarisAvatar() {
        return (Anchor)((Anchor)polarisHeader().shadowRootCreateByCss(Anchor.class, "div > now-avatar")).toExist().toBeClickable();
    }

    public Anchor polarisImpersonateUserAnchor() {
        return (Anchor)polarisHeader().shadowRootCreateByCss(Anchor.class, "button[data-id='impersonateUser']");
    }

    public Anchor polarisUnimpersonateUserAnchor() {
        return (Anchor)polarisHeader().shadowRootCreateByCss(Anchor.class, "button[data-id='unimpersonate']");
    }

    public Anchor polarisImpersonateButton() {
        return (Anchor)polarisImpersonationNowModal().shadowRootCreateByCss(WebComponent.class, ".now-line-height-crop").shadowRootCreateByCss(Anchor.class, ".now-button.-primary.-md");
    }

    public TextInput polarisSearchUserInput() {
        return (TextInput)polarisImpersonationNowPopover().createByCss(TextInput.class, "div > input[placeholder='Search for a user']");
    }

    public Anchor polarisSelectedUser() {
        return (Anchor)polarisSeismicHoist().shadowRootCreateByCss(Anchor.class, "mark.has-highlight");
    }

    public Anchor polarisAvatarContextualMenu() {
        return (Anchor)polarisHeader().shadowRootCreateByCss(Anchor.class, "div > sn-contextual-menu[id=userMenu]]");
    }

    private WebComponent polarisSeismicHoist() {
        return app().create().byCss(WebComponent.class, "now-popover-panel > seismic-hoist");
    }

    private WebComponent polarisNowPopoverPanel() {
        return polarisMainMacroponent().shadowRootCreateByCss(WebComponent.class, "now-popover-panel");
    }

    private WebComponent polarisImpersonationNowPopover() {
        return polarisImpersonationNowTypeHead().shadowRootCreateByCss(WebComponent.class, "now-popover");
    }

    private WebComponent polarisImpersonationNowTypeHead() {
        return polarisImpersonationNowModal().createByCss(WebComponent.class, "div > now-typeahead");
    }

    private WebComponent polarisImpersonationNowModal() {
        return polarisImpersonation().shadowRootCreateByCss(WebComponent.class, "now-modal");
    }

    private WebComponent polarisImpersonation() {
        return polarisLayout().shadowRootCreateByCss(WebComponent.class, "sn-impersonation");
    }

    public WebComponent polarisHeader() {
        return polarisLayout().shadowRootCreateByCss(WebComponent.class, "sn-polaris-header").toShadowRootToBeAttached();
    }

    private WebComponent polarisAvatarHeader() {
        return polarisCanvasAppShellLayout().shadowRootCreateByCss(WebComponent.class, "sn-polaris-header");
    }

    public WebComponent polarisLayout() {
        return polarisMainMacroponent().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout").toShadowRootToBeAttached();
    }

    WebComponent polarisMenu() {
        return polarisHeader().shadowRootCreateByCss(WebComponent.class, "sn-polaris-menu").toShadowRootToBeAttached();
    }

    public WebComponent contextualMenu() {
        return polarisHeader().shadowRootCreateByCss(WebComponent.class, "sn-contextual-menu").toShadowRootToBeAttached();
    }

    WebComponent polarisMenuShadowTest() {
        return app().create().byCss(WebComponent.class, "macroponent-f51912f4c700201072b211d4d8c26010").toShadowRootToBeAttached();
    }

    private WebComponent polarisMenuCollapsibleList() {
        return polarisMenu().shadowRootCreateByCss(WebComponent.class, "sn-collapsible-list").shadowRootCreateByCss(WebComponent.class, "sn-collapsible-list");
    }

    private WebComponent polarisCanvasAppShellLayout() {
        return polarisCanvasAppShellRoot().shadowRootCreateByCss(WebComponent.class, "sn-canvas-appshell-layout");
    }

    private WebComponent polarisCanvasAppShellRoot() {
        return polarisMainMacroponent().shadowRootCreateByCss(WebComponent.class, "sn-canvas-appshell-root");
    }

    WebComponent polarisMainMacroponent() {
        return app().create().byXPath(WebComponent.class, "//*[contains(name(),'macroponent')]").toShadowRootToBeAttached();
    }

    public WebComponent impersonationEndButtonShadowRoot() {
        return polarisImpersonationNowModal().shadowRootCreateByCss(WebComponent.class, "now-button-iconic");
    }

    public Anchor polarisEndImpersonateUserAnchor() {
        return (Anchor)polarisHeader().shadowRootCreateByCss(Anchor.class, "button[data-id='unimpersonate']>div[class='user-menu-label polaris-enabled']");
    }

    public Anchor polarisMenuItemChoise(String label) {
        String cssSelector = String.format("a[aria-label='%s'][class*='highlighted-item'] span > span.label > mark", label);
        return (Anchor)polarisMenuCollapsibleList().shadowRootCreateByCss(Anchor.class, cssSelector);
    }

    public Button nowIcon() {
        return (Button)impersonationEndButtonShadowRoot().shadowRootCreateByCss(Button.class, "now-icon");
    }

    public Anchor polarisMenuItemInLeftNav(String searchMenu) {
        String cssLocator = String.format("li a[aria-label='%s']", searchMenu);
        return (Anchor)polarisMenuShadowTest().shadowRootCreateByCss(WebComponent.class, "sn-polaris-layout").shadowRootCreateByCss(WebComponent.class, "sn-polaris-header").shadowRootCreateByCss(WebComponent.class, "sn-polaris-menu").shadowRootCreateByCss(WebComponent.class, "sn-collapsible-list").shadowRootCreateByCss(Anchor.class, cssLocator);
    }

    public void polarisImpersonateUser(String user) {
        app().browser().switchToDefault();
        polarisAvatar().click();
        app().browser().waitUntilPageLoadsCompletely();
        app().browser().waitForAjax();
        polarisImpersonateUserAnchor().click();
        app().browser().waitUntilPageLoadsCompletely();
        app().browser().waitForAjax();
        polarisSearchUserInput().setText(user);
        polarisSelectedUser().click();
        polarisImpersonateButton().click();
    }

    public void polarisLeftMenuNavigation(String module, String application) {
        app().browser().switchToDefault();
        polarisAllElementButton().click();
        polarisMenuShadow().setText(module);
        polarisMenuItem(module).click();
    }

    public void leftNavigationTable(String table) {
        app().browser().switchToDefault();
        polarisAllElementButton().click();
        polarisMenuShadow().waitToBe();
        polarisMenuShadow().setText(table + "\n");
    }
}
