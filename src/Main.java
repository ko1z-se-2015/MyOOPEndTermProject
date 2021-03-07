import controller.Controller;
import data.Interface.IManager;
import data.Manager;
import repositories.repository_consultant.IRepositoryConsultants;
import repositories.repository_consultant.RepositoryConsultans;
import repositories.repository_toy.IRepositoryToy;
import repositories.repository_toy.RepositoryToy;
import repositories.repository_toy.rep_atoys.IRepositoryAdultToys;
import repositories.repository_toy.rep_atoys.RepositoryAdultToys;
import repositories.repository_toy.rep_btoys.IRepositoryBoyToys;
import repositories.repository_toy.rep_btoys.RepositoryBoyToys;
import repositories.repository_toy.rep_gtoys.IRepositoryGirlToys;
import repositories.repository_toy.rep_gtoys.RepositoryGirltoys;

public class Main {

    public static void main(String[] args) {
        IManager iManager = new Manager();
        IRepositoryConsultants iRepositoryConsultants = new RepositoryConsultans(iManager);
        IRepositoryToy iRepositoryToy = new RepositoryToy(iManager);
        IRepositoryBoyToys iRepositoryBoyToys = new RepositoryBoyToys(iManager);
        IRepositoryGirlToys iRepositoryGirlToys = new RepositoryGirltoys(iManager);
        IRepositoryAdultToys iRepositoryAdultToys = new RepositoryAdultToys(iManager);
        Controller controller = new Controller(iRepositoryConsultants,iRepositoryToy,iRepositoryBoyToys,iRepositoryGirlToys,iRepositoryAdultToys);

        new App(controller);

    }

}