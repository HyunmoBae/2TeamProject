package Team.TeamProject.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity

public class Store extends BaseEntity {
    // 가게 정보 테이블
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long store_idx;

    private String bizesNm; //상호명
    private String indsLclsNm; //상권업종대분류명
    private String indsMclsNm; //상권업종중분류명
    private String indsSclsNm; //상권업종소분류명
    private String ksicNm; //표준산업분류명
    private String ctprvnNm; //시도명
    private String signguNm; //시군구명
    private String adongNm; //행정동명
    private String ldongNm; //법정동명
    private String lnoAdr; //지번주소
    private String rdnmAdr; //도로명주소
    private String newZipcd; //신우편번호
    private String flrNo; //층정보


    @ToString.Exclude
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Interest")
    private Interest interest; //관심
}
