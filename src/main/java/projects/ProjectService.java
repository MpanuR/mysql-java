package projects;

import projects.entity.Project;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;

public class ProjectService {
    private ProjectDao projectDao = new ProjectDao();

    public Project addProject(Project project) {
        return projectDao.insertProject(project);
    }

    // returns a list of project objects representing all projects
    public List<Project> fetchAllProjects() {
        return projectDao.fetchAllProjects();
    }

    // returns project from database by its ID
    public Project fetchProjectbyId(Integer projectId) {
        return projectDao.fetchProjectbyId(projectId).orElseThrow(
                () -> new NoSuchElementException(
                        "Project with project ID=" + projectId
                                + " does not exist."));
    }

}
