package next.pda.services.serviceImp;

import next.pda.dao.GenericDao;
import next.pda.dao.daoImp.ResponsableDaoImp;
import next.pda.entity.Responsable;
import next.pda.services.GenericService;
import next.pda.services.ResponsableService;

import java.util.List;

public class ResponsableServiceImp implements GenericService<Responsable>, ResponsableService {
    private GenericDao<Responsable> responsableDao = new  ResponsableDaoImp();

    public ResponsableServiceImp() {
    }

    @Override
    public void add(Responsable responsable) {
        responsableDao.add(responsable);
    }

    @Override
    public Responsable update(Responsable responsable) {
        responsable = responsableDao.update(responsable);
        return responsable;
    }

    @Override
    public List<Responsable> getAll() {
        return responsableDao.getAll();
    }

    @Override
    public Responsable getOneById(long id) {
        Responsable responsable = responsableDao.getOne(id);
        return responsable;
    }

    @Override
    public Responsable getOneByName(String name) {
        return null;
    }
}
