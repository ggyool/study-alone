package org.ggyool.exam01.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
// JPA Entity 클래스들이 이 클래스를 상속할 경우 createDate, modifiedDate 필드도 칼럼으로 인식하도록 합니다.
@MappedSuperclass
// BaseTimeEntity 클래스에 Auditing 기능을 포함시킵니다.
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    // Entity 생성되어 저장 될 때 시간이 자동 저장 됩니다.
    @CreatedDate
    private LocalDateTime createDate;

    // 조회한 Entity 값을 변경할 때 시간이 자동 저장 됩니다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
