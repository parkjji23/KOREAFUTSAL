package model;



import java.sql.Date;

public class AdminBranchRepDto {

	int branch_rep_no;
	String branch_rep_contents;
	Date branch_rep_date;
	int branch_no;
	String name;
	
	
	public int getBranch_rep_no() {
		return branch_rep_no;
	}
	public void setBranch_rep_no(int branch_rep_no) {
		this.branch_rep_no = branch_rep_no;
	}
	public String getBranch_rep_contents() {
		return branch_rep_contents;
	}
	public void setBranch_rep_contents(String branch_rep_contents) {
		this.branch_rep_contents = branch_rep_contents;
	}
	public Date getBranch_rep_date() {
		return branch_rep_date;
	}
	public void setBranch_rep_date(Date branch_rep_date) {
		this.branch_rep_date = branch_rep_date;
	}
	public int getBranch_no() {
		return branch_no;
	}
	public void setBranch_no(int branch_no) {
		this.branch_no = branch_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
