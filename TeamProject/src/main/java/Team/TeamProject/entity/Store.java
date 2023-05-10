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
@Entity
@Builder
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    // 가게 이름
    private String bizesNm;
    // 가게 코드
    private String indsSclsNm;
    // 주소
    private String lnoAdr;
    // 도로명 주소
    private String rdnmAdr;
    // 경도 (x값)
    private Double lon;
    // 위도 (y값)
    private Double lat;

    public Store(String bizesNm, String indsSclsNm, String lnoAdr, String rdnmAdr, Double lon, Double lat) {
        this.bizesNm = bizesNm;
        this.indsSclsNm = indsSclsNm;
        this.lnoAdr = lnoAdr;
        this.rdnmAdr = rdnmAdr;
        this.lon = lon;
        this.lat = lat;
    }
}
