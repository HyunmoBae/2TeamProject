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
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long store_idx;
    
    String bizesNm; //상호명
    String indsLclsNm; //상권업종대분류명
    String indsMclsNm; //상권업종중분류명
    String indsSclsNm; //상권업종소분류명
    String ksicNm; //표준산업분류명
    String ctprvnNm; //시도명
    String signguNm; //시군구명
    String adongNm; //행정동명
    String ldongNm; //법정동명
    String lnoAdr; //지번주소
    String rdnmAdr; //도로명주소
    String newZipcd; //신우편번호
    String flrNo; //층정보
    String lon; //경도
    String lat; //위도
}
