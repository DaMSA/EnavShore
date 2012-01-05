package dk.frv.enav.shore.core.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ais_class_a_position database table.
 * 
 */
@Entity
@Table(name = "ais_class_a_position")
public class AisClassAPosition implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer mmsi;
	private Byte navStatus;
	private Double rot = null;
	private Byte specialManIndicator;	
	private AisVesselPosition aisVesselPosition;

	public AisClassAPosition() {
	}

	@Id
	@Column(unique = true, nullable = false)
	public Integer getMmsi() {
		return this.mmsi;
	}

	public void setMmsi(Integer mmsi) {
		this.mmsi = mmsi;
	}

	@Column(name = "nav_status", nullable = false)
	public Byte getNavStatus() {
		return this.navStatus;
	}

	public void setNavStatus(Byte navStatus) {
		this.navStatus = navStatus;
	}

	public Double getRot() {
		return this.rot;
	}

	public void setRot(Double rot) {
		this.rot = rot;
	}

	@Column(name = "special_man_indicator", nullable = false)
	public Byte getSpecialManIndicator() {
		return this.specialManIndicator;
	}

	public void setSpecialManIndicator(Byte specialManIndicator) {
		this.specialManIndicator = specialManIndicator;
	}

	// bi-directional one-to-one association to AisVesselPosition
	@OneToOne
	@JoinColumn(name = "mmsi", nullable = false, insertable = false, updatable = false)
	public AisVesselPosition getAisVesselPosition() {
		return this.aisVesselPosition;
	}

	public void setAisVesselPosition(AisVesselPosition aisVesselPosition) {
		this.aisVesselPosition = aisVesselPosition;
	}

}