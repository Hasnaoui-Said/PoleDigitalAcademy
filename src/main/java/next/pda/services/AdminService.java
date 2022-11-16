package next.pda.services;

import next.pda.entity.Administrateur;

import java.util.List;

public interface AdminService{
    void add(Administrateur administrateur);
    Administrateur update(Administrateur administrateur);
    List<Administrateur> getAll();
    Administrateur getOneByName(String name);
    Administrateur getOneById(long id);
    Administrateur loginByEmailAndPassword(String email,String password) throws Exception;
    Administrateur getOneByEmail(String email);
    Administrateur getOneByPassword(String password);
}
