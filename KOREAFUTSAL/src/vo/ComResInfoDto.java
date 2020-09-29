package vo;

import java.sql.Date;

public class ComResInfoDto {
	String branch_name;
	String ground_name;
	int branch_no;
	int ground_no;
	String res_time;
	Date res_date;
	int radiocount;
	int fulldate; //ground_size
	
	
	public int getFulldate() {
		return fulldate;
	}
	public void setFulldate(int fulldate) {
		this.fulldate = fulldate;
	}
	public int getRadiocount() {
		return radiocount;
	}
	public void setRadiocount(int radiocount) {
		this.radiocount = radiocount;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getGround_name() {
		return ground_name;
	}
	public void setGround_name(String ground_name) {
		this.ground_name = ground_name;
	}
	public int getBranch_no() {
		return branch_no;
	}
	public void setBranch_no(int branch_no) {
		this.branch_no = branch_no;
	}
	public int getGround_no() {
		return ground_no;
	}
	public void setGround_no(int ground_no) {
		this.ground_no = ground_no;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	public Date getRes_date() {
		return res_date;
	}
	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}
	
	
}
