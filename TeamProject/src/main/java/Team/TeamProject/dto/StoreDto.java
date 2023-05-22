package Team.TeamProject.dto;

import Team.TeamProject.entity.Interest;
import Team.TeamProject.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreDto {
    private Long store_idx;
    private String opnSfTeamCode; //개방자치단체코드
    private String updateDt; //데이터 갱신일자
    private String opnSvcNm; //개방서비스명
    private String uptaeNm; //업태구분명
    private String bplcNm; //사업장명
    private String siteWhlAddr; //지번주소
    private String rdnPostNo; //도로명 우편번호
    private String rdnWhlAddr; //도로명주소
    private String apvPermYmd; //인허가 일자
    private String apvCancelYmd; //인허가 취소일자
    private String dtlStateNm; //상세영업상태
    private Double x; //x좌표
    private Double y; //y좌표
    private String siteTel; //전화번호
    private Interest interest; //관심

    // 개방자치단체코드. 데이터갱신일자, 인허가취소일자 제외
    public Store StoreDtoToEntity(StoreDto storedto){
        var storeEntity = Store.builder()
                .store_idx(storedto.getStore_idx())
                .apvPermYmd(storedto.getApvPermYmd())
                .bplcNm(storedto.getBplcNm())
                .dtlStateNm(storedto.getDtlStateNm())
                .opnSvcNm(storedto.getOpnSvcNm())
                .rdnPostNo(storedto.getRdnPostNo())
                .rdnWhlAddr(storedto.getRdnWhlAddr())
                .siteTel(storedto.getSiteTel())
                .siteWhlAddr(storedto.getSiteWhlAddr())
                .uptaeNm(storedto.getUptaeNm())
                .x(storedto.getX())
                .y(storedto.getY())
                .build();

        return storeEntity;
    }

}

