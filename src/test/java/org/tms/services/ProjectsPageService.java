package org.tms.services;

import org.tms.pages.ProjectsPage;

public class ProjectsPageService {
    ProjectsPage projectsPage = new ProjectsPage();
    public String getPageNameSectionText() {
        return projectsPage.getPageNameSectionText();
    }
}
