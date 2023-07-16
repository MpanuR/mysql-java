package projects;

import projects.entity.Project;
import projects.exception.DbException;

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

    public void modifyProjectDetails(Project project) {
        if (!projectDao.modifyProjectDetails(project)) {
            throw new DbException("Project with ID="
                    + project.getProjectId() + " does not exist. ");
        }
    }

    public void deleteProject(Integer projectId) {
        if (!projectDao.deleteProject(projectId)) {
            throw new DbException("Project with ID=" + projectId + " does not exist.");
        }
    }

}
