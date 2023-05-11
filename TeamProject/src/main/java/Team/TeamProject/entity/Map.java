package Team.TeamProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long map_idx;

    String opnSfTeamCode;
    String updateGbn;
    String updateDt;
    String opnSvcNm;
    String uptaeNm;
    String bplcNm;
    String siteWhlAddr;
    String rdnPostNo;
    String rdnWhlAddr;
    String apvPermYmd;
    String apvCancelYmd;
    String dcbYmd;
    String dtlStateNm;
    String x;
    String y;
    String siteTel;
}
