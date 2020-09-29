package model;

import java.sql.Date;

public class ReservationDto {
	int res_no;
	Date res_date;
	String res_time;
	int res_status;
	int payment_charge;
	String RES_MOMENT;
	//FK//
	String id;
	int ground_no;
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	public Date getRes_date() {
		return res_date;
	}
	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	public int getRes_status() {
		return res_status;
	}
	public void setRes_status(int res_status) {
		this.res_status = res_status;
	}
	public int getPayment_charge() {
		return payment_charge;
	}
	public void setPayment_charge(int payment_charge) {
		this.payment_charge = payment_charge;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGround_no() {
		return ground_no;
	}
	public void setGround_no(int ground_no) {
		this.ground_no = ground_no;
	}
	public String getRES_MOMENT() {
		return RES_MOMENT;
	}
	public void setRES_MOMENT(String rES_MOMENT) {
		RES_MOMENT = rES_MOMENT;
	}
	
	

}
