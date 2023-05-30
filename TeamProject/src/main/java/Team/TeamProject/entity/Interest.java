package Team.TeamProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Interest extends BaseEntity {
    // 관심 테이블
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interest_idx;

    @Column(nullable = false)
    private boolean status;  // true = 관심, false = 관심x

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;
}
