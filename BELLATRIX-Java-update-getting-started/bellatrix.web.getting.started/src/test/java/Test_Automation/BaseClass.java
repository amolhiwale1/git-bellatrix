package Test_Automation;

import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import solutions.bellatrix.web.components.*;
import solutions.bellatrix.web.infrastructure.DriverService;

public class BaseClass extends Polaris {

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

    public void impersonate(String user) throws InterruptedException {
        if (getUrl()) {
            DriverService.getWrappedDriver().switchTo().defaultContent();
            polImpersonate(user);
        } else {
            DriverService.getWrappedDriver().switchTo().defaultContent();
            ((Anchor)app().create().byCss(Anchor.class, ".user-name.hidden-xs.hidden-sm.hidden-md")).click();
            ((Anchor)app().create().byCss(Anchor.class, "#glide_ui_impersonator")).click();
            ((Anchor)app().create().byCss(Anchor.class, "#select2-chosen-2")).click();
            ((TextInput)app().create().byCss(TextInput.class, "#s2id_autogen2_search")).setText(user);
            ((Anchor)app().create().byXPath(Anchor.class, "//div[normalize-space()='" + user + "']")).click();
        }

    }

    public void leftMenuNavigation(String module, String application) {
        if (getUrl()) {
            selectFilterValue(module, application);
        } else {
            DriverService.getWrappedDriver().switchTo().defaultContent();
            ((Anchor)app().create().byXPath(Anchor.class, "//input[@id='filter']")).waitToBe();
            ((TextInput)app().create().byXPath(TextInput.class, "//input[@id='filter']")).setText(module);
            ((Anchor)app().create().byXPath(Anchor.class, "//span[text()='" + application + "']/following::div[text()='" + module + "']")).click();
        }

    }

    public void iFrame() {
        if (getUrl()) {
            polFrame();
        } else {
            Frame frame = (Frame)app().create().byId(Frame.class, "gsft_main");
            app().browser().switchToFrame(frame);
        }

    }

    public void form() throws InterruptedException {
        iFrame();
        setFieldValue("asset", "wanda-PC");
        setFieldValue("Order Summary", "Work Order EAM");
        Thread.sleep(3000L);
        clickFormButton("Save");
        Thread.sleep(3000L);
        clickFormButton("Delete");
    }

    public void setFieldValue(String label, String value) {
        ((TextInput)app().create().byXPath(TextInput.class, "//*[@aria-label='" + label + "' or @data-name='" + label + "']")).setText(value);
    }

    public void closePopup() throws InterruptedException {
        Thread.sleep(2000L);
        ((Anchor)app().create().byXPath(Anchor.class, "//button[@class='close icon-cross']")).click();
    }

    public void clickFormButton(String visibleText) {
        if (visibleText == "New") {
            ((Anchor)app().create().byXPath(Anchor.class, "//button[contains(normalize-space(),'" + visibleText + "')]")).click();
        } else if (visibleText == "Delete") {
            ((Anchor)app().create().byXPath(Anchor.class, "(//button[text()='" + visibleText + "'])[1]")).click();
            ((Anchor)app().create().byId(Anchor.class, "ok_button")).click();
        } else {
            Anchor button = (Anchor)app().create().byXPath(Anchor.class, "//button[contains(normalize-space(),'" + visibleText + "')]");
            button.scrollToVisible();
            button.click();
        }

    }

    public boolean getUrl() {
        try {
            app().browser().getUrl().contains("nav_to.do");
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

//    public void selectRelatedList(String list) {
//        List<Anchor> wb = app().create().allByXPath(Anchor.class, "//span[@class='tab_caption_text']");
//        System.out.println(wb.toString());
//        Iterator var4 = wb.iterator();
//
//        while(var4.hasNext()) {
//            Anchor component = (Anchor)var4.next();
//            if (component.toString().equals(list)) {
//                component.click();
//                break;
//            }
//        }
//
//    }

    public void selectRelatedListVulnerabilities(){
        Anchor output = (Anchor)app().create().byCss(Anchor.class, "span[class*='last_tab_closure'] span[class='tab_caption_text']");
        output.click();
    }


    public void selectRelatedList(String list) {
        if (list.length()==1) {
            Anchor output = (Anchor)app().create().byXPath(Anchor.class, "//span[text()='" + list + "'][contains(@class,'tab_caption_text')]");
            output.click();
        }else {

        }
        String[] words = list.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] var7 = words;
        int var6 = words.length;

        for(int var5 = 0; var5 < var6; ++var5) {
            String s = var7[var5];
            sb.append("[contains(text(),'" + s + "')]");
        }

        Anchor output = (Anchor)app().create().byXPath(Anchor.class, "//span[@class='tab_caption_text']" + sb.toString());
        output.click();
    }

    public void hasReletedList(String relatedlistname) {
        if (relatedlistname.length()==1){
            Anchor output = (Anchor)app().create().byXPath(Anchor.class, "//span[text()='"+relatedlistname+"'][contains(@class,'tab_caption_text')]");
            output.validateIsVisible();
        }else {
            String[] words = relatedlistname.split(" ");
            StringBuilder sb = new StringBuilder();
            String[] var7 = words;
            int var6 = words.length;

            for(int var5 = 0; var5 < var6; ++var5) {
                String s = var7[var5];
                sb.append("[contains(text(),'" + s + "')]");
            }

            Anchor output = (Anchor)app().create().byXPath(Anchor.class, "//span[@class='tab_caption_text']" + sb.toString());
            output.validateIsVisible();
        }

    }

    public void hasRelatedListButton(String relatedList, String buttonTitle) {
        selectRelatedList(relatedList);
        Anchor output = ((Anchor)app().create().byXPath(Anchor.class, "(//a[contains(@title,'" + relatedList + "')]//following::button[contains(text(),'" + buttonTitle + "')])[1]"));
        output.scrollToVisible();
        output.validateIsVisible();

    }

    public void clickRelatedListButton(String relatedlist, String button) {
        ((Anchor)app().create().byXPath(Anchor.class, "//div[contains(@tab_caption,'" + relatedlist + "')]//button[text()='" + button + "']")).click();
    }

    public void addSlushBucketValue(String value) {
        ((TextInput)app().create().byXPath(TextInput.class, "//input[@aria-label='Collection: Search Available List']")).setText(value);
        ((Anchor)app().create().byXPath(Anchor.class, "//option[text()='" + value + "']")).click();
        ((Anchor)app().create().byXPath(Anchor.class, "//a[@id='add_to_collection_button']")).click();
        ((Anchor)app().create().byXPath(Anchor.class, "(//button[text()='Save'])[1]")).click();
    }

    public void addSlushValue() {
        List<Anchor> value = app().create().allByXPath(Anchor.class, "//select[contains(@aria-label,'Collection')]//option");
        Iterator var3 = value.iterator();

        while(var3.hasNext()) {
            Anchor slushValue = (Anchor)var3.next();
            if (!slushValue.getText().isBlank()) {
                addSlushBucketValue(slushValue.getText());
                break;
            }
        }

    }

    public void clickCreateQueueLink(String queueName) {
        ((Anchor)app().create().byXPath(Anchor.class, "//div[contains(text(),'Create " + queueName + " Queue')]")).click();
    }

    public void clickRawTab() {
        ((Anchor)app().create().byXPath(Anchor.class, "//li[@id='raw']")).click();
    }

    public void setRawDataBody(String body) {
        (app().create().byXPath(TextInput.class, "//textarea[@id='post_body_ta']")).setText(body);
    }

    public void searchInList(String visibleText, String searchValue) {
        Select dropDown = app().create().byXPath(Select.class, "//select[@class='form-control default-focus-outline']");
        dropDown.selectByText(visibleText);
        app().create().byXPath(TextInput.class, "//input[@placeholder='Search' and contains(@id,'text')]").setText("*" + searchValue + "\n");

        app().create().byXPath(Anchor.class, "//a[contains(@aria-label,'Preview record')]").click();
        app().create().byXPath(Anchor.class, "//a[text()='Open Record']").click();
    }

    public void openDevice() throws InterruptedException {
                Thread.sleep(5000);
        app().create().byXPath(Anchor.class, "//a[@id='view.x_nuvo_cs_discovery_queue.target']").waitToBe();
                clickFormContextMenuItem("Reload form");

                app().create().byXPath(Anchor.class, "//a[@id='view.x_nuvo_cs_discovery_queue.target']").click();
                app().create().byXPath(Anchor.class, "//a[text()='Open Record']").waitToBe();
                app().create().byXPath(Anchor.class, "//a[text()='Open Record']").click();
    }

    public void clickFormContextMenuItem(String visibleText) {
        app().create().byXPath(Anchor.class, "//button[@data-original-title='Additional actions']").waitToBe();
        app().create().byXPath(Anchor.class, "//button[@data-original-title='Additional actions']").click();
        app().create().byXPath(Anchor.class, "//div[text()='" + visibleText + "']").click();
    }

    public String getDropValue(String label) {
        return app().create().byXPath(TextInput.class, "//select[contains(@aria-labelledby,'" + label + "')]").getAttribute("value").toString();
    }

    public void reloadForComplete() {
        clickFormContextMenuItem("Reload form");
        for (int i = 0; i < 3; i++) {
            if (getDropValue("label.x_nuvo_cs_discovery_queue.state").equals("complete")) {
                break;
            } else {
                clickFormContextMenuItem("Reload form");
            }
        }

    }

    public String getFieldValue(String label) {
        String name = app().create().byXPath(TextInput.class, "//*[contains(@aria-label,'" + label + "') or contains(@data-name,'" + label + "')]").getAttribute("value").toString();
        if (name.isEmpty()) {
            System.out.println(label + " field is empty");
        }

        return name;
    }

    public void gotoRelatedListRowRecord(String relatedList, int recordNumber) {
        selectRelatedList(relatedList);
        app().create().byXPath(Anchor.class, "(//*[contains(text(),'" + relatedList
                + "')]/following::a[contains(@aria-label,'Preview record')]/parent::td)[" + recordNumber + "]").click();
        app().create().byXPath(Anchor.class, "//a[text()='Open Record']").click();
    }
}
