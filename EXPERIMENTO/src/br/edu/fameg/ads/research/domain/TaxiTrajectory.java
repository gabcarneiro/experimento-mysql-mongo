package br.edu.fameg.ads.research.domain;

import java.io.Serializable;
import java.util.Date;


public class TaxiTrajectory implements Serializable{

	private Long id;
	private Long taxiID;
	private Date dateTime;
	private Double longitude;
	private Double latitude;
        
	
	public TaxiTrajectory() {
		super();
	}


	public TaxiTrajectory(Long id, Date date, Double longitude, Double latitude) {
		super();
		this.taxiID = id;
		this.dateTime = date;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	

	public Long getTaxiID() {
		return taxiID;
	}


	public void setTaxiID(Long taxiID) {
		this.taxiID = taxiID;
	}


	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	@Override
	public String toString() {
		return "TaxiData [id=" + taxiID + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taxiID == null) ? 0 : taxiID.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxiTrajectory other = (TaxiTrajectory) obj;
		if (taxiID == null) {
			if (other.taxiID != null)
				return false;
		} else if (!taxiID.equals(other.taxiID))
			return false;
		return true;
	}
	
	
	
}
