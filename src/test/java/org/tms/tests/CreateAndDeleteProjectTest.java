package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.LoginPageService;
import org.tms.services.ProjectsPageService;
import org.tms.services.SingleProjectPageService;

public class CreateAndDeleteProjectTest extends BaseTest{
    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    String projectName;
    @Test
    public void createNewProjectTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        SingleProjectPageService singleProjectPageService = new SingleProjectPageService();
        projectName = projectsPageService.createNewProject();
        Assert.assertTrue(singleProjectPageService.isCreateNewCaseButtonDisplayed(),
                "Failed to create new project!");
    }

    @Test
    public void deleteNewProject() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        int projectIndex = projectsPageService.getProjectIndexByName(projectName);
        projectsPageService.deleteProject(projectIndex);
    }

//    @Test
//    public void createAndDeleteProjectTest() {
//        User user = new User(System.getProperty("email"), System.getProperty("password"));
//        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
//        projectsPageService.createNewProject();
//        driver.get(PROJECTS_PAGE);
//        projectsPageService.deleteProject(2);
//    }
}
