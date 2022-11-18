package next.pda.services.serviceImp;

import next.pda.entity.Administrateur;
import next.pda.enu.Roles;
import next.pda.services.AdminService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AdminServiceImpTest {

    private AdminService adminService = new AdminServiceImp();

    @Test
    @Disabled
    void loginByEmailAndPassword() {
    }

    @Test
    void checkIfGetOneByEmailExist() {
        Administrateur adminNew = new Administrateur(" lastName",
                " firstName", " email", " phone", Roles.ADMIN,  true, " login", " password");


        }

    @Test
    @Disabled
    void getOneByPassword() {
    }

    @Test
    @Disabled
    void add() {
    }

    @Test
    @Disabled
    void update() {
    }

    @Test
    @Disabled
    void getAll() {
    }

    @Test
    @Disabled
    void getOneById() {
    }

    @Test
    @Disabled
    void getOneByName() {
    }
}