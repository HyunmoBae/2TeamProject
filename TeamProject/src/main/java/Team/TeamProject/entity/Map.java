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

    String region; //개방자치단체코드
    String updateIs; //데이터 갱신구분
    String update_date; //데이터 갱신일자
    String service_name; //개방서비스 명
    String uptae_name; //업태구분명 
    String store_name; //사업장 명 
    String site_address; //지번주소
    String street_postNum; //도로명 우편번호
    String street_address; //도로명 주소
    String license_sDate; //인허가 일자
    String license_eDate; //인허가 취소일자
    String close_date; //폐업일자
    String store_state; //상세영업상태 
    String x; //x좌표
    String y; //y좌표
    String store_tel; //전화번호
}
