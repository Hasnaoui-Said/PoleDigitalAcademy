package next.pda.services.serviceImp;

import next.pda.dao.AdminRepository;
import next.pda.dao.GenericDao;
import next.pda.dao.daoImp.AdministrateurDaoImp;
import next.pda.dao.repositoryImp.AdministrateurRepoImp;
import next.pda.entity.Administrateur;
import next.pda.services.AdminService;

import java.util.List;

public class AdminServiceImp implements AdminService {
    private GenericDao<Administrateur> adminDao = new AdministrateurDaoImp();
    private AdminRepository adminRepository = new AdministrateurRepoImp();

    public AdminServiceImp() {
    }

    @Override
    public Administrateur loginByEmailAndPassword(String email, String password) throws Exception {
        try {
            Administrateur administrateur = adminRepository.findByEmailAndPassword(email,password);
            if (administrateur.getPassword().equals(password))
                return administrateur;
            else
                throw new Exception("Password incorrect");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Administrateur getOneByEmail(String email) {
        Administrateur administrateur = adminRepository.findByEmail(email);
        return administrateur;
    }

    @Override
    public Administrateur getOneByPassword(String password) {
        Administrateur administrateur = adminRepository.findByEmail(password);
        return administrateur;
    }

    @Override
    public void add(Administrateur administrateur) {
        adminDao.add(administrateur);
    }

    @Override
    public Administrateur update(Administrateur administrateur) {
        adminDao.update(administrateur);
        return administrateur;
    }

    @Override
    public List<Administrateur> getAll() {
        return adminDao.getAll();
    }

    @Override
    public Administrateur getOneById(long id) {
        Administrateur administrateur = adminDao.getOne(id);
        return administrateur;
    }

    @Override
    public Administrateur getOneByName(String name) {
        return null;
    }
}
