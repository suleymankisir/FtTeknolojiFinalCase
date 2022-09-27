package FTTeknoloji.Account.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import FTTeknoloji.Account.entities.concretes.AccountActivitie;

public interface AccountActivitieDao extends JpaRepository<AccountActivitie, Integer>{

}
