package myprojects.salesapp.data;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;

/**
 * Application implementation of {@link Auditable}
 * 
 * @param <E>  Entity type
 * @param <ID> Entity ID type
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class AuditableEntity<E, ID> implements Auditable<E, ID, LocalDateTime> {

	@Id
	@EqualsAndHashCode.Include
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

	@CreatedDate
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@CreatedBy
	@ManyToOne(optional = false)
	@JoinColumn(name = "created_by", updatable = false)
	private E createdBy;

	@LastModifiedDate
	@Column(name = "updated_at", updatable = false)
	private LocalDateTime updatedAt;

	@LastModifiedBy
	@ManyToOne(optional = false)
	@JoinColumn(name = "updated_by", updatable = false)
	private E updatedBy;

	@Override
	@Nullable
	public ID getId() {
		return this.id;
	}

	@Override
	public boolean isNew() {
		return this.id == null;
	}

	@Override
	public Optional<E> getCreatedBy() {
		return Optional.ofNullable(this.createdBy);
	}

	@Override
	public void setCreatedBy(E createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public Optional<LocalDateTime> getCreatedDate() {
		return Optional.ofNullable(this.createdAt);
	}

	@Override
	public void setCreatedDate(LocalDateTime creationDate) {
		this.createdAt = creationDate;
	}

	@Override
	public Optional<E> getLastModifiedBy() {
		return Optional.ofNullable(this.updatedBy);
	}

	@Override
	public void setLastModifiedBy(E lastModifiedBy) {
		this.updatedBy = lastModifiedBy;
	}

	@Override
	public Optional<LocalDateTime> getLastModifiedDate() {
		return Optional.ofNullable(this.updatedAt);
	}

	@Override
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.updatedAt = lastModifiedDate;
	}
}
