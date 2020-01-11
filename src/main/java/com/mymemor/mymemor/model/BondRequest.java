package com.mymemor.mymemor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name="bond_requests")
public class BondRequest extends Auditable {

    @Getter
    @Setter
    @NotNull
    private BondRequestStatus bondRequestStatus = BondRequestStatus.PENDING;

    public BondRequestStatus getBondRequestStatus() {
		return bondRequestStatus;
	}

	public void setBondRequestStatus(BondRequestStatus bondRequestStatus) {
		this.bondRequestStatus = bondRequestStatus;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	@Getter
    @Setter
    @ManyToOne
    @NotNull
    private User from;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    private User to;

}