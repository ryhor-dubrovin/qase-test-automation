package org.tms.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ProjectsPagePanel extends BasePage {
    @FindBy(xpath = "//a[@class='defect-title']")
    private List<WebElement> projectButtons;
    @FindBy(xpath = "//a[@class='defect-title']/ancestor::td/following-sibling::td[5]/div/a")
    private List<WebElement> projectMenuButtons;
    @FindBy(xpath = "//button[text() = 'Delete']")
    private List<WebElement> projectMenuDeleteButtons;
    private int projectIndex;
    private WebElement projectButton = projectButtons.get(projectIndex);
    private WebElement projectMenuButton = projectMenuButtons.get(projectIndex);
    private WebElement menuDeleteButton = projectMenuDeleteButtons.get(projectIndex);
    @FindBy(xpath = "//span[text() = 'Delete project']")
    private WebElement deleteProjectButton;

    public ProjectsPagePanel(int projectIndex) {
        this.projectIndex = projectIndex;
    }

//    public void setIndex(int projectIndex){
//        this.projectIndex = projectIndex;
//    }
    public SingleProjectPage openProject(){
        waitElementToBeClickable(projectButton).click();
        return new SingleProjectPage();
    }
    public ProjectsPagePanel openProjectMenu() {
        waitElementToBeClickable(projectMenuButton).click();
        return this;
    }
    public ProjectsPagePanel clickMenuDeleteButton() {
        waitElementToBeClickable(menuDeleteButton).click();
        return this;
    }
    public ProjectsPagePanel clickDeleteButton() {
        waitElementToBeClickable(deleteProjectButton).click();
        return this;
    }
}
