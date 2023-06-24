package org.tms.pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@AllArgsConstructor
public class ProjectsPagePanel extends BasePage{

    @FindBy(xpath = "//a[@class='defect-title']")
    private List<WebElement> projectButton;
    @FindBy(xpath = "//a[@class='defect-title']/ancestor::td/following-sibling::td[5]/div/a")
    private List<WebElement> projectMenuButton;
    @FindBy(xpath = "//button[text() = 'Delete']")
    private List<WebElement> deleteProjectButton;

//    private WebElement projectButton;
//    private WebElement projectMenuButton;
//    private WebElement deleteProjectButton;
//    private int projectIndex;


//        public int getProjectIndex(String projectName) {
//            int index = 0;
//            for (WebElement button: this.getProjectButton()) {
//                if (button.getText().equals(projectName)) {
//                    return index;
//                }
//                index++;
//            }
//            return -1;
//        }
}
