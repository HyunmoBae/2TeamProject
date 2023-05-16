package Team.TeamProject.repository;

import Team.TeamProject.entity.MemberAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAddressRepository extends JpaRepository<MemberAddress, Long>  {
}
