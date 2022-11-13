package next.pda.dao;

import next.pda.entity.Administrateur;

public interface AdminRepository {
    Administrateur findByEmailAndPassword(String email, String password) throws Exception;
    Administrateur findByEmail(String email);
    Administrateur findByPassword(String password);
}
