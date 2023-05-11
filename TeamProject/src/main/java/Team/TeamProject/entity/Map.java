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

    String opnSfTeamCode; //개방자치단체코드
    String updateGbn; //데이터 갱신구분
    String updateDt; //데이터 갱신일자
    String opnSvcNm; //개방서비스 명
    String uptaeNm; //업태구분명 
    String bplcNm; //사업장 명 
    String siteWhlAddr; //지번주소
    String rdnPostNo; //도로명 우편번호
    String rdnWhlAddr; //도로명 주소
    String apvPermYmd; //인허가 일자
    String apvCancelYmd; //인허가 취소일자
    String dcbYmd; //폐업일자
    String dtlStateNm; //상세영업상태 
    String x; //x좌표
    String y; //y좌표
    String siteTel; //전화번호
}
